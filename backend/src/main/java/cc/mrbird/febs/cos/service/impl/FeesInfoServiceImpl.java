package cc.mrbird.febs.cos.service.impl;

import cc.mrbird.febs.cos.entity.FeesInfo;
import cc.mrbird.febs.cos.dao.FeesInfoMapper;
import cc.mrbird.febs.cos.service.IFeesInfoService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

/**
 * @author Fank gmail - fan1ke2ke@gmail.com
 */
@Service
public class FeesInfoServiceImpl extends ServiceImpl<FeesInfoMapper, FeesInfo> implements IFeesInfoService {

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
}
