package com.study.mybatis.member.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.study.mybatis.member.service.MemberServicelmpl;
import com.study.mybatis.member.vo.Member;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member m = new Member(); // 멤버 선언
		
		// m이라는 멤버 객체에 userId와 userPwd만 담아준다.
		m.setUserId(request.getParameter("userId"));
		m.setUserPwd(request.getParameter("userPwd"));
		
		// m이라는 객체를 썼는데 왜 loginUser을 썼냐면 id와 Pwd만 쓰기를 위함
		// loginUser는 실제로 데이터베이스에 있는지, 없는지 검증하기위해서 객체선언
		Member loginUser = new MemberServicelmpl().loginMember(m);
		//loginMember(m) 은 MemberService에 선언을 해줘야 오류가 뜨지않는다.
		
		if(loginUser == null) {
			request.setAttribute("errorMsg", "로그인 실패");
			request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
		}else {
			request.getSession().setAttribute("loginUser", loginUser);
			response.sendRedirect(request.getContextPath());
			System.out.println("request.getContextPath() : " + request.getContextPath());
		}
	}

}
