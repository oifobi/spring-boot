package guru.springframework.services;

import guru.springframework.commands.FactoryForm;
import guru.springframework.converters.FactoryFormToFactory;
import guru.springframework.domain.Factory;
import guru.springframework.domain.Packaging;
import guru.springframework.repositories.FactoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FactoryServiceImpl implements FactoryService {
    private FactoryRepository factoryRepository;
    private FactoryFormToFactory factoryFormToFactory;

    @Autowired
    public FactoryServiceImpl(FactoryRepository factoryRepository, FactoryFormToFactory factoryFormToFactory){
        this.factoryFormToFactory = factoryFormToFactory;
        this.factoryRepository = factoryRepository;
    }


    @Override
    public List<Factory> listAll() {
        List<Factory> factories= new ArrayList<>();
        factoryRepository.findAll().forEach(factories::add); //fun with Java 8
        return factories;
    }

    @Override
    public Factory getById(Long id) {
        return factoryRepository.findById(id).orElse(null);
    }

    @Override
    public Factory saveOrUpdate(Factory factory) {
        factoryRepository.save(factory);
        return factory;
    }

    @Override
    public void deleteFactory(Long id) {
        factoryRepository.deleteById(id);

    }

    @Override
    public Factory saveOrUpdateFactoryForm(FactoryForm factoryForm) {
        Factory savedFactory= saveOrUpdate(factoryFormToFactory.convert(factoryForm));

        System.out.println("Saved Factory Id: " + savedFactory.getId());
        return savedFactory;
    }

    @Override
    public String numOfElems() {
        String str = "";
        List<String> res = (List<String>) factoryRepository.findNumOfElems();
        str = res.toString();
        str = str.replaceAll("\\[", "").replaceAll("\\]", "");
        return str;
    }
}
