package guru.springframework.repositories;

import guru.springframework.domain.Man;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ManRepository extends CrudRepository<Man, Long> {
    @Query("select count(b) from Man b")
    List<?> findNumOfElems();
}
