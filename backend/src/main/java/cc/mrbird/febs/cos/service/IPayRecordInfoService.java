package cc.mrbird.febs.cos.service;

import cc.mrbird.febs.cos.entity.PayRecordInfo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;

/**
 * @author Fank gmail - fan1ke2ke@gmail.com
 */
public interface IPayRecordInfoService extends IService<PayRecordInfo> {

    /**
     * 分页获取缴费记录信息
     *
     * @param page         分页对象
     * @param payRecordInfo 缴费记录信息
     * @return 结果
     */
    IPage<LinkedHashMap<String, Object>> selectRecordPage(Page<PayRecordInfo> page, PayRecordInfo payRecordInfo);
}
