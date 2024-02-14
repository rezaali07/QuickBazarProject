package com.example.quickbazar.Pojo;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductPojo {


    private Integer id;

    @NotNull
    private Integer subCategoryId;

    @NotNull
    private Integer categoryId;

    @NotNull
    private String productName;

    @NotNull
    private String productBrand;

    @NotNull
    private String productCondition;

    @NotNull
    private String price;

    @NotNull
    private String address;

    @NotNull
    private String productDiscription;

    private String productImage; //


}
