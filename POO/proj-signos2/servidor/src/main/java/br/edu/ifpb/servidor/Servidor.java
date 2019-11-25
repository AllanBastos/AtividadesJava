package br.edu.ifpb.servidor;

import br.edu.ifpb.persistencia.persistencia;
import br.edu.ifpb.signos_IF;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Servidor implements signos_IF{
    private Map<String, List<String>> mapaSignos;
    private persistencia arquivo = new persistencia();


    public Servidor(){
        mapaSignos = new HashMap<String, List<String>>();

        arquivo.atualizarMapa(mapaSignos);

    }


    @Override
    public String getMensagem(String umSigno) throws RemoteException {
        String MsgSigno;
        Random random = new Random();
        List<String> temp;
        temp = mapaSignos.get(umSigno);
        if (temp != null) {
            MsgSigno = temp.get((int) (Math.random() * temp.size()));
            return MsgSigno;
        }
        return "Signo inválido!";
    }


    @Override
    public void adicionarNewMsg(String Signo, String Mensagem) throws RemoteException {
        arquivo.adicionarMsg(Signo, Mensagem);
        arquivo.atualizarMapa(mapaSignos);
    }

    @Override
    public boolean limparMsgDoSigno(String signo) throws RemoteException {
        mapaSignos.remove(signo);
        return arquivo.atualizaArquivo(mapaSignos);
    }

    @Override
    public boolean limparTodosSignos() throws RemoteException {
        arquivo.limparlista();
        mapaSignos.clear();
        return true;
    }

    public static void main(String[] args) {
        try {
            Servidor obj = new Servidor();
            signos_IF stub = (signos_IF) UnicastRemoteObject.exportObject(obj, 0);
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("signo",stub);

            System.err.println("Servidor Pronto!");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }
    }
}

