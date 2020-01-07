package com.hqyj.consumer.modules.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hqyj.consumer.modules.test.vo.ConfigTestBean;
@Controller
public class TestController extends SpringBootServletInitializer{
	@Value("${server.port}")
	private int port;
	@Value("${com.hqyj.name}")
	private String name;
	@Value("${com.hqyj.age}")
	private int age;
	@Value("${com.hqyj.description}")
	private String description;
	@Value("${com.hqyj.random}")
	private String random;
	
	
	
	@Autowired
	private ConfigTestBean configTestBean;
	
	@RequestMapping("/test/config")
	@ResponseBody
	public String configTest() {
		StringBuffer sb = new StringBuffer();
		
		sb.append(port).append("----").append("<br>")
			.append(name).append("----").append("<br>")
			.append(age).append("----").append("<br>")
			.append(description).append("----").append("<br>")
			.append(random).append("----").append("<br>");
		
		sb.append(configTestBean.getName()).append("----").append("<br>")
		.append(configTestBean.getAge()).append("----").append("<br>")
		.append(configTestBean.getDescription()).append("----").append("<br>")
		.append(configTestBean.getRandom()).append("----").append("<br>");
		
		return sb.toString();
	}

	
	@RequestMapping("/test/info")
	@ResponseBody
	public String appInfo() {
		return "This is spring boot app.";
	}
}
