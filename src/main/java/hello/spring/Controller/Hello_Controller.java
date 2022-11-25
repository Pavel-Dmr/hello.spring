package hello.spring.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class Hello_Controller {

    @GetMapping("Hello")
    public String Hello(Model model)
    {
        model.addAttribute("data","Hello!");
        return "Hello";
    }

    @GetMapping("/Fruit")
    public String Get_Fruit(Model model)
    {
        Map<String,String> fruit_map = new HashMap<>();
        fruit_map.put("fruit1","apple");
        fruit_map.put("fruit2","banana");
        fruit_map.put("fruit3","orange");
        model.addAttribute("fruit",fruit_map);
        return "Fruit/Fruit";

    }

//    ?name=spring url뒤에 붙여 사용
    @GetMapping("Hello-MVC")
    public String HelloMVC(@RequestParam("name") String name,Model model)
    {
        model.addAttribute("name",name);
        return "Hello_Template";
    }

//    단순 API 방식 - String 값 가지고 오기

    @GetMapping("Hello_String")
    @ResponseBody
    public String Hello_String(@RequestParam("name") String name)
    {
        return "Hello" + name;
    }

    @ResponseBody
    @GetMapping("Hello_API")
    public Hello Hello_API(@RequestParam("name") String name)
    {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello
    {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
