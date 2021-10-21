package src.model.source;

public class Onibus {
    private int numero;
    private String rota;
    private Cadeira[] cadeiras;
    
    public Onibus (int numero, String rota, int numeroCadeiras) {
        this.numero = numero;
        this.rota = rota;
        this.cadeiras = new Cadeira[numeroCadeiras];

        for (int i = 0; i < cadeiras.length; i++) {
            cadeiras[i] = new Cadeira();
        }
    }

    public int getNumero() {

        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getRota() {
        return this.rota;
    }
    public void setRota(String rota) {
        this.rota = rota;
    }

    public Cadeira[] getCadeiras() {
        return this.cadeiras;
    }
    public void setCadeiras(Cadeira[] cadeiras) {
        this.cadeiras = cadeiras;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Onibus onibus = (Onibus) o;
        return this.numero == onibus.getNumero();
    }
}

