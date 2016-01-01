package org.think.web.user.control;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserControl {

	@RequestMapping("/user/getusertest")
	public ModelAndView getCorePage(){
		 Map<String, Object> map = new HashMap<>();  
		 map.put("name", "core");
		 System.out.println("------UserControl!!!--------");
		return new ModelAndView("user/usertest", map);
	} 
	
}
