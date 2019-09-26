package guru.springframework.services;

import guru.springframework.commands.BeerTypeForm;
import guru.springframework.domain.BeerType;

import java.util.List;

public interface BeerTypeService {
    List<BeerType> listAll();

    BeerType getById(Long id);

    BeerType saveOrUpdate(BeerType beerType);

    void deleteBeerType(Long id);

    BeerType saveOrUpdateBeerTypeForm(BeerTypeForm beerTypeForm);

    String numOfElems();

}
