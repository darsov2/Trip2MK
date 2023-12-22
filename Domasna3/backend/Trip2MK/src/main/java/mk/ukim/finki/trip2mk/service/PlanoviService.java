package mk.ukim.finki.trip2mk.service;

import mk.ukim.finki.trip2mk.entities.Planovi;

import java.util.List;

public interface PlanoviService {
    void create(boolean ekskurzija, String ime, int brDenovi);
    void delete(long id);
    void save(long id, boolean ekskurzija, String ime, int brDenovi);

    Planovi findById(long id);
    List<Planovi> findAll();
}
