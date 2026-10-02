package app.feedio.reel.controller;

import app.feedio.reel.dto.response.ReelLikeResponse;

import app.feedio.reel.service.ReelLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1-reel")
public class ReelLikeController {


    @Autowired
    private ReelLikeService reelLikeService;

    @PostMapping("/like-reel/{reelId}")
    public ResponseEntity<ReelLikeResponse> likeReel(@PathVariable Long reelId,
                                                     @RequestParam Long userId) {

        return new ResponseEntity<>(reelLikeService.toggleLike(reelId, userId), HttpStatus.OK);
    }


    @PostMapping("/unlike-reel/{reelId}")
    public ResponseEntity<ReelLikeResponse> unlikeReel(@PathVariable Long reelId,
                                                     @RequestParam Long userId) {

        return new ResponseEntity<>(reelLikeService.toggleUnlike(reelId, userId), HttpStatus.OK);
    }


}
