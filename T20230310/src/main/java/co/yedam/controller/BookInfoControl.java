package co.yedam.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.service.BookService;
import co.yedam.service.BookServiceMybatis;
import co.yedam.vo.BookVO;

public class BookInfoControl implements Command {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("dan");
		System.out.println(code);
		BookService service = new BookServiceMybatis();
		BookVO infoBook = service.getBookInfo(code);
		
		System.out.println(infoBook.getBookTitle());//테스트
		
		request.setAttribute("bookCode", infoBook.getBookCode());
		request.setAttribute("bookTitle", infoBook.getBookTitle());
		request.setAttribute("bookAuthor", infoBook.getBookAuthor());
		request.setAttribute("bookPress", infoBook.getBookPress());
		request.setAttribute("bookDesc", infoBook.getBookDesc());
		request.setAttribute("bookPrice", infoBook.getBookPrice());
		
		String path = "WEB-INF/book/bookInfo.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}

}
