import java.util.*;

interface Dibujable {
    void dibujar();
}

abstract class Figura implements Dibujable {
    protected double x;
    protected double y;

    public Figura(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

class Hexagono extends Figura {
    public Hexagono(double x, double y) {
        super(x, y);
    }

    public void dibujar() {
        System.out.println("Dibujando hexágono en (" + x + ", " + y + ")");
    }
}

class Trapecio extends Figura {
    public Trapecio(double x, double y) {
        super(x, y);
    }

    public void dibujar() {
        System.out.println("Dibujando trapecio en (" + x + ", " + y + ")");
    }
}

class Estrella extends Figura {
    public Estrella(double x, double y) {
        super(x, y);
    }

    public void dibujar() {
        System.out.println("Dibujando estrella en (" + x + ", " + y + ")");
    }
}

class SimuladorGrafico {
    private List<Figura> figuras;

    public SimuladorGrafico() {
        figuras = new ArrayList<>();
    }

    public void agregarFigura(Figura f) {
        figuras.add(f);
    }

    public void dibujarTodo() {
        for (Figura f : figuras) {
            f.dibujar();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        SimuladorGrafico sim = new SimuladorGrafico();
        sim.agregarFigura(new Hexagono(1, 2));
        sim.agregarFigura(new Trapecio(3, 4));
        sim.agregarFigura(new Estrella(5, 6));
        sim.dibujarTodo();
    }
}
