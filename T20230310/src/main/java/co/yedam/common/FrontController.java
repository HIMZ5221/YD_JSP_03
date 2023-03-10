package co.yedam.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.controller.BookAddControl;
import co.yedam.controller.BookAddForm;
import co.yedam.controller.BookInfoControl;
import co.yedam.controller.BookListControl;
import co.yedam.controller.BookSearchControl;
import co.yedam.controller.BookSearchForm;
import co.yedam.controller.BookUpdateControl;

public class FrontController extends HttpServlet {

	Map<String, Command> map;
	String encoding;

	public FrontController() {
		map = new HashMap<>();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		encoding = config.getInitParameter("enc");

		map.put("/main.do", new MainControl()); // 메인페이지(참고)

		map.put("/bookList.do", new BookListControl()); // 목록
		map.put("/bookAddForm.do", new BookAddForm()); // 등록화면
		map.put("/bookAdd.do", new BookAddControl()); // 등록처리
		map.put("/bookInfo.do", new BookInfoControl()); // 상세보기
		
		map.put("/bookUpdate.do", new BookUpdateControl());
		map.put("/bookSearchForm.do", new BookSearchForm());
		map.put("/bookSearchControl.do", new BookSearchControl());
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding(encoding);

		String uri = req.getRequestURI();
		String context = req.getContextPath();
		String page = uri.substring(context.length());
		System.out.println(page);

		Command command = map.get(page);
		command.exec(req, resp);

	}
}
