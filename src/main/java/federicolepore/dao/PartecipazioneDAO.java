package federicolepore.dao;

import federicolepore.entities.Partecipazione;
import federicolepore.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class PartecipazioneDAO {
    private EntityManager em;

    public PartecipazioneDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Partecipazione p) {
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();
            em.persist(p);
            t.commit();
            System.out.println("Partecipazione dell'evento: " + p.getEvento() + " per la persona: " + p.getPersona().getNome() + " salvata");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Partecipazione findById(long id) {
        Partecipazione p = em.find(Partecipazione.class, id);
        if (p == null) throw new NotFoundException(id);
        return p;
    }

    public void delete(long id) {
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();
            Partecipazione p = this.findById(id);
            if (p != null) {
                em.remove(p);
                t.commit();
                System.out.println("La partecipazione all'evento " + p.getEvento() + " per la persona " + p.getPersona().getNome() + " " + p.getPersona().getCognome() + " è stata eliminita");
            } else System.out.println("Impossibile trovare la partecipazione");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    

}
