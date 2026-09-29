package app.feedio.rest.service;

import app.feedio.rest.Transformer.MenuTransformer;
import app.feedio.rest.dto.MenuItemDto;
import app.feedio.rest.dto.MenuSectionDto;
import app.feedio.rest.dto.RestMenuHeaderDto;
import app.feedio.rest.dto.response.MenuResponse;
import app.feedio.rest.model.Menu;
import app.feedio.rest.model.Restaurant;
import app.feedio.rest.repository.MenuRepository;
import app.feedio.rest.repository.RestaurantRepository;
import app.feedio.rest.util.LocationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class MenuService {

    @Autowired
    MenuRepository menuRepository;

    @Autowired
    RestaurantRepository restaurantRepository;

    public MenuResponse findMenuList(Long restId, double userLat, double userLng) {
        Restaurant restaurant = restaurantRepository.findById(restId)
                .orElseThrow(() -> new RuntimeException("Restaurant not found with ID: " + restId));
        double distance = LocationUtil.calculateHaversineDistance(userLat, userLng, restaurant.getLatitude(), restaurant.getLongitude());
        int etaMins = LocationUtil.estimateDeliveryTimeInMins(distance);
        RestMenuHeaderDto restMenuHeaderDto = MenuTransformer.restTransformerToRestMenuHeaderDto(restaurant, distance, etaMins);
        List<Menu> menuList = menuRepository.findByRestId(restId);
        Map<String, List<MenuItemDto>> map = new LinkedHashMap<>();
        for (Menu menu : menuList) {
            String catName = (menu.getCategory()!=null)?menu.getCategory().getName():"Recommended";
            MenuItemDto menuItemDto = MenuTransformer.menuTransformerToMenuItemDto(menu);
            map.computeIfAbsent(catName, k -> new ArrayList<>()).add(menuItemDto);
        }
        List<MenuSectionDto> menuSectionDtoList = new ArrayList<>();
        int sectionId = 1;
        for(Map.Entry<String, List<MenuItemDto>> entry : map.entrySet()) {
            menuSectionDtoList.add(new MenuSectionDto(sectionId++, entry.getKey(), entry.getValue()));
        }

        return new  MenuResponse(restMenuHeaderDto, menuSectionDtoList);
    }

}
