package org.weekendsoft.mpa.referencedata.model;

/**
 * @author Vivek Kant
 */
public class Account {

    public static final String DEFAULT_INCOME_ACCOUNT = "DEFAULT_INCOME" ;
    public static final String DEFAULT_EXPENSE_ACCOUNT = "DEFAULT_EXPENSE" ;
    
    private int id ;
    
    private String name ;
    
    private String instanceId ;
    
    private Integer accountTypeId ;
    
    private Integer bankId ;
    
    private String currencyId ;
    
    private boolean internal ;
    
    private double initialBalance ;
    
    public Account(int id, String name, String instanceId, Integer accountTypeId, Integer bankId, String currencyId,
			boolean internal, double initialBalance) {
		super();
		this.id = id;
		this.name = name;
		this.instanceId = instanceId;
		this.accountTypeId = accountTypeId;
		this.bankId = bankId;
		this.currencyId = currencyId;
		this.internal = internal;
		this.initialBalance = initialBalance;
	}

    public Account( int id ) {
        super() ;
        this.id = id ;
    }

    public Account() {
    	// Default Constructor
    }
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}

	public Integer getAccountTypeId() {
		return accountTypeId;
	}

	public void setAccountTypeId(Integer accountTypeId) {
		this.accountTypeId = accountTypeId;
	}

	public Integer getBankId() {
		return bankId;
	}


	public void setBankId(Integer bankId) {
		this.bankId = bankId;
	}

	public String getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(String currencyId) {
		this.currencyId = currencyId;
	}

	public boolean isInternal() {
		return internal;
	}

	public void setInternal(boolean internal) {
		this.internal = internal;
	}

	public double getInitialBalance() {
		return initialBalance;
	}

	public void setInitialBalance(double initialBalance) {
		this.initialBalance = initialBalance;
	}

	public int compareTo( Account account2 ) {
		return this.name.compareTo( account2.name ) ;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", instanceId=" + instanceId + ", accountTypeId="
				+ accountTypeId + ", bankId=" + bankId + ", currencyId=" + currencyId + ", internal=" + internal
				+ ", initialBalance=" + initialBalance + "]";
	}
    
}

