package com.xcy.mapper;

import com.xcy.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Administrator on 2019/7/18.
 */
@Mapper
public interface UserApplyMapper {
    List<User>selectUserApply();
    void insertUserApply(User user);
}
