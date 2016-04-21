/**
 * 
 */
package org.weekendsoft.mpa.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TypedQuery;

/**
 * Entity Bean for Journal
 * 
 * @author Vivek Kant
 *
 */
@Entity
@Table(name = "journal")
public class Journal extends BaseEntity implements Comparable<Journal> {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "journal_id")
    private int id ;
    
    @Column(name = "instance_id" )
    private String instanceId ;

    @Column(name = "compound_entry_id" )
    private Integer compoundEntry ;
    
    @Column(name = "debit_account_id" )
    private Integer debitAccount ;
    
    @Column(name = "credit_account_id" )
    private Integer creditAccount ;
    
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
    
    public Journal( int id ) {
        super() ;
        this.id = id ;
    }

    public Journal() {
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

	public Integer getCompoundEntry() {
		return compoundEntry;
	}

	public void setCompoundEntry(Integer compoundEntry) {
		this.compoundEntry = compoundEntry;
	}

	public Integer getDebitAccount() {
		return debitAccount;
	}

	public void setDebitAccount(Integer debitAccount) {
		this.debitAccount = debitAccount;
	}

	public Integer getCreditAccount() {
		return creditAccount;
	}

	public void setCreditAccount(Integer creditAccount) {
		this.creditAccount = creditAccount;
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
		return "Journal [id=" + id + ", instanceId=" + instanceId + ", compoundEntry=" + compoundEntry
				+ ", debitAccount=" + debitAccount + ", creditAccount=" + creditAccount + ", category=" + category
				+ ", subCategory=" + subCategory + ", amount=" + amount + ", currency=" + currency + ", bill=" + bill
				+ ", recordDate=" + recordDate + ", comment=" + comment + ", number=" + number + ", status=" + status
				+ ", split=" + split + "]";
	}

	public int compareTo( Journal tran2 ) {
		return this.recordDate.compareTo( tran2.recordDate ) ;
	}
	
    public static void create( Journal journalEntry ) throws Exception {
    	if ( !init ) init() ;
    	em.getTransaction().begin() ;
    	em.persist( journalEntry ) ;
    	em.flush() ;
    	em.getTransaction().commit() ;
    }
    
    public static Journal get( int id ) throws Exception {
        if ( !init ) init() ;
        Journal journalEntry = em.find( Journal.class, id ) ;
        return journalEntry ;
    }
    
    // Get all entries for an account
    public static List<Journal> getAccountEntries( String instanceId, int account ) throws Exception {
    	if ( !init ) init() ;
    	List<Journal> entries = null ;
    	
    	TypedQuery<Journal> q = em.createQuery( "select j from Journal j where "
    													+ "(j.debitAccount = :debitAccount "
    													+ "or j.creditAccount = :creditAccount) "
    												+ "and j.instanceId = :instanceId", Journal.class ) ;
		q.setParameter( "instanceId", instanceId ) ;
		q.setParameter( "debitAccount", account ) ;
		q.setParameter( "creditAccount", account ) ;
		entries = q.getResultList() ;
		
    	return entries ;
    }
    
    public static void modify( Journal journalEntry ) throws Exception {
    	if ( !init ) init() ;
    	Journal original = em.find( Journal.class, journalEntry.id ) ;
    	em.getTransaction().begin() ;
    	em.remove( original ) ;
    	em.persist( journalEntry ) ;
    	em.flush() ;
    	em.getTransaction().commit() ;
    }
    
    public static void delete( Journal journalEntry ) throws Exception {
    	em.getTransaction().begin() ;
    	em.remove( journalEntry ) ;
    	em.getTransaction().commit() ;
    }
    
}
