package com.mycompany.presenter;

import com.mycompany.model.Corporacao;
import com.mycompany.state.InclusaoState;
import com.mycompany.state.VisualizacaoState;
import com.mycompany.view.TelaPrincipal;
import com.mycompany.interfaces.Observer;
import com.mycompany.interfaces.Subject;
import com.mycompany.model.CorporacaoCollection;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mayco
 */
public class PrincipalPresenter implements Observer{
    private TelaPrincipal view;
    private PrincipalPresenterState estado;
    private static PrincipalPresenter instance;
    private DefaultTableModel tmMarcas;
    
    private CorporacaoCollection listaCorporacao = CorporacaoCollection.getInstance();
    
    public static PrincipalPresenter getInstance(){
        if (instance == null){
            instance = new PrincipalPresenter();
        }
        return instance;
    }
    
    
    private PrincipalPresenter() {
        this.view = new TelaPrincipal();
        if(listaCorporacao == null){
            this.estado = new InclusaoState(this);
        }else{
            this.estado = new VisualizacaoState(this);
        }
        carregarTabela();    
    }
    
    public void salvar(){
        estado.salvar();
    }
        
    public void excluir(){
        estado.excluir();
    }
    
    public void setEstado(PrincipalPresenterState estado){
        this.estado = estado;
    }
    
    public void carregarTabela(){
        tmMarcas = new DefaultTableModel(
                new Object[][]{},
                new String []{"Marcas"}
        );
        
        view.getTbMarcas().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tmMarcas.setNumRows(0);
        view.getTbMarcas().setModel(tmMarcas);
    }
    

    public TelaPrincipal getView() {
        return view;
    }
    
    private void limpaTabela() {
        if (tmMarcas.getRowCount() > 0) {
            for (int i = tmMarcas.getRowCount() - 1; i > -1; i--) {
                tmMarcas.removeRow(i);
            }
        }
    }

    @Override
    public void update(Subject subject) {
        limpaTabela();
        for (Corporacao corporacao : listaCorporacao.getCorporacoesList()){
            tmMarcas.addRow(new Object[]{
                corporacao.getNome()
            });
        }
    }
}
