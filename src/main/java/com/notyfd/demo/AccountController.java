package com.notyfd.demo;

import com.notyfd.demo.entity.AccountEntity;
import com.notyfd.demo.model.AccountModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Slf4j
@RequestMapping("api/v1/categories")
@RestController
public class AccountController {

	@Autowired
	private AccountDAO accountDAO;


	@GetMapping
	public List<AccountModel> getContents(){
		List<AccountModel> jsonList = new ArrayList<AccountModel>();
		List<AccountEntity> accountList = accountDAO.getAccountTree();
		return convertToMap(jsonList, accountList);
	}

	private List<AccountModel> convertToMap(List<AccountModel> jsonList, Collection<AccountEntity> accounts){
		for (AccountEntity account : accounts) {
			AccountModel accountModel = new AccountModel();
			accountModel.setId(account.getId());
			accountModel.setName(account.getName());
			jsonList.add(accountModel);
			Set<AccountEntity> childSet = account.getChild();
			if (childSet.size()>0){
				List<AccountModel> jsonList1 = new ArrayList<AccountModel>();
				accounts = childSet;
				jsonList1 = convertToMap(jsonList1, accounts);
				accountModel.setChild(jsonList1);
			}
		}
		return jsonList;
	}

}
