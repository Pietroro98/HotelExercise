package it.prova.hotel.model;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String ragioneSociale;
    private int Stelle;
    private List<Stanza> stanze = new ArrayList<>();

    public Hotel(String ragioneSociale, int stelle) {
        this.ragioneSociale = ragioneSociale;
        Stelle = stelle;
    }

    public String getRagioneSociale() {
        return ragioneSociale;
    }

    public void setRagioneSociale(String ragioneSociale) {
        this.ragioneSociale = ragioneSociale;
    }

    public int getStelle() {
        return Stelle;
    }

    public void setStelle(int stelle) {
        Stelle = stelle;
    }

    public List<Stanza> getStanze() {
        return stanze;
    }

    public void setStanze(List<Stanza> stanze) {
        this.stanze = stanze;
    }

    public static Hotel creaHotel(String ragioneSociale, int stelle) {
        return new Hotel(ragioneSociale, stelle);
    }

    public void aggiungiStanza(Stanza stanza) {
       if(stanza != null && !stanze.contains(stanza)) {
           stanze.add(stanza);
           stanza.setHotel(this);
       }
    }

    /**
     * Trova stanze disponibili basate su maxClienti e maxPrezzo
     * @param maxClienti massimo numero di clienti per stanza
     * @param maxPrezzo massimo prezzo per persona
     * @return lista di stanze disponibili
     */
    public List<Stanza> trovaStanzeDisponibili(int maxClienti, int maxPrezzo) {
        List<Stanza> stanzeDisponibili = new ArrayList<>();
        for (Stanza stanza : stanze) {
            if (stanza.getClienti().size() < maxClienti && stanza.getQuantoAPersona() <= maxPrezzo) {
                stanzeDisponibili.add(stanza);
            }
        }
        return stanzeDisponibili;
    }


    public int calcolaConto(Stanza input) {
        int sommaDaPagare = 0;
        for (Cliente cliente : input.getClienti()) {
            sommaDaPagare += cliente.sommaRealeDaPagare();
        }
        return sommaDaPagare;
    }


   /* public int checkout() {
        System.out.println("Effettuando il checkout della stanza n. " + );
        int totale = 0;

        for (Cliente cliente : clienti) {
            int daPagare = getHotel().calcolaConto(this);
            System.out.println("Cliente: " + cliente.getNome() + " " + cliente.getCognome() +
                    " paga: " + daPagare);
            totale += daPagare;

            //rimuovo il cliente dalla stanza
            cliente.setStanza(null);
        }

        // Svuoto la lista di clienti dalla stanza
        clienti.clear();
        return totale;
    }*/

    @Override
    public String toString() {
        return "Hotel{" +
                "ragioneSociale='" + ragioneSociale + '\'' +
                ", Stelle=" + Stelle +
                ", stanze=" + stanze +
                '}';
    }
}
