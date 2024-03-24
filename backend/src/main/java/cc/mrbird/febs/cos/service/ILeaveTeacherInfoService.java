package cc.mrbird.febs.cos.service;

import cc.mrbird.febs.cos.entity.LeaveTeacherInfo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;

/**
 * @author Fank gmail - fan1ke2ke@gmail.com
 */
public interface ILeaveTeacherInfoService extends IService<LeaveTeacherInfo> {

    /**
     * 分页获取请假信息
     *
     * @param page         分页对象
     * @param leaveTeacherInfo 请假信息
     * @return 结果
     */
    IPage<LinkedHashMap<String, Object>> selectLeavePage(Page<LeaveTeacherInfo> page, LeaveTeacherInfo leaveTeacherInfo);
}
