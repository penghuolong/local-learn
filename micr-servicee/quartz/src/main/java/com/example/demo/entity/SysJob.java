package com.example.demo.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author liujie
 * @since 2021-04-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysJob implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private Integer id; //任务ID

    /**
     * 任务名称
     */
    @TableField
    private String jobName;

    /**
     * 任务组名
     */
    @TableField
    private String jobGroup;

    /**
     * 时间表达式
     */
    @TableField
    private String jobCron;

    /**
     * 类路径,全类型
     */
    @TableField
    private String jobClassPath;

    /**
     * 传递map参数
     */
    @TableField
    private String jobDataMap;

    /**
     * 状态:1启用 0停用
     */
    @TableField
    private Integer jobStatus;

    /**
     * 任务功能描述
     */
    @TableField
    private String jobDescribe;


}
