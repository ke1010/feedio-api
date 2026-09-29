package app.feedio.rest.dto.response;

import app.feedio.rest.dto.MenuItemDto;
import app.feedio.rest.dto.MenuSectionDto;
import app.feedio.rest.dto.RestMenuHeaderDto;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class MenuResponse {

    private RestMenuHeaderDto restMenuHeaderDto;
 List<MenuSectionDto> menuSectionDto;


}
