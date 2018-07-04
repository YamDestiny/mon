package xyz.yamdestiny.mon.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xyz.yamdestiny.mon.module.demo.HelloService;

@RestController
@RequestMapping("/hello")
public class HelloController {
	
	private Logger log = LoggerFactory.getLogger(HelloController.class);
	
	@Autowired
	HelloService helloService;
	
	@GetMapping("/springMVC")
	public String sayHello() {
		String result = helloService.sayHello("Spring MVC");
		log.info(result);
		return result; 
	}

}
