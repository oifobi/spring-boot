package guru.springframework.converters;

import guru.springframework.commands.BeerForm;
import guru.springframework.domain.Beer;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class BeerFormToBeer implements Converter<BeerForm, Beer> {
    @Override
    public Beer convert(BeerForm beerForm) {
        Beer beer = new Beer();
        if (beerForm.getId() != null && !StringUtils.isEmpty(beerForm.getCountry())) {
            beer.setId(new Long(beerForm.getId()));
        }
        beer.setDescription(beerForm.getDescription());
        beer.setAlc(beerForm.getAlc());
        beer.setCountry(beerForm.getCountry());
        beer.setBeerTypeId(beerForm.getBeerTypeId());
        beer.setManufacturerId(beerForm.getManufacturerId());
        beer.setName(beerForm.getName());
        beer.setPackagingTypeId(beerForm.getPackagingTypeId());
        return beer;
    }
}
