package com.johnnycarreiro.graphql.module.category;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class CategoryController {

  @Autowired
  private CategoryRepository categoryRepository;

  @MutationMapping()
  CategoryEntity addCategory(@Argument CategoryInput categoryInput) {
    var category = this.categoryRepository.save(new CategoryEntity(categoryInput.name));
    return category;
  }

  @QueryMapping()
  Optional<CategoryEntity> getCategoryById(@Argument UUID id) {
    var category = this.categoryRepository.findById(id);
    return category;
  }

  record CategoryInput(String name) {
  }
}
