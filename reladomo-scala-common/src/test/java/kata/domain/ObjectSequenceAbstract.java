package kata.domain;

import com.gs.fw.common.mithra.MithraBusinessException;
import com.gs.fw.common.mithra.MithraDataObject;
import com.gs.fw.common.mithra.MithraNullPrimitiveException;
import com.gs.fw.common.mithra.MithraObjectPortal;
import com.gs.fw.common.mithra.behavior.TransactionalBehavior;
import com.gs.fw.common.mithra.behavior.state.PersistenceState;
import com.gs.fw.common.mithra.cache.Cache;
import com.gs.fw.common.mithra.finder.Operation;
import com.gs.fw.common.mithra.finder.RelatedFinder;
import com.gs.fw.common.mithra.util.StatisticCounter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;
import java.util.Map;

/**
* This file was automatically generated using Mithra 16.5.1. Please do not modify it.
* Add custom logic to its subclass instead.
*/
// Generated from templates/transactional/Abstract.jsp
public abstract class ObjectSequenceAbstract extends com.gs.fw.common.mithra.superclassimpl.MithraTransactionalObjectImpl
{
	private static byte MEMORY_STATE = PersistenceState.IN_MEMORY;
	private static byte PERSISTED_STATE = PersistenceState.PERSISTED;
	private static final Logger logger = LoggerFactory.getLogger(ObjectSequence.class.getName());
	public ObjectSequenceAbstract()
	{
		this.persistenceState = MEMORY_STATE;
	}

	public ObjectSequence getDetachedCopy() throws MithraBusinessException
	{
		return (ObjectSequence) super.getDetachedCopy();
	}

	public ObjectSequence getNonPersistentCopy() throws MithraBusinessException
	{
		ObjectSequence result = (ObjectSequence) super.getNonPersistentCopy();
		result.persistenceState = MEMORY_STATE;
		return result;
	}

	public ObjectSequence copyDetachedValuesToOriginalOrInsertIfNew()
	{
		return (ObjectSequence) this.zCopyDetachedValuesToOriginalOrInsertIfNew();
	}

	public ObjectSequence zFindOriginal()
	{
		ObjectSequenceData data = (ObjectSequenceData) this.currentData;
		Operation op;
		op = ObjectSequenceFinder.simulatedSequenceName().eq(data.getSimulatedSequenceName());
		return ObjectSequenceFinder.findOne(op);
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
		return new ObjectSequenceData();
	}

	protected void zSetFromObjectSequenceData( ObjectSequenceData data )
	{
		super.zSetData(data);
		this.persistenceState = PERSISTED_STATE;
	}

	public void setFromObjectSequenceData( ObjectSequenceData data )
	{
		super.zSetData(data);
	}

	public void zWriteDataClassName(ObjectOutput out) throws IOException
	{
	}

	public boolean isNextValueNull()
	{
		return ((ObjectSequenceData) this.zSynchronizedGetData()).isNextValueNull();
	}

	public long getNextValue()
	{
		ObjectSequenceData data = (ObjectSequenceData) this.zSynchronizedGetData();
		if (data.isNextValueNull()) MithraNullPrimitiveException.throwNew("nextValue", data);
		return data.getNextValue();
	}

	public void setNextValue(long newValue)
	{
		zSetLong(ObjectSequenceFinder.nextValue(), newValue, false, false ,true);
	}

	public boolean isSimulatedSequenceNameNull()
	{
		return ((ObjectSequenceData) this.zSynchronizedGetData()).isSimulatedSequenceNameNull();
	}

	public String getSimulatedSequenceName()
	{
		ObjectSequenceData data = (ObjectSequenceData) this.zSynchronizedGetData();
		return data.getSimulatedSequenceName();
	}

	public void setSimulatedSequenceName(String newValue)
	{
		if (newValue != null) newValue = newValue.trim();
		if (newValue != null && newValue.length() > 64)
		throw new MithraBusinessException("Attribute 'simulatedSequenceName' cannot exceed maximum length of 64: " + newValue);
		zSetString(ObjectSequenceFinder.simulatedSequenceName(), newValue, true, false );
	}

	protected void issuePrimitiveNullSetters(TransactionalBehavior behavior, MithraDataObject data)
	{
		zNullify(behavior, data, ObjectSequenceFinder.nextValue(), false);
	}

	public void setNextValueNull()
	{
		zNullify(ObjectSequenceFinder.nextValue(), false);
	}

	public void zPersistDetachedRelationships(MithraDataObject _data)
	{
		ObjectSequenceData _newData = (ObjectSequenceData) _data;
	}

	public void zSetTxDetachedDeleted()
	{
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForWriteWithWaitIfNecessary();
		if (_behavior.isDetached() && _behavior.isDeleted()) return;
		ObjectSequenceData _newData = (ObjectSequenceData) _behavior.getCurrentDataForRead(this);
		this.zSetTxPersistenceState(PersistenceState.DETACHED_DELETED);
	}

	public void zSetNonTxDetachedDeleted()
	{
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForWriteWithWaitIfNecessary();
		ObjectSequenceData _newData = (ObjectSequenceData) _behavior.getCurrentDataForRead(this);
		this.zSetNonTxPersistenceState(PersistenceState.DETACHED_DELETED);
	}

	protected void cascadeInsertImpl() throws MithraBusinessException
	{
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForWriteWithWaitIfNecessary();
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
	public ObjectSequence zCascadeCopyThenInsert() throws MithraBusinessException
	{
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForWriteWithWaitIfNecessary();
		ObjectSequence original = (ObjectSequence) _behavior.copyThenInsert(this);
		return original;
	}

	protected void cascadeDeleteImpl() throws MithraBusinessException
	{
		this.delete();
	}

	public Cache zGetCache()
	{
		return ObjectSequenceFinder.getMithraObjectPortal().getCache();
	}

	public MithraObjectPortal zGetPortal()
	{
		return ObjectSequenceFinder.getMithraObjectPortal();
	}

	public ObjectSequence getOriginalPersistentObject()
	{
		return this.zFindOriginal();
	}

	protected boolean issueUpdatesForNonPrimaryKeys(TransactionalBehavior behavior, MithraDataObject data, MithraDataObject newData)
	{
		boolean changed = false;
		changed |= zUpdateLong(behavior, data, newData, ObjectSequenceFinder.nextValue(), false);
		return changed;
	}

	protected boolean issueUpdatesForPrimaryKeys(TransactionalBehavior behavior, MithraDataObject data, MithraDataObject newData)
	{
		boolean changed = false;
		changed |= zUpdateString(behavior, data, newData, ObjectSequenceFinder.simulatedSequenceName(), false);
		return changed;
	}

	public Object readResolve() throws ObjectStreamException
	{
		ObjectSequenceAbstract result = (ObjectSequenceAbstract) super.readResolve();
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
