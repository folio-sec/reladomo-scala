package kata.domain;

import com.gs.fw.common.mithra.*;
import com.gs.fw.common.mithra.behavior.AuditOnlyTemporalDirector;
import com.gs.fw.common.mithra.behavior.DatedTransactionalBehavior;
import com.gs.fw.common.mithra.behavior.TemporalContainer;
import com.gs.fw.common.mithra.behavior.TemporalDirector;
import com.gs.fw.common.mithra.behavior.state.DatedPersistenceState;
import com.gs.fw.common.mithra.behavior.txparticipation.MithraOptimisticLockException;
import com.gs.fw.common.mithra.cache.Cache;
import com.gs.fw.common.mithra.finder.Operation;
import com.gs.fw.common.mithra.finder.RelatedFinder;
import com.gs.fw.common.mithra.util.MithraTimestamp;
import com.gs.fw.common.mithra.util.StatisticCounter;
import com.gs.fw.common.mithra.util.TimestampPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.sql.Timestamp;
import java.util.Map;

/**
* This file was automatically generated using Mithra 16.5.1. Please do not modify it.
* Add custom logic to its subclass instead.
*/
// Generated from templates/datedtransactional/Abstract.jsp
public abstract class TaskAbstract extends com.gs.fw.common.mithra.superclassimpl.MithraDatedTransactionalObjectImpl implements Serializable
{
	private static TemporalDirector temporalDirector = new AuditOnlyTemporalDirector(
		TaskFinder.processingDate()
	, TaskFinder.zGetDoubleAttributes(),TaskFinder.zGetBigDecimalAttributes());
	protected transient Timestamp processingDate;
	private static final Logger logger = LoggerFactory.getLogger(Task.class.getName());
	private static byte MEMORY_STATE = DatedPersistenceState.IN_MEMORY;
	private static byte PERSISTED_STATE = DatedPersistenceState.PERSISTED;
	public TaskAbstract(Timestamp processingDate
	)
	{
		this.processingDate = TimestampPool.getInstance().getOrAddToCache(processingDate, TaskFinder.isFullCache());
		this.persistenceState = MEMORY_STATE;
	}

	public TaskData zSynchronizedGetData()
	{
		return (TaskData) super.zSynchronizedGetData();
	}

	protected boolean checkAsOfAttributesForRefresh(MithraDataObject current)
	{
		boolean refresh = !TaskFinder.processingDate().dataMatches(current, this.processingDate);
		return refresh;
	}

	public TemporalDirector zGetTemporalDirector()
	{
		return temporalDirector;
	}

	public void insert() throws MithraBusinessException
	{
		DatedTransactionalBehavior behavior = this.zGetTransactionalBehaviorForWrite();
		this.checkAndGeneratePrimaryKeys();
		behavior.insert(this);
	}

	public void insertUntil(Timestamp exclusiveUntil) throws MithraBusinessException
	{
		throw new MithraBusinessException("insertUntil is only supported for dated objects with a business date");
	}

	public void terminateUntil(Timestamp exclusiveUntil) throws MithraBusinessException
	{
		throw new MithraBusinessException("terminateUntil is only supported for dated objects with a business date");
	}

	public void insertForRecovery() throws MithraBusinessException
	{
		DatedTransactionalBehavior behavior = this.zGetTransactionalBehaviorForWrite();
		checkAndGeneratePrimaryKeys();
		behavior.insertForRecovery(this);
	}

	public void insertWithIncrement() throws MithraBusinessException
	{
		DatedTransactionalBehavior behavior = this.zGetTransactionalBehaviorForWrite();
		this.checkAndGeneratePrimaryKeys();
		behavior.insertWithIncrement(this);
	}

	public void insertWithIncrementUntil(Timestamp exclusiveUntil) throws MithraBusinessException
	{
		DatedTransactionalBehavior behavior = this.zGetTransactionalBehaviorForWrite();
		this.checkAndGeneratePrimaryKeys();
		behavior.insertWithIncrementUntil(this, exclusiveUntil);
	}

	protected void cascadeInsertImpl() throws MithraBusinessException
	{
		DatedTransactionalBehavior _behavior = zGetTransactionalBehaviorForWrite();
		this.checkAndGeneratePrimaryKeys();
		_behavior.insert(this);
	}

