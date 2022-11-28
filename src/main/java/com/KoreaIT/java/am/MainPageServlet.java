package com.KoreaIT.java.am;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/home/main")
public class MainPageServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");

		HttpSession session = request.getSession();

		boolean isLogined = false;
		int loginedMemberId = -1;
		String loginedMemberName = (String) session.getAttribute("loginedMemberName");

		if (session.getAttribute("loginedMemberLoginId") != null) {
			loginedMemberId = (int) session.getAttribute("loginedMemberId");
			isLogined = true;
		}

		request.setAttribute("isLogined", isLogined);
		request.setAttribute("loginedMemberId", loginedMemberId);
		request.setAttribute("loginedMemberName", loginedMemberName);

		request.getRequestDispatcher("/jsp/home/main.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}