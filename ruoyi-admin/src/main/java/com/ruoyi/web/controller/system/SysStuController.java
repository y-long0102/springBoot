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
import com.ruoyi.system.domain.SysStu;
import com.ruoyi.system.service.ISysStuService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 学生Controller
 * 
 * @author ruoyi
 * @date 2021-05-14
 */
@Controller
@RequestMapping("/system/stu")
public class SysStuController extends BaseController
{
    private String prefix = "system/stu";

    @Autowired
    private ISysStuService sysStuService;

    @RequiresPermissions("system:stu:view")
    @GetMapping()
    public String stu()
    {
        return prefix + "/stu";
    }

    /**
     * 查询学生列表
     */
    @RequiresPermissions("system:stu:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysStu sysStu)
    {
        startPage();
        List<SysStu> list = sysStuService.selectSysStuList(sysStu);
        return getDataTable(list);
    }

    /**
     * 导出学生列表
     */
    @RequiresPermissions("system:stu:export")
    @Log(title = "学生", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysStu sysStu)
    {
        List<SysStu> list = sysStuService.selectSysStuList(sysStu);
        ExcelUtil<SysStu> util = new ExcelUtil<SysStu>(SysStu.class);
        return util.exportExcel(list, "stu");
    }

    /**
     * 新增学生
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存学生
     */
    @RequiresPermissions("system:stu:add")
    @Log(title = "学生", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysStu sysStu)
    {
        return toAjax(sysStuService.insertSysStu(sysStu));
    }

    /**
     * 修改学生
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        SysStu sysStu = sysStuService.selectSysStuById(id);
        mmap.put("sysStu", sysStu);
        return prefix + "/edit";
    }

    /**
     * 修改保存学生
     */
    @RequiresPermissions("system:stu:edit")
    @Log(title = "学生", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysStu sysStu)
    {
        return toAjax(sysStuService.updateSysStu(sysStu));
    }

    /**
     * 删除学生
     */
    @RequiresPermissions("system:stu:remove")
    @Log(title = "学生", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sysStuService.deleteSysStuByIds(ids));
    }
}
