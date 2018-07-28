/*
 * Copyright 2017 FOLIO Co.,Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.folio_sec.example.domain.simplebank;

import com.gs.collections.api.list.MutableList;
import com.gs.fw.common.mithra.MithraObjectPortal;
import com.gs.fw.common.mithra.MithraTransactionalList;
import com.gs.fw.common.mithra.finder.Operation;
import com.gs.fw.common.mithra.list.AbstractTransactionalNonOperationBasedList;
import com.gs.fw.common.mithra.list.AbstractTransactionalOperationBasedList;
import com.gs.fw.common.mithra.list.DelegatingList;

import java.util.Collection;

/**
* This file was automatically generated using Mithra 16.3.0. Please do not modify it.
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

	public MithraTransactionalList getNonPersistentGenericCopy()
	{
		return this.getNonPersistentCopy();
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

	public void setBalance(double newValue)
	{
		zSetDouble(CustomerAccountFinder.balance(), newValue);
	}

	public void setCustomerId(int newValue)
	{
		zSetInteger(CustomerAccountFinder.customerId(), newValue);
	}

	public void setBalanceNull()
	{
		zSetAttributeNull(CustomerAccountFinder.balance());
	}
}
