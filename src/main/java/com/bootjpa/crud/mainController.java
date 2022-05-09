package com.bootjpa.crud;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class mainController {
	@Autowired
	MemberService memberService;
	
	@GetMapping()
	public ResponseEntity<List<Member>> getAllmember(){
		List<Member> member = memberService.findAll();
		return new ResponseEntity<List<Member>>(member, HttpStatus.OK);
	}
	
	@GetMapping("/{mbrNo}") 
	public ResponseEntity<Member> getMember(@PathVariable("mbrNo") Long mbrNo) { 
		Optional<Member> member = memberService.findById(mbrNo); 
		return new ResponseEntity<Member>(member.get(), HttpStatus.OK); }

	@DeleteMapping("/{mbrNo}") 
	public ResponseEntity<Void> deleteMember(@PathVariable("mbrNo") Long mbrNo) { 
		memberService.deleteById(mbrNo);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT); } 
	
	@PutMapping("/{mbrNo}") 
	public ResponseEntity<Member> updateMember(@PathVariable("mbrNo") Long mbrNo, @RequestBody  Member member) {
		memberService.updateById(mbrNo, member);
		return new ResponseEntity<Member>(member, HttpStatus.OK); 
		}
	
	@PostMapping("/add")
	  public ResponseEntity<?> add(@RequestBody Member member) {  
		if(member !=null) {
		
			memberService.save(member);
		}
        return ResponseEntity.ok(member);  

    } 

}
