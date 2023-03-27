package com.myspring.pro31.ex03;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@EnableAsync
public class MailController {
	@Autowired
	private MailService mailService;
	
	@RequestMapping(value= "/sendMail.do", method = RequestMethod.GET)
	public void sendSimpleMail(HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		mailService.sendMail("wlsdud1384@naver.com", "안냥낭냐아냐", "안녕캬캬캬캬캬캬컄");
		mailService.sendPreConfiguredMail("캬캬캬키키키컄.");
		out.print("메일을 보냈습니다.");
	}
	
	
}
