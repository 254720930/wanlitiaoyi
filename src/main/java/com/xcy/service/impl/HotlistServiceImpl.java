package com.xcy.service.impl;

import com.xcy.mapper.HotlistMapper;
import com.xcy.pojo.Hotlist;
import com.xcy.service.HotlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: http://www/qfedu.com
 * @Date: 2019/7/18
 * @Description:
 * @version: 1.0
 */
@Service
public class HotlistServiceImpl implements HotlistService {

    @Autowired
    HotlistMapper hotlistMapper;


    @Override
    public List<Hotlist> selectAllHotlist() {
        List<Hotlist> hotlists = hotlistMapper.selectAllHotlist();
        return hotlists;
    }
}
