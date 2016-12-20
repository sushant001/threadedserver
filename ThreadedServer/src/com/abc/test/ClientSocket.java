package com.abc.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class ClientSocket {

    Socket socket = null;
    PrintWriter os = null;
    String identifierId;
    
    public Socket getSocket() {
        return socket;
    }
    
    public void send(MMessage msg) throws Exception {
        os = new PrintWriter(socket.getOutputStream());
        os.println("Sender : "+msg.getSender()+" , Message :"+msg.getMessage());
        os.flush();
    }


    public void startClient(String identifierId) throws IOException {
        this.identifierId = identifierId;
        InetAddress address = InetAddress.getLocalHost();
        String line = null;
        BufferedReader br = null;
        BufferedReader is = null;

        try {
            socket = new Socket(address, 4445); // You can use static final constant PORT_NUM
            br = new BufferedReader(new InputStreamReader(System.in));
            is = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        } catch (IOException e) {
            e.printStackTrace();
            System.err.print("IO Exception");
        }

        System.out.println("Client Address : " + address);
        System.out.println("Enter Data to echo Server ( Enter QUIT to end):");

        String response = null;
        try {
            while (true) {
                response = is.readLine();
                System.out.println(" I am "+identifierId+" ,  "+ response);
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Socket read Error");
        } finally {

            is.close();
            os.close();
            br.close();
            socket.close();
            System.out.println("Connection Closed");

        }

    }
}
