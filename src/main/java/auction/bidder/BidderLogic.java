package auction.bidder;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import auction.vo.ItemVO;

@Service
public class BidderLogic {
	Logger logger = Logger.getLogger(BidderLogic.class);
	
	@Autowired
	private SqlBidderDao sqlBidderDao = null;
	
	public int bidderUpdate(ItemVO bvo){
		logger.info("biderUpdate Logic 호출성공");
		//Detail페이지에서 넘어온 값.
		int a_bot_price = bvo.getA_bid_price();
		logger.info("입찰가 : "+a_bot_price);
//		String a_ddate = bvo.getA_ddate();
		
		double bidderDate = sqlBidderDao.biddderDate(bvo);
		logger.info("입찰일자 :"+bidderDate);
		
		int result =0;
		ItemVO rvo = sqlBidderDao.bidderSelect(bvo);
		int r_bot_price = rvo.getA_bot_price(); //최저
		int r_top_price = rvo.getA_top_price(); //최고가
//		String r_ddate = rvo.getA_ddate();
//		logger.info("현재가 :"+r_bot_price+",입찰가 : "+a_bot_price);
		
		
		if(a_bot_price > r_bot_price && bidderDate > 0 && a_bot_price < r_top_price){
			result = sqlBidderDao.bidderUpdate(bvo);
		}		
		logger.info("로직단 result : "+result);
		return result;
	}

	
}