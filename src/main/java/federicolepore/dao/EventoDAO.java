package federicolepore.dao;

import federicolepore.entities.Evento;
import federicolepore.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EventoDAO {
    private final EntityManager em;

    public EventoDAO(EntityManager em) {
        this.em = em;
    }


    public void saveEvento(Evento newEvento) {
        try {
            // 1 - creare la transazione
            EntityTransaction transaction = this.em.getTransaction();
            // 2 - parte la transazione
            transaction.begin();
            // 3 - aggiungiamo l'oggetto al PersistenceContext -> diventa managed
            em.persist(newEvento);
            // 4 - commit dell'oggetto -> diventa una nuova riga della nostra tabella
            transaction.commit();
            System.out.println("L' evento " + newEvento.getTitolo() + " è stato aggiunto");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public Evento getById(long eventoId) {
        Evento e = em.find(Evento.class, eventoId);
        if (e == null) throw new NotFoundException(eventoId);
        return e;
    }

    public void delete(long eventoId) {
        try {
            EntityTransaction transaction = this.em.getTransaction();
            transaction.begin();
            Evento e = this.getById(eventoId); //si ricicla il metodo per trovare l'id

            if (e != null) {
                em.remove(e);
                transaction.commit();
                System.out.println("L'evento " + e.getTitolo() + " è stato rimosso");
            } else {
                System.out.println("Evento non trovato");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
