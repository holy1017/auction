package auction.detail;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import auction.vo.ItemVO;

/**
 * Handles requests for the application home page.
 * ???��?��??
 */
@Controller
public class detailController {
	
	private final Logger log	= LoggerFactory.getLogger(this.getClass());
										
	@Autowired
	public detailService svc = null;
	
	@RequestMapping(value = "/detail.ac", method = RequestMethod.POST)
	public String detail(ModelMap model,@ModelAttribute("bvo") ItemVO vo) {
			
		ItemVO list = svc.select(vo);
		model.addAttribute("list", list);// spring
		
		return "item_detail";
		//return "forward:test";
	}
	
	
	
	
	
	
	
}
