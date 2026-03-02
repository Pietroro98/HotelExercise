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


    @Override
    public String toString() {
        return "Hotel{" +
                "ragioneSociale='" + ragioneSociale + '\'' +
                ", Stelle=" + Stelle +
                '}';
    }
}
