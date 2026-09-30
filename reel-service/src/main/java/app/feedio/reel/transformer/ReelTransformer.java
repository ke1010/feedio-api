package app.feedio.reel.transformer;

import app.feedio.reel.dto.ReelItemDto;
import app.feedio.reel.model.Reel;

public class ReelTransformer {

    public static ReelItemDto reelTransformerToReelItemdTO(Reel reel){
        return ReelItemDto.builder()
                .videoUrl(reel.getVideoUrl())
                .likes(reel.getLikes())
                .comments(reel.getComments())
                .caption(reel.getCaption())
                .build();
    }
}
