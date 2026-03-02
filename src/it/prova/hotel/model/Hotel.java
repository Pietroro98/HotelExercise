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

    @Override
    public String toString() {
        return "Hotel{" +
                "ragioneSociale='" + ragioneSociale + '\'' +
                ", Stelle=" + Stelle +
                ", stanze=" + stanze +
                '}';
    }
}
