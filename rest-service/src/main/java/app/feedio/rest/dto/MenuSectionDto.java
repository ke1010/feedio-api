package app.feedio.rest.dto;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class MenuSectionDto {

    private Integer sectionId;
    private String categoryName;
    private List<MenuItemDto> menuItemDto;
}
