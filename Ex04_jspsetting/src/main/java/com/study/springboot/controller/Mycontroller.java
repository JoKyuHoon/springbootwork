package com.study.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Mycontroller {
	@RequestMapping("/")
	public @ResponseBody String root() {
		return "JSP 실행";
	}
	
	@RequestMapping("/test1") // url => localhost:8080.test2
	public String test1() {   // String => 파일명 / Annotation String => 스트링
		return "test1";       // => /WEB-INF/views/test1.jsp
	}
	
	@RequestMapping("/test2") // url => localhost:8080.test2
	public String test2() {   // String => 파일명 / Annotation String => 스트링
		return "sub/test2";   // => /WEB-INF/views/sub/test2.jsp
	}
}
