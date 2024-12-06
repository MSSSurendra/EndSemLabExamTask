package com.klef.jfsd;

import javax.websocket.server.PathParam;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	   mv.setViewName("demo"); // demo is view name or jsp file name
	   return mv;
   }
	
	@GetMapping(path = "/demo1")
	public ModelAndView demo1()
	{
		ModelAndView mv = new ModelAndView("demo1");
		return mv;
	}
	
	
	
	
	
	
	
	@GetMapping("jfsd")
	@ResponseBody
	public String jfsd()
	{
		return "I am ready bro";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	@GetMapping("demo2")
	public ModelAndView demo2()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("demo2");
		return mv;
	}
	@GetMapping("demo3")
	@ResponseBody
	public String demo3()
	{
		return "Spring Web MVC";
	}
	
	@GetMapping("/add")
	@ResponseBody
	public String add(@RequestParam("x") int a,@RequestParam("y")  int b)
	{
		int c = a+b;
		return Integer.toString(c);
	}
	
	@GetMapping("/displayname")
	@ResponseBody
	public String displayname(@RequestParam("fname") String f,@RequestParam("lname") String l)
	{
		return f+" "+l;
	}
	
	@GetMapping("/displayid")
	@ResponseBody
	public String displayid(@RequestParam("id") int eid)
	{
		return Integer.toString(eid);
	}
	
	@GetMapping("viewname/{fname}/{lname}")
	@ResponseBody
	public String viewname(@PathVariable("fname") String x, @PathVariable("lname") String y)
	{
		return x+" "+y;
	}
	
	@GetMapping("viewid/{eid}")
	@ResponseBody
	public String viewid(@PathVariable("eid") int id)
	{
		return Integer.toString(id);
	}
	
	@GetMapping("mul/{a}/{b}")
	@ResponseBody
	public String mul(@PathVariable("a") int x, @PathVariable("b") int y)
	{
		int z= x*y;
		return Integer.toString(z);
	}
	
	@GetMapping("display")
	public ModelAndView display()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("display");
		mv.addObject("name", "KLU");
		return mv;
	}
	@GetMapping("sub")
	public ModelAndView sub(@RequestParam("a")int x, @RequestParam("b") int y)
	{
		int z = x-y;
		ModelAndView mv = new ModelAndView("output");
		mv.addObject("result", z);
		return mv;
	}
	
	@GetMapping("show/{fname}/{lname}")
	public ModelAndView show(@PathVariable("fname")String x, @PathVariable("lname")String y)
	{
		String z= x+""+y;
		ModelAndView mv = new ModelAndView();
		mv.setViewName("show");
		mv.addObject("fname",x.toUpperCase());
		mv.addObject("lname",y.toUpperCase());
		mv.addObject(" name",z.toUpperCase());
		return mv;
	}
	
	
	
}
