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
        if (!(o instanceof Cliente)) return false; //
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
    private String iban;
    private double saldo;
    private Cliente titular;

    public CuentaBancaria(String iban, double saldo, Cliente titular) {
        this.iban = iban;
        this.saldo = saldo;
        this.titular = titular;
    }

    public Cliente getTitular() {
        return titular;
    }

    public String toString() {
        return "Cuenta " + iban + " saldo=" + saldo + " titular=" + titular;
    }
}

public class Main {
    public static CuentaBancaria buscarPorDni(List<CuentaBancaria> cuentas, String dni) {
        for (CuentaBancaria c : cuentas) {
            if (c.getTitular().getDni().equals(dni)) return c;
        }
        return null;
    }

    public static void main(String[] args) {
        Cliente c1 = new Cliente("Sebas", "A", "1@mail.com");
        Cliente c2 = new Cliente("Andrea", "B", "2@mail.com");

        List<CuentaBancaria> cuentas = new ArrayList<>();
        cuentas.add(new CuentaBancaria("AB01", 100, c1));
        cuentas.add(new CuentaBancaria("AB02", 100, c2));

        CuentaBancaria resultado = buscarPorDni(cuentas, "A");
        System.out.println(resultado);
    }
}
