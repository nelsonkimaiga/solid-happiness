/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nelsonkimaiga;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kimaiga
 */
public class dbConn {

    public Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/test?useSSL=false", "root", "password");
        } catch (SQLException ex) {
            Logger.getLogger(dbConn.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

    public ArrayList<Employee> getRecords(String id) {
        ArrayList<Employee> list = new ArrayList<Employee>();
        Connection con = getConnection();
        Statement st;
        ResultSet rs;
        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT id, name FROM test.employee;");
            Employee emp;
            while (rs.next()) {
                emp = new Employee(
                        rs.getString("id"),
                        rs.getString("name"));
                list.add(emp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(dbConn.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    //find names by first id when selected from combobox
    public ArrayList<Employee> findNameById(String id) {
        ArrayList<Employee> list = new ArrayList<Employee>();
        Connection con = getConnection();
        Statement st;
        ResultSet rs;
        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM test.employee where id='234'");
            Employee emp;
            while (rs.next()) {
                emp = new Employee(
                        rs.getString("id"),
                        rs.getString("name"));
                list.add(emp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(dbConn.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    
    //find names by second id when selected from combobox
    public ArrayList<Employee> findNameBySecondId(String id) {
        ArrayList<Employee> list = new ArrayList<Employee>();
        Connection con = getConnection();
        Statement st;
        ResultSet rs;
        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM test.employee where id='1234'");
            Employee emp;
            while (rs.next()) {
                emp = new Employee(
                        rs.getString("id"),
                        rs.getString("name"));
                list.add(emp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(dbConn.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    
    //Search by partial id prefix eg: when any id selected
    public ArrayList<Employee> findByPartialSelect(String id) {
        ArrayList<Employee> list = new ArrayList<Employee>();
        Connection con = getConnection();
        Statement st;
        ResultSet rs;
        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM test.employee WHERE id like '%234%'");
            Employee emp;
            while (rs.next()) {
                emp = new Employee(
                        rs.getString("id"),
                        rs.getString("name"));
                list.add(emp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(dbConn.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
