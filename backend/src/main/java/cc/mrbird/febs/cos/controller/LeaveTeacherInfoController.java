package cc.mrbird.febs.cos.controller;


import cc.mrbird.febs.common.utils.R;
import cc.mrbird.febs.cos.entity.LeaveInfo;
import cc.mrbird.febs.cos.entity.LeaveTeacherInfo;
import cc.mrbird.febs.cos.entity.TeacherInfo;
import cc.mrbird.febs.cos.service.ILeaveTeacherInfoService;
import cc.mrbird.febs.cos.service.ITeacherInfoService;
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
@RequestMapping("/cos/leave-teacher-info")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LeaveTeacherInfoController {

    private final ILeaveTeacherInfoService leaveTeacherInfoService;

    private final ITeacherInfoService teacherInfoService;

    /**
     * 分页获取请假信息
     *
     * @param page         分页对象
     * @param leaveTeacherInfo 请假信息
     * @return 结果
     */
    @GetMapping("/page")
    public R page(Page<LeaveTeacherInfo> page, LeaveTeacherInfo leaveTeacherInfo) {
        return R.ok(leaveTeacherInfoService.selectLeavePage(page, leaveTeacherInfo));
    }

    /**
     * 教师请假审批
     *
     * @param id     主键
     * @param status 状态
     * @return 结果
     */
    @GetMapping("/leaveAudit")
    public R leaveAudit(Integer id, String status) {
        return R.ok(leaveTeacherInfoService.update(Wrappers.<LeaveTeacherInfo>lambdaUpdate().set(LeaveTeacherInfo::getStatus, status).eq(LeaveTeacherInfo::getId, id)));
    }

    /**
     * 请假信息详情
     *
     * @param id 请假ID
     * @return 结果
     */
    @GetMapping("/{id}")
    public R detail(@PathVariable("id") Integer id) {
        return R.ok(leaveTeacherInfoService.getById(id));
    }

    /**
     * 请假信息列表
     *
     * @return 结果
     */
    @GetMapping("/list")
    public R list() {
        return R.ok(leaveTeacherInfoService.list());
    }

    /**
     * 新增请假信息
     *
     * @param leaveTeacherInfo 请假信息
     * @return 结果
     */
    @PostMapping
    public R save(LeaveTeacherInfo leaveTeacherInfo) {
        TeacherInfo teacherInfo = teacherInfoService.getOne(Wrappers.<TeacherInfo>lambdaQuery().eq(TeacherInfo::getUserId, leaveTeacherInfo.getTeacherId()));
        leaveTeacherInfo.setTeacherId(teacherInfo.getId());
        leaveTeacherInfo.setStatus("0");
        leaveTeacherInfo.setCreateDate(DateUtil.formatDateTime(new Date()));
        return R.ok(leaveTeacherInfoService.save(leaveTeacherInfo));
    }

    /**
     * 修改请假信息
     *
     * @param leaveTeacherInfo 请假信息
     * @return 结果
     */
    @PutMapping
    public R edit(LeaveTeacherInfo leaveTeacherInfo) {
        return R.ok(leaveTeacherInfoService.updateById(leaveTeacherInfo));
    }

    /**
     * 删除请假信息
     *
     * @param ids ids
     * @return 请假信息
     */
    @DeleteMapping("/{ids}")
    public R deleteByIds(@PathVariable("ids") List<Integer> ids) {
        return R.ok(leaveTeacherInfoService.removeByIds(ids));
    }
}
