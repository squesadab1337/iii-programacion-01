import java.util.*;

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

    public void operar() {}

    public String toString() {
        return iban + " saldo=" + saldo + " titular=" + titular;
    }
}

class CuentaAhorro extends CuentaBancaria {
    public CuentaAhorro(String iban, double saldo, Cliente titular) {
        super(iban, saldo, titular);
    }

    public double calcularInteres() {
        return saldo * 0.02;
    }

    public void operar() {
        System.out.println("Interés generado en " + iban + ": " + calcularInteres());
    }
}

class CuentaNomina extends CuentaBancaria {
    private String empresa;

    public CuentaNomina(String iban, double saldo, Cliente titular, String empresa) {
        super(iban, saldo, titular);
        this.empresa = empresa;
    }

    public void recibirNomina(double cantidad) {
        saldo += cantidad;
        System.out.println("Recibida nómina de " + empresa + " en " + iban + ": +" + cantidad);
    }

    public void operar() {
        recibirNomina(1200);
    }
}

public class Main {
    public static void main(String[] args) {
        Cliente c1 = new Cliente("Sebas", "42424", "1@mail.com");
        Cliente c2 = new Cliente("Sebastian", "56457", "2@mail.com");

        List<CuentaBancaria> cuentas = new ArrayList<>();
        cuentas.add(new CuentaAhorro("PDK", 434242342, c1));
        cuentas.add(new CuentaNomina("4RS", 838383, c2, "DataCorp"));

        for (CuentaBancaria c : cuentas) {
            c.operar();
        }
    }
}
