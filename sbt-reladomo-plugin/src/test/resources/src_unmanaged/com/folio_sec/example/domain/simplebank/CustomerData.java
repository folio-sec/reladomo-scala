package com.folio_sec.example.domain.simplebank;
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
public class CustomerData
implements MithraDataObject
{
	private Object[] _relationships;
	private byte isNullBits0 = 0;
	private String country;
	private int customerId;
	private String firstName;
	private String lastName;
	private int zipCode;
	public boolean isCountryNull()
	{
		return this.getCountry() == null;
	}

	public boolean isCustomerIdNull()
	{
		return false;
	}

	public boolean isFirstNameNull()
	{
		return this.getFirstName() == null;
	}

	public boolean isLastNameNull()
	{
		return this.getLastName() == null;
	}

	public boolean isZipCodeNull()
	{
		return (isNullBits0 & 1) != 0 ;
	}

	public void zSerializeFullData(ObjectOutput out) throws IOException
	{
		zWriteNullBits(out);
		out.writeObject(this.country);
		out.writeInt(this.customerId);
		out.writeBoolean(_isCustomerIdSet);
		out.writeObject(this.firstName);
		out.writeObject(this.lastName);
		out.writeInt(this.zipCode);
	}

	private void zWriteNullBits(ObjectOutput out) throws IOException
	{
		out.writeByte(this.isNullBits0);
	}

	public String getCountry()
	{
		return this.country;
	}

	public int zGetCountryAsInt()
	{
		return StringPool.getInstance().getOffHeapAddressWithoutAdding(country);
	}

	public void setCountry(String value)
	{
		this.country = StringPool.getInstance().getOrAddToCache(value, CustomerFinder.isFullCache());
	}

	public void setCountryNull()
	{
		this.setCountry(null);
	}

	public int getCustomerId()
	{
		return this.customerId;
	}

	public void setCustomerId(int value)
	{
		this.customerId = value;
		_isCustomerIdSet = true;
	}

	public void setCustomerIdNull()
	{
		throw new RuntimeException("should never be called");
	}

	public String getFirstName()
	{
		return this.firstName;
	}

	public int zGetFirstNameAsInt()
	{
		return StringPool.getInstance().getOffHeapAddressWithoutAdding(firstName);
	}

	public void setFirstName(String value)
	{
		this.firstName = StringPool.getInstance().getOrAddToCache(value, CustomerFinder.isFullCache());
	}

	public void setFirstNameNull()
	{
		this.setFirstName(null);
	}

	public String getLastName()
	{
		return this.lastName;
	}

	public int zGetLastNameAsInt()
	{
		return StringPool.getInstance().getOffHeapAddressWithoutAdding(lastName);
	}

	public void setLastName(String value)
	{
		this.lastName = StringPool.getInstance().getOrAddToCache(value, CustomerFinder.isFullCache());
	}

	public void setLastNameNull()
	{
		this.setLastName(null);
	}

	public int getZipCode()
	{
		return this.zipCode;
	}

	public void setZipCode(int value)
	{
		this.zipCode = value;
		isNullBits0 = (byte)((int)isNullBits0 & ~( 1));
	}

	public void setZipCodeNull()
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

	public boolean _isCustomerIdSet;
	public boolean zGetIsCustomerIdSet()
	{
		return _isCustomerIdSet;
	}

	protected void copyInto(CustomerData copy, boolean withRelationships)
	{
		copy.isNullBits0 = this.isNullBits0;
		copy.country = this.country;
		copy.customerId = this.customerId;
		copy.firstName = this.firstName;
		copy.lastName = this.lastName;
		copy.zipCode = this.zipCode;
		copy._isCustomerIdSet = this._isCustomerIdSet;
		if (withRelationships)
		{
			if (_relationships != null)
			{
				copy._relationships = new Object[1];
				System.arraycopy(_relationships, 0, copy._relationships, 0, _relationships.length);
			}
		}
	}

	public void zDeserializeFullData(ObjectInput in) throws IOException, ClassNotFoundException
	{
		this.isNullBits0 = in.readByte();
		this.country = StringPool.getInstance().getOrAddToCache((String)in.readObject(), CustomerFinder.isFullCache());
		this.customerId = in.readInt();
		_isCustomerIdSet = in.readBoolean();
		this.firstName = StringPool.getInstance().getOrAddToCache((String)in.readObject(), CustomerFinder.isFullCache());
		this.lastName = StringPool.getInstance().getOrAddToCache((String)in.readObject(), CustomerFinder.isFullCache());
		this.zipCode = in.readInt();
	}

	public boolean hasSamePrimaryKeyIgnoringAsOfAttributes(MithraDataObject other)
	{
		if (this == other) return true;
		final CustomerData otherData = (CustomerData) other;
		if (getCustomerId() != otherData.getCustomerId())
		{
			return false;
		}

		return true;
	}

	public void zSerializePrimaryKey(ObjectOutput out) throws IOException
	{
		out.writeInt(this.customerId);
	}

	public void zDeserializePrimaryKey(ObjectInput in) throws IOException, ClassNotFoundException
	{
		this.customerId = in.readInt();
	}

	public void clearRelationships()
	{
		_relationships = null;
		clearAllDirectRefs();
	}

	public void clearAllDirectRefs()
	{
	}

	public Object getAccounts()
	{
		if (_relationships != null)
		{
			return _relationships[0];
		}

		return null;
	}

	public void setAccounts(Object related)
	{
		if (_relationships == null)
		{
			_relationships = new Object[1];
		}

		_relationships[0] = related;
	}

	public void zSerializeRelationships(ObjectOutputStream out) throws IOException
	{
		if (_relationships == null)
		{
			out.writeInt(0);
			return;
		}

		out.writeInt(_relationships.length);
		for(int i=0;i<_relationships.length;i++)
		{
			out.writeObject(_relationships[i]);
		}
	}

	public void zDeserializeRelationships(ObjectInputStream in) throws IOException, ClassNotFoundException
	{
		int total = in.readInt();
		if(total > 0)
		{
			_relationships = new Object[total];
			for(int i=0;i<total;i++)
			{
				_relationships[i] = in.readObject();
			}
		}
	}

	public MithraOffHeapDataObject zCopyOffHeap()
	{
		throw new RuntimeException("off heap no supported");
	}

	public void copyNonPkAttributes(MithraDataObject newData)
	{
		final CustomerData customerData = (CustomerData) newData;
		this.setCountry(customerData.getCountry());
		this.setFirstName(customerData.getFirstName());
		this.setLastName(customerData.getLastName());
		this.setZipCode(customerData.getZipCode());
		if (customerData.isZipCodeNull()) this.setZipCodeNull();
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
		final CustomerData other = (CustomerData) newData;
		if (!isCountryNull() ? !getCountry().equals(other.getCountry()) : !other.isCountryNull())
		{
			return true;
		}

		if (!isFirstNameNull() ? !getFirstName().equals(other.getFirstName()) : !other.isFirstNameNull())
		{
			return true;
		}

		if (!isLastNameNull() ? !getLastName().equals(other.getLastName()) : !other.isLastNameNull())
		{
			return true;
		}

		if ( isZipCodeNull() != other.isZipCodeNull() || getZipCode() != other.getZipCode())
		{
			return true;
		}

		return false;
	}

	public MithraDataObject copy()
	{
		CustomerData copy = new CustomerData();
		this.copyInto(copy, true);
		return copy;
	}

	public MithraDataObject copy(boolean withRelationships)
	{
		CustomerData copy = new CustomerData();
		this.copyInto(copy, withRelationships);
		return copy;
	}

	public String zGetPrintablePrimaryKey()
	{
		String result = "";
		result += "customerId: "+(""+getCustomerId())+ " / ";
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
		return "com.folio_sec.example.domain.simplebank.CustomerData";
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
		return CustomerFinder.getMithraObjectPortal();
	}

	public MithraObjectPortal zGetMithraObjectPortal()
	{
		return CustomerFinder.getMithraObjectPortal();
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
		return "com.folio_sec.example.domain.simplebank.CustomerData";
	}
}
