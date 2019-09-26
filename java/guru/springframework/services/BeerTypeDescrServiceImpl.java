package guru.springframework.services;

import guru.springframework.commands.BeerTypeDescrForm;
import guru.springframework.converters.BeerTypeDescrFormToBeerTypeDescr;
import guru.springframework.domain.BeerType;
import guru.springframework.domain.BeerTypeDescr;
import guru.springframework.repositories.BeerTypeDescrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BeerTypeDescrServiceImpl implements BeerTypeDescrService {
    private BeerTypeDescrRepository factoryRepository;
    private BeerTypeDescrFormToBeerTypeDescr factoryFormToFactory;

    @Autowired
    public BeerTypeDescrServiceImpl(BeerTypeDescrRepository factoryRepository, BeerTypeDescrFormToBeerTypeDescr factoryFormToFactory) {
        this.factoryFormToFactory = factoryFormToFactory;
        this.factoryRepository = factoryRepository;
    }


    @Override
    public List<BeerTypeDescr> listAll() {
        List<BeerTypeDescr> factories = new ArrayList<>();
        factoryRepository.findAll().forEach(factories::add); //fun with Java 8
        return factories;
    }

    @Override
    public BeerTypeDescr getById(Long id) {
        return factoryRepository.findById(id).orElse(null);
    }

    @Override
    public BeerTypeDescr saveOrUpdate(BeerTypeDescr factory) {
        factoryRepository.save(factory);
        return factory;
    }

    @Override
    public void deleteBeerTypeDescr(Long id) {
        factoryRepository.deleteById(id);

    }

    @Override
    public BeerTypeDescr saveOrUpdateBeerTypeDescrForm(BeerTypeDescrForm factoryForm) {
        BeerTypeDescr savedFactory = saveOrUpdate(factoryFormToFactory.convert(factoryForm));

        System.out.println("Saved Beer Type Description Id: " + savedFactory.getId());
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
