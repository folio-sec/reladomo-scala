package kata.domain;
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
public abstract class AllTypesAbstract extends com.gs.fw.common.mithra.superclassimpl.MithraTransactionalObjectImpl
{
	private static byte MEMORY_STATE = PersistenceState.IN_MEMORY;
	private static byte PERSISTED_STATE = PersistenceState.PERSISTED;
	private static final Logger logger = LoggerFactory.getLogger(AllTypes.class.getName());
	public AllTypesAbstract()
	{
		this.persistenceState = MEMORY_STATE;
	}

	public AllTypes getDetachedCopy() throws MithraBusinessException
	{
		return (AllTypes) super.getDetachedCopy();
	}

	public AllTypes getNonPersistentCopy() throws MithraBusinessException
	{
		AllTypes result = (AllTypes) super.getNonPersistentCopy();
		result.persistenceState = MEMORY_STATE;
		return result;
	}

	public AllTypes copyDetachedValuesToOriginalOrInsertIfNew()
	{
		return (AllTypes) this.zCopyDetachedValuesToOriginalOrInsertIfNew();
	}

	public AllTypes zFindOriginal()
	{
		AllTypesData data = (AllTypesData) this.currentData;
		Operation op;
		op = AllTypesFinder.id().eq(data.getId());
		return AllTypesFinder.findOne(op);
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
		return new AllTypesData();
	}

	protected void zSetFromAllTypesData( AllTypesData data )
	{
		super.zSetData(data);
		this.persistenceState = PERSISTED_STATE;
	}

	public void setFromAllTypesData( AllTypesData data )
	{
		super.zSetData(data);
	}

	public void zWriteDataClassName(ObjectOutput out) throws IOException
	{
	}

	public boolean isBooleanValueNull()
	{
		return ((AllTypesData) this.zSynchronizedGetData()).isBooleanValueNull();
	}

	public boolean isBooleanValue()
	{
		AllTypesData data = (AllTypesData) this.zSynchronizedGetData();
		return data.isBooleanValue();
	}

	public void setBooleanValue(boolean newValue)
	{
		zSetBoolean(AllTypesFinder.booleanValue(), newValue, false, false ,false);
	}

	public boolean isByteArrayValueNull()
	{
		return ((AllTypesData) this.zSynchronizedGetData()).isByteArrayValueNull();
	}

	public byte[] getByteArrayValue()
	{
		AllTypesData data = (AllTypesData) this.zSynchronizedGetData();
		return data.getByteArrayValue();
	}

	public void setByteArrayValue(byte[] newValue)
	{
		zSetByteArray(AllTypesFinder.byteArrayValue(), newValue, false, false );
	}

	public boolean isByteValueNull()
	{
		return ((AllTypesData) this.zSynchronizedGetData()).isByteValueNull();
	}

	public byte getByteValue()
	{
		AllTypesData data = (AllTypesData) this.zSynchronizedGetData();
		return data.getByteValue();
	}

	public void setByteValue(byte newValue)
	{
		zSetByte(AllTypesFinder.byteValue(), newValue, false, false ,false);
	}

	public boolean isCharValueNull()
	{
		return ((AllTypesData) this.zSynchronizedGetData()).isCharValueNull();
	}

	public char getCharValue()
	{
		AllTypesData data = (AllTypesData) this.zSynchronizedGetData();
		return data.getCharValue();
	}

	public void setCharValue(char newValue)
	{
		zSetChar(AllTypesFinder.charValue(), newValue, false, false ,false);
	}

	public boolean isDateValueNull()
	{
		return ((AllTypesData) this.zSynchronizedGetData()).isDateValueNull();
	}

	public Date getDateValue()
	{
		AllTypesData data = (AllTypesData) this.zSynchronizedGetData();
		return data.getDateValue();
	}

	public void setDateValue(Date newValue)
	{
		zSetDate(AllTypesFinder.dateValue(), newValue, false, false );
	}

