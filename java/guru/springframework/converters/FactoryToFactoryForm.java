package guru.springframework.converters;


import guru.springframework.commands.FactoryForm;
import guru.springframework.domain.Factory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class FactoryToFactoryForm implements Converter<Factory, FactoryForm> {

    @Override
    public FactoryForm convert(Factory factory) {
        FactoryForm factoryForm = new FactoryForm();
        factoryForm.setId(factory.getId());
        factoryForm.setLocation(factory.getLocation());
        factoryForm.setManufacturerId(factory.getManufacturerId());
        return factoryForm;
    }
}
