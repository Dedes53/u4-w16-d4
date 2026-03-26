package federicolepore.dao;

import federicolepore.entities.Location;
import federicolepore.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class LocationDAO {
    private EntityManager em;

    public LocationDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Location l) {
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();
            em.persist(l);
            t.commit();
            System.out.println("La località " + l.getNome() + " salvata");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Location findById(long id) {
        Location l = em.find(Location.class, id);
        if (l == null) throw new NotFoundException(id);
        return l;
    }

    public void delete(long id) {
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();
            Location l = this.findById(id);
            if (l != null) {
                em.remove(l);
                t.commit();
                System.out.println("Location " + l.getNome() + " rimossa con successo");
            } else System.out.println("Location non trovata");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
