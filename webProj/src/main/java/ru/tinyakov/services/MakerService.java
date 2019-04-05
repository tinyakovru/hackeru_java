package ru.tinyakov.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.tinyakov.entity.Maker;
import ru.tinyakov.exceptions.MakerServicesException;
import ru.tinyakov.repository.IRepository;

import java.util.List;

@Component
public class MakerService implements IMakerServices {

    @Autowired
    private IRepository<Maker> repository;

    public void setRepository(IRepository<Maker> repository) {
        this.repository = repository;
    }

    @Override
    public List<Maker> get() {
        List<Maker> list = repository.get();
        return list;
    }

    @Override
    public Maker get(int id) {
        Maker maker = repository.get(id);
        return maker;
    }

    @Override
    public void insert(Maker maker) throws MakerServicesException {
        if (!repository.insert(maker))
            throw new MakerServicesException("Maker don't insert");
    }

    @Override
    public void delete(int id) throws MakerServicesException {
        if (!repository.delete(id))
            throw new MakerServicesException("Maker don't delete");
    }

    @Override
    public void update(Maker maker) throws MakerServicesException {
        if (!repository.update(maker))
            throw new MakerServicesException("Maker don't update");
    }
}
