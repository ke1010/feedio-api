package app.feedio.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class SectionDto {

    private int id;
    private String title;

    @JsonProperty("items")
    private List<?> items;


}
