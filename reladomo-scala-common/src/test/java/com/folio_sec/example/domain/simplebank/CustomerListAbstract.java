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

	public MithraTransactionalList getNonPersistentGenericCopy()
	{
		return this.getNonPersistentCopy();
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

	protected void zCascadeDeleteRelationships()
	{
		((DelegatingList)this.getAccounts()).cascadeDeleteAll();
	}
}
