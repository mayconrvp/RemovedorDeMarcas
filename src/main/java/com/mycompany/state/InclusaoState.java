/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.state;

import com.mycompany.command.SalvarCommand;
import com.mycompany.presenter.PrincipalPresenter;
import com.mycompany.presenter.PrincipalPresenterState;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author mayco
 */
public class InclusaoState extends PrincipalPresenterState {
    
    PrincipalPresenter presenter;
    public InclusaoState(PrincipalPresenter presenter){
        super(presenter);
        this.presenter = presenter;
        presenter.getView().setEnabled(false);
        presenter.getView().getTxtMarca().setEnabled(true);
        presenter.getView().getBtnAdicionar().setText("Salvar");
        presenter.getView().getBtnDeletar().setEnabled(false);
        presenter.getView().getBtnProcessar().setEnabled(false);
        presenter.getView().setEnabled(true);
        presenter.getView().setVisible(true);
        configuraListeners();
    }
    
    @Override
    public void salvar(){
        new SalvarCommand().execute(presenter);
        presenter.setEstado(new VisualizacaoState(presenter));
    }
    
    public void configuraListeners(){
        presenter.getView().getBtnAdicionar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                salvar();
            }
        });
    }
}
