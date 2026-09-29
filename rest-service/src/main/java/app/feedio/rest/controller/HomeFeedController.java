package app.feedio.rest.controller;

import app.feedio.rest.dto.response.HomeFeedResponse;
import app.feedio.rest.service.HomeFeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1-home")
public class HomeFeedController {

  @Autowired
    HomeFeedService homeFeedService;

  @GetMapping("/get-home-data")
  public ResponseEntity<HomeFeedResponse> getHomeData(@RequestParam double lat,
                                                      @RequestParam double lng,
                                                      @RequestParam(defaultValue = "0") int page,
                                                      @RequestParam(defaultValue = "10") int size){

      return  new ResponseEntity<>(homeFeedService.getHomeFeed(lat, lng, page, size), HttpStatus.OK);
  }

}
