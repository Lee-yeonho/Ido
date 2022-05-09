package com.bootjpa.crud;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;



@Service
public class MemberService {
	@Autowired
	private MemberRepository memberRepository;
	
	public void save(Member member) {
		 memberRepository.save(member);
		 
	}
	
	public List<Member> findAll() { 
		List<Member> members = new ArrayList<>(); 
		memberRepository.findAll().forEach(e -> members.add(e)); 
		return members; 
		} 
	public Optional<Member> findById(Long mbrNo) {
		Optional<Member> member = memberRepository.findById(mbrNo); 
		return member; 
		}
	public void deleteById(Long mbrNo) { 
		memberRepository.deleteById(mbrNo); 
		}

	public void updateById(Long mbrNo, Member member) {
		Optional<Member> e = memberRepository.findById(mbrNo);
		if (e.isPresent()) {
			e.get().setId(member.getId());
			e.get().setEmail(member.getEmail()); 
			e.get().setAge(member.getAge());
			
			} 
		
	}

	
}
