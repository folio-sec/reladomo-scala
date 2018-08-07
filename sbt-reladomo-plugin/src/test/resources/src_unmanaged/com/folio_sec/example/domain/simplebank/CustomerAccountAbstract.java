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
public abstract class CustomerAccountAbstract extends com.gs.fw.common.mithra.superclassimpl.MithraTransactionalObjectImpl
{
	private static byte MEMORY_STATE = PersistenceState.IN_MEMORY;
	private static byte PERSISTED_STATE = PersistenceState.PERSISTED;
	private static final Logger logger = LoggerFactory.getLogger(CustomerAccount.class.getName());
	private static final RelationshipHashStrategy forcustomer = new CustomerRhs();
	private static final class CustomerRhs implements RelationshipHashStrategy
	{
		public boolean equalsForRelationship(Object _srcObject, Object _srcData, Object _targetData, Timestamp _asOfDate0, Timestamp _asOfDate1)
		{
			CustomerAccountData _castedSrcData = (CustomerAccountData) _srcData;
			CustomerData _castedTargetData = (CustomerData) _targetData;
			if (_castedSrcData.getCustomerId() == _castedTargetData.getCustomerId())
			{
				return true;
			}

			return false;
		}

		public int computeHashCodeFromRelated(Object _srcObject, Object _srcData)
		{
			CustomerAccountData _castedSrcData = (CustomerAccountData) _srcData;
			return HashUtil.hash(_castedSrcData.getCustomerId());
		}

		public int computeOffHeapHashCodeFromRelated(Object _srcObject, Object _srcData)
		{
			return computeHashCodeFromRelated(_srcObject, _srcData);
		}
	}

	public CustomerAccountAbstract()
	{
		this.persistenceState = MEMORY_STATE;
	}

	public CustomerAccount getDetachedCopy() throws MithraBusinessException
	{
		return (CustomerAccount) super.getDetachedCopy();
	}

	public CustomerAccount getNonPersistentCopy() throws MithraBusinessException
	{
		CustomerAccount result = (CustomerAccount) super.getNonPersistentCopy();
		result.persistenceState = MEMORY_STATE;
		return result;
	}

	public void insert() throws MithraBusinessException
	{
		TransactionalBehavior behavior = zGetTransactionalBehaviorForWriteWithWaitIfNecessary();
		this.checkAndGeneratePrimaryKeys();
		behavior.insert(this);
	}

	public CustomerAccount copyDetachedValuesToOriginalOrInsertIfNew()
	{
		return (CustomerAccount) this.zCopyDetachedValuesToOriginalOrInsertIfNew();
	}

	public CustomerAccount zFindOriginal()
	{
		CustomerAccountData data = (CustomerAccountData) this.currentData;
		Operation op;
		op = CustomerAccountFinder.accountId().eq(data.getAccountId());
		return CustomerAccountFinder.findOne(op);
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
		return new CustomerAccountData();
	}

	protected void zSetFromCustomerAccountData( CustomerAccountData data )
	{
		super.zSetData(data);
		this.persistenceState = PERSISTED_STATE;
	}

	public void setFromCustomerAccountData( CustomerAccountData data )
	{
		super.zSetData(data);
	}

	public void zWriteDataClassName(ObjectOutput out) throws IOException
	{
	}

	public boolean isAccountIdNull()
	{
		return ((CustomerAccountData) this.zSynchronizedGetData()).isAccountIdNull();
	}

	public int getAccountId()
	{
		CustomerAccountData data = (CustomerAccountData) this.zSynchronizedGetData();
		return data.getAccountId();
	}

	public void setAccountId(int newValue)
	{
		zSetInteger(CustomerAccountFinder.accountId(), newValue, true, false ,false);
	}

	public boolean isAccountNameNull()
	{
		return ((CustomerAccountData) this.zSynchronizedGetData()).isAccountNameNull();
	}

	public String getAccountName()
	{
		CustomerAccountData data = (CustomerAccountData) this.zSynchronizedGetData();
		return data.getAccountName();
	}

	public void setAccountName(String newValue)
	{
		if (newValue != null) newValue = newValue.trim();
		if (newValue != null && newValue.length() > 48)
		throw new MithraBusinessException("Attribute 'accountName' cannot exceed maximum length of 48: " + newValue);
		zSetString(CustomerAccountFinder.accountName(), newValue, false, false );
	}

	public boolean isAccountTypeNull()
	{
		return ((CustomerAccountData) this.zSynchronizedGetData()).isAccountTypeNull();
	}

	public String getAccountType()
	{
		CustomerAccountData data = (CustomerAccountData) this.zSynchronizedGetData();
		return data.getAccountType();
	}

