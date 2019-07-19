package com.xcy.mapper;

import com.xcy.pojo.Hotlist;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Auther: http://www/qfedu.com
 * @Date: 2019/7/18
 * @Description:
 * @version: 1.0
 */

@Mapper
public interface HotlistMapper {
    List<Hotlist> selectAllHotlist();

}
