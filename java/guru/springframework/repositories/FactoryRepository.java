package guru.springframework.repositories;

import guru.springframework.domain.Factory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FactoryRepository extends CrudRepository<Factory, Long> {
    @Query("select count(b) from Factory b")
    List<?> findNumOfElems();
}
