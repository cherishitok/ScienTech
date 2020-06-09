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
import com.ruoyi.system.domain.EmpQuerypackage;
import com.ruoyi.system.service.IEmpQuerypackageService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 订购关系查询Controller
 * 
 * @author ruoyi
 * @date 2020-06-01
 */
@Controller
@RequestMapping("/system/querypackage")
public class EmpQuerypackageController extends BaseController
{
    private String prefix = "system/querypackage";

    @Autowired
    private IEmpQuerypackageService empQuerypackageService;

    @RequiresPermissions("system:querypackage:view")
    @GetMapping()
    public String querypackage()
    {
        return prefix + "/querypackage";
    }

    /**
     * 查询订购关系查询列表
     */
    @RequiresPermissions("system:querypackage:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(EmpQuerypackage empQuerypackage)
    {
        startPage();
        List<EmpQuerypackage> list = empQuerypackageService.selectEmpQuerypackageList(empQuerypackage);
        return getDataTable(list);
    }

    /**
     * 导出订购关系查询列表
     */
    @RequiresPermissions("system:querypackage:export")
    @Log(title = "订购关系查询", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(EmpQuerypackage empQuerypackage)
    {
        List<EmpQuerypackage> list = empQuerypackageService.selectEmpQuerypackageList(empQuerypackage);
        ExcelUtil<EmpQuerypackage> util = new ExcelUtil<EmpQuerypackage>(EmpQuerypackage.class);
        return util.exportExcel(list, "querypackage");
    }

    /**
     * 新增订购关系查询
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存订购关系查询
     */
    @RequiresPermissions("system:querypackage:add")
    @Log(title = "订购关系查询", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(EmpQuerypackage empQuerypackage)
    {
        return toAjax(empQuerypackageService.insertEmpQuerypackage(empQuerypackage));
    }

    /**
 * 修改订购关系查询
 */
@GetMapping("/edit/{queId}")
public String edit(@PathVariable("queId") Long queId, ModelMap mmap)
{
    EmpQuerypackage empQuerypackage = empQuerypackageService.selectEmpQuerypackageById(queId);
    mmap.put("empQuerypackage", empQuerypackage);
    return prefix + "/edit";
}

    /**
     * 修改保存订购关系查询
     */
    @RequiresPermissions("system:querypackage:edit")
    @Log(title = "订购关系查询", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(EmpQuerypackage empQuerypackage)
    {
        return toAjax(empQuerypackageService.updateEmpQuerypackage(empQuerypackage));
    }

    /**
     * 订购关系详情
     */
    @RequiresPermissions("system:querypackage:detail")
    @GetMapping("/detail/{queId}")
    public String detail(@PathVariable("queId") Long queId, ModelMap mmap)
    {
        EmpQuerypackage empQuerypackage = empQuerypackageService.selectEmpQuerypackageById(queId);
        mmap.put("empQuerypackage", empQuerypackage);
        return prefix + "/detail";
    }

    /**
     * emp退订
     */

    @RequiresPermissions("system:querypackage:unsubscribe")
    @PostMapping("/unsubscribe")
    @ResponseBody
    public AjaxResult unsubscribe(EmpQuerypackage empQuerypackage)
    {
        System.out.println("-----------"+empQuerypackage.getMdn()+"---"+empQuerypackage.getIsCountDownNum()+"---"+empQuerypackage.getPackageId()+"--------------");
        return AjaxResult.success("查询成功");
    }

    /**
     * 删除订购关系查询
     */
    @RequiresPermissions("system:querypackage:remove")
    @Log(title = "订购关系查询", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(empQuerypackageService.deleteEmpQuerypackageByIds(ids));
    }
}
