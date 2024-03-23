package cc.mrbird.febs.cos.dao;

import cc.mrbird.febs.cos.entity.FeesInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;

/**
 * @author Fank gmail - fan1ke2ke@gmail.com
 */
public interface FeesInfoMapper extends BaseMapper<FeesInfo> {

    /**
     * 分页获取缴费内容信息
     *
     * @param page         分页对象
     * @param feesInfo 缴费内容信息
     * @return 结果
     */
    IPage<LinkedHashMap<String, Object>> selectFeesPage(Page<FeesInfo> page, @Param("feesInfo") FeesInfo feesInfo);
}
