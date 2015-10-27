package auction.test2;

import java.sql.SQLException;
import java.util.List;

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

/**
 * Handles requests for the application home page.
 * 테스트용
 */
@Controller
public class test2Controller {
	
	private static final Logger	logger	= LoggerFactory.getLogger(test2Controller.class);
										
	@Autowired
	public test2Service			svc		= null;
										
	@RequestMapping(value = "/test2.ac", method = RequestMethod.POST)
	public String test2(HttpSession session, ModelMap model, @ModelAttribute("test2VO") test2VO vo,
	        HttpServletRequest req, HttpServletResponse res) {
			
		String test = req.getParameter("test");
		String test5 = req.getParameter("test5");
		logger.info("Welcome test! {}", test);
		req.setAttribute("test", test);
		req.setAttribute("test5", test5);
		session.setAttribute("ligintest", "ligintest!!!!");
		
		List<test2VO> list = svc.select(vo);
		model.addAttribute("list", list);// spring
		model.addAttribute("pageItems", 1234);// spring
		model.addAttribute("pageOnItems", 10);// spring
		model.addAttribute("pageNum", 15);// spring
		return "test";
		//return "forward:test";
	}
	
	@RequestMapping(value = "/testUserCreateForm.ac", method = RequestMethod.POST)
	public String testUserCreateForm(HttpSession session, ModelMap model, @ModelAttribute("testUserVO") testUserVO vo,
	        HttpServletRequest req, HttpServletResponse res) {
		
		//
		
		return "test/testUserCreateForm";
	}
	
	@RequestMapping(value = "/testUserCreate.ac", method = RequestMethod.POST)
	public String testUserCreate(HttpSession session, ModelMap model, @ModelAttribute("testUserVO") testUserVO vo,
	        HttpServletRequest req, HttpServletResponse res) {
			
		String test = req.getParameter("test");
		String test5 = req.getParameter("test5");
		logger.info("Welcome test! {}", test);
		req.setAttribute("test", test);
		req.setAttribute("test5", test5);
		session.setAttribute("ligintest", "ligintest!!!!");
		
		int result;
		try {
			result = svc.userCreate(vo);
		} catch (SQLException e) {
			result = 0;
			req.setAttribute("exception", e.getMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			result = 0;
			req.setAttribute("exception", e.getMessage());
		}
		req.setAttribute("result", result);
		
		model.addAttribute("result", result);// spring
		model.addAttribute("pageItems", 1234);// spring
		model.addAttribute("pageOnItems", 10);// spring
		model.addAttribute("pageNum", 15);// spring
		return "test";
	}
	
	@RequestMapping(value = "/testUserLoginForm.ac", method = RequestMethod.POST)
	public String testUserLoginForm(HttpSession session, ModelMap model, @ModelAttribute("testUserVO") testUserVO vo,
	        HttpServletRequest req, HttpServletResponse res) {
		return "test/testUserLoginForm";
	}
	
	@RequestMapping(value = "/testUserLogin.ac", method = RequestMethod.POST)
	public String testUserLogin(HttpSession session, ModelMap model, @ModelAttribute("testUserVO") testUserVO vo,
	        HttpServletRequest req, HttpServletResponse res) {
			
		String test = req.getParameter("test");
		String test5 = req.getParameter("test5");
		logger.info("Welcome test! {}", test);
		req.setAttribute("test", test);
		req.setAttribute("test5", test5);
		session.setAttribute("ligintest", "ligintest!!!!");
		
		testUserVO userInfo = null;
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
		model.addAttribute("pageItems", 1234);// spring
		model.addAttribute("pageOnItems", 10);// spring
		model.addAttribute("pageNum", 15);// spring
		
		System.out.println(userInfo);
		return "test/testUserLoginResult";
/*		if (userInfo == null) {
			req.setAttribute("msg", "로그인 실패");
			return "test/testUserLoginForm";
		} else {
			return "test";
		}
		*/
	}
	
	@RequestMapping(value ={ "/testUserLogout.ac"}, method = RequestMethod.POST)
	public String testUserLogout(HttpSession session) {
		session.removeAttribute("userInfo");
		return "test/testUserLogout";
	}
	

	
}
