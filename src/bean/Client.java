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
 */
public class Client implements Serializable{
    private int idClient;
    private String nom	;
    private String prenom;
    private String adresse;
    private String contact;
    private String emailClient;

    public Client() {
    }

    public Client(int idClient) {
        this.idClient = idClient;
    }

    public Client(String nom, String prenom, String adresse, String contact, String emailClient) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.contact = contact;
        this.emailClient = emailClient;
    }
    
    public Client(int idClient, String nom, String prenom, String adresse, String contact, String emailClient) {
        this.idClient=idClient;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.contact = contact;
        this.emailClient = emailClient;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmailClient() {
        return emailClient;
    }

    public void setEmailClient(String emailClient) {
        this.emailClient = emailClient;
    }

    @Override
    public String toString() {
        return "Client{" + "idClient=" + idClient + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", contact=" + contact + ", emailClient=" + emailClient + '}';
    }
    
}
