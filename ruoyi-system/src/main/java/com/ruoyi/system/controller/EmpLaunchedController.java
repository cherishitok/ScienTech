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
import com.ruoyi.system.domain.EmpLaunched;
import com.ruoyi.system.service.IEmpLaunchedService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 爱音乐发起订购Controller
 * 
 * @author ruoyi
 * @date 2020-05-26
 */
@Controller
@RequestMapping("/system/launched")
public class EmpLaunchedController extends BaseController
{
    private String prefix = "system/launched";

    @Autowired
    private IEmpLaunchedService empLaunchedService;

    @RequiresPermissions("system:launched:view")
    @GetMapping()
    public String launched()
    {
        return prefix + "/launched";
    }

    /**
     * 查询爱音乐发起订购列表
     */
    @RequiresPermissions("system:launched:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(EmpLaunched empLaunched)
    {
        startPage();
        List<EmpLaunched> list = empLaunchedService.selectEmpLaunchedList(empLaunched);
        return getDataTable(list);
    }

    /**
     * 导出爱音乐发起订购列表
     */
    @RequiresPermissions("system:launched:export")
    @Log(title = "爱音乐发起订购", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(EmpLaunched empLaunched)
    {
        List<EmpLaunched> list = empLaunchedService.selectEmpLaunchedList(empLaunched);
        ExcelUtil<EmpLaunched> util = new ExcelUtil<EmpLaunched>(EmpLaunched.class);
        return util.exportExcel(list, "launched");
    }

    /**
     * 新增爱音乐发起订购
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存爱音乐发起订购
     */
    @RequiresPermissions("system:launched:add")
    @Log(title = "爱音乐发起订购", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(EmpLaunched empLaunched)
    {
        return toAjax(empLaunchedService.insertEmpLaunched(empLaunched));
    }

    /**
     * 修改爱音乐发起订购
     */
    @GetMapping("/edit/{lauId}")
    public String edit(@PathVariable("lauId") Long lauId, ModelMap mmap)
    {
        EmpLaunched empLaunched = empLaunchedService.selectEmpLaunchedById(lauId);
        mmap.put("empLaunched", empLaunched);
        return prefix + "/edit";
    }

    /**
     * 修改保存爱音乐发起订购
     */
    @RequiresPermissions("system:launched:edit")
    @Log(title = "爱音乐发起订购", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(EmpLaunched empLaunched)
    {
        return toAjax(empLaunchedService.updateEmpLaunched(empLaunched));
    }

    /**
     * 删除爱音乐发起订购
     */
    @RequiresPermissions("system:launched:remove")
    @Log(title = "爱音乐发起订购", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(empLaunchedService.deleteEmpLaunchedByIds(ids));
    }
}