	public boolean isDoubleValueNull()
	{
		return ((AllTypesData) this.zSynchronizedGetData()).isDoubleValueNull();
	}

	public double getDoubleValue()
	{
		AllTypesData data = (AllTypesData) this.zSynchronizedGetData();
		return data.getDoubleValue();
	}

	public void setDoubleValue(double newValue)
	{
		zSetDouble(AllTypesFinder.doubleValue(), newValue, false, false ,false);
	}

	public boolean isFloatValueNull()
	{
		return ((AllTypesData) this.zSynchronizedGetData()).isFloatValueNull();
	}

	public float getFloatValue()
	{
		AllTypesData data = (AllTypesData) this.zSynchronizedGetData();
		return data.getFloatValue();
	}

	public void setFloatValue(float newValue)
	{
		zSetFloat(AllTypesFinder.floatValue(), newValue, false, false ,false);
	}

	public boolean isIdNull()
	{
		return ((AllTypesData) this.zSynchronizedGetData()).isIdNull();
	}

	public int getId()
	{
		AllTypesData data = (AllTypesData) this.zSynchronizedGetData();
		return data.getId();
	}

	public void setId(int newValue)
	{
		zSetInteger(AllTypesFinder.id(), newValue, true, false ,false);
	}

	public boolean isIntValueNull()
	{
		return ((AllTypesData) this.zSynchronizedGetData()).isIntValueNull();
	}

	public int getIntValue()
	{
		AllTypesData data = (AllTypesData) this.zSynchronizedGetData();
		return data.getIntValue();
	}

	public void setIntValue(int newValue)
	{
		zSetInteger(AllTypesFinder.intValue(), newValue, false, false ,false);
	}

	public boolean isLongValueNull()
	{
		return ((AllTypesData) this.zSynchronizedGetData()).isLongValueNull();
	}

	public long getLongValue()
	{
		AllTypesData data = (AllTypesData) this.zSynchronizedGetData();
		return data.getLongValue();
	}

	public void setLongValue(long newValue)
	{
		zSetLong(AllTypesFinder.longValue(), newValue, false, false ,false);
	}

	public boolean isNullableByteArrayValueNull()
	{
		return ((AllTypesData) this.zSynchronizedGetData()).isNullableByteArrayValueNull();
	}

	public byte[] getNullableByteArrayValue()
	{
		AllTypesData data = (AllTypesData) this.zSynchronizedGetData();
		return data.getNullableByteArrayValue();
	}

	public void setNullableByteArrayValue(byte[] newValue)
	{
		zSetByteArray(AllTypesFinder.nullableByteArrayValue(), newValue, false, false );
	}

	public boolean isNullableByteValueNull()
	{
		return ((AllTypesData) this.zSynchronizedGetData()).isNullableByteValueNull();
	}

	public byte getNullableByteValue()
	{
		AllTypesData data = (AllTypesData) this.zSynchronizedGetData();
		if (data.isNullableByteValueNull()) MithraNullPrimitiveException.throwNew("nullableByteValue", data);
		return data.getNullableByteValue();
	}

	public void setNullableByteValue(byte newValue)
	{
		zSetByte(AllTypesFinder.nullableByteValue(), newValue, false, false ,true);
	}

	public boolean isNullableCharValueNull()
	{
		return ((AllTypesData) this.zSynchronizedGetData()).isNullableCharValueNull();
	}

	public char getNullableCharValue()
	{
		AllTypesData data = (AllTypesData) this.zSynchronizedGetData();
		if (data.isNullableCharValueNull()) MithraNullPrimitiveException.throwNew("nullableCharValue", data);
		return data.getNullableCharValue();
	}

	public void setNullableCharValue(char newValue)
	{
		zSetChar(AllTypesFinder.nullableCharValue(), newValue, false, false ,true);
	}

	public boolean isNullableDateValueNull()
	{
		return ((AllTypesData) this.zSynchronizedGetData()).isNullableDateValueNull();
	}

