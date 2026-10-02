package app.feedio.reel.service;

import app.feedio.reel.dto.response.ReelLikeResponse;
import app.feedio.reel.model.Reel;
import app.feedio.reel.model.ReelLike;
import app.feedio.reel.repository.ReelLikeRepository;
import app.feedio.reel.repository.ReelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReelLikeService {

    @Autowired
    ReelLikeRepository reelLikeRepository;

    @Autowired
    ReelRepository reelRepository;

    public ReelLikeResponse toggleLike(Long reelId, Long userId) {
        Reel reel = reelRepository.findById(reelId)
                .orElseThrow(() -> new RuntimeException("Reel not found"+reelId));

        Optional<ReelLike> existingLike = reelLikeRepository.findByUserIdAndReelId(userId, reelId);
        if(existingLike.isPresent()) {
           ReelLike like = existingLike.get();
           if(!like.isLiked()) {
               like.setLiked(true);
               reel.setLikes(reel.getLikes() + 1);
                reelLikeRepository.save(like);
           }
        }else{

            ReelLike newLike = new ReelLike();
            newLike.setReelId(reelId);
            newLike.setLiked(true);
            newLike.setUserId(userId);
            reelLikeRepository.save(newLike);
            reel.setLikes(reel.getLikes() + 1);

        }

return new ReelLikeResponse(reelId, userId, true, reel.getLikes());
    }




   public ReelLikeResponse toggleUnlike(Long reelId, Long userId){
        Reel reel = reelRepository.findById(reelId)
                .orElseThrow(() -> new RuntimeException("Reel not found"+reelId));

        Optional<ReelLike> existingLike = reelLikeRepository.findByUserIdAndReelId(userId, reelId);
        if(existingLike.isPresent()) {
            ReelLike like = existingLike.get();
            if(like.isLiked()) {
                like.setLiked(false);
                reel.setLikes(Math.max(0, reel.getLikes() - 1));
                reelLikeRepository.save(like);
                reelRepository.save(reel);
            }
        }

return  new ReelLikeResponse(reelId,userId, false, reel.getLikes());
    }

}
