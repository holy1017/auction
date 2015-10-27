package auction.bidder;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import auction.vo.ItemVO;

@Service
public class SqlBidderDao {
	Logger logger = Logger.getLogger(SqlBidderDao.class);
	
	@Autowired
	@Qualifier("auctionSession")
	private SqlSessionTemplate sqlSession = null;

	public int bidderUpdate(ItemVO bvo){
		logger.info("bidderUpdate dao호출");
		int result = 0;
		result = sqlSession.update("bidderUpdate", bvo);
		return result;
	}
	

	public ItemVO bidderSelect(ItemVO ivo) {
		logger.info("bidder Dao 호출 성공!!!");
		ItemVO rvo =sqlSession.selectOne("bidderSelect",ivo);		
		return rvo;
		
	}


	public double biddderDate(ItemVO bvo) {
		logger.info("bidderDate Dao 호출 성공!!!");
		double bidderDate =sqlSession.selectOne("bidderDate",bvo);		
		return bidderDate;
	}



	
	


}
