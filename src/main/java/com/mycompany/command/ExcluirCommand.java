/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.command;

import com.mycompany.model.Corporacao;
import com.mycompany.model.CorporacaoCollection;
import com.mycompany.presenter.PrincipalPresenter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mayco
 */
public class ExcluirCommand extends Command{

    private CorporacaoCollection listaCorporacao = CorporacaoCollection.getInstance();
    
    @Override
    public void execute(PrincipalPresenter presenter) {
        List<Corporacao> auxList = new ArrayList<>(listaCorporacao.getCorporacoesList());
        for (int i = 0; i < auxList.size(); i++) {
            if (presenter.getView().getTbMarcas().getSelectedRow() == i) {
                listaCorporacao.remove(auxList.get(i));
            }
        }
    }
    
}
