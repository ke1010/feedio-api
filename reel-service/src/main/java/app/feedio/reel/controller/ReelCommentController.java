package app.feedio.reel.controller;

import app.feedio.reel.dto.CommentItemDto;
import app.feedio.reel.dto.response.ReelCommentResponse;
import app.feedio.reel.service.ReelCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1-reel")
public class ReelCommentController {

    @Autowired
    ReelCommentService reelCommentService;


    @GetMapping("/get-comments/{reelId}")
    public ResponseEntity<ReelCommentResponse> getCommentList(@PathVariable Long reelId,
                                                              @RequestParam(defaultValue = "0") int page,
                                                              @RequestParam(defaultValue = "5")int size){

        return  new ResponseEntity<>(reelCommentService.getCommentList(reelId, page, size), HttpStatus.OK);
    }

    @PostMapping("/add-comment/{reelId}")
    public ResponseEntity<CommentItemDto> addNewComment(@PathVariable Long reelId,
                                                         @RequestParam Long userId,
                                                         @RequestParam String content){

        return  new ResponseEntity<>(reelCommentService.addComment(reelId, userId, content), HttpStatus.OK);
    }


    @DeleteMapping("/delete-comment/{commentId}")
    public ResponseEntity<CommentItemDto> deleteComment(
            @PathVariable Long commentId,
            @RequestParam Long reelId,
            @RequestParam Long userId) {
        CommentItemDto response = reelCommentService.deleteComment(commentId, reelId, userId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
