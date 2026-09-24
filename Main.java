import model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.print("\033[H\033[2J");
        System.out.flush();
        int quantidadeitem=0;
        Scanner scan = new Scanner(System.in);

        Produto prod1 = new Produto("arroz", 5.0);
        Produto prod2 = new Produto("batata", 2.50);
        Produto prod3 = new Produto("chocolate", 7.25);

        ArrayList<Produto> catalogo = new ArrayList<>();

        catalogo.add(prod1);
        catalogo.add(prod2);
        catalogo.add(prod3);

        Fatura fatura = new Fatura();

        int opcao = 0;

        while (true) {

            System.out.println("=========================");
            System.out.println("   LOJA DE SUPRIMENTOS   ");
            System.out.println("-------------------------");
            System.out.println("      1) Comprar        ");
            System.out.println("      2) Ver fatura     ");
            System.out.println("      3) Excluir item   ");
            System.out.println("      4) Alterar item   ");
            System.out.println("      5) Finalizar      ");
            System.out.println("=========================");

            opcao = scan.nextInt();
            System.out.println("");

            switch (opcao) {

                case 1:
                    int escolha = 0;
                    int find = 0;

                    while (escolha != 1) {

                        System.out.println("Escolha o código do produto");
                        System.out.println("---------------------------");
                        System.out.println("\033[3mDigite 1 para sair\033[0m\n");

                        for (Produto p : catalogo) {
                            System.out.printf(
                                "%d - %s R$%.2f%n",
                                p.getCodigo(),
                                p.getNome(),
                                p.getPreco()
                            );
                        }

                        escolha = scan.nextInt();
                        if(escolha==1){break;}
                        for (Produto p : catalogo) {
                            if (p.getCodigo() == escolha) {
                                find = 1;
                            }
                        }

                        if (find == 1) {

                            System.out.println("Quantidade desejada:");
                            int quantidade = scan.nextInt();

                            for (Produto p : catalogo) {
                                if (p.getCodigo() == escolha) {

                                    Item item = new Item(p, quantidade);
                                    fatura.addItem(item);

                                    System.out.println("Produto adicionado!\n");
                                }
                            }

                        } else {
                            System.out.println("Produto não encontrado\n");
                        }

                        find = 0;
                    }

                    break;

                case 2:
                    System.out.println("\033[3mSUA FATURA ATUAL\033[0m");
                    System.out.println("------------------------------");
                    for (Item i : fatura.getConjunto()){
                      System.out.printf("%s - x%s                 R$%.2f%n",i.getProduto().getNome(),i.getQuantidade(),i.getValorTotal());
                    }
                    System.out.println("------------------------------");
                    System.out.printf("Total: %.2f\n\n", fatura.getValorFatura());
                    break;
                case 3:
                    int opcDelete=0;
                    
                    while (true) {
                        
                    System.out.println("       ITENS ESCOLHIDOS       ");
                    System.out.println("------------------------------");
                    for (Item i : fatura.getConjunto()){
                      System.out.printf(" %d) %s - x%s           R$%.2f%n\n",i.getProduto().getCodigo(),i.getProduto().getNome(),i.getQuantidade(),i.getValorTotal());
                    }
                    System.out.println("\033[3m digite o código para excluir \033[0m");
                    System.out.println("\033[3m      ou 1 para sair          \033[0m");
                    System.out.println("------------------------------");
                    opcDelete = scan.nextInt();
                    if(opcDelete==1){break;}
                    System.out.println("Quantos deseja deletar?");
                    int qntDelete =  scan.nextInt();

                    for(Item i : fatura.getConjunto()){
                        if(i.getProduto().getCodigo()==opcDelete){
                        quantidadeitem = i.getQuantidade()- qntDelete;
                       i.setQuantidade(quantidadeitem);
                        System.out.printf("%s definida para %d unidades\n",i.getProduto().getNome(),i.getQuantidade());
                        }
                    }                   
                    break;
                    }
                    
            
                
                case 4:
                     int opcUpdate=0;
                    
                    while (true) {
                        
                    System.out.println("       ITENS ESCOLHIDOS       ");
                    System.out.println("------------------------------");
                    for (Item i : fatura.getConjunto()){
                      System.out.printf(" %d) %s - x%s           R$%.2f%n\n",i.getProduto().getCodigo(),i.getProduto().getNome(),i.getQuantidade(),i.getValorTotal());
                    }
                    System.out.println("\033[3m digite o código para alterar \033[0m");
                    System.out.println("\033[3m      ou 1 para sair          \033[0m");
                    System.out.println("------------------------------");
                    opcUpdate = scan.nextInt();
                    if(opcUpdate==1){break;}
                    System.out.println("Quantos deseja adicionar?");
                    int qntUpdate =  scan.nextInt();

                    for(Item i : fatura.getConjunto()){
                        if(i.getProduto().getCodigo()==opcUpdate){
                        quantidadeitem = i.getQuantidade()+ qntUpdate;
                       i.setQuantidade(quantidadeitem);
                        System.out.printf("%s definida para %d unidades\n",i.getProduto().getNome(),i.getQuantidade());
                        }
                    } }                  
                    break;
                
                case 5: 
                    System.out.println("\033[3mSUA FATURA FINAL\033[0m");
                    System.out.println("------------------------------");
                    for (Item i : fatura.getConjunto()){
                      System.out.printf("%s - x%s                 R$%.2f%n",i.getProduto().getNome(),i.getQuantidade(),i.getValorTotal());
                    }
                    System.out.println("------------------------------");
                    System.out.printf("Total: %.2f\n\n", fatura.getValorFatura());
                    break;
                    
            
            }
        
        }
    }
}
}