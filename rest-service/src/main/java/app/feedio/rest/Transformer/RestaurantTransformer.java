package app.feedio.rest.Transformer;

import app.feedio.rest.dto.RestaurantItemDto;
import app.feedio.rest.model.Restaurant;
import app.feedio.rest.util.LocationUtil;

public class RestaurantTransformer {

public static RestaurantItemDto restaurantTransformerToRestaurantItemDto(Restaurant restaurant, double distance) {
    return RestaurantItemDto
            .builder()
            .id(restaurant.getId())
            .name(restaurant.getName())
            .address(restaurant.getAddress())
            .ratings(restaurant.getRatings())
            .imgUrl(restaurant.getImgUrl())
            .distanceKm(distance)
            .eta(LocationUtil.estimateDeliveryTimeInMins(distance)+"min")
            .build();
}

}
