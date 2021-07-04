package kr.hs.dgsw.Spring_Boot_Practice.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    //정적 컨텐츠
    @GetMapping("hello")
    public String hello(Model model) {

        model.addAttribute("data", "hello!!");

        return "hello";
    }

    // MVC 방식
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model ) {
        // RequestParam에서  required = False를 해주면 넘겨주지 않아도 에러가 안남
        // 하지만 Required의 기본 값이 True이기 때문에 웹 주소 상에서 "?변수명 = 변수값"을 추가해주어야됨
        model.addAttribute("name", name);

        return "hello-template";
    }

    // API 방식
    @GetMapping("hello-string")
    @ResponseBody       // ResponseBody 어노테이션을 적어주면 Return 해주는 값이 그대로 전송됨
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();

        hello.setName(name);

        return hello;       // 객체가 return 되면 Json 방식으로 데이터를 변환시켜서 내보내주는 규약이 정의도어있음
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
