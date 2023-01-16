/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.util.Date;
import java.sql.Time;

/**
 *
 * @author IDA
 */

public class Voyage implements Serializable {
   	private int idVoyage;
        private Date dateVoyage;
        private Time heurDepartVoyage;
        private Time heurArrivee;
        private String status;
        private Date dateLimite;
        private int nbSiegeDispo;
        private int idBus;
        private int idDriver;
        private int idTrajet;

    public Voyage() {
    }

    public Voyage(int idVoyage) {
        this.idVoyage = idVoyage;
    }

    public Voyage(Date dateVoyage, Time heurDepartVoyage, Date dateLimite, int nbSiegeDispo, int idBus, int idDriver, int idTrajet) {
        this.dateVoyage = dateVoyage;
        this.heurDepartVoyage = heurDepartVoyage;
        this.dateLimite = dateLimite;
        this.nbSiegeDispo = nbSiegeDispo;
        this.idBus = idBus;
        this.idDriver = idDriver;
        this.idTrajet = idTrajet;
    }

    public Voyage(int idVoyage, Date dateVoyage, Time heurDepartVoyage, Time heurArrivee, String status, Date dateLimite, int nbSiegeDispo, int idBus, int idDriver, int idTrajet) {
        this.idVoyage = idVoyage;
        this.dateVoyage = dateVoyage;
        this.heurDepartVoyage = heurDepartVoyage;
        this.heurArrivee = heurArrivee;
        this.status = status;
        this.dateLimite = dateLimite;
        this.nbSiegeDispo = nbSiegeDispo;
        this.idBus = idBus;
        this.idDriver = idDriver;
        this.idTrajet = idTrajet;
    }

    public int getIdVoyage() {
        return idVoyage;
    }

    public void setIdVoyage(int idVoyage) {
        this.idVoyage = idVoyage;
    }

    public Date getDateVoyage() {
        return dateVoyage;
    }

    public void setDateVoyage(Date dateVoyage) {
        this.dateVoyage = dateVoyage;
    }

    public Time getHeurDepartVoyage() {
        return heurDepartVoyage;
    }

    public void setHeurDepartVoyage(Time heurDepartVoyage) {
        this.heurDepartVoyage = heurDepartVoyage;
    }

    public Time getHeurArrivee() {
        return heurArrivee;
    }

    public void setHeurArrivee(Time heurArrivee) {
        this.heurArrivee = heurArrivee;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDateLimite() {
        return dateLimite;
    }

    public void setDateLimite(Date dateLimite) {
        this.dateLimite = dateLimite;
    }

    public int getNbSiegeDispo() {
        return nbSiegeDispo;
    }

    public void setNbSiegeDispo(int nbSiegeDispo) {
        this.nbSiegeDispo = nbSiegeDispo;
    }

    public int getIdBus() {
        return idBus;
    }

    public void setIdBus(int idBus) {
        this.idBus = idBus;
    }

    public int getIdDriver() {
        return idDriver;
    }

    public void setIdDriver(int idDriver) {
        this.idDriver = idDriver;
    }

    public int getIdTrajet() {
        return idTrajet;
    }

    public void setIdTrajet(int idTrajet) {
        this.idTrajet = idTrajet;
    }

    @Override
    public String toString() {
        return "Voyage{" + "idVoyage=" + idVoyage + ", dateVoyage=" + dateVoyage + ", heurDepartVoyage=" + heurDepartVoyage + ", heurArrivee=" + heurArrivee + ", status=" + status + ", dateLimite=" + dateLimite + ", nbSiegeDispo=" + nbSiegeDispo + ", idBus=" + idBus + ", idDriver=" + idDriver + ", idTrajet=" + idTrajet + '}';
    }
        
}
