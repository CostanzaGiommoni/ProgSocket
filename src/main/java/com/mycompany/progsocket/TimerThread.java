/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progsocket;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author costy
 */
public class TimerThread implements Runnable{
    private int tempo;
    public TimerThread(int t){
        this.tempo=t;
    }
    @Override
    public void run(){
        for(int i=tempo; i>0;i--)
        {
            try {
                System.out.println("Secondi rimasti: "+i);
                sleep(1000);
            } catch (InterruptedException ex) { //eccezione legata ai thread
                Logger.getLogger(TimerThread.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        Thread t=new Thread();
    }

    void start() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
