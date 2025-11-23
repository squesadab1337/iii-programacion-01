import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

class Cliente {
    public String nombre;
    public String apellido;
    public String email;
    
    Cliente(String nombre, String apellido, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;    
    }

    void crearFichero(String ubicacionFichero, String nombreFichero, String extensionFichero) {
        // dumps using filewriter
        nombre = this.nombre;
        apellido = this.apellido;
        email = this.email;
        // donde va el fichero
        ubicacionFichero = ubicacionFichero;
        // usando try-catch
        try (FileWriter fileWriter = new FileWriter(ubicacionFichero + nombreFichero + "." + extensionFichero)) {
            String datosCliente = nombre + " | " + apellido + " | " + email;
            // escribimos al fichero
            fileWriter.write(datosCliente);
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }   
    
}

public class EJ_1 {
    void main(String args[]) {
        // debug run
        Cliente cliente = new Cliente("Sebastian", "Quesada", "sebasw@usp.ceu.es");
        cliente.crearFichero("./", "SQ_DATOS", "txt");
    }
}