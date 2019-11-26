package br.edu.ifpb.servidor;

import br.edu.ifpb.IF.ObjetoRemotoBiblioteca_IF;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class MainServidor {
    public static void main(String[] args) {
        try {
            Servidor obj = new Servidor();
            ObjetoRemotoBiblioteca_IF stub = (ObjetoRemotoBiblioteca_IF) UnicastRemoteObject.exportObject(obj, 0);
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("biblioteca",stub);

            System.err.println("Servidor Pronto!");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }


    }
}
