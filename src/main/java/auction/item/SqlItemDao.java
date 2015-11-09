package auction.item;

import java.util.List;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import auction.vo.ItemVO;

@Service
public class SqlItemDao {
	Logger logger = Logger.getLogger(SqlItemDao.class);
	
	@Autowired
	@Qualifier("auctionSession")
	private SqlSessionTemplate sqlSession = null;

	public List<ItemVO> getItemList(ItemVO ivo){
		logger.info("getItemList dao호출");
		List<ItemVO> iList = sqlSession.selectList("getItemList",ivo);		
		return iList;
	}

	


}
