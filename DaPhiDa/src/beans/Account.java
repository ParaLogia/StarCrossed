package beans;

import java.sql.Date;

public class Account {
	private String ownerSSN;
	private Integer cardNumber;
	private String acctNumber;
	private Date acctCreationDate;
	
	public Account() {
		
	}
	
	public Account(String ownerSSN, Integer cardNumber, String acctNumber, Date acctCreationDate) {
		this.ownerSSN = ownerSSN;
		this.cardNumber = cardNumber;
		this.acctNumber = acctNumber;
		this.acctCreationDate = acctCreationDate;
	}
	public String getOwnerSSN() {
		return ownerSSN;
	}
	public void setOwnerSSN(String ownerSSN) {
		this.ownerSSN = ownerSSN;
	}
	public Integer getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(Integer cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getAcctNumber() {
		return acctNumber;
	}
	public void setAcctNumber(String acctNumber) {
		this.acctNumber = acctNumber;
	}
	public Date getAcctCreationDate() {
		return acctCreationDate;
	}
	public void setAcctCreationDate(Date acctCreationDate) {
		this.acctCreationDate = acctCreationDate;
	}
	
}
