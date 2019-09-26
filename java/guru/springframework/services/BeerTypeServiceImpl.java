package guru.springframework.services;

import guru.springframework.commands.BeerTypeForm;
import guru.springframework.converters.BeerTypeFormToBeerType;
import guru.springframework.domain.BeerType;
import guru.springframework.repositories.BeerTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BeerTypeServiceImpl implements BeerTypeService {
    private BeerTypeRepository beerTypeRepository;
    private BeerTypeFormToBeerType beerTypeFormToBeerType;

    @Autowired
    public BeerTypeServiceImpl(BeerTypeRepository beerTypeRepository, BeerTypeFormToBeerType beerTypeFormToBeerType) {
        this.beerTypeRepository = beerTypeRepository;
        this.beerTypeFormToBeerType = beerTypeFormToBeerType;
    }


    @Override
    public List<BeerType> listAll() {
        List<BeerType> beerTypes = new ArrayList<>();
        beerTypeRepository.findAll().forEach(beerTypes::add); //fun with Java 8
        return beerTypes;
    }

    @Override
    public BeerType getById(Long id) {
        return beerTypeRepository.findById(id).orElse(null);
    }

    @Override
    public BeerType saveOrUpdate(BeerType beerType) {
        beerTypeRepository.save(beerType);
        return beerType;
    }

    @Override
    public void deleteBeerType(Long id) {
        beerTypeRepository.deleteById(id);

    }

    @Override
    public BeerType saveOrUpdateBeerTypeForm(BeerTypeForm beerTypeForm) {
        BeerType savedBeerType = saveOrUpdate(beerTypeFormToBeerType.convert(beerTypeForm));

        System.out.println("Saved Beer Type Id: " + savedBeerType.getBeerTypeId());
        return savedBeerType;
    }

    @Override
    public String numOfElems() {
        String str = "";
        List<String> res = (List<String>) beerTypeRepository.findNumOfElems();
        str = res.toString();
        str = str.replaceAll("\\[", "").replaceAll("\\]", "");
        return str;
    }
}
