package com.jhklab.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");

        return "hello"; // hello.html을 실행시켜라라는 의미
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name", required = false) String name, Model model) {
        // RequestParam 안에서 Command + P를 누르면 넘길수 있는 파라미터가 나옴
        model.addAttribute("name", name);

        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody   // http의 Body부에 내가 이 데이터를 직접 넣어주겠다라는 의미
    public String helloString(@RequestParam(value = "name", required = false) String name) {

        return "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam(value = "name", required = false) String name) {
        Hello hello = new Hello();
        hello.setName(name);

        return hello;
    }


    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
