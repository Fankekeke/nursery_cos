package cc.mrbird.febs.cos.service;

import cc.mrbird.febs.cos.entity.SavorInfo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author Fank gmail - fan1ke2ke@gmail.com
 */
public interface ISavorInfoService extends IService<SavorInfo> {

    /**
     * 分页获取学生兴趣信息
     *
     * @param page         分页对象
     * @param savorInfo 学生兴趣信息
     * @return 结果
     */
    IPage<LinkedHashMap<String, Object>> selectSavorPage(Page<SavorInfo> page, SavorInfo savorInfo);

    /**
     * 学生推荐课程
     *
     * @param userId 学生ID
     * @return 结果
     */
    List<LinkedHashMap<String, Object>> recommendCourses(Integer userId);
}
