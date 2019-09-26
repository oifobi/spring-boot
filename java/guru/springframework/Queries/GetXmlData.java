package guru.springframework.Queries;

import guru.springframework.domain.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class GetXmlData<T> {
    private String filename;
    private final Class<T> typeParameterClass;

    public GetXmlData(String filename, Class<T> typeParameterClass) {
        this.filename = filename;
        this.typeParameterClass = typeParameterClass;
    }

    public List getData() {
        try {
            JAXBContext context = JAXBContext.newInstance(typeParameterClass);
            Unmarshaller um = context.createUnmarshaller();
            List list = null;
            switch (filename) {
                case "inputXmlBeer.xml":
                    Beer obj1 = (Beer) um.unmarshal(new FileReader(filename));
                    list = obj1.getBeers();
                    return list;
                case "inputXmlBeerType.xml":
                    BeerType obj2 = (BeerType) um.unmarshal(new FileReader(filename));
                    list = obj2.getBeerTypesList();
                    return list;
                case "inputXmlBeerTypeHistory.xml":
                    BeerTypeHistory obj3 = (BeerTypeHistory) um.unmarshal(new FileReader(filename));
                    list = obj3.getBeerTypeHistories();
                    return list;
                case "inputXmlBeerTypeDescription.xml":
                    BeerTypeDescr obj4 = (BeerTypeDescr) um.unmarshal(new FileReader(filename));
                    list = obj4.getBeerTypeDescriptions();
                    return list;
                case "inputXmlManufacturer.xml":
                    Man obj5 = (Man) um.unmarshal(new FileReader(filename));
                    list = obj5.getManufacturers();
                    return list;
                case "inputXmlPackaging.xml":
                    Packaging obj6 = (Packaging) um.unmarshal(new FileReader(filename));
                    list = obj6.getPackagings();
                    return list;
                case "inputXmlFactory.xml":
                    Factory obj7 = (Factory) um.unmarshal(new FileReader(filename));
                    //list = obj7.getFactories();
                    return list;
                default:
                    break;
            }
            return null;
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}
