package federicolepore.entities;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "gare_di_atletica")
@NamedQuery(name = "gare_per_vincitore", query = "SELECT g FROM GaraDiAtletica g WHERE vincitore=:vincitore")
public class GaraDiAtletica extends Evento {

    @ManyToMany
    @JoinTable(name = "gara_persona", joinColumns = @JoinColumn(name = "gara_id"), inverseJoinColumns = @JoinColumn(name = "atleta_id"))
    private Set<Persona> atleti;

    @ManyToOne
    @JoinColumn(name = "vincitore")
    private Persona vincitore;

    public GaraDiAtletica() {
    }

    // fare riferimento al costruttore di evento
    public GaraDiAtletica(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, Location location) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
    }

    public Set<Persona> getAtleti() {
        return atleti;
    }

    public void setAtleti(Set<Persona> atleti) {
        this.atleti = atleti;
    }

    public Persona getVincitore() {
        return vincitore;
    }

    public void setVincitore(Persona vincitore) {
        this.vincitore = vincitore;
    }

    @Override
    public String toString() {
        return "GaraDiAtletica{" +
                "atleti=" + atleti +
                ", vincitore=" + vincitore +
                '}';
    }
}
