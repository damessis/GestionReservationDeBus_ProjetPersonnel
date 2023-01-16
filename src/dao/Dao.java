/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bd.Connexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import bean.*;
import java.sql.Date;
import java.sql.Statement;
import java.sql.Time;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author IDA
 */
public class Dao {
     private static Statement statement;
     private static PreparedStatement prepstatement;
/*fonction du bus////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////*/
    /*creation d'un bus*/
    public static void createBus(Bus b) throws SQLException{
     
        String query="insert into bus(immatriculation,capacite,status) values('"+b.getImmatriculation()+"','"+b.getCapacite()+"','"+b.getStatus()+"')";
        try{
            
            statement=Connexion.getConnexion().createStatement();
            statement.executeUpdate(query);
            
         }catch(SQLException ex){           
                   Logger.getLogger(Dao.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    /*modifier bus*/
    public static void updateBus(Bus b) throws SQLException{
     
        String query="UPDATE bus SET immatriculation =?,capacite =?,status=? where idBus=?";
        try{
            prepstatement=bd.Connexion.getConnexion().prepareStatement(query);
            prepstatement.setString(1, b.getImmatriculation());
            prepstatement.setInt(2, b.getCapacite());
            prepstatement.setString(3, b.getStatus());
            prepstatement.setInt(4, b.getIdBus());
            prepstatement.executeUpdate();
            
         }catch(SQLException ex){           
                   Logger.getLogger(Dao.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    /*trouver un bus par son Id*/
     public static Bus findBusById (int idBus) throws SQLException, ClassNotFoundException {
       Bus b=null;
        String query="select*from bus where idBus="+idBus;
        try{
             prepstatement=bd.Connexion.getConnexion().prepareStatement(query);
             ResultSet rs=prepstatement.executeQuery();
             while(rs.next()){
              b=new Bus();
              b.setIdBus(rs.getInt("idBus"));
              b.setImmatriculation(rs.getString("immatriculation"));
              b.setCapacite(rs.getInt("capacite"));
              b.setStatus(rs.getString("status"));
              
        }
        }catch(SQLException ex){           
                   Logger.getLogger(Dao.class.getName()).log(Level.SEVERE,null,ex);          
        }    
       return b; 
    }
     /*trouver un bus par son immatriculation*/
     public static Bus findBusByImmatriculation (String immatriculation) throws SQLException, ClassNotFoundException {
       Bus b=null;
        String query="select*from bus where immatriculation="+immatriculation;
        try{
             prepstatement=bd.Connexion.getConnexion().prepareStatement(query);
             ResultSet rs=prepstatement.executeQuery();
             while(rs.next()){
              b=new Bus();
              b.setIdBus(rs.getInt("idBus"));
              b.setImmatriculation(rs.getString("immatriculation"));
              b.setCapacite(rs.getInt("capacite"));
              b.setStatus(rs.getString("status"));
              
        }
        }catch(SQLException ex){           
                   Logger.getLogger(Dao.class.getName()).log(Level.SEVERE,null,ex);          
        }    
       return b; 
    }
     
    /*trouver tous les bus*/ 
    public static ObservableList<Bus> findAllBus () throws SQLException, ClassNotFoundException {
       ObservableList<Bus> busList = FXCollections.observableArrayList();
        String query="select*from bus";
        try{
             prepstatement=bd.Connexion.getConnexion().prepareStatement(query);
             ResultSet rs=prepstatement.executeQuery();
             while(rs.next()){
              /*Bus b=new Bus();*/
              /*b.setIdBus(rs.getInt("idBus"));
              b.setImmatriculation(rs.getString("immatriculation"));
              b.setType(rs.getString("type"));
              b.setCapacite(rs.getInt("capacite"));
              b.setStatus(rs.getString("status"));*/
              busList.add(new Bus(rs.getInt("idBus"),rs.getString("immatriculation"),rs.getInt("capacite"),rs.getString("status")));
        }
        }catch(SQLException ex){           
                   Logger.getLogger(Dao.class.getName()).log(Level.SEVERE,null,ex);          
        }    
       return busList; 
    }
    
    /*trouver tous les bus du meme type*/ 
    public static ObservableList<Bus> findAllBusOfSameCapacity (int capacite) throws SQLException, ClassNotFoundException {
       ObservableList<Bus> busList = FXCollections.observableArrayList();
        String query="select*from bus where capacite="+capacite;
        try{
             prepstatement=bd.Connexion.getConnexion().prepareStatement(query);
             ResultSet rs=prepstatement.executeQuery();
             while(rs.next()){
              Bus b=new Bus();
              b.setIdBus(rs.getInt("idBus"));
              b.setImmatriculation(rs.getString("immatriculation"));
              b.setCapacite(rs.getInt("capacite"));
              b.setStatus(rs.getString("status"));
              busList.add(b);
        }
        }catch(SQLException ex){           
                   Logger.getLogger(Dao.class.getName()).log(Level.SEVERE,null,ex);          
        }    
       return busList; 
    }
    /*trouver tous les bus du meme status*/ 
    public static ObservableList<Bus> findAllBusOfSameStatus (String status) throws SQLException, ClassNotFoundException {
       ObservableList<Bus> busList = FXCollections.observableArrayList();
        String query="select*from bus where status="+status;
        try{
             prepstatement=bd.Connexion.getConnexion().prepareStatement(query);
             ResultSet rs=prepstatement.executeQuery();
             while(rs.next()){
              Bus b=new Bus();
              b.setIdBus(rs.getInt("idBus"));
              b.setImmatriculation(rs.getString("immatriculation"));
              b.setCapacite(rs.getInt("capacite"));
              b.setStatus(rs.getString("status"));
              busList.add(b);
        }
        }catch(SQLException ex){           
                   Logger.getLogger(Dao.class.getName()).log(Level.SEVERE,null,ex);          
        }    
       return busList; 
    }
    /*verifier si le bus existe*/
    public static boolean busExist(Bus b) throws SQLException, ClassNotFoundException{
        boolean exist=false;
         if(findAllBus().contains(b)){
             exist=true;
         }
                
        return exist;
    }
/*fonction chauffeur //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////*/
    /*creation d'un chauffeur*/
    public static void createChauffeur(Chauffeur ch) throws SQLException{
     
        String query="insert into chauffeur(nomDriver,Prenom,contact,tauxHoraire,categorie) values(?,?,?,?,?)";
        try{
            prepstatement=bd.Connexion.getConnexion().prepareStatement(query);
            prepstatement.setString(1, ch.getNomDriver());
            prepstatement.setString(2, ch.getPrenom());
            prepstatement.setString(3, ch.getContact());
            prepstatement.setFloat(4, ch.getTauxHoraire());
            prepstatement.setString(5, ch.getCategorie());
            prepstatement.executeUpdate();
            
         }catch(SQLException ex){           
                   Logger.getLogger(Dao.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    /*modifier un chauffeur*/
     public static void updateChauffeur(Chauffeur ch) throws SQLException{
     
        String query="UPDATE chauffeur SET nomDriver =?, prenom=?, contact =?,tauxHoraire=? ,categorie=?,where idDriver=?";
        try{
            prepstatement=bd.Connexion.getConnexion().prepareStatement(query);
            prepstatement.setString(1, ch.getNomDriver());
            prepstatement.setString(2, ch.getPrenom());
            prepstatement.setString(3, ch.getContact());
            prepstatement.setFloat(4, ch.getTauxHoraire());
            prepstatement.setString(5, ch.getCategorie());
            prepstatement.setInt(6, ch.getIdDriver());
            prepstatement.executeUpdate();
            
         }catch(SQLException ex){           
                   Logger.getLogger(Dao.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
     /*trouver un chauffeur*/
     public static Chauffeur findChauffeurById (int idDriver) throws SQLException, ClassNotFoundException {
       Chauffeur ch=null;
        String query="select*from chauffeur where idDriver="+idDriver;
        try{
             prepstatement=bd.Connexion.getConnexion().prepareStatement(query);
             ResultSet rs=prepstatement.executeQuery();
             while(rs.next()){
              ch=new Chauffeur();
              ch.setIdDriver(rs.getInt("idDriver"));
              ch.setNomDriver(rs.getString("nomDriver"));
              ch.setPrenom(rs.getString("prenom"));
              ch.setContact(rs.getString("contact"));
              ch.setTauxHoraire(rs.getInt("tauxHoraire"));
              ch.setCategorie(rs.getString("categorie"));
              
        }
        }catch(SQLException ex){           
                   Logger.getLogger(Dao.class.getName()).log(Level.SEVERE,null,ex);          
        }    
       return ch; 
    }
     /*trouver tous les chauffeurs*/
     public static ObservableList<Chauffeur>  findAllChauffeur() throws SQLException, ClassNotFoundException {
        ObservableList<Chauffeur> chauffeurList = FXCollections.observableArrayList();
        String query="select*from chauffeur";
        try{
             prepstatement=bd.Connexion.getConnexion().prepareStatement(query);
             ResultSet rs=prepstatement.executeQuery();
             while(rs.next()){
              Chauffeur ch=new Chauffeur();
              ch.setIdDriver(rs.getInt("idDriver"));
              ch.setNomDriver(rs.getString("nomDriver"));
              ch.setPrenom(rs.getString("prenom"));
              ch.setContact(rs.getString("contact"));
              ch.setTauxHoraire(rs.getInt("tauxHoraire"));
              ch.setCategorie(rs.getString("categorie"));
              chauffeurList.add(ch);
              
        }
        }catch(SQLException ex){           
                   Logger.getLogger(Dao.class.getName()).log(Level.SEVERE,null,ex);          
        }    
       return chauffeurList; 
    }
     /*verifier si le chauffeur existe*/
    private boolean chauffeurExist(Bus b) throws SQLException, ClassNotFoundException{
        boolean exist=false;
         if(findAllChauffeur().contains(b)){
             exist=true;
         }
                
        return exist;
    }
/*fonction clients///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////*/
      /*creation d'un client*/
    public static void createClient(Client c) throws SQLException{
        
        String query="insert into client(nom,prenom,adresse,contact,emailClient) values(?,?,?,?,?)";
        try{
            prepstatement=bd.Connexion.getConnexion().prepareStatement(query);
            prepstatement.setString(1, c.getNom());
            prepstatement.setString(2, c.getPrenom());
            prepstatement.setString(3, c.getAdresse());
            prepstatement.setString(4, c.getContact());
            prepstatement.setString(5, c.getEmailClient());
            prepstatement.executeUpdate();
            
         }catch(SQLException ex){           
                   Logger.getLogger(Dao.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
     /*modifier un client*/
     public static void updateClient(Client c) throws SQLException{
     
        String query="UPDATE client SET nom =?, prenom=?, contact =?,emailClient=? ,categorie=?,where idClient=?";
        try{
            prepstatement=bd.Connexion.getConnexion().prepareStatement(query);
            prepstatement.setString(1, c.getNom());
            prepstatement.setString(2, c.getPrenom());
            prepstatement.setString(3, c.getContact());
            prepstatement.setString(4, c.getEmailClient());
            prepstatement.setInt(5, c.getIdClient());
            prepstatement.executeUpdate();
            
         }catch(SQLException ex){           
                   Logger.getLogger(Dao.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
     /*trouver un client*/
     public static Client findClientById (int idClient) throws SQLException, ClassNotFoundException {
       Client c=null;
        String query="select*from chauffeur where idClient="+idClient;
        try{
             prepstatement=bd.Connexion.getConnexion().prepareStatement(query);
             ResultSet rs=prepstatement.executeQuery();
             while(rs.next()){
              c=new Client();
              c.setIdClient(rs.getInt("idClient"));
              c.setNom(rs.getString("nomDriver"));
              c.setPrenom(rs.getString("prenom"));
              c.setContact(rs.getString("contact"));
              c.setEmailClient(rs.getString("emailClient"));
              
        }
        }catch(SQLException ex){           
                   Logger.getLogger(Dao.class.getName()).log(Level.SEVERE,null,ex);          
        }    
       return c; 
    }
    /*trouver tous les clients*/
     public static ObservableList<Client> findAllClient () throws SQLException, ClassNotFoundException {
        ObservableList<Client> clientList = FXCollections.observableArrayList();
        String query="select*from client";
        try{
             prepstatement=bd.Connexion.getConnexion().prepareStatement(query);
             ResultSet rs=prepstatement.executeQuery();
             while(rs.next()){
              Client c=new Client();
              c.setIdClient(rs.getInt("idClient"));
              c.setNom(rs.getString("nomDriver"));
              c.setPrenom(rs.getString("prenom"));
              c.setContact(rs.getString("contact"));
              c.setEmailClient(rs.getString("emailClient"));
              clientList.add(c);
        }
        }catch(SQLException ex){           
                   Logger.getLogger(Dao.class.getName()).log(Level.SEVERE,null,ex);          
        }    
       return clientList; 
    }
      /*verifier si le client existe*/
    private boolean clientExist(Bus b) throws SQLException, ClassNotFoundException{
        boolean exist=false;
         if(findAllChauffeur().contains(b)){
             exist=true;
         }
                
        return exist;
    }
/*fonction reservation//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////*/
/*fonction ticket///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////*/
/*fonction trajet///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////*/
    /*creation d'un trajet*/
    public static void createTrajet(Trajet tr) throws SQLException{
        
        String query="insert into trajet(villeDepart,villeArrivee,tarifTrajet,durée) values(?,?,?,?)";
        try{
            prepstatement=bd.Connexion.getConnexion().prepareStatement(query);
            prepstatement.setString(1, tr.getVilleDepart());
            prepstatement.setString(2, tr.getVilleArrivee());
            prepstatement.setFloat(3, tr.getTarifTrajet());
            prepstatement.setTime(4, tr.getDurée());
            prepstatement.executeUpdate();
            
         }catch(SQLException ex){           
                   Logger.getLogger(Dao.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
     /*modifier un trajet*/
     public static void updateTrajet(Trajet tr) throws SQLException{
     
        String query="UPDATE trajet SET villeDepart =?, villeArrivee=?,  tarifTrajet=?, durée=?, where idTrajet=?";
        try{
            prepstatement=bd.Connexion.getConnexion().prepareStatement(query);
            prepstatement.setString(1, tr.getVilleDepart());
            prepstatement.setString(2, tr.getVilleArrivee());
            prepstatement.setFloat(3, tr.getTarifTrajet());
            prepstatement.setTime(4, tr.getDurée());
            prepstatement.setInt(5, tr.getIdTrajet());
            prepstatement.executeUpdate();
            
         }catch(SQLException ex){           
                   Logger.getLogger(Dao.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
     /*trouver un trajet*/
     public static Trajet findTrajetById (int idTrajet) throws SQLException, ClassNotFoundException {
        Trajet tr=null;
        String query="select*from trajet where idTrajet="+idTrajet;
        try{
             prepstatement=bd.Connexion.getConnexion().prepareStatement(query);
             ResultSet rs=prepstatement.executeQuery();
             while(rs.next()){
              tr=new Trajet();
              tr.setIdTrajet(rs.getInt("idTrajet"));
              tr.setVilleDepart(rs.getString("villeDepart"));
              tr.setVilleArrivee(rs.getString("villeArrivee"));
              tr.setTarifTrajet(rs.getFloat("tarifTrajet"));
              tr.setDurée(rs.getTime("durée"));
              
        }
        }catch(SQLException ex){           
                   Logger.getLogger(Dao.class.getName()).log(Level.SEVERE,null,ex);          
        }    
       return tr; 
    }
    /*trouver tous les trajets*/
     public static ObservableList<Trajet> findAllTrajet () throws SQLException, ClassNotFoundException {
        ObservableList<Trajet> trajetList = FXCollections.observableArrayList();
        String query="select*from Trajet";
        try{
             prepstatement=bd.Connexion.getConnexion().prepareStatement(query);
             ResultSet rs=prepstatement.executeQuery();
             while(rs.next()){
              Trajet tr=new Trajet();
              tr.setIdTrajet(rs.getInt("idClient"));
              tr.setVilleDepart(rs.getString("nomDriver"));
              tr.setVilleArrivee(rs.getString("prenom"));
              tr.setTarifTrajet(rs.getFloat("contact"));
              tr.setDurée(rs.getTime("emailClient"));
              trajetList.add(tr);
        }
        }catch(SQLException ex){           
                   Logger.getLogger(Dao.class.getName()).log(Level.SEVERE,null,ex);          
        }    
       return trajetList; 
    }
      /*verifier si le trajet existe*/
    private boolean trajettExist(Trajet tr) throws SQLException, ClassNotFoundException{
        boolean exist=false;
         if(findAllTrajet().contains(tr)){
             exist=true;
         }
                
        return exist;
    }
/*fonction utilisateur///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////*/
    /*creation d'un utilisateur*/
    public static void createUtilisateur(Utilisateur util) throws SQLException{
        
        String query="insert into utilisateur(nomCompteUtilisateur,contactUtilisateur,emailUtilisateur,userName,password,categorieCompte,dateInscription) values('"+util.getNomCompteUtilisateur()+"','"+util.getContactUtilisateur()+"','"+util.getEmailUtilisateur()+"','"+util.getUserName()+"','"+util.getPassword()+"','"+util.getCategorieCompte()+"','"+util.getDateInscription()+"')";
        try{
            statement=bd.Connexion.getConnexion().createStatement();
            statement.execute(query);
            /*prepstatement=bd.Connexion.getConnexion().prepareStatement(query);
            prepstatement.setString(1, util.getNomCompteUtilisateur());
            prepstatement.setString(2, util.getContactUtilisateur());
            prepstatement.setString(3, util.getEmailUtilisateur());
            prepstatement.setString(4, util.getUserName());
            prepstatement.setString(5, util.getPassword());
            prepstatement.setString(6, util.getCategorieCompte());
            prepstatement.setDate(7, (Date) util.getDateInscription());
            prepstatement.setTime(8, (Time) util.getDerniereActivite());
            prepstatement.executeUpdate();*/
            
         }catch(SQLException ex){           
                   Logger.getLogger(Dao.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
     /*modifier un utilisateur*/
     public static void updateUtilisateur(Utilisateur util) throws SQLException{
     
        String query="UPDATE utilisateur SET nomCompteUtilisateur=?,contactUtilisateur=?,emailUtilisateur=?,userName=?,password=?,categorieCompte=?,dateInscription=?,where idUtilisateur=?";
        try{
            prepstatement=bd.Connexion.getConnexion().prepareStatement(query);
            prepstatement.setString(1, util.getNomCompteUtilisateur());
            prepstatement.setString(2, util.getContactUtilisateur());
            prepstatement.setString(3, util.getEmailUtilisateur());
            prepstatement.setString(4, util.getUserName());
            prepstatement.setString(5, util.getPassword());
            prepstatement.setString(6, util.getCategorieCompte());
            prepstatement.setDate(8, (Date) util.getDateInscription());
            prepstatement.setInt(9, util.getIdUtilisateur());
            prepstatement.executeUpdate();
            
         }catch(SQLException ex){           
                   Logger.getLogger(Dao.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
     /*trouver un utilisateur*/
     public static Utilisateur findUtilisateurById (int idUtilisateur) throws SQLException, ClassNotFoundException {
        Utilisateur util=null;
        String query="select*from utilisateur where idUtilisateur="+idUtilisateur;
        try{
             prepstatement=bd.Connexion.getConnexion().prepareStatement(query);
             ResultSet rs=prepstatement.executeQuery();
             while(rs.next()){
              util=new Utilisateur();
              util.setIdUtilisateur(rs.getInt("idUtilisateur"));
              util.setNomCompteUtilisateur(rs.getString("villeDepart"));
              util.setContactUtilisateur(rs.getString("contactUtilisateur"));
              util.setEmailUtilisateur(rs.getString("EmailUtilisateur"));
              util.setUserName(rs.getString("userName"));
              util.setPassword(rs.getString("AES_DECRYPT(password)"));
              util.setCategorieCompte(rs.getString("categorieCompte"));
              util.setDateInscription(rs.getDate("dateInscription"));
              util.setIdUtilisateur(rs.getInt("idUtilisateur"));
              
              
        }
        }catch(SQLException ex){           
                   Logger.getLogger(Dao.class.getName()).log(Level.SEVERE,null,ex);          
        }    
       return util; 
    }
    /*trouver tous les utilisateurs*/
     public static ObservableList<Utilisateur> findAllUtilisateur () throws SQLException, ClassNotFoundException {
        ObservableList<Utilisateur> utilisateurList = FXCollections.observableArrayList();
        String query="select*from Utilisateur";
        try{
             prepstatement=bd.Connexion.getConnexion().prepareStatement(query);
             ResultSet rs=prepstatement.executeQuery();
             while(rs.next()){
              Utilisateur util=new Utilisateur();
              util.setIdUtilisateur(rs.getInt("idUtilisateur"));
              util.setIdUtilisateur(rs.getInt("idUtilisateur"));
              util.setNomCompteUtilisateur(rs.getString("nomCompteUtilisateur"));
              util.setContactUtilisateur(rs.getString("contactUtilisateur"));
              util.setEmailUtilisateur(rs.getString("EmailUtilisateur"));
              util.setUserName(rs.getString("userName"));
              util.setPassword(rs.getString("password"));
              util.setCategorieCompte(rs.getString("categorieCompte"));
              util.setDateInscription(rs.getDate("dateInscription"));
              utilisateurList.add(util);
        }
        }catch(SQLException ex){           
                   Logger.getLogger(Dao.class.getName()).log(Level.SEVERE,null,ex);          
        }    
       return utilisateurList; 
    }
     /*trouver tous les login*/
      public static ObservableList<Utilisateur> findAllLogin () throws SQLException, ClassNotFoundException {
        ObservableList<Utilisateur> loginList = FXCollections.observableArrayList();
        String query="select userName,AES_DECRYPT(password)from Utilisateur";
        try{
             prepstatement=bd.Connexion.getConnexion().prepareStatement(query);
             ResultSet rs=prepstatement.executeQuery();
             while(rs.next()){
              Utilisateur util=new Utilisateur();
              util.setUserName(rs.getString("userName"));
              util.setPassword(rs.getString("password)"));
              loginList.add(util);
        }
        }catch(SQLException ex){           
                   Logger.getLogger(Dao.class.getName()).log(Level.SEVERE,null,ex);          
        }    
       return loginList; 
      }
      /*verifier si l'utilisateur existe*/
    public static boolean utilisateurExist(Utilisateur util) throws SQLException, ClassNotFoundException{
        boolean exist=false;
         if(findAllUtilisateur().contains(util)){
             exist=true;
         }       
        return exist;
    }
     /*verifier si le trajet existe*/
    private boolean loginExist(Utilisateur util) throws SQLException, ClassNotFoundException{
        boolean exist=false;
         if(findAllLogin().contains(util)){
             exist=true;
         }
                
        return exist;
    }
/*fonction voyage////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////*/
/*numero valid///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////*/
     public static boolean isValid(String s)
    {
 
        
        Pattern p = Pattern.compile("^\\d{8}$");
 
        Matcher m = p.matcher(s);
 
        return (m.matches());
    }
 
    
}
