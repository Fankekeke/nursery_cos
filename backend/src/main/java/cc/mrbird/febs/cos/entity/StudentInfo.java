package cc.mrbird.febs.cos.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 学生管理
 *
 * @author Fank gmail - fan1ke2ke@gmail.com
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class StudentInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 学生编号
     */
    private String code;

    /**
     * 学生姓名
     */
    private String name;

    /**
     * 出生日期
     */
    private String birthday;

    /**
     * 性别（1.男 2.女）
     */
    private String sex;

    /**
     * 头像
     */
    private String images;

    /**
     * 所属班级
     */
    private Integer classesId;

    /**
     * 学生家长联系方式
     */
    private String phone;

    /**
     * 备注
     */
    private String content;

    /**
     * 创建时间
     */
    private String createDate;

    /**
     * 所属账户
     */
    private Integer userId;

    @TableField(exist = false)
    private Integer teacherId;

    @TableField(exist = false)
    private String interest;

}
