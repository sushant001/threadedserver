/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abc.test;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author SushantKumar
 */
public class MMessage {

    private String sender;
    private String reciever;
    private String message;
    private Date arrivalTime;

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReciever() {
        return reciever;
    }

    public void setReciever(String reciever) {
        this.reciever = reciever;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.reciever);
        hash = 23 * hash + Objects.hashCode(this.message);
        hash = 23 * hash + Objects.hashCode(this.arrivalTime);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MMessage other = (MMessage) obj;
        return Objects.equals(this.reciever, other.reciever)
                && (Objects.equals(this.message, other.message))
                && (Math.abs(this.arrivalTime.getTime() - other.getArrivalTime().getTime()) < 5000);
    }

}
