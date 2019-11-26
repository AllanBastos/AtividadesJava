package br.edu.ifpb.cliente;

import br.edu.ifpb.IF.ObjetoRemotoBiblioteca_IF;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Cliente{
    private static ObjetoRemotoBiblioteca_IF stub;
    private static Registry registry;


    public void execultarCliente(String host){
        try{
            registry = LocateRegistry.getRegistry(host);
            stub = (ObjetoRemotoBiblioteca_IF) registry.lookup("biblioteca");
        }catch (Exception e){
            System.err.println("Cliente exception: " + e.toString());
            e.printStackTrace();
        }
    }
    private String ReceberID(){
        Scanner input = new Scanner(System.in);
        System.out.print("Insira o id: ");
        String Id = input.nextLine();
        return Id;
    }


    public void menu(){
        while (true){
            Scanner input = new Scanner(System.in);
            System.out.print(
                    "O que deseja Fazer? \n" +
                    "1 - Buscar Livor\n" +
                    "2 - Cadastrar Livro\n" +
                    "3 - Remover Livro\n" +
                    "0 - Sair\n" +
                    "Digite uma opção:_");

            int opção = input.nextInt();

            switch (opção){
                case 1:{
                    String Id = ReceberID();
                    try {
                        String Resposta = stub.buscarLivro(Id);
                        System.out.println(Resposta);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }break;
                case 2:{
                    String id, titulo, autor, preco, tipo;
                    id = ReceberID();
                    titulo = ReceberTitulo();
                    autor = ReceberAutor();
                    preco = ReceberPreço();
                    tipo = ReceberTipo();

                    try {
                        String Resposta = stub.cadastrarLivro(id, titulo, autor, tipo, preco);
                        System.out.println(Resposta);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }break;
                case 3:{
                    String id = ReceberID();
                    try {
                        String Resposta = stub.removerLivro(id);
                        System.out.println(Resposta);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }break;
                case 0: System.exit(0);
                default:
                    System.err.println("Opção Invalida Tente Novamente!");
            }

        }
    }

    private String ReceberTipo() {
        Scanner input = new Scanner(System.in);
        System.out.print("Insira o Tipo: ");
        String resposta = input.nextLine();
        return resposta;
    }

    private String ReceberPreço() {
        Scanner input = new Scanner(System.in);
        System.out.print("Insira o Preço: R$");
        String resposta = input.nextLine();
        return resposta;
    }

    private String ReceberAutor() {
        Scanner input = new Scanner(System.in);
        System.out.print("Insira o Autor: ");
        String resposta = input.nextLine();
        return resposta;
    }

    private String ReceberTitulo() {
        Scanner input = new Scanner(System.in);
        System.out.print("Insira o Titulo: ");
        String Titulo = input.nextLine();
        return Titulo;
    }


}
