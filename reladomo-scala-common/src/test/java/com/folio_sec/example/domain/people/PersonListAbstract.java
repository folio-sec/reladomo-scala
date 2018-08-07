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

package com.folio_sec.example.domain.people;
import java.util.*;
import com.gs.fw.common.mithra.MithraList;
import com.gs.fw.common.mithra.MithraManager;
import com.gs.fw.common.mithra.MithraManagerProvider;
import com.gs.fw.common.mithra.finder.*;
import com.gs.fw.common.mithra.list.*;
import com.gs.fw.finder.OrderBy;
import com.gs.collections.api.list.MutableList;
import java.math.BigDecimal;
import java.util.*;
import java.sql.Timestamp;
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
* This file was automatically generated using Mithra 16.3.0. Please do not modify it.
* Add custom logic to its subclass instead.
*/
// Generated from templates/transactional/ListAbstract.jsp
public class PersonListAbstract extends DelegatingList<Person> implements MithraTransactionalList<Person>
{
	public PersonListAbstract()
	{
		super();
		this.setDelegated(AbstractTransactionalNonOperationBasedList.DEFAULT);
		AbstractTransactionalNonOperationBasedList.DEFAULT.init(this);
	}

	public PersonListAbstract(int initialSize)
	{
		super();
		this.setDelegated(AbstractTransactionalNonOperationBasedList.DEFAULT);
		AbstractTransactionalNonOperationBasedList.DEFAULT.init(this, initialSize);
	}

	public PersonListAbstract(Collection c)
	{
		super();
		this.setDelegated(AbstractTransactionalNonOperationBasedList.DEFAULT);
		AbstractTransactionalNonOperationBasedList.DEFAULT.init(this, c);
	}

	public PersonListAbstract(com.gs.fw.finder.Operation operation)
	{
		super(operation);
		this.setDelegated(AbstractTransactionalOperationBasedList.DEFAULT);
	}

	public Person[] elements()
	{
		Person[] result = new Person[size()];
		this.getDelegated().toArray(this, result);
		return result;
	}

	public PersonList intersection(PersonList another)
	{
		return (PersonList)super.intersection(another);
	}

	public Person getPersonAt(int index)
	{
		return (Person)this.get(index);
	}

	public MithraObjectPortal getMithraObjectPortal()
	{
		return PersonFinder.getMithraObjectPortal();
	}

	public PersonList getNonPersistentCopy()
	{
		PersonList result = new PersonList();
		zCopyNonPersistentInto(result);
		return result;
	}

	public MithraTransactionalList getNonPersistentGenericCopy()
	{
		return this.getNonPersistentCopy();
	}

	public PersonList getDetachedCopy()
	{
		PersonList result = new PersonList();
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
		zSetString(PersonFinder.country(), newValue);
	}

	public void setFirstName(String newValue)
	{
		zSetString(PersonFinder.firstName(), newValue);
	}

	public void setLastName(String newValue)
	{
		zSetString(PersonFinder.lastName(), newValue);
	}

	public void setPersonId(int newValue)
	{
		zSetInteger(PersonFinder.personId(), newValue);
	}
}
