/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.progsocket;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author costy
 */
public class AvvioClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            Client c=new Client(InetAddress.getLocalHost(),2000);      //Per far partire il socket del client serve la porta dell'indirizzo IP
            c.leggi();
            c.scrivi("Okay grazie");
 
        } catch (UnknownHostException ex) {
            Logger.getLogger(AvvioClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
