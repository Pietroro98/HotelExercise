package it.prova.hotel.model;

public class Rappresentante extends Cliente{
    public Rappresentante(String nome, String cognome) {
        super(nome, cognome);
    }

    @Override
    public int sommaRealeDaPagare() {
        return (int) (stanza.getQuantoAPersona() * 0.8);
    }
}
