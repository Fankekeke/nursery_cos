package cc.mrbird.febs.cos.controller;


import cc.mrbird.febs.common.utils.R;
import cc.mrbird.febs.cos.entity.CourseInfo;
import cc.mrbird.febs.cos.service.ICourseInfoService;
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
@RequestMapping("/cos/course-info")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CourseInfoController {

    private final ICourseInfoService courseInfoService;

    /**
     * 分页获取课程信息
     *
     * @param page         分页对象
     * @param courseInfo 课程信息
     * @return 结果
     */
    @GetMapping("/page")
    public R page(Page<CourseInfo> page, CourseInfo courseInfo) {
        return R.ok(courseInfoService.selectCoursePage(page, courseInfo));
    }

    /**
     * 课程信息详情
     *
     * @param id 课程ID
     * @return 结果
     */
    @GetMapping("/{id}")
    public R detail(@PathVariable("id") Integer id) {
        return R.ok(courseInfoService.getById(id));
    }

    /**
     * 课程信息列表
     *
     * @return 结果
     */
    @GetMapping("/list")
    public R list() {
        return R.ok(courseInfoService.list());
    }

    /**
     * 新增课程信息
     *
     * @param courseInfo 课程信息
     * @return 结果
     */
    @PostMapping
    public R save(CourseInfo courseInfo) {
        courseInfo.setCreateDate(DateUtil.formatDateTime(new Date()));
        return R.ok(courseInfoService.save(courseInfo));
    }

    /**
     * 修改课程信息
     *
     * @param courseInfo 课程信息
     * @return 结果
     */
    @PutMapping
    public R edit(CourseInfo courseInfo) {
        return R.ok(courseInfoService.updateById(courseInfo));
    }

    /**
     * 删除课程信息
     *
     * @param ids ids
     * @return 课程信息
     */
    @DeleteMapping("/{ids}")
    public R deleteByIds(@PathVariable("ids") List<Integer> ids) {
        return R.ok(courseInfoService.removeByIds(ids));
    }
}
