package model;
import java.util.ArrayList;
public class Fatura {
    private ArrayList<Item> conjuntoItens = new ArrayList<>();
    private double valorFatura;

    public Fatura (ArrayList<Item> conjuntoItens,double valorFatura){
        this.conjuntoItens = conjuntoItens;
        this.valorFatura = valorFatura;
    }
    public Fatura (){}

    public ArrayList<Item> getConjunto(){
        return conjuntoItens;
    }

    public void setConjunto(ArrayList<Item> conjuntoItens){
        this.conjuntoItens = conjuntoItens;
    }

    public void addItem(Item item){
    conjuntoItens.add(item);
    this.valorFatura += item.getValorTotal();     
    }
   
    public double getValorFatura(){
    return valorFatura;
   }

}
