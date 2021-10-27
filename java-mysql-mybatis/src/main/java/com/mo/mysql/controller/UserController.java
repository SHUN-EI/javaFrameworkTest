package com.mo.mysql.controller;

import com.mo.mysql.constant.ResultData;
import com.mo.mysql.dao.UserDao;
import com.mo.mysql.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by mo on 2021/10/27
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserDao userDao;

    @GetMapping("/queryById/{id}")
    public ResultData queryById(@PathVariable Long id) {
        ResultData<User> resultData = new ResultData<>();
        User user = userDao.queryById(id);
        if (user != null) {
            resultData.setMsg("查询用户成功");
            resultData.setData(user);
        } else {
            resultData.setMsg("查询用户失败");
        }
        return resultData;
    }

    @PostMapping("/add")
    public ResultData add(@RequestBody User user) {
        ResultData<User> resultData = new ResultData<>();
        if (user != null) {
            resultData.setData(user);
            resultData.setMsg("新增用户成功");
            userDao.add(user);
        } else {
            resultData.setMsg("新增用户失败");
        }

        return resultData;
    }

    @PostMapping("/update")
    public ResultData update(@RequestBody User user) {
        ResultData<User> resultData = new ResultData<>();
        if (user != null) {
            resultData.setData(user);
            resultData.setMsg("修改用户成功");
            userDao.update(user);
        } else {
            resultData.setMsg("修改用户失败");
        }
        return resultData;
    }

    @GetMapping("/delete/{id}")
    public ResultData delete(@PathVariable Long id) {
        ResultData<User> resultData = new ResultData<>();

        if (userDao.delete(id)) {
            resultData.setMsg("删除用户成功");
        } else {
            resultData.setMsg("删除用户失败");
        }

        return resultData;
    }

    @GetMapping("/queryUserByName/{name}")
    public ResultData queryUserByName(@PathVariable String name) {
        ResultData<List<User>> resultData = new ResultData<>();

        List<User> users = userDao.queryUserByName(name);
        if (users.size() > 0) {
            resultData.setMsg("查询用户成功");
            resultData.setData(users);
        } else {
            resultData.setMsg("查询用户失败");
        }
        return resultData;
    }
}
