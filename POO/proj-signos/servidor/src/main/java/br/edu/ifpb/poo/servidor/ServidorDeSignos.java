package br.edu.ifpb.poo.servidor;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

public class ServidorDeSignos implements objetoRemotoSignos_IF {

    private Map<String, List<String>> mapaSignos;

    public ServidorDeSignos() {
        mapaSignos = new HashMap<String, List<String>>();
        List<String> msgARIES = new ArrayList<String>();
        List<String> msgESCORPIAO = new ArrayList<String>();
        msgARIES.add("O dia continua tenso e você deve manter a calma e tentar retomar o equilíbrio. A Lua em Libra");
        msgARIES.add("Tome muito cuidado com gastos irracionais e investimentos de risco, pois pode haver perda e arrependimento. Você estará mais determinado e agressivo.");
        msgARIES.add("Se for comprometido, aproveite este período de queda da energia vital com assistindo a bons filmes e curtindo a intimidade junto de seu amor ou mesmo com os filhos.");
        msgESCORPIAO.add("Deve tomar cuidado com os excessos, especialmente de iniciativa, que pode atropelar egos mais frágeis.");
        msgESCORPIAO.add("Se puder, tire alguns dias para descansar e reavaliar seus planos de negócios e projetos.");
        msgESCORPIAO.add("O período pode envolver mal entendidos e atrasos em projetos ou pagamentos.");
        mapaSignos.put("ARIES", msgARIES);
        mapaSignos.put("ESCORPIAO", msgESCORPIAO);

    }

    public String getMensagemSigno(String umSigno) throws RemoteException {
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

    public static void main(String[] args) {
        try {
            ServidorDeSignos obj = new ServidorDeSignos();
            objetoRemotoSignos_IF stub = (objetoRemotoSignos_IF) UnicastRemoteObject.exportObject(obj, 0);
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
