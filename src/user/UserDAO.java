package user;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDAO {
    String strDriver = "com.mysql.cj.jdbc.Driver"; //mysql 사용
    String strURL = "jdbc:mysql://localhost/AccountBook?serverTimezone=UTC"; //내 pc
    //String strURL = "jdbc:sqlserver://10.40.45.57:1433;DatabaseName=Automobile"; //서버에 올리기(교수 pc(10.40.45.57))
    String strUser = "root";
    String strPwd = "kimjuyeon0912!";
    
    public Connection DB_con;
    public Statement DB_stmt;
    public ResultSet DB_rs;
    
    String strSQL = "";
    
    public void dbOpen() throws IOException {
        try {
            Class.forName(strDriver);
            DB_con = DriverManager.getConnection(strURL, strUser, strPwd);
            DB_stmt = DB_con.createStatement();
        } catch (Exception e) {
            System.out.println("SQL Exception : " + e.getMessage());
        }
    }
    
    public void dbClose() throws IOException {
        try {
            DB_stmt.close();
            DB_con.close();
        } catch (Exception e) {
            System.out.println("SQL Exception : " + e.getMessage());
        }
    }
    
    public int login(String userID, String userPassword) {
        strSQL = "SELECT UserPassword FROM USER WHERE user.UserID = " + "'" + userID + "';";
        try {
            dbOpen();
            DB_rs = DB_stmt.executeQuery(strSQL);
            if (DB_rs.next()) {
                if (DB_rs.getString("UserPassword").equals(userPassword)) {
                    return 1; //로그인 성공
                } else {
                    return 0; //비번 불일치
                }
            }
            DB_rs.close();
            return -1; //아이디없음
        } catch (Exception e) {
            System.out.println("SQL Exception : " + e.getMessage());
        }
        return -2; //DB오류
    }
}
