package co.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.DataSource;
import co.yedam.mapper.BookMapper;
import co.yedam.vo.BookVO;

public class BookServiceMybatis implements BookService {

	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	BookMapper mapper = sqlSession.getMapper(BookMapper.class);

	@Override
	public List<BookVO> bookList() { //목록.
		List<BookVO> bookList = mapper.bookList();
		
		
		return bookList;
	}

	@Override
	public boolean addBook(BookVO vo) { //등록.
		int result = mapper.insertBook(vo);
		if(result >= 1) {
			System.out.println(result);
			return true;
		}
		return false;
	}

	@Override
	public BookVO getBookInfo(String bookCode) { //조회.
		System.out.println("BookInfo 쿼리문에 들어가는 bookCode 입니다 = " + bookCode);
		BookVO book = mapper.selectBook(bookCode);
		
		return book;
	}

	@Override
	public boolean updateBook(BookVO vo) {
		System.out.println("UpdateBook 쿼리문에 들어가는 객체의 title입니다" + vo.getBookTitle());
		int result = mapper.updateBook(vo);
		if(result >= 1) {
			System.out.println(result);
			return true;
		}		return false;
	}

	@Override
	public BookVO searchBook(String search) {
		System.out.println("searchBook 쿼리문에 들어가는 객체의 date입니다" + search);
		BookVO result = mapper.searchBook(search);
		
		return result;
	}
	
	

}
