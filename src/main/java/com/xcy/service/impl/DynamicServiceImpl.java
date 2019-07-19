package com.xcy.service.impl;

import com.xcy.mapper.DynamicMapper;
import com.xcy.pojo.Dynamic;
import com.xcy.service.DynamicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: http://www/qfedu.com
 * @Date: 2019/7/19
 * @Description:
 * @version: 1.0
 */
@Service
public class DynamicServiceImpl implements DynamicService {

    @Autowired
    DynamicMapper dynamicMapper;

    @Override
    public int addDynamic(Dynamic dynamic) {
        return dynamicMapper.addDynamic(dynamic);
    }
}
