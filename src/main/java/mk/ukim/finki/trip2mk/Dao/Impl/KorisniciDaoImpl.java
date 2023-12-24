package mk.ukim.finki.trip2mk.Dao.Impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import mk.ukim.finki.trip2mk.Dao.KorisniciDao;
import mk.ukim.finki.trip2mk.entities.Korisnici;
import org.hibernate.persister.entity.EntityPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KorisniciDaoImpl implements KorisniciDao {
    @PersistenceContext
    EntityManager em;
    @Override
    public void create(Korisnici korisnik) {
        em.persist(korisnik);
    }

    @Override
    public void delete(Korisnici korisnik) {
        em.remove(korisnik);
    }

    @Override
    public void save(Korisnici korisnik) {
        em.persist(korisnik);
    }

    @Override
    public Korisnici findById(long id) {
        return em.find(Korisnici.class, id);
    }

    @Override
    public List<Korisnici> findAll() {
        return em.createQuery("SELECT k FROM Korisnici k ORDER BY korisnikId").getResultList();
    }
}
