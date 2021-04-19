package com.example.demo.controller;


import com.example.demo.entity.SysJob;
import com.example.demo.exception.BizException;
import com.example.demo.service.ISysJobService;
import com.example.demo.util.SchedulerUtil;
import com.google.common.base.Joiner;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import net.sf.jsqlparser.statement.select.Join;
import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.bcel.classfile.Constant;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liujie
 * @since 2021-04-19
 */
@RestController
@RequestMapping("/sys-job")
@Api("quartz配置")
@Slf4j
public class SysJobController {
    @Autowired
    ISysJobService sysJobService;
    @GetMapping("/selectAll")
    @ApiOperation("查询所有")
    public String selectAll(){
        List<SysJob> list = sysJobService.list();
        List<String> s = new ArrayList<>();
        list.forEach(o->{
            s.add(o.toString());
        });
        return Joiner.on(",").join(s);
    }


    /**
     * 修改定时表达式
     */
    @GetMapping("/reSchedulejob")
    @ApiOperation("动态修改-quartz配置并生效")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "任务唯一ID",  paramType = "query", required = true, dataType =  "Integer"),
            @ApiImplicitParam(name = "jobCron", value = "触发器表达式",  paramType = "query", required = true, dataType =  "string")
    })
    public int updateByBean(@RequestParam("id") Integer id, @RequestParam("jobCron") String jobCron) throws Exception {
        log.info("修改定时任务信息开始... ...");
        int num =0;
        SysJob result = sysJobService.getById(id);
        // 数据不存在
        if (null == result) {
            throw new BizException("根据任务ID[" + id + "]未查到相应的任务记录");
        }
        SysJob bean = new SysJob();
        bean.setId(id);
        bean.setJobCron(jobCron);
        try {
            sysJobService.updateById(bean);
        } catch (Exception e) {
            throw new BizException("变更任务表达式异常：" + e.getMessage());
        }
        //只有任务状态为启用，才开始运行
        // 如果先启动再手工插入数据，此处会报空指针异常
        if( result.getJobStatus() == 1 ){
            SchedulerUtil.jobReschedule(result.getJobName(), result.getJobGroup(),jobCron);
        }

        // 返回成功
        return num;
    }
}
