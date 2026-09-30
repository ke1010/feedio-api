package app.feedio.reel.dto;

import app.feedio.reel.model.Reel;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ReelResponse {

    List<ReelItemDto> reelItemDtos;
    boolean isLast;

}
