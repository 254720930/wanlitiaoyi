package com.xcy.service.impl;

import com.xcy.mapper.DynamicMapper;
import com.xcy.pojo.Dynamic;
import com.xcy.service.DynamicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.List;

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

    @Override
    public int updateDynamic(Dynamic dynamic) {
        return dynamicMapper.updateDynamic(dynamic);
    }

    @Override
    public int deleteDynamic(int id) {
        return dynamicMapper.deleteDynamic(id);
    }

    @Override
    public List<Dynamic> selectAllDynamic() {
        return dynamicMapper.selectAllDynamic();
    }

    @Override
    @Transient
    public int upDynamic(int id,int userId) {
        Dynamic dynamic = dynamicMapper.selectOldUpDynamic(userId);
        if (dynamic != null){
            int b = dynamicMapper.downDynamic(dynamic);
        }
        int a = dynamicMapper.upDynamic(id);
        return a;
    }

    @Override
    public List<Dynamic> selectAllDynamicById(int id) {
        return dynamicMapper.selectAllDynamicById(id);
    }

}
