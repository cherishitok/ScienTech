package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.EmpSubscribeMapper;
import com.ruoyi.system.domain.EmpSubscribe;
import com.ruoyi.system.service.IEmpSubscribeService;
import com.ruoyi.common.core.text.Convert;

/**
 * 爱音乐订购Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-05-26
 */
@Service
public class EmpSubscribeServiceImpl implements IEmpSubscribeService 
{
    @Autowired
    private EmpSubscribeMapper empSubscribeMapper;

    /**
     * 查询爱音乐订购
     * 
     * @param subId 爱音乐订购ID
     * @return 爱音乐订购
     */
    @Override
    public EmpSubscribe selectEmpSubscribeById(Long subId)
    {
        return empSubscribeMapper.selectEmpSubscribeById(subId);
    }

    /**
     * 查询爱音乐订购列表
     * 
     * @param empSubscribe 爱音乐订购
     * @return 爱音乐订购
     */
    @Override
    public List<EmpSubscribe> selectEmpSubscribeList(EmpSubscribe empSubscribe)
    {
        return empSubscribeMapper.selectEmpSubscribeList(empSubscribe);
    }

    /**
     * 新增爱音乐订购
     * 
     * @param empSubscribe 爱音乐订购
     * @return 结果
     */
    @Override
    public int insertEmpSubscribe(EmpSubscribe empSubscribe)
    {
        return empSubscribeMapper.insertEmpSubscribe(empSubscribe);
    }

    /**
     * 修改爱音乐订购
     * 
     * @param empSubscribe 爱音乐订购
     * @return 结果
     */
    @Override
    public int updateEmpSubscribe(EmpSubscribe empSubscribe)
    {
        return empSubscribeMapper.updateEmpSubscribe(empSubscribe);
    }

    /**
     * 删除爱音乐订购对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteEmpSubscribeByIds(String ids)
    {
        return empSubscribeMapper.deleteEmpSubscribeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除爱音乐订购信息
     * 
     * @param subId 爱音乐订购ID
     * @return 结果
     */
    @Override
    public int deleteEmpSubscribeById(Long subId)
    {
        return empSubscribeMapper.deleteEmpSubscribeById(subId);
    }
}
