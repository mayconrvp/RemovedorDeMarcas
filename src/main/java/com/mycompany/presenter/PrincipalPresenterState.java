/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.presenter;

/**
 *
 * @author mayco
 */
public abstract class PrincipalPresenterState {
    private PrincipalPresenter presenter;

    public PrincipalPresenterState(PrincipalPresenter presenter) {
        this.presenter = presenter; 
    }
    
    public void salvar(){
        throw new RuntimeException("Não é possivel salvar a partir desse estado");
    }
    
    public void excluir(){
        throw new RuntimeException("Não é possivel excluir a partir desse estado");
    }
    
}
