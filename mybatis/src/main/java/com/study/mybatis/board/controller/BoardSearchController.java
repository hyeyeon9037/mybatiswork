package com.study.mybatis.board.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import com.study.mybatis.board.service.*;
import com.study.mybatis.common.vo.PageInfo;

public class BoardSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyField = request.getParameter("keyField");
		String keyword = request.getParameter("keyword");
		int nowPage = Integer.parseInt(request.getParameter("nowPage"));
		
		// keyField와 keyword 2개를 모두 담을 bean객체를 만들어 넘기는 방법
		// keyField와 keyword 2개를 HashMap<key, value>를 이용하는 방법
		
		HashMap<String, String> map = new HashMap();
		map.put("keyField", keyField);
		map.put("keyword", keyword);
		
		BoardService bService = new BoardServiceImpl();
		int searchCount = bService.selectSearchCount(map);
		
		PageInfo pi = Pagination.getPageInfo(searchCount, nowPage, 5, 3);
		
		ArrayList<Board> list = bService.selectSearchList(map, pi);
		
	}
}
