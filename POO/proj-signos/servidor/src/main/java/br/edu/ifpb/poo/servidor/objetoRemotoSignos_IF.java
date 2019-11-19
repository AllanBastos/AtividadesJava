package br.edu.ifpb.poo.servidor;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface objetoRemotoSignos_IF extends Remote {
    public String getMensagemSigno(String umSigno) throws RemoteException;
}
