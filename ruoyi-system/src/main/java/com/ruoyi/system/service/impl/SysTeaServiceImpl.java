package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysTeaMapper;
import com.ruoyi.system.domain.SysTea;
import com.ruoyi.system.service.ISysTeaService;
import com.ruoyi.common.core.text.Convert;

/**
 * 老师Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-05-14
 */
@Service
public class SysTeaServiceImpl implements ISysTeaService 
{
    @Autowired
    private SysTeaMapper sysTeaMapper;

    /**
     * 查询老师
     * 
     * @param tid 老师ID
     * @return 老师
     */
    @Override
    public SysTea selectSysTeaById(Long tid)
    {
        return sysTeaMapper.selectSysTeaById(tid);
    }

    /**
     * 查询老师列表
     * 
     * @param sysTea 老师
     * @return 老师
     */
    @Override
    public List<SysTea> selectSysTeaList(SysTea sysTea)
    {
        return sysTeaMapper.selectSysTeaList(sysTea);
    }

    /**
     * 新增老师
     * 
     * @param sysTea 老师
     * @return 结果
     */
    @Override
    public int insertSysTea(SysTea sysTea)
    {
        return sysTeaMapper.insertSysTea(sysTea);
    }

    /**
     * 修改老师
     * 
     * @param sysTea 老师
     * @return 结果
     */
    @Override
    public int updateSysTea(SysTea sysTea)
    {
        return sysTeaMapper.updateSysTea(sysTea);
    }

    /**
     * 删除老师对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSysTeaByIds(String ids)
    {
        return sysTeaMapper.deleteSysTeaByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除老师信息
     * 
     * @param tid 老师ID
     * @return 结果
     */
    @Override
    public int deleteSysTeaById(Long tid)
    {
        return sysTeaMapper.deleteSysTeaById(tid);
    }
}
