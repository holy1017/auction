package auction.login;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import auction.vo.UserVO;

/**
 * Handles requests for the application home page.
 * 테스트용
 */
@Controller
public class LoginController {
	
	private static final Logger	logger	= LoggerFactory.getLogger(LoginController.class);
										
	@Autowired
	public LoginService			svc		= null;
	
	@RequestMapping(value = "/UserLoginForm.ac", method = RequestMethod.POST)
	public String testUserLoginForm(HttpSession session, ModelMap model, @ModelAttribute("UserVO") UserVO vo,
	        HttpServletRequest req, HttpServletResponse res) {
		return "UserLoginForm";
	}
	
	@RequestMapping(value = "/UserLogin.ac", method = RequestMethod.POST)
	public String testUserLogin(HttpSession session, ModelMap model, @ModelAttribute("UserVO") UserVO vo,
	        HttpServletRequest req, HttpServletResponse res) {
			
		UserVO userInfo = null;
		int result = 0;
		try {
			userInfo = svc.userLogin(vo);
			if (userInfo!=null) {
				session.setAttribute("userInfo", userInfo);
				//System.out.println(userInfo);
				result = 1;
			}

		} catch (SQLException e) {
			req.setAttribute("exception", e.getMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			req.setAttribute("exception", e.getMessage());
		}
		model.addAttribute("result", result);// spring
//		model.addAttribute("pageItems", 1234);// spring
//		model.addAttribute("pageOnItems", 10);// spring
//		model.addAttribute("pageNum", 15);// spring
		
		System.out.println(userInfo);
		return "UserLoginResult";
/*		if (userInfo == null) {
			req.setAttribute("msg", "로그인 실패");
			return "test/testUserLoginForm";
		} else {
			return "test";
		}
		*/
	}
	
	@RequestMapping(value ={ "/UserLogout.ac"}, method = RequestMethod.POST)
	public String testUserLogout(HttpSession session) {
		session.removeAttribute("userInfo");
		return "UserLogout";
	}
	

	
}
