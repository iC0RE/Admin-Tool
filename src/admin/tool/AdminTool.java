/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.tool;
import java.sql.*;
/**
 *
 * @author Paul
 */
public class AdminTool {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GraphicalUserInterface gui = new GraphicalUserInterface();
	gui.setVisible(true);
        
//        try{
//            // 1. Get a connection
//            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/qtool", "root", "");
//            // 2. Create a statement
//            Statement stm = con.createStatement();
//            // 3. Execute SQL query
//            ResultSet rs = stm.executeQuery("select * from frage");
//            // 4. Process the result set
//            while (rs.next()) {
//                
//            }
//            
//        }
//        catch (Exception exc) {
//            exc.printStackTrace();
//        }
    }
}
