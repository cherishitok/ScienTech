package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.EmpQuerypackageMapper;
import com.ruoyi.system.domain.EmpQuerypackage;
import com.ruoyi.system.service.IEmpQuerypackageService;
import com.ruoyi.common.core.text.Convert;

/**
 * 订购关系查询Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-06-01
 */
@Service
public class EmpQuerypackageServiceImpl implements IEmpQuerypackageService 
{
    @Autowired
    private EmpQuerypackageMapper empQuerypackageMapper;

    /**
     * 查询订购关系查询
     * 
     * @param queId 订购关系查询ID
     * @return 订购关系查询
     */
    @Override
    public EmpQuerypackage selectEmpQuerypackageById(Long queId)
    {
        return empQuerypackageMapper.selectEmpQuerypackageById(queId);
    }

    /**
     * 查询订购关系查询列表
     * 
     * @param empQuerypackage 订购关系查询
     * @return 订购关系查询
     */
    @Override
    public List<EmpQuerypackage> selectEmpQuerypackageList(EmpQuerypackage empQuerypackage)
    {
        return empQuerypackageMapper.selectEmpQuerypackageList(empQuerypackage);
    }

    /**
     * 新增订购关系查询
     * 
     * @param empQuerypackage 订购关系查询
     * @return 结果
     */
    @Override
    public int insertEmpQuerypackage(EmpQuerypackage empQuerypackage)
    {
        return empQuerypackageMapper.insertEmpQuerypackage(empQuerypackage);
    }

    /**
     * 修改订购关系查询
     * 
     * @param empQuerypackage 订购关系查询
     * @return 结果
     */
    @Override
    public int updateEmpQuerypackage(EmpQuerypackage empQuerypackage)
    {
        return empQuerypackageMapper.updateEmpQuerypackage(empQuerypackage);
    }

    /**
     * 删除订购关系查询对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteEmpQuerypackageByIds(String ids)
    {
        return empQuerypackageMapper.deleteEmpQuerypackageByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除订购关系查询信息
     * 
     * @param queId 订购关系查询ID
     * @return 结果
     */
    @Override
    public int deleteEmpQuerypackageById(Long queId)
    {
        return empQuerypackageMapper.deleteEmpQuerypackageById(queId);
    }
}
