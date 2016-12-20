/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abc.test;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author SushantKumar
 */
public class MessageSender {
    
    private static final Map<String, MMessage> clientMessageMap = new HashMap<>();
    
    public static boolean validate(MMessage msg) {
        
        if(clientMessageMap.containsKey(msg.getReciever())) {
            MMessage lastMsg = clientMessageMap.get(msg.getReciever());
            if(lastMsg.equals(msg)) {
                return false;
            }
        } else {
            clientMessageMap.put(msg.getReciever(), msg);
        }
        return true;
    }
    
    
    
}
