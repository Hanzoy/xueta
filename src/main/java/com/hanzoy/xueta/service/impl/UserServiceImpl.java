package com.hanzoy.xueta.service.impl;

import com.hanzoy.utils.JWTUtils;
import com.hanzoy.xueta.domain.*;
import com.hanzoy.xueta.dto.CommonResult;
import com.hanzoy.xueta.dto.param.PostTimeParam;
import com.hanzoy.xueta.exception.exception.TokenErrorException;
import com.hanzoy.xueta.mapper.GroupsMapper;
import com.hanzoy.xueta.mapper.LabelMapper;
import com.hanzoy.xueta.mapper.UserMapper;
import com.hanzoy.xueta.service.NPCService;
import com.hanzoy.xueta.service.UserService;
import com.hanzoy.xueta.service.VerificationCodeService;
import com.hanzoy.xueta.utils.HttpUtils;
import com.hanzoy.xueta.utils.XhhEnc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Service
public class UserServiceImpl implements UserService {
    public static final String SING = "SIPC_Hanzoy@xueta";
    public static final int TIME = 60 * 60 * 24 * 7;

    public JWTUtils jwtUtils;

    public UserServiceImpl() {
        jwtUtils = new JWTUtils(SING, TIME);
    }

    @Resource
    UserMapper userMapper;

    @Autowired
    VerificationCodeService verificationCodeService;

    @Autowired
    NPCService npcService;

    @Resource
    LabelMapper labelMapper;

    @Resource
    GroupsMapper groupsMapper;

    @Override
    public CommonResult login(String username, String password) {
        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andUsernameEqualTo(username)
                .andPasswordEqualTo(password);
        List<User> users = userMapper.selectByExample(userExample);
        if (users.isEmpty()) {
            return CommonResult.fail("1000", "用户名或密码错误");
        }
        HashMap<String, String> data = new HashMap<>();
        data.put("token", jwtUtils.createToken(users.get(0)));
        return CommonResult.success("0000", "一切正常", data);
    }

    @Override
    public void check(String token) {
        if (!jwtUtils.checkToken(token)) {
            throw new TokenErrorException("失效的token");
        }
    }

    @Override
    public CommonResult changePassword(User user, String oldPassword, String newPassword) {
        User user1 = userMapper.selectByPrimaryKey(user.getId());
        if (!user1.getPassword().equals(oldPassword)) {
            return CommonResult.fail("1000", "用户密码错误");
        }
        user1.setPassword(newPassword);
        if (HttpUtils.changePassword(user1)) {
            userMapper.updateByPrimaryKey(user1);
            return CommonResult.success(null);
        }
        return CommonResult.fail("1002", "修改密码失败");
    }

    @Transactional
    @Override
    public CommonResult register(String username, String password, String phone, String verification) {
        if (usernameIsExistence(username)) {
            return CommonResult.fail("1003", "用户名已经存在");
        }
        if (!verificationCodeService.checkVerificationCode(phone, verification)) {
            return CommonResult.fail("1003", "账号验证码错误");
        }
        User user = new User();
        user.setPhone(phone);
        user.setUsername(username);
        user.setPassword(password);
        user.setMoney(50);
        userMapper.insert(user);

        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andUsernameEqualTo(username);

        List<User> users = userMapper.selectByExample(userExample);

        npcService.registerUser(users.get(0).getId());
        verificationCodeService.deleteVerificationCode(phone);

        HashMap<String, String> data = new HashMap<>();
        data.put("token", jwtUtils.createToken(users.get(0)));


        return CommonResult.success(data);
    }

    @Override
    public User getUserByUsername(String username) {
        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andUsernameEqualTo(username);
        List<User> users = userMapper.selectByExample(userExample);
        if (users.isEmpty()) {
            return null;
        }
        return users.get(0);
    }

    @Override
    public User getUserByPhone(String phone) {
        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andPhoneEqualTo(phone);
        List<User> users = userMapper.selectByExample(userExample);
        if (users.isEmpty()) {
            return null;
        }
        return users.get(0);
    }

    @Override
    public User getUserByToken(String token) {
        check(token);
        return jwtUtils.getBean(token, User.class);
    }

    @Override
    public JWTUtils getJWTUtils() {
        return jwtUtils;
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateByPrimaryKey(user);
    }

    @Override
    public String createTokenFromMap(Map<String, ?> map) {
        return JWTUtils.createTokenFromMap(map, SING, TIME);
    }

    @Override
    public User getUserById(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public CommonResult postPersonTime(PostTimeParam param) {
        return postTime(param, 1);
    }

    @Override
    public CommonResult postTeamTime(PostTimeParam param) {
        return postTime(param, 2);
    }

    @Override
    public CommonResult getUserInfo(String token, String username) {
        User user = getUserByToken(token);

        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andUsernameEqualTo(username);

        List<User> users = userMapper.selectByExample(userExample);
        if (users.isEmpty()) {
            return CommonResult.fail("查询数据为空");
        }
        user = users.get(0);

        LabelExample labelExample = new LabelExample();
        labelExample.createCriteria()
                .andUseridEqualTo(user.getId());
        List<Label> labels = labelMapper.selectByExample(labelExample);

        return null;
    }

    private boolean usernameIsExistence(String username) {
        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andUsernameEqualTo(username);
        List<User> users = userMapper.selectByExample(userExample);
        return !users.isEmpty();
    }

    private CommonResult postTime(PostTimeParam param, int pre) {
        if (XhhEnc.enc(param.getToken() + param.getTime()).equals(param.getSign())) {
            return CommonResult.fail("签名认证失败");
        }
        User user = getUserByToken(param.getToken());
        user = userMapper.selectByPrimaryKey(user.getId());
        LabelExample labelExample = new LabelExample();
        labelExample.createCriteria()
                .andUseridEqualTo(user.getId())
                .andLabelEqualTo(param.getLabel());

        List<Label> labels = labelMapper.selectByExample(labelExample);
        Label label;
        if (labels.isEmpty()) {
            label = new Label();
            label.setWeektime(0);
            label.setAlltime(0);
        } else {
            label = labels.get(0);
        }
        label.setLabel(param.getLabel());
        label.setWeektime(label.getWeektime() + param.getTime());
        label.setAlltime(label.getAlltime() + param.getTime());
        label.setUserid(user.getId());
        user.setMoney(user.getMoney() + param.getTime() * pre);

        param.setGroup(HttpUtils.getGroups(user.getUsername()));
        for (PostTimeParam.Groups groups : param.getGroup()) {
            Groups group = groupsMapper.selectByPrimaryKey(groups.getId());
            if (group == null) {
                group = new Groups();
                group.setAlltime(param.getTime());
                group.setTdtime(param.getTime());
                group.setId(groups.getId());
                group.setNumber(HttpUtils.getNumber(groups.getId()));
                groupsMapper.insert(group);
            }else{
                group.setTdtime(group.getTdtime() + param.getTime());
                group.setAlltime(group.getAlltime() + param.getTime());
                groupsMapper.updateByPrimaryKey(group);
            }
        }

        userMapper.updateByPrimaryKey(user);

        if (label.getId() == null) {
            labelMapper.insert(label);
        } else {
            labelMapper.updateByPrimaryKey(label);
        }

        HashMap<String, Object> data = new HashMap<>();
        data.put("money", user.getMoney());
        return CommonResult.success(data);
    }
}
