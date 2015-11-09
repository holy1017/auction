package auction.test2;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
//@RequestMapping("/formTest.ac")
@SessionAttributes({"cart"})
public class GoodsControl {
	private final Logger log	= LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value="/formTest.ac",method = RequestMethod.GET)
	public String getCart(Model model) {
		log.debug("getCart");
		if (!model.containsAttribute("cart")) {
			model.addAttribute("cart", new ArrayList<Goods>());
		}
		return "formTest";
	}
	
	
	@RequestMapping(value="/add.ac", method = RequestMethod.POST)
	public String add(@ModelAttribute Goods goods,
			          @ModelAttribute("cart") List<Goods> cart) {
		log.debug("add");
		cart.add(goods);
		return "redirect:/formTest.ac";
	}
	
	
}