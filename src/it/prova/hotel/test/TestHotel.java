package it.prova.hotel.test;

import it.prova.hotel.model.*;

public class TestHotel {
    public static void main(String[] args) {
        System.out.println("Hotel exercise");

        // creazione hotel
        Hotel hotel = Hotel.creaHotel("Hotel luxury", 5);
        System.out.println(hotel);

        // aggiungo stanze al hotel
        Stanza stanza1 = new Stanza(1, 100, hotel);
        Stanza stanza2 = new Stanza(102, 250, hotel);
        Stanza stanza3 = new Stanza(103, 300, hotel);

        hotel.aggiungiStanza(stanza1);
        hotel.aggiungiStanza(stanza2);
        hotel.aggiungiStanza(stanza3);

        System.out.println(hotel.getStanze());

        // Creaione dei clienti
        Cliente cliente1 = new Turista("Mario", "Rossi");
        Cliente cliente2 = new Rappresentante("Anna", "Bianchi");
        Cliente cliente3 = new Premio("Luigi", "Verdi");
        Cliente cliente4 = new Turista("Elisa", "Gialli");
        Cliente cliente5 = new Rappresentante("Paolo", "Blu");


        // Aggiungo clienti alle stanze
        stanza1.aggiungiClienteAStanza(cliente1);
        stanza1.aggiungiClienteAStanza(cliente2);
        stanza2.aggiungiClienteAStanza(cliente3);
        stanza2.aggiungiClienteAStanza(cliente4);
        stanza3.aggiungiClienteAStanza(cliente5);

        System.out.println("\nClienti stanza 1: " + stanza1.getClienti());
        System.out.println("Clienti stanza 2: " + stanza2.getClienti());
        System.out.println("Clienti stanza 3: " + stanza3.getClienti());

        // Effettuo il checkout per ogni stanza
        System.out.println("\n--- Checkout stanza 1 ---");
        int totaleStanza1 = stanza1.checkout();
        System.out.println("Totale stanza 1: " + totaleStanza1);

        System.out.println("\n--- Checkout stanza 2 ---");
        int totaleStanza2 = stanza2.checkout();
        System.out.println("Totale stanza 2: " + totaleStanza2);

        System.out.println("\n--- Checkout stanza 3 ---");
        int totaleStanza3 = stanza3.checkout();
        System.out.println("Totale stanza 3: " + totaleStanza3);

    }
}
