/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package block.network;

import block.gui.MainScreen;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mohamed_Reda
 */
public class MessageListner extends Thread {

    ServerSocket server;
    int port = 8877;
    writableGUI gui;

    public MessageListner(writableGUI gui, int port) {
        this.port = port;
        this.gui = gui;
        try {
            server = new ServerSocket(port);
        } catch (IOException ex) {
            Logger.getLogger(MessageListner.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public MessageListner() {
        try {
            server = new ServerSocket(port);
        } catch (IOException ex) {
            Logger.getLogger(MessageListner.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public MessageListner(MainScreen aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void run() {
        Socket clientSocket;
        try {
            while ((clientSocket = server.accept()) != null) {
                InputStream is = clientSocket.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String line = br.readLine();
                if (line != null) {
                    if (line.charAt(0) == '*') { //to add transaction.
                       gui.write(line); 
                    }else if(line.charAt(0)=='!')//update the transactions.
                    {
                        gui.updateTheData(line);
                    }else if(line.charAt(0)=='#')//the respose of the request of update transactions.
                    {
                        gui.data(line);
                    }else if(line.charAt(0)=='@') //to update the blockchain.
                    {
                        gui.UpdateTheBlockChain(line);
                    }else if(line.charAt(0)=='$')//the respose of the request of update blockchain.
                    {
                        gui.responseBlockChain(line);
                    }
                    else { //to add block to the chain.
                        gui.writeToBlockChain(line);
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(MessageListner.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
