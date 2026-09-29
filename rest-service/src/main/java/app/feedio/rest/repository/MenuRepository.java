package app.feedio.rest.repository;

import app.feedio.rest.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {

    @Query("SELECT m FROM Menu m WHERE m.restaurant.id = :restId")
    List<Menu> findByRestId(@Param("restId") Long restId);
}
