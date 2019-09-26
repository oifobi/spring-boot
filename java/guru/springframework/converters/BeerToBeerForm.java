package guru.springframework.converters;

import guru.springframework.commands.BeerForm;
import guru.springframework.domain.Beer;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class BeerToBeerForm implements Converter<Beer, BeerForm> {
    @Override
    public BeerForm convert(Beer beer) {
        BeerForm beerForm = new BeerForm();
        beerForm.setId(beer.getId());
        beerForm.setDescription(beer.getDescription());
        beerForm.setAlc(beer.getAlc());
        beerForm.setBeerTypeId(beer.getBeerTypeId());
        beerForm.setCountry(beer.getCountry());
        beerForm.setManufacturerId(beer.getManufacturerId());
        beerForm.setName(beer.getName());
        beerForm.setPackagingTypeId(beer.getPackagingTypeId());
        return beerForm;
    }
}