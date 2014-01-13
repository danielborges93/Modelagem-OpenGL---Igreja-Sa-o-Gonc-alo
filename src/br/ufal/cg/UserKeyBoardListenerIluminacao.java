/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufal.cg;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Daniel Borges | Jário José
 */

public class UserKeyBoardListenerIluminacao implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Lister: " + e.toString());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
}
