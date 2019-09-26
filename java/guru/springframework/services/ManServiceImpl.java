package guru.springframework.services;

import guru.springframework.commands.ManForm;
import guru.springframework.converters.ManFormToMan;
import guru.springframework.domain.Man;
import guru.springframework.repositories.ManRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ManServiceImpl implements ManService{
    private ManRepository factoryRepository;
    private ManFormToMan factoryFormToFactory;

    @Autowired
    public ManServiceImpl(ManRepository factoryRepository, ManFormToMan factoryFormToFactory){
        this.factoryFormToFactory = factoryFormToFactory;
        this.factoryRepository = factoryRepository;
    }


    @Override
    public List<Man> listAll() {
        List<Man> factories= new ArrayList<>();
        factoryRepository.findAll().forEach(factories::add); //fun with Java 8
        return factories;
    }

    @Override
    public Man getById(Long id) {
        return factoryRepository.findById(id).orElse(null);
    }

    @Override
    public Man saveOrUpdate(Man factory) {
        factoryRepository.save(factory);
        return factory;
    }

    @Override
    public void deleteMan(Long id) {
        factoryRepository.deleteById(id);

    }

    @Override
    public Man saveOrUpdateManForm(ManForm factoryForm) {
        Man savedFactory= saveOrUpdate(factoryFormToFactory.convert(factoryForm));

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
