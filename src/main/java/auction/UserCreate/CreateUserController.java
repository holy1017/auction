package auction.UserCreate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class CreateUserController {

	private static final Logger logger = LoggerFactory.getLogger(CreateUserController.class);
	
	@Autowired
	public CreateUserService	svc	= null;
	
	@RequestMapping(value = "/UserCreateForm.ac", method = RequestMethod.POST)
	public String testUserCreateForm(HttpSession session, ModelMap model, 
	        HttpServletRequest req, HttpServletResponse res) {
		return "createuser";
	}
	@RequestMapping(value="/UserSelect.ac",method = RequestMethod.POST)
	public String userSelect(@ModelAttribute("mem_id") String u_id ,Model model){
		String result;
		int result2;
		logger.info("UserSelect 사용확인"+u_id);
		
		result= svc.UserSelect(u_id);
		
		if(result==null){
			result2 = 1;
			logger.info(result2+"");
		}
		else{
			result2 = 2;
			logger.info(result2+"");
		}
		model.addAttribute("data", result2);
		return "idcheckresult";
		
	}
	
	@RequestMapping(value="/NickSelect.ac",method = RequestMethod.POST)
	public String nickSelect(@ModelAttribute("mem_id") String u_nick ,Model model){
		String result;
		String result2;
		logger.info("NickSelect 사용확인"+u_nick);
		
		result= svc.NickSelect(u_nick);
		
		if(result==null){
			result2 = "1";
			logger.info(result2);
		}
		else{
			result2 = "2";
			logger.info(result2);
		}
		model.addAttribute("data", result2);
		return "idcheckresult";
		
	}
	
	
	
	
	@RequestMapping(value = "/UserCreate.ac", method = RequestMethod.POST)
	public String userCreate(@ModelAttribute("createUserVO") CreateUserVO vo ,Model model){
		
		String result2;
		
		logger.info("createUserController 사용확인");
		logger.info("vo.getU_lv()"+vo.getU_lv());
		
		int result = svc.createUser(vo);
		
		if(result==1){
			result2="축하합니다 가입에 성공하셨습니다.";
		}else{
			result2="가입에 실패 하셨습니다 관리자에게 문의 하세요 ";
		}
		model.addAttribute("result", result2);
		
		return "UserCreateResult";
		
	}
	
}
