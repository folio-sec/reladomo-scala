package com.folio_sec.example.domain.simplebank;
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
* This file was automatically generated using Mithra 17.0.2. Please do not modify it.
* Add custom logic to its subclass instead.
*/
// Generated from templates/transactional/Abstract.jsp
public abstract class CustomerAbstract extends com.gs.fw.common.mithra.superclassimpl.MithraTransactionalObjectImpl
{
	private static byte MEMORY_STATE = PersistenceState.IN_MEMORY;
	private static byte PERSISTED_STATE = PersistenceState.PERSISTED;
	private static final Logger logger = LoggerFactory.getLogger(Customer.class.getName());
	public CustomerAbstract()
	{
		this.persistenceState = MEMORY_STATE;
	}

	public Customer getDetachedCopy() throws MithraBusinessException
	{
		return (Customer) super.getDetachedCopy();
	}

	public Customer getNonPersistentCopy() throws MithraBusinessException
	{
		Customer result = (Customer) super.getNonPersistentCopy();
		result.persistenceState = MEMORY_STATE;
		return result;
	}

	public void insert() throws MithraBusinessException
	{
		TransactionalBehavior behavior = zGetTransactionalBehaviorForWriteWithWaitIfNecessary();
		this.checkAndGeneratePrimaryKeys();
		behavior.insert(this);
	}

	public Customer copyDetachedValuesToOriginalOrInsertIfNew()
	{
		return (Customer) this.zCopyDetachedValuesToOriginalOrInsertIfNew();
	}

	public Customer zFindOriginal()
	{
		CustomerData data = (CustomerData) this.currentData;
		Operation op;
		op = CustomerFinder.customerId().eq(data.getCustomerId());
		return CustomerFinder.findOne(op);
	}

	public boolean isModifiedSinceDetachmentByDependentRelationships()
	{
		if(this.isModifiedSinceDetachment()) return true;
		if(isAccountsModifiedSinceDetachment()) return true;
		return false;
	}

	private Logger getLogger()
	{
		return logger;
	}

	public MithraDataObject zAllocateData()
	{
		return new CustomerData();
	}

	protected void zSetFromCustomerData( CustomerData data )
	{
		super.zSetData(data);
		this.persistenceState = PERSISTED_STATE;
	}

	public void setFromCustomerData( CustomerData data )
	{
		super.zSetData(data);
	}

	public void zWriteDataClassName(ObjectOutput out) throws IOException
	{
	}

	public boolean isCountryNull()
	{
		return ((CustomerData) this.zSynchronizedGetData()).isCountryNull();
	}

	public String getCountry()
	{
		CustomerData data = (CustomerData) this.zSynchronizedGetData();
		return data.getCountry();
	}

	public void setCountry(String newValue)
	{
		if (newValue != null) newValue = newValue.trim();
		if (newValue != null && newValue.length() > 48)
		throw new MithraBusinessException("Attribute 'country' cannot exceed maximum length of 48: " + newValue);
		zSetString(CustomerFinder.country(), newValue, false, false );
	}

	public boolean isCustomerIdNull()
	{
		return ((CustomerData) this.zSynchronizedGetData()).isCustomerIdNull();
	}

	public int getCustomerId()
	{
		CustomerData data = (CustomerData) this.zSynchronizedGetData();
		return data.getCustomerId();
	}

	public void setCustomerId(int newValue)
	{
		MithraDataObject d = zSetInteger(CustomerFinder.customerId(), newValue, true, false ,false);
		if (d == null) return;
		CustomerData data = (CustomerData) d;
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForWriteWithWaitIfNecessary();
		if (!_behavior.isPersisted())
		{
			CustomerAccountList accounts =
			(CustomerAccountList ) data.getAccounts();
			if (accounts != null)
			{
				accounts.setCustomerId(newValue);
			}
		}
	}

	public boolean isFirstNameNull()
	{
		return ((CustomerData) this.zSynchronizedGetData()).isFirstNameNull();
	}

	public String getFirstName()
	{
		CustomerData data = (CustomerData) this.zSynchronizedGetData();
		return data.getFirstName();
	}

	public void setFirstName(String newValue)
	{
		if (newValue != null) newValue = newValue.trim();
		if (newValue != null && newValue.length() > 64)
		throw new MithraBusinessException("Attribute 'firstName' cannot exceed maximum length of 64: " + newValue);
		zSetString(CustomerFinder.firstName(), newValue, false, false );
	}

