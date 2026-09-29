package app.feedio.rest.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RestaurantItemDto {

    Long id;
    String name;
    String address;
    double ratings;
    String imgUrl;
    double distanceKm;
    String eta;
}
