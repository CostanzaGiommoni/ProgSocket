/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progsocket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author costy
 */
public class Server {
    //invocare questi metodi nella classe di avvio
    TimerThread tt;
    ServerSocket ss;
    Socket so;
    BufferedWriter bw;
    BufferedReader br;
   public Server(int porta){
        try {
            ss=new ServerSocket(porta);
            System.out.println("Server avviato ed in ascolto");     //ACCENSIONE DEL SERVER, APERTURA DELLA PORTA ED UTILIZZO
                       ss.setSoTimeout(50000);                                             //appunti:Bind Exception si lega alla porta 2000
       tt=new TimerThread(2000);
       tt.start();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
    
   public void ascolto(){
        try {   
            so=ss.accept();
             System.out.println("Connessione Stabilita");               //Il socket a livello logico deve avere due aree di memoria(input e output stream)
             br=new BufferedReader(new InputStreamReader(so.getInputStream()));           //Visualizzazione inputstream
             bw=new BufferedWriter(new OutputStreamWriter(so.getOutputStream()));
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);       //Gestione dell'eccezione  
        }

   }
    public void scrivi(String messaggio){
        try {
            bw.write(messaggio+"\n");                //scrive dentro la RAM del server
            bw.flush();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        }
    public String leggi(){
        String messaggioritorno="";
        try {
            messaggioritorno=br.readLine();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        return messaggioritorno;        //istruzione globale 
    }
    
   
}
