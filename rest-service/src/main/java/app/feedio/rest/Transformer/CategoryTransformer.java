package app.feedio.rest.Transformer;

import app.feedio.rest.dto.CategoryItemDto;
import app.feedio.rest.model.Category;

public class CategoryTransformer {


    public static CategoryItemDto categoryTransformerToCategoryItemDto(Category dishes){
        return CategoryItemDto.builder()
                .name(dishes.getName())
                .build();
    }
}
