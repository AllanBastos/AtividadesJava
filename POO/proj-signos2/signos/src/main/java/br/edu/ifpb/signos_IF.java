package br.edu.ifpb;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface signos_IF extends Remote {
    public String getMensagem(String umSigno) throws RemoteException;
    public void adicionarNewMsg(String Signo, String Mensagem) throws RemoteException;
    public boolean limparMsgDoSigno(String signo) throws RemoteException;
    public boolean limparTodosSignos() throws RemoteException;
}
