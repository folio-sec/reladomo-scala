package kata.domain;

import com.gs.collections.api.list.MutableList;
import com.gs.collections.impl.list.mutable.ListAdapter;
import com.gs.fw.common.mithra.MithraDatedTransactionalList;
import com.gs.fw.common.mithra.MithraObjectPortal;
import com.gs.fw.common.mithra.MithraTransactionalList;
import com.gs.fw.common.mithra.attribute.SequenceAttribute;
import com.gs.fw.common.mithra.finder.Operation;
import com.gs.fw.common.mithra.list.AbstractTransactionalNonOperationBasedList;
import com.gs.fw.common.mithra.list.AbstractTransactionalOperationBasedList;
import com.gs.fw.common.mithra.list.DelegatingList;
import com.gs.fw.common.mithra.list.merge.TopLevelMergeOptions;

import java.sql.Timestamp;
import java.util.Collection;

/**
* This file was automatically generated using Mithra 16.5.1. Please do not modify it.
* Add custom logic to its subclass instead.
*/
// Generated from templates/transactional/ListAbstract.jsp
public class TaskListAbstract extends DelegatingList<Task> implements MithraDatedTransactionalList<Task>
{
	public TaskListAbstract()
	{
		super();
		this.setDelegated(AbstractTransactionalNonOperationBasedList.DEFAULT);
		AbstractTransactionalNonOperationBasedList.DEFAULT.init(this);
	}

	public TaskListAbstract(int initialSize)
	{
		super();
		this.setDelegated(AbstractTransactionalNonOperationBasedList.DEFAULT);
		AbstractTransactionalNonOperationBasedList.DEFAULT.init(this, initialSize);
	}

	public TaskListAbstract(Collection c)
	{
		super();
		this.setDelegated(AbstractTransactionalNonOperationBasedList.DEFAULT);
		AbstractTransactionalNonOperationBasedList.DEFAULT.init(this, c);
	}

	public TaskListAbstract(com.gs.fw.finder.Operation operation)
	{
		super(operation);
		this.setDelegated(AbstractTransactionalOperationBasedList.DEFAULT);
	}

	public Task[] elements()
	{
		Task[] result = new Task[size()];
		this.getDelegated().toArray(this, result);
		return result;
	}

	public TaskList intersection(TaskList another)
	{
		return (TaskList)super.intersection(another);
	}

	public Task getTaskAt(int index)
	{
		return (Task)this.get(index);
	}

	public MithraObjectPortal getMithraObjectPortal()
	{
		return TaskFinder.getMithraObjectPortal();
	}

	public TaskList getNonPersistentCopy()
	{
		TaskList result = new TaskList();
		zCopyNonPersistentInto(result);
		return result;
	}

	public TaskList asAdhoc()
	{
		return (TaskList) super.asAdhoc();
	}

	public MithraDatedTransactionalList getNonPersistentGenericCopy()
	{
		return this.getNonPersistentCopy();
	}

	/**
	* Return a view of this list that implements GS Collections MutableList API.
	* Since the returned list will be operation-based, it is effectively read-only,
	* so mutating methods will throw a RuntimeException.
	* (Implemented by a light-weight adapter, not a copy)
	*/
	public MutableList<Task> asGscList()
	{
		return ListAdapter.adapt(this);
	}

	public TaskList merge(MithraTransactionalList<Task> incoming, TopLevelMergeOptions<Task> mergeOptions)
	{
		return (TaskList) super.merge(incoming, mergeOptions);
	}

	public TaskList getDetachedCopy()
	{
		TaskList result = new TaskList();
		zDetachInto(result);
		return result;
	}

	public void zMakeDetached(Operation op, Object previousDetachedList)
	{
		super.zMakeDetached(op, previousDetachedList);
	}

	protected void generateAndSetPrimaryKeys()
	{
		zGenerateAndSetPrimaryKeysForSingleSource((SequenceAttribute) TaskFinder.taskId(), false, "Task", "kata.util.ObjectSequenceObjectFactory", null);
	}

	public void setName(String newValue)
	{
		zSetString(TaskFinder.name(), newValue);
	}

	public void setProcessingDateFrom(Timestamp newValue)
	{
		zSetTimestamp(TaskFinder.processingDateFrom(), newValue);
	}

	public void setProcessingDateTo(Timestamp newValue)
	{
		zSetTimestamp(TaskFinder.processingDateTo(), newValue);
	}

	public void setStatus(String newValue)
	{
		zSetString(TaskFinder.status(), newValue);
	}

	public void setTaskId(int newValue)
	{
		zSetInteger(TaskFinder.taskId(), newValue);
	}

	public void purgeAll()
	{
		super.purgeAll();
	}

	public void terminateAll()
	{
		super.terminateAll();
	}
}
