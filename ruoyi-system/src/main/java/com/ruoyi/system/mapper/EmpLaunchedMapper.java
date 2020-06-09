package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.EmpLaunched;

/**
 * 爱音乐发起订购Mapper接口
 * 
 * @author ruoyi
 * @date 2020-05-26
 */
public interface EmpLaunchedMapper 
{
    /**
     * 查询爱音乐发起订购
     * 
     * @param lauId 爱音乐发起订购ID
     * @return 爱音乐发起订购
     */
    public EmpLaunched selectEmpLaunchedById(Long lauId);

    /**
     * 查询爱音乐发起订购列表
     * 
     * @param empLaunched 爱音乐发起订购
     * @return 爱音乐发起订购集合
     */
    public List<EmpLaunched> selectEmpLaunchedList(EmpLaunched empLaunched);

    /**
     * 新增爱音乐发起订购
     * 
     * @param empLaunched 爱音乐发起订购
     * @return 结果
     */
    public int insertEmpLaunched(EmpLaunched empLaunched);

    /**
     * 修改爱音乐发起订购
     * 
     * @param empLaunched 爱音乐发起订购
     * @return 结果
     */
    public int updateEmpLaunched(EmpLaunched empLaunched);

    /**
     * 删除爱音乐发起订购
     * 
     * @param lauId 爱音乐发起订购ID
     * @return 结果
     */
    public int deleteEmpLaunchedById(Long lauId);

    /**
     * 批量删除爱音乐发起订购
     * 
     * @param lauIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteEmpLaunchedByIds(String[] lauIds);
}
