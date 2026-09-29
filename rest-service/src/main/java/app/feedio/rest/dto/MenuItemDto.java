package app.feedio.rest.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class MenuItemDto {

    String name;
    String description;
    int price;
    String imgUrl;
    double ratings;
    boolean isVeg;
}
