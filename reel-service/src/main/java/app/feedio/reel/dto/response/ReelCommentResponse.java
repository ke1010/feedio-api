package app.feedio.reel.dto.response;


import app.feedio.reel.dto.CommentItemDto;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ReelCommentResponse {

    boolean success;
    String message;
    List<CommentItemDto> commentList;
    boolean isLast;

}
