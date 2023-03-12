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

public class BookAddControl implements Command {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookService service = new BookServiceMybatis();
		BookVO addBook = new BookVO();
		
		addBook.setBookCode(request.getParameter("book_code"));
		addBook.setBookAuthor(request.getParameter("book_author"));
		addBook.setBookTitle(request.getParameter("book_title"));
		addBook.setBookPress(request.getParameter("book_press"));
		addBook.setBookDesc(request.getParameter("book_desc"));
		addBook.setBookPrice(Integer.parseInt(request.getParameter("book_price")));
		boolean add = service.addBook(addBook);
		request.setAttribute("result", add);
		
		System.out.println("BookAddControl 클래스의 쿼리결과에 대한 참/거짓 결과 : " + request.getAttribute("result"));
		System.out.println("BookAddControl 클래스의 쿼리결과에 대한 참/거짓 결과 : " + add);
		if(add = true) {
			String path = "bookAddForm.do";//등록되었다면, 페이지 다시띄움, 등록실패 시, 창을 이동하지 않음
			request.getRequestDispatcher(path).forward(request, response);
			
		}
		
		
//		request.setAttribute("bookList", list);
		
		

	
	}

}
