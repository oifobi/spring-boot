package guru.springframework.repositories;

import guru.springframework.domain.Beer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BeerRepository  extends CrudRepository<Beer, Long> {
    @Query("SELECT b.name, b.alc FROM Beer b where b.alc >= 8.0")
    List<Object[]> findMaxAlc();
}
