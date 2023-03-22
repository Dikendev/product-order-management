package com.system.productorder.services;

import com.system.productorder.entities.Category;
import com.system.productorder.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findByid(Long id) {
        Optional<Category> obj = categoryRepository.findById(id);
        return obj.get();
    }


}
