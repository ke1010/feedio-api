package app.feedio.reel.service;

import app.feedio.reel.dto.ReelItemDto;
import app.feedio.reel.dto.ReelResponse;
import app.feedio.reel.model.Reel;
import app.feedio.reel.repository.ReelLikeRepository;
import app.feedio.reel.repository.ReelRepository;
import app.feedio.reel.transformer.ReelTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
public class ReelService {

    @Autowired
    private ReelRepository reelRepository;

    @Autowired
    private ReelLikeRepository reelLikeRepository;

     public ReelResponse getReel(Long userId){
         Pageable pageable = PageRequest.of(0, 5);
         Page<Reel> reelPage = reelRepository.findAll(pageable);
         List<ReelItemDto> reelItemDtoList = new ArrayList<>();
         List<Reel> reelList = reelPage.getContent();
         List<Long> reelIds = reelList.stream().map(Reel::getId).toList();
         Set<Long> likedReelIdSet = reelIds.isEmpty() ? Collections.emptySet()
                 : reelLikeRepository.findLikedReelIdsByUserIdAndReelIds(userId, reelIds);

         for(Reel reel1 : reelPage.getContent()){
             boolean isLiked = likedReelIdSet.contains(reel1.getId());
                reelItemDtoList.add(ReelTransformer.reelTransformerToReelItemdTO(reel1, isLiked));
            }
           return new ReelResponse(reelItemDtoList, reelPage.isLast());

     }

}
