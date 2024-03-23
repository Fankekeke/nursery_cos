package cc.mrbird.febs.cos.service.impl;

import cc.mrbird.febs.cos.entity.SavorInfo;
import cc.mrbird.febs.cos.dao.SavorInfoMapper;
import cc.mrbird.febs.cos.service.ISavorInfoService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

/**
 * @author Fank gmail - fan1ke2ke@gmail.com
 */
@Service
public class SavorInfoServiceImpl extends ServiceImpl<SavorInfoMapper, SavorInfo> implements ISavorInfoService {

    /**
     * 分页获取学生兴趣信息
     *
     * @param page         分页对象
     * @param savorInfo 学生兴趣信息
     * @return 结果
     */
    @Override
    public IPage<LinkedHashMap<String, Object>> selectSavorPage(Page<SavorInfo> page, SavorInfo savorInfo) {
        return baseMapper.selectSavorPage(page, savorInfo);
    }
}