	public boolean isLastNameNull()
	{
		return ((CustomerData) this.zSynchronizedGetData()).isLastNameNull();
	}

	public String getLastName()
	{
		CustomerData data = (CustomerData) this.zSynchronizedGetData();
		return data.getLastName();
	}

	public void setLastName(String newValue)
	{
		if (newValue != null) newValue = newValue.trim();
		if (newValue != null && newValue.length() > 64)
		throw new MithraBusinessException("Attribute 'lastName' cannot exceed maximum length of 64: " + newValue);
		zSetString(CustomerFinder.lastName(), newValue, false, false );
	}

	public boolean isZipCodeNull()
	{
		return ((CustomerData) this.zSynchronizedGetData()).isZipCodeNull();
	}

	public int getZipCode()
	{
		CustomerData data = (CustomerData) this.zSynchronizedGetData();
		if (data.isZipCodeNull()) MithraNullPrimitiveException.throwNew("zipCode", data);
		return data.getZipCode();
	}

	public void setZipCode(int newValue)
	{
		zSetInteger(CustomerFinder.zipCode(), newValue, false, false ,true);
	}

	protected void issuePrimitiveNullSetters(TransactionalBehavior behavior, MithraDataObject data)
	{
		zNullify(behavior, data, CustomerFinder.zipCode(), false);
	}

	public void setZipCodeNull()
	{
		zNullify(CustomerFinder.zipCode(), false);
	}

	public void zPersistDetachedRelationships(MithraDataObject _data)
	{
		CustomerData _newData = (CustomerData) _data;
		{
			CustomerAccountList accounts =
			(CustomerAccountList) _newData.getAccounts();
			if (accounts != null)
			{
				accounts.copyDetachedValuesToOriginalOrInsertIfNewOrDeleteIfRemoved();
			}
		}
	}

	public void zSetTxDetachedDeleted()
	{
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForWriteWithWaitIfNecessary();
		if (_behavior.isDetached() && _behavior.isDeleted()) return;
		CustomerData _newData = (CustomerData) _behavior.getCurrentDataForRead(this);
		if (_newData.getAccounts() != null && !(_newData.getAccounts() instanceof NulledRelation))
		{
			((CustomerAccountList)_newData.getAccounts()).zSetTxDetachedDeleted();
		}

		this.zSetTxPersistenceState(PersistenceState.DETACHED_DELETED);
	}

	public void zSetNonTxDetachedDeleted()
	{
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForWriteWithWaitIfNecessary();
		CustomerData _newData = (CustomerData) _behavior.getCurrentDataForRead(this);
		if (_newData.getAccounts() != null && !(_newData.getAccounts() instanceof NulledRelation))
		{
			((CustomerAccountList)_newData.getAccounts()).zSetNonTxDetachedDeleted();
		}

		this.zSetNonTxPersistenceState(PersistenceState.DETACHED_DELETED);
	}

	/**
	* Relationship Expression:<pre>
	this.customerId = CustomerAccount.customerId</pre>
	* @see CustomerAccount#getCustomer() reverse relationship CustomerAccount.getCustomer()
	* @return accounts
	*/
	public CustomerAccountList getAccounts()
	{
		CustomerAccountList _result = null;
		Operation _op = null;
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForReadWithWaitIfNecessary();
		CustomerData _data = (CustomerData) _behavior.getCurrentDataForRead(this);
		if (_behavior.isPersisted())
		{
			{
				{
					_op = CustomerAccountFinder.customerId().eq(_data.getCustomerId());
				}
			}
		}
		else if (_behavior.isDetached())
		{
			_result = (CustomerAccountList) _data.getAccounts();
			if (_result == null)
			{
				{
					Operation detachedOp = CustomerAccountFinder.customerId().eq(_data.getCustomerId());
					_result = new CustomerAccountList(detachedOp);
					_result.zSetForRelationship();
					if(_result != null)
					{
						_result = _result.getDetachedCopy();
					}

					_result.zSetAddHandler(new AccountsAddHandlerInMemory());
				}

				_behavior = zGetTransactionalBehaviorForWriteWithWaitIfNecessary();
				_data = (CustomerData) _behavior.getCurrentDataForWrite(this);
				_data.setAccounts(_result);
				if (_result != null) _result.zSetParentContainercustomer(this);
			}
		}
		else if (_behavior.isInMemory())
		{
			_result = (CustomerAccountList) _data.getAccounts();
			if (_result == null)
			{
				_result = new CustomerAccountList();
				_result.zSetAddHandler(new AccountsAddHandlerInMemory());
				_behavior = zGetTransactionalBehaviorForWriteWithWaitIfNecessary();
				_data = (CustomerData) _behavior.getCurrentDataForWrite(this);
				_data.setAccounts(_result);
			}
		}

		if (_op != null)
		{
			_result = new CustomerAccountList(_op);
			_result.zSetForRelationship();
			_result.zSetRemoveHandler(DeleteOnRemoveHandler.getInstance());
			_result.zSetAddHandler(new AccountsAddHandlerPersisted());
		}

		return _result;
	}

