package auction.detail;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import auction.vo.ItemVO;

@Service
public class detailService {
	
	Logger logger = Logger.getLogger(this.getClass());
	@Autowired
	public detailDAO	dao	= null;
	
	public ItemVO select(ItemVO vo) {
		
		ItemVO s_vo=dao.select(vo);
		return s_vo;
	}
}
