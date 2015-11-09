package auction.InsertItem;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import auction.vo.ItemVO;

@Repository
public class InsertItemDao {
	@Autowired
	@Qualifier("auctionSession")
	private SqlSessionTemplate sqlSession = null;
	
	Logger logger = Logger.getLogger(InsertItemDao.class);
	public int write(ItemVO ivo){
		logger.info("DAO - write 호출 성공");
		
		int result = sqlSession.insert("write",ivo);
		logger.info("들어옴");
		
		return result;
	}
	public int delete(int a_no) {
		logger.info("DAO - delete 호출 성공");
		
		int result = sqlSession.delete("delete",a_no);
		return result;
	}
}