	public Date getNullableDateValue()
	{
		AllTypesData data = (AllTypesData) this.zSynchronizedGetData();
		return data.getNullableDateValue();
	}

	public void setNullableDateValue(Date newValue)
	{
		zSetDate(AllTypesFinder.nullableDateValue(), newValue, false, false );
	}

	public boolean isNullableDoubleValueNull()
	{
		return ((AllTypesData) this.zSynchronizedGetData()).isNullableDoubleValueNull();
	}

	public double getNullableDoubleValue()
	{
		AllTypesData data = (AllTypesData) this.zSynchronizedGetData();
		if (data.isNullableDoubleValueNull()) MithraNullPrimitiveException.throwNew("nullableDoubleValue", data);
		return data.getNullableDoubleValue();
	}

	public void setNullableDoubleValue(double newValue)
	{
		zSetDouble(AllTypesFinder.nullableDoubleValue(), newValue, false, false ,true);
	}

	public boolean isNullableFloatValueNull()
	{
		return ((AllTypesData) this.zSynchronizedGetData()).isNullableFloatValueNull();
	}

	public float getNullableFloatValue()
	{
		AllTypesData data = (AllTypesData) this.zSynchronizedGetData();
		if (data.isNullableFloatValueNull()) MithraNullPrimitiveException.throwNew("nullableFloatValue", data);
		return data.getNullableFloatValue();
	}

	public void setNullableFloatValue(float newValue)
	{
		zSetFloat(AllTypesFinder.nullableFloatValue(), newValue, false, false ,true);
	}

	public boolean isNullableIntValueNull()
	{
		return ((AllTypesData) this.zSynchronizedGetData()).isNullableIntValueNull();
	}

	public int getNullableIntValue()
	{
		AllTypesData data = (AllTypesData) this.zSynchronizedGetData();
		if (data.isNullableIntValueNull()) MithraNullPrimitiveException.throwNew("nullableIntValue", data);
		return data.getNullableIntValue();
	}

	public void setNullableIntValue(int newValue)
	{
		zSetInteger(AllTypesFinder.nullableIntValue(), newValue, false, false ,true);
	}

	public boolean isNullableLongValueNull()
	{
		return ((AllTypesData) this.zSynchronizedGetData()).isNullableLongValueNull();
	}

	public long getNullableLongValue()
	{
		AllTypesData data = (AllTypesData) this.zSynchronizedGetData();
		if (data.isNullableLongValueNull()) MithraNullPrimitiveException.throwNew("nullableLongValue", data);
		return data.getNullableLongValue();
	}

	public void setNullableLongValue(long newValue)
	{
		zSetLong(AllTypesFinder.nullableLongValue(), newValue, false, false ,true);
	}

	public boolean isNullableShortValueNull()
	{
		return ((AllTypesData) this.zSynchronizedGetData()).isNullableShortValueNull();
	}

	public short getNullableShortValue()
	{
		AllTypesData data = (AllTypesData) this.zSynchronizedGetData();
		if (data.isNullableShortValueNull()) MithraNullPrimitiveException.throwNew("nullableShortValue", data);
		return data.getNullableShortValue();
	}

	public void setNullableShortValue(short newValue)
	{
		zSetShort(AllTypesFinder.nullableShortValue(), newValue, false, false ,true);
	}

	public boolean isNullableStringValueNull()
	{
		return ((AllTypesData) this.zSynchronizedGetData()).isNullableStringValueNull();
	}

	public String getNullableStringValue()
	{
		AllTypesData data = (AllTypesData) this.zSynchronizedGetData();
		return data.getNullableStringValue();
	}

	public void setNullableStringValue(String newValue)
	{
		if (newValue != null) newValue = newValue.trim();
		if (newValue != null && newValue.length() > 50)
		newValue = newValue.substring(0, 50 ).trim();
		zSetString(AllTypesFinder.nullableStringValue(), newValue, false, false );
	}

	public boolean isNullableTimestampValueNull()
	{
		return ((AllTypesData) this.zSynchronizedGetData()).isNullableTimestampValueNull();
	}

