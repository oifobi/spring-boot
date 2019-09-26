package guru.springframework.Queries;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class GetJsonData<T> {
    private String filename;
    private final Class<T> typeParameterClass;

    public GetJsonData(String filename, Class<T> typeParameterClass){
        this.filename = filename;
        this.typeParameterClass = typeParameterClass;
    }

    public List<T> getData() {
        List<T> obj = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            byte[] jsonData = Files.readAllBytes(Paths.get(filename));
            List<T> beerTypes = mapper.readValue(jsonData, mapper.getTypeFactory().constructCollectionType(List.class, typeParameterClass));
            return beerTypes;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return obj;
    }
}
