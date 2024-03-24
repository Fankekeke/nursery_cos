package cc.mrbird.febs.cos.service.impl;

import cc.mrbird.febs.cos.entity.LeaveTeacherInfo;
import cc.mrbird.febs.cos.dao.LeaveTeacherInfoMapper;
import cc.mrbird.febs.cos.service.ILeaveTeacherInfoService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

/**
 * @author Fank gmail - fan1ke2ke@gmail.com
 */
@Service
public class LeaveTeacherInfoServiceImpl extends ServiceImpl<LeaveTeacherInfoMapper, LeaveTeacherInfo> implements ILeaveTeacherInfoService {

    /**
     * 分页获取请假信息
     *
     * @param page         分页对象
     * @param leaveTeacherInfo 请假信息
     * @return 结果
     */
    @Override
    public IPage<LinkedHashMap<String, Object>> selectLeavePage(Page<LeaveTeacherInfo> page, LeaveTeacherInfo leaveTeacherInfo) {
        return baseMapper.selectLeavePage(page, leaveTeacherInfo);
    }
}
