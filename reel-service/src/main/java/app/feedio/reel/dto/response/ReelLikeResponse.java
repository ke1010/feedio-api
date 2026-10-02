package app.feedio.reel.dto.response;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class ReelLikeResponse {

    Long reelId;
    Long userId;
    boolean isLiked;
    int totalLikes;

}
