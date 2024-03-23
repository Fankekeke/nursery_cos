package cc.mrbird.febs.cos.controller;


import cc.mrbird.febs.common.utils.R;
import cc.mrbird.febs.cos.entity.SavorInfo;
import cc.mrbird.febs.cos.service.ISavorInfoService;
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
@RequestMapping("/cos/savor-info")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SavorInfoController {

    private final ISavorInfoService savorInfoService;

    /**
     * 分页获取学生兴趣信息
     *
     * @param page         分页对象
     * @param savorInfo 学生兴趣信息
     * @return 结果
     */
    @GetMapping("/page")
    public R page(Page<SavorInfo> page, SavorInfo savorInfo) {
        return R.ok();
    }

    /**
     * 学生兴趣信息详情
     *
     * @param id 学生兴趣ID
     * @return 结果
     */
    @GetMapping("/{id}")
    public R detail(@PathVariable("id") Integer id) {
        return R.ok(savorInfoService.getById(id));
    }

    /**
     * 学生兴趣信息列表
     *
     * @return 结果
     */
    @GetMapping("/list")
    public R list() {
        return R.ok(savorInfoService.list());
    }

    /**
     * 新增学生兴趣信息
     *
     * @param savorInfo 学生兴趣信息
     * @return 结果
     */
    @PostMapping
    public R save(SavorInfo savorInfo) {
        savorInfo.setCreateDate(DateUtil.formatDateTime(new Date()));
        return R.ok(savorInfoService.save(savorInfo));
    }

    /**
     * 修改学生兴趣信息
     *
     * @param savorInfo 学生兴趣信息
     * @return 结果
     */
    @PutMapping
    public R edit(SavorInfo savorInfo) {
        return R.ok(savorInfoService.updateById(savorInfo));
    }

    /**
     * 删除学生兴趣信息
     *
     * @param ids ids
     * @return 学生兴趣信息
     */
    @DeleteMapping("/{ids}")
    public R deleteByIds(@PathVariable("ids") List<Integer> ids) {
        return R.ok(savorInfoService.removeByIds(ids));
    }
}
