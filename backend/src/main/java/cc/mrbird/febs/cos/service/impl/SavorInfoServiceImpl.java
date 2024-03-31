package cc.mrbird.febs.cos.service.impl;

import cc.mrbird.febs.cos.dao.CourseInfoMapper;
import cc.mrbird.febs.cos.entity.CourseInfo;
import cc.mrbird.febs.cos.entity.SavorInfo;
import cc.mrbird.febs.cos.dao.SavorInfoMapper;
import cc.mrbird.febs.cos.entity.StudentInfo;
import cc.mrbird.febs.cos.service.ICourseInfoService;
import cc.mrbird.febs.cos.service.ISavorInfoService;
import cc.mrbird.febs.cos.service.IStudentInfoService;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Fank gmail - fan1ke2ke@gmail.com
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SavorInfoServiceImpl extends ServiceImpl<SavorInfoMapper, SavorInfo> implements ISavorInfoService {

    private final IStudentInfoService studentInfoService;

    private final ICourseInfoService courseInfoService;

    private final CourseInfoMapper courseInfoMapper;

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

    /**
     * 学生推荐课程
     *
     * @param userId 学生ID
     * @return 结果
     */
    @Override
    public List<LinkedHashMap<String, Object>> recommendCourses(Integer userId) {
        // 学生信息
        StudentInfo studentInfo = studentInfoService.getOne(Wrappers.<StudentInfo>lambdaQuery().eq(StudentInfo::getUserId, userId));
        // 学生兴趣
        SavorInfo savorInfo = this.getOne(Wrappers.<SavorInfo>lambdaQuery().eq(SavorInfo::getStudentId, studentInfo.getId()));
        String interest = "";
        if (savorInfo != null) {
            interest = savorInfo.getInterest();
        }

        List<String> interestList = Arrays.asList(StrUtil.split(interest, ","));
        // 根据兴趣信息获取课程
        List<CourseInfo> courseInfoList = courseInfoService.list();

        if (CollectionUtil.isEmpty(courseInfoList)) {
            return Collections.emptyList();
        }
        List<CourseInfo> resultList = new ArrayList<>();
        if (CollectionUtil.isEmpty(interestList)) {
            List<Integer> ids = courseInfoList.stream().map(CourseInfo::getId).collect(Collectors.toList());
            return courseInfoMapper.selectCourseByIds(ids);
        }

        for (CourseInfo courseInfo : courseInfoList) {
            for (String s : interestList) {
                if (courseInfo.getContent().contains(s)) {
                    resultList.add(courseInfo);
                    break;
                }
            }
        }
        if (CollectionUtil.isEmpty(resultList)) {
            return Collections.emptyList();
        }
        List<Integer> ids = resultList.stream().map(CourseInfo::getId).collect(Collectors.toList());
        return courseInfoMapper.selectCourseByIds(ids);
    }
}
