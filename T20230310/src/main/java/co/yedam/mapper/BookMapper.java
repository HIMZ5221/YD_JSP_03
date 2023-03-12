package co.yedam.mapper;

import java.util.List;

import co.yedam.vo.BookVO;

public interface BookMapper {

	// 목록.
	public List<BookVO> bookList();
	// 등록.
	public int insertBook(BookVO vo);
	// 조회.
	public BookVO selectBook(String bookCode);
	
	public int updateBook(BookVO vo);
	
	public BookVO searchBook(String search);
}
