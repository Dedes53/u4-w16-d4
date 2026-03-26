package federicolepore.dao;

import federicolepore.entities.Persona;
import federicolepore.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class PersonaDAO {
    private EntityManager em;

    public PersonaDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Persona p) {
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();
            em.persist(p);
            t.commit();
            System.out.println(p.getNome() + " " + p.getCognome() + " salvato con successo");
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public Persona findById(long id) {
        Persona p = em.find(Persona.class, id);
        if (p == null) throw new NotFoundException(id);
        return p;
    }

    public void delete(long id) {
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();
            Persona p = this.findById(id);
            if (p != null) {
                em.remove(p);
                t.commit();
                System.out.println(p.getNome() + " è stato eliminato con successo");
            } else {
                System.out.println("Persona non trovata");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
