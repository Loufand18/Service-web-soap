/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WS_Soap;

import Methodes.Fonctions;
import java.util.ArrayList;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import models.CommuniquemaladesCovid;

/**
 *
 * @author fallou
 */
@WebService(serviceName = "WebServices")
public class WebServices {

    /**
     * This is a sample web service operation
     */
   
    @WebMethod( operationName="Date_1_contamination" )
	public String getDate_First_contamination( @WebParam(name ="pays") String pays ) {
	
		String date_first_contamination = new Fonctions().first_contamination(pays);
		
		return date_first_contamination;
	}
     
	@WebMethod(operationName="Contamination_Pays_jour_precedent")
	public String Contamination( @WebParam(name="pays")String pays ) {
		
		CommuniquemaladesCovid infos =new Fonctions().infos_Contamination(pays);
		
		return "Nombres de cas importés : "+ infos.getNbre_cas_importe()+ " Nombres de cas contacts : "+ infos.getNbre_cas_contact();
	}
        @WebMethod(operationName="Deces_Pays_jour_precedent")
	public String Deces( @WebParam(name="pays")String pays ) {
		
		CommuniquemaladesCovid infos =new Fonctions().infos_Contamination(pays);
		
		return "Nombres de déces : "+ infos.getNbre_deces();
	}
        @WebMethod(operationName="Total_Contamines_depuis_debut_pandemie")
	public String TotalContamines( @WebParam(name="pays")String pays ) {
		
		String total =new Fonctions().total_Contamines(pays);
		
		return "Total contamines depuis le debut de la pandemie : "+ total;
	}
         @WebMethod(operationName="Total_Guerris_depuis_debut_pandemie")
	public String TotalGuerris( @WebParam(name="pays")String pays ) {
		
		String total =new Fonctions().total_Guerris(pays);
		
		return "Total Guerris depuis le debut de la pandemie : "+ total;
	}
        
	@WebMethod(operationName="Donnees_Contamination")
	public ArrayList<CommuniquemaladesCovid> Courbe_contamination(@WebParam(name="pays")String pays) {
		
		 ArrayList<CommuniquemaladesCovid> info = new Fonctions(). Donnees_pays(pays);
		
		return info;
	}
       @WebMethod(operationName="Courbe_Contamination")
	public String[] Diagramme_Courbe_contamination(@WebParam(name="pays")String pays) {
		
		 String[] info = new Fonctions(). Diagramme_evolution(pays);
		
		return info;
	}
        
}
    