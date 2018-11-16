package com.yp.core.system.controller;

import com.yp.core.base.Result;
import com.yp.core.constants.BaseEnums;
import com.yp.core.system.dto.User;
import com.yp.core.system.service.UserService;
import com.yp.core.util.Results;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 用户Controller
 * Created by yepeng on 2018/11/14.
 */
@RequestMapping("sys/user")
@RestController
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;
//    private static List<User> userList = new ArrayList<>();
//
//    //先静态模拟数据
//    static {
//        User user1 = new User();
//        user1.setUserId(1L);
//        user1.setUsername("xiaoming");
//        user1.setNickname("狂战士");
//        user1.setBirthday(Dates.parseDate("1993-05-05"));
//        user1.setGender(Constants.Gender.MALE);
//        user1.setEnabled(Constants.Flag.YES);
//        userList.add(user1);
//
//        User user2 = new User();
//        user2.setUserId(2L);
//        user2.setUsername("lihua");
//        user2.setNickname("修罗");
//        user2.setBirthday(Dates.parseDate("1994/7/3"));
//        user2.setGender(Constants.Gender.FEMALE);
//        user2.setEnabled(Constants.Flag.YES);
//        userList.add(user2);
//    }

    @GetMapping("queryAll")
    public Result queryAll() {
        List<User> list = userService.selectAll();
        return Results.successWithData(list, BaseEnums.SUCCESS.code(), BaseEnums.SUCCESS.desc());
    }

    @GetMapping("queryOne/{userId}")
    public Result queryOne(@PathVariable Long userId) {
        User user = userService.get(userId);

        logger.debug("userId:{},username:{},birthday:{}", user.getUserId(), user.getUsername(), user.getBirthday());
        logger.info("userId:{},username:{},birthday:{}", user.getUserId(), user.getUsername(), user.getBirthday());
        logger.error("userId:{},username:{},birthday:{}", user.getUserId(), user.getUsername(), user.getBirthday());
        return Results.successWithData(user);
    }

    @PostMapping("save")
    public Result save(@Valid @RequestBody User user) {
        user = userService.insertSelective(user);
        return Results.successWithData(user);
    }

    @PostMapping("update")
    public Result update(@Valid @RequestBody List<User> user) {
        user = userService.persistSelective(user);
        return Results.successWithData(user);
    }

    @RequestMapping("delete")
    public Result delete(User user) {
        userService.delete(user);
        return Results.success();
    }

    @RequestMapping("delete/{userId}")
    public Result delete(@PathVariable Long userId) {
        userService.delete(userId);
        return Results.success();
    }
}
