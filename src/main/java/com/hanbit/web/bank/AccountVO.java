/**
 * 
 */
package com.hanbit.web.bank;

import java.io.Serializable;

/**
 * @date   : 2016. 6. 16.
 * @author : HyunWoo Lee
 * @file   : Account.java 
 * @story  : 
*/
public class AccountVO implements Serializable {
	
		private static final long serialVersionUID = 1L;
		private String id;
		private int    money,pw;
		private int    accountNo;
	
		public AccountVO() {
			this.money = 0;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public int getMoney() {
			return money;
		}
		public void setMoney(int money) {
			this.money = money;
		}
		public void setMoney(String money){
			this.money = Integer.parseInt(money);
		}
		public int getAccountNo() {
			return accountNo;
		}
		public void setAccountNo(int accountNo) {
			this.accountNo = accountNo;
		}
		public int getPw() {
			return pw;
		}
		public void setPw(int pw) {
			this.pw = pw;
		}
		@Override
		public String toString() {
			return "AccountBean [id=" + id + ", money=" + money + ", accountNo=" + accountNo + "]";
		}
}
