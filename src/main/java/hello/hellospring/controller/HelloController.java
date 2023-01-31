package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        return "hello";
    }
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name", required = false) String name, Model model){// what is Modal?
        /*
        * Param으로 required의 디폴트 값은 true이다. false로 할시 값을 넘기지 않아도 오류가 발생하지 않는다.
        * 값을 넘기지 않을시 null값이 넘어간다.
        * 값을 넘길때는 url > get방식으로 넘기는 것이다.
        * ex) ?name=spring!! 으로 넘길시 name에 spring!!이 탑재되어서 넘어가게 된다.
        * */
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody // what is mean?
    /*
    html의 body를 이야기하는 것이 아니라,
    http에서 헤더, 바디 부가 있는데.. (http 통신 프로토콜이 그렇게 구성 되어있다)
    바디에 리턴값을 직접 넣어주겠다고 하는 뜻이다.
    html 코드가 아예 사라지고, 저 리턴 텍스트 하나만 달랑 있다.
    이런 방식은 잘 사용되지 않는다.
    */
    public String helloString(@RequestParam("name") String name){
        return "hello"+ name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }
    /*
    * 객체를 넘기는 방식이다. api방식으로 가장 많이 사용하는 것
    * json형태로 넘어가게 된다.
    * get방식으로 넘어갈시 {name : 넘겨준값}으로 띄워준다.
    * */
    static class Hello{
        private String name;
        /*
        * getter & setter 는 자바빈 규약임
        * private으로 선언된 것을 외부에서 사용할때 쓰임
        * */
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }
}


