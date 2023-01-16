/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author IDA
 */

public class Reservation implements Serializable {

   private int idreservation;
   private Date dateReservation;
   private int nbDePlace;
   private int payement;
   private Date dateLimiteAnnulation;
   private String status;
   private String statusPayement;
   private int idClient;
   private int idVoyage;

    public Reservation() {
    }

    public Reservation(int idreservation) {
        this.idreservation = idreservation;
    }

    public Reservation(Date dateReservation, int nbDePlace, int payement, Date dateLimiteAnnulation, String status, String statusPayement, int idClient, int idVoyage) {
        this.dateReservation = dateReservation;
        this.nbDePlace = nbDePlace;
        this.payement = payement;
        this.dateLimiteAnnulation = dateLimiteAnnulation;
        this.status = status;
        this.statusPayement = statusPayement;
        this.idClient = idClient;
        this.idVoyage = idVoyage;
    }

    public Reservation(int idreservation, Date dateReservation, int nbDePlace, int payement, Date dateLimiteAnnulation, String status, String statusPayement, int idClient, int idVoyage) {
        this.idreservation = idreservation;
        this.dateReservation = dateReservation;
        this.nbDePlace = nbDePlace;
        this.payement = payement;
        this.dateLimiteAnnulation = dateLimiteAnnulation;
        this.status = status;
        this.statusPayement = statusPayement;
        this.idClient = idClient;
        this.idVoyage = idVoyage;
    }

    public int getIdreservation() {
        return idreservation;
    }

    public void setIdreservation(int idreservation) {
        this.idreservation = idreservation;
    }

    public Date getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(Date dateReservation) {
        this.dateReservation = dateReservation;
    }

    public int getNbDePlace() {
        return nbDePlace;
    }

    public void setNbDePlace(int nbDePlace) {
        this.nbDePlace = nbDePlace;
    }

    public int getPayement() {
        return payement;
    }

    public void setPayement(int payement) {
        this.payement = payement;
    }

    public Date getDateLimiteAnnulation() {
        return dateLimiteAnnulation;
    }

    public void setDateLimiteAnnulation(Date dateLimiteAnnulation) {
        this.dateLimiteAnnulation = dateLimiteAnnulation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusPayement() {
        return statusPayement;
    }

    public void setStatusPayement(String statusPayement) {
        this.statusPayement = statusPayement;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getIdVoyage() {
        return idVoyage;
    }

    public void setIdVoyage(int idVoyage) {
        this.idVoyage = idVoyage;
    }

    @Override
    public String toString() {
        return "Reservation{" + "idreservation=" + idreservation + ", dateReservation=" + dateReservation + ", nbDePlace=" + nbDePlace + ", payement=" + payement + ", dateLimiteAnnulation=" + dateLimiteAnnulation + ", status=" + status + ", statusPayement=" + statusPayement + ", idClient=" + idClient + ", idVoyage=" + idVoyage + '}';
    }
   
    
}
