package co.yedam.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.service.BookService;
import co.yedam.service.BookServiceMybatis;
import co.yedam.vo.BookVO;

public class BookUpdateControl implements Command {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BookService service = new BookServiceMybatis();
		BookVO updateBook = new BookVO();
		
		updateBook.setBookCode(request.getParameter("book_code"));
		updateBook.setBookAuthor(request.getParameter("book_author"));
		updateBook.setBookTitle(request.getParameter("book_title"));
		updateBook.setBookPress(request.getParameter("book_press"));
		updateBook.setBookDesc(request.getParameter("book_desc"));
		updateBook.setBookPrice(Integer.parseInt(request.getParameter("book_price")));
		boolean update = service.updateBook(updateBook);
		request.setAttribute("result", update);
		
		if(update = true) {
			String path = "bookList.do";//등록되었다면, 페이지 다시띄움, 등록실패 시, 창을 이동하지 않음
			request.getRequestDispatcher(path).forward(request, response);
			
		}

	}

}
