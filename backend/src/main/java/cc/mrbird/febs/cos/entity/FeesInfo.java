package cc.mrbird.febs.cos.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 缴费内容
 *
 * @author Fank gmail - fan1ke2ke@gmail.com
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class FeesInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 缴费内容
     */
    private String name;

    /**
     * 备注
     */
    private String content;

    /**
     * 所属班级
     */
    private Integer classId;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    private String createDate;

    /**
     * 缴费金额
     */
    private BigDecimal price;


}
