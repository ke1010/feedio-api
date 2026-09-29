package app.feedio.rest.Transformer;

import app.feedio.rest.dto.MenuItemDto;
import app.feedio.rest.dto.RestMenuHeaderDto;
import app.feedio.rest.dto.response.MenuResponse;
import app.feedio.rest.model.Menu;
import app.feedio.rest.model.Restaurant;

import java.util.List;

public class MenuTransformer {


    public static MenuItemDto menuTransformerToMenuItemDto(Menu menu){
        return MenuItemDto.builder()
                .name(menu.getName())
                .description(menu.getDescription())
                .price(menu.getPrice())
                .imgUrl(menu.getImgUrl())
                .ratings(menu.getRatings())
                .isVeg(menu.isVeg())
                .build();

    }

    public static RestMenuHeaderDto restTransformerToRestMenuHeaderDto(Restaurant  restaurant, double distance, int eta){
        return RestMenuHeaderDto.builder()
                .restId(restaurant.getId())
                .restName(restaurant.getName())
                .restRating(restaurant.getRatings())
                .distanceKm(distance)
                .etaMins(eta+" mins")
                .address(restaurant.getAddress())
                .imgUrl(restaurant.getImgUrl())
                .build();

    }
}