	public void setAccounts(CustomerAccountList accounts)
	{
		CustomerAccountList _accounts = (CustomerAccountList) accounts;
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForWriteWithWaitIfNecessary();
		CustomerData _data = (CustomerData) _behavior.getCurrentDataForWrite(this);
		if (_behavior.isInMemory())
		{
			if (_behavior.isDetached() && _accounts != null)
			{
				_accounts.zMakeDetached(CustomerAccountFinder.customerId().eq(_data.getCustomerId()),
					_data.getAccounts());
			}

			_data.setAccounts(_accounts);
			if (_accounts != null)
			{
				_accounts.setCustomerId(_data.getCustomerId());
				_accounts.zSetParentContainercustomer(this);
				_accounts.zSetAddHandler(new AccountsAddHandlerInMemory());
			}
			else if (_behavior.isDetached())
			{
				throw new MithraBusinessException("to-many relationships cannot be set to null. Use the clear() method on the list instead.");
			}
		}
		else if (_behavior.isPersisted())
		{
			_behavior.clearTempTransaction(this);
			_accounts.zSetAddHandler(new AccountsAddHandlerPersisted());
			CustomerAccountList accountsToDelete = new CustomerAccountList();
			accountsToDelete.addAll(this.getAccounts());
			for(int i=0;i < _accounts.size(); i++)
			{
				CustomerAccount item = _accounts.getCustomerAccountAt(i);
				if (!accountsToDelete.remove(item))
				{
					item.setCustomerId(_data.getCustomerId());
					item.cascadeInsert();
				}
			}

			accountsToDelete.cascadeDeleteAll();
		}
		else throw new RuntimeException("not implemented");
	}

	public boolean isAccountsModifiedSinceDetachment()
	{
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForReadWithWaitIfNecessary();
		CustomerData _data = (CustomerData) _behavior.getCurrentDataForRead(this);
		CustomerAccountList accounts =
		(CustomerAccountList) _data.getAccounts();
		if( accounts != null)
		{
			return accounts.isModifiedSinceDetachment();
		}

		return false;
	}

	protected void cascadeInsertImpl() throws MithraBusinessException
	{
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForWriteWithWaitIfNecessary();
		this.checkAndGeneratePrimaryKeys();
		CustomerData _data = (CustomerData) _behavior.getCurrentDataForWrite(this);
		CustomerAccountList accounts =
		(CustomerAccountList) _data.getAccounts();
		_behavior.insert(this);
		if (accounts != null)
		{
			accounts.cascadeInsertAll();
		}
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
		CustomerFinder.CustomerRelatedFinder parentFinder = (CustomerFinder.CustomerRelatedFinder) parentFinderGeneric;
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForWriteWithWaitIfNecessary();
		CustomerData _newData = (CustomerData) _behavior.getCurrentDataForWrite(this);
		{
			CustomerAccountList accounts =
			(CustomerAccountList) _newData.getAccounts();
			RelatedFinder dependentFinder = parentFinder.accounts();
			DeepRelationshipUtility.zAddToNavigationStats(dependentFinder, accounts != null, navigationStats);
			if (accounts != null)
			{
				accounts.zCascadeAddNavigatedRelationshipsStats(dependentFinder, navigationStats);
			}
		}

		return navigationStats;
	}

