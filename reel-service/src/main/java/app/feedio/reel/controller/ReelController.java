package app.feedio.reel.controller;

import app.feedio.reel.dto.ReelResponse;
import app.feedio.reel.service.ReelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1-reel")
public class ReelController {

  @Autowired
    ReelService reelService;

  @GetMapping("/get-reel/{userId}")
  public ResponseEntity<ReelResponse> getReels(@PathVariable Long userId){
    return new ResponseEntity<>(reelService.getReel(userId), HttpStatus.OK);
  }
}
