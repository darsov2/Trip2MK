package mk.ukim.finki.trip2mk.service.Impl;

import mk.ukim.finki.trip2mk.Dao.PlanoviDao;
import mk.ukim.finki.trip2mk.entities.Planovi;
import mk.ukim.finki.trip2mk.service.PlanoviService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanoviServiceImpl implements PlanoviService {

    private final PlanoviDao planoviDao;

    public PlanoviServiceImpl(PlanoviDao planoviDao) {
        this.planoviDao = planoviDao;
    }

    @Override
    public void create(boolean ekskurzija, String ime, int brDenovi) {
        planoviDao.create(new Planovi(ekskurzija, ime, brDenovi));
    }

    @Override
    public void delete(long id) {
        planoviDao.delete(findById(id));
    }

    @Override
    public void save(long id, boolean ekskurzija, String ime, int brDenovi) {
        Planovi plan = planoviDao.findById(id);
        plan.setIme(ime);
        plan.setBrDenovi(brDenovi);
        plan.setEkskurzija(ekskurzija);
        planoviDao.save(plan);
    }

    @Override
    public Planovi findById(long id) {
        return planoviDao.findById(id);
    }

    @Override
    public List<Planovi> findAll() {
        return planoviDao.findAll();
    }
}
