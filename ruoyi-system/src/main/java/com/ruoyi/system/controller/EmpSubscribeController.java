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
import com.ruoyi.system.domain.EmpSubscribe;
import com.ruoyi.system.service.IEmpSubscribeService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 爱音乐订购Controller
 * 
 * @author ruoyi
 * @date 2020-05-26
 */
@Controller
@RequestMapping("/system/subscribe")
public class EmpSubscribeController extends BaseController
{
    private String prefix = "system/subscribe";

    @Autowired
    private IEmpSubscribeService empSubscribeService;

    @RequiresPermissions("system:subscribe:view")
    @GetMapping()
    public String subscribe()
    {
        return prefix + "/subscribe";
    }

    /**
     * 查询爱音乐订购列表
     */
    @RequiresPermissions("system:subscribe:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(EmpSubscribe empSubscribe)
    {
        startPage();
        List<EmpSubscribe> list = empSubscribeService.selectEmpSubscribeList(empSubscribe);
        return getDataTable(list);
    }

    /**
     * 导出爱音乐订购列表
     */
    @RequiresPermissions("system:subscribe:export")
    @Log(title = "爱音乐订购", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(EmpSubscribe empSubscribe)
    {
        List<EmpSubscribe> list = empSubscribeService.selectEmpSubscribeList(empSubscribe);
        ExcelUtil<EmpSubscribe> util = new ExcelUtil<EmpSubscribe>(EmpSubscribe.class);
        return util.exportExcel(list, "subscribe");
    }

    /**
     * 新增爱音乐订购
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存爱音乐订购
     */
    @RequiresPermissions("system:subscribe:add")
    @Log(title = "爱音乐订购", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(EmpSubscribe empSubscribe)
    {
        return toAjax(empSubscribeService.insertEmpSubscribe(empSubscribe));
    }

    /**
     * 修改爱音乐订购
     */
    @GetMapping("/edit/{subId}")
    public String edit(@PathVariable("subId") Long subId, ModelMap mmap)
    {
        EmpSubscribe empSubscribe = empSubscribeService.selectEmpSubscribeById(subId);
        mmap.put("empSubscribe", empSubscribe);
        return prefix + "/edit";
    }

    /**
     * 修改保存爱音乐订购
     */
    @RequiresPermissions("system:subscribe:edit")
    @Log(title = "爱音乐订购", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(EmpSubscribe empSubscribe)
    {
        return toAjax(empSubscribeService.updateEmpSubscribe(empSubscribe));
    }

    /**
     * 删除爱音乐订购
     */
    @RequiresPermissions("system:subscribe:remove")
    @Log(title = "爱音乐订购", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(empSubscribeService.deleteEmpSubscribeByIds(ids));
    }
}
