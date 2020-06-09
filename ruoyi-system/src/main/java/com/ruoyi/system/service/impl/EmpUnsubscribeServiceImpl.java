package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.EmpUnsubscribeMapper;
import com.ruoyi.system.domain.EmpUnsubscribe;
import com.ruoyi.system.service.IEmpUnsubscribeService;
import com.ruoyi.common.core.text.Convert;

/**
 * 爱音乐退订Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-05-27
 */
@Service
public class EmpUnsubscribeServiceImpl implements IEmpUnsubscribeService 
{
    @Autowired
    private EmpUnsubscribeMapper empUnsubscribeMapper;

    /**
     * 查询爱音乐退订
     * 
     * @param unsubId 爱音乐退订ID
     * @return 爱音乐退订
     */
    @Override
    public EmpUnsubscribe selectEmpUnsubscribeById(Long unsubId)
    {
        return empUnsubscribeMapper.selectEmpUnsubscribeById(unsubId);
    }

    /**
     * 查询爱音乐退订列表
     * 
     * @param empUnsubscribe 爱音乐退订
     * @return 爱音乐退订
     */
    @Override
    public List<EmpUnsubscribe> selectEmpUnsubscribeList(EmpUnsubscribe empUnsubscribe)
    {
        return empUnsubscribeMapper.selectEmpUnsubscribeList(empUnsubscribe);
    }

    /**
     * 新增爱音乐退订
     * 
     * @param empUnsubscribe 爱音乐退订
     * @return 结果
     */
    @Override
    public int insertEmpUnsubscribe(EmpUnsubscribe empUnsubscribe)
    {
        return empUnsubscribeMapper.insertEmpUnsubscribe(empUnsubscribe);
    }

    /**
     * 修改爱音乐退订
     * 
     * @param empUnsubscribe 爱音乐退订
     * @return 结果
     */
    @Override
    public int updateEmpUnsubscribe(EmpUnsubscribe empUnsubscribe)
    {
        return empUnsubscribeMapper.updateEmpUnsubscribe(empUnsubscribe);
    }

    /**
     * 删除爱音乐退订对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteEmpUnsubscribeByIds(String ids)
    {
        return empUnsubscribeMapper.deleteEmpUnsubscribeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除爱音乐退订信息
     * 
     * @param unsubId 爱音乐退订ID
     * @return 结果
     */
    @Override
    public int deleteEmpUnsubscribeById(Long unsubId)
    {
        return empUnsubscribeMapper.deleteEmpUnsubscribeById(unsubId);
    }
}
