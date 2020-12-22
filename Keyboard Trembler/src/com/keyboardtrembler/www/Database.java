package com.keyboardtrembler.www;

import java.io.FileInputStream;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class Database {
	
	
	/*String dbUrl = "jdbc:mysql://sql12.freemysqlhosting.net:3306/";
	String dbName = "sql12286296";
	String userName = "sql12286296";
	String password = "hu283XB2aj";*/
	
	
	//----------Connecting to localhost-----------
	String dbUrl = "jdbc:mysql://localhost:3306/";
	String dbName = "keyboard_trembler";
	String userName = "root";
	String password = "";
	
	Connection connection=null;
	
	public class rankDetails{
		int userId;
		String userName;
		double avgSpeed;
		int bestSpeed;
		double avgAccuracy;
		
		public rankDetails(int userId, String userName, double avgSpeed, int bestSpeed, double avgAccuracy) {
			this.userId=userId;
			this.userName = userName;
			this.avgSpeed = avgSpeed;
			this.bestSpeed = bestSpeed;
			this.avgAccuracy = avgAccuracy;
		}
	}
	
	public class raceDetails{
		int speed; 
		double accuracy; 
		String status, date;
		public raceDetails(int speed, double accuracy, String status, String date) {
			this.speed = speed;
			this.accuracy = accuracy;
			this.status = status;
			this.date = date;
		}
	}
	
	public boolean open(){
		try {
            connection = (Connection) DriverManager.getConnection(dbUrl + dbName, userName, password);
            if (connection != null) {
                System.out.println("Connected successfully");
                return true;
            }
        } catch (SQLException e) {
            System.err.println("" + e.getMessage());
        }
		return false;
	}
	
	public boolean close(){
		try {
			connection.close();
			connection=null;
			System.out.println("Disconnected successfully");
			return true;
		} catch (Exception e) {
			System.out.println("Faild to disconnect");
			return false;
		}
	}
	
	///.........Inserting to USER TABLE......
	public boolean insertIntoUser(String name, String userName, String email, String dateOfBirth, String password, String question1Answer, String question2Answer){
		
		String sql="INSERT INTO tbl_user(name, username, email, dateOfBirth, password, question1Answer, question2Answer) VALUES('"+name+"', '"+userName+"', '"+email+"', '"+dateOfBirth+"', '"+password+"', '"+question1Answer+"', '"+question2Answer+"');";
		Statement st;
		if(open()==true)
		{
			try {
				st = (Statement) connection.createStatement();
				st.executeUpdate(sql);
				System.out.println("1 row inserted successfully");
				close();
				return true;
			} catch (Exception e) {
				System.out.println("Insertion Failed");
			}
		}
		return false;
	}
	
	//.............Inserting to RACE HISTORY TABLE...........
	public boolean insertIntoRaceHistory(int userId, int speed, double accuracy, String status, String date){
		
		String sql="INSERT INTO tbl_raceHistory(userId, speed, accuracy, status, date) VALUES("+userId+", "+speed+", "+accuracy+", '"+status+"', '"+date+"');";
		Statement st;
		if(open()==true)
		{
			try {
				st = (Statement) connection.createStatement();
				st.executeUpdate(sql);
				System.out.println("1 row inserted successfully");
				close();
				return true;
			} catch (Exception e) {
				System.out.println("Insertion Failed");
			}
		}
		return false;
	}
	
	//.........inserting to TABLE TOTAL.......................
	public boolean insertIntoTotal(int userId, int typedCharacters, int playingTime){
		
		String sql="INSERT INTO tbl_total(userId, typedCharacters, playingTime) VALUES("+userId+", "+typedCharacters+", "+playingTime+");";
		Statement st;
		if(open()==true)
		{
			try {
				st = (Statement) connection.createStatement();
				st.executeUpdate(sql);
				System.out.println("1 row inserted successfully");
				close();
				return true;
			} catch (Exception e) {
				System.out.println("Insertion Failed");
			}
		}
		return false;
	}
	
	//.........inserting to tbl_profilePicture.......................
		public boolean insertIntoProfilePicture(int userId, FileInputStream file, int len){
			
			String sql="INSERT INTO tbl_profilePicture(userId, picture) VALUES(?, ?);";
			PreparedStatement st;
			if(open()==true)
			{
				try {
					st = (PreparedStatement) connection.prepareStatement(sql);
					st.setInt(1, userId);
					st.setBlob(2, file, len);
					st.executeUpdate();
					System.out.println("1 row inserted successfully");
					close();
					return true;
				} catch (Exception e) {
					System.out.println("Insertion Failed");
				}
			}
			return false;
		}
	
	
	//........inserting to textDetails Table............
	public boolean insertIntotextDetails(int userId, String details){
		
		String sql="INSERT INTO tbl_textDetails(userId, details) VALUES("+userId+", '"+details+"');";
		Statement st;
		if(open()==true)
		{
			try {
				st = (Statement) connection.createStatement();
				st.executeUpdate(sql);
				System.out.println("1 row inserted successfully");
				close();
				return true;
			} catch (Exception e) {
				System.out.println("Insertion Failed");
			}
		}
		return false;
	}
	
	//.........inserting to Table currentLogin.............
	public boolean insertIntoCurrentLogin(int userId){
		
		String sql="INSERT INTO tbl_currentLogin VALUES(1, "+userId+");";
		Statement st;
		if(open()==true)
		{
			try {
				st = (Statement) connection.createStatement();
				st.executeUpdate(sql);
				System.out.println("1 row inserted successfully");
				close();
				return true;
			} catch (Exception e) {
				System.out.println("Insertion Failed");
			}
		}
		return false;
	}
	
	//........inserting to Table ProfilePicture
	
	//.....Updating Table Total..............
	
	public boolean updatingTotal(int userId, int typedCharters, int playingTime){
		
		typedCharters+=getTypedCharacters(userId);
		playingTime+=getPlayingTime(userId);
		
		String sql="UPDATE tbl_total SET typedCharacters="+typedCharters+", playingTime="+playingTime+" WHERE userId="+userId+";";
		Statement st;
		if(open()==true)
		{
			try {
				st = (Statement) connection.createStatement();
				st.executeUpdate(sql);
				System.out.println("Updated successfully");
				close();
				return true;
			} catch (Exception e) {
				System.out.println("Update Failed");
			}
		}
		return false;
	}
	
	//..........Update password...............
	public boolean updatePassword(int userId, String password){
		
		password=hashStringValue(password);
		String sql="Update tbl_user SET password='"+password+"' WHERE userId="+userId+";";
		Statement st;
		if(open()==true)
		{
			try {
				st = (Statement) connection.createStatement();
				st.executeUpdate(sql);
				System.out.println("Password changed successfully");
				close();
				return true;
			} catch (Exception e) {
				System.out.println("Failed to change password");
			}
		}
		return false;
	}
	
	//..............UPDATE USER..............
	
	public boolean updateUser(int userId, String name, String email, String dateOfBirth){
		
		String sql="Update tbl_user SET email='"+email+"', name='"+name+"', dateOfBirth='"+dateOfBirth+"' WHERE userId="+userId+";";
		Statement st;
		if(open()==true)
		{
			try {
				st = (Statement) connection.createStatement();
				st.executeUpdate(sql);
				System.out.println("Updated successfully");
				close();
				return true;
			} catch (Exception e) {
				System.out.println("Failed to update");
			}
		}
		return false;
	}
	
	//......get typed characters...........
	public int getTypedCharacters(int userId)
	{
		String sql = "SELECT typedCharacters FROM tbl_total WHERE userId="+userId+";";
		Statement st;
		int ch =0;
		ResultSet rs;
		if(open()==true)
		{
			try {
				st = (Statement) connection.createStatement();
				rs = st.executeQuery(sql);
				System.out.println("Runned successfully");
				
				while(rs.next())
				{
					ch= rs.getInt("typedCharacters");
				}
				
			} catch (Exception e) {
				System.out.println("Failed to run");
			}
			close();
		}
		return ch;
	}
	
	//...............get playing time..............
	public int getPlayingTime(int userId)
	{
		String sql = "SELECT playingTime FROM tbl_total WHERE userId="+userId+";";
		Statement st;
		int tm =0;
		ResultSet rs;
		if(open()==true)
		{
			try {
				st = (Statement) connection.createStatement();
				rs = st.executeQuery(sql);
				System.out.println("Runned successfully");
				
				while(rs.next())
				{
					tm= rs.getInt("playingTime");
				}
				
			} catch (Exception e) {
				System.out.println("Failed to run");
			}
			close();
		}
		return tm;
	}
	
	
	//........GET AVERAGE SPEED............
	public int getAvgSpeed(int userId)
	{
		String sql = "SELECT AVG(speed) as AvgSpeed FROM tbl_raceHistory WHERE userId="+userId+";";
		Statement st;
		int speed =0;
		ResultSet rs;
		if(open()==true)
		{
			try {
				st = (Statement) connection.createStatement();
				rs = st.executeQuery(sql);
				System.out.println("Runned successfully");
				
				while(rs.next())
				{
					speed= (int) rs.getDouble("AvgSpeed");
				}
				
			} catch (Exception e) {
				System.out.println("Failed to run");
			}
			close();
		}
		return speed;
	}
	
	
	//........GET Best SPEED............
	public int getBestSpeed(int userId)
	{
		String sql = "SELECT MAX(speed) as maxSpeed FROM tbl_raceHistory WHERE userId="+userId+";";
		Statement st;
		int speed =0;
			ResultSet rs;
		if(open()==true)
		{
			try {
				st = (Statement) connection.createStatement();
				rs = st.executeQuery(sql);
				System.out.println("Runned successfully");
				
				while(rs.next())
				{
					speed= (int) rs.getDouble("maxSpeed");
				}
				
			} catch (Exception e) {
				System.out.println("Failed to run");
			}
			close();
		}
		return speed;
	}
	
	//........GET PLAYED TOTAL RACES............
	public int getTotalPlayedRaces(int userId)
	{
		String sql = "SELECT COUNT(raceId) as totalRaces FROM tbl_raceHistory WHERE userId="+userId+";";
		Statement st;
		int races =0;
			ResultSet rs;
		if(open()==true)
		{
			try {
				st = (Statement) connection.createStatement();
				rs = st.executeQuery(sql);
				System.out.println("Runned successfully");
				
				while(rs.next())
				{
					races= (int) rs.getDouble("totalRaces");
				}
				
			} catch (Exception e) {
				System.out.println("Failed to run");
			}
			close();
		}
		return races;
	}
	
	//...........Get Total Won races...........
	public int getTotalWonRaces(int userId)
	{
		String sql = "SELECT COUNT(raceId) as totalRaces FROM tbl_raceHistory WHERE userId="+userId+" && status='WON';";
		Statement st;
		int races =0;
			ResultSet rs;
		if(open()==true)
		{
			try {
				st = (Statement) connection.createStatement();
				rs = st.executeQuery(sql);
				System.out.println("Runned............................. successfully");
				
				while(rs.next())
				{
					races= (int) rs.getDouble("totalRaces");
				}
				
			} catch (Exception e) {
				System.out.println("Failed /////////////////////////////////////to run");
			}
			close();
		}
		return races;
	}
	//..................userName availability checking..................
	public boolean isAvailable(String username)
	{
		String sql=" SELECT userName FROM tbl_user WHERE userName='"+username+"';";
		Statement st;
		ResultSet rs;
		ArrayList<String> list = new ArrayList<String>();
		if(open()==true)
		{
			try {
				st = (Statement) connection.createStatement();
				rs = st.executeQuery(sql);
				System.out.println("Runned successfully");
				
				while(rs.next())
				{
					String u = rs.getString("userName");
					list.add(u);
				}
				
			} catch (Exception e) {
				System.out.println("Failed to run");
			}
			close();
		}
		if(list.size()==0)
			return true;
		else
			return false;
	}
	
	//...........Get USER ID..............
	public int getUserId(String username)
	{
		String sql=" SELECT userId FROM tbl_user WHERE userName='"+username+"';";
		Statement st;
		ResultSet rs;
		int userId=0;
		if(open()==true)
		{
			try {
				st = (Statement) connection.createStatement();
				rs = st.executeQuery(sql);
				System.out.println("Runned successfully");
				
				while(rs.next())
				{
					userId= rs.getInt("userId");
				}
				
			} catch (Exception e) {
				System.out.println("Failed to run");
			}
			close();
		}
		return userId;
	}
	
	public int getUserId(String username, String password)
	{
		password=hashStringValue(password);
		String sql="SELECT userId FROM tbl_user WHERE userName='"+username+"' AND password='"+password+"';";
		Statement st;
		ResultSet rs;
		int userId=0;
		if(open()==true)
		{
			try {
				st = (Statement) connection.createStatement();
				rs = st.executeQuery(sql);
				System.out.println("Runned successfully");
				
				while(rs.next())
				{
					userId= rs.getInt("userId");
				}
				
			} catch (Exception e) {
				System.out.println("Failed to run");
			}
			close();
		}
		return userId;
	}
	
	//....has problem with access denied......
	public int getUserId(String email, String username, String dateOfBirth, String question1Answer, String question2Answer)
	{
		question1Answer=hashStringValue(question1Answer);
		question2Answer=hashStringValue(question2Answer);
		
//		String sql="SELECT userId FROM tbl_user WHERE email='"+email+"' AND userName='"+username+"' AND dateOfBirth='"+dateOfBirth+"' AND question1Answer='"+question1Answer+"' AND question2Answer='"+question2Answer+"';";
		String sql="SELECT userId FROM tbl_user WHERE email='"+email+"' AND userName='"+username+"' AND dateOfBirth='"+dateOfBirth+"' AND question1Answer='"+question1Answer+"' AND question2Answer='"+question2Answer+"';";
		Statement st;
		ResultSet rs;
		int userId=0;
		if(open()==true)
		{
			try {
				st = (Statement) connection.createStatement();
				rs = st.executeQuery(sql);
				System.out.println("Runned successfully");
				
				while(rs.next())
				{
					userId= rs.getInt("userId");
				}
				
			} catch (Exception e) {
				System.out.println("Failed to run");
			}
			close();
		}
		return userId;
	}
	
	
	public String getUserName(int userId)
	{
		String sql="SELECT userName FROM tbl_user WHERE userId="+userId+";";
		Statement st;
		ResultSet rs;
		String userName="";
		if(open()==true)
		{
			try {
				st = (Statement) connection.createStatement();
				rs = st.executeQuery(sql);
				System.out.println("Runned successfully");
				
				while(rs.next())
				{
					userName= rs.getString("userName");
				}
				
			} catch (Exception e) {
				System.out.println("Failed to run");
			}
			close();
		}
		return userName;
	}
	
	
	public String getName(int userId)
	{
		String sql="SELECT name FROM tbl_user WHERE userId="+userId+";";
		Statement st;
		ResultSet rs;
		String name="";
		if(open()==true)
		{
			try {
				st = (Statement) connection.createStatement();
				rs = st.executeQuery(sql);
				System.out.println("Runned successfully");
				
				while(rs.next())
				{
					name= rs.getString("name");
				}
				
			} catch (Exception e) {
				System.out.println("Failed to run");
			}
			close();
		}
		return name;
	}
	
	//.............GET Date of birth............
	public String getDateOfBirth(int userId)
	{
		String sql="SELECT dateOfBirth FROM tbl_user WHERE userId="+userId+";";
		Statement st;
		ResultSet rs;
		String dob="";
		if(open()==true)
		{
			try {
				st = (Statement) connection.createStatement();
				rs = st.executeQuery(sql);
				System.out.println("Runned successfully");
				
				while(rs.next())
				{
					dob= rs.getString("dateOfBirth");
				}
				
			} catch (Exception e) {
				System.out.println("Failed to run");
			}
			close();
		}
		return dob;
	}
	
	//..................GET EMAIL........
	public String getEmail(int userId)
	{
		String sql="SELECT email FROM tbl_user WHERE userId="+userId+";";
		Statement st;
		ResultSet rs;
		String email="";
		if(open()==true)
		{
			try {
				st = (Statement) connection.createStatement();
				rs = st.executeQuery(sql);
				System.out.println("Runned successfully");
				
				while(rs.next())
				{
					email= rs.getString("email");
				}
				
			} catch (Exception e) {
				System.out.println("Failed to run");
			}
			close();
		}
		return email;
	}
	
	//.............get profile picture................
	public ImageIcon getPicture(int userId)
	{
		String sql="SELECT picture FROM tbl_profilePicture WHERE userId="+userId;
		Statement st;
		ResultSet rs;
		ImageIcon img=null;
		
		if(open()==true)
		{
			try {
				st = (Statement) connection.createStatement();
				rs = st.executeQuery(sql);
				System.out.println("Runned successfully");
				
				while(rs.next())
				{
					byte[] image = rs.getBytes("picture");
					img = new ImageIcon(image);
				}
				
			} catch (Exception e) {
				System.out.println("Failed to run");
			}
			close();
		}
		return img;
	}
	
	//......is password correct..........
	
	public boolean isPasswordCorrect(int userId, String password){
		
		password = hashStringValue(password);
		System.out.println(password);
		String sql="SELECT password FROM tbl_user WHERE userId="+userId+" AND password='"+password+"';";
		Statement st;
		ResultSet rs;
		String pass="";
		if(open()==true)
		{
			try {
				st = (Statement) connection.createStatement();
				rs = st.executeQuery(sql);
				System.out.println("Runned successfully");
				
				while(rs.next())
				{
					pass= rs.getString("password");
				}
				
			} catch (Exception e) {
				System.out.println("Failed to run");
			}
			close();
		}
		System.out.println(pass);
		if(pass!="")
			return true;
		else
			return false;
	}
	
	//.............DELETE USER.................
	public boolean deleteUser(int userId){
			
		String sql="DELETE FROM tbl_user WHERE userId="+userId+";";
		Statement st;
		if(open()==true)
		{
			try {
				st = (Statement) connection.createStatement();
				st.executeUpdate(sql);
				System.out.println("Deleted successfully");
				close();
				return true;
			} catch (Exception e) {
				System.out.println("Failed to delete");
			}
		}
		return false;
	}	
	
	public int checkCurrentLogin(){
		String sql="SELECT userId FROM tbl_currentLogin LIMIT 1";
		Statement st;
		int userId=0;
		ResultSet rs;
		if(open()==true)
		{
			try {
				st = (Statement) connection.createStatement();
				rs = st.executeQuery(sql);
				while(rs.next()){
					userId = rs.getInt("userId");
				}
				System.out.println("runned successfully");
			} catch (Exception e) {
				System.out.println("Failed to run");
			}
			close();
		}
		return userId;
	}
	
	//Delete from current login
	
	public boolean deleteCurrentLogin(){
		String sql="DELETE FROM tbl_currentLogin;";
		Statement st;
		if(open()==true)
		{
			try {
				st = (Statement) connection.createStatement();
				st.executeUpdate(sql);
				System.out.println("Deleted successfully");
				close();
				return true;
			} catch (Exception e) {
				System.out.println("Failed to delete");
			}
		}
		return false;
	}
	
	//...........delete profile pic........
	public boolean deleteProfilePic(int userId){
		String sql="DELETE FROM tbl_profilePicture  WHERE userId="+userId+";";
		Statement st;
		if(open()==true)
		{
			try {
				st = (Statement) connection.createStatement();
				st.executeUpdate(sql);
				System.out.println("Deleted successfully");
				close();
				return true;
			} catch (Exception e) {
				System.out.println("Failed to delete");
			}
		}
		return false;
	}
	
	//............GET RACE HISTORY.............
	public ArrayList<raceDetails> getRaceDetails(int userId)
	{
		String sql ="SELECT speed, accuracy, status, date FROM tbl_raceHistory WHERE userId="+userId+" ORDER BY raceId DESC;";
		Statement st;
		ArrayList<raceDetails> list = new ArrayList<raceDetails>();
		ResultSet rs;
		if(open()==true)
		{
			try {
				st = (Statement) connection.createStatement();
				rs = st.executeQuery(sql);
				System.out.println("Runned successfully");
				
				while(rs.next())
				{
					raceDetails details = new raceDetails(rs.getInt("speed"), rs.getDouble("accuracy"), rs.getString("status"), rs.getString("date"));
					list.add(details);
//					System.out.println(details.speed);
//					System.out.println(details.accuracy);
//					System.out.println(details.status);
//					System.out.println(details.date);
				}
				
			} catch (Exception e) {
				System.out.println("Failed to run");
			}
			close();
		}
		return list;
	}
	
	//..........Get rank details..............
	public ArrayList<rankDetails> getRankDetails()
	{
		String sql ="SELECT tbl_user.userId, userName, AVG(speed) AS avgSpeed, MAX(speed)AS bestSpeed, AVG(accuracy) AS avgAccuracy FROM tbl_user, tbl_raceHistory WHERE tbl_user.userId=tbl_raceHistory.userId GROUP BY tbl_raceHistory.userId ORDER BY AVG(speed) DESC";
		Statement st;
		ArrayList<rankDetails> list = new ArrayList<rankDetails>();
		ResultSet rs;
		if(open()==true)
		{
			try {
				st = (Statement) connection.createStatement();
				rs = st.executeQuery(sql);
				System.out.println("Runned successfully");
				
				while(rs.next())
				{
					rankDetails details = new rankDetails(rs.getInt("userId"), rs.getString("username"), rs.getDouble("avgSpeed"), rs.getInt("bestSpeed"), rs.getDouble("avgAccuracy"));
					list.add(details);
				}
				
			} catch (Exception e) {
				System.out.println("Failed to run");
			}
			close();
		}
		return list;
	}
	
	//.....Hashing String.........
	public String hashStringValue(String str){
		String temp; long hash=0, len=str.length();
		for(int i=0; i<len; i++)
		{
			temp=null;
			temp+=str.charAt(i);
			hash+=temp.hashCode()%10000007;
		}
		return String.valueOf(hash);
	}
	
//	public static void main(String[] args) {
//		Database obj = new Database();
		
//		obj.open();
//		obj.close();
		
//		obj.insertIntoUser("Samad", "ssmd", "samad@hotmail.com", "1996-07-11", "785663565", "Canada", "Basket Ball");
//		obj.insertIntoRaceHistory(32, 49, 92.3, "WON", "2017-04-07");
//		obj.insertIntoTotal(25, 792, 78);
//		obj.insertIntotextDetails(8, "\"Hey Salman, Como estas hoy!\"");
//		obj.insertIntoCurrentLogin(8);
		
//		obj.updatingTotal(18, 1250, 130);
		
//		obj.deleteUser(9);
//		obj.deleteCurrentLogin();
		
//		System.out.println(obj.isAvailable("abdulhalimchy"));
//		System.out.println(obj.getUserId("abdulhalimchy"));
//		System.out.println(obj.getUserId("salmanxyz", "123456"));
//		System.out.println(obj.getUserName(15));
//		System.out.println(obj.getName(18));
//		System.out.println(obj.getTypedCharacters(18));
//		System.out.println(obj.getPlayingTime(18));
//		System.out.println(obj.updatingTotal(18, 23, 23));
//		System.out.println(obj.updatingTotal(18, 0, 0));
//		System.out.println(obj.getAvgSpeed(18));
//		System.out.println(obj.getBestSpeed(18));
//		System.out.println(obj.getTotalPlayedRaces(18));
//		System.out.println(obj.getTotalWonRaces(18));
//		System.out.println(obj.checkCurrentLogin());


//		System.out.println(obj.getUserId("che@c.c", "check", "1234-12-12", "123", "123"));
//		System.out.println(obj.getUserId("salmanxyz@gmail.com", "salmanxyz", "1995-10-23", "Bangladesh", "Football"));
		
//		System.out.println(obj.updatePassword(18, "123456"));
//		System.out.println(obj.insertIntoProfilePicture(18, null, 0));
//		System.out.println(obj.deleteProfilePic(18));
//		System.out.println(obj.getUserName(18));
//		System.out.println(obj.updateUser(18, "salman", "sal@outlook.com", "1995-10-23"));
	
//		System.out.println(obj.isPasswordCorrect(18, "123456"));
//	}
}
