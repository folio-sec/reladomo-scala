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
import com.gs.fw.common.mithra.*;
import com.gs.fw.common.mithra.behavior.*;
import com.gs.fw.common.mithra.cache.Cache;
import com.gs.fw.common.mithra.extractor.*;
import com.gs.fw.common.mithra.finder.*;
import com.gs.fw.common.mithra.list.*;
import com.gs.fw.common.mithra.behavior.state.PersistenceState;
import com.gs.fw.common.mithra.attribute.update.*;
import com.gs.fw.common.mithra.transaction.MithraObjectPersister;
import java.util.Arrays;
import java.util.HashSet;
/**
* This file was automatically generated using Mithra 16.3.0. Please do not modify it.
* Add custom logic to its subclass instead.
*/
// Generated from templates/transactional/Abstract.jsp
public abstract class PersonAbstract extends com.gs.fw.common.mithra.superclassimpl.MithraTransactionalObjectImpl
{
	private static byte MEMORY_STATE = PersistenceState.IN_MEMORY;
	private static byte PERSISTED_STATE = PersistenceState.PERSISTED;
	private static final Logger logger = LoggerFactory.getLogger(Person.class.getName());
	public PersonAbstract()
	{
		this.persistenceState = MEMORY_STATE;
	}

	public Person getDetachedCopy() throws MithraBusinessException
	{
		return (Person) super.getDetachedCopy();
	}

	public Person getNonPersistentCopy() throws MithraBusinessException
	{
		Person result = (Person) super.getNonPersistentCopy();
		result.persistenceState = MEMORY_STATE;
		return result;
	}

	public void insert() throws MithraBusinessException
	{
		TransactionalBehavior behavior = zGetTransactionalBehaviorForWriteWithWaitIfNecessary();
		this.checkAndGeneratePrimaryKeys();
		behavior.insert(this);
	}

	public Person copyDetachedValuesToOriginalOrInsertIfNew()
	{
		return (Person) this.zCopyDetachedValuesToOriginalOrInsertIfNew();
	}

	public Person zFindOriginal()
	{
		PersonData data = (PersonData) this.currentData;
		Operation op;
		op = PersonFinder.personId().eq(data.getPersonId());
		return PersonFinder.findOne(op);
	}

	public boolean isModifiedSinceDetachmentByDependentRelationships()
	{
		if(this.isModifiedSinceDetachment()) return true;
		return false;
	}

	private Logger getLogger()
	{
		return logger;
	}

	public MithraDataObject zAllocateData()
	{
		return new PersonData();
	}

	protected void zSetFromPersonData( PersonData data )
	{
		super.zSetData(data);
		this.persistenceState = PERSISTED_STATE;
	}

	public void setFromPersonData( PersonData data )
	{
		super.zSetData(data);
	}

	public void zWriteDataClassName(ObjectOutput out) throws IOException
	{
	}

	public boolean isCountryNull()
	{
		return ((PersonData) this.zSynchronizedGetData()).isCountryNull();
	}

	public String getCountry()
	{
		PersonData data = (PersonData) this.zSynchronizedGetData();
		return data.getCountry();
	}

	public void setCountry(String newValue)
	{
		if (newValue != null) newValue = newValue.trim();
		if (newValue != null && newValue.length() > 48)
		throw new MithraBusinessException("Attribute 'country' cannot exceed maximum length of 48: " + newValue);
		zSetString(PersonFinder.country(), newValue, false, false );
	}

	public boolean isFirstNameNull()
	{
		return ((PersonData) this.zSynchronizedGetData()).isFirstNameNull();
	}

	public String getFirstName()
	{
		PersonData data = (PersonData) this.zSynchronizedGetData();
		return data.getFirstName();
	}

	public void setFirstName(String newValue)
	{
		if (newValue != null) newValue = newValue.trim();
		if (newValue != null && newValue.length() > 64)
		throw new MithraBusinessException("Attribute 'firstName' cannot exceed maximum length of 64: " + newValue);
		zSetString(PersonFinder.firstName(), newValue, false, false );
	}

	public boolean isLastNameNull()
	{
		return ((PersonData) this.zSynchronizedGetData()).isLastNameNull();
	}

	public String getLastName()
	{
		PersonData data = (PersonData) this.zSynchronizedGetData();
		return data.getLastName();
	}

	public void setLastName(String newValue)
	{
		if (newValue != null) newValue = newValue.trim();
		if (newValue != null && newValue.length() > 64)
		throw new MithraBusinessException("Attribute 'lastName' cannot exceed maximum length of 64: " + newValue);
		zSetString(PersonFinder.lastName(), newValue, false, false );
	}

	public boolean isPersonIdNull()
	{
		return ((PersonData) this.zSynchronizedGetData()).isPersonIdNull();
	}

	public int getPersonId()
	{
		PersonData data = (PersonData) this.zSynchronizedGetData();
		return data.getPersonId();
	}

	public void setPersonId(int newValue)
	{
		zSetInteger(PersonFinder.personId(), newValue, true, false ,false);
	}

	protected void issuePrimitiveNullSetters(TransactionalBehavior behavior, MithraDataObject data)
	{
	}

	public void zPersistDetachedRelationships(MithraDataObject _data)
	{
		PersonData _newData = (PersonData) _data;
	}

