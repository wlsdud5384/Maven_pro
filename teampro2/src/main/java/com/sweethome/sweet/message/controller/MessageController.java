package com.sweethome.sweet.message.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


public interface MessageController {
	
	public ModelAndView selectAllMessageList(@RequestParam("member_id")  String send_id,HttpServletRequest request, HttpServletResponse response)  throws Exception;
	
}
