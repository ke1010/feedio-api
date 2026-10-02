package app.feedio.reel.transformer;

import app.feedio.reel.dto.CommentItemDto;
import app.feedio.reel.dto.ReelItemDto;
import app.feedio.reel.model.Reel;
import app.feedio.reel.model.ReelComment;

public class ReelTransformer {

    public static ReelItemDto reelTransformerToReelItemdTO(Reel reel, boolean isLiked){
        return ReelItemDto.builder()
                .videoUrl(reel.getVideoUrl())
                .likes(reel.getLikes())
                .comments(reel.getComments())
                .caption(reel.getCaption())
                .isLiked(isLiked)
                .build();
    }

    public static CommentItemDto reelCommentTransformerToCommentItemdTO(ReelComment reelComment){
        return CommentItemDto.builder()
                .reelId(reelComment.getReelId())
                .userId(reelComment.getUserId())
                .content(reelComment.getContent())
                .build();
    }
}
