package cc.mrbird.febs.cos.service.impl;

import cc.mrbird.febs.cos.entity.ClassesInfo;
import cc.mrbird.febs.cos.dao.ClassesInfoMapper;
import cc.mrbird.febs.cos.service.IClassesInfoService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

/**
 * @author Fank gmail - fan1ke2ke@gmail.com
 */
@Service
public class ClassesInfoServiceImpl extends ServiceImpl<ClassesInfoMapper, ClassesInfo> implements IClassesInfoService {

    /**
     * 分页获取班级信息
     *
     * @param page        分页对象
     * @param classesInfo 班级信息
     * @return 结果
     */
    @Override
    public IPage<LinkedHashMap<String, Object>> selectClassesPage(Page<ClassesInfo> page, ClassesInfo classesInfo) {
        return baseMapper.selectClassesPage(page, classesInfo);
    }
}
