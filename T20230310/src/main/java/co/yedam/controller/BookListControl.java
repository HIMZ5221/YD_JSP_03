package co.yedam.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.service.BookService;
import co.yedam.service.BookServiceMybatis;
import co.yedam.vo.BookVO;

public class BookListControl implements Command {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = "WEB-INF/book/bookList.jsp";
		BookService service = new BookServiceMybatis();
		List<BookVO>list = service.bookList();
		for(BookVO i : list) {
			System.out.println(i);
		}
		
		request.setAttribute("bookList", list);
		
		
		request.getRequestDispatcher(path).forward(request, response);

	}

}
