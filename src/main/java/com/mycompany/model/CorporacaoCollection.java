/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model;

import java.util.ArrayList;
import java.util.Collections;
import com.mycompany.interfaces.Subject;
import java.util.LinkedHashSet;
import java.util.List;
import com.mycompany.interfaces.Observer;
import java.util.Set;

/**
 *
 * @author mayco
 */
public class CorporacaoCollection implements Subject {
    private static CorporacaoCollection instance;
    private final Set<Observer> observadores = new LinkedHashSet<Observer>();
    private final List<Corporacao> corporacoesList = new ArrayList<>();
    
    private CorporacaoCollection(){        
    }
    
    public static CorporacaoCollection getInstance(){
        if (instance == null){
            instance = new CorporacaoCollection();
        }
        return instance;
    }
    
    public void add(Corporacao corp){
        corporacoesList.add(corp);
        notificar();
    }
    
    public void remove(Corporacao corp){
        corporacoesList.remove(corp);
        notificar();
    }
    
    @Override
    public void registrarObservador(Observer observer) {
        observadores.add(observer);  
    }

    @Override
    public void desregistrarObservador(Observer observer) {
        observadores.remove(observer);
    }

    @Override
    public void notificar() {
        for (Observer observer : observadores){
            observer.update(this);
        }
    }

    public Set<Observer> getObservadores() {
        return observadores;
    }

    public List<Corporacao> getCorporacoesList() {
        return Collections.unmodifiableList(corporacoesList);
    }

    
}

