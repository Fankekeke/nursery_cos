package cc.mrbird.febs.cos.service;

import cc.mrbird.febs.cos.entity.TeacherInfo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;

/**
 * @author Fank gmail - fan1ke2ke@gmail.com
 */
public interface ITeacherInfoService extends IService<TeacherInfo> {

    /**
     * 分页获取教师信息
     *
     * @param page        分页对象
     * @param teacherInfo 教师信息
     * @return 结果
     */
    IPage<LinkedHashMap<String, Object>> selectTeacherPage(Page<TeacherInfo> page, TeacherInfo teacherInfo);
}
