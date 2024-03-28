package cc.mrbird.febs.cos.controller;


import cc.mrbird.febs.common.exception.FebsException;
import cc.mrbird.febs.common.utils.R;
import cc.mrbird.febs.cos.entity.FeesInfo;
import cc.mrbird.febs.cos.entity.PayRecordInfo;
import cc.mrbird.febs.cos.entity.StudentInfo;
import cc.mrbird.febs.cos.service.IFeesInfoService;
import cc.mrbird.febs.cos.service.IPayRecordInfoService;
import cc.mrbird.febs.cos.service.IStudentInfoService;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Fank gmail - fan1ke2ke@gmail.com
 */
@RestController
@RequestMapping("/cos/fees-info")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FeesInfoController {

    private final IFeesInfoService feesInfoService;

    private final IPayRecordInfoService payRecordService;

    private final IStudentInfoService studentInfoService;

    /**
     * 分页获取缴费内容信息
     *
     * @param page         分页对象
     * @param feesInfo 缴费内容信息
     * @return 结果
     */
    @GetMapping("/page")
    public R page(Page<FeesInfo> page, FeesInfo feesInfo) {
        return R.ok(feesInfoService.selectFeesPage(page, feesInfo));
    }

    /**
     * 缴费内容信息详情
     *
     * @param id 缴费内容ID
     * @return 结果
     */
    @GetMapping("/{id}")
    public R detail(@PathVariable("id") Integer id) {
        return R.ok(feesInfoService.getById(id));
    }

    /**
     * 缴费内容信息列表
     *
     * @return 结果
     */
    @GetMapping("/list")
    public R list() {
        return R.ok(feesInfoService.list());
    }

    /**
     * 新增缴费内容信息
     *
     * @param feesInfo 缴费内容信息
     * @return 结果
     */
    @PostMapping
    public R save(FeesInfo feesInfo) throws FebsException {
        feesInfo.setCreateDate(DateUtil.formatDateTime(new Date()));
        feesInfoService.save(feesInfo);

        List<StudentInfo> studentInfoList = studentInfoService.list(Wrappers.<StudentInfo>lambdaQuery().eq(StudentInfo::getClassesId, feesInfo.getClassId()));
        if (CollectionUtil.isEmpty(studentInfoList)) {
            throw new FebsException("此班级没有学生！");
        }
        List<PayRecordInfo> recordInfoList = new ArrayList<>();
        for (StudentInfo studentInfo : studentInfoList) {
            PayRecordInfo payRecord = new PayRecordInfo();
            payRecord.setPrice(feesInfo.getPrice());
            payRecord.setFeesId(feesInfo.getId());
            payRecord.setStudentId(studentInfo.getId());
            payRecord.setStatus("0");
            payRecord.setCode("PR-" + System.currentTimeMillis() + RandomUtil.randomNumbers(5));
            recordInfoList.add(payRecord);
        }
        return R.ok(payRecordService.saveBatch(recordInfoList));
    }

    /**
     * 查询主页信息
     *
     * @return 结果
     */
    @GetMapping("/home/data")
    public R homeData() {
        return R.ok(feesInfoService.homeData());
    }

    /**
     * 修改缴费内容信息
     *
     * @param feesInfo 缴费内容信息
     * @return 结果
     */
    @PutMapping
    public R edit(FeesInfo feesInfo) {
        return R.ok(feesInfoService.updateById(feesInfo));
    }

    /**
     * 删除缴费内容信息
     *
     * @param ids ids
     * @return 缴费内容信息
     */
    @DeleteMapping("/{ids}")
    public R deleteByIds(@PathVariable("ids") List<Integer> ids) {
        return R.ok(feesInfoService.removeByIds(ids));
    }
}
