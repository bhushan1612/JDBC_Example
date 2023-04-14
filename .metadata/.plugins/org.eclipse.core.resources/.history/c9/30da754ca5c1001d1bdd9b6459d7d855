package com.example.su.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "ACCOUNTS")
public class AccountBean {

	private long accNo;
	private String name;
	private double balance;
	private Date accCreationDate;
	
	@Id
	@Column(name = "acc_no", nullable = true, length = 5)
	public long getAccNo() {
		return accNo;
	}
	public void setAccNo(long accNo) {
		this.accNo = accNo;
	}
	
	@Column(name = "NAME", nullable = false, length = 20)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "BALANCE", nullable = false, precision = 8, scale = 2)
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	@Column(name = "ACC_CRE_DT", nullable = false)
	public Date getAccCreationDate() {
		return accCreationDate;
	}
	public void setAccCreationDate(Date accCreationDate) {
		this.accCreationDate = accCreationDate;
	}
	@Override
	public String toString() {
		return "AccountBean [accNo=" + accNo + ", name=" + name + ", balance=" + balance + ", accCreationDate="
				+ accCreationDate + "]";
	}
	
}
