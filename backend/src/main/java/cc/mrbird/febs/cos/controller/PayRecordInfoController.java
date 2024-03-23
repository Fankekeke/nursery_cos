package cc.mrbird.febs.cos.controller;


import cc.mrbird.febs.common.utils.R;
import cc.mrbird.febs.cos.entity.PayRecordInfo;
import cc.mrbird.febs.cos.service.IPayRecordInfoService;
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
@RequestMapping("/cos/pay-record-info")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PayRecordInfoController {

    private final IPayRecordInfoService payRecordInfoService;

    /**
     * 分页获取缴费记录信息
     *
     * @param page         分页对象
     * @param payRecordInfo 缴费记录信息
     * @return 结果
     */
    @GetMapping("/page")
    public R page(Page<PayRecordInfo> page, PayRecordInfo payRecordInfo) {
        return R.ok();
    }

    /**
     * 缴费记录信息详情
     *
     * @param id 缴费记录ID
     * @return 结果
     */
    @GetMapping("/{id}")
    public R detail(@PathVariable("id") Integer id) {
        return R.ok(payRecordInfoService.getById(id));
    }

    /**
     * 缴费记录信息列表
     *
     * @return 结果
     */
    @GetMapping("/list")
    public R list() {
        return R.ok(payRecordInfoService.list());
    }

    /**
     * 新增缴费记录信息
     *
     * @param payRecordInfo 缴费记录信息
     * @return 结果
     */
    @PostMapping
    public R save(PayRecordInfo payRecordInfo) {
        payRecordInfo.setPayDate(DateUtil.formatDateTime(new Date()));
        return R.ok(payRecordInfoService.save(payRecordInfo));
    }

    /**
     * 修改缴费记录信息
     *
     * @param payRecordInfo 缴费记录信息
     * @return 结果
     */
    @PutMapping
    public R edit(PayRecordInfo payRecordInfo) {
        return R.ok(payRecordInfoService.updateById(payRecordInfo));
    }

    /**
     * 删除缴费记录信息
     *
     * @param ids ids
     * @return 缴费记录信息
     */
    @DeleteMapping("/{ids}")
    public R deleteByIds(@PathVariable("ids") List<Integer> ids) {
        return R.ok(payRecordInfoService.removeByIds(ids));
    }
}
