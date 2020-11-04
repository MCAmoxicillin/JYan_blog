package com.jyan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jyan.entity.User;
import com.jyan.mapper.UserMapper;
import com.jyan.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 江延
 * @since 2020-10-30
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    UserMapper userMapper;
    //登录事件
    public boolean login(String name,String pw){
        QueryWrapper<User> wrapper = new QueryWrapper();
        wrapper.eq("username",name);
        User user=userMapper.selectOne(wrapper);
        if(user==null){
            return false;
        }
        return user.getPassword().equals(pw);
    }

}
