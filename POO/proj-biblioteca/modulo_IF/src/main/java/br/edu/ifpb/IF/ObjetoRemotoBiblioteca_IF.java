package br.edu.ifpb.IF;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ObjetoRemotoBiblioteca_IF extends Remote {
    public String buscarLivro(String Id) throws RemoteException;
    public String cadastrarLivro(String Id, String Titulo, String Autor, String tipo, String preço) throws RemoteException;
    public String removerLivro(String Id) throws RemoteException;
}
