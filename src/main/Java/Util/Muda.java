package main.Java.Util;

import main.Java.App;

public class Muda {

    public void pedidos() {
        App.chefe.setVisible(false);
        App.vegano.setVisible(false);
        App.finalizar.setVisible(false);
        App.burger.setVisible(false);
        App.sobremasa.setVisible(false);
        App.pedidos.setVisible(true);
    }

    public void chefe() {
        App.pedidos.setVisible(false);
        App.finalizar.setVisible(false);
        App.burger.setVisible(false);
        App.sobremasa.setVisible(false);
        App.vegano.setVisible(false);  
        App.chefe.setVisible(true);
    }

    public void vegano() {
        App.pedidos.setVisible(false);
        App.chefe.setVisible(false);
        App.finalizar.setVisible(false);
        App.burger.setVisible(false);
        App.sobremasa.setVisible(false);
        App.vegano.setVisible(true);
    }

    public void finalizar() {
        App.pedidos.setVisible(false);
        App.chefe.setVisible(false);
        App.vegano.setVisible(false);
        App.burger.setVisible(false);
        App.sobremasa.setVisible(false);
        App.finalizar.setVisible(true);

        App.finalizar.carregarDadosTabela();
    }

    public void sobremasa() {
        App.pedidos.setVisible(false);
        App.chefe.setVisible(false);
        App.vegano.setVisible(false);
        App.finalizar.setVisible(false);
        App.burger.setVisible(false);
        App.sobremasa.setVisible(true);
    }

    public void burger() {
        App.pedidos.setVisible(false);
        App.chefe.setVisible(false);
        App.vegano.setVisible(false);
        App.finalizar.setVisible(false);
        App.sobremasa.setVisible(false);
        App.burger.setVisible(true);
    }
}
