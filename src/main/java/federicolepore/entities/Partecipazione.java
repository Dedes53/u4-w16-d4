package federicolepore.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "partecipazione")
public class Partecipazione {

    //  attributi
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "persona_id")
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;
    @Enumerated(EnumType.STRING)
    private Stato stato;


    //  costruttori
    protected Partecipazione() {
    }

    public Partecipazione(Persona persona, Evento evento) {
        this.persona = persona;
        this.evento = evento;
        this.stato = Stato.DA_CONFERMARE;
    }


    //  getters/setters
    public UUID getId() {
        return id;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Stato getStato() {
        return stato;
    }

    public void setStato(Stato stato) {
        this.stato = stato;
    }

    @Override
    public String toString() {
        return "Partecipazione{" +
                "id=" + id +
                ", persona=" + persona +
                ", evento=" + evento +
                ", stato=" + stato +
                '}';
    }


}
