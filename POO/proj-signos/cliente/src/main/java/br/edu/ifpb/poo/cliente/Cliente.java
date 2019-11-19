package br.edu.ifpb.poo.cliente;

import br.edu.ifpb.poo.servidor.objetoRemotoSignos_IF;

import javax.swing.*;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Cliente{
    private static objetoRemotoSignos_IF stub;
    private static Registry registry;

    public static void executarCliente(String host){
        try {
            registry = LocateRegistry.getRegistry(host);
            stub = (objetoRemotoSignos_IF) registry.lookup("signo");
        } catch (Exception e) {
            System.err.println("Cliente exception: " + e.toString());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws RemoteException {
        String Host = (args.length < 1) ? "localhost": args[0];

        while (true){
            executarCliente(Host);
            Scanner input = new Scanner(System.in);
            System.out.print("Digite um signo: ");
            String msg = input.nextLine();

            String resposta = stub.getMensagemSigno(msg.toUpperCase());
            System.out.println(resposta);
        }
    }
}
