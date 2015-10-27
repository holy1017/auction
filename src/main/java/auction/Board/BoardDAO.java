package auction.Board;

import java.util.List;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import auction.test.testVO;
import auction.vo.BoardVO;
import common.Paging;

@Repository
public class BoardDAO {
	
	Logger						log	= Logger.getLogger(this.getClass());
									
	@Autowired
	@Qualifier("auctionSession") // 빈즈에서 등록된 id중 auctionSessiontest를 찿아서 가져옴
	// @Qualifier("scottSession")
	public SqlSessionTemplate	sql	= null;
									
	public List<BoardVO> selectListLast(int pageCount) {
		// TODO Auto-generated method stub
		log.info("selectListLast 호출 성공");
		List<BoardVO> List = sql.selectList("Board.SelectList", pageCount);
		return List;
	}
	
	/**
	 * wjscp 전체 게시물 개수
	 * 
	 * @return
	 */
	public int selectTotalCount() {
		log.info("selectTotalCount 호출 성공");
		// TODO Auto-generated method stub
		return sql.selectOne("Board.SelectTotalCount");
	}
	
	public List<BoardVO> selectList(Paging paging) {
		// TODO Auto-generated method stub
		log.info("selectList 호출 성공");
//		log.info(paging.getPageSize());
//		log.info(paging.getFirstPageNo());
//		log.info(paging.getPrevPageNo());
//		log.info(paging.getStartPageNo());
//		log.info(paging.getPageNo());
//		log.info(paging.getEndPageNo());
//		log.info(paging.getNextPageNo());
//		log.info(paging.getFinalPageNo());
//		log.info(paging.getTotalCount());
		
		List<BoardVO> List = sql.selectList("Board.SelectList", paging);
		log.info("selectList 호출 성공 return"+List);
		return List;
	}

	public int boardInsert(BoardVO vo) {
		// TODO Auto-generated method stub
		log.info("boardInsert 호출 성공 :"+vo);
		return sql.insert("Board.boardInsert", vo);
	}
	
}
