package br.edu.ifpb.cliente;

import br.edu.ifpb.signos_IF;
import com.sun.source.tree.WhileLoopTree;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Cliente {
    private static signos_IF stub;
    private static Registry registry;
    private static Scanner input = new Scanner(System.in);
    private static List<String> signosValidos = new ArrayList<>();


    public Cliente() {
        String signos[] = {"ESCORPIAO", "ARIES", "TOURO", "GEMEOS", "GEMEOS",
                "LEAO", "VIRGEM", "LIBRA", "SARGITARIO", "AQUARIO", "PEIXES"};

        signosValidos.addAll(Arrays.asList(signos));
    }

    public void execultarCliente(String host){
        try{
            registry = LocateRegistry.getRegistry(host);
            stub = (signos_IF) registry.lookup("signo");
        }catch (Exception e){
            System.err.println("Cliente exception: " + e.toString());
            e.printStackTrace();
        }
    }

    public void menu(){
        while (true){
            System.out.printf(
                            " ______________________________\n" +
                            "|        Projeto Signos        |\n" +
                            "|______________________________|\n" +
                            "|  1. Entrar como administrador|\n" +
                            "|  2. Cliente                  |\n" +
                            "|  3. Encerrar                 |\n" +
                            "|______________________________|\n" +
                            "   Digite uma opção:_");

            try {
                int opção = input.nextInt();

                switch (opção){
                    case 1: {
                        menuAdmin();
                    }break;
                    case 2: {
                        menucliente();
                    }break;
                    case 3: {
                        System.exit(0);
                    }
                    default:
                        System.out.println("Opção invalida tente novamente");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    private void menuAdmin() {
        while (true) {
            System.out.printf(
                    " ______________________________\n" +
                            "|        Projeto Signos        |\n" +
                            "|______________________________|\n" +
                            "|  1. Adicionar nova mensagem  |\n" +
                            "|  2. Limpar Mensagem do Signo |\n" +
                            "|  3. Limpar Todos Signos      |\n" +
                            "|  4. voltar                   |\n" +
                            "|  5. Sair                     |\n" +
                            "|______________________________|\n" +
                            "   Digite uma opção:_");

            try {
                int opção = input.nextInt();
                switch (opção){
                    case 1:{
                        menuAdicionarNewMsg();
                    }break;
                    case 2:{
                        menuLiparMsgSigno();
                    }
                    case 3:{
                        menuLimpar();
                    }
                    case 4:{
                        menu();
                    }
                    case 5 : System.exit(0);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    private void menuLimpar() {

        System.out.println("Tem certeza que deseja limpar Todas Mensagens ? \n" +
                "[S/N]");
        String opção = input.nextLine();
        if(opção.toUpperCase().equals("S")){
            try {
                stub.limparTodosSignos();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

    }

    private void menuLiparMsgSigno() {
        System.out.println("Insira o Signo que deseja Limpar");
        String signo = input.nextLine();
        try {
            stub.limparMsgDoSigno(signo.toUpperCase());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    private void menuAdicionarNewMsg(){
            while (true) {
                System.out.println("Insira o Signo que deseja adicionar a mensagem");
                String signo = input.nextLine();
                if (signosValidos.contains(signo.toUpperCase())) {
                    System.out.println("Insira a mensagem");
                    String msg = input.nextLine();
                    try {
                        stub.adicionarNewMsg(signo.toUpperCase(), msg);
                        break;
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
                else System.out.println("Signo incorreto tenta novamente");
            }

    }

    private void menucliente(){
        while (true) {
            System.out.print("Entre Com o signo ou 0 Para voltar\n");
            String signo = input.nextLine();
            if (signo.equals("0")) menu();
            else if(signosValidos.contains(signo.toUpperCase())) {


                try {
                    String resposta = stub.getMensagem(signo.toUpperCase());
                    System.out.println("Resposta: " + resposta);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
