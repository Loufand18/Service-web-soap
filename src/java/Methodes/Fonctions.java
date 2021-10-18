/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Methodes;

import BDConnection.ConnectjonSessionBean;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.ImageIcon;
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
public class Fonctions {
    // date premier contamination par Pays
	public String first_contamination(String pays) {
	String date_premiere_contamination=null ;
        Connection conn=null;
        PreparedStatement preparestatement=null;
        conn = ConnectjonSessionBean.connecterdb();
		try {
           preparestatement = conn.prepareStatement("SELECT * FROM pays WHERE nom_Pays = ? ");
           preparestatement.setString(1, pays);
           ResultSet rs = preparestatement.executeQuery();
            while ( rs.next() ) {
                 //System.out.println(rs.getString(0));
                String nom= rs.getDate("date_1_contamination").toString();
        
               date_premiere_contamination=nom;  
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
                return date_premiere_contamination;
	}
        
      //  cas de contamination du jour precedent par Pays
	public CommuniquemaladesCovid infos_Contamination(String pays) {
			
			CommuniquemaladesCovid  infos = new CommuniquemaladesCovid();
			
			PreparedStatement preparestatement=null;
			Connection conn=null;
			
			 conn = ConnectjonSessionBean.connecterdb();
			
		
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
					int nbre_deces = resultat.getInt ("nbre_deces");
					int nbre_gueris = resultat.getInt ("nbre_gueris");
					
					infos = new CommuniquemaladesCovid(numCommunique ,jour,cas_confirme,nbre_deces,cas_contact, cas_importe, nbre_gueris );
                                        
					
				}
		        
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return infos;
		}
        
         //  Total contamines depuis le debut de la pandemie par Pays
        
             public String total_Contamines(String pays) {
			
	
			
			PreparedStatement preparestatement=null;
			Connection conn=null;
                        String total=null;
			
			 conn = ConnectjonSessionBean.connecterdb();
			
		
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
			
			return total;
		}
             
      // Total guerris 
             
             public String total_Guerris(String pays) {
			
	
			
			PreparedStatement preparestatement=null;
			Connection conn=null;
                        String total=null;
			
			 conn = ConnectjonSessionBean.connecterdb();
			
		
			try {
				 preparestatement = conn.prepareStatement("SELECT SUM(nbre_gueris) AS Total_Contamines from communiquemaladescovid a JOIN faire_un_communique b ON a.NumeroCommunique=b.NumeroCommunique where b.nom_Pays = ? ");
				
				 preparestatement.setString(1, pays);
				 
				ResultSet resultat = preparestatement.executeQuery();
                                
				while(resultat.next()) {
                                    total=resultat.getString(1);
                                    
                                }
				
					
				
					
                                        
					
		
		        
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return total;
		}
   
             // Courbe evolution de la maladie
             
             public ArrayList<CommuniquemaladesCovid> Donnees_pays(String pays) {
		
	        CommuniquemaladesCovid  infos = new CommuniquemaladesCovid();
		PreparedStatement p2 = null;
		ArrayList<CommuniquemaladesCovid> resutl = new  ArrayList<CommuniquemaladesCovid>();
		
		
		PreparedStatement preparestatement=null;
			Connection conn=null;
                        
			
			 conn = ConnectjonSessionBean.connecterdb();
		
		
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
		
		return resutl;
			}
             
  
        public String[] Diagramme_evolution(String pays) {
		       
		ArrayList<CommuniquemaladesCovid> list =  Donnees_pays(pays);
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
            
           
             return img;
	}
    public void insert(){     
   try { 
            Connection conn=null;
		conn = ConnectjonSessionBean.connecterdb();
            Statement st = conn.createStatement(); 
            st.executeUpdate("INSERT INTO continent " + 
                "VALUES ( 'Simpson')"); 
            conn.close(); 
       } catch (Exception e) { 
            System.err.println("Got an exception! "); 
            System.err.println(e.getMessage()); 
        } 
 }
    
    
}
