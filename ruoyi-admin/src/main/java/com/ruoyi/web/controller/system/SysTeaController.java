package com.ruoyi.web.controller.system;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.SysTea;
import com.ruoyi.system.service.ISysTeaService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 老师Controller
 * 
 * @author ruoyi
 * @date 2021-05-14
 */
@Controller
@RequestMapping("/system/tea")
public class SysTeaController extends BaseController
{
    private String prefix = "system/tea";

    @Autowired
    private ISysTeaService sysTeaService;

    @RequiresPermissions("system:tea:view")
    @GetMapping()
    public String tea()
    {
        return prefix + "/tea";
    }

    /**
     * 查询老师列表
     */
    @RequiresPermissions("system:tea:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysTea sysTea)
    {
        startPage();
        List<SysTea> list = sysTeaService.selectSysTeaList(sysTea);
        return getDataTable(list);
    }

    /**
     * 导出老师列表
     */
    @RequiresPermissions("system:tea:export")
    @Log(title = "老师", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysTea sysTea)
    {
        List<SysTea> list = sysTeaService.selectSysTeaList(sysTea);
        ExcelUtil<SysTea> util = new ExcelUtil<SysTea>(SysTea.class);
        return util.exportExcel(list, "tea");
    }

    /**
     * 新增老师
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存老师
     */
    @RequiresPermissions("system:tea:add")
    @Log(title = "老师", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysTea sysTea)
    {
        return toAjax(sysTeaService.insertSysTea(sysTea));
    }

    /**
     * 修改老师
     */
    @GetMapping("/edit/{tid}")
    public String edit(@PathVariable("tid") Long tid, ModelMap mmap)
    {
        SysTea sysTea = sysTeaService.selectSysTeaById(tid);
        mmap.put("sysTea", sysTea);
        return prefix + "/edit";
    }

    /**
     * 修改保存老师
     */
    @RequiresPermissions("system:tea:edit")
    @Log(title = "老师", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysTea sysTea)
    {
        return toAjax(sysTeaService.updateSysTea(sysTea));
    }

    /**
     * 删除老师
     */
    @RequiresPermissions("system:tea:remove")
    @Log(title = "老师", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sysTeaService.deleteSysTeaByIds(ids));
    }
}
