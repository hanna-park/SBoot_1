package com.naver.b1.notice;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.naver.b1.util.Pager;


@Controller
@RequestMapping("/notice/**")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;

	@ModelAttribute(name="noticeVO")
	public NoticeVO getNoticeVO(){
		return new NoticeVO(); 
	}
	
	@GetMapping("noticeSelect")
	public ModelAndView noticeSelect(NoticeVO noticeVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		noticeVO = noticeService.noticeSelect(noticeVO);
		
		mv.addObject("noticeVO",noticeVO);
		mv.setViewName("notice/noticeSelect");
		return mv;
	}
	
	@GetMapping("noticeList")
	public ModelAndView noticeList(Pager pager) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		List<NoticeVO> ar = noticeService.noticeList(pager);
		
		mv.addObject("list",ar);
		mv.addObject("pager",pager);
		mv.setViewName("notice/noticeList");
		
		
		return mv;
	}
	
	@GetMapping("noticeWrite")
	public String noticeWrite() {
		//model.addAttribute("noticeVO",new NoticeVO());
		
		return "notice/noticeWrite";
	}
	
	@PostMapping("noticeWrite")
	public ModelAndView noticeWirte(@Valid NoticeVO noticeVO, BindingResult bindingresult,MultipartFile[] files) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		if(bindingresult.hasErrors()) {
			mv.setViewName("notice/noticeWrite");
		}else {
			int result = noticeService.noticeWrite(noticeVO, files);
			String msg="작성실패";
			String path="../";
			
			if(result>0) {
				msg = "작성성공";
			}
			mv.setViewName("common/result");
			mv.addObject("msg",msg);
			mv.addObject("path",path);
		}
		
		return mv;
	}
	

}
