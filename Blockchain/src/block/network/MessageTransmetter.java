/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package block.network;

import blockchain.code.Block;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mohamed_Reda
 */
public class MessageTransmetter extends Thread {

    String message, hostname = "localhost";
    int port = 8877;
    Block block;
    int flagForUpdateTheData = 0;

    public MessageTransmetter() {
    }

    public MessageTransmetter(String message, String hostname, int port,int flagForUpdateTheData) {
        this.message = message;
        this.hostname = hostname;
        this.port = port;
        this.flagForUpdateTheData=flagForUpdateTheData;
    }

    public MessageTransmetter(String message) {
        this.message = message;
        this.flagForUpdateTheData = 0;
    }

    public MessageTransmetter(String message, int flagForUpdateTheData) {
        this.message = message;
        this.flagForUpdateTheData = flagForUpdateTheData;
    }

    
    
    @Override
    public void run() {

        try {
            File theIPs_and_Ports = new File("theIPs_and_Ports.txt");
            if (!theIPs_and_Ports.exists()) {

                theIPs_and_Ports.createNewFile();
            }

            BufferedReader br = new BufferedReader(new FileReader(theIPs_and_Ports));

            String st;
            if (flagForUpdateTheData == 0) {

                while ((st = br.readLine()) != null) { // 
                    System.out.println(st);
                    String arr[] = st.split(",");

                    for (int i = 0; i < arr.length; i += 2) {
                        Socket s = new Socket(arr[i], Integer.parseInt(arr[i + 1]));
                        s.getOutputStream().write(message.getBytes());
                        s.close();
                    }
                }
            } else {
                Socket s = new Socket(hostname, port);
                s.getOutputStream().write(message.getBytes());
                s.close();
            }

        } catch (IOException ex) {
            Logger.getLogger(MessageTransmetter.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
