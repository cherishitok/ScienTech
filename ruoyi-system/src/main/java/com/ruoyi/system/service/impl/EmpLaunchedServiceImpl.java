package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.EmpLaunchedMapper;
import com.ruoyi.system.domain.EmpLaunched;
import com.ruoyi.system.service.IEmpLaunchedService;
import com.ruoyi.common.core.text.Convert;

/**
 * 爱音乐发起订购Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-05-26
 */
@Service
public class EmpLaunchedServiceImpl implements IEmpLaunchedService 
{
    @Autowired
    private EmpLaunchedMapper empLaunchedMapper;

    /**
     * 查询爱音乐发起订购
     * 
     * @param lauId 爱音乐发起订购ID
     * @return 爱音乐发起订购
     */
    @Override
    public EmpLaunched selectEmpLaunchedById(Long lauId)
    {
        return empLaunchedMapper.selectEmpLaunchedById(lauId);
    }

    /**
     * 查询爱音乐发起订购列表
     * 
     * @param empLaunched 爱音乐发起订购
     * @return 爱音乐发起订购
     */
    @Override
    public List<EmpLaunched> selectEmpLaunchedList(EmpLaunched empLaunched)
    {
        return empLaunchedMapper.selectEmpLaunchedList(empLaunched);
    }

    /**
     * 新增爱音乐发起订购
     * 
     * @param empLaunched 爱音乐发起订购
     * @return 结果
     */
    @Override
    public int insertEmpLaunched(EmpLaunched empLaunched)
    {
        return empLaunchedMapper.insertEmpLaunched(empLaunched);
    }

    /**
     * 修改爱音乐发起订购
     * 
     * @param empLaunched 爱音乐发起订购
     * @return 结果
     */
    @Override
    public int updateEmpLaunched(EmpLaunched empLaunched)
    {
        return empLaunchedMapper.updateEmpLaunched(empLaunched);
    }

    /**
     * 删除爱音乐发起订购对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteEmpLaunchedByIds(String ids)
    {
        return empLaunchedMapper.deleteEmpLaunchedByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除爱音乐发起订购信息
     * 
     * @param lauId 爱音乐发起订购ID
     * @return 结果
     */
    @Override
    public int deleteEmpLaunchedById(Long lauId)
    {
        return empLaunchedMapper.deleteEmpLaunchedById(lauId);
    }
}
