package com.myspring.proTest.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myspring.proTest.member.vo.TestVO;

public interface TestController {
public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	public ModelAndView addMember(@ModelAttribute("info") TestVO testVO, HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	public ModelAndView removeMember(@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception;

	public ModelAndView login(@ModelAttribute("member") TestVO member, RedirectAttributes rAttr, HttpServletRequest request, HttpServletResponse response) throws Exception;

	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	public ModelAndView modMember(@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception;
	

	public ModelAndView updateMember(@ModelAttribute("member") TestVO member, HttpServletRequest request, HttpServletResponse response)
			throws Exception;

	
	
	
	
}
