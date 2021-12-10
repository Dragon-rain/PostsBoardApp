package repository;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.DatabaseConnection;
import dto.User;
import dto.UserRoles;
import utils.DateUtil;

public class UserRepository {
	
	private UserRepository () {
	}
	
	public static UserRepository getInstance() {
		return new UserRepository();
	}
	
	private String encodePassword(String password){  
        String encryptedpassword = null;  
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");  
            m.update(password.getBytes());  
            byte[] bytes = m.digest();  
            StringBuilder s = new StringBuilder();  
            for(int i=0; i< bytes.length ;i++) {  
                s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));  
            }  
            encryptedpassword = s.toString();  
        }
        catch (NoSuchAlgorithmException e) {  
            e.printStackTrace();  
        }
          
        return encryptedpassword;  
    }  

	
	public User userLogin(String username, String password) {
		User user = new User();
		try(Connection connection = DatabaseConnection.initializeDatabase();
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM user WHERE username='"+username+"' AND password='"+encodePassword(password)+"' AND deleted IS NULL");
			ResultSet rs = ps.executeQuery();) {
			if(!rs.next()) return null;
			user.setId(rs.getInt("id"));
			user.setUsername(rs.getString("username"));
			user.setRole(rs.getString("role"));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return user;
	}
	
	public void userRegistration(User newUser, String password) {
		try(Connection connection = DatabaseConnection.initializeDatabase();
			PreparedStatement ps = connection.prepareStatement("INSERT INTO user (username, password, created, role) VALUES ('"+newUser.getUsername()+"','"+encodePassword(password)+"','"+DateUtil.getCurrentSqlDate()+"', '"+UserRoles.USER.toString()+"')");){
			ps.execute();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateUserProfile(User user) {
		try(Connection connection = DatabaseConnection.initializeDatabase();
			PreparedStatement ps = connection.prepareStatement("UPDATE user SET username = '"+user.getUsername()+"', updated = '"+DateUtil.getCurrentSqlDate()+"' WHERE id ='"+user.getId()+"'");){
			ps.execute();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void changeUserPassword(String newPassword, int userId) {
		try(Connection connection = DatabaseConnection.initializeDatabase();
			PreparedStatement ps = connection.prepareStatement("UPDATE user SET password='"+encodePassword(newPassword)+"', updated='"+DateUtil.getCurrentSqlDate()+"' WHERE id='"+userId+"'");){
			
			ps.execute();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteUser(int userId) {
		try(Connection connection = DatabaseConnection.initializeDatabase();
			PreparedStatement ps = connection.prepareStatement("UPDATE user SET deleted='"+DateUtil.getCurrentSqlDate()+"' WHERE id='"+userId+"'")){
			ps.execute();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
