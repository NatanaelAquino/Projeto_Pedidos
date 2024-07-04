package main.Java;

import main.Java.Paginas.Burges;
import main.Java.Paginas.Chefe;
import main.Java.Paginas.Finalizar;
import main.Java.Paginas.Pedidos;
import main.Java.Paginas.Sobremesa;
import main.Java.Paginas.Vegano;


public class App {

    public static Chefe chefe = new Chefe();
    public static Burges burger = new Burges();
    public static Vegano vegano = new Vegano();
    public static Finalizar finalizar = new Finalizar();
    public static Sobremesa sobremasa = new Sobremesa();
    public static Pedidos pedidos = new Pedidos();




    public static void main(String[] args) {
        pedidos.setVisible(true);

        finalizar.carregarDadosTabela();
    }
}
