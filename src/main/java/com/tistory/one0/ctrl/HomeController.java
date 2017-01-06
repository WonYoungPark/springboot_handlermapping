package com.tistory.one0.ctrl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Won Young, Park
 * @date 2017-01-06
 */
@RestController
@RequestMapping("home")
public class HomeController {

    @GetMapping(value = "/test1.do")
    public String getGetTest() {
        return "GetMapping Test1";
    }

    @GetMapping(value = "/test2.do")
    public String getGetTest2() {
        return "GetMapping Test2";
    }

    @PostMapping(value = "/test1.do")
    public String getPostTest() {
        return "PostMapping Test1";
    }

    @PostMapping(value = "/test2.do")
    public String getPostTest2() {
        return "PostMapping Test2";
    }
}
