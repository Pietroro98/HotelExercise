package it.prova.hotel.model;

public class Turista extends Cliente{
    public Turista(String nome, String cognome) {
        super(nome, cognome);
    }

    @Override
    public int sommaRealeDaPagare() {
        return 200;
    }
}
