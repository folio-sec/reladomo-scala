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
* This file was automatically generated using Mithra 17.0.2. Please do not modify it.
* Add custom logic to its subclass instead.
*/
public class AllTypesData
implements MithraDataObject
{
	private byte isNullBits0 = 0;
	private boolean booleanValue;
	private byte[] byteArrayValue;
	private byte byteValue;
	private char charValue;
	private Date dateValue;
	private double doubleValue;
	private float floatValue;
	private int id;
	private int intValue;
	private long longValue;
	private byte[] nullableByteArrayValue;
	private byte nullableByteValue;
	private char nullableCharValue;
	private Date nullableDateValue;
	private double nullableDoubleValue;
	private float nullableFloatValue;
	private int nullableIntValue;
	private long nullableLongValue;
	private short nullableShortValue;
	private String nullableStringValue;
	private Timestamp nullableTimestampValue;
	private short shortValue;
	private String stringValue;
	private Timestamp timestampValue;
	public boolean isBooleanValueNull()
	{
		return false;
	}

	public boolean isByteArrayValueNull()
	{
		return this.getByteArrayValue() == null;
	}

	public boolean isByteValueNull()
	{
		return false;
	}

	public boolean isCharValueNull()
	{
		return false;
	}

	public boolean isDateValueNull()
	{
		return this.getDateValue() == null;
	}

	public boolean isDoubleValueNull()
	{
		return false;
	}

	public boolean isFloatValueNull()
	{
		return false;
	}

	public boolean isIdNull()
	{
		return false;
	}

	public boolean isIntValueNull()
	{
		return false;
	}

	public boolean isLongValueNull()
	{
		return false;
	}

	public boolean isNullableByteArrayValueNull()
	{
		return this.getNullableByteArrayValue() == null;
	}

	public boolean isNullableDateValueNull()
	{
		return this.getNullableDateValue() == null;
	}

	public boolean isNullableStringValueNull()
	{
		return this.getNullableStringValue() == null;
	}

	public boolean isNullableTimestampValueNull()
	{
		return this.getNullableTimestampValue() == null;
	}

	public boolean isShortValueNull()
	{
		return false;
	}

	public boolean isStringValueNull()
	{
		return this.getStringValue() == null;
	}

	public boolean isTimestampValueNull()
	{
		return this.getTimestampValue() == null;
	}

	public boolean isNullableByteValueNull()
	{
		return (isNullBits0 & 1) != 0 ;
	}

	public boolean isNullableShortValueNull()
	{
		return (isNullBits0 & 1 << 1) != 0 ;
	}

	public boolean isNullableCharValueNull()
	{
		return (isNullBits0 & 1 << 2) != 0 ;
	}

	public boolean isNullableIntValueNull()
	{
		return (isNullBits0 & 1 << 3) != 0 ;
	}

	public boolean isNullableLongValueNull()
	{
		return (isNullBits0 & 1 << 4) != 0 ;
	}

	public boolean isNullableFloatValueNull()
	{
		return (isNullBits0 & 1 << 5) != 0 ;
	}

	public boolean isNullableDoubleValueNull()
	{
		return (isNullBits0 & 1 << 6) != 0 ;
	}

	public void zSerializeFullData(ObjectOutput out) throws IOException
	{
		zWriteNullBits(out);
		out.writeBoolean(this.booleanValue);
		if (byteArrayValue == null) out.writeInt(-1); else 
		{
			out.writeInt(byteArrayValue.length); out.write(byteArrayValue); 
		}

		;
		out.writeByte(this.byteValue);
		out.writeChar(this.charValue);
		MithraTimestamp.writeTimezoneInsensitiveDate(out, this.dateValue);
		out.writeDouble(this.doubleValue);
		out.writeFloat(this.floatValue);
		out.writeInt(this.id);
		out.writeInt(this.intValue);
		out.writeLong(this.longValue);
		if (nullableByteArrayValue == null) out.writeInt(-1); else 
		{
			out.writeInt(nullableByteArrayValue.length); out.write(nullableByteArrayValue); 
		}

		;
		out.writeByte(this.nullableByteValue);
		out.writeChar(this.nullableCharValue);
		MithraTimestamp.writeTimezoneInsensitiveDate(out, this.nullableDateValue);
		out.writeDouble(this.nullableDoubleValue);
		out.writeFloat(this.nullableFloatValue);
		out.writeInt(this.nullableIntValue);
		out.writeLong(this.nullableLongValue);
		out.writeShort(this.nullableShortValue);
		out.writeObject(this.nullableStringValue);
		MithraTimestamp.writeTimezoneInsensitiveTimestamp(out, this.nullableTimestampValue);
		out.writeShort(this.shortValue);
		out.writeObject(this.stringValue);
		MithraTimestamp.writeTimezoneInsensitiveTimestamp(out, this.timestampValue);
	}

	private void zWriteNullBits(ObjectOutput out) throws IOException
	{
		out.writeByte(this.isNullBits0);
	}

	public boolean isBooleanValue()
	{
		return this.booleanValue;
	}

	public void setBooleanValue(boolean value)
	{
		this.booleanValue = value;
	}

	public void setBooleanValueNull()
	{
		throw new RuntimeException("should never be called");
	}

	public byte[] getByteArrayValue()
	{
		return this.byteArrayValue;
	}

	public void setByteArrayValue(byte[] value)
	{
		this.byteArrayValue = value;
	}

	public void setByteArrayValueNull()
	{
		this.setByteArrayValue(null);
	}

	public byte getByteValue()
	{
		return this.byteValue;
	}

	public void setByteValue(byte value)
	{
		this.byteValue = value;
	}

	public void setByteValueNull()
	{
		throw new RuntimeException("should never be called");
	}

	public char getCharValue()
	{
		return this.charValue;
	}

	public void setCharValue(char value)
	{
		this.charValue = value;
	}

	public void setCharValueNull()
	{
		throw new RuntimeException("should never be called");
	}

	public Date getDateValue()
	{
		return this.dateValue;
	}

	public void setDateValue(java.util.Date value)
	{
		if (value == null || value instanceof java.sql.Date)
		{
			this.dateValue = (java.sql.Date) value;
		}
		else
		{
			this.dateValue = new java.sql.Date(value.getTime());
		}
	}

	public void setDateValueNull()
	{
		this.setDateValue(null);
	}

	public double getDoubleValue()
	{
		return this.doubleValue;
	}

	public void setDoubleValue(double value)
	{
		this.doubleValue = value;
	}

	public void setDoubleValueNull()
	{
		throw new RuntimeException("should never be called");
	}

	public float getFloatValue()
	{
		return this.floatValue;
	}

	public void setFloatValue(float value)
	{
		this.floatValue = value;
	}

	public void setFloatValueNull()
	{
		throw new RuntimeException("should never be called");
	}

	public int getId()
	{
		return this.id;
	}

	public void setId(int value)
	{
		this.id = value;
	}

	public void setIdNull()
	{
		throw new RuntimeException("should never be called");
	}

	public int getIntValue()
	{
		return this.intValue;
	}

	public void setIntValue(int value)
	{
		this.intValue = value;
	}

	public void setIntValueNull()
	{
		throw new RuntimeException("should never be called");
	}

	public long getLongValue()
	{
		return this.longValue;
	}

	public void setLongValue(long value)
	{
		this.longValue = value;
	}

	public void setLongValueNull()
	{
		throw new RuntimeException("should never be called");
	}

	public byte[] getNullableByteArrayValue()
	{
		return this.nullableByteArrayValue;
	}

	public void setNullableByteArrayValue(byte[] value)
	{
		this.nullableByteArrayValue = value;
	}

	public void setNullableByteArrayValueNull()
	{
		this.setNullableByteArrayValue(null);
	}

	public byte getNullableByteValue()
	{
		return this.nullableByteValue;
	}

	public void setNullableByteValue(byte value)
	{
		this.nullableByteValue = value;
		isNullBits0 = (byte)((int)isNullBits0 & ~( 1));
	}

	public char getNullableCharValue()
	{
		return this.nullableCharValue;
	}

	public void setNullableCharValue(char value)
	{
		this.nullableCharValue = value;
		isNullBits0 = (byte)((int)isNullBits0 & ~( 1 << 2));
	}

	public Date getNullableDateValue()
	{
		return this.nullableDateValue;
	}

	public void setNullableDateValue(java.util.Date value)
	{
		if (value == null || value instanceof java.sql.Date)
		{
			this.nullableDateValue = (java.sql.Date) value;
		}
		else
		{
			this.nullableDateValue = new java.sql.Date(value.getTime());
		}
	}

	public void setNullableDateValueNull()
	{
		this.setNullableDateValue(null);
	}

	public double getNullableDoubleValue()
	{
		return this.nullableDoubleValue;
	}

	public void setNullableDoubleValue(double value)
	{
		this.nullableDoubleValue = value;
		isNullBits0 = (byte)((int)isNullBits0 & ~( 1 << 6));
	}

	public float getNullableFloatValue()
	{
		return this.nullableFloatValue;
	}

	public void setNullableFloatValue(float value)
	{
		this.nullableFloatValue = value;
		isNullBits0 = (byte)((int)isNullBits0 & ~( 1 << 5));
	}

	public int getNullableIntValue()
	{
		return this.nullableIntValue;
	}

	public void setNullableIntValue(int value)
	{
		this.nullableIntValue = value;
		isNullBits0 = (byte)((int)isNullBits0 & ~( 1 << 3));
	}

	public long getNullableLongValue()
	{
		return this.nullableLongValue;
	}

	public void setNullableLongValue(long value)
	{
		this.nullableLongValue = value;
		isNullBits0 = (byte)((int)isNullBits0 & ~( 1 << 4));
	}

	public short getNullableShortValue()
	{
		return this.nullableShortValue;
	}

	public void setNullableShortValue(short value)
	{
		this.nullableShortValue = value;
		isNullBits0 = (byte)((int)isNullBits0 & ~( 1 << 1));
	}

	public String getNullableStringValue()
	{
		return this.nullableStringValue;
	}

	public int zGetNullableStringValueAsInt()
	{
		return StringPool.getInstance().getOffHeapAddressWithoutAdding(nullableStringValue);
	}

	public void setNullableStringValue(String value)
	{
		this.nullableStringValue = StringPool.getInstance().getOrAddToCache(value, AllTypesFinder.isFullCache());
	}

	public void setNullableStringValueNull()
	{
		this.setNullableStringValue(null);
	}

	public Timestamp getNullableTimestampValue()
	{
		return this.nullableTimestampValue;
	}

	public long zGetNullableTimestampValueAsLong()
	{
		if (nullableTimestampValue == null) return TimestampPool.OFF_HEAP_NULL;
		return nullableTimestampValue.getTime();
	}

	public void setNullableTimestampValue(Timestamp value)
	{
		this.nullableTimestampValue = TimestampPool.getInstance().getOrAddToCache(value, AllTypesFinder.isFullCache(), AllTypesFinder.isOffHeap());
	}

	public void setNullableTimestampValueNull()
	{
		this.setNullableTimestampValue(null);
	}

	public short getShortValue()
	{
		return this.shortValue;
	}

	public void setShortValue(short value)
	{
		this.shortValue = value;
	}

	public void setShortValueNull()
	{
		throw new RuntimeException("should never be called");
	}

	public String getStringValue()
	{
		return this.stringValue;
	}

	public int zGetStringValueAsInt()
	{
		return StringPool.getInstance().getOffHeapAddressWithoutAdding(stringValue);
	}

	public void setStringValue(String value)
	{
		this.stringValue = StringPool.getInstance().getOrAddToCache(value, AllTypesFinder.isFullCache());
	}

	public void setStringValueNull()
	{
		this.setStringValue(null);
	}

	public Timestamp getTimestampValue()
	{
		return this.timestampValue;
	}

	public long zGetTimestampValueAsLong()
	{
		if (timestampValue == null) return TimestampPool.OFF_HEAP_NULL;
		return timestampValue.getTime();
	}

	public void setTimestampValue(Timestamp value)
	{
		this.timestampValue = TimestampPool.getInstance().getOrAddToCache(value, AllTypesFinder.isFullCache(), AllTypesFinder.isOffHeap());
	}

	public void setTimestampValueNull()
	{
		this.setTimestampValue(null);
	}

	public void setNullableByteValueNull()
	{
		isNullBits0 = (byte)((int)isNullBits0 | 1);
	}

	public void setNullableShortValueNull()
	{
		isNullBits0 = (byte)((int)isNullBits0 | 1 << 1);
	}

	public void setNullableCharValueNull()
	{
		isNullBits0 = (byte)((int)isNullBits0 | 1 << 2);
	}

	public void setNullableIntValueNull()
	{
		isNullBits0 = (byte)((int)isNullBits0 | 1 << 3);
	}

	public void setNullableLongValueNull()
	{
		isNullBits0 = (byte)((int)isNullBits0 | 1 << 4);
	}

	public void setNullableFloatValueNull()
	{
		isNullBits0 = (byte)((int)isNullBits0 | 1 << 5);
	}

	public void setNullableDoubleValueNull()
	{
		isNullBits0 = (byte)((int)isNullBits0 | 1 << 6);
	}

	public byte zGetIsNullBits0()
	{
		return this.isNullBits0;
	}

	public void zSetIsNullBits0(byte newValue)
	{
		this.isNullBits0 = newValue;
	}

	protected void copyInto(AllTypesData copy, boolean withRelationships)
	{
		copy.isNullBits0 = this.isNullBits0;
		copy.booleanValue = this.booleanValue;
		copy.byteArrayValue = this.byteArrayValue;
		copy.byteValue = this.byteValue;
		copy.charValue = this.charValue;
		copy.dateValue = this.dateValue;
		copy.doubleValue = this.doubleValue;
		copy.floatValue = this.floatValue;
		copy.id = this.id;
		copy.intValue = this.intValue;
		copy.longValue = this.longValue;
		copy.nullableByteArrayValue = this.nullableByteArrayValue;
		copy.nullableByteValue = this.nullableByteValue;
		copy.nullableCharValue = this.nullableCharValue;
		copy.nullableDateValue = this.nullableDateValue;
		copy.nullableDoubleValue = this.nullableDoubleValue;
		copy.nullableFloatValue = this.nullableFloatValue;
		copy.nullableIntValue = this.nullableIntValue;
		copy.nullableLongValue = this.nullableLongValue;
		copy.nullableShortValue = this.nullableShortValue;
		copy.nullableStringValue = this.nullableStringValue;
		copy.nullableTimestampValue = this.nullableTimestampValue;
		copy.shortValue = this.shortValue;
		copy.stringValue = this.stringValue;
		copy.timestampValue = this.timestampValue;
		if (withRelationships)
		{
		}
	}

	public void zDeserializeFullData(ObjectInput in) throws IOException, ClassNotFoundException
	{
		this.isNullBits0 = in.readByte();
		this.booleanValue = in.readBoolean();
		int _byteArrayValueLength = in.readInt(); if (_byteArrayValueLength == -1) byteArrayValue = null; else 
		{
			byteArrayValue = new byte[_byteArrayValueLength];in.readFully(byteArrayValue);
		}

		;
		this.byteValue = in.readByte();
		this.charValue = in.readChar();
		this.dateValue = (Date)MithraTimestamp.readTimezoneInsensitiveDate(in);
		this.doubleValue = in.readDouble();
		this.floatValue = in.readFloat();
		this.id = in.readInt();
		this.intValue = in.readInt();
		this.longValue = in.readLong();
		int _nullableByteArrayValueLength = in.readInt(); if (_nullableByteArrayValueLength == -1) nullableByteArrayValue = null; else 
		{
			nullableByteArrayValue = new byte[_nullableByteArrayValueLength];in.readFully(nullableByteArrayValue);
		}

		;
		this.nullableByteValue = in.readByte();
		this.nullableCharValue = in.readChar();
		this.nullableDateValue = (Date)MithraTimestamp.readTimezoneInsensitiveDate(in);
		this.nullableDoubleValue = in.readDouble();
		this.nullableFloatValue = in.readFloat();
		this.nullableIntValue = in.readInt();
		this.nullableLongValue = in.readLong();
		this.nullableShortValue = in.readShort();
		this.nullableStringValue = StringPool.getInstance().getOrAddToCache((String)in.readObject(), AllTypesFinder.isFullCache());
		this.nullableTimestampValue = TimestampPool.getInstance().getOrAddToCache(MithraTimestamp.readTimezoneInsensitiveTimestamp(in), AllTypesFinder.isFullCache(), AllTypesFinder.isOffHeap());
		this.shortValue = in.readShort();
		this.stringValue = StringPool.getInstance().getOrAddToCache((String)in.readObject(), AllTypesFinder.isFullCache());
		this.timestampValue = TimestampPool.getInstance().getOrAddToCache(MithraTimestamp.readTimezoneInsensitiveTimestamp(in), AllTypesFinder.isFullCache(), AllTypesFinder.isOffHeap());
	}

	public boolean hasSamePrimaryKeyIgnoringAsOfAttributes(MithraDataObject other)
	{
		if (this == other) return true;
		final AllTypesData otherData = (AllTypesData) other;
		if (getId() != otherData.getId())
		{
			return false;
		}

		return true;
	}

	public void zSerializePrimaryKey(ObjectOutput out) throws IOException
	{
		out.writeInt(this.id);
	}

	public void zDeserializePrimaryKey(ObjectInput in) throws IOException, ClassNotFoundException
	{
		this.id = in.readInt();
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
		final AllTypesData allTypesData = (AllTypesData) newData;
		this.setBooleanValue(allTypesData.isBooleanValue());
		this.setByteArrayValue(allTypesData.getByteArrayValue());
		this.setByteValue(allTypesData.getByteValue());
		this.setCharValue(allTypesData.getCharValue());
		this.setDateValue(allTypesData.getDateValue());
		this.setDoubleValue(allTypesData.getDoubleValue());
		this.setFloatValue(allTypesData.getFloatValue());
		this.setIntValue(allTypesData.getIntValue());
		this.setLongValue(allTypesData.getLongValue());
		this.setNullableByteArrayValue(allTypesData.getNullableByteArrayValue());
		this.setNullableByteValue(allTypesData.getNullableByteValue());
		if (allTypesData.isNullableByteValueNull()) this.setNullableByteValueNull();
		this.setNullableCharValue(allTypesData.getNullableCharValue());
		if (allTypesData.isNullableCharValueNull()) this.setNullableCharValueNull();
		this.setNullableDateValue(allTypesData.getNullableDateValue());
		this.setNullableDoubleValue(allTypesData.getNullableDoubleValue());
		if (allTypesData.isNullableDoubleValueNull()) this.setNullableDoubleValueNull();
		this.setNullableFloatValue(allTypesData.getNullableFloatValue());
		if (allTypesData.isNullableFloatValueNull()) this.setNullableFloatValueNull();
		this.setNullableIntValue(allTypesData.getNullableIntValue());
		if (allTypesData.isNullableIntValueNull()) this.setNullableIntValueNull();
		this.setNullableLongValue(allTypesData.getNullableLongValue());
		if (allTypesData.isNullableLongValueNull()) this.setNullableLongValueNull();
		this.setNullableShortValue(allTypesData.getNullableShortValue());
		if (allTypesData.isNullableShortValueNull()) this.setNullableShortValueNull();
		this.setNullableStringValue(allTypesData.getNullableStringValue());
		this.setNullableTimestampValue(allTypesData.getNullableTimestampValue());
		this.setShortValue(allTypesData.getShortValue());
		this.setStringValue(allTypesData.getStringValue());
		this.setTimestampValue(allTypesData.getTimestampValue());
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
		final AllTypesData other = (AllTypesData) newData;
		if ( isBooleanValue() != other.isBooleanValue())
		{
			return true;
		}

		if (!isByteArrayValueNull() ? !Arrays.equals(getByteArrayValue(),other.getByteArrayValue()) : !other.isByteArrayValueNull())
		{
			return true;
		}

		if ( getByteValue() != other.getByteValue())
		{
			return true;
		}

		if ( getCharValue() != other.getCharValue())
		{
			return true;
		}

		if (!isDateValueNull() ? !getDateValue().equals(other.getDateValue()) : !other.isDateValueNull())
		{
			return true;
		}

		if ( Math.abs(getDoubleValue() - other.getDoubleValue()) > toleranceForFloatingPointFields)
		{
			return true;
		}

		if ( Math.abs(getFloatValue() - other.getFloatValue()) > toleranceForFloatingPointFields)
		{
			return true;
		}

		if ( getIntValue() != other.getIntValue())
		{
			return true;
		}

		if ( getLongValue() != other.getLongValue())
		{
			return true;
		}

		if (!isNullableByteArrayValueNull() ? !Arrays.equals(getNullableByteArrayValue(),other.getNullableByteArrayValue()) : !other.isNullableByteArrayValueNull())
		{
			return true;
		}

		if ( isNullableByteValueNull() != other.isNullableByteValueNull() || getNullableByteValue() != other.getNullableByteValue())
		{
			return true;
		}

		if ( isNullableCharValueNull() != other.isNullableCharValueNull() || getNullableCharValue() != other.getNullableCharValue())
		{
			return true;
		}

		if (!isNullableDateValueNull() ? !getNullableDateValue().equals(other.getNullableDateValue()) : !other.isNullableDateValueNull())
		{
			return true;
		}

		if ( isNullableDoubleValueNull() != other.isNullableDoubleValueNull() || Math.abs(getNullableDoubleValue() - other.getNullableDoubleValue()) > toleranceForFloatingPointFields)
		{
			return true;
		}

		if ( isNullableFloatValueNull() != other.isNullableFloatValueNull() || Math.abs(getNullableFloatValue() - other.getNullableFloatValue()) > toleranceForFloatingPointFields)
		{
			return true;
		}

		if ( isNullableIntValueNull() != other.isNullableIntValueNull() || getNullableIntValue() != other.getNullableIntValue())
		{
			return true;
		}

		if ( isNullableLongValueNull() != other.isNullableLongValueNull() || getNullableLongValue() != other.getNullableLongValue())
		{
			return true;
		}

		if ( isNullableShortValueNull() != other.isNullableShortValueNull() || getNullableShortValue() != other.getNullableShortValue())
		{
			return true;
		}

		if (!isNullableStringValueNull() ? !getNullableStringValue().equals(other.getNullableStringValue()) : !other.isNullableStringValueNull())
		{
			return true;
		}

		if (!isNullableTimestampValueNull() ? !getNullableTimestampValue().equals(other.getNullableTimestampValue()) : !other.isNullableTimestampValueNull())
		{
			return true;
		}

		if ( getShortValue() != other.getShortValue())
		{
			return true;
		}

		if (!isStringValueNull() ? !getStringValue().equals(other.getStringValue()) : !other.isStringValueNull())
		{
			return true;
		}

		if (!isTimestampValueNull() ? !getTimestampValue().equals(other.getTimestampValue()) : !other.isTimestampValueNull())
		{
			return true;
		}

		return false;
	}

	public MithraDataObject copy()
	{
		AllTypesData copy = new AllTypesData();
		this.copyInto(copy, true);
		return copy;
	}

	public MithraDataObject copy(boolean withRelationships)
	{
		AllTypesData copy = new AllTypesData();
		this.copyInto(copy, withRelationships);
		return copy;
	}

	public String zGetPrintablePrimaryKey()
	{
		String result = "";
		result += "id: "+(""+getId())+ " / ";
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
		return "kata.domain.AllTypesData";
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
		return AllTypesFinder.getMithraObjectPortal();
	}

	public MithraObjectPortal zGetMithraObjectPortal()
	{
		return AllTypesFinder.getMithraObjectPortal();
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
		return "kata.domain.AllTypesData";
	}
}
