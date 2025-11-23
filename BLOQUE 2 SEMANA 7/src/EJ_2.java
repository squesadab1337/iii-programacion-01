import java.io.*;

class CuentaBancaria implements Serializable {
    String propietario;

    CuentaBancaria(String propietario) {
        this.propietario = propietario;
    }
}

class CuentaBancariaMovimiento implements Serializable {
    double movimiento;
    String remitente;

    CuentaBancariaMovimiento(double movimiento, String remitente) {
        this.movimiento = movimiento;
        this.remitente = remitente;
    }
}

public class EJ_2 {

    public static void main(String[] args) {

        // make accounts and movements
        CuentaBancaria CUENTA_BANCARIA_Q = new CuentaBancaria("Sebastian");
        CuentaBancariaMovimiento CUENTA_BANCARIA_MOVIMIENTO_Q = new CuentaBancariaMovimiento(100.0, "Bakery");

        CuentaBancaria CUENTA_BANCARIA_Z = new CuentaBancaria("Bakery");
        CuentaBancariaMovimiento CUENTA_BANCARIA_MOVIMIENTO_Z = new CuentaBancariaMovimiento(100.0, "Sebastian");

        try {
            ObjectOutputStream FICHERO_OUT = new ObjectOutputStream(new FileOutputStream("cuentas.dat"));
            // write to data
            FICHERO_OUT.writeObject(CUENTA_BANCARIA_Q);
            FICHERO_OUT.writeObject(CUENTA_BANCARIA_MOVIMIENTO_Q);
            // write to data 
            FICHERO_OUT.writeObject(CUENTA_BANCARIA_Z);
            FICHERO_OUT.writeObject(CUENTA_BANCARIA_MOVIMIENTO_Z);

            FICHERO_OUT.close();

        } catch (IOException exception) {
            exception.getMessage();
        }

        try {
            ObjectInputStream FICHERO_IN = new ObjectInputStream(new FileInputStream("cuentas.dat"));
            
            CuentaBancaria CUENTA_BANCARIA_IN_Q = (CuentaBancaria) FICHERO_IN.readObject();
            CuentaBancariaMovimiento CUENTA_BANCARIA_MOVIMIENTO_IN_Q = (CuentaBancariaMovimiento) FICHERO_IN.readObject();

            CuentaBancaria CUENTA_BANCARIA_IN_Z = (CuentaBancaria) FICHERO_IN.readObject();
            CuentaBancariaMovimiento CUENTA_BANCARIA_MOVIMIENTO_IN_Z = (CuentaBancariaMovimiento) FICHERO_IN.readObject();
            FICHERO_IN.close();

            System.out.println(CUENTA_BANCARIA_MOVIMIENTO_IN_Q.remitente + " -> " + CUENTA_BANCARIA_IN_Q.propietario + " $" + CUENTA_BANCARIA_MOVIMIENTO_IN_Q.movimiento);
            System.out.println(CUENTA_BANCARIA_MOVIMIENTO_IN_Z.remitente + " -> " + CUENTA_BANCARIA_IN_Z.propietario + " $" + CUENTA_BANCARIA_MOVIMIENTO_IN_Z.movimiento);

        } catch (IOException | ClassNotFoundException exception) {
            exception.getMessage();
        }
    }
}
