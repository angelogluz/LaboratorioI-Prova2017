/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prova;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author angeloluz
 */
public class Util {
    /**
     * Simula carregamento
     * @param mensagem String
     * @param tempo long
     */
    public static void load(String mensagem, long tempo) {
        try {
            System.out.print(mensagem);
            long load = tempo / 5;
            int ponto = 0;
            while (ponto++ < 5) {
                System.out.print(".");
                Thread.sleep(load);
            }
            System.out.println("");
        } catch (InterruptedException ex) {
            Logger.getLogger(Boteco.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
