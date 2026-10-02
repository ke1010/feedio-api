package app.feedio.reel.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ReelItemDto {

    String videoUrl;
    int likes;
    int comments;
    String caption;
    boolean isLiked;

}
