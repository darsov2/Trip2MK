package mk.ukim.finki.trip2mk.service.Impl;

import mk.ukim.finki.trip2mk.Dao.KorisniciDao;
import mk.ukim.finki.trip2mk.entities.Korisnici;
import mk.ukim.finki.trip2mk.service.KorisniciService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KorisniciServiceImpl implements KorisniciService {

    private final KorisniciDao korisniciDao;

    public KorisniciServiceImpl(KorisniciDao korisniciDao) {
        this.korisniciDao = korisniciDao;
    }

    @Override
    public void create(String username, String password, String ime, String prezime, String telefonskiBroj, String email) {
        Korisnici korisnici  = new Korisnici(username, password, ime, prezime, telefonskiBroj, email);
        korisniciDao.create(korisnici);
    }

    @Override
    public void delete(long id) {
        korisniciDao.delete(findById(id));
    }

    @Override
    public void save(long id, String username, String password, String ime, String prezime, String telefonskiBroj, String email) {
        Korisnici korisnik = findById(id);
        korisnik.setUsername(username);
        korisnik.setPassword(password);
        korisnik.setIme(ime);
        korisnik.setPrezime(prezime);
        korisnik.setTelefonskiBroj(telefonskiBroj);
        korisnik.setEmail(email);
        korisniciDao.save(korisnik);
    }

    @Override
    public Korisnici findById(long id) {
        return korisniciDao.findById(id);
    }

    @Override
    public List<Korisnici> findAll() {
        return korisniciDao.findAll();
    }
}
