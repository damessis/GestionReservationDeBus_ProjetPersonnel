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
public class Bus implements Serializable{
   	private int idBus;
        private String immatriculation;
        private int capacite;
        private String status;

    public Bus() {
    }

    public Bus(int idBus) {
        this.idBus = idBus;
    }

    public Bus(String immatriculation,int capacite, String status) {
        this.immatriculation = immatriculation;
        this.capacite = capacite;
        this.status = status;
    }

    public Bus(int idBus, String immatriculation, int capacite, String status) {
        this.idBus = idBus;
        this.immatriculation = immatriculation;
        this.capacite = capacite;
        this.status = status;
    }

    public int getIdBus() {
        return idBus;
    }

    public void setIdBus(int idBus) {
        this.idBus = idBus;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }
    
    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Bus{" + "idBus=" + idBus + ", immatriculation=" + immatriculation + ", capacite=" + capacite + ", status=" + status + '}';
    }

   
        
    
    
  
    
    
}
