package com.folio_sec.example.domain.simplebank;
import java.util.*;
import com.gs.fw.common.mithra.MithraList;
import com.gs.fw.common.mithra.MithraManager;
import com.gs.fw.common.mithra.MithraManagerProvider;
import com.gs.fw.common.mithra.finder.*;
import com.gs.fw.common.mithra.list.*;
import com.gs.fw.common.mithra.list.merge.TopLevelMergeOptions;
import com.gs.fw.finder.OrderBy;
import com.gs.collections.api.list.MutableList;
import com.gs.collections.impl.list.mutable.ListAdapter;
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
* This file was automatically generated using Mithra 16.7.0. Please do not modify it.
* Add custom logic to its subclass instead.
*/
// Generated from templates/transactional/ListAbstract.jsp
public class CustomerAccountListAbstract extends DelegatingList<CustomerAccount> implements MithraTransactionalList<CustomerAccount>
{
	public CustomerAccountListAbstract()
	{
		super();
		this.setDelegated(AbstractTransactionalNonOperationBasedList.DEFAULT);
		AbstractTransactionalNonOperationBasedList.DEFAULT.init(this);
	}

	public CustomerAccountListAbstract(int initialSize)
	{
		super();
		this.setDelegated(AbstractTransactionalNonOperationBasedList.DEFAULT);
		AbstractTransactionalNonOperationBasedList.DEFAULT.init(this, initialSize);
	}

	public CustomerAccountListAbstract(Collection c)
	{
		super();
		this.setDelegated(AbstractTransactionalNonOperationBasedList.DEFAULT);
		AbstractTransactionalNonOperationBasedList.DEFAULT.init(this, c);
	}

	public CustomerAccountListAbstract(com.gs.fw.finder.Operation operation)
	{
		super(operation);
		this.setDelegated(AbstractTransactionalOperationBasedList.DEFAULT);
	}

	public CustomerAccount[] elements()
	{
		CustomerAccount[] result = new CustomerAccount[size()];
		this.getDelegated().toArray(this, result);
		return result;
	}

	public CustomerAccountList intersection(CustomerAccountList another)
	{
		return (CustomerAccountList)super.intersection(another);
	}

	public CustomerAccount getCustomerAccountAt(int index)
	{
		return (CustomerAccount)this.get(index);
	}

	/**
	* Relationship Expression:<pre>
	Customer.customerId = this.customerId</pre>
	* @see Customer#getAccounts() reverse relationship Customer.getAccounts()
	* @return The customer
	*/
	public CustomerList getCustomers()
	{
		return (CustomerList) this.getDelegated().resolveRelationship(this, CustomerAccountFinder.customer());
	}

	public void zSetParentContainercustomer(CustomerAbstract parent)
	{
		for (int i = 0; i < this.size(); i++)
		{
			CustomerAccount item = this.getCustomerAccountAt(i);
			item.zSetParentContainercustomer(parent);
		}
	}

	public MithraObjectPortal getMithraObjectPortal()
	{
		return CustomerAccountFinder.getMithraObjectPortal();
	}

	public CustomerAccountList getNonPersistentCopy()
	{
		CustomerAccountList result = new CustomerAccountList();
		zCopyNonPersistentInto(result);
		return result;
	}

	public CustomerAccountList asAdhoc()
	{
		return (CustomerAccountList) super.asAdhoc();
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
	public MutableList<CustomerAccount> asGscList()
	{
		return ListAdapter.adapt(this);
	}

	public CustomerAccountList merge(MithraTransactionalList<CustomerAccount> incoming, TopLevelMergeOptions<CustomerAccount> mergeOptions)
	{
		return (CustomerAccountList) super.merge(incoming, mergeOptions);
	}

	public CustomerAccountList getDetachedCopy()
	{
		CustomerAccountList result = new CustomerAccountList();
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

	public void setAccountId(int newValue)
	{
		zSetInteger(CustomerAccountFinder.accountId(), newValue);
	}

	public void setAccountName(String newValue)
	{
		zSetString(CustomerAccountFinder.accountName(), newValue);
	}

	public void setAccountType(String newValue)
	{
		zSetString(CustomerAccountFinder.accountType(), newValue);
	}

	public void setAreaId(int newValue)
	{
		zSetInteger(CustomerAccountFinder.areaId(), newValue);
	}

	public void setBalance(double newValue)
	{
		zSetDouble(CustomerAccountFinder.balance(), newValue);
	}

	public void setCustomerId(int newValue)
	{
		zSetInteger(CustomerAccountFinder.customerId(), newValue);
	}

	public void setAreaIdNull()
	{
		zSetAttributeNull(CustomerAccountFinder.areaId());
	}

	public void setBalanceNull()
	{
		zSetAttributeNull(CustomerAccountFinder.balance());
	}
}
