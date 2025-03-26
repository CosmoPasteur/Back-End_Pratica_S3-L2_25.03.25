package it.epicode;



import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("epicode");
        EntityManager em = emf.createEntityManager();

        EventoDAO eventoDAO = new EventoDAO(em);

        Evento evento = new Evento("Evento di prova", LocalDate.of(2024, 1, 1), "Descrizione evento di prova", "Type", 100);
        eventoDAO.save(evento);

        Evento eventoById = eventoDAO.getById(1L);
        System.out.println(eventoById);

        eventoDAO.delete(eventoById);

    }
}
//EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");
//EntityManager em = emf.createEntityManager();
//Evento evento = new Evento();