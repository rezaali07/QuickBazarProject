package com.example.quickbazar.Controller;

import com.example.quickbazar.Entity.SubCategory;
import com.example.quickbazar.Pojo.SubCategoryPojo;
import com.example.quickbazar.Service.SubCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("subCategory")
@RequiredArgsConstructor
public class SubCategoryController {

    private final SubCategoryService subCategoryService;

    @PostMapping("/save")
    public String saveSubCategory(@RequestBody SubCategoryPojo subCategoryPojo) throws IOException {
        subCategoryService.saveSubCategory(subCategoryPojo);
        return "Saved successfully";
    }

    @GetMapping("/findAll")
    public List<SubCategory> findAll() {
        return subCategoryService.findAll();
    }

    @GetMapping("/findById/{id}")
    public Optional<SubCategory> getItemById(@PathVariable("id") Integer id) {
        return subCategoryService.getSubCategoryById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteSubCategoryById(@PathVariable("id") Integer id) {
        subCategoryService.deleteSubCategoryById(id);
    }
}
