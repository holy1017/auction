package auction.bidder;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import auction.vo.ItemVO;

@Controller
public class BidderController{
	Logger logger = Logger.getLogger(BidderController.class);
	
	@Autowired
	private BidderLogic BidderLogic = null;
	
	/*********************************************************************
	 * 글목록화면 호출하기 
	 ***************************************************************************/
//	@RequestMapping(value="/itemList.ac")
//	public String getBoardList(@ModelAttribute("bvo") BidderVO bvo, ModelMap pMap){
//		logger.info("글쓰기화면 호출 성공");
//		List<BidderVO> bList = new ArrayList<BidderVO>();
//		bList = BidderLogic.getBidderList(bvo);
//	    pMap.addAttribute("bList", bList);
//		return "bList";
//	}
	
	@RequestMapping(value="/bidderUpdate.ac")
	public String bidderUpdate(Model model, @ModelAttribute("bvo") ItemVO bvo){
		//bvo에는 writeform에서 입력한 값이 들어어있다.
		logger.info("bidderUpdate 호출");
		int result = 0;
		result = BidderLogic.bidderUpdate(bvo);
		
		logger.info("컨트롤 result : "+result);
		
		model.addAttribute("result",result);
		if(result==0){			
			return "forward:detail.ac";
		}else{
			return "forward:detail.ac";			
		}
	}
	//입찰 버튼을 누르면 
	//입찰가랑 
	//현재가격을 
	//DB에서 가져와서 
	//비교를 하고 
	//비교에 따른 나머지 판단을 해야한다.
	//조건: 입력가격 < 현재가격 경고창 띄우고 종료
	//조건 : 입찰시간 > 마감시간 경고창 띄우고 종료
	//else는 Update진행
//
}
