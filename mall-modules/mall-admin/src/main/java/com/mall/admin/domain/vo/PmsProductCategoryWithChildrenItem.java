package com.mall.admin.domain.vo;

import com.mall.mbg.model.PmsProductCategory;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 包含子级分类的商品分类
 */
public class PmsProductCategoryWithChildrenItem extends PmsProductCategory {
    @Getter
    @Setter
    @ApiModelProperty("子级分类")
    private List<PmsProductCategory> children;
}
