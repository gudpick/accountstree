package com.notyfd.demo.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "nalaccount")
public class AccountEntity {

	@Id
	@GeneratedValue
	private Integer id;

	@ManyToOne
	private AccountEntity parent;

	private String name;

	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="parent_id")
	private Set<AccountEntity> child;

	public Integer getId() {
		return id;
	}

	public AccountEntity getParent() {
		return parent;
	}

	public void setParent(AccountEntity parent) {
		this.parent = parent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<AccountEntity> getChild() {
		return child;
	}

	public void setChild(Set<AccountEntity> child) {
		this.child = child;
	}
}
