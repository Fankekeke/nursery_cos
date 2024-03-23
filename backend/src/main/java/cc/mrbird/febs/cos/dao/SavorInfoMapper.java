package cc.mrbird.febs.cos.dao;

import cc.mrbird.febs.cos.entity.SavorInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;

/**
 * @author Fank gmail - fan1ke2ke@gmail.com
 */
public interface SavorInfoMapper extends BaseMapper<SavorInfo> {

    /**
     * 分页获取学生兴趣信息
     *
     * @param page         分页对象
     * @param savorInfo 学生兴趣信息
     * @return 结果
     */
    IPage<LinkedHashMap<String, Object>> selectSavorPage(Page<SavorInfo> page, @Param("savorInfo") SavorInfo savorInfo);
}
