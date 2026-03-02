package it.prova.hotel.model;

import java.util.ArrayList;
import java.util.List;

public class Stanza {
    private int numeroStanza;
    private int quantoAPersona;
    //hotel e  bidirezionale
    private Hotel hotel;

    private List<Cliente> clienti = new ArrayList<>();

    public Stanza(int numeroStanza, int quantoAPersona, Hotel hotel) {
        this.numeroStanza = numeroStanza;
        this.quantoAPersona = quantoAPersona;
        this.hotel = hotel;
    }

    public int getNumeroStanza() {
        return numeroStanza;
    }

    public void setNumeroStanza(int numeroStanza) {
        this.numeroStanza = numeroStanza;
    }

    public int getQuantoAPersona() {
        return quantoAPersona;
    }

    public void setQuantoAPersona(int quantoAPersona) {
        this.quantoAPersona = quantoAPersona;
    }

    public List<Cliente> getClienti() {
        return clienti;
    }

    public void setClienti(List<Cliente> clienti) {
        this.clienti = clienti;
    }

    @Override
    public String toString() {
        return "Stanza{" +
                "numeroStanza=" + numeroStanza +
                ", quantoAPersona=" + quantoAPersona +
                '}';
    }
}
