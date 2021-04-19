package com.example.demo.service.impl;

import com.example.demo.entity.SysJob;
import com.example.demo.mapper.SysJobMapper;
import com.example.demo.service.ISysJobService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liujie
 * @since 2021-04-19
 */
@Service
public class SysJobServiceImpl extends ServiceImpl<SysJobMapper, SysJob> implements ISysJobService {

    @Override
    public List<SysJob> querySysJobList(HashMap<String, String> map) {
        Map<String, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.putAll(map);
        return this.listByMap(objectObjectHashMap);
    }
}
