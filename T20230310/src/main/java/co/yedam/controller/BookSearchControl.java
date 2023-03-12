package co.yedam.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.service.BookService;
import co.yedam.service.BookServiceMybatis;
import co.yedam.vo.BookVO;

public class BookSearchControl implements Command {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookService service = new BookServiceMybatis();
		
		BookVO searchBook = service.searchBook(request.getParameter("book_search"));
		
		request.setAttribute("bookCode", searchBook.getBookCode());
		request.setAttribute("bookTitle", searchBook.getBookTitle());
		request.setAttribute("bookAuthor", searchBook.getBookAuthor());
		request.setAttribute("bookPress", searchBook.getBookPress());
		request.setAttribute("bookDesc", searchBook.getBookDesc());
		request.setAttribute("bookPrice", searchBook.getBookPrice());
		
		String path = "WEB-INF/book/bookInfo.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}

}
