import java.util.*;

interface Dibujable {
    void dibujar();
}

interface Transformable {
    void escalar(double factor);
    void rotar(double grados);
}

class Figura implements Dibujable, Transformable {
    protected double posicionX;
    protected double posicionY;

    public Figura(double x, double y) {
        this.posicionX = x;
        this.posicionY = y;
    }

    public void dibujar() {}

    public void escalar(double factor) {}

    public void rotar(double grados) {}
}

class Circulo extends Figura {
    private double radio;

    public Circulo(double x, double y, double radio) {
        super(x, y);
        this.radio = radio;
    }

    public void dibujar() {
        System.out.println("Dibujando círculo en (" + posicionX + ", " + posicionY + ") radio = " + radio);
    }

    public void escalar(double factor) {
        radio *= factor;
        System.out.println("Escalando círculo a radio = " + radio);
    }

    public void rotar(double grados) {
        System.out.println("Rotando círculo " + grados + " grados");
    }
}

class Poligono extends Figura {
    private int lados;

    public Poligono(double x, double y, int lados) {
        super(x, y);
        this.lados = lados;
    }

    public void dibujar() {
        System.out.println("Dibujando polígono de " + lados + " lados en (" + posicionX + ", " + posicionY + ")");
    }

    public void escalar(double factor) {
        System.out.println("Escalando polígono por " + factor);
    }

    public void rotar(double grados) {
        System.out.println("Rotando polígono " + grados + " grados");
    }
}

class Linea extends Figura {
    private double largo;

    public Linea(double x, double y, double largo) {
        super(x, y);
        this.largo = largo;
    }

    public void dibujar() {
        System.out.println("Dibujando línea en (" + posicionX + ", " + posicionY + ") largo =" + largo);
    }

    public void escalar(double factor) {
        largo *= factor;
        System.out.println("Escalando línea a largo =" + largo);
    }

    public void rotar(double grados) {
        System.out.println("Rotando línea " + grados + " grados");
    }
}

public class Main {
    public static void aplicarTransformaciones(List<Transformable> lista) {
        for (Transformable t : lista) {
            t.escalar(1.5);
            t.rotar(45);
        }
    }

    public static void main(String[] args) {
        List<Figura> figuras = new ArrayList<>();
        figuras.add(new Circulo(2, 3, 5));
        figuras.add(new Poligono(0, 0, 6));
        figuras.add(new Linea(1, 1, 4));

        for (Figura f : figuras) {
            f.dibujar();
        }

        List<Transformable> transformables = new ArrayList<>(figuras);
        aplicarTransformaciones(transformables);
    }
}
