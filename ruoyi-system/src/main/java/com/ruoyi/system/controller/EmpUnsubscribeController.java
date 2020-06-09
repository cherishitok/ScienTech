package com.ruoyi.system.controller;

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
import com.ruoyi.system.domain.EmpUnsubscribe;
import com.ruoyi.system.service.IEmpUnsubscribeService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 爱音乐退订Controller
 * 
 * @author ruoyi
 * @date 2020-05-27
 */
@Controller
@RequestMapping("/system/unsubscribe")
public class EmpUnsubscribeController extends BaseController
{
    private String prefix = "system/unsubscribe";

    @Autowired
    private IEmpUnsubscribeService empUnsubscribeService;

    @RequiresPermissions("system:unsubscribe:view")
    @GetMapping()
    public String unsubscribe()
    {
        return prefix + "/unsubscribe";
    }

    /**
     * 查询爱音乐退订列表
     */
    @RequiresPermissions("system:unsubscribe:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(EmpUnsubscribe empUnsubscribe)
    {
        startPage();
        List<EmpUnsubscribe> list = empUnsubscribeService.selectEmpUnsubscribeList(empUnsubscribe);
        return getDataTable(list);
    }

    /**
     * 导出爱音乐退订列表
     */
    @RequiresPermissions("system:unsubscribe:export")
    @Log(title = "爱音乐退订", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(EmpUnsubscribe empUnsubscribe)
    {
        List<EmpUnsubscribe> list = empUnsubscribeService.selectEmpUnsubscribeList(empUnsubscribe);
        ExcelUtil<EmpUnsubscribe> util = new ExcelUtil<EmpUnsubscribe>(EmpUnsubscribe.class);
        return util.exportExcel(list, "unsubscribe");
    }

    /**
     * 新增爱音乐退订
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存爱音乐退订
     */
    @RequiresPermissions("system:unsubscribe:add")
    @Log(title = "爱音乐退订", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(EmpUnsubscribe empUnsubscribe)
    {
        return toAjax(empUnsubscribeService.insertEmpUnsubscribe(empUnsubscribe));
    }

    /**
     * 修改爱音乐退订
     */
    @GetMapping("/edit/{unsubId}")
    public String edit(@PathVariable("unsubId") Long unsubId, ModelMap mmap)
    {
        EmpUnsubscribe empUnsubscribe = empUnsubscribeService.selectEmpUnsubscribeById(unsubId);
        mmap.put("empUnsubscribe", empUnsubscribe);
        return prefix + "/edit";
    }

    /**
     * 修改保存爱音乐退订
     */
    @RequiresPermissions("system:unsubscribe:edit")
    @Log(title = "爱音乐退订", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(EmpUnsubscribe empUnsubscribe)
    {
        return toAjax(empUnsubscribeService.updateEmpUnsubscribe(empUnsubscribe));
    }

    /**
     * 删除爱音乐退订
     */
    @RequiresPermissions("system:unsubscribe:remove")
    @Log(title = "爱音乐退订", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(empUnsubscribeService.deleteEmpUnsubscribeByIds(ids));
    }
}
