package br.edu.ifpb.servidor;

import br.edu.ifpb.IF.ObjetoRemotoBiblioteca_IF;

import java.net.IDN;
import java.rmi.RemoteException;

public class Servidor implements ObjetoRemotoBiblioteca_IF {
    private Biblioteca b = new Biblioteca();


    @Override
    public String buscarLivro(String Id) throws RemoteException {
        return b.buscarLivro(Id);
    }

    @Override
    public String cadastrarLivro(String Id, String Titulo, String Autor, String tipo, String preço) throws RemoteException {
        return b.cadastrarLivro(Id, Titulo, Autor, tipo, preço);
    }

    @Override
    public String removerLivro(String Id) throws RemoteException {
        return b.removerLivro(Id);
    }
}
