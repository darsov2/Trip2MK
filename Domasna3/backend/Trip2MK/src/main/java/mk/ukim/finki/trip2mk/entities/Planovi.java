package mk.ukim.finki.trip2mk.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Planovi {
    @Id
    @GeneratedValue
    private long planId;
    private boolean ekskurzija;
    private String ime;
    private int brDenovi;
    @ManyToMany
    @JoinTable(name = "planovi_stavki",
            joinColumns = @JoinColumn(name = "znamenitostId", foreignKey = @ForeignKey(name = "fk_planovi_planovi_stavki")),
            inverseJoinColumns = @JoinColumn(name = "planId", foreignKey = @ForeignKey(name = "fk_planovi_stavki_planovi")))
    private List<Znamenitosti> znamenitosti;

    public Planovi(boolean ekskurzija, String ime, int brDenovi) {
        this.ekskurzija = ekskurzija;
        this.brDenovi = brDenovi;
        this.ime = ime;
        this.znamenitosti = new ArrayList<>();
    }

    public Planovi() {
        this.znamenitosti = new ArrayList<>();
    }
}
