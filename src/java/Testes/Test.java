package Testes;


import Methodes.Fonctions;
import models.CommuniquemaladesCovid;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fallou
 */
public class Test {
   public static void main(String[] args) {
		
	Fonctions meth = new Fonctions();
		
	
		 System.out.println("Pays senegal,date premiere contamination : "+meth.first_contamination("Senegal"));	
		//meth.insert();
                 CommuniquemaladesCovid com=meth.infos_Contamination("Senegal");  
                
               System.out.println( "Pays senegal,Contaminations: Cas Contacts : "+ com.getNbre_cas_contact() +" Cas Importes "+com.getNbre_cas_importe());
              
           
            System.out.println( "Pays senegal, Nombres deces : "+ com.getNbre_deces());
             System.out.println( "Pays senegal, Total contamines depuis le debut de la pandemie : " + meth.total_Contamines("Senegal"));
             System.out.println( "Pays senegal, Total guerris depuis le debut de la pandemie: " + meth.total_Guerris("Senegal"));
             
                   System.out.println( "Pays senegal, Total guerris depuis le debut de la pandemie: " + meth.Diagramme_evolution("Senegal"));
}              
}