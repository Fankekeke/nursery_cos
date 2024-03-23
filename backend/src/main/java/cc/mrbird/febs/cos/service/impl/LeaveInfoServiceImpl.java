package cc.mrbird.febs.cos.service.impl;

import cc.mrbird.febs.cos.entity.LeaveInfo;
import cc.mrbird.febs.cos.dao.LeaveInfoMapper;
import cc.mrbird.febs.cos.service.ILeaveInfoService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

/**
 * @author Fank gmail - fan1ke2ke@gmail.com
 */
@Service
public class LeaveInfoServiceImpl extends ServiceImpl<LeaveInfoMapper, LeaveInfo> implements ILeaveInfoService {

    /**
     * 分页获取请假信息
     *
     * @param page      分页对象
     * @param leaveInfo 请假信息
     * @return 结果
     */
    @Override
    public IPage<LinkedHashMap<String, Object>> selectLeavePage(Page<LeaveInfo> page, LeaveInfo leaveInfo) {
        return baseMapper.selectLeavePage(page, leaveInfo);
    }
}
