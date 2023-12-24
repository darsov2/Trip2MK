package mk.ukim.finki.trip2mk.Dao;

import mk.ukim.finki.trip2mk.entities.Korisnici;

import java.util.List;

public interface KorisniciDao {

    void create(Korisnici korisnik);
    void delete(Korisnici korisnik);
    void save(Korisnici korisnik);

    Korisnici findById(long id);
    List<Korisnici> findAll();

}
