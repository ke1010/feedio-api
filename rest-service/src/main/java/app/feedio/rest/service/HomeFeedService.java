package app.feedio.rest.service;

import app.feedio.rest.dto.*;
import app.feedio.rest.dto.response.HomeFeedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HomeFeedService {

    @Autowired
    RestaurantService restaurantService;

    @Autowired
    CategoryService categoryService;

    public HomeFeedResponse getHomeFeed(double lat, double lng, int page, int size){
        List<Long> nearbyRestIds = restaurantService.getNearbyRestaurantIds(lat, lng, page, size);
        List<CategoryItemDto> categoryItemDtoList = categoryService.getCategoryList(nearbyRestIds);
        List<RestaurantItemDto> restaurantItemDtoList= restaurantService.getRestaurantList(lat, lng, page, size );
        HeaderDto headerDto = new HeaderDto("Gajraula", "Hello ketan", true);
        PaginationDto paginationDto = new PaginationDto(restaurantItemDtoList.size() == size, page);
        List<SectionDto> sectionDtoList = new ArrayList<>();
        sectionDtoList.add(new SectionDto(1,"Carousel", categoryItemDtoList));
        sectionDtoList.add(new SectionDto(2,"RestaurantList", restaurantItemDtoList));
        return  new HomeFeedResponse(headerDto, sectionDtoList, paginationDto);
    }

}
