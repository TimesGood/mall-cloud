package com.mall.admin.domain.vo;

import com.mall.mbg.model.PmsProduct;
import com.mall.mbg.model.SmsFlashPromotionProductRelation;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 限时购商品信息封装
 */
public class SmsFlashPromotionProduct extends SmsFlashPromotionProductRelation{
    @Getter
    @Setter
    @ApiModelProperty("关联商品")
    private PmsProduct product;
}