	public void zSetTxDetachedDeleted()
	{
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForWriteWithWaitIfNecessary();
		if (_behavior.isDetached() && _behavior.isDeleted()) return;
		PersonData _newData = (PersonData) _behavior.getCurrentDataForRead(this);
		this.zSetTxPersistenceState(PersistenceState.DETACHED_DELETED);
	}

	public void zSetNonTxDetachedDeleted()
	{
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForWriteWithWaitIfNecessary();
		PersonData _newData = (PersonData) _behavior.getCurrentDataForRead(this);
		this.zSetNonTxPersistenceState(PersistenceState.DETACHED_DELETED);
	}

	protected void cascadeInsertImpl() throws MithraBusinessException
	{
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForWriteWithWaitIfNecessary();
		this.checkAndGeneratePrimaryKeys();
		_behavior.insert(this);
	}

	@Override
	public Map< RelatedFinder, StatisticCounter > zAddNavigatedRelationshipsStats(RelatedFinder finder, Map< RelatedFinder, StatisticCounter > navigationStats)
	{
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForWriteWithWaitIfNecessary();
		_behavior.addNavigatedRelationshipsStats(this, finder, navigationStats);
		return navigationStats;
	}

	@Override
	public Map< RelatedFinder, StatisticCounter > zAddNavigatedRelationshipsStatsForUpdate(RelatedFinder parentFinderGeneric, Map< RelatedFinder, StatisticCounter > navigationStats)
	{
		return navigationStats;
	}

	@Override
	public Map< RelatedFinder, StatisticCounter > zAddNavigatedRelationshipsStatsForDelete(RelatedFinder parentFinder, Map< RelatedFinder, StatisticCounter > navigationStats)
	{
		return navigationStats;
	}

	@Override
	public Person zCascadeCopyThenInsert() throws MithraBusinessException
	{
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForWriteWithWaitIfNecessary();
		this.checkAndGeneratePrimaryKeys();
		Person original = (Person) _behavior.copyThenInsert(this);
		return original;
	}

	protected void cascadeDeleteImpl() throws MithraBusinessException
	{
		this.delete();
	}

	public Cache zGetCache()
	{
		return PersonFinder.getMithraObjectPortal().getCache();
	}

	public MithraObjectPortal zGetPortal()
	{
		return PersonFinder.getMithraObjectPortal();
	}

	public Person getOriginalPersistentObject()
	{
		return this.zFindOriginal();
	}

	protected boolean issueUpdatesForNonPrimaryKeys(TransactionalBehavior behavior, MithraDataObject data, MithraDataObject newData)
	{
		boolean changed = false;
		changed |= zUpdateString(behavior, data, newData, PersonFinder.country(), false);
		changed |= zUpdateString(behavior, data, newData, PersonFinder.firstName(), false);
		changed |= zUpdateString(behavior, data, newData, PersonFinder.lastName(), false);
		return changed;
	}

	protected boolean issueUpdatesForPrimaryKeys(TransactionalBehavior behavior, MithraDataObject data, MithraDataObject newData)
	{
		boolean changed = false;
		changed |= zUpdateInteger(behavior, data, newData, PersonFinder.personId(), false);
		return changed;
	}

	public int generateAndSetPersonId()
	{
		int nextValue =(int) this.generatePersonId();
		this.setPersonId(nextValue);
		return nextValue;
	}

	public boolean zGetIsPersonIdSet()
	{
		TransactionalBehavior behavior = zGetTransactionalBehaviorForReadWithWaitIfNecessary();
		PersonData data = (PersonData) behavior.getCurrentDataForRead(this);
		return data.zGetIsPersonIdSet();
	}

	protected int generatePersonId()
	throws MithraBusinessException
	{
		MaxFromTablePrimaryKeyGenerator primaryKeyGenerator =
		MithraPrimaryKeyGenerator.getInstance().getMaxFromTablePrimaryKeyGenerator(PersonFinder.personId(),null);
		return (int)primaryKeyGenerator.getNextId();
	}

	private void checkAndGeneratePrimaryKeys()
	{
		TransactionalBehavior behavior = zGetTransactionalBehaviorForWriteWithWaitIfNecessary();
		PersonData data = (PersonData) behavior.getCurrentDataForWrite(this);
		if (!data.zGetIsPersonIdSet())
		{
			data.setPersonId(generatePersonId());
		}
	}

	public Object readResolve() throws ObjectStreamException
	{
		PersonAbstract result = (PersonAbstract) super.readResolve();
		if (result.persistenceState == PersistenceState.PERSISTED)
		{
			result.persistenceState = PERSISTED_STATE;
		}
		else if (result.persistenceState == PersistenceState.IN_MEMORY)
		{
			result.persistenceState = MEMORY_STATE;
		}

		return result;
	}

	protected static void zConfigNonTx()
	{
		MEMORY_STATE = PersistenceState.IN_MEMORY_NON_TRANSACTIONAL;
		PERSISTED_STATE = PersistenceState.PERSISTED_NON_TRANSACTIONAL;
	}

	protected static void zConfigFullTx()
	{
		MEMORY_STATE = PersistenceState.IN_MEMORY;
		PERSISTED_STATE = PersistenceState.PERSISTED;
	}
}
