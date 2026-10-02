package app.feedio.reel.dto;


import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CommentItemDto {

    Long reelId;
    Long userId;
    String content;
    LocalDateTime createdAt;

}
