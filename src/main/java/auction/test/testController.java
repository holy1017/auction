package auction.test;

import java.util.Iterator;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import common.CommandMap;

/**
 * Handles requests for the application home page.
 * 테스트용.
 * 빈즈에 자동으로 등록됨.
 * spring MVC의 Controller 클래스 선언을 단순화시켜준다. 스프링 컨트롤러,
 * 서블릿을 상속할 필요가 없으며, @Controller로 등록된 클래스 파일에 대한 bean을 자동으로 생성해준다.
 * Controller로 사용하고자 하는 클래스에 @Controller 지정해 주면 component-scan으로 자동 등록된다.
 */
@Controller
public class testController {
	
	private static final Logger	log	= LoggerFactory.getLogger(testController.class);
										
	/*
	 * @Controller 안에 있는 @Autowired는
	 * 
	 * @Service로 지정된걸 참조함
	 */
	@Autowired
	public testService			svc		= null;
										
	/* 다중지정 가능 */
	// @RequestMapping(value={"/addMovie.do", "/updateMovie.do" })
	/* 메소드 종류 */
	// @RequestMapping(method = RequestMethod.GET)
	/* 파라메터값 */
	// @RequestMapping(params = {"param1=a", "param2", "!myParam"})
	/* <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR"> 의 테그값을 참조하는 예제 */
	// @RequestMapping(value="/movie.do", headers="content-type=text/*")
	@RequestMapping(value = "/test.ac", method = RequestMethod.POST)
	public String test(ModelMap model, @ModelAttribute("testVO") testVO vo, HttpServletRequest req,
	        HttpServletResponse res) {
			
		// String test = req.getParameter("test");
		// logger.info("Welcome test! {}", test);
		// req.setAttribute("test", test);
		//
		// List<testVO> list = svc.select(vo);
		// model.addAttribute("list", list);// spring
		// model.addAttribute("pageItems", 1234);// spring
		// model.addAttribute("pageOnItems", 10);// spring
		// model.addAttribute("pageNum", 15);// spring
		return "test";
	}
	
	@RequestMapping(value = "/testMapArgumentResolver.ac")
	public ModelAndView testMapArgumentResolver(CommandMap commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("");
		
		if (commandMap.isEmpty() == false) {
			Iterator<Entry<String, Object>> iterator = commandMap.getMap().entrySet().iterator();
			Entry<String, Object> entry = null;
			while (iterator.hasNext()) {
				entry = iterator.next();
				log.debug("key : " + entry.getKey() + ", value : " + entry.getValue());
			}
		}
		return mv;
	}
}
