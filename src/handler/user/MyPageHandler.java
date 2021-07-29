package handler.user;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import dto.MemberDto;
import dto.PaymentDto;
import dto.join.PostContentDto;
import service.inter.MemberService;
import service.inter.PaymentService;
import service.inter.PostService;
import service.inter.ReplyService;
import service.inter.ReviewService;
import util.AppCancelReason;


@Controller
public class MyPageHandler {
	
	@Resource
	PostService postService;
	
	@Resource
	PaymentService paymentService;
	
	@Resource
	ReviewService reviewService;
	
	@Resource
	ReplyService replyService;
	
	@Resource
	MemberService memberService;
	
	@RequestMapping("/mypage/posts/payable")
	public ModelAndView payable(String pageNum) {
		
		ModelAndView mav = new ModelAndView("user/template/mypageTemplate");
		mav.addObject("page","/WEB-INF/views/user/mypage/myPayablePost");
	
		int member_id = Integer.parseInt(((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession().getAttribute("member_id").toString());

		Map<String, Object> map = postService.myPostListByStatus(pageNum, member_id, "P");
		
		mav.addObject("postListDto", map.get("postListDto"));
		mav.addObject("info", map.get("info"));
		
		return mav;
	}
		
	@RequestMapping("/mypage/posts/payable/pay")
	public ModelAndView payPost(int total_price, int application_id) {
		
		ModelAndView mav = new ModelAndView("user/template/mypageTemplate");
		mav.addObject("page","/WEB-INF/views/user/mypage/payPost");
		
		int member_id = Integer.parseInt(((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession().getAttribute("member_id").toString());

		mav.addObject("total_price", total_price);
		mav.addObject("application_id", application_id);
		mav.addObject("memberDto", paymentService.getUserInfo(member_id));
		
		return mav;
	}
	
	@RequestMapping("/mypage/posts/payable/paypro")
	public ModelAndView payPostPro(PaymentDto payment) {
		
		ModelAndView mav = new ModelAndView("user/pro/payPostPro");
	
		mav.addObject("result", paymentService.payment(payment));
		
		return mav;
	}
	
	@RequestMapping("/mypage/posts/apply")
	public ModelAndView apply(String pageNum) {
		
		ModelAndView mav = new ModelAndView("user/template/mypageTemplate");
		mav.addObject("page","/WEB-INF/views/user/mypage/myApplyPost");
	
		int member_id = Integer.parseInt(((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession().getAttribute("member_id").toString());

		Map<String, Object> map = postService.myPostListByStatus(pageNum, member_id, "A");
		
		mav.addObject("postListDto", map.get("postListDto"));
		mav.addObject("info", map.get("info"));
		
		return mav;
	}
	
	@RequestMapping("/mypage/posts/apply/cancelpro")
	public ModelAndView cancelAppPro(int application_id, AppCancelReason reason) {
		
		ModelAndView mav = new ModelAndView("user/template/mypageTemplate");
		
		mav.addObject("page","/WEB-INF/views/user/pro/cancelAppPro");
		
		mav.addObject("result", postService.cancelApp(application_id, reason));
		
		return mav;
	}
	
	@RequestMapping("/mypage/posts/payed")
	public ModelAndView payed(String pageNum) {
		
		ModelAndView mav = new ModelAndView("user/template/mypageTemplate");
		mav.addObject("page","/WEB-INF/views/user/mypage/myPayedPost");
	
		int member_id = Integer.parseInt(((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession().getAttribute("member_id").toString());

		Map<String, Object> map = postService.myPostListByStatus(pageNum, member_id, "S");
		
		mav.addObject("postListDto", map.get("postListDto"));
		mav.addObject("info", map.get("info"));
		
		return mav;
	}
				
	@RequestMapping("/mypage/reviews")
	public ModelAndView myReviews(String pageNum) {
		
		ModelAndView mav = new ModelAndView("user/template/mypageTemplate");
		mav.addObject("page","/WEB-INF/views/user/mypage/myReviews");
			
		int member_id = Integer.parseInt(((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession().getAttribute("member_id").toString());

		Map<String, Object> map = reviewService.getMyReviewList(pageNum, member_id);
		
		mav.addObject("reviewContentDtos", map.get("reviewContentDtos"));
		mav.addObject("info", map.get("info"));
		
		return mav;
	}
	
	//내가 쓴 댓글 보기
	@RequestMapping("/mypage/replys")
	public ModelAndView myReplyList() {
		
		ModelAndView mav = new ModelAndView("user/template/mypageTemplate");
		mav.addObject("page","/WEB-INF/views/user/mypage/myReply");
	
		int member_id = Integer.parseInt(((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession().getAttribute("member_id").toString());

		mav.addObject("replyDto", replyService.getMyReply(member_id));

		return mav;
	}
	
	//내 정보 간략 보기
	@RequestMapping("/mypage/info")
	public ModelAndView myInfo() {
		
		ModelAndView mav = new ModelAndView("user/template/mypageTemplate");
		mav.addObject("page","/WEB-INF/views/user/mypage/myInfo");

		int member_id = Integer.parseInt(((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession().getAttribute("member_id").toString());
		
		mav.addObject("memberDto", memberService.getMember(member_id));
		
		return mav;
	}
	
	//정보 수정 비밀번호 입력폼
	@RequestMapping("/mypage/info/check")
	public ModelAndView myInforCheck() {
		
		ModelAndView mav = new ModelAndView("user/template/mypageTemplate");
		mav.addObject("page","/WEB-INF/views/user/mypage/myInfoCheck");
		
		return mav;
	}
	
	//정보 수정 비밀번호 입력폼
	@RequestMapping("/mypage/info/checkpro")
	public ModelAndView myInforCheckPro(String password) {
		
		ModelAndView mav = new ModelAndView("user/template/mypageTemplate");
		mav.addObject("page","/WEB-INF/views/user/pro/myInforCheckPro");
			
		int member_id = Integer.parseInt(((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession().getAttribute("member_id").toString());
		
		mav.addObject("result", memberService.checkMember(member_id, password));
		
		return mav;
	}
	
	//정보 수정 비밀번호 입력폼
	@RequestMapping("/mypage/info/modify")
	public ModelAndView myInforModify() {
		
		ModelAndView mav = new ModelAndView("user/template/mypageTemplate");
		mav.addObject("page","/WEB-INF/views/user/mypage/myInfoModify");
		
		int member_id = Integer.parseInt(((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession().getAttribute("member_id").toString());
		
		mav.addObject("memberDto", memberService.getMember(member_id));
		
		return mav;
	}	
	
	//정부 수정하기
	@RequestMapping("/mypage/info/modifypro")
	public ModelAndView myInforModifyPro(MemberDto member) {
		
		ModelAndView mav = new ModelAndView("user/template/mypageTemplate");
		mav.addObject("page","/WEB-INF/views/user/pro/myInforModifyPro");
		
		int member_id = Integer.parseInt(((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession().getAttribute("member_id").toString());
		
		member.setMember_id(member_id);
		
		mav.addObject("result", memberService.modifyMember(member));

		return mav;
	
	}
	
	
	
}
