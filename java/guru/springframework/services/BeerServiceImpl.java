package guru.springframework.services;


import guru.springframework.commands.BeerForm;
import guru.springframework.converters.BeerFormToBeer;
import guru.springframework.domain.Beer;
import guru.springframework.repositories.BeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class BeerServiceImpl implements BeerService {
    private BeerRepository beerRepository;
    private BeerFormToBeer beerFormToBeer;

    @Autowired
    public BeerServiceImpl(BeerRepository beerRepository, BeerFormToBeer beerFormToBeer) {
        this.beerRepository = beerRepository;
        this.beerFormToBeer = beerFormToBeer;
    }


    @Override
    public List<Beer> listAll() {
        List<Beer> beers = new ArrayList<>();
        beerRepository.findAll().forEach(beers::add); //fun with Java 8
        return beers;
    }

    @Override
    public Beer getByIdBeer(Long id) {
        return beerRepository.findById(id).orElse(null);
    }

    @Override
    public Beer saveOrUpdateBeer(Beer beer) {
        beerRepository.save(beer);
        return beer;
    }

    @Override
    public void deleteBeer(Long id) {
        beerRepository.deleteById(id);

    }

    @Override
    public Beer saveOrUpdateBeerForm(BeerForm beerForm) {
        Beer savedBeer = saveOrUpdateBeer(beerFormToBeer.convert(beerForm));

        System.out.println("Saved Beer Id: " + savedBeer.getId());
        return savedBeer;
    }

    @Override
    public List<Beer> findMaxAlc() {
        List<Beer> beers = new ArrayList<Beer>();
        List<Object[]> res =  beerRepository.findMaxAlc();

        for (Object o[] : res) {
           // Beer id = (Beer) o[0];
           // Beer name  = (Beer) o[1];
           // Beer alc = (Beer) o[2];
            Beer obj = new Beer();
            obj.setName((String) o[0]); obj.setAlc((double) o[1]);
           // obj.setId(id.getId()); obj.setName(name.getName()); obj.setAlc(alc.getAlc());
            beers.add(obj);
        }

        return beers;
    }
}
