package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysStu;

/**
 * 学生Mapper接口
 * 
 * @author ruoyi
 * @date 2021-05-14
 */
public interface SysStuMapper 
{
    /**
     * 查询学生
     * 
     * @param id 学生ID
     * @return 学生
     */
    public SysStu selectSysStuById(Long id);

    /**
     * 查询学生列表
     * 
     * @param sysStu 学生
     * @return 学生集合
     */
    public List<SysStu> selectSysStuList(SysStu sysStu);

    /**
     * 新增学生
     * 
     * @param sysStu 学生
     * @return 结果
     */
    public int insertSysStu(SysStu sysStu);

    /**
     * 修改学生
     * 
     * @param sysStu 学生
     * @return 结果
     */
    public int updateSysStu(SysStu sysStu);

    /**
     * 删除学生
     * 
     * @param id 学生ID
     * @return 结果
     */
    public int deleteSysStuById(Long id);

    /**
     * 批量删除学生
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysStuByIds(String[] ids);
}
