package auction.InsertItem;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import auction.vo.ItemVO;
@Service

public class InsertItemLogic {
	Logger logger = Logger.getLogger(InsertItemLogic.class);
	
	@Autowired
	private InsertItemDao itemDao = null; 
	
	public int write(ItemVO ivo) {
		logger.info(" Logic - write 호출 성공");
		int result = itemDao.write(ivo);
		return result;
	}

	public int delete(int a_no) {
		logger.info(" Logic - delete 호출 성공");
		int result = itemDao.delete(a_no);
		return result;
	}
}