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
public class Ticket implements Serializable {
  	private int idTicket;
        private String numTicket;
        private int numSiege;
        private int montantPayer;	
        private Date dateTicket;
        private String status;
        private Date validite;
        private int idreservation;

    public Ticket() {
    }

    public Ticket(int idTicket) {
        this.idTicket = idTicket;
    }

    public Ticket(String numTicket, int numSiege, int montantPayer, Date dateTicket, String status, Date validite, int idreservation) {
        this.numTicket = numTicket;
        this.numSiege = numSiege;
        this.montantPayer = montantPayer;
        this.dateTicket = dateTicket;
        this.status = status;
        this.validite = validite;
        this.idreservation = idreservation;
    }

    public Ticket(int idTicket, String numTicket, int numSiege, int montantPayer, Date dateTicket, String status, Date validite, int idreservation) {
        this.idTicket = idTicket;
        this.numTicket = numTicket;
        this.numSiege = numSiege;
        this.montantPayer = montantPayer;
        this.dateTicket = dateTicket;
        this.status = status;
        this.validite = validite;
        this.idreservation = idreservation;
    }

    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    public String getNumTicket() {
        return numTicket;
    }

    public void setNumTicket(String numTicket) {
        this.numTicket = numTicket;
    }

    public int getNumSiege() {
        return numSiege;
    }

    public void setNumSiege(int numSiege) {
        this.numSiege = numSiege;
    }

    public int getMontantPayer() {
        return montantPayer;
    }

    public void setMontantPayer(int montantPayer) {
        this.montantPayer = montantPayer;
    }

    public Date getDateTicket() {
        return dateTicket;
    }

    public void setDateTicket(Date dateTicket) {
        this.dateTicket = dateTicket;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getValidite() {
        return validite;
    }

    public void setValidite(Date validite) {
        this.validite = validite;
    }

    public int getIdreservation() {
        return idreservation;
    }

    public void setIdreservation(int idreservation) {
        this.idreservation = idreservation;
    }

    @Override
    public String toString() {
        return "Ticket{" + "idTicket=" + idTicket + ", numTicket=" + numTicket + ", numSiege=" + numSiege + ", montantPayer=" + montantPayer + ", dateTicket=" + dateTicket + ", status=" + status + ", validite=" + validite + ", idreservation=" + idreservation + '}';
    }
        
}