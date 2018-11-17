package com.yp.cloud.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by yepeng on 2018/11/17.
 */
@Controller
public class TestController {
    @RequestMapping("test")
    @ResponseBody
    public String test(){
        return "hello security!";
    }
}
