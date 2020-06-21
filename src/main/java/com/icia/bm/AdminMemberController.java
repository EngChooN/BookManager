package com.icia.bm;

import java.io.UnsupportedEncodingException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.icia.bm.dao.MemberDAO;

@Controller
public class AdminMemberController {
	
	@Inject
	MemberDAO memberDAO;

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminLogin(HttpServletRequest request, HttpServletResponse response,Model model) {
		
		return "admin/login";
	}
	@RequestMapping(value = "/admin/loginaction", method = {RequestMethod.GET, RequestMethod.POST})
	public String adminAction(HttpServletRequest request, HttpServletResponse response,Model model) throws UnsupportedEncodingException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String mid = request.getParameter("mid");
		String mpass = request.getParameter("mpass");
		try {
			String memberid = memberDAO.searchmid(mid);
			if(!memberid.equals("root")) {
				model.addAttribute("msg","아이디나 비밀번호가 다릅니다.");
	            model.addAttribute("url","/bm/admin");
			}else {
				String memberpass = memberDAO.searchpass(memberid);
				if(mid.equals(memberid)&&mpass.equals(memberpass)) {
					HttpSession session = request.getSession();
					session.setAttribute("isLogon", true);
					session.setAttribute("mid", mid);
					return "redirect:/admin/home";
				}else {
					model.addAttribute("msg","아이디나 비밀번호가 다릅니다.");
		            model.addAttribute("url","/bm/admin");
				}
			}
		}catch(NullPointerException e) {
			model.addAttribute("msg","아이디나 비밀번호가 다릅니다.");
            model.addAttribute("url","/bm/admin");
		}
		return "/redirectt";
		
	}
	@RequestMapping(value = "/admin/home", method = RequestMethod.GET)
	public String adminHome(HttpServletRequest request, HttpServletResponse response,Model model) {
		HttpSession session = request.getSession();
		String mid = (String)session.getAttribute("mid");
		if(mid.equals("root")) {
			return "admin/home";
		}else {
			return "redirect:/admin";
		}
	}
	@RequestMapping(value = "/admin/mm", method = RequestMethod.GET)
	public String manageMember(HttpServletRequest request, HttpServletResponse response,Model model) {
		
		return "admin/mm";
	}
	
	
	@RequestMapping(value = "/admin/logout", method = RequestMethod.GET)
	public String logOut(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:/admin" ;
	}
}