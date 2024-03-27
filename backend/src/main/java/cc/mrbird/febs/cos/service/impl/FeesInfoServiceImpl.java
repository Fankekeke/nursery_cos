package cc.mrbird.febs.cos.service.impl;

import cc.mrbird.febs.cos.dao.ClassesInfoMapper;
import cc.mrbird.febs.cos.dao.StudentInfoMapper;
import cc.mrbird.febs.cos.dao.TeacherInfoMapper;
import cc.mrbird.febs.cos.entity.*;
import cc.mrbird.febs.cos.dao.FeesInfoMapper;
import cc.mrbird.febs.cos.service.IBulletinInfoService;
import cc.mrbird.febs.cos.service.IFeesInfoService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author Fank gmail - fan1ke2ke@gmail.com
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FeesInfoServiceImpl extends ServiceImpl<FeesInfoMapper, FeesInfo> implements IFeesInfoService {

    private final ClassesInfoMapper classesInfoMapper;

    private final TeacherInfoMapper teacherInfoMapper;

    private final StudentInfoMapper studentInfoMapper;

    private final IBulletinInfoService bulletinInfoService;

    /**
     * 分页获取缴费内容信息
     *
     * @param page         分页对象
     * @param feesInfo 缴费内容信息
     * @return 结果
     */
    @Override
    public IPage<LinkedHashMap<String, Object>> selectFeesPage(Page<FeesInfo> page, FeesInfo feesInfo) {
        return baseMapper.selectFeesPage(page, feesInfo);
    }

    /**
     * 查询主页信息
     *
     * @return 结果
     */
    @Override
    public LinkedHashMap<String, Object> homeData() {
        // 管理员展示信息
        LinkedHashMap<String, Object> result = new LinkedHashMap<>();

        // 本月收益
        BigDecimal incomeMonth = baseMapper.selectIncomeMonth();
        // 本月工单
        Integer workOrderMonth = baseMapper.selectWorkOrderMonth();
        // 本年收益
        BigDecimal incomeYear = baseMapper.selectIncomeYear();
        // 本年工单
        Integer workOrderYear = baseMapper.selectWorkOrderYear();
        // 班级数量
        Integer userNum = classesInfoMapper.selectCount(Wrappers.<ClassesInfo>lambdaQuery());
        // 学生数量
        Integer staffNum = studentInfoMapper.selectCount(Wrappers.<StudentInfo>lambdaQuery());
        // 教师数量
        Integer roomNum = teacherInfoMapper.selectCount(Wrappers.<TeacherInfo>lambdaQuery());
        // 总收益
        BigDecimal amount = baseMapper.selectAmountPrice();
        // 十天内缴费记录
        List<LinkedHashMap<String, Object>> paymentRecord = baseMapper.selectPaymentRecord();
        // 十天内工单数量
        List<LinkedHashMap<String, Object>> orderRecord = baseMapper.selectOrderRecord();
        result.put("incomeMonth", incomeMonth);
        result.put("workOrderMonth", workOrderMonth);
        result.put("incomeYear", incomeYear);
        result.put("workOrderYear", workOrderYear);
        result.put("totalOrderNum", userNum);
        result.put("staffNum", staffNum);
        result.put("roomNum", roomNum);
        result.put("totalRevenue", amount);
        result.put("paymentRecord", paymentRecord);
        result.put("orderRecord", orderRecord);

        // 公告信息
        List<BulletinInfo> bulletinList = bulletinInfoService.list();
        result.put("bulletin", bulletinList);
        return result;
    }
}
