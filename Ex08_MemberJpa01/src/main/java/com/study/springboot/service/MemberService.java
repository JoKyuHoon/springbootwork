package com.study.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springboot.domain.Member;
import com.study.springboot.repository.MemberRepository;

@Service
public class MemberService {
	
	@Autowired
	MemberRepository memberRepository;
	
	public Member insert(Member member) {
		// save() : jpa에서 insert메서드
		// 		    동일한 키가 있으면 update, 키가 없으면 insert
		
		Member result = memberRepository.save(member);
		return result;
	}

	public Optional<Member> select(Long id) {
		
		return memberRepository.findById(id);
	}

	public List<Member> selectAll() {
		
		return memberRepository.findAll();
	}
	
	  // 회원 삭제 메서드
    public boolean delete(Long id) {
        // id로 회원을 삭제
        if (memberRepository.existsById(id)) {  // 해당 id로 회원이 존재하는지 확인
            memberRepository.deleteById(id);  // 존재하면 삭제
            return true;  // 삭제 성공
        } else {
            return false;  // 회원이 존재하지 않으면 실패
        }
    }
	

	/* jpa 메서드
	 * deleteById(id) 
	 * save(member)
	 */
}
