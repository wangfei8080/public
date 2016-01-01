package org.think.web.core.control;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CoreControl {

	@RequestMapping("/core/getcoretest")
	public ModelAndView getCorePage(){
		 Map<String, Object> map = new HashMap<>();  
		 map.put("name", "core");
		 System.out.println("------CoreControl!!!--------");
		return new ModelAndView("core/coretest", map);
	} 
}
