package rest;

import java.sql.*;
import javax.swing.*;

public class GuiConnection {

    public static Connection dbconnect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant","root","");
            return con;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
            return null;
        }
    }
}