	public Timestamp getNullableTimestampValue()
	{
		AllTypesData data = (AllTypesData) this.zSynchronizedGetData();
		return data.getNullableTimestampValue();
	}

	public void setNullableTimestampValue(Timestamp newValue)
	{
		zSetTimestamp(AllTypesFinder.nullableTimestampValue(), newValue, false, false );
	}

	public boolean isShortValueNull()
	{
		return ((AllTypesData) this.zSynchronizedGetData()).isShortValueNull();
	}

	public short getShortValue()
	{
		AllTypesData data = (AllTypesData) this.zSynchronizedGetData();
		return data.getShortValue();
	}

	public void setShortValue(short newValue)
	{
		zSetShort(AllTypesFinder.shortValue(), newValue, false, false ,false);
	}

	public boolean isStringValueNull()
	{
		return ((AllTypesData) this.zSynchronizedGetData()).isStringValueNull();
	}

	public String getStringValue()
	{
		AllTypesData data = (AllTypesData) this.zSynchronizedGetData();
		return data.getStringValue();
	}

	public void setStringValue(String newValue)
	{
		if (newValue != null) newValue = newValue.trim();
		if (newValue != null && newValue.length() > 50)
		newValue = newValue.substring(0, 50 ).trim();
		zSetString(AllTypesFinder.stringValue(), newValue, false, false );
	}

	public boolean isTimestampValueNull()
	{
		return ((AllTypesData) this.zSynchronizedGetData()).isTimestampValueNull();
	}

	public Timestamp getTimestampValue()
	{
		AllTypesData data = (AllTypesData) this.zSynchronizedGetData();
		return data.getTimestampValue();
	}

	public void setTimestampValue(Timestamp newValue)
	{
		zSetTimestamp(AllTypesFinder.timestampValue(), newValue, false, false );
	}

	protected void issuePrimitiveNullSetters(TransactionalBehavior behavior, MithraDataObject data)
	{
		zNullify(behavior, data, AllTypesFinder.nullableByteValue(), false);
		zNullify(behavior, data, AllTypesFinder.nullableShortValue(), false);
		zNullify(behavior, data, AllTypesFinder.nullableCharValue(), false);
		zNullify(behavior, data, AllTypesFinder.nullableIntValue(), false);
		zNullify(behavior, data, AllTypesFinder.nullableLongValue(), false);
		zNullify(behavior, data, AllTypesFinder.nullableFloatValue(), false);
		zNullify(behavior, data, AllTypesFinder.nullableDoubleValue(), false);
	}

	public void setNullableByteValueNull()
	{
		zNullify(AllTypesFinder.nullableByteValue(), false);
	}

	public void setNullableShortValueNull()
	{
		zNullify(AllTypesFinder.nullableShortValue(), false);
	}

	public void setNullableCharValueNull()
	{
		zNullify(AllTypesFinder.nullableCharValue(), false);
	}

	public void setNullableIntValueNull()
	{
		zNullify(AllTypesFinder.nullableIntValue(), false);
	}

	public void setNullableLongValueNull()
	{
		zNullify(AllTypesFinder.nullableLongValue(), false);
	}

	public void setNullableFloatValueNull()
	{
		zNullify(AllTypesFinder.nullableFloatValue(), false);
	}

	public void setNullableDoubleValueNull()
	{
		zNullify(AllTypesFinder.nullableDoubleValue(), false);
	}

	public void zPersistDetachedRelationships(MithraDataObject _data)
	{
		AllTypesData _newData = (AllTypesData) _data;
	}

	public void zSetTxDetachedDeleted()
	{
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForWriteWithWaitIfNecessary();
		if (_behavior.isDetached() && _behavior.isDeleted()) return;
		AllTypesData _newData = (AllTypesData) _behavior.getCurrentDataForRead(this);
		this.zSetTxPersistenceState(PersistenceState.DETACHED_DELETED);
	}

