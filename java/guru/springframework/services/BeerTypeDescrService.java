package guru.springframework.services;

import guru.springframework.commands.BeerTypeDescrForm;
import guru.springframework.domain.BeerTypeDescr;

import java.util.List;

public interface BeerTypeDescrService {
    List<BeerTypeDescr> listAll();

    BeerTypeDescr getById(Long id);

    BeerTypeDescr saveOrUpdate(BeerTypeDescr beerTypeDescr);

    void deleteBeerTypeDescr(Long id);

    BeerTypeDescr saveOrUpdateBeerTypeDescrForm(BeerTypeDescrForm beerTypeDescrForm);

    String numOfElems();
}