	@Override
	public Map< RelatedFinder, StatisticCounter > zAddNavigatedRelationshipsStatsForDelete(RelatedFinder parentFinder, Map< RelatedFinder, StatisticCounter > navigationStats)
	{
		DeepRelationshipUtility.zAddAllDependentNavigationsStatsForDelete(parentFinder, navigationStats);
		return navigationStats;
	}

	@Override
	public Customer zCascadeCopyThenInsert() throws MithraBusinessException
	{
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForWriteWithWaitIfNecessary();
		this.checkAndGeneratePrimaryKeys();
		CustomerData _data = (CustomerData) _behavior.getCurrentDataForWrite(this);
		CustomerAccountList accounts =
		(CustomerAccountList) _data.getAccounts();
		Customer original = (Customer) _behavior.copyThenInsert(this);
		if (accounts != null)
		{
			accounts.zCascadeCopyThenInsertAll();
		}

		return original;
	}

	protected void cascadeDeleteImpl() throws MithraBusinessException
	{
		this.getAccounts().cascadeDeleteAll();
		this.delete();
	}

	public Cache zGetCache()
	{
		return CustomerFinder.getMithraObjectPortal().getCache();
	}

	public MithraObjectPortal zGetPortal()
	{
		return CustomerFinder.getMithraObjectPortal();
	}

	public Customer getOriginalPersistentObject()
	{
		return this.zFindOriginal();
	}

	protected boolean issueUpdatesForNonPrimaryKeys(TransactionalBehavior behavior, MithraDataObject data, MithraDataObject newData)
	{
		boolean changed = false;
		changed |= zUpdateString(behavior, data, newData, CustomerFinder.country(), false);
		changed |= zUpdateString(behavior, data, newData, CustomerFinder.firstName(), false);
		changed |= zUpdateString(behavior, data, newData, CustomerFinder.lastName(), false);
		changed |= zUpdateInteger(behavior, data, newData, CustomerFinder.zipCode(), false);
		return changed;
	}

	protected boolean issueUpdatesForPrimaryKeys(TransactionalBehavior behavior, MithraDataObject data, MithraDataObject newData)
	{
		boolean changed = false;
		changed |= zUpdateInteger(behavior, data, newData, CustomerFinder.customerId(), false);
		return changed;
	}

	public int generateAndSetCustomerId()
	{
		int nextValue =(int) this.generateCustomerId();
		this.setCustomerId(nextValue);
		return nextValue;
	}

	public boolean zGetIsCustomerIdSet()
	{
		TransactionalBehavior behavior = zGetTransactionalBehaviorForReadWithWaitIfNecessary();
		CustomerData data = (CustomerData) behavior.getCurrentDataForRead(this);
		return data.zGetIsCustomerIdSet();
	}

	protected int generateCustomerId()
	throws MithraBusinessException
	{
		MaxFromTablePrimaryKeyGenerator primaryKeyGenerator =
		MithraPrimaryKeyGenerator.getInstance().getMaxFromTablePrimaryKeyGenerator(CustomerFinder.customerId(),null);
		return (int)primaryKeyGenerator.getNextId();
	}

	private void checkAndGeneratePrimaryKeys()
	{
		TransactionalBehavior behavior = zGetTransactionalBehaviorForWriteWithWaitIfNecessary();
		CustomerData data = (CustomerData) behavior.getCurrentDataForWrite(this);
		if (!data.zGetIsCustomerIdSet())
		{
			data.setCustomerId(generateCustomerId());
			CustomerAccountList accounts =
			(CustomerAccountList ) data.getAccounts();
			if (accounts != null)
			{
				accounts.setCustomerId(data.getCustomerId());
			}
		}
	}

	public Object readResolve() throws ObjectStreamException
	{
		CustomerAbstract result = (CustomerAbstract) super.readResolve();
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

	protected class AccountsAddHandlerInMemory implements DependentRelationshipAddHandler
	{
		public void addRelatedObject(MithraTransactionalObject relatedObject)
		{
			CustomerAccount item = (CustomerAccount) relatedObject;
			item.setCustomerId(getCustomerId());
			item.zSetParentContainercustomer(CustomerAbstract.this);
		}
	}

	protected class AccountsAddHandlerPersisted implements DependentRelationshipAddHandler
	{
		public void addRelatedObject(MithraTransactionalObject relatedObject)
		{
			CustomerAccount item = (CustomerAccount) relatedObject;
			item.setCustomerId(getCustomerId());
			item.cascadeInsert();
		}
	}
}
