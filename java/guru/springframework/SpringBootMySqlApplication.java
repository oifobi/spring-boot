package guru.springframework;

import guru.springframework.Queries.GetJsonData;
import guru.springframework.Queries.GetXmlData;
import guru.springframework.domain.*;
import guru.springframework.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import java.util.List;


@SpringBootApplication
public class SpringBootMySqlApplication extends SpringBootServletInitializer {


    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringBootMySqlApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMySqlApplication.class, args);
    }


    @Bean
    public CommandLineRunner insertJsonFactory(FactoryRepository repository) {
        GetJsonData<Factory> objFactory = new GetJsonData<>("src/main/resources/inputJsonFactoryNew.txt", Factory.class);
        List<Factory> factories = (List<Factory>) (objFactory.getData());
        return (args) -> {
            for (int i = 0; i < factories.size(); i++) {
               repository.save(new Factory((Long) factories.get(i).getManufacturerId(), factories.get(i).getLocation() /*,
                        factories.get(i).getYearOfFoundation()*/));
            }
        };
    }

    @Bean
    public CommandLineRunner insertJsonPackaging(PackagingRepository repository) {
        GetJsonData<Packaging> objPackaging = new GetJsonData<>("src/main/resources/inputJsonPackaging.txt", Packaging.class);
        List<Packaging> packagings = (List<Packaging>) (objPackaging.getData());
        return (args) -> {
            for (int i = 0; i < packagings.size(); i++) {
                repository.save(new Packaging(packagings.get(i).getPackagingTypes()));
            }
        };
    }

    @Bean
    public CommandLineRunner insertJsonBeerTypeDescription(BeerTypeDescrRepository repository) {
        GetJsonData<BeerTypeDescr> objBeerTypeDescription = new GetJsonData<>("src/main/resources/inputJsonBeerTypeDescription.txt", BeerTypeDescr.class);
        List<BeerTypeDescr> beerTypeDescriptions = (List<BeerTypeDescr>) (objBeerTypeDescription.getData());
        return (args) -> {
            // save a couple of customers
            for (int i = 0; i < beerTypeDescriptions.size(); i++) {
                repository.save(new BeerTypeDescr((Long) beerTypeDescriptions.get(i).getBeerTypeId(), beerTypeDescriptions.get(i).getDescription()));
            }
        };
    }

    @Bean
    public CommandLineRunner insertJsonBeerTypeHistory(BeerTypeHistoryRepository repository) {
        GetJsonData<BeerTypeHistory> objBeerTypeHistory = new GetJsonData<>("src/main/resources/inputJsonBeerTypeHistory.txt", BeerTypeHistory.class);
        List<BeerTypeHistory> beerTypeHistories = (List<BeerTypeHistory>) (objBeerTypeHistory.getData());
        return (args) -> {
            // save a couple of customers
            for (int i = 0; i < beerTypeHistories.size(); i++) {
                repository.save(new BeerTypeHistory(beerTypeHistories.get(i).getBeerTypeId(), beerTypeHistories.get(i).getHistory()));
            }
        };
    }

    @Bean
    public CommandLineRunner insertJsonBeerType(BeerTypeRepository repository) {
        GetJsonData<BeerType> objBeerType = new GetJsonData<>("src/main/resources/inputJsonBeerType.txt", BeerType.class);
        List<BeerType> beerTypes = (List<BeerType>) (objBeerType.getData());
        return (args) -> {
            // save a couple of customers
            for (int i = 0; i < beerTypes.size(); i++) {
                repository.save(new BeerType(beerTypes.get(i).getBeerTypeName()));
            }
        };
    }

    @Bean
    public CommandLineRunner insertJsonManufacturer(ManRepository repository) {
        GetJsonData<Man> objManufacturer = new GetJsonData<>("src/main/resources/inputJsonManufacturer.txt", Man.class);
        List<Man> manufacturers = (List<Man>) (objManufacturer.getData());
        return (args) -> {
            // save a couple of customers
            for (int i = 0; i < manufacturers.size(); i++) {
                repository.save(new Man(manufacturers.get(i).getName()));
            }
        };
    }

    @Bean
    public CommandLineRunner insertJsonBeer(BeerRepository repository) {
        GetJsonData<Beer> objBeer = new GetJsonData<>("src/main/resources/inputJsonBeer.txt", Beer.class);
        List<Beer> beers = (List<Beer>) (objBeer.getData());
        return (args) -> {
            // save a couple of customers
            for (int i = 0; i < beers.size(); i++) {
                repository.save(new Beer(beers.get(i).getName(), beers.get(i).getDescription(), beers.get(i).getCountry(),
                        beers.get(i).getAlc(), (Long) beers.get(i).getBeerTypeId(), (Long) beers.get(i).getManufacturerId(), (Long) beers.get(i).getPackagingTypeId()));
            }
        };
    }


   /* @Bean
    public CommandLineRunner insertXmlBeer(BeerRepository repository) {
        GetXmlData<Beer> objXmlBeer = new GetXmlData<>("src/main/resources/inputXmlBeer.xml", Beer.class);
        List<Beer> beersXml = objXmlBeer.getData();
        return (args) -> {
            // save a couple of customers
            for(int i = 0; i < beersXml.size(); i++){
                repository.save(new Beer(beersXml.get(i).getName(), beersXml.get(i).getDescription(), beersXml.get(i).getCountry(),
                        beersXml.get(i).getAlc(), (Long) beersXml.get(i).getBeerTypeId(), (Long) beersXml.get(i).getManufacturerId(), (Long) beersXml.get(i).getPackagingTypeId()));
            }
        };
    }

    @Bean
    public CommandLineRunner insertXmlBeerType(BeerTypeRepository repository) {
        GetXmlData<BeerType> objXmlBeerType = new GetXmlData<>("src/main/resources/inputXmlBeerType.xml", BeerType.class);
        List<BeerType> beerTypes = objXmlBeerType.getData();
        return (args) -> {
            // save a couple of customers
            for(int i = 0; i < beerTypes.size(); i++){
                repository.save(new BeerType(beerTypes.get(i).getBeerTypeName()));
            }
        };
    }

    @Bean
    public CommandLineRunner insertXmlBeerTypeHistory(BeerTypeHistoryRepository repository) {
        GetXmlData<BeerTypeHistory> objXmlBeerTypeHistory = new GetXmlData<>("src/main/resources/inputXmlBeerTypeHistory.xml", BeerTypeHistory.class);
        List<BeerTypeHistory> beerTypeHistories = objXmlBeerTypeHistory.getData();
        return (args) -> {
            // save a couple of customers
            for(int i = 0; i < beerTypeHistories.size(); i++){
                repository.save(new BeerTypeHistory(beerTypeHistories.get(i).getBeerTypeId(), beerTypeHistories.get(i).getHistory()));
            }
        };
    }

    @Bean
    public CommandLineRunner insertXmlBeerTypeDescription(BeerTypeDescrRepository repository) {
        GetXmlData<BeerTypeDescr> objXmlBeerTypeDescription = new GetXmlData<>("src/main/resources/inputXmlBeerTypeDescription.xml", BeerTypeDescr.class);
        List<BeerTypeDescr> beerTypeDescriptions = objXmlBeerTypeDescription.getData();
        return (args) -> {
            // save a couple of customers
            for (int i = 0; i < beerTypeDescriptions.size(); i++) {
                repository.save(new BeerTypeDescr((Long) beerTypeDescriptions.get(i).getBeerTypeId(), beerTypeDescriptions.get(i).getDescription()));
            }
        };
    }

    @Bean
    public CommandLineRunner insertXmlManufacturer(ManRepository repository) {
        GetXmlData<Man> objXmlManufacturer = new GetXmlData<>("src/main/resources/inputXmlManufacturer.xml", Man.class);
        List<Man> manufacturers = objXmlManufacturer.getData();
        return (args) -> {
            // save a couple of customers
            for(int i = 0; i < manufacturers.size(); i++){
                repository.save(new Man(manufacturers.get(i).getName()));
            }
        };
    }

    @Bean
    public CommandLineRunner insertXmlPackaging(PackagingRepository repository) {
        GetXmlData<Packaging> objXmlPackaging = new GetXmlData<>("src/main/resources/inputXmlPackaging.xml", Packaging.class);
        List<Packaging> packagings = objXmlPackaging.getData();
        return (args) -> {
            // save a couple of customers
            for(int i = 0; i < packagings.size(); i++){
                repository.save(new Packaging(packagings.get(i).getPackagingTypes()));
            }
        };
    }*/

}