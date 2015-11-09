package auction.Board;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import auction.vo.BoardVO;
import common.Paging;

@Service
public class BoardService {
	Logger			log	= Logger.getLogger(this.getClass());
						
	@Autowired
	public BoardDAO	dao	= null;
						
	/**
	 * 최근글을 가져옴
	 * 
	 * @param pageCount
	 *            출력할 페이지수
	 * @return
	 */
	public List<BoardVO> selectListLast(int pageCount) {
		// TODO Auto-generated method stub
		List<BoardVO> list = dao.selectListLast(pageCount);
		return list;
		
	}
	


	public int selectTotalCount() {
		// TODO Auto-generated method stub
		return dao.selectTotalCount();
	}

	public List<BoardVO> selectLast(Paging paging) {
		// TODO Auto-generated method stub
		log.debug("selectLast Paging ok");
		return dao.selectList(paging);
	}



	public int boardInsert(BoardVO vo) {
		// TODO Auto-generated method stub
		return dao.boardInsert(vo);
	}
	
}
