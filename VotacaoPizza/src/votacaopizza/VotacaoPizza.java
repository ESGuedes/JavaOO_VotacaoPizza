package votacaopizza;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class VotacaoPizza {

   
    private static Scanner leitor = new Scanner(System.in);
    
    private static List<Usuario> usuarios;
    private static List<Pizza> pizzas;
    private static List<Voto> votos;
    
    public static void main(String[] args) {
        VotacaoPizza.usuarios = new ArrayList<Usuario>();
        VotacaoPizza.pizzas = new ArrayList<Pizza>();
        VotacaoPizza.votos = new ArrayList<Voto>();
        
        GerarMassaTestes();
        int opcao = 0;
        
        do{
            opcao = Opcoes();
             
            switch (opcao){
                case 1:
                    //CadastrarUsuario();
                    break;
                case 2:
                    //CadastrarPizza();
                    break;
                case 3:
                    VotoUsuarioPizza();
                    break;
                case 4:
                    //VotosUsuario();
                    break;
                case 5:
                    break;
                case 9:
                    break;
                        
            }
        }while(opcao != 9);
        
    }
    
    private static int Opcoes(){
        System.out.println("1 - Cadastrar Pizza");
        System.out.println("2 - Cadastrar Usuario");
        System.out.println("3 - Votar Sabor");
        System.out.println("4 - Seu voto");
        System.out.println("5 - Ver combinações");
        System.out.println("9 - Sair");
        System.out.println("Digite sua opção");
        int opcao = leitor.nextInt();
        leitor.nextLine();
        
        return opcao;    
    }
    
    private static void GerarMassaTestes() {
        for (int i = 1; i < 8; i++) {
            Usuario u = new Usuario();
            u.setCodigo(i);
            u.setNome("Usuario_" + i);
            VotacaoPizza.usuarios.add(u);
        }
        
         Pizza p1 = new Pizza();
         p1.setSabor("Calabresa");
         VotacaoPizza.pizzas.add(p1);
         
         Pizza p2 = new Pizza();
         p2.setSabor("Portuguesa");
         VotacaoPizza.pizzas.add(p2);
         
         Pizza p3 = new Pizza();
         p3.setSabor("Quatro Queijos");
         VotacaoPizza.pizzas.add(p3);
                 
    }
    
     private static void VotoUsuarioPizza(){
         Usuario u = null;
         
        do{
            System.out.println("Codigo de usuario: ");
            int codUsuario = leitor.nextInt();
            leitor.nextLine();
            u = UsuarioPorCodigo(codUsuario);
        }
        while(u == null);
         
         System.out.println("Usuario valido");
         System.out.println("Atribua notas de 1 a 5 para os sabores:");
         
        for(Pizza p : pizzas){
             System.out.println("Sabor: " + p.getSabor());
             System.out.println("Digite sua nota: ");
             int nota = leitor.nextInt();
             leitor.nextLine();
             
             Voto v = new Voto();
             v.setUsuario(u);
             v.setPizza(p);
             v.setNota(nota);
             VotacaoPizza.votos.add(v);
                         
        }
    }
     
    private static Usuario UsuarioPorCodigo(int codUsuario){
        for (Usuario u : usuarios){
             if(codUsuario == u.getCodigo()){
                 return u;
             }
        }
        return null;
    }
}