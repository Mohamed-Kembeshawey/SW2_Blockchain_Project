/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package block.network;

/**
 *
 * @author Mohamed_Reda
 */
public interface writableGUI {
    void write(String s);
    void writeToBlockChain(String s);
    
    void updateTheData(String s);
    void data(String line);
    
    void UpdateTheBlockChain(String line);
    void responseBlockChain(String line);
}
