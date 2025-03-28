package com.study.springboot.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.springboot.domain.Member;
import com.study.springboot.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping("/")
	public String root() {
		return "menu";
	}
	
	@RequestMapping("/insert")
	public String insert(@RequestParam("username") String name, Model model) {
		Member member = Member.builder()
							  .username(name)
							  .createDate(LocalDate.now())
							  .build();
		
		Member result = memberService.insert(member);
		
		model.addAttribute("member", result);
		return "insert";
	}
	
	@RequestMapping("/select")
	public String select(@RequestParam("id") Long id, Model model) {
		/*
		 * Optional<T> : NullpointerException 발생을 방지하기 위해
		  				 기존의 반환 값 타입 T에 Optional<T>를 wrapping하여,
		  				 null 대신 Optional안에 빈 타입 객체를 돌려주는 기법
		  	ex) Member member = memberRepository.findById("user01"); => 없는 아아디
		  		member.getUserName(); => NullpointerException
		 
		 */
		Optional<Member> result = memberService.select(id);
		if (result.isPresent()) { // isPresent() : 데이터가 있는지 없는지 체크 
			model.addAttribute("member", result.get());
		} else {
			model.addAttribute("member", null);
		}
		return "select";
	}
	@RequestMapping("/selectAll")
	public String selectAll(Model model) {
		List<Member> result = memberService.selectAll();
		model.addAttribute("members", result);
		return "selectAll";
	}

	 // GET 방식으로 요청 받음
    @RequestMapping("/delete")
    public String delete(@RequestParam("id") Long id, Model model) {
        boolean result = memberService.delete(id);

        if (result) {
            model.addAttribute("message", "회원이 삭제되었습니다.");
        } else {
            model.addAttribute("message", "회원 삭제에 실패했습니다.");
        }

        return "menu"; // 삭제 후 보여줄 페이지
    }
}
