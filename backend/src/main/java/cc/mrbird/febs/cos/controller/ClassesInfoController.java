package cc.mrbird.febs.cos.controller;


import cc.mrbird.febs.common.utils.R;
import cc.mrbird.febs.cos.entity.ClassesInfo;
import cc.mrbird.febs.cos.service.IClassesInfoService;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author Fank gmail - fan1ke2ke@gmail.com
 */
@RestController
@RequestMapping("/cos/classes-info")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ClassesInfoController {

    private final IClassesInfoService classesInfoService;

    /**
     * 分页获取班级信息
     *
     * @param page         分页对象
     * @param classesInfo 班级信息
     * @return 结果
     */
    @GetMapping("/page")
    public R page(Page<ClassesInfo> page, ClassesInfo classesInfo) {
        return R.ok(classesInfoService.selectClassesPage(page, classesInfo));
    }

    /**
     * 班级信息详情
     *
     * @param id 班级ID
     * @return 结果
     */
    @GetMapping("/{id}")
    public R detail(@PathVariable("id") Integer id) {
        return R.ok(classesInfoService.getById(id));
    }

    /**
     * 班级信息列表
     *
     * @return 结果
     */
    @GetMapping("/list")
    public R list() {
        return R.ok(classesInfoService.list());
    }

    /**
     * 新增班级信息
     *
     * @param classesInfo 班级信息
     * @return 结果
     */
    @PostMapping
    public R save(ClassesInfo classesInfo) {
        classesInfo.setCode("CL-" + System.currentTimeMillis());
        classesInfo.setCreateDate(DateUtil.formatDateTime(new Date()));
        return R.ok(classesInfoService.save(classesInfo));
    }

    /**
     * 修改班级信息
     *
     * @param classesInfo 班级信息
     * @return 结果
     */
    @PutMapping
    public R edit(ClassesInfo classesInfo) {
        return R.ok(classesInfoService.updateById(classesInfo));
    }

    /**
     * 删除班级信息
     *
     * @param ids ids
     * @return 班级信息
     */
    @DeleteMapping("/{ids}")
    public R deleteByIds(@PathVariable("ids") List<Integer> ids) {
        return R.ok(classesInfoService.removeByIds(ids));
    }
}
