package auction.detail;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import auction.vo.ItemVO;

@Repository
public class detailDAO {
	Logger						logger	= Logger.getLogger(this.getClass());
	
	@Autowired
	@Qualifier("auctionSession")
//	@Qualifier("scottSession")
	public SqlSessionTemplate	sql		= null;

	public ItemVO select(ItemVO vo) {
		
		logger.info("detailDAO 호출 성공!!!");
		
		ItemVO dao_vo=sql.selectOne("detail.Select",vo);
		
		
		return dao_vo;
	}
	
	
	
}
