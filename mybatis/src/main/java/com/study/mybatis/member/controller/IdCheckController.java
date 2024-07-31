package com.study.mybatis.member.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.study.mybatis.member.service.MemberServicelmpl;


public class IdCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;
/* 다음 순서 : MemberServiceImpl */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("id");
		
		int result = new MemberServicelmpl().checkId(userId);
		if(result > 0) {
			response.getWriter().print("idN");
		}else {
			response.getWriter().print("idY");
		}
	}

}

/*
 $(() => {
         const $idInput = $("#id");
         $idInput.keyup(function() {
            if($idInput.val().length >= 5) {
               $.ajax({
                  url: "idCheck.me",
                  data : {id : $idInput.val()},
         memberEnrollForm.jsp에 있는 함수를 가져옴          
*/