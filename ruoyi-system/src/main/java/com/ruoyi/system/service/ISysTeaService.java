package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysTea;

/**
 * 老师Service接口
 * 
 * @author ruoyi
 * @date 2021-05-14
 */
public interface ISysTeaService 
{
    /**
     * 查询老师
     * 
     * @param tid 老师ID
     * @return 老师
     */
    public SysTea selectSysTeaById(Long tid);

    /**
     * 查询老师列表
     * 
     * @param sysTea 老师
     * @return 老师集合
     */
    public List<SysTea> selectSysTeaList(SysTea sysTea);

    /**
     * 新增老师
     * 
     * @param sysTea 老师
     * @return 结果
     */
    public int insertSysTea(SysTea sysTea);

    /**
     * 修改老师
     * 
     * @param sysTea 老师
     * @return 结果
     */
    public int updateSysTea(SysTea sysTea);

    /**
     * 批量删除老师
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysTeaByIds(String ids);

    /**
     * 删除老师信息
     * 
     * @param tid 老师ID
     * @return 结果
     */
    public int deleteSysTeaById(Long tid);
}
