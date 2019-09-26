package guru.springframework.converters;


import guru.springframework.commands.PackagingForm;
import guru.springframework.domain.Packaging;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PackagingToPackagingForm implements Converter<Packaging, PackagingForm> {
    @Override
    public PackagingForm convert (Packaging packaging){
        PackagingForm packagingForm= new PackagingForm();
        packagingForm.setPackagingTypeId(packaging.getPackagingTypeId());
        packagingForm.setPackagingTypes(packaging.getPackagingTypes());
        return packagingForm;
    }
}