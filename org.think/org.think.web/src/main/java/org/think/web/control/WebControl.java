package org.think.web.control;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebControl {

	@RequestMapping("/web/getwebtest")
	public ModelAndView getCorePage(){
		 Map<String, Object> map = new HashMap<>();  
		 map.put("name", "core");
		 System.out.println("------WebControl!!!--------");
		return new ModelAndView("webtest", map);
	} 
}
