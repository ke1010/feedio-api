package app.feedio.rest.controller;

import app.feedio.rest.dto.response.MenuResponse;
import app.feedio.rest.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1-menu")
public class MenuController {

  @Autowired
  MenuService menuService;

  @GetMapping("/get-rest-menu/{restId}")
  public ResponseEntity<MenuResponse> getMenuList(@PathVariable Long restId,
                                                  @RequestParam("lat") double userLat,
                                                  @RequestParam("lng") double userLng){
      return new ResponseEntity<>(menuService.findMenuList(restId, userLat, userLng),  HttpStatus.OK);
  }

}