	@Override
	public Map< RelatedFinder, StatisticCounter > zAddNavigatedRelationshipsStats(RelatedFinder finder, Map< RelatedFinder, StatisticCounter > navigationStats)
	{
		DatedTransactionalBehavior _behavior = zGetTransactionalBehaviorForWrite();
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

	public Task zCascadeCopyThenInsert() throws MithraBusinessException
	{
		DatedTransactionalBehavior _behavior = zGetTransactionalBehaviorForWrite();
		this.checkAndGeneratePrimaryKeys();
		Task original = (Task) _behavior.copyThenInsert(this);
		return original;
	}

	public void cascadeInsertUntil(Timestamp exclusiveUntil) throws MithraBusinessException
	{
		this.insertUntil(exclusiveUntil);
	}

	protected DatedTransactionalState zCreateDatedTransactionalState(TemporalContainer container, MithraDataObject data, MithraTransaction threadTx)
	{
		return new DatedTransactionalState(threadTx,
			this.persistenceState, container, data, null,
			TaskFinder.processingDate().getInfinityDate().equals(this.processingDate) || threadTx.isInFuture(this.processingDate.getTime()));
	}

	public Task getNonPersistentCopy() throws MithraBusinessException
	{
		DatedTransactionalBehavior behavior = this.zGetTransactionalBehavior();
		MithraDataObject data = behavior.getCurrentDataForRead(this);
		MithraDataObject newData = data.copy(!behavior.isPersisted());
		Timestamp[] asOfAttributes = new Timestamp[1];
		asOfAttributes[0] = this.processingDate;
		TaskAbstract result = (TaskAbstract)
		((MithraDatedObjectFactory) this.zGetPortal().getMithraDatedObjectFactory()).createObject(newData, asOfAttributes);
		result.zSetNonTxPersistenceState(MEMORY_STATE);
		if (result.transactionalState != null)
		{
			result.zSetTxPersistenceState(DatedPersistenceState.IN_MEMORY);
		}

		return (Task) result;
	}

	public Task zFindOriginal()
	{
		TaskData data = (TaskData) this.currentData;
		Operation op;
		op = TaskFinder.taskId().eq(data.getTaskId());
		op = op.and(TaskFinder.processingDate().eq(this.getProcessingDate()));
		return TaskFinder.findOne(op);
	}

	public Task getDetachedCopy() throws MithraBusinessException
	{
		DatedTransactionalBehavior behavior = this.zGetTransactionalBehavior();
		Timestamp[] asOfAttributes = new Timestamp[1];
		asOfAttributes[0] = this.processingDate;
		TaskAbstract result = (TaskAbstract) behavior.getDetachedCopy(this, asOfAttributes);
		if (result.transactionalState != null)
		{
			result.zSetTxPersistenceState(DatedPersistenceState.DETACHED);
		}

		return (Task) result;
	}

	public boolean isModifiedSinceDetachmentByDependentRelationships()
	{
		if(this.isModifiedSinceDetachment()) return true;
		return false;
	}

	public Task copyDetachedValuesToOriginalOrInsertIfNewImpl(MithraTransaction tx)
	{
		DatedTransactionalBehavior behavior = this.zGetTransactionalBehaviorForWrite();
		return (Task) behavior.updateOriginalOrInsert(this);
	}

	public Task copyDetachedValuesToOriginalOrInsertIfNew()
	{
		return (Task) this.zCopyDetachedValuesToOriginalOrInsertIfNew();
	}

	public Object readResolve() throws ObjectStreamException
	{
		if (this.persistenceState == DatedPersistenceState.PERSISTED)
		{
			TaskData data = (TaskData) this.currentData;
			Operation op = TaskFinder.processingDate().eq(this.processingDate);
			op = op.and(TaskFinder.taskId().eq(data.getTaskId()));
			return TaskFinder.findOne(op);
		}

		return this;
	}

	public boolean zHasSameNullPrimaryKeyAttributes(MithraTransactionalObject other)
	{
		return true;
	}

	public boolean isNameNull()
	{
		return this.zSynchronizedGetData().isNameNull();
	}

	public boolean isProcessingDateFromNull()
	{
		return this.zSynchronizedGetData().isProcessingDateFromNull();
	}

	public boolean isProcessingDateToNull()
	{
		return this.zSynchronizedGetData().isProcessingDateToNull();
	}

	public boolean isStatusNull()
	{
		return this.zSynchronizedGetData().isStatusNull();
	}

	public boolean isTaskIdNull()
	{
		return this.zSynchronizedGetData().isTaskIdNull();
	}

	public String getName()
	{
		return this.zSynchronizedGetData().getName();
	}

	public void setName(String newValue)
	{
		if (newValue != null) newValue = newValue.trim();
		if (newValue != null && newValue.length() > 64)
		{
			throw new MithraBusinessException("Attribute 'name' cannot exceed maximum length of 64: " + newValue);
		}

		zSetString(TaskFinder.name(), newValue, false );
	}

	public Timestamp getProcessingDateFrom()
	{
		return this.zSynchronizedGetData().getProcessingDateFrom();
	}

	public void setProcessingDateFrom(Timestamp newValue)
	{
		zSetTimestamp(TaskFinder.processingDateFrom(), newValue, false );
	}

	public Timestamp getProcessingDateTo()
	{
		return this.zSynchronizedGetData().getProcessingDateTo();
	}

	public void setProcessingDateTo(Timestamp newValue)
	{
		zSetTimestamp(TaskFinder.processingDateTo(), newValue, false );
	}

	public String getStatus()
	{
		return this.zSynchronizedGetData().getStatus();
	}

	public void setStatus(String newValue)
	{
		if (newValue != null) newValue = newValue.trim();
		if (newValue != null && newValue.length() > 32)
		{
			throw new MithraBusinessException("Attribute 'status' cannot exceed maximum length of 32: " + newValue);
		}

		zSetString(TaskFinder.status(), newValue, false );
	}

	public int getTaskId()
	{
		return this.zSynchronizedGetData().getTaskId();
	}

	public void setTaskId(int newValue)
	{
		zSetInteger(TaskFinder.taskId(), newValue, true ,false);
	}

	protected void issuePrimitiveNullSetters(DatedTransactionalBehavior behavior, MithraDataObject data, boolean mustCheckCurrent)
	{
	}

	public Timestamp getProcessingDate()
	{
		return this.processingDate;
	}

	public void zPersistDetachedRelationships(MithraDataObject _data)
	{
		TaskData _newData = (TaskData) _data;
	}

	public void zSetTxDetachedDeleted()
	{
		DatedTransactionalBehavior behavior = this.zGetTransactionalBehavior();
		if (behavior.isDetached() && behavior.isDeleted()) return;
		TaskData _newData = (TaskData) behavior.getCurrentDataForRead(this);
		this.zSetTxPersistenceState(DatedPersistenceState.DETACHED_DELETED);
	}

	public void zSetNonTxDetachedDeleted()
	{
		DatedTransactionalBehavior behavior = this.zGetTransactionalBehavior();
		TaskData _newData = (TaskData) behavior.getCurrentDataForRead(this);
		this.zSetNonTxPersistenceState(DatedPersistenceState.DETACHED_DELETED);
	}

	public Cache zGetCache()
	{
		return TaskFinder.getMithraObjectPortal().getCache();
	}

	private Logger getLogger()
	{
		return logger;
	}

	public MithraDataObject zAllocateData()
	{
		return new TaskData();
	}

	public MithraDataObject zRefreshWithLock(boolean lock)
	{
		TaskData data = (TaskData) TaskFinder.getMithraObjectPortal().refreshDatedObject(this, lock);
		if (data == null)
		{
			throw new MithraDeletedException("Task has been deleted.");
		}

		return data;
	}

	public void setFromTaskData( TaskData data )
	{
		this.zSetData(data);
	}

	protected void zSetFromTaskData( TaskData data )
	{
		this.zSetData(data);
		this.zSetNonTxPersistenceState(PERSISTED_STATE);
	}

	public MithraTransactionalDatabaseObject zGetDatabaseObject()
	{
		return (MithraTransactionalDatabaseObject) TaskFinder.getMithraObjectPortal().getDatabaseObject();
	}

	public MithraObjectPortal zGetPortal()
	{
		return TaskFinder.getMithraObjectPortal();
	}

	public Task getOriginalPersistentObject()
	{
		return this.zFindOriginal();
	}

	public void copyNonPrimaryKeyAttributesFrom(TaskAbstract from) throws MithraBusinessException
	{
		this.copyNonPrimaryKeyAttributesFrom((MithraTransactionalObject)from);
	}

	protected void copyNonPrimaryKeyAttributesFromImpl(MithraTransactionalObject f, MithraTransaction tx) throws MithraBusinessException
	{
		TaskAbstract from = (TaskAbstract) f;
		TaskData newData = from.zSynchronizedGetData();
		this.setName(newData.getName());
		this.setStatus(newData.getStatus());
	}

	protected void zCheckOptimisticLocking(MithraTransaction tx, MithraDataObject d, MithraDataObject nd)
	{
		TaskData newData = (TaskData) d;
		TaskData data = (TaskData) nd;
		if (TaskFinder.getMithraObjectPortal().getTxParticipationMode(tx).isOptimisticLocking()
		&& !tx.retryOnOptimisticLockFailure() && !newData.getProcessingDateFrom().equals(data.getProcessingDateFrom()))
		{
			throw new MithraOptimisticLockException("Optimistic lock failure. "+data.zGetPrintablePrimaryKey());
		}
	}

	protected boolean issueUpdates(DatedTransactionalBehavior behavior, MithraDataObject data, MithraDataObject newData)
	{
		boolean changed = false;
		changed |= zUpdateString(behavior, data, newData, TaskFinder.name(), false);
		changed |= zUpdateString(behavior, data, newData, TaskFinder.status(), false);
		changed |= zUpdateInteger(behavior, data, newData, TaskFinder.taskId(), false);
		return changed;
	}

	public void cascadeTerminate()
	{
		this.terminate();
	}

	public void cascadeTerminateUntil(Timestamp exclusiveUntil) throws MithraBusinessException
	{
		this.terminateUntil(exclusiveUntil);
	}

	public void zSerializePrimaryKey(ObjectOutput out) throws IOException
	{
		TaskData data = ((TaskData)this.zGetCurrentOrTransactionalData());
		data.zSerializePrimaryKey(out);
		MithraTimestamp.writeTimezoneInsensitiveTimestampWithInfinity(out, processingDate, kata.util.TimestampProvider.getInfinityDate());
	}

	public void zWriteDataClassName(ObjectOutput out) throws IOException
	{
	}

	public void zSerializeFullData(ObjectOutput out) throws IOException
	{
		TaskData data = ((TaskData)this.zGetCurrentDataWithCheck());
		data.zSerializeFullData(out);
		MithraTimestamp.writeTimezoneInsensitiveTimestampWithInfinity(out, processingDate, kata.util.TimestampProvider.getInfinityDate());
	}

	public void zSerializeFullTxData(ObjectOutput out) throws IOException
	{
		TaskData data = ((TaskData)this.zGetTxDataForRead());
		data.zSerializeFullData(out);
		MithraTimestamp.writeTimezoneInsensitiveTimestampWithInfinity(out, processingDate, kata.util.TimestampProvider.getInfinityDate());
	}

	public int generateAndSetTaskId()
	{
		int nextValue =(int) this.generateTaskId();
		this.setTaskId(nextValue);
		return nextValue;
	}

	public boolean zGetIsTaskIdSet()
	{
		TaskData data = this.zSynchronizedGetData();
		return data.zGetIsTaskIdSet();
	}

	protected int generateTaskId()
	{
		Object sourceAttribute = null;
		TaskFinder.getMithraObjectPortal().getCache();
		SimulatedSequencePrimaryKeyGenerator primaryKeyGenerator =
		MithraPrimaryKeyGenerator.getInstance().getSimulatedSequencePrimaryKeyGeneratorForNoSourceAttribute("Task", "kata.util.ObjectSequenceObjectFactory",sourceAttribute);
		return (int)primaryKeyGenerator.getNextId(sourceAttribute);
	}

	private void checkAndGeneratePrimaryKeys()
	{
		DatedTransactionalBehavior behavior = this.zGetTransactionalBehaviorForWrite();
		TaskData data = (TaskData) behavior.getCurrentDataForWrite(this);
		if (!data.zGetIsTaskIdSet())
		{
			int newValue = this.generateTaskId();
			data.setTaskId(newValue);
		}
	}

	protected void zSerializeAsOfAttributes(ObjectOutputStream out) throws IOException
	{
		MithraTimestamp.writeTimezoneInsensitiveTimestampWithInfinity(out, processingDate, kata.util.TimestampProvider.getInfinityDate());
	}

	protected void zDeserializeAsOfAttributes(ObjectInputStream in) throws IOException, ClassNotFoundException
	{
		this.processingDate = TimestampPool.getInstance().getOrAddToCache(MithraTimestamp.readTimezoneInsensitiveTimestampWithInfinity(in, kata.util.TimestampProvider.getInfinityDate()), TaskFinder.isFullCache());
	}

	public boolean zDataMatches(Object data, Timestamp[] asOfDates)
	{
		TaskData localData = (TaskData) data;
		MithraDataObject thisData = this.zGetCurrentOrTransactionalData();
		return thisData != null && localData.hasSamePrimaryKeyIgnoringAsOfAttributes(thisData)
		&& this.processingDate.equals(asOfDates[0])
		;
	}

	protected static void zConfigNonTx()
	{
		MEMORY_STATE = DatedPersistenceState.IN_MEMORY_NON_TRANSACTIONAL;
		PERSISTED_STATE = DatedPersistenceState.PERSISTED_NON_TRANSACTIONAL;
	}

	protected static void zConfigFullTx()
	{
		MEMORY_STATE = DatedPersistenceState.IN_MEMORY;
		PERSISTED_STATE = DatedPersistenceState.PERSISTED;
	}
}
