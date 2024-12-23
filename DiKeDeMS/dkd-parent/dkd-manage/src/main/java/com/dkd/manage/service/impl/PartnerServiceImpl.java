package com.dkd.manage.service.impl;

import java.util.List;

import com.dkd.common.constant.ExceptionConstant;
import com.dkd.common.exception.base.BaseException;
import com.dkd.common.utils.DateUtils;
import com.dkd.manage.domain.Vo.PartnerVO;
import com.dkd.manage.mapper.NodeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dkd.manage.mapper.PartnerMapper;
import com.dkd.manage.domain.Partner;
import com.dkd.manage.service.IPartnerService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 合作商管理Service业务层处理
 * 
 * @author RichDu
 * @date 2024-11-28
 */

@Transactional
@Service
public class PartnerServiceImpl implements IPartnerService 
{
    @Autowired
    private PartnerMapper partnerMapper;

    @Autowired
    private NodeMapper nodeMapper;
    /**
     * 查询合作商管理
     * 
     * @param id 合作商管理主键
     * @return 合作商管理
     */
    @Override
    public Partner selectPartnerById(Long id)
    {
        return partnerMapper.selectPartnerById(id);
    }

    /**
     * 查询合作商管理列表
     * 
     * @param partner 合作商管理
     * @return 合作商管理
     */
    @Override
    public List<Partner> selectPartnerList(Partner partner)
    {
        return partnerMapper.selectPartnerList(partner);
    }

    /**
     * 新增合作商管理
     * 
     * @param partner 合作商管理
     * @return 结果
     */
    @Override
    public int insertPartner(Partner partner)
    {
        partner.setCreateTime(DateUtils.getNowDate());
        return partnerMapper.insertPartner(partner);
    }

    /**
     * 修改合作商管理
     * 
     * @param partner 合作商管理
     * @return 结果
     */
    @Override
    public int updatePartner(Partner partner)
    {
        partner.setUpdateTime(DateUtils.getNowDate());
        return partnerMapper.updatePartner(partner);
    }

    /**
     * 批量删除合作商管理
     * 
     * @param ids 需要删除的合作商管理主键
     * @return 结果
     */
    @Override
    public int deletePartnerByIds(Long[] ids)
    {
        //判断是否有被使用的合作商
        for (Long id : ids) {
            if(nodeMapper.selectNodeByPartnerId(id)>0)
                throw new BaseException(ExceptionConstant.PARTNER_HAS_NODE);
        }
        return partnerMapper.deletePartnerByIds(ids);
    }

    /**
     * 查询合作商管理列表
     *
     * @param partner 合作商管理
     * @return 合作商管理
     */
    @Override
    public List<PartnerVO> selectPartnerVOList(Partner partner) {
        return partnerMapper.selectPartnerVOList(partner);
    }

    /**
     * 删除合作商管理信息
     * 
     * @param id 合作商管理主键
     * @return 结果
     */
    @Override
    public int deletePartnerById(Long id)
    {
        //判断是否有被使用的合作商
        if(nodeMapper.selectNodeByPartnerId(id)>0)
            throw new BaseException(ExceptionConstant.PARTNER_HAS_NODE);
        return partnerMapper.deletePartnerById(id);
    }
}
