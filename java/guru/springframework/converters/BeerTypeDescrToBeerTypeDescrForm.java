package guru.springframework.converters;

import guru.springframework.commands.BeerTypeDescrForm;
import guru.springframework.domain.BeerTypeDescr;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class BeerTypeDescrToBeerTypeDescrForm implements Converter<BeerTypeDescr, BeerTypeDescrForm> {
    @Override
    public BeerTypeDescrForm convert(BeerTypeDescr factory) {
        BeerTypeDescrForm factoryForm = new BeerTypeDescrForm();
        factoryForm.setId(factory.getId());
        factoryForm.setBeerTypeId(factory.getBeerTypeId());
        factoryForm.setDescription(factory.getDescription());
        return factoryForm;
    }
}
