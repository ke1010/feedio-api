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

    List<CommentItemDto> commentItemDtoList;
    boolean isLast;

}
