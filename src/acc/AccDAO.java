/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author admin
 */
public class AccDAO {
    String strDriver = "com.mysql.cj.jdbc.Driver"; //mysql 사용
    String strURL = "jdbc:mysql://localhost/AccountBook?serverTimezone=UTC"; //내 pc
    //String strURL = "jdbc:sqlserver://10.40.45.57:1433;DatabaseName=Automobile"; //서버에 올리기(교수 pc(10.40.45.57))
    String strUser = "root";
    String strPwd = "kimjuyeon0912!";
    
    public Connection DB_con;
    public Statement DB_stmt;
    public ResultSet DB_rs;
    
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
    
    public String getDBData(String strQuery) {
        String strOutput = "날짜\t구분\t유형\t비용\t타입\t메모\n";
        try {
            DB_rs = DB_stmt.executeQuery(strQuery);
            while (DB_rs.next()) {
                strOutput += DB_rs.getDate("UseDate") + "\t";
                strOutput += DB_rs.getString("Division") + "\t";
                strOutput += DB_rs.getString("Item") + "\t";
                strOutput += DB_rs.getInt("Price") + "\t";
                strOutput += DB_rs.getString("UseType") + "\t";
                strOutput += DB_rs.getString("Memo") + "\n";
            }
        } catch (Exception e) {
            System.out.println("SQL Exception : " + e.getMessage());
        }
        return strOutput;
    }
    
    public String getDBDataLeast(String strQuery) {
        String strOutput = "항목\t금액\t유형\n";
        try {
            DB_rs = DB_stmt.executeQuery(strQuery);
            while (DB_rs.next()) {
                strOutput += DB_rs.getString("Item") + "\t";
                strOutput += DB_rs.getInt("Price") + "\t";
                strOutput += DB_rs.getString("UseType") + "\n";
            }
        } catch (Exception e) {
            System.out.println("SQL Exception : " + e.getMessage());
        }
        return strOutput;
    }
    
    public String lblExpen(String strQuery) {
        String strOutput = "";
        int result;
        try {
            DB_rs = DB_stmt.executeQuery(strQuery);
            while (DB_rs.next()) {
                result = DB_rs.getInt("Price");
                strOutput = Integer.toString(result);
            }
        } catch (Exception e) {
            System.out.println("SQL Exception : " + e.getMessage());
            return "0";
        }
        return strOutput;
    }
    
    public String lblExpenPrice(String strQuery) {
        String strOutput = "";
        int result;
        try {
            DB_rs = DB_stmt.executeQuery(strQuery);
            while (DB_rs.next()) {
                result = DB_rs.getInt("Price");
                strOutput = Integer.toString(result);
            }
        } catch (Exception e) {
            System.out.println("SQL Exception : " + e.getMessage());
            return "0";
        }
        return strOutput;
    }
    
    public String userProperty(String strQuery) {
        String strOutput = "";
        int result;
        try {
            DB_rs = DB_stmt.executeQuery(strQuery);
            while (DB_rs.next()) {
                result = DB_rs.getInt("UserProperty");
                strOutput = Integer.toString(result);
            }
        } catch (Exception e) {
            System.out.println("SQL Exception : " + e.getMessage());
            return "0";
        }
        return strOutput;
    }
}
