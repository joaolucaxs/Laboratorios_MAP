package src.models;

import src.visitors.Visitor;

import java.util.Objects;

public class Retangulo implements Forma {
    private double base;
    private double altura;

    public Retangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    @Override
    public double aceitarVisita(Visitor v) {
        return v.visitarRetangulo(this);
    }

    @Override
    public String toString() {
        return String.format("Retangulo{ base = %s, altura = %s }", base, altura);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Retangulo retangulo = (Retangulo) o;
        return Double.compare(retangulo.base, base) == 0 &&
                Double.compare(retangulo.altura, altura) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(base, altura);
    }
}
