package kata5P2.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import kata5P2.model.Mail;

public class MailListReaderBD {
     public static List<Mail> read(){
        Connection conn = null;
        List<Mail> list = new ArrayList<>();
        
        String url = "jdbc:sqlite:Kata5.db";
        try {
            conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM EMAIL");
            while(rs.next()){
                list.add(new Mail(rs.getString("mail")));
            }
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
      
        return list;
    }

}
