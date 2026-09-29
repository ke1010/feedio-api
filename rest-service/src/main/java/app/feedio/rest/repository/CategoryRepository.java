package app.feedio.rest.repository;

import app.feedio.rest.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {


    @Query(""" 
SELECT DISTINCT c 
        FROM rest_db r 
        JOIN r.categories c 
        WHERE r.id IN :restIds
        """)
    List<Category> findCategoryByRestId(@Param("restIds") List<Long> restIds);
}
