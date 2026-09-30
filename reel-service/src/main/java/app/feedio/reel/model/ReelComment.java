package app.feedio.reel.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ReelComment {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String content;
    int userId;
    Long reelId;

}
