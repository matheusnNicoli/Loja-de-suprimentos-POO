import model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.print("\033[H\033[2J");
        System.out.flush();

        Scanner scan = new Scanner(System.in);

        Produto prod1 = new Produto("arroz", 5.0);
        Produto prod2 = new Produto("batata",  2.50);
        Produto prod3 = new Produto("chocolate",  7.25);
       
        ArrayList<Produto> catalogo = new ArrayList<>();

        catalogo.add(prod1);
        catalogo.add(prod2);
        catalogo.add(prod3);
        
        Fatura fatura = new Fatura();

        int opcao= 0;
     
   while (opcao!=5) {
    
   

        System.out.println("=========================");
        System.out.println("   LOJA DE SUPRIMENTOS   ");
        System.out.println("-------------------------");
        System.out.println("      1) Comprar        ");
        System.out.println("      2) Ver fatura     ");
        System.out.println("      3) Excluir item   ");
        System.out.println("      4) Alterar item   ");
        System.out.println("      5) Finalizar      ");
        System.out.println("=========================");

        opcao=scan.nextInt();
        System.out.println("");
        switch (opcao) {
            case 1: 
            int escolha =0;
            while (escolha!=1) {
            System.out.println("Escolha o código do produto");
            System.out.println("---------------------------");
            System.out.println("\033[3mDigite 1 para sair\033[0m\n");
            for(Produto p: catalogo){
            System.out.printf("%d - %s R$%.2f%n", p.getCodigo(), p.getNome(), p.getPreco());
            }
            escolha = scan.nextInt();
            System.out.println("Quantidade desejada:");
            int quantidade = scan.nextInt(); 
            Item item = new Item(prod3, quantidade)
            }
            break;
        }
   
   
   
}
}
}