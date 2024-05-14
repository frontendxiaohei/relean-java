package com.ck.edu.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ck.edu.entity.User;
import com.ck.edu.mapper.UserMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserMapper userMapper;


    @GetMapping("/findAll")
    public List<User> findAll() {
        return userMapper.selectList(null);
    }

    @PostMapping("/add")
    public String addUser(@RequestBody User user) {
        userMapper.insert(user);
        return "添加成功";
    }

    @PostMapping("/udp")
    public String uptUser(@RequestBody User user) {
        userMapper.updateById(user);
        return "更新成功";
    }

    // 根据id查
    @GetMapping("/id/{id}")
    public User findById(@PathVariable Long id) {
        return userMapper.selectById(id);
    }

    // 根据id批量查
    @GetMapping("/ids")
    public List<User> findByIds(@RequestParam Long[] ids) {
        return userMapper.selectBatchIds(Arrays.asList(ids));
    }

    // 分页
    @GetMapping("/page/{current}/{size}")
    public Map<String, Object> findByPage(@PathVariable Integer current, @PathVariable Integer size) {
        Page<User> page = new Page<>(current, size);
        IPage<User> userIPage = userMapper.selectPage(page, null);
        HashMap<String, Object> mp = new HashMap<>();
        mp.put("list", userIPage.getRecords());
        mp.put("total", userIPage.getTotal());
        return mp;
    }


}
