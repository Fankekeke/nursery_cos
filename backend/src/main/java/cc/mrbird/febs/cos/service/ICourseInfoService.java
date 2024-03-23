package cc.mrbird.febs.cos.service;

import cc.mrbird.febs.cos.entity.CourseInfo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;

/**
 * @author Fank gmail - fan1ke2ke@gmail.com
 */
public interface ICourseInfoService extends IService<CourseInfo> {

    /**
     * 分页获取课程信息
     *
     * @param page         分页对象
     * @param courseInfo 课程信息
     * @return 结果
     */
    IPage<LinkedHashMap<String, Object>> selectCoursePage(Page<CourseInfo> page, @Param("courseInfo") CourseInfo courseInfo);
}
