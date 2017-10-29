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
* This file was automatically generated using Mithra 16.6.1. Please do not modify it.
* Add custom logic to its subclass instead.
*/
public class CustomerAccountData
implements MithraDataObject
{
	private Object[] _relationships;
	private byte isNullBits0 = 0;
	private int accountId;
	private String accountName;
	private String accountType;
	private int areaId;
	private double balance;
	private int customerId;
	public boolean isAccountIdNull()
	{
		return false;
	}

	public boolean isAccountNameNull()
	{
		return this.getAccountName() == null;
	}

	public boolean isAccountTypeNull()
	{
		return this.getAccountType() == null;
	}

	public boolean isCustomerIdNull()
	{
		return false;
	}

	public boolean isAreaIdNull()
	{
		return (isNullBits0 & 1) != 0 ;
	}

	public boolean isBalanceNull()
	{
		return (isNullBits0 & 1 << 1) != 0 ;
	}

	public void zSerializeFullData(ObjectOutput out) throws IOException
	{
		zWriteNullBits(out);
		out.writeInt(this.accountId);
		out.writeBoolean(_isAccountIdSet);
		out.writeObject(this.accountName);
		out.writeObject(this.accountType);
		out.writeInt(this.areaId);
		out.writeDouble(this.balance);
		out.writeInt(this.customerId);
	}

	private void zWriteNullBits(ObjectOutput out) throws IOException
	{
		out.writeByte(this.isNullBits0);
	}

	public int getAccountId()
	{
		return this.accountId;
	}

	public void setAccountId(int value)
	{
		this.accountId = value;
		_isAccountIdSet = true;
	}

	public void setAccountIdNull()
	{
		throw new RuntimeException("should never be called");
	}

	public String getAccountName()
	{
		return this.accountName;
	}

	public int zGetAccountNameAsInt()
	{
		return StringPool.getInstance().getOffHeapAddressWithoutAdding(accountName);
	}

	public void setAccountName(String value)
	{
		this.accountName = StringPool.getInstance().getOrAddToCache(value, CustomerAccountFinder.isFullCache());
	}

	public void setAccountNameNull()
	{
		this.setAccountName(null);
	}

	public String getAccountType()
	{
		return this.accountType;
	}

	public int zGetAccountTypeAsInt()
	{
		return StringPool.getInstance().getOffHeapAddressWithoutAdding(accountType);
	}

	public void setAccountType(String value)
	{
		this.accountType = StringPool.getInstance().getOrAddToCache(value, CustomerAccountFinder.isFullCache());
	}

	public void setAccountTypeNull()
	{
		this.setAccountType(null);
	}

	public int getAreaId()
	{
		return this.areaId;
	}

	public void setAreaId(int value)
	{
		this.areaId = value;
		isNullBits0 = (byte)((int)isNullBits0 & ~( 1));
	}

	public double getBalance()
	{
		return this.balance;
	}

	public void setBalance(double value)
	{
		this.balance = value;
		isNullBits0 = (byte)((int)isNullBits0 & ~( 1 << 1));
	}

	public int getCustomerId()
	{
		return this.customerId;
	}

	public void setCustomerId(int value)
	{
		this.customerId = value;
	}

	public void setCustomerIdNull()
	{
		throw new RuntimeException("should never be called");
	}

	public void setAreaIdNull()
	{
		isNullBits0 = (byte)((int)isNullBits0 | 1);
	}

	public void setBalanceNull()
	{
		isNullBits0 = (byte)((int)isNullBits0 | 1 << 1);
	}

	public byte zGetIsNullBits0()
	{
		return this.isNullBits0;
	}

	public void zSetIsNullBits0(byte newValue)
	{
		this.isNullBits0 = newValue;
	}

	public boolean _isAccountIdSet;
	public boolean zGetIsAccountIdSet()
	{
		return _isAccountIdSet;
	}

	protected void copyInto(CustomerAccountData copy, boolean withRelationships)
	{
		copy.isNullBits0 = this.isNullBits0;
		copy.accountId = this.accountId;
		copy.accountName = this.accountName;
		copy.accountType = this.accountType;
		copy.areaId = this.areaId;
		copy.balance = this.balance;
		copy.customerId = this.customerId;
		copy._isAccountIdSet = this._isAccountIdSet;
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
		this.accountId = in.readInt();
		_isAccountIdSet = in.readBoolean();
		this.accountName = StringPool.getInstance().getOrAddToCache((String)in.readObject(), CustomerAccountFinder.isFullCache());
		this.accountType = StringPool.getInstance().getOrAddToCache((String)in.readObject(), CustomerAccountFinder.isFullCache());
		this.areaId = in.readInt();
		this.balance = in.readDouble();
		this.customerId = in.readInt();
	}

	public boolean hasSamePrimaryKeyIgnoringAsOfAttributes(MithraDataObject other)
	{
		if (this == other) return true;
		final CustomerAccountData otherData = (CustomerAccountData) other;
		if (getAccountId() != otherData.getAccountId())
		{
			return false;
		}

		return true;
	}

	public void zSerializePrimaryKey(ObjectOutput out) throws IOException
	{
		out.writeInt(this.accountId);
	}

	public void zDeserializePrimaryKey(ObjectInput in) throws IOException, ClassNotFoundException
	{
		this.accountId = in.readInt();
	}

	public void clearRelationships()
	{
		_relationships = null;
		clearAllDirectRefs();
	}

	public void clearAllDirectRefs()
	{
	}

	public Object getCustomer()
	{
		if (_relationships != null)
		{
			return _relationships[0];
		}

		return null;
	}

	public void setCustomer(Object related)
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
		final CustomerAccountData customerAccountData = (CustomerAccountData) newData;
		this.setAccountName(customerAccountData.getAccountName());
		this.setAccountType(customerAccountData.getAccountType());
		this.setAreaId(customerAccountData.getAreaId());
		if (customerAccountData.isAreaIdNull()) this.setAreaIdNull();
		this.setBalance(customerAccountData.getBalance());
		if (customerAccountData.isBalanceNull()) this.setBalanceNull();
		this.setCustomerId(customerAccountData.getCustomerId());
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
		final CustomerAccountData other = (CustomerAccountData) newData;
		if (!isAccountNameNull() ? !getAccountName().equals(other.getAccountName()) : !other.isAccountNameNull())
		{
			return true;
		}

		if (!isAccountTypeNull() ? !getAccountType().equals(other.getAccountType()) : !other.isAccountTypeNull())
		{
			return true;
		}

		if ( isAreaIdNull() != other.isAreaIdNull() || getAreaId() != other.getAreaId())
		{
			return true;
		}

		if ( isBalanceNull() != other.isBalanceNull() || Math.abs(getBalance() - other.getBalance()) > toleranceForFloatingPointFields)
		{
			return true;
		}

		if ( getCustomerId() != other.getCustomerId())
		{
			return true;
		}

		return false;
	}

	public MithraDataObject copy()
	{
		CustomerAccountData copy = new CustomerAccountData();
		this.copyInto(copy, true);
		return copy;
	}

	public MithraDataObject copy(boolean withRelationships)
	{
		CustomerAccountData copy = new CustomerAccountData();
		this.copyInto(copy, withRelationships);
		return copy;
	}

	public String zGetPrintablePrimaryKey()
	{
		String result = "";
		result += "accountId: "+(""+getAccountId())+ " / ";
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
		return "com.folio_sec.example.domain.simplebank.CustomerAccountData";
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
		return CustomerAccountFinder.getMithraObjectPortal();
	}

	public MithraObjectPortal zGetMithraObjectPortal()
	{
		return CustomerAccountFinder.getMithraObjectPortal();
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
		return "com.folio_sec.example.domain.simplebank.CustomerAccountData";
	}
}
