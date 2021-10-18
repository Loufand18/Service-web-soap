/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BDConnection;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import javax.ejb.Stateless;
import javax.swing.JOptionPane;

/**
 *
 * @author fallou
 */
@Stateless
public class ConnectjonSessionBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
	Connection conn=null;
	
	public static Connection connecterdb(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/bdcovid19","root","");
			
			return conn;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,e);
			return null;
		}
		
	}
/*	public static void connect() {
		Connection con = null;
		try {
			String url = "jdbc:sqlite:C:/sqlite/db/chinook.db";
			con = DriverManager.getConnection(url);
			System.out.println("Connexion SqLite a réussi ");
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
		} finally {
			
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e2) {
				System.out.println(e2.getMessage());
			}
		} 
	}
*/
	public static void main(String[] args) {
		connecterdb();
	}
}
