package co.yedam.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;

public class BookSearchForm implements Command {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "WEB-INF/book/bookSearchForm.jsp";
		System.out.println("BookSearchForm 작동 됨 - ");
		
		
		request.getRequestDispatcher(path).forward(request, response);

	}

}
