package co.yedam.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;

public class BookAddForm implements Command {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "WEB-INF/book/bookAddForm.jsp";
		System.out.println("BoodAddControl 작동 됨 - ");
		if(request.getAttribute("result") == null) {
			request.setAttribute("result", false);
			System.out.println("이 값이 true이면, al1ert창을 띄웁니다 : " + request.getAttribute("result") + "\n 이 값은 BookAddForm에 존재 합니다.");
		}
		
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
