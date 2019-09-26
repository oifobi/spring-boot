package guru.springframework.services;

import guru.springframework.commands.BeerTypeHistoryForm;
import guru.springframework.domain.BeerTypeHistory;
import guru.springframework.repositories.BeerTypeHistoryRepository;

import java.util.List;

public interface BeerTypeHistoryService {
    List<BeerTypeHistory> listAll();

    BeerTypeHistory getByIdBeerTypeHistory(Long id);

    BeerTypeHistory saveOrUpdateBeerTypeHistory(BeerTypeHistory beerTypeHistory);

    void deleteBeerTypeHistory(Long id);

    BeerTypeHistory saveOrUpdateBeerTypeHistoryForm(BeerTypeHistoryForm beerTypeHistoryForm);

    String numOfElems();

}
