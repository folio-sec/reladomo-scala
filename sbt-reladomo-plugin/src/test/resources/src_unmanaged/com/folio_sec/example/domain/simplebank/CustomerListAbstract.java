package com.folio_sec.example.domain.simplebank;
import java.util.*;
import com.gs.fw.common.mithra.MithraList;
import com.gs.fw.common.mithra.MithraManager;
import com.gs.fw.common.mithra.MithraManagerProvider;
import com.gs.fw.common.mithra.finder.*;
import com.gs.fw.common.mithra.list.*;
import com.gs.fw.common.mithra.list.merge.TopLevelMergeOptions;
import com.gs.fw.finder.OrderBy;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.*;
import java.io.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.gs.fw.common.mithra.*;
import com.gs.fw.common.mithra.attribute.*;
import com.gs.fw.common.mithra.util.*;
import com.gs.fw.common.mithra.notification.*;
import com.gs.fw.common.mithra.notification.listener.*;
import com.gs.fw.common.mithra.list.cursor.Cursor;
import com.gs.fw.common.mithra.bulkloader.*;
/**
* This file was automatically generated using Mithra 17.0.2. Please do not modify it.
* Add custom logic to its subclass instead.
*/
// Generated from templates/transactional/ListAbstract.jsp
public class CustomerListAbstract extends DelegatingList<Customer> implements MithraTransactionalList<Customer>
{
	public CustomerListAbstract()
	{
		super();
		this.setDelegated(AbstractTransactionalNonOperationBasedList.DEFAULT);
		AbstractTransactionalNonOperationBasedList.DEFAULT.init(this);
	}

	public CustomerListAbstract(int initialSize)
	{
		super();
		this.setDelegated(AbstractTransactionalNonOperationBasedList.DEFAULT);
		AbstractTransactionalNonOperationBasedList.DEFAULT.init(this, initialSize);
	}

	public CustomerListAbstract(Collection c)
	{
		super();
		this.setDelegated(AbstractTransactionalNonOperationBasedList.DEFAULT);
		AbstractTransactionalNonOperationBasedList.DEFAULT.init(this, c);
	}

	public CustomerListAbstract(com.gs.fw.finder.Operation operation)
	{
		super(operation);
		this.setDelegated(AbstractTransactionalOperationBasedList.DEFAULT);
	}

	public Customer[] elements()
	{
		Customer[] result = new Customer[size()];
		this.getDelegated().toArray(this, result);
		return result;
	}

	public CustomerList intersection(CustomerList another)
	{
		return (CustomerList)super.intersection(another);
	}

	public Customer getCustomerAt(int index)
	{
		return (Customer)this.get(index);
	}

	/**
	* Relationship Expression:<pre>
	this.customerId = CustomerAccount.customerId</pre>
	* @see CustomerAccount#getCustomer() reverse relationship CustomerAccount.getCustomer()
	* @return accounts
	*/
	public CustomerAccountList getAccounts()
	{
		return (CustomerAccountList) this.getDelegated().resolveRelationship(this, CustomerFinder.accounts());
	}

	public MithraObjectPortal getMithraObjectPortal()
	{
		return CustomerFinder.getMithraObjectPortal();
	}

	public CustomerList getNonPersistentCopy()
	{
		CustomerList result = new CustomerList();
		zCopyNonPersistentInto(result);
		return result;
	}

	public CustomerList asAdhoc()
	{
		return (CustomerList) super.asAdhoc();
	}

	public MithraTransactionalList getNonPersistentGenericCopy()
	{
		return this.getNonPersistentCopy();
	}

	/**
	* Return a view of this list that implements GS Collections MutableList API.
	* Since the returned list will be operation-based, it is effectively read-only,
	* so mutating methods will throw a RuntimeException.
	* (Implemented by a light-weight adapter, not a copy)
	*/
	public com.gs.collections.api.list.MutableList<Customer> asGscList()
	{
		return com.gs.collections.impl.list.mutable.ListAdapter.adapt(this);
	}

	public CustomerList merge(MithraTransactionalList<Customer> incoming, TopLevelMergeOptions<Customer> mergeOptions)
	{
		return (CustomerList) super.merge(incoming, mergeOptions);
	}

	public CustomerList getDetachedCopy()
	{
		CustomerList result = new CustomerList();
		zDetachInto(result);
		return result;
	}

	public void zMakeDetached(Operation op, Object previousDetachedList)
	{
		super.zMakeDetached(op, previousDetachedList);
	}

	protected void generateAndSetPrimaryKeys()
	{
	}

	public void setCountry(String newValue)
	{
		zSetString(CustomerFinder.country(), newValue);
	}

	public void setCustomerId(int newValue)
	{
		zSetInteger(CustomerFinder.customerId(), newValue);
	}

	public void setFirstName(String newValue)
	{
		zSetString(CustomerFinder.firstName(), newValue);
	}

	public void setLastName(String newValue)
	{
		zSetString(CustomerFinder.lastName(), newValue);
	}

	public void setZipCode(int newValue)
	{
		zSetInteger(CustomerFinder.zipCode(), newValue);
	}

	public void setZipCodeNull()
	{
		zSetAttributeNull(CustomerFinder.zipCode());
	}

	protected void zCascadeDeleteRelationships()
	{
		((DelegatingList)this.getAccounts()).cascadeDeleteAll();
	}
}
