package guru.springframework.repositories;


import guru.springframework.domain.Packaging;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PackagingRepository extends CrudRepository<Packaging, Long> {
    @Query("select count(b) from Packaging b")
    List<?> findNumOfElems();
}
