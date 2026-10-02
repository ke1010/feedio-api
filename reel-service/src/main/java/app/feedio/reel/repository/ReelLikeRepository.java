package app.feedio.reel.repository;

import app.feedio.reel.model.ReelLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface ReelLikeRepository extends JpaRepository<ReelLike, Long> {

    Optional<ReelLike> findByUserIdAndReelId(Long userId, Long reelId);

    @Query("SELECT rl.reelId FROM ReelLike rl WHERE rl.userId = :userId AND rl.reelId IN :reelIds AND rl.isLiked = true")
    Set<Long> findLikedReelIdsByUserIdAndReelIds(
            @Param("userId") Long userId,
            @Param("reelIds") List<Long> reelIds
    );
}
