/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.command;

import com.mycompany.model.Corporacao;
import com.mycompany.model.CorporacaoCollection;
import com.mycompany.presenter.PrincipalPresenter;


/**
 *
 * @author mayco
 */
public class SalvarCommand extends Command{
    
    private CorporacaoCollection listaCorporacao = CorporacaoCollection.getInstance();

    @Override
    public void execute(PrincipalPresenter presenter) {
        System.out.println("Executei");
        String marca = presenter.getView().getTxtMarca().getText();
        Corporacao c = new Corporacao(marca);
        listaCorporacao.add(c);
    }
    
}
