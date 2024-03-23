package cc.mrbird.febs.cos.service;

import cc.mrbird.febs.cos.entity.ClassesInfo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;

/**
 * @author Fank gmail - fan1ke2ke@gmail.com
 */
public interface IClassesInfoService extends IService<ClassesInfo> {

    /**
     * 分页获取班级信息
     *
     * @param page        分页对象
     * @param classesInfo 班级信息
     * @return 结果
     */
    IPage<LinkedHashMap<String, Object>> selectClassesPage(Page<ClassesInfo> page, ClassesInfo classesInfo);
}
