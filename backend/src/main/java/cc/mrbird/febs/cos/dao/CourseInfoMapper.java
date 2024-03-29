package cc.mrbird.febs.cos.dao;

import cc.mrbird.febs.cos.entity.CourseInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author Fank gmail - fan1ke2ke@gmail.com
 */
public interface CourseInfoMapper extends BaseMapper<CourseInfo> {

    /**
     * 分页获取课程信息
     *
     * @param page       分页对象
     * @param courseInfo 课程信息
     * @return 结果
     */
    IPage<LinkedHashMap<String, Object>> selectCoursePage(Page<CourseInfo> page, @Param("courseInfo") CourseInfo courseInfo);

    /**
     * 根据ID获取课程信息
     *
     * @param ids ID
     * @return 结果
     */
    List<LinkedHashMap<String, Object>> selectCourseByIds(@Param("ids") List<Integer> ids);
}
