package com.hanzoy.xueta.service.impl;

import com.hanzoy.utils.JWTUtils;
import com.hanzoy.xueta.domain.User;
import com.hanzoy.xueta.domain.UserExample;
import com.hanzoy.xueta.dto.CommonResult;
import com.hanzoy.xueta.exception.TokenErrorException;
import com.hanzoy.xueta.mapper.UserMapper;
import com.hanzoy.xueta.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    public static final String SING = "SIPC_Hanzoy@xueta";
    public static final int TIME =  60*60*24*7;

    public JWTUtils jwtUtils;

    public UserServiceImpl(){
        jwtUtils = new JWTUtils(SING, TIME);
    }
    @Resource
    UserMapper userMapper;

    @Override
    public CommonResult login(String username, String password) {
        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andUsernameEqualTo(username)
                .andPasswordEqualTo(password);
        List<User> users = userMapper.selectByExample(userExample);
        if(users.isEmpty()){
            return CommonResult.fail("1000", "用户名或密码错误");
        }
        HashMap<String, String> data = new HashMap<>();
        data.put("token", jwtUtils.createToken(users.get(0)));
        return CommonResult.success("0000", "一切正常", data);
    }

    @Override
    public User check(String token) {
        if(!jwtUtils.checkToken(token)){
            throw new TokenErrorException("失效的token");
        }
        return jwtUtils.getBean(token, User.class);
    }

    @Override
    public CommonResult changePassword(User user, String oldPassword, String newPassword) {
        User user1 = userMapper.selectByPrimaryKey(user.getId());
        if (!user1.getPassword().equals(oldPassword)) {
            return CommonResult.fail("1000", "用户密码错误");
        }
        user1.setPassword(newPassword);
        userMapper.updateByPrimaryKey(user1);
        return CommonResult.success(null);
    }

}
