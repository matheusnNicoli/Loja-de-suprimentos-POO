package model;
import java.util.Random;

public class Produto {
    private String nome;
    private int codigo;
    private double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;

        Random random = new Random();
        this.codigo=random.nextInt(989)+10;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }



    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}