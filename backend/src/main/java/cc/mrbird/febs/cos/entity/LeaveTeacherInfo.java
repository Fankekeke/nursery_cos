package cc.mrbird.febs.cos.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 请假管理
 *
 * @author Fank gmail - fan1ke2ke@gmail.com
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class LeaveTeacherInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 教师ID
     */
    private Integer teacherId;

    /**
     * 请假内容
     */
    private String auditTitle;

    /**
     * 请假天数
     */
    private Integer days;

    /**
     * 状态（0.未审批 1.通过 2.驳回）
     */
    private String status;

    /**
     * 创建时间
     */
    private String createDate;

    /**
     * 请假图片
     */
    private String images;

    /**
     * 审批时间
     */
    private String auditDate;

    @TableField(exist = false)
    private String teacherName;

}
