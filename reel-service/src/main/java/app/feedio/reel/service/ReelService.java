package app.feedio.reel.service;

import app.feedio.reel.dto.ReelItemDto;
import app.feedio.reel.dto.ReelResponse;
import app.feedio.reel.model.Reel;
import app.feedio.reel.repository.ReelRepository;
import app.feedio.reel.transformer.ReelTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReelService {

    @Autowired
    private ReelRepository reelRepository;

     public ReelResponse getReel(Long userId){
         Pageable pageable = PageRequest.of(0, 5);
         Page<Reel> reelPage = reelRepository.getReelList(pageable);
         List<ReelItemDto> reelItemDtoList = new ArrayList<>();
            for(Reel reel1 : reelPage.getContent()){
                reelItemDtoList.add(ReelTransformer.reelTransformerToReelItemdTO(reel1));
            }
            return new ReelResponse(reelItemDtoList, reelPage.isLast());

     }

}
