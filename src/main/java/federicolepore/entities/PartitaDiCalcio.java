package federicolepore.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "partite")
@NamedQuery(name = "get_patite_vinte_in_casa", query = "SELECT p FROM PartitaDiCalcio p WHERE p.numeroGolSquadraDiCasa > p.numeroGolSquadraOspite")
@NamedQuery(name = "get_partite_vinte_in_trasferta", query = "SELECT p FROM PartitaDiCalcio p WHERE p.numeroGolSquadraDiCasa > p.numeroGolSquadraOspite")
@NamedQuery(name = "get_partite_pareggiate", query = "SELECT p FROM PartitaDiCalcio p WHERE p.squadraVinccente=null")

public class PartitaDiCalcio extends Evento {

    @Column(nullable = false)
    private String squadraDiCasa;
    @Column(nullable = false)
    private String squadraOspite;
    private String squadraVincente;
    @Column(nullable = false)
    private int numeroGolSquadraDiCasa;
    @Column(nullable = false)
    private int numeroGolSquadraOspite;

    //  costruttori
    protected PartitaDiCalcio() {
    }

    public PartitaDiCalcio(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, Location location, String squadraDiCasa, String squadraOspite) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
        this.squadraDiCasa = squadraDiCasa;
        this.squadraOspite = squadraOspite;
    }

    //  getters/setters


    public String getSquadraDiCasa() {
        return squadraDiCasa;
    }

    public void setSquadraDiCasa(String squadraDiCasa) {
        this.squadraDiCasa = squadraDiCasa;
    }

    public String getSquadraOspite() {
        return squadraOspite;
    }

    public void setSquadraOspite(String squadraOspite) {
        this.squadraOspite = squadraOspite;
    }

    public String getSquadraVincente() {
        return squadraVincente;
    }

    public void setSquadraVincente(String squadraVincente) {
        this.squadraVincente = squadraVincente;
    }

    public int getNumeroGolSquadraDiCasa() {
        return numeroGolSquadraDiCasa;
    }

    public void setNumeroGolSquadraDiCasa(int numeroGolSquadraDiCasa) {
        this.numeroGolSquadraDiCasa = numeroGolSquadraDiCasa;
    }

    public int getNumeroGolSquadraOspite() {
        return numeroGolSquadraOspite;
    }

    public void setNumeroGolSquadraOspite(int numeroGolSquadraOspite) {
        this.numeroGolSquadraOspite = numeroGolSquadraOspite;
    }

    @Override
    public String toString() {
        return "PartitaDiCalcio{" +
                "squadraDiCasa='" + squadraDiCasa + '\'' +
                ", squadraOspite='" + squadraOspite + '\'' +
                ", squadraVincente='" + squadraVincente + '\'' +
                ", numeroGolSquadraDiCasa=" + numeroGolSquadraDiCasa +
                ", numeroGolSquadraOspite=" + numeroGolSquadraOspite +
                '}';
    }
}
