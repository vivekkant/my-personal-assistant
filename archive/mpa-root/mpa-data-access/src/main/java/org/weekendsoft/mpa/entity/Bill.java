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
import javax.persistence.Query;
import javax.persistence.Table;
import javax.persistence.TypedQuery;

/**
 * Entity Bean for Bill
 * 
 * @author Vivek Kant
 *
 */
@Entity
@Table(name = "bill")
public class Bill extends BaseEntity implements Comparable<Bill> {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "bill_id")
    private int id ;
    
    @Column(name = "bill_name")
    private String name ;
    
    @Column(name = "instance_id" )
    private String instanceId ;
    
    @Column(name = "credit_account_id" )
    private Integer creditAccount ;
    
    @Column(name = "debit_account_id" )
    private Integer debitAccount ;
    
    @Column(name = "category_id" )
    private Integer category ;
    
    @Column(name = "subcategory_id" )
    private Integer subCategory ;
    
    @Column(name = "amount" )
    private double amount ;
    
    @Column(name = "currency_id" )
    private String currency ;

    @Column(name = "comment" )
    private String comment ;
    
    @Column(name = "number" )
    private String number ;
    
    @Column(name = "frequency" )
    private Frequency frequency ;
    
    @Column(name = "num_payments" )
    private Integer numPayments ;
    
    @Column(name = "automatic" )
    private boolean automatic ;
    
    @Column(name = "payment_date" )
    private Date paymentDate ;
    
    public enum Frequency {
    	ONCE, DAILY, WEEKLY, MONTHLY, QUARTERLY, HALF_YEARLY, YEARLY 
    }
    
    public Bill( int id ) {
        super() ;
        this.id = id ;
    }

    public Bill() {
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

	public Integer getCreditAccount() {
		return creditAccount;
	}

	public void setCreditAccount(Integer creditAccount) {
		this.creditAccount = creditAccount;
	}

	public Integer getDebitAccount() {
		return debitAccount;
	}

	public void setDebitAccount(Integer debitAccount) {
		this.debitAccount = debitAccount;
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

	public Frequency getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = Frequency.valueOf( frequency ) ;
	}

	public Integer getNumPayments() {
		return numPayments;
	}

	public void setNumPayments(Integer numPayments) {
		this.numPayments = numPayments;
	}

	public boolean isAutomatic() {
		return automatic;
	}

	public void setAutomatic(boolean automatic) {
		this.automatic = automatic;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	@Override
	public String toString() {
		return "Bill [id=" + id + ", name=" + name + ", instanceId=" + instanceId + ", creditAccount=" + creditAccount
				+ ", debitAccount=" + debitAccount + ", category=" + category + ", subCategory=" + subCategory
				+ ", amount=" + amount + ", currency=" + currency + ", comment=" + comment + ", number=" + number
				+ ", frequency=" + frequency + ", numPayments=" + numPayments + ", automatic=" + automatic
				+ ", paymentDate=" + paymentDate + "]";
	}
    
    public static Bill get( int id ) throws Exception {
        if ( !init ) init() ;
        Bill bank = em.find( Bill.class, id ) ;
        return bank ;
    }
    
    public static Bill getBillByName( String name, String instanceId ) throws Exception {
    	if ( !init ) init() ;
    	
    	Bill bank = null ;
    	
    	Query q = em.createQuery( "select a from Bill a where "
    			+ "a.instanceId = :instanceId and "
    			+ "a.name = :name order by payment_date desc" ) ;
    	
    	q.setParameter( "instanceId", instanceId ) ;
    	q.setParameter( "name", name ) ;
    	q.setMaxResults( 1 ) ;
    	
    	bank = (Bill) q.getSingleResult() ;
    	
    	return bank ;
    }
    
    public static List<Bill> getAll( String instanceId ) throws Exception {
    	if ( !init ) init() ;
    	
    	TypedQuery<Bill> q = em.createQuery( "select a from Bill a where "
    										  + "a.instanceId = :instanceId "
    										  + "order by payment_date desc", Bill.class ) ;
    	q.setParameter( "instanceId", instanceId ) ;
    	List<Bill> results = q.getResultList() ;
    	
    	return results ;
    }
    
    public static void create( Bill bill ) throws Exception {
    	if ( !init ) init() ;
    	em.getTransaction().begin() ;
    	em.persist( bill ) ;
    	em.flush() ;
    	em.getTransaction().commit() ;
    }

    public static void modify( Bill bill ) throws Exception {
    	if ( !init ) init() ;
    	Bill original = em.find( Bill.class, bill.id ) ;
    	em.getTransaction().begin() ;
    	copy( original, bill ) ;
    	em.getTransaction().commit() ;
    }
    
    //TODO Update the logic for entering bill
    public static void enterBill( Bill bill ) throws Exception {
    	if ( !init ) init() ;
    	
    }
    
    
    public static void delete( Bill bill ) throws Exception {
    	em.getTransaction().begin() ;
    	em.remove( bill ) ;
    	em.getTransaction().commit() ;
    }
    
    private static void copy( Bill to, Bill from ) {
    	to.name 			= from.name ;
    	to.instanceId 		= from.instanceId ;
    }

	public int compareTo( Bill accountType ) {
		return this.paymentDate.compareTo( accountType.paymentDate ) ;
	}
    
}
