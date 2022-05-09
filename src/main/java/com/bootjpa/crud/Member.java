package com.bootjpa.crud;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="member")
public class Member  {
	@Id
	@NonNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long MbrNo;
	private String id;
	private int age;
	private String email;
}