	public void setAccountType(String newValue)
	{
		if (newValue != null) newValue = newValue.trim();
		if (newValue != null && newValue.length() > 16)
		throw new MithraBusinessException("Attribute 'accountType' cannot exceed maximum length of 16: " + newValue);
		zSetString(CustomerAccountFinder.accountType(), newValue, false, false );
	}

	public boolean isAreaIdNull()
	{
		return ((CustomerAccountData) this.zSynchronizedGetData()).isAreaIdNull();
	}

	public int getAreaId()
	{
		CustomerAccountData data = (CustomerAccountData) this.zSynchronizedGetData();
		if (data.isAreaIdNull()) MithraNullPrimitiveException.throwNew("areaId", data);
		return data.getAreaId();
	}

	public void setAreaId(int newValue)
	{
		zSetInteger(CustomerAccountFinder.areaId(), newValue, false, false ,true);
	}

	public boolean isBalanceNull()
	{
		return ((CustomerAccountData) this.zSynchronizedGetData()).isBalanceNull();
	}

	public double getBalance()
	{
		CustomerAccountData data = (CustomerAccountData) this.zSynchronizedGetData();
		if (data.isBalanceNull()) MithraNullPrimitiveException.throwNew("balance", data);
		return data.getBalance();
	}

	public void setBalance(double newValue)
	{
		zSetDouble(CustomerAccountFinder.balance(), newValue, false, false ,true);
	}

	public boolean isCustomerIdNull()
	{
		return ((CustomerAccountData) this.zSynchronizedGetData()).isCustomerIdNull();
	}

	public int getCustomerId()
	{
		CustomerAccountData data = (CustomerAccountData) this.zSynchronizedGetData();
		return data.getCustomerId();
	}

	public void setCustomerId(int newValue)
	{
		zSetInteger(CustomerAccountFinder.customerId(), newValue, false, false ,false);
	}

	protected void issuePrimitiveNullSetters(TransactionalBehavior behavior, MithraDataObject data)
	{
		zNullify(behavior, data, CustomerAccountFinder.areaId(), false);
		zNullify(behavior, data, CustomerAccountFinder.balance(), false);
	}

	public void setAreaIdNull()
	{
		zNullify(CustomerAccountFinder.areaId(), false);
	}

	public void setBalanceNull()
	{
		zNullify(CustomerAccountFinder.balance(), false);
	}

	public void zPersistDetachedRelationships(MithraDataObject _data)
	{
		CustomerAccountData _newData = (CustomerAccountData) _data;
	}

	public void zSetTxDetachedDeleted()
	{
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForWriteWithWaitIfNecessary();
		if (_behavior.isDetached() && _behavior.isDeleted()) return;
		CustomerAccountData _newData = (CustomerAccountData) _behavior.getCurrentDataForRead(this);
		this.zSetTxPersistenceState(PersistenceState.DETACHED_DELETED);
	}

	public void zSetNonTxDetachedDeleted()
	{
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForWriteWithWaitIfNecessary();
		CustomerAccountData _newData = (CustomerAccountData) _behavior.getCurrentDataForRead(this);
		this.zSetNonTxPersistenceState(PersistenceState.DETACHED_DELETED);
	}

	/**
	* Relationship Expression:<pre>
	Customer.customerId = this.customerId</pre>
	* @see Customer#getAccounts() reverse relationship Customer.getAccounts()
	* @return The customer
	*/
	public Customer getCustomer()
	{
		Customer _result = null;
		Operation _op = null;
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForReadWithWaitIfNecessary();
		CustomerAccountData _data = (CustomerAccountData) _behavior.getCurrentDataForRead(this);
		MithraObjectPortal _portal = null;
		if (_behavior.isPersisted())
		{
			{
				_portal = CustomerFinder.getMithraObjectPortal();
				Object _related = _portal.getAsOneFromCache(this, _data, forcustomer, null, null);
				if (!(_related instanceof NulledRelation)) _result = (Customer) _related;
				if (_related == null)
				{
					_op = CustomerFinder.customerId().eq(_data.getCustomerId());
				}
			}
		}
		else if (_behavior.isDetached())
		{
			if (_data.getCustomer() instanceof NulledRelation)
			{
				return null;
			}

			_result = (Customer) _data.getCustomer();
			if (_result == null)
			{
				{
					Operation detachedOp = CustomerFinder.customerId().eq(_data.getCustomerId());
					_result = CustomerFinder.zFindOneForRelationship(detachedOp);
					if(_result != null)
					{
						_result = _result.getDetachedCopy();
					}
				}

				_data = (CustomerAccountData) _behavior.getCurrentDataForWrite(this);
				_data.setCustomer(_result);
			}
		}
		else if (_behavior.isInMemory())
		{
			_result = (Customer) _data.getCustomer();
			if (_result == null)
			{
				{
					_op = CustomerFinder.customerId().eq(_data.getCustomerId());
				}
			}
		}

		if (_op != null)
		{
			_result = CustomerFinder.zFindOneForRelationship(_op);
		}

		return _result;
	}

