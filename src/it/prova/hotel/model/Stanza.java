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

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    /**
     * Definisce la capienza massima di una stanza (quadrupla)
     * @return
     */
    public int capienzaMaxStanza(){
        return 4;
    }

    /**
     * Aggiunge un cliente alla stanza con controllo della capienza,
     * se durante iterazione, cliente era in u altra stanza lo rimuovo.
     * @param cliente
     */
    public void aggiungiClienteAStanza(Cliente cliente){
        if(cliente == null || clienti.size() >= capienzaMaxStanza()) {
            return ;
        }

        if(cliente.getStanza() != null && cliente.getStanza() != this) {
            cliente.getStanza().rimuoviClienteDaStanza(cliente);
        }

        clienti.add(cliente);
        cliente.setStanza(this);

    }

    public void rimuoviClienteDaStanza(Cliente cliente){
        if(cliente == null) {
            return ;
        }
        for (int i = 0; i < clienti.size(); i++) {
            if(clienti.get(i) == cliente) {
                clienti.remove(i);
                cliente.setStanza(null);
                return;
            }
        }
    }

    @Override
    public String toString() {
        return "Stanza{" +
                "numeroStanza=" + numeroStanza +
                ", quantoAPersona=" + quantoAPersona +
                '}';
    }
}
