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


    /**
     * metodo che pasando la somma reale da pagare, successivamente poi rinmuove il cliente dalla stanza.
     * @param input
     * @return
     */
    public int checkout(Stanza input) {
        System.out.println("Effettuando il checkout della stanza n. " + input.getNumeroStanza());
        int totale = 0;
        for (Cliente cliente : input.getClienti()) {
            int daPagare = cliente.sommaRealeDaPagare(); // richiamo il metodo per il calcolo della somma reale da pagare
            System.out.println("Cliente: " + cliente.getNome() + " " + cliente.getCognome() +
                    " paga: " + daPagare);
            totale += daPagare;
        }
        // dopo il pagamento, svuoto la stanza
        input.getClienti().clear();
        System.out.println("Checkout completato. La stanza n. " + input.getNumeroStanza() + " è ora vuota.");

        return totale;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "ragioneSociale='" + ragioneSociale + '\'' +
                ", Stelle=" + Stelle +
                ", stanze=" + stanze +
                '}';
    }
}
