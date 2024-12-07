package com.klef.jfsd.exam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClientController 
{
	
	@RequestMapping(path = "/", method = RequestMethod.GET)
   public ModelAndView demo()
   {
	   ModelAndView mv = new ModelAndView();
	   mv.setViewName("demo"); 
	   return mv;
   }
	
	@GetMapping(path = "about")
	public ModelAndView about()
	{
		ModelAndView mv = new ModelAndView("about");
		return mv;
	}
	
	@GetMapping("greet")
	@ResponseBody
	public String greet()
	{
		return "Hello Alice";
	}
	
	
	@GetMapping("/addition")
	@ResponseBody
	public String add(@RequestParam("x") int a,@RequestParam("y")  int b)
	{
		int c = a+b;
		return Integer.toString(c);
	}
	
	
	
	
	
	@GetMapping("viewname/{fname}/{lname}")
	@ResponseBody
	public String viewname(@PathVariable("fname") String x, @PathVariable("lname") String y)
	{
		return x+" "+y;
	}
	
	
	@GetMapping("multiplication/{a}/{b}")
	@ResponseBody
	public String mul(@PathVariable("a") int x, @PathVariable("b") int y)
	{
		int z= x*y;
		return Integer.toString(z);
	}
	
	@GetMapping("/displayname")
	@ResponseBody
	public String displayname(@RequestParam("fname") String f,@RequestParam("lname") String l)
	{
		return f+" "+l;
	}
	
	@GetMapping("division/{a}/{b}")
	@ResponseBody
	public String division(@PathVariable("a") int x, @PathVariable("b") int y)
	{
		int z= x/y;
		return Integer.toString(z);
	}
	
	
	@GetMapping("substraction")
	public ModelAndView substraction(@RequestParam("a")int x, @RequestParam("b") int y)
	{
		int z = x-y;
		ModelAndView mv = new ModelAndView("output");
		mv.addObject("result", z);
		return mv;
	}
	
}