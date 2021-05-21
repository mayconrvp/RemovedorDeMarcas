/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.state;

import com.mycompany.command.ExcluirCommand;
import com.mycompany.model.Corporacao;
import com.mycompany.model.CorporacaoCollection;
import com.mycompany.presenter.PrincipalPresenter;
import com.mycompany.presenter.PrincipalPresenterState;
import com.mycompany.util.UtilitarioString;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author mayco
 */
public class VisualizacaoState extends PrincipalPresenterState {

    PrincipalPresenter presenter;
    private CorporacaoCollection listaCorporacao = CorporacaoCollection.getInstance();
    private UtilitarioString utilString = UtilitarioString.getInstance();
    
    public VisualizacaoState(PrincipalPresenter presenter) {
        super(presenter);
        this.presenter = presenter;
        presenter.getView().setEnabled(false);
        presenter.getView().getBtnAdicionar().setText("Adicionar");
        presenter.getView().getBtnAdicionar().setVisible(true);
        presenter.getView().getTxtMarca().setEnabled(false);
        presenter.getView().getBtnAdicionar().setEnabled(true);
        presenter.getView().getBtnDeletar().setEnabled(true);
        presenter.getView().getBtnProcessar().setEnabled(true);
        presenter.getView().setEnabled(true);
        presenter.getView().setVisible(true);
        
        configuraListeners();
    }
    
    @Override
    public void excluir(){
        new ExcluirCommand().execute(presenter);
    }
    
    public void configuraListeners(){
        presenter.getView().getBtnAdicionar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                new InclusaoState(presenter);
            }
        });
        
        presenter.getView().getBtnDeletar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try {
                    verificaCollectionVazia();
                    excluir();
                    JOptionPane.showMessageDialog(null, "Marca removida", "Ok", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao excluir", "Erro", JOptionPane.ERROR_MESSAGE);
                }
                excluir();
            }
        });
        
        presenter.getView().getBtnProcessar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                processaSubstituicao();
            }
        });
    }
    
    private void verificaCollectionVazia() throws Exception {
        if (listaCorporacao.getCorporacoesList().size()==0) {
            throw new Exception("Não há Marcas para serem deletadas");
        }
    }
    
    private void processaSubstituicao() {
        try{
            String original = presenter.getView().getTaOriginal().getText();
            String processada = "";
            int i=0;
            for (Corporacao corporacao : listaCorporacao.getCorporacoesList()){
                String marca = corporacao.getNome();
                String simbolo = "*";
                String newString = utilString.substitui(marca, simbolo);
                processada = original.replace(marca, newString);
                System.out.println(processada);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
    }
}
