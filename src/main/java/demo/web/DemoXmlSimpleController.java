package demo.web;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class DemoXmlSimpleController implements Controller {
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if ("POST".equals(request.getMethod())) {
            response.getWriter().write("in post method ");
            return null;
        } else if ("GET".equals(request.getMethod())) {
            final String id = request.getParameter("id");
            final String name = request.getParameter("name");
            Map<String, String> data = new HashMap<String, String>() {{
                put("id", id);
                put("name", name);
            }};
            return new ModelAndView("demo", data);
        } else {
            return null;
        }
    }
}
