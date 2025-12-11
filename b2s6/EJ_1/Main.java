import java.util.Date;

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

class Movimiento {
    private Date fecha;
    private double cantidad;
    private String concepto;

    public Movimiento(Date fecha, double cantidad, String concepto) {
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.concepto = concepto;
    }

    public void aplicar(CuentaBancaria cuenta) {
        cuenta.saldo += cantidad;
        System.out.println("Movimiento aplicado: " + concepto + " cantidad=" + cantidad + " en cuenta " + cuenta.iban);
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
        System.out.println("Recibida nómina de " + empresa + ": +" + cantidad + ", saldo=" + saldo);
    }

    public void operar() {
        recibirNomina(1200);
    }
}

class Main {
    public static void main(String[] args) {
        Cliente c1 = new Cliente("Sebas", "aaa", "1@mail.com");
        Cliente c2 = new Cliente("Sebastian", "bbb", "2@mail.com");

        CuentaBancaria ahorro = new CuentaAhorro("qwdq", 2000, c1);
        CuentaBancaria nomina = new CuentaNomina("dqdqd", 500, c2, "DATACorp");

        ahorro.operar();
        nomina.operar();

        Movimiento m1 = new Movimiento(new Date(), 300, "Depósito adicional");
        m1.aplicar(ahorro);
    }
}
