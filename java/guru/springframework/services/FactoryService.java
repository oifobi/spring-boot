package guru.springframework.services;

import guru.springframework.commands.FactoryForm;
import guru.springframework.domain.Factory;

import java.util.List;

public interface FactoryService {
    List<Factory> listAll();

    Factory getById(Long id);

    Factory saveOrUpdate(Factory factory);

    void deleteFactory(Long id);

    Factory saveOrUpdateFactoryForm(FactoryForm factoryForm);

    String numOfElems();

}
