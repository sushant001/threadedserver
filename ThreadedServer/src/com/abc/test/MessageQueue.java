/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abc.test;

/**
 *
 * @author SushantKumar
 */
public class MessageQueue {
    
    public static  void send(MMessage msg, ClientSocket client) throws Exception {
        client.send(msg);
    }
}
