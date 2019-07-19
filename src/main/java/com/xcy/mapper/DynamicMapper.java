package com.xcy.mapper;

import com.xcy.pojo.Dynamic;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Auther: http://www/qfedu.com
 * @Date: 2019/7/19
 * @Description:
 * @version: 1.0
 */
@Mapper
public interface DynamicMapper {
    int addDynamic(Dynamic dynamic);

}