	public void setCustomer(Customer customer)
	{
		Customer _customer = (Customer) customer;
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForWriteWithWaitIfNecessary();
		CustomerAccountData _data = (CustomerAccountData) _behavior.getCurrentDataForWrite(this);
		if (_behavior.isInMemory())
		{
			Object _prev = _data.getCustomer();
			if (_behavior.isDetached() && _prev != null)
			{
				((DelegatingList)((Customer)_prev).getAccounts()).zMarkMoved( (CustomerAccount) this);
			}

			_data.setCustomer(_customer);
			_customer.getAccounts().add( (CustomerAccount) this);
		}
		else if (_behavior.isPersisted())
		{
			_behavior.clearTempTransaction(this);
			if (_customer == null)
			{
				this.setCustomerId(0);
			}
			else
			{
				this.setCustomerId(
					_customer.getCustomerId());
			}
		}
		else throw new RuntimeException("not implemented");
	}

	public void zSetParentContainercustomer(CustomerAbstract parent)
	{
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForWriteWithWaitIfNecessary();
		CustomerAccountData _data = (CustomerAccountData) _behavior.getCurrentDataForWrite(this);
		_behavior.clearTempTransaction(this);
		if (_behavior.isInMemory())
		{
			_data.setCustomer(parent);
		}
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
	public CustomerAccount zCascadeCopyThenInsert() throws MithraBusinessException
	{
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForWriteWithWaitIfNecessary();
		this.checkAndGeneratePrimaryKeys();
		CustomerAccount original = (CustomerAccount) _behavior.copyThenInsert(this);
		return original;
	}

	protected void cascadeDeleteImpl() throws MithraBusinessException
	{
		this.delete();
	}

	public Cache zGetCache()
	{
		return CustomerAccountFinder.getMithraObjectPortal().getCache();
	}

	public MithraObjectPortal zGetPortal()
	{
		return CustomerAccountFinder.getMithraObjectPortal();
	}

	public CustomerAccount getOriginalPersistentObject()
	{
		return this.zFindOriginal();
	}

	protected boolean issueUpdatesForNonPrimaryKeys(TransactionalBehavior behavior, MithraDataObject data, MithraDataObject newData)
	{
		boolean changed = false;
		changed |= zUpdateString(behavior, data, newData, CustomerAccountFinder.accountName(), false);
		changed |= zUpdateString(behavior, data, newData, CustomerAccountFinder.accountType(), false);
		changed |= zUpdateInteger(behavior, data, newData, CustomerAccountFinder.areaId(), false);
		changed |= zUpdateDouble(behavior, data, newData, CustomerAccountFinder.balance(), false);
		changed |= zUpdateInteger(behavior, data, newData, CustomerAccountFinder.customerId(), false);
		return changed;
	}

	protected boolean issueUpdatesForPrimaryKeys(TransactionalBehavior behavior, MithraDataObject data, MithraDataObject newData)
	{
		boolean changed = false;
		changed |= zUpdateInteger(behavior, data, newData, CustomerAccountFinder.accountId(), false);
		return changed;
	}

	public int generateAndSetAccountId()
	{
		int nextValue =(int) this.generateAccountId();
		this.setAccountId(nextValue);
		return nextValue;
	}

	public boolean zGetIsAccountIdSet()
	{
		TransactionalBehavior behavior = zGetTransactionalBehaviorForReadWithWaitIfNecessary();
		CustomerAccountData data = (CustomerAccountData) behavior.getCurrentDataForRead(this);
		return data.zGetIsAccountIdSet();
	}

	protected int generateAccountId()
	throws MithraBusinessException
	{
		MaxFromTablePrimaryKeyGenerator primaryKeyGenerator =
		MithraPrimaryKeyGenerator.getInstance().getMaxFromTablePrimaryKeyGenerator(CustomerAccountFinder.accountId(),null);
		return (int)primaryKeyGenerator.getNextId();
	}

	private void checkAndGeneratePrimaryKeys()
	{
		TransactionalBehavior behavior = zGetTransactionalBehaviorForWriteWithWaitIfNecessary();
		CustomerAccountData data = (CustomerAccountData) behavior.getCurrentDataForWrite(this);
		if (!data.zGetIsAccountIdSet())
		{
			data.setAccountId(generateAccountId());
		}
	}

	public Object readResolve() throws ObjectStreamException
	{
		CustomerAccountAbstract result = (CustomerAccountAbstract) super.readResolve();
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
