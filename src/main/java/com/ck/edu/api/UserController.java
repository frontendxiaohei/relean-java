package com.ck.edu.api;

import com.ck.edu.dto.LoginDTO;
import com.ck.edu.utils.R;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;


@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {


    @PostMapping("/login")
    public R login(@RequestBody LoginDTO loginDTO) {
        return R.ok().data("token", "admin");
    }


    @GetMapping("/info")
    public R login(@RequestParam("token") String token) {
        return R.ok()
                .data("roles", Arrays.asList(1,2,3))
                .data("name", "ck")
                .data("avatar", "beijing.aliyuncs.com/avatar/default.jpg");
    }
}
