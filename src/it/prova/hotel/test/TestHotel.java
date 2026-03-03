package it.prova.hotel.test;

import it.prova.hotel.model.*;

public class TestHotel {
    public static void main(String[] args) {
        System.out.println("Hotel exercise");

        // Creazione hotel
        Hotel hotel = Hotel.creaHotel("Hotel Luxury", 5);
        System.out.println(hotel);

        // Aggiungo stanze all'hotel
        Stanza stanza1 = new Stanza(101, 100, hotel);
        Stanza stanza2 = new Stanza(102, 200, hotel);
        Stanza stanza3 = new Stanza(103, 300, hotel);

        hotel.aggiungiStanza(stanza1);
        hotel.aggiungiStanza(stanza2);
        hotel.aggiungiStanza(stanza3);

        // Creazione clienti di tipi diversi
        Cliente turista1 = new Turista("Mario", "Rossi");
        Cliente turista2 = new Turista("Elena", "Verdi");
        Cliente rappresentante1 = new Rappresentante("Anna", "Bianchi");
        Cliente rappresentante2 = new Rappresentante("Paolo", "Blu");
        Cliente premio = new Premio("Clara", "Neri");

        // Aggiunta clienti a stanze con controllo di capienza
        stanza1.aggiungiClienteAStanza(turista1);
        stanza1.aggiungiClienteAStanza(rappresentante1);

        stanza2.aggiungiClienteAStanza(turista2);
        stanza2.aggiungiClienteAStanza(premio);

        stanza3.aggiungiClienteAStanza(rappresentante2);

        // Verifica iniziale dei clienti in ogni stanza
        System.out.println("\nClienti stanza 1: " + stanza1.getClienti());
        System.out.println("Clienti stanza 2: " + stanza2.getClienti());
        System.out.println("Clienti stanza 3: " + stanza3.getClienti());

        // Checkout clienti
        System.out.println("\n--- Checkout stanza 1 ---");
        int totaleStanza1 = hotel.calcolaConto(stanza1);
        int checkoutStanza1 = hotel.checkout(stanza1);

        System.out.println("Totale stanza 1: " + totaleStanza1);
        System.out.println("Checkout stanza 1 : " + checkoutStanza1);

        System.out.println("\n--- Checkout stanza 2 ---");
        int totaleStanza2 = hotel.calcolaConto(stanza2);
        int checkoutStanza2 = hotel.checkout(stanza2);
        System.out.println("Totale stanza 2: " + totaleStanza2);
        System.out.println("Checkout stanza 2 : " + checkoutStanza2);

        System.out.println("\n--- Checkout stanza 3 ---");
        int totaleStanza3 = hotel.calcolaConto(stanza3);
        int checkoutStanza3 = hotel.checkout(stanza3);
        System.out.println("Totale stanza 3: " + totaleStanza3);
        System.out.println("Checkout stanza 3 : " + checkoutStanza3);

        // Verifica delle stanze dopo il checkout (devono essere vuote)
        System.out.println("\nStato delle stanze dopo il checkout:");
        System.out.println("Clienti stanza 1: " + stanza1.getClienti());
        System.out.println("Clienti stanza 2: " + stanza2.getClienti());
        System.out.println("Clienti stanza 3: " + stanza3.getClienti());

        // Checkout di una stanza vuota
        System.out.println("\n--- Provo il checkout su una stanza vuota ---");
        int totaleVuota = hotel.calcolaConto(stanza1);
        int checkoutVuota = hotel.checkout(stanza1);
        System.out.println("Totale stanza vuota (stanza 1): " + totaleVuota);
        System.out.println("Checkout stanza 1 : " + checkoutVuota);

        // Raggiunta capienza massima
        System.out.println("\n--- Provo a riempire una stanza fino alla capienza massima ---");
        stanza1.aggiungiClienteAStanza(turista1);
        stanza1.aggiungiClienteAStanza(turista2);
        stanza1.aggiungiClienteAStanza(rappresentante1);
        stanza1.aggiungiClienteAStanza(rappresentante2);

        // Provo ad aggiungere un cliente extra, dovrebbe fallire per via della capienza max a 4 (quadrupla max)
        boolean clienteExtra = stanza1.aggiungiClienteAStanza(premio);
        System.out.println("Risultato atteso false:  " + clienteExtra);

        // Stampo i clienti della stanza per confermare
        System.out.println("Clienti stanza 1 dopo riempimento: " + stanza1.getClienti());

        // Aggiungo e poi rimuovo un cliente
        System.out.println("\n--- Rimuovo un cliente e ne aggiungo un altro ---");
        stanza1.rimuoviClienteDaStanza(turista1);
        stanza1.aggiungiClienteAStanza(premio);
        System.out.println("Clienti stanza 1 dopo rimozione e aggiunta: " + stanza1.getClienti());

        // Verifica finale delle stanze disponibili basata su criteri specifici
        System.out.println("\n--- Verifica finale: Trova stanze disponibili ---");
        int maxClientiFinale = 4;
        int maxPrezzoFinale = 300;
        System.out.println("Stanze disponibili (max clienti: " + maxClientiFinale + ", max prezzo: " + maxPrezzoFinale + "): " + hotel.trovaStanzeDisponibili(maxClientiFinale, maxPrezzoFinale));

        System.out.println("Fine test.");
    }
}
