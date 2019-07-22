package com.xcy.mapper;

import com.xcy.pojo.Dynamic;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Auther: http://www/qfedu.com
 * @Date: 2019/7/19
 * @Description:
 * @version: 1.0
 */
@Mapper
public interface DynamicMapper {
    int addDynamic(Dynamic dynamic);

    int updateDynamic(Dynamic dynamic);

    int deleteDynamic(int id);

    List<Dynamic> selectAllDynamic();

    int upDynamic(int id);

    Dynamic selectOldUpDynamic(int userId);

    int downDynamic(Dynamic dynamic);

    List<Dynamic> selectAllDynamicById(int id);
}
