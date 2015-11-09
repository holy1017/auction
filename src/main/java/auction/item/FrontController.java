package auction.item;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import auction.vo.ItemVO;

@Controller
public class FrontController {
	Logger logger = Logger.getLogger(FrontController.class);
	
	@Autowired
	private ItemLogic ItemLogic = null;
	
	/*********************************************************************
	 * 글목록화면 호출하기 
	 ***************************************************************************/
	@RequestMapping(value="/itemList.ac")
	public String getBoardList(@ModelAttribute("ivo") ItemVO ivo, ModelMap pMap){
		logger.info("글쓰기화면 호출 성공");
		List<ItemVO> iList = new ArrayList<ItemVO>();
		iList = ItemLogic.getBoardList(ivo);
	    pMap.addAttribute("iList", iList);
		return "itemList";
	}
	
	
}
