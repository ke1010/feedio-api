package app.feedio.reel.repository;

import app.feedio.reel.model.Reel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReelRepository extends JpaRepository<Reel, Long> {


}
