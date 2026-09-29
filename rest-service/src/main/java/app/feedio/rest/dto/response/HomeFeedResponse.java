package app.feedio.rest.dto.response;

import app.feedio.rest.dto.HeaderDto;
import app.feedio.rest.dto.PaginationDto;
import app.feedio.rest.dto.SectionDto;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class HomeFeedResponse {

    HeaderDto headerDto;
    List<SectionDto> sectionDto;
    PaginationDto paginationDto;



}
