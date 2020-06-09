package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.EmpUnsubscribe;

/**
 * 爱音乐退订Mapper接口
 * 
 * @author ruoyi
 * @date 2020-05-27
 */
public interface EmpUnsubscribeMapper 
{
    /**
     * 查询爱音乐退订
     * 
     * @param unsubId 爱音乐退订ID
     * @return 爱音乐退订
     */
    public EmpUnsubscribe selectEmpUnsubscribeById(Long unsubId);

    /**
     * 查询爱音乐退订列表
     * 
     * @param empUnsubscribe 爱音乐退订
     * @return 爱音乐退订集合
     */
    public List<EmpUnsubscribe> selectEmpUnsubscribeList(EmpUnsubscribe empUnsubscribe);

    /**
     * 新增爱音乐退订
     * 
     * @param empUnsubscribe 爱音乐退订
     * @return 结果
     */
    public int insertEmpUnsubscribe(EmpUnsubscribe empUnsubscribe);

    /**
     * 修改爱音乐退订
     * 
     * @param empUnsubscribe 爱音乐退订
     * @return 结果
     */
    public int updateEmpUnsubscribe(EmpUnsubscribe empUnsubscribe);

    /**
     * 删除爱音乐退订
     * 
     * @param unsubId 爱音乐退订ID
     * @return 结果
     */
    public int deleteEmpUnsubscribeById(Long unsubId);

    /**
     * 批量删除爱音乐退订
     * 
     * @param unsubIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteEmpUnsubscribeByIds(String[] unsubIds);
}
