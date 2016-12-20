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
public class ClientManager {
    
    static int autoId=1;
    public static Map<String, ClientSocket> clientMap = new HashMap<>();
    
    public static String startClient() {
        String id = "client " + autoId;
         new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    ClientSocket client = new ClientSocket();
                    autoId += 1;
                    clientMap.put(id, client);
                    client.startClient(id);

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }).start();
         return id;
    }
    
   public static void listClients() {
       for(String s : clientMap.keySet()) {
           System.out.println(s);
       }
   }
}
