package app.feedio.reel.service;

import app.feedio.reel.dto.CommentItemDto;
import app.feedio.reel.dto.response.ReelCommentResponse;
import app.feedio.reel.model.Reel;
import app.feedio.reel.model.ReelComment;
import app.feedio.reel.repository.ReelCommentRepository;
import app.feedio.reel.repository.ReelRepository;
import app.feedio.reel.transformer.ReelTransformer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ReelCommentService {


    @Autowired
    ReelCommentRepository reelCommentRepository;

    @Autowired
    ReelRepository reelRepository;

    public ReelCommentResponse getCommentList(Long reelId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Slice<ReelComment> reelCommentSlice = reelCommentRepository.findByReelId(reelId, pageable);
         List<CommentItemDto> commentItemDtoList = new ArrayList<>();

        for(ReelComment reelCmnt : reelCommentSlice.getContent()){
            commentItemDtoList.add(ReelTransformer.reelCommentTransformerToCommentItemdTO(reelCmnt));
        }

        return new ReelCommentResponse(commentItemDtoList, reelCommentSlice.isLast());

    }

    public CommentItemDto addComment(Long reelId, Long userId, String content){
        Reel reel = reelRepository.findById(reelId)
                .orElseThrow(() -> new RuntimeException("Reel not found"));
        ReelComment reelComment = new ReelComment();
        reelComment.setReelId(reelId);
        reelComment.setUserId(userId);
        reelComment.setContent(content);
        reelCommentRepository.save(reelComment);
         reel.setComments(reel.getComments()+1);
       return ReelTransformer.reelCommentTransformerToCommentItemdTO(reelComment);
    }

    public CommentItemDto deleteComment(Long reelId, Long userId, Long commentId){
        ReelComment reelComment = reelCommentRepository.findById(commentId)
                .orElseThrow(() -> new RuntimeException("Comment not found with id: " + commentId));

        if (!reelComment.getUserId().equals(userId)) {
            throw new RuntimeException("Unauthorized: You can only delete your own comments");
        }

        Reel reel = reelRepository.findById(reelId)
                .orElseThrow(() -> new RuntimeException("Reel not found with id: " + reelId));

        if (reel.getComments() > 0) {
            reel.setComments(reel.getComments() - 1);
        }

        reelCommentRepository.delete(reelComment);
        return ReelTransformer.reelCommentTransformerToCommentItemdTO(reelComment);
    }

}
