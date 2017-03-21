package demo.web;

import demo.entity.Demo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 注解的controller 返回json和模板
 */
@Controller
public class DemoAnnoController {

    @RequestMapping("/getAnnoDemoJson")
    //返回值有@ResponseBody注解，项目包含jackson的包，就可以把返回对象转换为json
    @ResponseBody
    public Demo getAnnoDemoJson(@RequestParam(value = "id", defaultValue = "1") int id, @RequestParam(value = "name", defaultValue = "god") String name) {
        return new Demo(id, name);
    }

    @RequestMapping("/getAnnoDemoView")
    public String getAnnoDemoView(@RequestParam(value = "id", defaultValue = "1") int id, @RequestParam(value = "name", defaultValue = "god") String name, Model model) {
        model.addAttribute("id", id);
        model.addAttribute("name", name);
        return "demo";
    }
}
