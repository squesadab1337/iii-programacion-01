
/**
 * Representa un cliente de un banco.
 */
class Cliente {
    private String nombre;
    private String dni;
    private String email;

    public Cliente(String nombre, String dni, String email) {
        this.nombre = nombre;
        this.dni = dni;
        this.email = email;
    }

    public String getDni() {
        return dni;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente)) return false;
        Cliente c = (Cliente) o;
        return dni.equals(c.dni);
    }

    public int hashCode() {
        return dni.hashCode();
    }

    public String toString() {
        return nombre + " (" + dni + ")";
    }
}

/**
 * Excepción para saldo insuficiente en una cuenta.
 */
class SaldoInsuficienteException extends Exception {
    public SaldoInsuficienteException(String mensaje) {
        super(mensaje);
    }
}

/**
 * Excepción para operaciones inválidas.
 */
class OperacionInvalidaException extends Exception {
    public OperacionInvalidaException(String mensaje) {
        super(mensaje);
    }
}

/**
 * Representa una cuenta bancaria.
 */
class CuentaBancaria {
    protected String iban;
    protected double saldo;
    protected Cliente titular;

    public CuentaBancaria(String iban, double saldo, Cliente titular) {
        this.iban = iban;
        this.saldo = saldo;
        this.titular = titular;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void depositar(double cantidad) throws OperacionInvalidaException {
        if(cantidad <= 0) throw new OperacionInvalidaException("Cantidad a depositar debe ser positiva");
        saldo += cantidad;
        System.out.println("Depositado: " + cantidad + ", nuevo saldo=" + saldo);
    }

    public void retirar(double cantidad) throws SaldoInsuficienteException, OperacionInvalidaException {
        if(cantidad <= 0) throw new OperacionInvalidaException("Cantidad a retirar debe ser positiva");
        if(cantidad > saldo) throw new SaldoInsuficienteException("Saldo insuficiente. Saldo actual=" + saldo);
        saldo -= cantidad;
        System.out.println("Retirado: " + cantidad + ", nuevo saldo=" + saldo);
    }

    public String toString() {
        return iban + " saldo=" + saldo + " titular=" + titular;
    }
}

/**
 * Cuenta de ahorro con interés.
 */
class CuentaAhorro extends CuentaBancaria {
    public CuentaAhorro(String iban, double saldo, Cliente titular) {
        super(iban, saldo, titular);
    }

    public double calcularInteres() {
        return saldo * 0.02;
    }

    public void operar() {
        System.out.println("Interés generado: " + calcularInteres());
    }
}

/**
 * Cuenta nómina con empresa asociada.
 */
class CuentaNomina extends CuentaBancaria {
    private String empresa;

    public CuentaNomina(String iban, double saldo, Cliente titular, String empresa) {
        super(iban, saldo, titular);
        this.empresa = empresa;
    }

    public void recibirNomina(double cantidad) {
        saldo += cantidad;
        System.out.println("Recibida nómina de " + empresa + ": +" + cantidad + ", saldo=" + saldo);
    }

    public void operar() {
        recibirNomina(1200);
    }
}

public class Main {
    public static void main(String[] args) {
        Cliente c1 = new Cliente("Sebas", "aaaaa", "1s@mail.com");
        CuentaBancaria cuenta = new CuentaBancaria("ES01", 500, c1);

        try {
            cuenta.depositar(200);
            cuenta.retirar(800);
        } catch (SaldoInsuficienteException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (OperacionInvalidaException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            cuenta.retirar(-50);
        } catch (SaldoInsuficienteException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (OperacionInvalidaException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
