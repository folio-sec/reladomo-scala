package kata.domain;

import com.gs.fw.common.mithra.MithraDataObject;
import com.gs.fw.common.mithra.MithraObjectPortal;
import com.gs.fw.common.mithra.cache.offheap.MithraOffHeapDataObject;
import com.gs.fw.common.mithra.util.StringPool;

import java.io.*;

/**
* This file was automatically generated using Mithra 16.5.1. Please do not modify it.
* Add custom logic to its subclass instead.
*/
public class ObjectSequenceData
implements MithraDataObject
{
	private byte isNullBits0 = 0;
	private long nextValue;
	private String simulatedSequenceName;
	public boolean isSimulatedSequenceNameNull()
	{
		return this.getSimulatedSequenceName() == null;
	}

	public boolean isNextValueNull()
	{
		return (isNullBits0 & 1) != 0 ;
	}

	public void zSerializeFullData(ObjectOutput out) throws IOException
	{
		zWriteNullBits(out);
		out.writeLong(this.nextValue);
		out.writeObject(this.simulatedSequenceName);
	}

	private void zWriteNullBits(ObjectOutput out) throws IOException
	{
		out.writeByte(this.isNullBits0);
	}

	public long getNextValue()
	{
		return this.nextValue;
	}

	public void setNextValue(long value)
	{
		this.nextValue = value;
		isNullBits0 = (byte)((int)isNullBits0 & ~( 1));
	}

	public String getSimulatedSequenceName()
	{
		return this.simulatedSequenceName;
	}

	public int zGetSimulatedSequenceNameAsInt()
	{
		return StringPool.getInstance().getOffHeapAddressWithoutAdding(simulatedSequenceName);
	}

	public void setSimulatedSequenceName(String value)
	{
		this.simulatedSequenceName = StringPool.getInstance().getOrAddToCache(value, ObjectSequenceFinder.isFullCache());
	}

	public void setSimulatedSequenceNameNull()
	{
		this.setSimulatedSequenceName(null);
	}

	public void setNextValueNull()
	{
		isNullBits0 = (byte)((int)isNullBits0 | 1);
	}

	public byte zGetIsNullBits0()
	{
		return this.isNullBits0;
	}

	public void zSetIsNullBits0(byte newValue)
	{
		this.isNullBits0 = newValue;
	}

	protected void copyInto(ObjectSequenceData copy, boolean withRelationships)
	{
		copy.isNullBits0 = this.isNullBits0;
		copy.nextValue = this.nextValue;
		copy.simulatedSequenceName = this.simulatedSequenceName;
		if (withRelationships)
		{
		}
	}

	public void zDeserializeFullData(ObjectInput in) throws IOException, ClassNotFoundException
	{
		this.isNullBits0 = in.readByte();
		this.nextValue = in.readLong();
		this.simulatedSequenceName = StringPool.getInstance().getOrAddToCache((String)in.readObject(), ObjectSequenceFinder.isFullCache());
	}

	public boolean hasSamePrimaryKeyIgnoringAsOfAttributes(MithraDataObject other)
	{
		if (this == other) return true;
		final ObjectSequenceData otherData = (ObjectSequenceData) other;
		if (!isSimulatedSequenceNameNull() ? !getSimulatedSequenceName().equals(otherData.getSimulatedSequenceName()) : !otherData.isSimulatedSequenceNameNull())
		{
			return false;
		}

		return true;
	}

	public void zSerializePrimaryKey(ObjectOutput out) throws IOException
	{
		out.writeObject(this.simulatedSequenceName);
	}

	public void zDeserializePrimaryKey(ObjectInput in) throws IOException, ClassNotFoundException
	{
		this.simulatedSequenceName = StringPool.getInstance().getOrAddToCache((String)in.readObject(), ObjectSequenceFinder.isFullCache());
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
		final ObjectSequenceData objectSequenceData = (ObjectSequenceData) newData;
		this.setNextValue(objectSequenceData.getNextValue());
		if (objectSequenceData.isNextValueNull()) this.setNextValueNull();
	}

	public byte zGetDataVersion() 
	{
		return (byte)0; 
	}

	public void zSetDataVersion(byte version) 
	{
	}
	// only used by dated objects
	public void zIncrementDataVersion() 
	{
	}

	public boolean zNonPrimaryKeyAttributesChanged(MithraDataObject newData)
	{
		return this.zNonPrimaryKeyAttributesChanged(newData, 0.0);
	}

	public boolean zNonPrimaryKeyAttributesChanged(MithraDataObject newData, double toleranceForFloatingPointFields)
	{
		final ObjectSequenceData other = (ObjectSequenceData) newData;
		if ( isNextValueNull() != other.isNextValueNull() || getNextValue() != other.getNextValue())
		{
			return true;
		}

		return false;
	}

	public MithraDataObject copy()
	{
		ObjectSequenceData copy = new ObjectSequenceData();
		this.copyInto(copy, true);
		return copy;
	}

	public MithraDataObject copy(boolean withRelationships)
	{
		ObjectSequenceData copy = new ObjectSequenceData();
		this.copyInto(copy, withRelationships);
		return copy;
	}

	public String zGetPrintablePrimaryKey()
	{
		String result = "";
		result += "simulatedSequenceName: "+"'"+getSimulatedSequenceName()+"'"+ " / ";
		return result;
	}

	public boolean zAsOfAttributesFromEquals(MithraDataObject other)
	{
		return true;
	}

	public boolean zAsOfAttributesChanged(MithraDataObject other)
	{
		return false;
	}

	public void zWriteDataClassName(ObjectOutput out) throws IOException
	{
	}

	public String zReadDataClassName(ObjectInput in) throws IOException, ClassNotFoundException
	{
		return "kata.domain.ObjectSequenceData";
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
		return ObjectSequenceFinder.getMithraObjectPortal();
	}

	public MithraObjectPortal zGetMithraObjectPortal()
	{
		return ObjectSequenceFinder.getMithraObjectPortal();
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
		return "kata.domain.ObjectSequenceData";
	}
}
