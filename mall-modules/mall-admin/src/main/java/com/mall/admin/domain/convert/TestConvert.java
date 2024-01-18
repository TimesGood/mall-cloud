package com.mall.admin.domain.convert;

import com.mall.admin.domain.vo.TestVo;
import com.mall.mbg.model.SmsHomeRecommendSubject;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TestConvert {
    TestConvert INSTANCE = Mappers.getMapper(TestConvert.class);

    TestVo convert(SmsHomeRecommendSubject smsHomeRecommendSubject);
}
