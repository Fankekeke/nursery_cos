package cc.mrbird.febs.cos.controller;


import cc.mrbird.febs.common.utils.R;
import cc.mrbird.febs.cos.entity.FeesInfo;
import cc.mrbird.febs.cos.service.IFeesInfoService;
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
@RequestMapping("/cos/fees-info")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FeesInfoController {

    private final IFeesInfoService feesInfoService;

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
    public R save(FeesInfo feesInfo) {
        feesInfo.setCreateDate(DateUtil.formatDateTime(new Date()));
        return R.ok(feesInfoService.save(feesInfo));
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
