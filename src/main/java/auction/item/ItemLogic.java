package auction.item;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import auction.vo.ItemVO;

@Service
public class ItemLogic {
	Logger logger = Logger.getLogger(ItemLogic.class);
	
	@Autowired
	private SqlItemDao sqlItemDao = null;
	
	public List<ItemVO> getBoardList(ItemVO ivo){
		logger.info("getItemList Logic 호출성공");
		List<ItemVO> iList = null;
		iList = sqlItemDao.getItemList(ivo);
		return iList;
	}

	
}
