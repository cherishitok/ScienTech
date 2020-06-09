package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.EmpSubscribe;

/**
 * 爱音乐订购Service接口
 * 
 * @author ruoyi
 * @date 2020-05-26
 */
public interface IEmpSubscribeService 
{
    /**
     * 查询爱音乐订购
     * 
     * @param subId 爱音乐订购ID
     * @return 爱音乐订购
     */
    public EmpSubscribe selectEmpSubscribeById(Long subId);

    /**
     * 查询爱音乐订购列表
     * 
     * @param empSubscribe 爱音乐订购
     * @return 爱音乐订购集合
     */
    public List<EmpSubscribe> selectEmpSubscribeList(EmpSubscribe empSubscribe);

    /**
     * 新增爱音乐订购
     * 
     * @param empSubscribe 爱音乐订购
     * @return 结果
     */
    public int insertEmpSubscribe(EmpSubscribe empSubscribe);

    /**
     * 修改爱音乐订购
     * 
     * @param empSubscribe 爱音乐订购
     * @return 结果
     */
    public int updateEmpSubscribe(EmpSubscribe empSubscribe);

    /**
     * 批量删除爱音乐订购
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteEmpSubscribeByIds(String ids);

    /**
     * 删除爱音乐订购信息
     * 
     * @param subId 爱音乐订购ID
     * @return 结果
     */
    public int deleteEmpSubscribeById(Long subId);
}
