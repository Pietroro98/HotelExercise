package it.prova.hotel.model;

public abstract class Cliente {
    protected String nome;
    protected String cognome;

   //stanza e bidirezionale
    protected Stanza stanza;
    public Cliente(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }

   public abstract int sommaRealeDaPagare();

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                '}';
    }
}
