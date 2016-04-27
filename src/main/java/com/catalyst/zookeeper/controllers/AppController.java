package com.catalyst.zookeeper.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * this class handles request mapping to the application web pages
 * @author jgao
 *
 */

@Controller
public class AppController {
	
	/**
	 * map the index page to "/"
	 * @return index.html
	 */
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String index(){
		return "/index.html";
	}
}
