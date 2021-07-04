package kr.hs.dgsw.Spring_Boot_Practice.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {

        model.addAttribute("data", "hello!!");

        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model ) {
        // RequestParam에서  required = False를 해주면 넘겨주지 않아도 에러가 안남
        // 하지만 Required의 기본 값이 True이기 때문에 웹 주소 상에서 "?변수명 = 변수값"을 추가해주어야됨
        model.addAttribute("name", name);

        return "hello-template";
    }
}
