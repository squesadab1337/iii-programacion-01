interface Transformable {
    void escalar(double factor);
    void rotar(double grados);
}

class Rectangulo implements Transformable {
    private double ancho;
    private double alto;

    public Rectangulo(double ancho, double alto) {
        this.ancho = ancho;
        this.alto = alto;
    }

    public void escalar(double factor) {
        ancho *= factor;
        alto *= factor;
        System.out.println("Rectangulo escalado: ancho = " + ancho + ", alto = " + alto);
    }

    public void rotar(double grados) {
        System.out.println("Rectangulo rotado " + grados + " grados");
    }
}

class Triangulo implements Transformable {
    private double base;
    private double altura;

    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    public void escalar(double factor) {
        base *= factor;
        altura *= factor;
        System.out.println("Triángulo escalado: base = " + base + ", altura = " + altura);
    }

    public void rotar(double grados) {
        System.out.println("Triángulo rotado " + grados + " grados");
    }
}

public class Main {
    public static void main(String[] args) {
        Transformable r = new Rectangulo(4, 2);
        Transformable t = new Triangulo(3, 5);

        r.escalar(2);
        r.rotar(45);

        t.escalar(0.5);
        t.rotar(90);
    }
}
