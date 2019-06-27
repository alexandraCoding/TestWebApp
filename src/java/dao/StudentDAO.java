/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Entities.Student;
import controllers.MyServlet;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author George.Pasparakis
 */
public class StudentDAO extends Database {

    String server = "localhost:3306";
    String database = "bootcampdb";
    String username = "root";
    String password = "1994";
    

    public StudentDAO() {
        super();
    }

    public List<Student> getStudents() {
        String query = "SELECT * FROM `bootcampdb`.`students`";
        Student st;
        List<Student> students = new ArrayList<>();

        setOptions("?zeroDateTimeBehavior=convertToNull&serverTimezone=Europe/Athens&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false");
        ResultSet rs = Database(server, database, username, password, query);
        if (rs == null) {
            System.out.println("Error to the database");
        }
        try {
            while (rs.next()) {
                st = new Student(rs.getInt("ID"), rs.getString("SURNAME"),
                        rs.getString("NAME"), rs.getFloat("GRADE"),
                        rs.getString("BIRTHDATE"));
                students.add(st);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MyServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        return students;
    }

   public boolean InsertStudent(Student st) {
        String query = "INSERT INTO `bootcampdb`.`students` \n" +
                        "(SURNAME,NAME,GRADE,BIRTHDATE) \n" +
                        "VALUES(\"" + st.getSurname() + "\",\"" + st.getName() + "\"," + st.getGrade() + "," + "\"" + st.getBirthDate() + "\")";
        int i = Database(server, database, username, password, query, (byte)1);
        if(i >= 1) return true; else return false;
    }
   
    public boolean DeleteStudent( int id) {
        String query = "DELETE FROM `bootcampdb`.`students` \n" +
                        "WHERE ID="+id; 
        int i = Database(server, database, username, password, query, (byte)1);
        if(i >= 1) return true; else return false;
       
}
    public boolean UpdateStudent(Student st) {
        String query = "UPDATE `bootcampdb`.`students` \n" +
                        "SET  SURNAME='"+ st.getSurname() + "',NAME='"+st.getName() 
                + "',GRADE='"+st.getGrade() +"',BIRTHDATE='"+st.getBirthDate()
                +"' WHERE ID="+st.getId();
       // System.out.println(query);
        int i = Database(server, database, username, password, query, (byte)1);
        if(i >= 1) return true; else return false;
    }
     public Student getStudentById(int id) {
         String query = "SELECT * FROM `bootcampdb`.`students` WHERE ID="+id;
        Student st=null;
      
        setOptions("?zeroDateTimeBehavior=convertToNull&serverTimezone=Europe/Athens&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false");
        ResultSet rs = Database(server, database, username, password, query);
        if (rs == null) {
            System.out.println("Error to the database");
        }
        try {
            rs.next();
                     st = new Student(rs.getInt("ID"), rs.getString("SURNAME"),
                        rs.getString("NAME"), rs.getFloat("GRADE"),
                        rs.getString("BIRTHDATE"));
               
            
        } catch (SQLException ex) {
            Logger.getLogger(MyServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        return st;
    }
    
}