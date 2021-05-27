package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysStuMapper;
import com.ruoyi.system.domain.SysStu;
import com.ruoyi.system.service.ISysStuService;
import com.ruoyi.common.core.text.Convert;

/**
 * 学生Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-05-14
 */
@Service
public class SysStuServiceImpl implements ISysStuService 
{
    @Autowired
    private SysStuMapper sysStuMapper;

    /**
     * 查询学生
     * 
     * @param id 学生ID
     * @return 学生
     */
    @Override
    public SysStu selectSysStuById(Long id)
    {
        return sysStuMapper.selectSysStuById(id);
    }

    /**
     * 查询学生列表
     * 
     * @param sysStu 学生
     * @return 学生
     */
    @Override
    public List<SysStu> selectSysStuList(SysStu sysStu)
    {
        return sysStuMapper.selectSysStuList(sysStu);
    }

    /**
     * 新增学生
     * 
     * @param sysStu 学生
     * @return 结果
     */
    @Override
    public int insertSysStu(SysStu sysStu)
    {
        return sysStuMapper.insertSysStu(sysStu);
    }

    /**
     * 修改学生
     * 
     * @param sysStu 学生
     * @return 结果
     */
    @Override
    public int updateSysStu(SysStu sysStu)
    {
        return sysStuMapper.updateSysStu(sysStu);
    }

    /**
     * 删除学生对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSysStuByIds(String ids)
    {
        return sysStuMapper.deleteSysStuByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除学生信息
     * 
     * @param id 学生ID
     * @return 结果
     */
    @Override
    public int deleteSysStuById(Long id)
    {
        return sysStuMapper.deleteSysStuById(id);
    }
}
