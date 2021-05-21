/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model;

import com.mycompany.presenter.PrincipalPresenter;

/**
 *
 * @author mayco
 */
public class App {
    
    
    public static void main(String[] args) {
        PrincipalPresenter ob1 = PrincipalPresenter.getInstance();
        CorporacaoCollection.getInstance().registrarObservador(ob1);
        
    }
}
