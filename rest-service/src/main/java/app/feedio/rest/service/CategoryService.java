package app.feedio.rest.service;

import app.feedio.rest.Transformer.CategoryTransformer;
import app.feedio.rest.dto.CategoryItemDto;
import app.feedio.rest.model.Category;
import app.feedio.rest.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public List<CategoryItemDto> getCategoryList(List<Long> restIds){
        if (restIds == null || restIds.isEmpty()) {
            return List.of();
        }
        List<Category> category = categoryRepository.findCategoryByRestId(restIds);
        List<CategoryItemDto> categoryItemDtoList = new ArrayList<>();
        for(Category cat : category){
          categoryItemDtoList.add(CategoryTransformer.categoryTransformerToCategoryItemDto(cat));
        }
        return categoryItemDtoList;
    }
}
