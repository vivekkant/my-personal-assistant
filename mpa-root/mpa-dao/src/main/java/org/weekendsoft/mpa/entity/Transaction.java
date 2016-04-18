/**
 * 
 */
package org.weekendsoft.mpa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity Bean for Transaction
 * 
 * @author Vivek Kant
 *
 */
@Entity
@Table(name = "transaction")
public class Transaction extends BaseEntity implements Comparable<Transaction> {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private int id ;
    
    @Column(name = "instance_id" )
    private String instanceId ;

    @Column(name = "transaction_parent_id" )
    private Integer parent ;
    
    @Column(name = "from_account_id" )
    private Integer fromAccount ;
    
    @Column(name = "to_account_id" )
    private Integer toAccount ;
    
    @Column(name = "category_id" )
    private Integer category ;
    
    @Column(name = "subcategory_id" )
    private Integer subCategory ;
    
    @Column(name = "amount" )
    private double amount ;
    
    @Column(name = "currency_id" )
    private String currency ;
    
    @Column(name = "bill_id" )
    private Integer bill ;
    
    @Column(name = "record_date" )
    private Date recordDate ;
    
    @Column(name = "comment" )
    private String comment ;
    
    @Column(name = "number" )
    private String number ;
    
    @Column(name = "status" )
    private Character status ;
    
    @Column(name = "split" )
    private boolean split ;
    
    //private 
    
    public Transaction( int id ) {
        super() ;
        this.id = id ;
    }

    public Transaction() {
    	// Default Constructor
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}

	public Integer getParent() {
		return parent;
	}

	public void setParent(Integer parent) {
		this.parent = parent;
	}

	public Integer getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(Integer fromAccount) {
		this.fromAccount = fromAccount;
	}

	public Integer getToAccount() {
		return toAccount;
	}

	public void setToAccount(Integer toAccount) {
		this.toAccount = toAccount;
	}

	public Integer getCategory() {
		return category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}

	public Integer getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(Integer subCategory) {
		this.subCategory = subCategory;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Integer getBill() {
		return bill;
	}

	public void setBill(Integer bill) {
		this.bill = bill;
	}

	public Date getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Character getStatus() {
		return status;
	}

	public void setStatus(Character status) {
		this.status = status;
	}

	public boolean isSplit() {
		return split;
	}

	public void setSplit(boolean split) {
		this.split = split;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", instanceId=" + instanceId + ", parent=" + parent + ", fromAccount="
				+ fromAccount + ", toAccount=" + toAccount + ", category=" + category + ", subCategory=" + subCategory
				+ ", amount=" + amount + ", currency=" + currency + ", bill=" + bill + ", recordDate=" + recordDate
				+ ", comment=" + comment + ", number=" + number + ", status=" + status + ", split=" + split + "]";
	}

	public int compareTo( Transaction tran2 ) {
		return this.recordDate.compareTo( tran2.recordDate ) ;
	}
	
    public static void create( Transaction transaction ) throws Exception {
    	if ( !init ) init() ;
    	em.getTransaction().begin() ;
    	em.persist( transaction ) ;
    	em.flush() ;
    	em.getTransaction().commit() ;
    }
    
    public static Transaction get( int id ) throws Exception {
        if ( !init ) init() ;
        Transaction transaction = em.find( Transaction.class, id ) ;
        return transaction ;
    }
    
    //TODO All the get combinations
    
    public static void modify( Transaction transaction ) throws Exception {
    	if ( !init ) init() ;
    	Transaction original = em.find( Transaction.class, transaction.id ) ;
    	em.getTransaction().begin() ;
    	em.remove( original ) ;
    	em.persist( transaction ) ;
    	em.flush() ;
    	em.getTransaction().commit() ;
    }
    
    public static void delete( Transaction transaction ) throws Exception {
    	em.getTransaction().begin() ;
    	em.remove( transaction ) ;
    	em.getTransaction().commit() ;
    }
    
}
