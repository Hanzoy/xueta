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
    public CommonResult check(String username, String password) {
        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andUsernameEqualTo(username)
                .andPasswordEqualTo(password);
        List<User> users = userMapper.selectByExample(userExample);
        if(users.isEmpty()){
            return CommonResult.fail("1000", "用户名或密码错误");
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("username", username);
        HashMap<String, String> data = new HashMap<>();
        data.put("token", jwtUtils.createToken(map));
        return CommonResult.success("0000", "一切正常", data);
    }

    @Override
    public User check(String token) {
        if(!jwtUtils.checkToken(token)){
            throw new TokenErrorException("失效的token");
        }
        User user = new User();
        user.setUsername(jwtUtils.getBeanAsMap(token, String.class).get("token"));
        return user;
    }

}
