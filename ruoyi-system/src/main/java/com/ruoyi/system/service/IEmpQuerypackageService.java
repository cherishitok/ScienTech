package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.EmpQuerypackage;

/**
 * 订购关系查询Service接口
 * 
 * @author ruoyi
 * @date 2020-06-01
 */
public interface IEmpQuerypackageService 
{
    /**
     * 查询订购关系查询
     * 
     * @param queId 订购关系查询ID
     * @return 订购关系查询
     */
    public EmpQuerypackage selectEmpQuerypackageById(Long queId);

    /**
     * 查询订购关系查询列表
     * 
     * @param empQuerypackage 订购关系查询
     * @return 订购关系查询集合
     */
    public List<EmpQuerypackage> selectEmpQuerypackageList(EmpQuerypackage empQuerypackage);

    /**
     * 新增订购关系查询
     * 
     * @param empQuerypackage 订购关系查询
     * @return 结果
     */
    public int insertEmpQuerypackage(EmpQuerypackage empQuerypackage);

    /**
     * 修改订购关系查询
     * 
     * @param empQuerypackage 订购关系查询
     * @return 结果
     */
    public int updateEmpQuerypackage(EmpQuerypackage empQuerypackage);

    /**
     * 批量删除订购关系查询
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteEmpQuerypackageByIds(String ids);

    /**
     * 删除订购关系查询信息
     * 
     * @param queId 订购关系查询ID
     * @return 结果
     */
    public int deleteEmpQuerypackageById(Long queId);
}
