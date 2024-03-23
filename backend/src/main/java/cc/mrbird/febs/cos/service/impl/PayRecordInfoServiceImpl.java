package cc.mrbird.febs.cos.service.impl;

import cc.mrbird.febs.cos.entity.PayRecordInfo;
import cc.mrbird.febs.cos.dao.PayRecordInfoMapper;
import cc.mrbird.febs.cos.service.IPayRecordInfoService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

/**
 * @author Fank gmail - fan1ke2ke@gmail.com
 */
@Service
public class PayRecordInfoServiceImpl extends ServiceImpl<PayRecordInfoMapper, PayRecordInfo> implements IPayRecordInfoService {

    /**
     * 分页获取缴费记录信息
     *
     * @param page         分页对象
     * @param payRecordInfo 缴费记录信息
     * @return 结果
     */
    @Override
    public IPage<LinkedHashMap<String, Object>> selectRecordPage(Page<PayRecordInfo> page, PayRecordInfo payRecordInfo) {
        return baseMapper.selectRecordPage(page, payRecordInfo);
    }
}
