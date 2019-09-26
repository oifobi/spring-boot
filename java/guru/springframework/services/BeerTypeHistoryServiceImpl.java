package guru.springframework.services;


import guru.springframework.commands.BeerTypeHistoryForm;
import guru.springframework.converters.BeerTypeHistoryFormToBeerTypeHistory;
import guru.springframework.domain.BeerTypeHistory;
import guru.springframework.repositories.BeerTypeHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BeerTypeHistoryServiceImpl implements BeerTypeHistoryService {

    private BeerTypeHistoryRepository beerTypeHistoryRepository;
    private BeerTypeHistoryFormToBeerTypeHistory beerTypeHistoryFormToBeerTypeHistory;

    @Autowired
    public BeerTypeHistoryServiceImpl(BeerTypeHistoryRepository beerTypeHistoryRepository, BeerTypeHistoryFormToBeerTypeHistory beerTypeHistoryFormToBeerTypeHistory) {
        this.beerTypeHistoryRepository = beerTypeHistoryRepository;
        this.beerTypeHistoryFormToBeerTypeHistory = beerTypeHistoryFormToBeerTypeHistory;
    }


    @Override
    public List<BeerTypeHistory> listAll() {
        List<BeerTypeHistory> beerTypeHistories = new ArrayList<>();
        beerTypeHistoryRepository.findAll().forEach(beerTypeHistories::add); //fun with Java 8
        return beerTypeHistories;
    }

    @Override
    public BeerTypeHistory getByIdBeerTypeHistory(Long id) {
        return beerTypeHistoryRepository.findById(id).orElse(null);
    }

    @Override
    public BeerTypeHistory saveOrUpdateBeerTypeHistory(BeerTypeHistory beerTypeHistory) {
        beerTypeHistoryRepository.save(beerTypeHistory);
        return beerTypeHistory;
    }

    @Override
    public void deleteBeerTypeHistory(Long id) {
        beerTypeHistoryRepository.deleteById(id);

    }

    @Override
    public BeerTypeHistory saveOrUpdateBeerTypeHistoryForm(BeerTypeHistoryForm beerTypeHistoryForm) {
        BeerTypeHistory savedBeerTypeHistory = saveOrUpdateBeerTypeHistory(beerTypeHistoryFormToBeerTypeHistory.convert(beerTypeHistoryForm));

        System.out.println("Saved Beer Type History Id: " + savedBeerTypeHistory.getId());
        return savedBeerTypeHistory;
    }

    @Override
    public String numOfElems() {
        String str = "";
        List<String> res = (List<String>) beerTypeHistoryRepository.findNumOfElems();
        str = res.toString();
        str = str.replaceAll("\\[", "").replaceAll("\\]", "");
        return str;
    }
}
