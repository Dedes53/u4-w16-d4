package federicolepore.entities;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;


@Entity
@Table(name = "eventi")

public abstract class Evento {

    @Id //obbligatorio, per dire che sarà la primary key della tabella
    @GeneratedValue // per far gestire al db la creazione del valore di evento_id
    private UUID id;

    private String titolo;
    private LocalDate dataEvento;
    private String descrizione;
    @Enumerated(EnumType.STRING)
    private TipoEvento tipoEvento;
    private int numeroMassimoPartecipanti;

    @ManyToOne
    @JoinColumn(name = "luogo_evento_id")
    private Location luogoEvento;

    @OneToMany(mappedBy = "evento", cascade = CascadeType.REMOVE)
    private List<Partecipazione> listaPartecipazioni;

    // costruttori
    protected Evento() {
        //per JPA
    }

    public Evento(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, Location location) {
        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.descrizione = descrizione;
        this.tipoEvento = tipoEvento;
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
        this.luogoEvento = location;
    }

    // getters
    public UUID getId() {
        return id;
    }

    public String getTitolo() {
        return titolo;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public int getNumeroMassimoPartecipanti() {
        return numeroMassimoPartecipanti;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", name='" + titolo + '\'' +
                ", data='" + dataEvento + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", studentType=" + tipoEvento + '\'' +
                ", numero massimo di partecipanti= " + numeroMassimoPartecipanti +
                ", location=" + luogoEvento +
                '}';
    }

}
