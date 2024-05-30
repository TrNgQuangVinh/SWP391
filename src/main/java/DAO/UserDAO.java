package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.DBUtils;

public class UserDAO {

	private static final String LOGIN = "SELECT fullName, roleID FROM tblUsers WHERE userID=? AND password=?";
    
	    public UserDTO checkLogin(String userID, String password) throws SQLException {
	        Connection conn=null;
	        PreparedStatement ptm=null;
	        ResultSet rs=null;
	        UserDTO user = null;
	        try {
	            conn=DBUtils.getConnection();
	            if(conn!=null){
	                ptm=conn.prepareStatement(LOGIN);
	                ptm.setString(1, userID);
	                ptm.setString(2, password);
	                rs=ptm.executeQuery();
	                if(rs.next()){
	                    String fullName=rs.getString("fullName");
	                    String roleID=rs.getString("roleID");
	                    user=new UserDTO(userID, fullName, roleID, "");
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            if(rs!=null) rs.close();
	            if(ptm!=null) ptm.close();
	            if(conn!=null) conn.close();
	        }
	         return user;
	    }

}
