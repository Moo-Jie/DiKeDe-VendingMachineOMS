package com.dkd.manage.service.impl;

import java.util.List;

import com.dkd.common.constant.ExceptionConstant;
import com.dkd.common.exception.base.BaseException;
import com.dkd.common.utils.DateUtils;
import com.dkd.manage.domain.Vo.RegionVO;
import com.dkd.manage.mapper.NodeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dkd.manage.mapper.RegionMapper;
import com.dkd.manage.domain.Region;
import com.dkd.manage.service.IRegionService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 区域管理Service业务层处理
 * 
 * @author RichDu
 * @date 2024-11-28
 */
@Transactional
@Service
public class RegionServiceImpl implements IRegionService 
{
    @Autowired
    private RegionMapper regionMapper;

    @Autowired
    private NodeMapper nodeMapper;
    /**
     * 查询区域管理
     * 
     * @param id 区域管理主键
     * @return 区域管理
     */
    @Override
    public Region selectRegionById(Long id)
    {
        return regionMapper.selectRegionById(id);
    }

    /**
     * 查询区域管理列表
     * 
     * @param region 区域管理
     * @return 区域管理
     */
    @Override
    public List<Region> selectRegionList(Region region)
    {
        return regionMapper.selectRegionList(region);
    }

    /**
     * 新增区域管理
     * 
     * @param region 区域管理
     * @return 结果
     */
    @Override
    public int insertRegion(Region region)
    {
        region.setCreateTime(DateUtils.getNowDate());
        return regionMapper.insertRegion(region);
    }

    /**
     * 修改区域管理
     * 
     * @param region 区域管理
     * @return 结果
     */
    @Override
    public int updateRegion(Region region)
    {
        region.setUpdateTime(DateUtils.getNowDate());
        return regionMapper.updateRegion(region);
    }

    /**
     * 批量删除区域管理
     * 
     * @param ids 需要删除的区域管理主键
     * @return 结果
     */
    @Override
    public int deleteRegionByIds(Long[] ids)
    {
        //判断该区域是否被使用
        for (Long id : ids) {
            if(nodeMapper.selectNodeByRegionId(id)>0)
                throw new BaseException(ExceptionConstant.REGION_HAS_NODE);
        }
        return regionMapper.deleteRegionByIds(ids);
    }

    /**
     * 删除区域管理信息
     * 
     * @param id 区域管理主键
     * @return 结果
     */
    @Override
    public int deleteRegionById(Long id)
    {
        //判断该区域是否被使用
        if(nodeMapper.selectNodeByRegionId(id)>0)
            throw new BaseException(ExceptionConstant.REGION_HAS_NODE);
        return regionMapper.deleteRegionById(id);
    }

    @Override
    public List<RegionVO> selectRegionVOList(Region region)
    {
        return regionMapper.selectRegionVOList(region);
    }
}
