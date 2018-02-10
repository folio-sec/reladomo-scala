package kata.domain;
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
public class AllTypesListAbstract extends DelegatingList<AllTypes> implements MithraTransactionalList<AllTypes>
{
	public AllTypesListAbstract()
	{
		super();
		this.setDelegated(AbstractTransactionalNonOperationBasedList.DEFAULT);
		AbstractTransactionalNonOperationBasedList.DEFAULT.init(this);
	}

	public AllTypesListAbstract(int initialSize)
	{
		super();
		this.setDelegated(AbstractTransactionalNonOperationBasedList.DEFAULT);
		AbstractTransactionalNonOperationBasedList.DEFAULT.init(this, initialSize);
	}

	public AllTypesListAbstract(Collection c)
	{
		super();
		this.setDelegated(AbstractTransactionalNonOperationBasedList.DEFAULT);
		AbstractTransactionalNonOperationBasedList.DEFAULT.init(this, c);
	}

	public AllTypesListAbstract(com.gs.fw.finder.Operation operation)
	{
		super(operation);
		this.setDelegated(AbstractTransactionalOperationBasedList.DEFAULT);
	}

	public AllTypes[] elements()
	{
		AllTypes[] result = new AllTypes[size()];
		this.getDelegated().toArray(this, result);
		return result;
	}

	public AllTypesList intersection(AllTypesList another)
	{
		return (AllTypesList)super.intersection(another);
	}

	public AllTypes getAllTypesAt(int index)
	{
		return (AllTypes)this.get(index);
	}

	public MithraObjectPortal getMithraObjectPortal()
	{
		return AllTypesFinder.getMithraObjectPortal();
	}

	public AllTypesList getNonPersistentCopy()
	{
		AllTypesList result = new AllTypesList();
		zCopyNonPersistentInto(result);
		return result;
	}

	public AllTypesList asAdhoc()
	{
		return (AllTypesList) super.asAdhoc();
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
	public MutableList<AllTypes> asGscList()
	{
		return ListAdapter.adapt(this);
	}

	public AllTypesList merge(MithraTransactionalList<AllTypes> incoming, TopLevelMergeOptions<AllTypes> mergeOptions)
	{
		return (AllTypesList) super.merge(incoming, mergeOptions);
	}

	public AllTypesList getDetachedCopy()
	{
		AllTypesList result = new AllTypesList();
		zDetachInto(result);
		return result;
	}

	public void zMakeDetached(Operation op, Object previousDetachedList)
	{
		super.zMakeDetached(op, previousDetachedList);
	}

	public void setBooleanValue(boolean newValue)
	{
		zSetBoolean(AllTypesFinder.booleanValue(), newValue);
	}

	public void setByteArrayValue(byte[] newValue)
	{
		zSetByteArray(AllTypesFinder.byteArrayValue(), newValue);
	}

	public void setByteValue(byte newValue)
	{
		zSetByte(AllTypesFinder.byteValue(), newValue);
	}

	public void setCharValue(char newValue)
	{
		zSetChar(AllTypesFinder.charValue(), newValue);
	}

	public void setDateValue(Date newValue)
	{
		zSetDate(AllTypesFinder.dateValue(), newValue);
	}

	public void setDoubleValue(double newValue)
	{
		zSetDouble(AllTypesFinder.doubleValue(), newValue);
	}

	public void setFloatValue(float newValue)
	{
		zSetFloat(AllTypesFinder.floatValue(), newValue);
	}

	public void setId(int newValue)
	{
		zSetInteger(AllTypesFinder.id(), newValue);
	}

	public void setIntValue(int newValue)
	{
		zSetInteger(AllTypesFinder.intValue(), newValue);
	}

	public void setLongValue(long newValue)
	{
		zSetLong(AllTypesFinder.longValue(), newValue);
	}

	public void setNullableByteArrayValue(byte[] newValue)
	{
		zSetByteArray(AllTypesFinder.nullableByteArrayValue(), newValue);
	}

	public void setNullableByteValue(byte newValue)
	{
		zSetByte(AllTypesFinder.nullableByteValue(), newValue);
	}

	public void setNullableCharValue(char newValue)
	{
		zSetChar(AllTypesFinder.nullableCharValue(), newValue);
	}

	public void setNullableDateValue(Date newValue)
	{
		zSetDate(AllTypesFinder.nullableDateValue(), newValue);
	}

	public void setNullableDoubleValue(double newValue)
	{
		zSetDouble(AllTypesFinder.nullableDoubleValue(), newValue);
	}

	public void setNullableFloatValue(float newValue)
	{
		zSetFloat(AllTypesFinder.nullableFloatValue(), newValue);
	}

	public void setNullableIntValue(int newValue)
	{
		zSetInteger(AllTypesFinder.nullableIntValue(), newValue);
	}

	public void setNullableLongValue(long newValue)
	{
		zSetLong(AllTypesFinder.nullableLongValue(), newValue);
	}

	public void setNullableShortValue(short newValue)
	{
		zSetShort(AllTypesFinder.nullableShortValue(), newValue);
	}

	public void setNullableStringValue(String newValue)
	{
		zSetString(AllTypesFinder.nullableStringValue(), newValue);
	}

	public void setNullableTimestampValue(Timestamp newValue)
	{
		zSetTimestamp(AllTypesFinder.nullableTimestampValue(), newValue);
	}

	public void setShortValue(short newValue)
	{
		zSetShort(AllTypesFinder.shortValue(), newValue);
	}

	public void setStringValue(String newValue)
	{
		zSetString(AllTypesFinder.stringValue(), newValue);
	}

	public void setTimestampValue(Timestamp newValue)
	{
		zSetTimestamp(AllTypesFinder.timestampValue(), newValue);
	}

	public void setNullableByteValueNull()
	{
		zSetAttributeNull(AllTypesFinder.nullableByteValue());
	}

	public void setNullableShortValueNull()
	{
		zSetAttributeNull(AllTypesFinder.nullableShortValue());
	}

	public void setNullableCharValueNull()
	{
		zSetAttributeNull(AllTypesFinder.nullableCharValue());
	}

	public void setNullableIntValueNull()
	{
		zSetAttributeNull(AllTypesFinder.nullableIntValue());
	}

	public void setNullableLongValueNull()
	{
		zSetAttributeNull(AllTypesFinder.nullableLongValue());
	}

	public void setNullableFloatValueNull()
	{
		zSetAttributeNull(AllTypesFinder.nullableFloatValue());
	}

	public void setNullableDoubleValueNull()
	{
		zSetAttributeNull(AllTypesFinder.nullableDoubleValue());
	}
}
