package mk.ukim.finki.trip2mk.service.Impl;

import mk.ukim.finki.trip2mk.Dao.MislenjaDao;
import mk.ukim.finki.trip2mk.entities.Korisnici;
import mk.ukim.finki.trip2mk.entities.Mislenja;
import mk.ukim.finki.trip2mk.entities.Znamenitosti;
import mk.ukim.finki.trip2mk.service.MislenjaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MislenjaServiceImpl implements MislenjaService {
    private final MislenjaDao mislenjaDao;

    public MislenjaServiceImpl(MislenjaDao mislenjaDao) {
        this.mislenjaDao = mislenjaDao;
    }

    @Override
    public void create(int ocenka, String opis, Znamenitosti znamenitost, Korisnici korisnik) {
        Mislenja mislenje = new Mislenja(ocenka, opis, znamenitost, korisnik);
        mislenjaDao.create(mislenje);
    }

    @Override
    public void delete(long id) {
        mislenjaDao.delete(findById(id));
    }

    @Override
    public void save(long id, int ocenka, String opis, Znamenitosti znamenitost, Korisnici korisnik) {
        Mislenja mislenje = mislenjaDao.findById(id);
        mislenje.setKorisnik(korisnik);
        mislenje.setOpis(opis);
        mislenje.setOcenka(ocenka);
        mislenje.setZnamenitost(znamenitost);
        mislenjaDao.save(mislenje);
    }

    @Override
    public Mislenja findById(long id) {
        return null;
    }

    @Override
    public List<Mislenja> findAll() {
        return null;
    }

    @Override
    public List<Mislenja> findByCityId(Long id) {
        return mislenjaDao.findByCityId(id);
    }
}
