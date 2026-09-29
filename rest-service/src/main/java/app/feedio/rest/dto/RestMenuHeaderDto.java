package app.feedio.rest.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RestMenuHeaderDto {

    private Long restId;
    private String restName;
    private double restRating;
    private double distanceKm;
    private String etaMins;
    private String address;
    private String imgUrl;
}
