package app.feedio.rest.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PaginationDto {
    boolean hasMore;
    long lastPage;
}
