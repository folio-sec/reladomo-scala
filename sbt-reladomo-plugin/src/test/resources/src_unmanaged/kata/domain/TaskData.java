package kata.domain;
import java.util.*;
import java.sql.Timestamp;
import java.sql.Date;
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
import com.gs.fw.common.mithra.finder.PrintablePreparedStatement;
import com.gs.fw.common.mithra.finder.RelatedFinder;
import com.gs.fw.common.mithra.cache.offheap.MithraOffHeapDataObject;
import com.gs.fw.common.mithra.cache.offheap.OffHeapDataStorage;
/**
* This file was automatically generated using Mithra 16.6.1. Please do not modify it.
* Add custom logic to its subclass instead.
*/
public class TaskData
implements MithraDataObject
{
	private byte _dataVersion;
	private String name;
	private Timestamp processingDateFrom;
	private Timestamp processingDateTo;
	private String status;
	private int taskId;
	public boolean isNameNull()
	{
		return this.getName() == null;
	}

	public boolean isProcessingDateFromNull()
	{
		return this.getProcessingDateFrom() == null;
	}

	public boolean isProcessingDateToNull()
	{
		return this.getProcessingDateTo() == null;
	}

	public boolean isStatusNull()
	{
		return this.getStatus() == null;
	}

	public boolean isTaskIdNull()
	{
		return false;
	}

	public void zSerializeFullData(ObjectOutput out) throws IOException
	{
		zWriteNullBits(out);
		out.writeObject(this.name);
		MithraTimestamp.writeTimezoneInsensitiveTimestamp(out, this.processingDateFrom);
		MithraTimestamp.writeTimezoneInsensitiveTimestampWithInfinity(out, this.processingDateTo, TaskFinder.processingDate().getInfinityDate());
		out.writeObject(this.status);
		out.writeInt(this.taskId);
		out.writeBoolean(_isTaskIdSet);
	}

	private void zWriteNullBits(ObjectOutput out) throws IOException
	{
	}

	public String getName()
	{
		return this.name;
	}

	public int zGetNameAsInt()
	{
		return StringPool.getInstance().getOffHeapAddressWithoutAdding(name);
	}

	public void setName(String value)
	{
		this.name = StringPool.getInstance().getOrAddToCache(value, TaskFinder.isFullCache());
	}

	public void setNameNull()
	{
		this.setName(null);
	}

	public Timestamp getProcessingDateFrom()
	{
		return this.processingDateFrom;
	}

	public long zGetProcessingDateFromAsLong()
	{
		if (processingDateFrom == null) return TimestampPool.OFF_HEAP_NULL;
		return processingDateFrom.getTime();
	}

	public void setProcessingDateFrom(Timestamp value)
	{
		this.processingDateFrom = TimestampPool.getInstance().getOrAddToCache(value, TaskFinder.isFullCache(), TaskFinder.isOffHeap());
	}

	public void setProcessingDateFromNull()
	{
		this.setProcessingDateFrom(null);
	}

	public Timestamp getProcessingDateTo()
	{
		return this.processingDateTo;
	}

	public long zGetProcessingDateToAsLong()
	{
		if (processingDateTo == null) return TimestampPool.OFF_HEAP_NULL;
		return processingDateTo.getTime();
	}

	public void setProcessingDateTo(Timestamp value)
	{
		if (!value.equals(this.processingDateTo))
		{
			zIncrementDataVersion();
		}

		this.processingDateTo = TimestampPool.getInstance().getOrAddToCache(value, TaskFinder.isFullCache(), TaskFinder.isOffHeap());
	}

	public void setProcessingDateToNull()
	{
		throw new RuntimeException("should never be called");
	}

	public String getStatus()
	{
		return this.status;
	}

	public int zGetStatusAsInt()
	{
		return StringPool.getInstance().getOffHeapAddressWithoutAdding(status);
	}

	public void setStatus(String value)
	{
		this.status = StringPool.getInstance().getOrAddToCache(value, TaskFinder.isFullCache());
	}

	public void setStatusNull()
	{
		this.setStatus(null);
	}

	public int getTaskId()
	{
		return this.taskId;
	}

	public void setTaskId(int value)
	{
		this.taskId = value;
		_isTaskIdSet = true;
	}

	public void setTaskIdNull()
	{
		throw new RuntimeException("should never be called");
	}

	public boolean _isTaskIdSet;
	public boolean zGetIsTaskIdSet()
	{
		return _isTaskIdSet;
	}

	public byte zGetDataVersion() 
	{
		return _dataVersion; 
	}

	public void zSetDataVersion(byte version) 
	{
		this._dataVersion = version; 
	}

	public void zIncrementDataVersion()
	{
		_dataVersion++;
		if (_dataVersion > 120) _dataVersion = (byte) 0;
	}

	protected void copyInto(TaskData copy, boolean withRelationships)
	{
		copy.name = this.name;
		copy.processingDateFrom = this.processingDateFrom;
		copy.processingDateTo = this.processingDateTo;
		copy.status = this.status;
		copy.taskId = this.taskId;
		copy._isTaskIdSet = this._isTaskIdSet;
		if (withRelationships)
		{
		}
	}

	public void zDeserializeFullData(ObjectInput in) throws IOException, ClassNotFoundException
	{
		this.name = StringPool.getInstance().getOrAddToCache((String)in.readObject(), TaskFinder.isFullCache());
		this.processingDateFrom = TimestampPool.getInstance().getOrAddToCache(MithraTimestamp.readTimezoneInsensitiveTimestamp(in), TaskFinder.isFullCache(), TaskFinder.isOffHeap());
		this.processingDateTo = TimestampPool.getInstance().getOrAddToCache(MithraTimestamp.readTimezoneInsensitiveTimestampWithInfinity(in, TaskFinder.processingDate().getInfinityDate()), TaskFinder.isFullCache(), TaskFinder.isOffHeap());
		this.status = StringPool.getInstance().getOrAddToCache((String)in.readObject(), TaskFinder.isFullCache());
		this.taskId = in.readInt();
		_isTaskIdSet = in.readBoolean();
	}

	public boolean hasSamePrimaryKeyIgnoringAsOfAttributes(MithraDataObject other)
	{
		if (this == other) return true;
		final TaskData otherData = (TaskData) other;
		if (getTaskId() != otherData.getTaskId())
		{
			return false;
		}

		return true;
	}

	public void zSerializePrimaryKey(ObjectOutput out) throws IOException
	{
		MithraTimestamp.writeTimezoneInsensitiveTimestamp(out, this.processingDateFrom);
		MithraTimestamp.writeTimezoneInsensitiveTimestampWithInfinity(out, this.processingDateTo, TaskFinder.processingDate().getInfinityDate());
		out.writeInt(this.taskId);
	}

	public void zDeserializePrimaryKey(ObjectInput in) throws IOException, ClassNotFoundException
	{
		this.processingDateFrom = TimestampPool.getInstance().getOrAddToCache(MithraTimestamp.readTimezoneInsensitiveTimestamp(in), TaskFinder.isFullCache(), TaskFinder.isOffHeap());
		this.processingDateTo = TimestampPool.getInstance().getOrAddToCache(MithraTimestamp.readTimezoneInsensitiveTimestampWithInfinity(in, TaskFinder.processingDate().getInfinityDate()), TaskFinder.isFullCache(), TaskFinder.isOffHeap());
		this.taskId = in.readInt();
	}

	public void clearRelationships()
	{
		clearAllDirectRefs();
	}

	public void clearAllDirectRefs()
	{
	}

	public void zSerializeRelationships(ObjectOutputStream out) throws IOException
	{
	}

	public void zDeserializeRelationships(ObjectInputStream in) throws IOException, ClassNotFoundException
	{
	}

	public MithraOffHeapDataObject zCopyOffHeap()
	{
		throw new RuntimeException("off heap no supported");
	}

	public void copyNonPkAttributes(MithraDataObject newData)
	{
		final TaskData taskData = (TaskData) newData;
		this.setName(taskData.getName());
		this.setProcessingDateFrom(taskData.getProcessingDateFrom());
		this.setProcessingDateTo(taskData.getProcessingDateTo());
		this.setStatus(taskData.getStatus());
	}

	public boolean zNonPrimaryKeyAttributesChanged(MithraDataObject newData)
	{
		return this.zNonPrimaryKeyAttributesChanged(newData, 0.0);
	}

	public boolean zNonPrimaryKeyAttributesChanged(MithraDataObject newData, double toleranceForFloatingPointFields)
	{
		final TaskData other = (TaskData) newData;
		if (!isNameNull() ? !getName().equals(other.getName()) : !other.isNameNull())
		{
			return true;
		}

		if (!isStatusNull() ? !getStatus().equals(other.getStatus()) : !other.isStatusNull())
		{
			return true;
		}

		return false;
	}

	public MithraDataObject copy()
	{
		TaskData copy = new TaskData();
		this.copyInto(copy, true);
		return copy;
	}

	public MithraDataObject copy(boolean withRelationships)
	{
		TaskData copy = new TaskData();
		this.copyInto(copy, withRelationships);
		return copy;
	}

	public String zGetPrintablePrimaryKey()
	{
		String result = "";
		result += "processingDateFrom: "+(isProcessingDateFromNull() ? "null" : PrintablePreparedStatement.timestampFormat.print(zGetProcessingDateFromAsLong()))+ " / ";
		result += "processingDateTo: "+(isProcessingDateToNull() ? "null" : PrintablePreparedStatement.timestampFormat.print(zGetProcessingDateToAsLong()))+ " / ";
		result += "taskId: "+(""+getTaskId())+ " / ";
		return result;
	}

	public boolean zAsOfAttributesFromEquals(MithraDataObject other)
	{
		boolean result = true;
		TaskData otherData = (TaskData) other;
		result &= zGetProcessingDateFromAsLong() == otherData.zGetProcessingDateFromAsLong();
		return result;
	}

	public boolean zAsOfAttributesChanged(MithraDataObject other)
	{
		TaskData otherData = (TaskData) other;
		if (zGetProcessingDateToAsLong() != otherData.zGetProcessingDateToAsLong())
		{
			return true;
		}

		if (zGetProcessingDateFromAsLong() != otherData.zGetProcessingDateFromAsLong())
		{
			return true;
		}

		return false;
	}

	public void zWriteDataClassName(ObjectOutput out) throws IOException
	{
	}

	public String zReadDataClassName(ObjectInput in) throws IOException, ClassNotFoundException
	{
		return "kata.domain.TaskData";
	}

	public boolean changed(MithraDataObject newData)
	{
		if(zNonPrimaryKeyAttributesChanged(newData))
		{
			return true;
		}
		else
		{
			return zAsOfAttributesChanged(newData);
		}
	}

	public boolean zHasSameNullPrimaryKeyAttributes(MithraDataObject newData)
	{
		return true;
	}

	public MithraObjectPortal zGetMithraObjectPortal(int hierarchyDepth)
	{
		return TaskFinder.getMithraObjectPortal();
	}

	public MithraObjectPortal zGetMithraObjectPortal()
	{
		return TaskFinder.getMithraObjectPortal();
	}

	public Number zGetIdentityValue()
	{
		return null;
	}

	public boolean zHasIdentity()
	{
		return false;
	}

	public void zSetIdentity(Number identityValue)
	{
	}

	public String zGetSerializationClassName()
	{
		return "kata.domain.TaskData";
	}
}
