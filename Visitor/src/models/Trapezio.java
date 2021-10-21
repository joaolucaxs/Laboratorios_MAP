package src.models;

import src.visitors.Visitor;

import java.util.Objects;

public class Trapezio implements Forma {
    private double baseMaior;
    private double baseMenor;
    private double altura;

    public Trapezio(double baseMaior, double baseMenor, double altura) {
        this.baseMaior = baseMaior;
        this.baseMenor = baseMenor;
        this.altura = altura;
    }

    public double getBaseMaior() {
        return baseMaior;
    }

    public void setBaseMaior(double baseMaior) {
        this.baseMaior = baseMaior;
    }

    public double getBaseMenor() {
        return baseMenor;
    }

    public void setBaseMenor(double baseMenor) {
        this.baseMenor = baseMenor;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    @Override
    public double aceitarVisita(Visitor v) {
        return v.visitarTrapezio(this);
    }

    @Override
    public String toString() {
        return String.format("Trapezio{ baseMaior = %s, baseMenor = %s, altura = %s }", baseMaior, baseMenor, altura);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trapezio trapezio = (Trapezio) o;
        return Double.compare(trapezio.baseMaior, baseMaior) == 0 &&
                Double.compare(trapezio.baseMenor, baseMenor) == 0 &&
                Double.compare(trapezio.altura, altura) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseMaior, baseMenor, altura);
    }
}
