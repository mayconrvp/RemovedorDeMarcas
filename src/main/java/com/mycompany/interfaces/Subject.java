/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.interfaces;

/**
 *
 * @author mayco
 */
public interface Subject {
    public void registrarObservador(Observer observer);
    public void desregistrarObservador(Observer observer);
    public void notificar();
}
