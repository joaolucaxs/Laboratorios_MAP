package src.models;

import src.visitors.Visitor;

import java.util.Objects;

public class Circulo implements Forma {
    private double raio;

    public Circulo(double raio) {
        this.raio = raio;
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }

    @Override
    public double aceitarVisita(Visitor v) {
        return v.visitarCirculo(this);
    }

    @Override
    public String toString() {
        return String.format("Circulo{ raio = %s }", raio);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circulo circulo = (Circulo) o;
        return Double.compare(circulo.raio, raio) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(raio);
    }
}
