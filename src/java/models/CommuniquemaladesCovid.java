/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

/**
 *
 * @author fallou
 */
public class CommuniquemaladesCovid {
    private String Pays;
    private int NumeCommunique;
    private String jour;
    private int nbre_cas_confirme;
     private int nbre_deces;
    private int nbre_cas_contact;
    private int nbre_cas_importe;
    private int nbre_guerris;

    public CommuniquemaladesCovid() {
    }
    
    
    public CommuniquemaladesCovid(int NumeCommunique, String jour, int nbre_cas_confirme, int nbre_deces, int nbre_cas_contact, int nbre_cas_importe, int nbre_guerris) {
        this.NumeCommunique = NumeCommunique;
        this.jour = jour;
        this.nbre_cas_confirme = nbre_cas_confirme;
        this.nbre_deces = nbre_deces;
        this.nbre_cas_contact = nbre_cas_contact;
        this.nbre_cas_importe = nbre_cas_importe;
        this.nbre_guerris = nbre_guerris;
    }

    public CommuniquemaladesCovid(String Pays, int NumeCommunique, String jour, int nbre_cas_confirme, int nbre_deces, int nbre_cas_contact, int nbre_cas_importe, int nbre_guerris) {
        this.Pays = Pays;
        this.NumeCommunique = NumeCommunique;
        this.jour = jour;
        this.nbre_cas_confirme = nbre_cas_confirme;
        this.nbre_deces = nbre_deces;
        this.nbre_cas_contact = nbre_cas_contact;
        this.nbre_cas_importe = nbre_cas_importe;
        this.nbre_guerris = nbre_guerris;
    }

    public String getPays() {
        return Pays;
    }

    public void setPays(String Pays) {
        this.Pays = Pays;
    }

   
    

    public int getNumeCommunique() {
        return NumeCommunique;
    }

    public void setNumeCommunique(int NumeCommunique) {
        this.NumeCommunique = NumeCommunique;
    }

    public String getJour() {
        return jour;
    }

    public void setJour(String jour) {
        this.jour = jour;
    }

    public int getNbre_cas_confirme() {
        return nbre_cas_confirme;
    }

    public void setNbre_cas_confirme(int nbre_cas_confirme) {
        this.nbre_cas_confirme = nbre_cas_confirme;
    }

    public int getNbre_deces() {
        return nbre_deces;
    }

    public void setNbre_deces(int nbre_deces) {
        this.nbre_deces = nbre_deces;
    }

    public int getNbre_cas_contact() {
        return nbre_cas_contact;
    }

    public void setNbre_cas_contact(int nbre_cas_contact) {
        this.nbre_cas_contact = nbre_cas_contact;
    }

    public int getNbre_cas_importe() {
        return nbre_cas_importe;
    }

    public void setNbre_cas_importe(int nbre_cas_importe) {
        this.nbre_cas_importe = nbre_cas_importe;
    }

    public int getNbre_guerris() {
        return nbre_guerris;
    }

    public void setNbre_guerris(int nbre_guerris) {
        this.nbre_guerris = nbre_guerris;
    }
    
   
    
    
}
