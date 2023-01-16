/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.sql.Time;

/**
 *
 * @author IDA
 */
public class Trajet {
    private int idTrajet;
    private String villeDepart;
    private String villeArrivee;
    private Float tarifTrajet;
    private Time durée;

    public Trajet() {
    }

    public Trajet(int idTrajet) {
        this.idTrajet = idTrajet;
    }

    public Trajet(String villeDepart, String villeArrivee, Float tarifTrajet, Time durée) {
        this.villeDepart = villeDepart;
        this.villeArrivee = villeArrivee;
        this.tarifTrajet = tarifTrajet;
        this.durée = durée;
    }

    public Trajet(int idTrajet,String villeDepart, String villeArrivee,Float tarifTrajet,Time durée) {
        this.idTrajet=idTrajet;
        this.villeDepart = villeDepart;
        this.villeArrivee = villeArrivee;
        this.tarifTrajet =tarifTrajet ;
        this.durée =durée;
    }

    public Time getDurée() {
        return durée;
    }

    public void setDurée(Time durée) {
        this.durée = durée;
    }

    public int getIdTrajet() {
        return idTrajet;
    }

    public void setIdTrajet(int idTrajet) {
        this.idTrajet = idTrajet;
    }

    public String getVilleDepart() {
        return villeDepart;
    }

    public void setVilleDepart(String villeDepart) {
        this.villeDepart = villeDepart;
    }

    public String getVilleArrivee() {
        return villeArrivee;
    }

    public void setVilleArrivee(String villeArrivee) {
        this.villeArrivee = villeArrivee;
    }

    public Float getTarifTrajet() {
        return tarifTrajet;
    }

    public void setTarifTrajet(Float tarifTrajet) {
        this.tarifTrajet = tarifTrajet;
    }

    @Override
    public String toString() {
        return "Trajet{" + "idTrajet=" + idTrajet + ", villeDepart=" + villeDepart + ", villeArrivee=" + villeArrivee + ", tarifTrajet=" + tarifTrajet + ", dur\u00e9e=" + durée + '}';
    }

    

   
    
}
