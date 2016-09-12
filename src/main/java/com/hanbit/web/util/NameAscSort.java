package com.hanbit.web.util;



import java.util.Comparator;

import com.hanbit.web.domains.AccountDTO;




/**
 * @date   :2016. 7. 8.
 * @author :HyunWoo Lee
 * @file   :NameAccSort.java
 * @story  :
*/

public class NameAscSort implements Comparator<AccountDTO> {
	
	@Override
	public int compare(AccountDTO first, AccountDTO second) {
		// TODO Auto-generated method stub
		return first.getId().compareTo(second.getId());
	}
	
}
