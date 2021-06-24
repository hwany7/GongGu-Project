package handler.user;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import service.inter.LoginService;

@Controller
public class LoginHandler {
	
	@Resource(name="loginServiceImpl")
	LoginService loginService;
	
	//로그인 폼으로 이동
	@RequestMapping("/loginForm.do")
	public ModelAndView loginForm() {
		
		ModelAndView mav = new ModelAndView("user/template/beginTemplate");
		
		mav.addObject("page", "/WEB-INF/views/user/login/loginForm");
		
		return mav;
	}
	
	//로그인 기능
	@RequestMapping("/loginPro.do")
	public ModelAndView logInPro(String member_email, String password) {
		
		ModelAndView mav = new ModelAndView("user/login/loginPro");

		mav.addObject("memSession", loginService.directLogin(member_email, password));
		
		return mav;
	}
	
	//휴면 계정 활성화 폼으로 이동
	@RequestMapping("/activateStatus.do")
	public ModelAndView activateStatus() {
		
		ModelAndView mav = new ModelAndView("user/template/beginTemplate");
		
		mav.addObject("page", "/WEB-INF/views/user/login/activateStatus");
		
		return mav;
	}
	
	//휴면 계정 활성화
	@RequestMapping("/activateStatusPro.do")
	public ModelAndView activateStatusPro(HttpServletRequest request, String password) {
		
		ModelAndView mav = new ModelAndView("user/login/activateStatusPro");
		
		int member_id = Integer.parseInt(request.getSession().getAttribute("member_id").toString());
		
		mav.addObject("result", loginService.activateUser(member_id, password));
	
		return mav;
	}
	
	//로그 아웃
	@RequestMapping("/logout.do")
	public String logOutPro(HttpServletRequest request) {
		
		//세션 초기화
		request.getSession().invalidate();

		return "redirect:/loginForm.do";
	}
	
}