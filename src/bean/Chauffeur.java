/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;

/**
 *
 * @author IDA
 *//*verifie*/
public class Chauffeur implements Serializable {
   
private int idDriver;
private String nomDriver;
private String Prenom;
private String contact;
private float tauxHoraire;
private String categorie;

    public Chauffeur() {
    }

    public Chauffeur(int idDriver) {
        this.idDriver = idDriver;
    }

    public Chauffeur(String nomDriver, String Prenom, String contact, float tauxHoraire, String categorie) {
        this.nomDriver = nomDriver;
        this.Prenom = Prenom;
        this.contact = contact;
        this.tauxHoraire = tauxHoraire;
        this.categorie = categorie;
    }

    public Chauffeur(int idDriver, String nomDriver, String Prenom, String contact, float tauxHoraire, String categorie) {
        this.idDriver = idDriver;
        this.nomDriver = nomDriver;
        this.Prenom = Prenom;
        this.contact = contact;
        this.tauxHoraire = tauxHoraire;
        this.categorie = categorie;
    }

    public int getIdDriver() {
        return idDriver;
    }

    public void setIdDriver(int idDriver) {
        this.idDriver = idDriver;
    }

    public String getNomDriver() {
        return nomDriver;
    }

    public void setNomDriver(String nomDriver) {
        this.nomDriver = nomDriver;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public float getTauxHoraire() {
        return tauxHoraire;
    }

    public void setTauxHoraire(float tauxHoraire) {
        this.tauxHoraire = tauxHoraire;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    @Override
    public String toString() {
        return "Chauffeur{" + "idDriver=" + idDriver + ", nomDriver=" + nomDriver + ", Prenom=" + Prenom + ", contact=" + contact + ", tauxHoraire=" + tauxHoraire + ", categorie=" + categorie + '}';
    }

}
