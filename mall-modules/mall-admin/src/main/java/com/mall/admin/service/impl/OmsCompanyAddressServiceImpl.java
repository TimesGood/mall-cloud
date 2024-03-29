package com.mall.admin.service.impl;

import com.mall.mbg.mapper.OmsCompanyAddressMapper;
import com.mall.mbg.model.OmsCompanyAddress;
import com.mall.mbg.model.OmsCompanyAddressExample;
import com.mall.admin.service.OmsCompanyAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 收货地址管理Service实现类
 */
@Service
public class OmsCompanyAddressServiceImpl implements OmsCompanyAddressService {
    @Autowired
    private OmsCompanyAddressMapper companyAddressMapper;
    @Override
    public List<OmsCompanyAddress> list() {
        return companyAddressMapper.selectByExample(new OmsCompanyAddressExample());
    }
}
