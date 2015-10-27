package auction.InsertItem;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import auction.test2.testUserVO;
import auction.vo.ItemVO;
import auction.vo.UserVO;
import auction.vo.UsersVO;
@Controller
public class InsertItemController {
	Logger logger = Logger.getLogger(InsertItemController.class);
	
	@Autowired
	private InsertItemLogic itemLogic = null;
	
	@RequestMapping(value="/writeForm.ac")
	public String writeForm(){
		logger.info("writeForm 호출 성공");
		return "writeForm";
	}
	@RequestMapping(value="/write.ac")
	public String write(HttpSession session,@ModelAttribute("ievo") ItemVO ievo, HttpServletRequest req) throws IllegalStateException, IOException{
		logger.info("write 호출성공");
		logger.info("file : " + ievo.getA_file());
		
		String a_imgContext = fileUploadUtil.fileUpload(ievo.getA_file(), req);
		ievo.setA_imgContext(a_imgContext);
		
		
		UserVO uvo = (UserVO) session.getAttribute("userInfo");
		ievo.setU_no(uvo.getU_no());
		logger.info(uvo.getU_no());
		
		
		int result = itemLogic.write(ievo);
		
		if(result == 1){//����
			return "redirect:/itemList.ac";
		}
		else{ 
			return "errer";
		} 
	} 
	@RequestMapping(value="/delete.ac")
	public String delete(@ModelAttribute("ievo") ItemVO ievo){
		logger.info("delete 호출성공");
		int a_no = ievo.getA_no();
		logger.info("a_no : "+a_no);
		int result = itemLogic.delete(a_no);
		if(result == 1){//����
			return "redirect:/itemList.ac";
		}
		else{ 
			return "errer";
		} 
	}
}
