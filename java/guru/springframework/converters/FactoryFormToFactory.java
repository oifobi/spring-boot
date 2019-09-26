package guru.springframework.converters;

import guru.springframework.commands.FactoryForm;
import guru.springframework.domain.Factory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class FactoryFormToFactory implements Converter<FactoryForm, Factory> {
    @Override
    public Factory convert(FactoryForm factoryForm) {
        Factory factory = new Factory();
        if (factoryForm.getId() != null && !StringUtils.isEmpty(factoryForm.getLocation())) {
            factory.setId(new Long(factoryForm.getId()));
        }
        factory.setLocation(factoryForm.getLocation());
        factory.setManufacturerId(factoryForm.getManufacturerId());
        return factory;
    }
}
