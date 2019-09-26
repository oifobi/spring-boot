package guru.springframework.converters;

import guru.springframework.commands.BeerTypeForm;
import guru.springframework.domain.BeerType;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class BeerTypeFormToBeerType implements Converter<BeerTypeForm, BeerType> {
    @Override
    public BeerType convert(BeerTypeForm beerTypeForm) {
        BeerType beerType = new BeerType();
        if (beerTypeForm.getBeerTypeId() != null && !StringUtils.isEmpty(beerTypeForm.getBeerTypeName())) {
            beerType.setBeerTypeId(new Long(beerTypeForm.getBeerTypeId()));
        }
        beerType.setBeerTypeName(beerTypeForm.getBeerTypeName());
        return beerType;
    }
}