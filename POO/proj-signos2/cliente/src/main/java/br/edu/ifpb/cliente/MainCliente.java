package br.edu.ifpb.cliente;

public class MainCliente {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        String Host = (args.length < 1) ? "localhost": args[0];
        cliente.execultarCliente(Host);

        while (true){
            cliente.menu();
        }
    }
}
