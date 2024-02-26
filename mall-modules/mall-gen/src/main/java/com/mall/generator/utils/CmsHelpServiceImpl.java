//package com.mall.generator.utils;
//
//import java.util.List;
//import com.ruoyi.common.utils.DateUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import com.mall.mapper.CmsHelpMapper;
//import com.mall.domain.CmsHelp;
//import com.mall.service.ICmsHelpService;
//import com.ruoyi.common.core.text.Convert;
//
///**
// * 帮助Service业务层处理
// *
// * @author test
// * @date 2024-02-22 10:48:06
// */
//@Service
//public class CmsHelpServiceImpl implements ICmsHelpService
//{
//    @Autowired
//    private CmsHelpMapper cmsHelpMapper;
//
//    /**
//     * 查询帮助
//     *
//     * @param id 帮助主键
//     * @return 帮助
//     */
//    @Override
//    public CmsHelp selectCmsHelpById(Long id)
//    {
//        return cmsHelpMapper.selectCmsHelpById(id);
//    }
//
//    /**
//     * 查询帮助列表
//     *
//     * @param cmsHelp 帮助
//     * @return 帮助
//     */
//    @Override
//    public List<CmsHelp> selectCmsHelpList(CmsHelp cmsHelp)
//    {
//        return cmsHelpMapper.selectCmsHelpList(cmsHelp);
//    }
//
//    /**
//     * 新增帮助
//     *
//     * @param cmsHelp 帮助
//     * @return 结果
//     */
//    @Override
//    public int insertCmsHelp(CmsHelp cmsHelp)
//    {
//        cmsHelp.setCreateTime(DateUtils.getNowDate());
//        return cmsHelpMapper.insertCmsHelp(cmsHelp);
//    }
//
//    /**
//     * 修改帮助
//     *
//     * @param cmsHelp 帮助
//     * @return 结果
//     */
//    @Override
//    public int updateCmsHelp(CmsHelp cmsHelp)
//    {
//        return cmsHelpMapper.updateCmsHelp(cmsHelp);
//    }
//
//    /**
//     * 批量删除帮助
//     *
//     * @param ids 需要删除的帮助主键
//     * @return 结果
//     */
//    @Override
//    public int deleteCmsHelpByIds(Long[] ids)
//    {
//
//        return cmsHelpMapper.deleteCmsHelpByIds(ids);
//    }
//
//    /**
//     * 删除帮助信息
//     *
//     * @param id 帮助主键
//     * @return 结果
//     */
//    @Override
//    public int deleteCmsHelpById(Long id)
//    {
//        return cmsHelpMapper.deleteCmsHelpById(id);
//    }
//}
