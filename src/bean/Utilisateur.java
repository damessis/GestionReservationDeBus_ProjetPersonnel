/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.Date;

/**
 *
 * @author IDA
 */
public class Utilisateur {
   
   	private int idUtilisateur;
        private String nomCompteUtilisateur;
        private String contactUtilisateur;
        private String emailUtilisateur;
        private String userName;
        private String password;
        private String categorieCompte;
        private Date dateInscription;


    public Utilisateur() {
    }

    public Utilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public Utilisateur(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
    
    public Utilisateur(String nomCompteUtilisateur, String contactUtilisateur, String emailUtilisateur, String userName, String password, String categorieCompte, Date dateInscription) {
        this.nomCompteUtilisateur = nomCompteUtilisateur;
        this.contactUtilisateur = contactUtilisateur;
        this.emailUtilisateur = emailUtilisateur;
        this.userName = userName;
        this.password = password;
        this.categorieCompte = categorieCompte;
        this.dateInscription = dateInscription;
    }

    public Utilisateur(int idUtilisateur, String nomCompteUtilisateur, String contactUtilisateur, String emailUtilisateur, String userName, String password, String categorieCompte, Date dateInscription, Date derniereActivite) {
        this.idUtilisateur = idUtilisateur;
        this.nomCompteUtilisateur = nomCompteUtilisateur;
        this.contactUtilisateur = contactUtilisateur;
        this.emailUtilisateur = emailUtilisateur;
        this.userName = userName;
        this.password = password;
        this.categorieCompte = categorieCompte;
        this.dateInscription = dateInscription;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getNomCompteUtilisateur() {
        return nomCompteUtilisateur;
    }

    public void setNomCompteUtilisateur(String nomCompteUtilisateur) {
        this.nomCompteUtilisateur = nomCompteUtilisateur;
    }

    public String getContactUtilisateur() {
        return contactUtilisateur;
    }

    public void setContactUtilisateur(String contactUtilisateur) {
        this.contactUtilisateur = contactUtilisateur;
    }

    public String getEmailUtilisateur() {
        return emailUtilisateur;
    }

    public void setEmailUtilisateur(String emailUtilisateur) {
        this.emailUtilisateur = emailUtilisateur;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCategorieCompte() {
        return categorieCompte;
    }

    public void setCategorieCompte(String categorieCompte) {
        this.categorieCompte = categorieCompte;
    }

    public Date getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(Date dateInscription) {
        this.dateInscription = dateInscription;
    }

            
}
