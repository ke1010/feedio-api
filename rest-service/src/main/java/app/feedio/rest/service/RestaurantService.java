package app.feedio.rest.service;

import app.feedio.rest.Transformer.RestaurantTransformer;
import app.feedio.rest.dto.RestaurantItemDto;
import app.feedio.rest.model.Restaurant;
import app.feedio.rest.repository.RestaurantRepository;
import app.feedio.rest.util.LocationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;

    public List<RestaurantItemDto> getRestaurantList(double lat, double lng, int page, int size){
        Pageable pageable =  PageRequest.of(page, size);
        Page<Restaurant> restaurantList = restaurantRepository.findByIsActiveTrue(pageable);
        List<RestaurantItemDto> restaurantItemDtoList = new ArrayList<>();

        for(Restaurant restaurant : restaurantList){
            double distance = LocationUtil.calculateHaversineDistance(restaurant.getLatitude(), restaurant.getLongitude(), lat, lng);
            if ( distance <= 6) {
                restaurantItemDtoList.add(RestaurantTransformer.restaurantTransformerToRestaurantItemDto(restaurant, distance));
            }
        }
        return restaurantItemDtoList;
    }

    public List<Long> getNearbyRestaurantIds(double lat, double lng,int page, int size) {
        Pageable pageable =  PageRequest.of(page, size);
        Page<Restaurant> restaurantList = restaurantRepository.findByIsActiveTrue(pageable);
        List<Long> restIds = new  ArrayList<>();
        for(Restaurant restaurant : restaurantList){
            double distance = LocationUtil.calculateHaversineDistance(restaurant.getLatitude(), restaurant.getLongitude(), lat, lng);
            if(distance<=6){
                restIds.add(restaurant.getId());
            }
        }


return restIds;

    }
}
