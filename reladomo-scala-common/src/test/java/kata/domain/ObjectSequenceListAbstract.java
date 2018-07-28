package kata.domain;

import com.gs.collections.api.list.MutableList;
import com.gs.fw.common.mithra.MithraObjectPortal;
import com.gs.fw.common.mithra.MithraTransactionalList;
import com.gs.fw.common.mithra.finder.Operation;
import com.gs.fw.common.mithra.list.AbstractTransactionalNonOperationBasedList;
import com.gs.fw.common.mithra.list.AbstractTransactionalOperationBasedList;
import com.gs.fw.common.mithra.list.DelegatingList;
import com.gs.fw.common.mithra.list.merge.TopLevelMergeOptions;

import java.util.Collection;

/**
* This file was automatically generated using Mithra 16.5.1. Please do not modify it.
* Add custom logic to its subclass instead.
*/
// Generated from templates/transactional/ListAbstract.jsp
public class ObjectSequenceListAbstract extends DelegatingList<ObjectSequence> implements MithraTransactionalList<ObjectSequence>
{
	public ObjectSequenceListAbstract()
	{
		super();
		this.setDelegated(AbstractTransactionalNonOperationBasedList.DEFAULT);
		AbstractTransactionalNonOperationBasedList.DEFAULT.init(this);
	}

	public ObjectSequenceListAbstract(int initialSize)
	{
		super();
		this.setDelegated(AbstractTransactionalNonOperationBasedList.DEFAULT);
		AbstractTransactionalNonOperationBasedList.DEFAULT.init(this, initialSize);
	}

	public ObjectSequenceListAbstract(Collection c)
	{
		super();
		this.setDelegated(AbstractTransactionalNonOperationBasedList.DEFAULT);
		AbstractTransactionalNonOperationBasedList.DEFAULT.init(this, c);
	}

	public ObjectSequenceListAbstract(com.gs.fw.finder.Operation operation)
	{
		super(operation);
		this.setDelegated(AbstractTransactionalOperationBasedList.DEFAULT);
	}

	public ObjectSequence[] elements()
	{
		ObjectSequence[] result = new ObjectSequence[size()];
		this.getDelegated().toArray(this, result);
		return result;
	}

	public ObjectSequenceList intersection(ObjectSequenceList another)
	{
		return (ObjectSequenceList)super.intersection(another);
	}

	public ObjectSequence getObjectSequenceAt(int index)
	{
		return (ObjectSequence)this.get(index);
	}

	public MithraObjectPortal getMithraObjectPortal()
	{
		return ObjectSequenceFinder.getMithraObjectPortal();
	}

	public ObjectSequenceList getNonPersistentCopy()
	{
		ObjectSequenceList result = new ObjectSequenceList();
		zCopyNonPersistentInto(result);
		return result;
	}

	public ObjectSequenceList asAdhoc()
	{
		return (ObjectSequenceList) super.asAdhoc();
	}

	public MithraTransactionalList getNonPersistentGenericCopy()
	{
		return this.getNonPersistentCopy();
	}

	public ObjectSequenceList merge(MithraTransactionalList<ObjectSequence> incoming, TopLevelMergeOptions<ObjectSequence> mergeOptions)
	{
		return (ObjectSequenceList) super.merge(incoming, mergeOptions);
	}

	public ObjectSequenceList getDetachedCopy()
	{
		ObjectSequenceList result = new ObjectSequenceList();
		zDetachInto(result);
		return result;
	}

	public void zMakeDetached(Operation op, Object previousDetachedList)
	{
		super.zMakeDetached(op, previousDetachedList);
	}

	public void setNextValue(long newValue)
	{
		zSetLong(ObjectSequenceFinder.nextValue(), newValue);
	}

	public void setSimulatedSequenceName(String newValue)
	{
		zSetString(ObjectSequenceFinder.simulatedSequenceName(), newValue);
	}

	public void setNextValueNull()
	{
		zSetAttributeNull(ObjectSequenceFinder.nextValue());
	}
}
