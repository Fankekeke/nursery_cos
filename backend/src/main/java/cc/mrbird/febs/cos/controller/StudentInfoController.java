package cc.mrbird.febs.cos.controller;


import cc.mrbird.febs.common.utils.R;
import cc.mrbird.febs.cos.entity.ClassesInfo;
import cc.mrbird.febs.cos.entity.SavorInfo;
import cc.mrbird.febs.cos.entity.StudentInfo;
import cc.mrbird.febs.cos.service.IClassesInfoService;
import cc.mrbird.febs.cos.service.ISavorInfoService;
import cc.mrbird.febs.cos.service.IStudentInfoService;
import cc.mrbird.febs.cos.service.ITeacherInfoService;
import cc.mrbird.febs.system.service.UserService;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
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
@RequestMapping("/cos/student-info")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class StudentInfoController {

    private final IStudentInfoService studentInfoService;

    private final UserService userService;

    private final ISavorInfoService savorInfoService;

    private final IClassesInfoService classesInfoService;

    private final ITeacherInfoService teacherInfoService;

    /**
     * 分页获取学生信息
     *
     * @param page        分页对象
     * @param studentInfo 学生信息
     * @return 结果
     */
    @GetMapping("/page")
    public R page(Page<StudentInfo> page, StudentInfo studentInfo) {
        return R.ok(studentInfoService.selectStudentPage(page, studentInfo));
    }

    /**
     * 学生信息详情
     *
     * @param userId 学生ID
     * @return 结果
     */
    @GetMapping("/detail/{userId}")
    public R studentDetail(@PathVariable("userId") Integer userId) {
        StudentInfo studentInfo = studentInfoService.getOne(Wrappers.<StudentInfo>lambdaQuery().eq(StudentInfo::getUserId, userId));
        // 学生兴趣
        SavorInfo smiInfo = savorInfoService.getOne(Wrappers.<SavorInfo>lambdaQuery().eq(SavorInfo::getStudentId, studentInfo.getId()));
        if (smiInfo != null) {
            studentInfo.setInterest(smiInfo.getInterest());
        }
        return R.ok(studentInfo);
    }

    /**
     * 获取学生代课老师信息
     *
     * @param userId 学生ID
     * @return 结果
     */
    @GetMapping("/teacher/{userId}")
    public R selectTeacherByStudentId(@PathVariable("userId") Integer userId) {
        StudentInfo studentInfo = studentInfoService.getOne(Wrappers.<StudentInfo>lambdaQuery().eq(StudentInfo::getUserId, userId));
        // 班级信息
        ClassesInfo classesInfo = classesInfoService.getById(studentInfo.getClassesId());

        // 教师信息
        return R.ok(teacherInfoService.getById(classesInfo.getTeacherId()));
    }

    /**
     * 学生信息详情
     *
     * @param id 学生ID
     * @return 结果
     */
    @GetMapping("/{id}")
    public R detail(@PathVariable("id") Integer id) {
        return R.ok(studentInfoService.getById(id));
    }

    /**
     * 学生信息列表
     *
     * @return 结果
     */
    @GetMapping("/list")
    public R list() {
        return R.ok(studentInfoService.list());
    }

    /**
     * 新增学生信息
     *
     * @param studentInfo 学生信息
     * @return 结果
     */
    @PostMapping
    public R save(StudentInfo studentInfo) throws Exception {
        studentInfo.setCode("STU-" + System.currentTimeMillis());
        studentInfo.setCreateDate(DateUtil.formatDateTime(new Date()));
        userService.registStudent(studentInfo.getCode(), "1234qwer", studentInfo);
        return R.ok(true);
    }

    /**
     * 修改学生信息
     *
     * @param studentInfo 学生信息
     * @return 结果
     */
    @PutMapping
    public R edit(StudentInfo studentInfo) {
        // 学生兴趣
        SavorInfo smiInfo = savorInfoService.getOne(Wrappers.<SavorInfo>lambdaQuery().eq(SavorInfo::getStudentId, studentInfo.getId()));
        if (smiInfo != null) {
            smiInfo.setInterest(studentInfo.getInterest());
            savorInfoService.updateById(smiInfo);
        } else {
            SavorInfo smiInfo2 = new SavorInfo();
            smiInfo2.setInterest(studentInfo.getInterest());
            smiInfo2.setStudentId(studentInfo.getId());
            smiInfo2.setCreateDate(DateUtil.formatDateTime(new Date()));
            savorInfoService.save(smiInfo2);
        }
        return R.ok(studentInfoService.updateById(studentInfo));
    }

    /**
     * 删除学生信息
     *
     * @param ids ids
     * @return 学生信息
     */
    @DeleteMapping("/{ids}")
    public R deleteByIds(@PathVariable("ids") List<Integer> ids) {
        return R.ok(studentInfoService.removeByIds(ids));
    }
}
