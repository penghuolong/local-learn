package com.example.demo.service;

import com.example.demo.entity.SysJob;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liujie
 * @since 2021-04-19
 */
public interface ISysJobService extends IService<SysJob> {

    List<SysJob> querySysJobList(HashMap<String, String> map);
}