	public void zSetNonTxDetachedDeleted()
	{
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForWriteWithWaitIfNecessary();
		AllTypesData _newData = (AllTypesData) _behavior.getCurrentDataForRead(this);
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
	public AllTypes zCascadeCopyThenInsert() throws MithraBusinessException
	{
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForWriteWithWaitIfNecessary();
		AllTypes original = (AllTypes) _behavior.copyThenInsert(this);
		return original;
	}

	protected void cascadeDeleteImpl() throws MithraBusinessException
	{
		this.delete();
	}

	public Cache zGetCache()
	{
		return AllTypesFinder.getMithraObjectPortal().getCache();
	}

	public MithraObjectPortal zGetPortal()
	{
		return AllTypesFinder.getMithraObjectPortal();
	}

	public AllTypes getOriginalPersistentObject()
	{
		return this.zFindOriginal();
	}

	protected boolean issueUpdatesForNonPrimaryKeys(TransactionalBehavior behavior, MithraDataObject data, MithraDataObject newData)
	{
		boolean changed = false;
		changed |= zUpdateBoolean(behavior, data, newData, AllTypesFinder.booleanValue(), false);
		changed |= zUpdateByteArray(behavior, data, newData, AllTypesFinder.byteArrayValue(), false);
		changed |= zUpdateByte(behavior, data, newData, AllTypesFinder.byteValue(), false);
		changed |= zUpdateChar(behavior, data, newData, AllTypesFinder.charValue(), false);
		changed |= zUpdateDate(behavior, data, newData, AllTypesFinder.dateValue(), false);
		changed |= zUpdateDouble(behavior, data, newData, AllTypesFinder.doubleValue(), false);
		changed |= zUpdateFloat(behavior, data, newData, AllTypesFinder.floatValue(), false);
		changed |= zUpdateInteger(behavior, data, newData, AllTypesFinder.intValue(), false);
		changed |= zUpdateLong(behavior, data, newData, AllTypesFinder.longValue(), false);
		changed |= zUpdateByteArray(behavior, data, newData, AllTypesFinder.nullableByteArrayValue(), false);
		changed |= zUpdateByte(behavior, data, newData, AllTypesFinder.nullableByteValue(), false);
		changed |= zUpdateChar(behavior, data, newData, AllTypesFinder.nullableCharValue(), false);
		changed |= zUpdateDate(behavior, data, newData, AllTypesFinder.nullableDateValue(), false);
		changed |= zUpdateDouble(behavior, data, newData, AllTypesFinder.nullableDoubleValue(), false);
		changed |= zUpdateFloat(behavior, data, newData, AllTypesFinder.nullableFloatValue(), false);
		changed |= zUpdateInteger(behavior, data, newData, AllTypesFinder.nullableIntValue(), false);
		changed |= zUpdateLong(behavior, data, newData, AllTypesFinder.nullableLongValue(), false);
		changed |= zUpdateShort(behavior, data, newData, AllTypesFinder.nullableShortValue(), false);
		changed |= zUpdateString(behavior, data, newData, AllTypesFinder.nullableStringValue(), false);
		changed |= zUpdateTimestamp(behavior, data, newData, AllTypesFinder.nullableTimestampValue(), false);
		changed |= zUpdateShort(behavior, data, newData, AllTypesFinder.shortValue(), false);
		changed |= zUpdateString(behavior, data, newData, AllTypesFinder.stringValue(), false);
		changed |= zUpdateTimestamp(behavior, data, newData, AllTypesFinder.timestampValue(), false);
		return changed;
	}

	protected boolean issueUpdatesForPrimaryKeys(TransactionalBehavior behavior, MithraDataObject data, MithraDataObject newData)
	{
		boolean changed = false;
		changed |= zUpdateInteger(behavior, data, newData, AllTypesFinder.id(), false);
		return changed;
	}

	public Object readResolve() throws ObjectStreamException
	{
		AllTypesAbstract result = (AllTypesAbstract) super.readResolve();
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
