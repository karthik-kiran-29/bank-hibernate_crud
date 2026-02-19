package com.kce.in.bean;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "transfer_tbl")
public class TransferBean {
	@Id
	@Column(name = "Transaction_id")
	private int transactionId;
	@Column(name="Account_Number")
	private String fromAccountNumber;
	@Column(name="Beneficiary_acc_number")
	private String toAccountNumber;
	@Column(name="Transaction_Date")
	private Date dateOfTransaction;
	@Column(name="Transaction_Amount")
	private float amount;
	
	public TransferBean(int transactionId, String fromAccountNumber, String toAccountNumber, Date dateOfTransaction,
			float amount) {
		super();
		this.transactionId = transactionId;
		this.fromAccountNumber = fromAccountNumber;
		this.toAccountNumber = toAccountNumber;
		this.dateOfTransaction = dateOfTransaction;
		this.amount = amount;
	}

	public TransferBean() {
		super();
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public String getFromAccountNumber() {
		return fromAccountNumber;
	}

	public void setFromAccountNumber(String fromAccountNumber) {
		this.fromAccountNumber = fromAccountNumber;
	}

	public String getToAccountNumber() {
		return toAccountNumber;
	}

	public void setToAccountNumber(String toAccountNumber) {
		this.toAccountNumber = toAccountNumber;
	}

	public Date getDateOfTransaction() {
		return dateOfTransaction;
	}

	public void setDateOfTransaction(Date dateOfTransaction) {
		this.dateOfTransaction = dateOfTransaction;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}
	
	
}
