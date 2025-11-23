import java.util.ArrayList;
import java.util.List;

class Banco {
    // Cliente hereda cuenta

    List<Cliente> clienteBanco;
    boolean entradaSistema = false; //
    int UUID;

    public Banco() {
        this.clienteBanco = new ArrayList<>();    
        this.UUID = -1;
    }

    /**
     * suma el cliente
     */

    boolean sumarCuentaCliente(Cliente cliente) {
        
        if (entradaSistema == false) {
            System.out.println("Alerta: Sistema Cerrado!");
            return false;
        }

        this.clienteBanco.add(cliente);
        System.out.println("Alerta: Cliente Sumado! UUID: " + ++this.UUID);
        return true;
    }

    /**
     * muestra las cuentas en el sistema
     */

    boolean mostrarCuentasClientes() {
        if (entradaSistema == false) {
            System.out.println("Alerta: Sistema Cerrado!");
            return false;
        }

    System.out.println("Alerta: Exportando Clientes!"); 
        for (int i=0; i < this.clienteBanco.size(); i++) {
            Cliente x = clienteBanco.get(i);
            System.out.println("Alerta: Detalles Cliente! UUID: " + i);
            x.info();
        }
        return true;

    }

    /**
     * cierra el sistema
     */
    boolean cerrarSistema() {
        if (entradaSistema == false) {
            System.out.println("Alerta: Sistema Cerrado!");
            return false;
        }

        this.clienteBanco = new ArrayList<>();
        this.entradaSistema = false;
        System.out.println("Alerta: Sistema Cerrado Con Exito");
        return true;

    }

    // TODO admin
    /**
     * abre el sistema
     */
    boolean abrirSistema() {
        this.entradaSistema = true;
        System.out.println("Alerta: Sistema Abierto Con Exito");

        if (entradaSistema == true) {
            this.clienteBanco = new ArrayList<>();
            return true;
        }
        return false;
    }
}
    /**
     * clase cuenta
     */
class Cuenta {
    char moneda = '$';
    void info() {
        System.out.println("| Moneda: " + moneda);
    }

}
    /**
     * clase cliente hereda cuenta
     */
class Cliente extends Cuenta {
    String cliente;

    Cliente(String cliente) {
        this.cliente = cliente;
    }

    @Override
    void info() {
        super.info();
        System.out.println("| Cliente: " + cliente);
    }

}

class MP {

    void main(String args[]) {

        Banco banco = new Banco();

        Cliente clienteA = new Cliente("Sebas");
        Cliente clienteB = new Cliente("Andrea");

        // primero abrimos sistema (default cerrado)
        banco.abrirSistema();
        // luego podemos libremente sumar cuentas
        banco.sumarCuentaCliente(clienteA);
        banco.sumarCuentaCliente(clienteB);
        // luego con el sistema abierto podemos ver los clientes (cuentas)
        banco.mostrarCuentasClientes();

        // probando funcionalidad
        banco.cerrarSistema();
        // tratamos de accionar con el sistema cerrado vemos que no nos deja
        banco.mostrarCuentasClientes();
        banco.sumarCuentaCliente(clienteB);
        banco.sumarCuentaCliente(clienteA);
        // abrimos
        banco.abrirSistema();
        Cliente clienteC = new Cliente("Pluto");
        // funciona sumar cliente ya que abrimos el sistema
        banco.sumarCuentaCliente(clienteC);
        // finalmente cerramos sistema como medida de seguridad
        banco.cerrarSistema();


    }

}
