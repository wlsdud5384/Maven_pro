package com.myspring.proTest.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myspring.proTest.member.service.TestService;
import com.myspring.proTest.member.vo.TestVO;

@Controller("memberController")
//@EnableAspectJAutoProxy
public class TestControllerImpl implements TestController {
	private static final Logger logger = LoggerFactory.getLogger(TestControllerImpl.class);
	@Autowired
	private TestService testService;
	@Autowired
	private TestVO testVO;
	
	@Override
	@RequestMapping(value="/member/listTest.do", method = RequestMethod.GET)
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		//String viewName = (String)request.getAttribute("viewName");
		//System.out.println("viewName: " + viewName);
		logger.info("viewName: " + viewName);
		logger.debug("viewName: " + viewName);
		List membersList = testService.listMembers();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("membersList", membersList);
		return mav;
	}


	@Override
	@RequestMapping(value="/member/addMember.do", method = RequestMethod.POST)
	public ModelAndView addMember(@ModelAttribute("member") TestVO member, HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		int result = 0;
		result = testService.addMember(member);
		ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");
		return mav;
	}
	
	
	@Override
	@RequestMapping(value="/member/modMember.do", method = RequestMethod.GET)
	public ModelAndView modMember(@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = new ModelAndView();
		TestVO testVO = testService.modMember(id);
		mav.addObject("member", testVO);
		return mav;

	}
	
	
	


	@Override
	@RequestMapping(value="/member/updateMember.do", method = RequestMethod.POST)
	public ModelAndView updateMember(@ModelAttribute("member") TestVO member, HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		System.out.println(member.getName());
		int result = 0;
		result = testService.updateMember(member);
		ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");
		return mav;
	}
	
	
	
	@Override
	@RequestMapping(value="/member/removeMember.do", method = RequestMethod.GET)
	public ModelAndView removeMember(@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		testService.removeMember(id);
		ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");
		return mav;
	}
	
	
	
	
	@RequestMapping(value= {"/member/main.do", "/member/testform.do"}, method = RequestMethod.GET)
	public ModelAndView form(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}
	
	@Override
	@RequestMapping(value= "/member/login.do", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("member") TestVO member, RedirectAttributes rAttr, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		testVO = testService.login(member);
		if(testVO != null) {
			HttpSession session = request.getSession();
			session.setAttribute("member", testVO);
			session.setAttribute("isLogOn", true);
			mav.setViewName("redirect:/member/listMembers.do");
		}else {
			rAttr.addAttribute("result","loginFailed");
			mav.setViewName("redirect:/member/loginForm.do");
		}
		return mav;
	}
	
	@Override
	@RequestMapping(value= "/member/logout.do", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		session.removeAttribute("member");
		session.removeAttribute("isLogOn");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/member/listMembers.do");
		return mav;
	}
	
	
	@RequestMapping(value= "/member/*Form.do", method = RequestMethod.GET)
	public ModelAndView form(@RequestParam(value="result", required=false) String result, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.addObject("result",result);
		mav.setViewName(viewName);
		return mav;
	}
	private String getViewName(HttpServletRequest request) throws Exception {
		String contextPath = request.getContextPath();
		String uri = (String) request.getAttribute("javax.servlet.include.request_uri");
		if(uri == null || uri.trim().equals("")) {
			uri = request.getRequestURI();
		}
		
		int begin = 0;
		if(!((contextPath == null) || ("".equals(contextPath)))) {
			begin = contextPath.length();
		}
		
		int end;
		if(uri.indexOf(";") != -1) {
			end = uri.indexOf(";");
		} else if(uri.indexOf("?") != -1) {
			end = uri.indexOf("?");
		} else {
			end = uri.length();
		}
		
		String viewName = uri.substring(begin, end);
		if(viewName.indexOf(".") != -1) {
			viewName = viewName.substring(0, viewName.lastIndexOf("."));
		}
		if(viewName.lastIndexOf("/") != -1) {
			viewName = viewName.substring(viewName.lastIndexOf("/",1), viewName.length());
		}
		return viewName;
		
	}
	
}