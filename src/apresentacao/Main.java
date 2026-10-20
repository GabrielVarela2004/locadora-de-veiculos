package apresentacao;

import dominio.Cliente;
import dominio.TipoCliente;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Maria", "123456789", TipoCliente.PESSOA_FISICA);
        System.out.println(cliente);
    }
}
