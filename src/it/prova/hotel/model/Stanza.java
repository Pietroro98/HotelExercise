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
    public boolean aggiungiClienteAStanza(Cliente cliente){
        if(cliente == null || clienti.size() >= capienzaMaxStanza()) {
            return false;
        }

        if(cliente.getStanza() != null && cliente.getStanza() != this) {
            cliente.getStanza().rimuoviClienteDaStanza(cliente);
        }

        clienti.add(cliente);
        cliente.setStanza(this);

        return true;
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


    /**
     * Metodo per effettuare il checkout di una stanza:
     * - Calcola quanto deve pagare ogni cliente.
     * - Somma i totale dei pagamenti dei clienti.
     * - Rimuove tutti i clienti dalla stanza al termine,
     * quindi stanza ritorna disponibile.
     *
     * @return Il totale pagato per la stanza.
     */

    public int checkout() {
        System.out.println("Effettuando il checkout della stanza n. " + numeroStanza);
        int totale = 0;

        for (Cliente cliente : clienti) {
            int daPagare = cliente.sommaRealeDaPagare();
            System.out.println("Cliente: " + cliente.getNome() + " " + cliente.getCognome() +
                    " paga: " + daPagare);
            totale += daPagare;

            //rimuovo il cliente dalla stanza
            cliente.setStanza(null);
        }

        // Svuoto la lista di clienti dalla stanza
        clienti.clear();
        return totale;
    }

    @Override
    public String toString() {
        return "Stanza{" +
                "numeroStanza=" + numeroStanza +
                ", quantoAPersona=" + quantoAPersona +
                '}';
    }
}
