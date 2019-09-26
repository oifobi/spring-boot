package guru.springframework.converters;

import guru.springframework.commands.BeerTypeForm;
import guru.springframework.domain.BeerType;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class BeerTypeToBeerTypeForm implements Converter<BeerType, BeerTypeForm> {
    @Override
    public BeerTypeForm convert(BeerType beerType) {
        BeerTypeForm beerTypeForm = new BeerTypeForm();
        beerTypeForm.setBeerTypeId(beerType.getBeerTypeId());
        beerTypeForm.setBeerTypeName(beerType.getBeerTypeName());
        return beerTypeForm;
    }
}
