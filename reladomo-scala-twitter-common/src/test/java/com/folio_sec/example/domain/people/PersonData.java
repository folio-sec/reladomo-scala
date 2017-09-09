/*
 * Copyright 2017 FOLIO Co.,Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.folio_sec.example.domain.people;
import java.util.*;
import java.sql.Timestamp;
import java.sql.Date;
import java.math.BigDecimal;
import java.util.*;
import java.sql.Timestamp;
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
* This file was automatically generated using Mithra 16.3.0. Please do not modify it.
* Add custom logic to its subclass instead.
*/
public class PersonData
implements MithraDataObject
{
	private String country;
	private String firstName;
	private String lastName;
	private int personId;
	public boolean isCountryNull()
	{
		return this.getCountry() == null;
	}

	public boolean isFirstNameNull()
	{
		return this.getFirstName() == null;
	}

	public boolean isLastNameNull()
	{
		return this.getLastName() == null;
	}

	public boolean isPersonIdNull()
	{
		return false;
	}

	public void zSerializeFullData(ObjectOutput out) throws IOException
	{
		zWriteNullBits(out);
		out.writeObject(this.country);
		out.writeObject(this.firstName);
		out.writeObject(this.lastName);
		out.writeInt(this.personId);
		out.writeBoolean(_isPersonIdSet);
	}

	private void zWriteNullBits(ObjectOutput out) throws IOException
	{
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
		this.country = StringPool.getInstance().getOrAddToCache(value, PersonFinder.isFullCache());
	}

	public void setCountryNull()
	{
		this.setCountry(null);
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
		this.firstName = StringPool.getInstance().getOrAddToCache(value, PersonFinder.isFullCache());
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
		this.lastName = StringPool.getInstance().getOrAddToCache(value, PersonFinder.isFullCache());
	}

	public void setLastNameNull()
	{
		this.setLastName(null);
	}

	public int getPersonId()
	{
		return this.personId;
	}

	public void setPersonId(int value)
	{
		this.personId = value;
		_isPersonIdSet = true;
	}

	public void setPersonIdNull()
	{
		throw new RuntimeException("should never be called");
	}

	public boolean _isPersonIdSet;
	public boolean zGetIsPersonIdSet()
	{
		return _isPersonIdSet;
	}

	protected void copyInto(PersonData copy, boolean withRelationships)
	{
		copy.country = this.country;
		copy.firstName = this.firstName;
		copy.lastName = this.lastName;
		copy.personId = this.personId;
		copy._isPersonIdSet = this._isPersonIdSet;
		if (withRelationships)
		{
		}
	}

	public void zDeserializeFullData(ObjectInput in) throws IOException, ClassNotFoundException
	{
		this.country = StringPool.getInstance().getOrAddToCache((String)in.readObject(), PersonFinder.isFullCache());
		this.firstName = StringPool.getInstance().getOrAddToCache((String)in.readObject(), PersonFinder.isFullCache());
		this.lastName = StringPool.getInstance().getOrAddToCache((String)in.readObject(), PersonFinder.isFullCache());
		this.personId = in.readInt();
		_isPersonIdSet = in.readBoolean();
	}

	public boolean hasSamePrimaryKeyIgnoringAsOfAttributes(MithraDataObject other)
	{
		if (this == other) return true;
		final PersonData otherData = (PersonData) other;
		if (getPersonId() != otherData.getPersonId())
		{
			return false;
		}

		return true;
	}

	public void zSerializePrimaryKey(ObjectOutput out) throws IOException
	{
		out.writeInt(this.personId);
	}

	public void zDeserializePrimaryKey(ObjectInput in) throws IOException, ClassNotFoundException
	{
		this.personId = in.readInt();
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
		final PersonData personData = (PersonData) newData;
		this.setCountry(personData.getCountry());
		this.setFirstName(personData.getFirstName());
		this.setLastName(personData.getLastName());
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
		final PersonData other = (PersonData) newData;
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

		return false;
	}

	public MithraDataObject copy()
	{
		PersonData copy = new PersonData();
		this.copyInto(copy, true);
		return copy;
	}

	public MithraDataObject copy(boolean withRelationships)
	{
		PersonData copy = new PersonData();
		this.copyInto(copy, withRelationships);
		return copy;
	}

	public String zGetPrintablePrimaryKey()
	{
		String result = "";
		result += "personId: "+(""+getPersonId())+ " / ";
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
		return "com.folio_sec.example.domain.people.PersonData";
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
		return PersonFinder.getMithraObjectPortal();
	}

	public MithraObjectPortal zGetMithraObjectPortal()
	{
		return PersonFinder.getMithraObjectPortal();
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
		return "com.folio_sec.example.domain.people.PersonData";
	}
}
