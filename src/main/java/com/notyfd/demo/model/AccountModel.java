package com.notyfd.demo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountModel {

	private int id;

	private String name;

	private List<AccountModel> child;
}
