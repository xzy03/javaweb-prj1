package cn.edu.zjut.dao;
import java.sql.*;
import javax.sql.*;
import javax.naming.*;
import cn.edu.zjut.model.UserBean;
public class UserDAO {
    private static final String GET_ONE_SQL =
            "SELECT * FROM usertable WHERE username=? and userpassword=? and usertype=?";
    public UserDAO( ){ }
    public Connection getConnection(){
        Connection conn = null;
        String driver = "org.postgresql.Driver";
        String dburl = "jdbc:postgresql://192.168.239.132:26000/mydb";
        String username = "dbuser"; //数据库登录用户名
        String password = "dbpassword@123"; //数据库登录密码
        try{
            Class.forName(driver); //加载数据库驱动程序
            conn = DriverManager.getConnection(dburl,username,password);
        }catch( Exception e ){ e.printStackTrace(); }
        return conn;
    }
    public boolean searchUser(UserBean user){
// 按用户名和密码校验用户是否合法
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rst=null;
        try{
            conn = getConnection();
            pstmt = conn.prepareStatement(GET_ONE_SQL);
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getType());
            rst = pstmt.executeQuery();
            if(rst.next()){
                return true;
            }
        }catch(SQLException se){
            se.printStackTrace();
            return false;
        }finally{
            try{
                pstmt.close();
                conn.close();
            }catch(SQLException se){ se.printStackTrace(); }
        }
        return false;
    }
    public boolean addUser(UserBean user){
// 添加用户
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = "INSERT INTO usertable VALUES(?,?,?)";
        try{
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getType());
            pstmt.executeUpdate();
            return true;
        }catch(SQLException se){
            se.printStackTrace();
            return false;
        }finally{
            try{
                pstmt.close();
                conn.close();
            }catch(SQLException se){ se.printStackTrace(); }
        }
    }
}
