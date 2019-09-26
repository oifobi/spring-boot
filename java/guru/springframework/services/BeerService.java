package guru.springframework.services;

import guru.springframework.commands.BeerForm;
import guru.springframework.domain.Beer;

import java.util.List;

public interface BeerService {
    List<Beer> listAll();

    Beer getByIdBeer(Long id);

    Beer saveOrUpdateBeer(Beer beer);

    void deleteBeer(Long id);

    Beer saveOrUpdateBeerForm(BeerForm beerForm);

    List<Beer> findMaxAlc();

}
