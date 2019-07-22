package com.xcy.service;

import com.xcy.pojo.Dynamic;

import java.util.List;

/**
 * @Auther: http://www/qfedu.com
 * @Date: 2019/7/19
 * @Description:
 * @version: 1.0
 */
public interface DynamicService {
    int addDynamic(Dynamic dynamic);

    int updateDynamic(Dynamic dynamic);

    int deleteDynamic(int id);

    List<Dynamic> selectAllDynamic();

    int upDynamic(int id,int userId);

    List<Dynamic> selectAllDynamicById(int id);
}
