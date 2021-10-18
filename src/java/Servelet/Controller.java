/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servelet;

import com.mysql.jdbc.Connection;
import static com.sun.xml.ws.api.message.Packet.Status.Response;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import models.CommuniquemaladesCovid;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author fallou
 */
@WebServlet(name = "Controller", urlPatterns = {"/Controller"})
public class Controller extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
              RequestDispatcher myDispatch = request.getRequestDispatcher("affiche.jsp");
 
              String pays =(String)request.getParameter("pays");
              String date_premiere_contamination=null ;
              String Scas_contact=null;
              String Scas_importe = null;
              String Snbre_deces =null;
               String total =null;
              String total_guerris=null;
              String continent=null;  
    if (pays!=null){
                  
	Connection conn=null;
	
	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/bdcovid19","root","");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,e);
			
		}
                

        PreparedStatement preparestatement=null;
        
		try {
           preparestatement = conn.prepareStatement("SELECT * FROM pays WHERE nom_Pays = ? ");
           preparestatement.setString(1, pays);
           ResultSet rs = preparestatement.executeQuery();
            while ( rs.next() ) {
                 //System.out.println(rs.getString(0));
                String nom= rs.getDate("date_1_contamination").toString();
                 continent= rs.getString("nom_continent");
               date_premiere_contamination=nom;  
            }
            
            
            
    
        
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
                
          
			try {
				 preparestatement = conn.prepareStatement("SELECT * FROM communiquemaladescovid a  JOIN faire_un_communique b ON a.NumeroCommunique=b.NumeroCommunique where b.nom_Pays= ? ORDER BY a.jour LIMIT 2");
				 preparestatement.setString(1, pays);
				
				 
				ResultSet resultat = preparestatement.executeQuery();
				
				while(resultat.next()) {
					
					String jour = resultat.getString("jour");
					int numCommunique = resultat.getInt("NumeroCommunique");
                                        int cas_confirme = resultat.getInt ("nbre_cas_confirmes");
					int cas_contact = resultat.getInt ("nbre_cas_contact");
					 int cas_importe = resultat.getInt ("nbre_cas_impore");
					int  nbre_deces = resultat.getInt ("nbre_deces");
					int nbre_gueris = resultat.getInt ("nbre_gueris");
					
					Scas_contact=""+cas_contact;
                                        Scas_importe=""+cas_importe;
					Snbre_deces=""+ nbre_deces;
				}
		        
			} catch (SQLException e) {
				e.printStackTrace();
			}  
                        
           
			try {
				 preparestatement = conn.prepareStatement("SELECT SUM(nbre_cas_confirmes) AS Total_Contamines from communiquemaladescovid a JOIN faire_un_communique b ON a.NumeroCommunique=b.NumeroCommunique where b.nom_Pays = ? ");
				
				 preparestatement.setString(1, pays);
				 
				ResultSet resultat = preparestatement.executeQuery();
                                
				while(resultat.next()) {
                                    total=resultat.getString(1);
                                    
                                }                 
				
		        
			} catch (SQLException e) {
				e.printStackTrace();
			}
                        
                        
			try {
				 preparestatement = conn.prepareStatement("SELECT SUM(nbre_gueris) AS Total_Contamines from communiquemaladescovid a JOIN faire_un_communique b ON a.NumeroCommunique=b.NumeroCommunique where b.nom_Pays = ? ");
				
				 preparestatement.setString(1, pays);
				 
				ResultSet resultat = preparestatement.executeQuery();
                                
				while(resultat.next()) {
                                    total_guerris=resultat.getString(1);
                                    
                                }		
		
		        
			} catch (SQLException e) {
				e.printStackTrace();
			}
                        
                    
                 CommuniquemaladesCovid  infos = new CommuniquemaladesCovid();
		PreparedStatement p2 = null;
		ArrayList<CommuniquemaladesCovid> resutl = new  ArrayList<CommuniquemaladesCovid>();
		try {
			 preparestatement = conn.prepareStatement("SELECT * from communiquemaladescovid a JOIN faire_un_communique b ON a.NumeroCommunique=b.NumeroCommunique where b.nom_Pays = ? ");
			 preparestatement.setString(1, pays);
			 ResultSet resultat = preparestatement.executeQuery();
			
			 while (resultat.next ()) {
				 
			                String nom_pays = resultat.getString("nom_Pays");
					String jour = resultat.getString("jour");
					int numCommunique = resultat.getInt("NumeroCommunique");
                                        int cas_confirme = resultat.getInt ("nbre_cas_confirmes");
					int cas_contact = resultat.getInt ("nbre_cas_contact");
					int cas_importe = resultat.getInt ("nbre_cas_impore");
					int nbre_deces = resultat.getInt ("nbre_deces");
					int nbre_gueris = resultat.getInt ("nbre_gueris");
					
					infos = new CommuniquemaladesCovid(numCommunique ,jour,cas_confirme,nbre_deces,cas_contact, cas_importe, nbre_gueris );
			        resutl.add(infos);
			        
			}
			 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
                        
                        
                        
                    
                        
                        ArrayList<CommuniquemaladesCovid> list =  resutl;
                final DefaultCategoryDataset dataset = new DefaultCategoryDataset( ); 
                
                for (int i = 0; i < list.size(); i++) {
        	 dataset.addValue(list.get(i).getNbre_deces(), "deces", list.get(i).getJour());
        	 dataset.addValue(list.get(i).getNbre_guerris(), "gueris", list.get(i).getJour());
        	 dataset.addValue(list.get(i).getNbre_cas_contact()+list.get(i).getNbre_cas_importe(), "Nouveau cas", list.get(i).getJour() );	
		}
                
                
                	   JFreeChart barChart = ChartFactory.createBarChart(
               "Diagramme d'évolution COVID-19 Au "+pays, "nbre cas", "date" ,  dataset, PlotOrientation.VERTICAL,  true, true, false);

	   	JFreeChart courbe = ChartFactory.createLineChart("Courbe d'évolution COVID-19 au "+pays, "nbre cas", "date" ,dataset ,  PlotOrientation.VERTICAL, true, true, false);


	   ChartPanel chartPanel = new ChartPanel( barChart );
	   
	   String file = "C:\\Users\\fallou\\Documents\\NetBeansProjects\\SWProjet\\web\\image";
	      
	      try {
                    ChartUtilities.saveChartAsJPEG(new File(file+"/courbe_"+pays+".jpeg"), courbe, 1000, 500);
                    ChartUtilities.saveChartAsJPEG(new File(file+"/barChar_"+pays+".jpeg"), barChart, 1000, 500);
                } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }

            String[] img = new String[2];  
          
            ImageIcon img_courbe = new ImageIcon(file+"/courbe_"+pays+".jpeg");
            ImageIcon img_barChart = new ImageIcon(file+"/barChar_"+pays+".jpeg");
            img[0] = img_courbe.toString();
            img[1] = img_barChart.toString();
            String  nom_courbe="courbe_"+pays+".jpeg";
            
               
                
              
            /* TODO output your page here. You may use following sample code. */
              request.setAttribute( "courbe",nom_courbe );
              request.setAttribute( "continent", continent);
              request.setAttribute( "total_guerris", total_guerris);
             request.setAttribute( "total", total);
            request.setAttribute( "deces", Snbre_deces);
              request.setAttribute( "cas_importe", Scas_importe);
             request.setAttribute( "cas_contact", Scas_contact);
             request.setAttribute( "date", date_premiere_contamination);
            request.setAttribute( "test", pays);
             myDispatch.forward(request, response);
            response.sendRedirect("affiche.jsp"); 
        
                
                 
     }
     else{
               
              response.sendRedirect("affiche.jsp");   
       }
                
		
	
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
