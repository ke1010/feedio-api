package app.feedio.reel.repository;

import app.feedio.reel.model.ReelComment;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReelCommentRepository extends JpaRepository<ReelComment, Long> {

    Slice<ReelComment> findByReelId(Long reelId, Pageable pageable);
}
