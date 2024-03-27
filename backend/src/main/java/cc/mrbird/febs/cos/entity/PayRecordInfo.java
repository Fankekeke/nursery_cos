package cc.mrbird.febs.cos.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 缴费记录
 *
 * @author Fank gmail - fan1ke2ke@gmail.com
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class PayRecordInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 学生ID
     */
    private Integer studentId;

    /**
     * 缴费内容
     */
    private Integer feesId;

    /**
     * 缴纳金额
     */
    private BigDecimal price;

    /**
     * 缴费状态（0.未缴费 1.已缴费）
     */
    private String status;

    /**
     * 缴费时间
     */
    private String payDate;

    /**
     * 订单编号
     */
    private String code;

    @TableField(exist = false)
    private String studentName;

    @TableField(exist = false)
    private String studentCode;

    /**
     * 教师ID
     */
    @TableField(exist = false)
    private Integer teacherId;
}
