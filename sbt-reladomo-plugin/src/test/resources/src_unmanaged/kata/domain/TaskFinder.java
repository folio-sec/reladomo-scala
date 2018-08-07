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
import com.gs.fw.common.mithra.attribute.*;
import com.gs.fw.common.mithra.attribute.calculator.procedure.ObjectProcedure;
import com.gs.fw.common.mithra.behavior.txparticipation.*;
import com.gs.fw.common.mithra.cache.Cache;
import com.gs.fw.common.mithra.cache.bean.*;
import com.gs.fw.common.mithra.extractor.*;
import com.gs.fw.common.mithra.finder.*;
import com.gs.fw.common.mithra.finder.booleanop.*;
import com.gs.fw.common.mithra.finder.integer.*;
import com.gs.fw.common.mithra.finder.longop.*;
import com.gs.fw.common.mithra.finder.orderby.OrderBy;
import com.gs.fw.common.mithra.finder.string.*;
import com.gs.fw.common.mithra.extractor.NormalAndListValueSelector;
import com.gs.fw.common.mithra.list.NulledRelation;
import com.gs.fw.common.mithra.querycache.CachedQuery;
import com.gs.fw.common.mithra.querycache.QueryCache;
import com.gs.fw.common.mithra.portal.*;
import com.gs.fw.common.mithra.remote.*;
import com.gs.fw.common.mithra.transaction.MithraObjectPersister;
import com.gs.fw.common.mithra.util.TimestampPool;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import java.io.Serializable;
/**
* This file was automatically generated using Mithra 17.0.2. Please do not modify it.
* Add custom logic to its subclass instead.
*/
public class TaskFinder
{
	private static final Timestamp processingDateInfinity = TimestampPool.getInstance().getOrAddToCache(kata.util.TimestampProvider.getInfinityDate(), true);
	private static final Timestamp processingDateDefault = TimestampPool.getInstance().getOrAddToCache(kata.util.TimestampProvider.getInfinityDate(), true);
	private static final String IMPL_CLASS_NAME_WITH_SLASHES = "kata/domain/Task";
	private static final String BUSINESS_CLASS_NAME_WITH_DOTS = "kata.domain.Task";
	private static final FinderMethodMap finderMethodMap;
	private static boolean isFullCache;
	private static boolean isOffHeap;
	private static volatile MithraObjectPortal objectPortal = new UninitializedPortal("kata.domain.Task");
	private static final TaskSingleFinder<Task, Object, Task> finder = new TaskSingleFinder<Task, Object, Task>();
	private static ConstantStringSet[] constantStringSets = new ConstantStringSet[0];
	private static ConstantIntSet[] constantIntSets = new ConstantIntSet[0];
	private static ConstantShortSet[] constantShortSets = new ConstantShortSet[0];
	static
	{
		finderMethodMap = new FinderMethodMap(TaskFinder.TaskRelatedFinder.class);
		finderMethodMap.addNormalAttributeName("taskId");
		finderMethodMap.addNormalAttributeName("name");
		finderMethodMap.addNormalAttributeName("status");
		finderMethodMap.addNormalAttributeName("processingDateFrom");
		finderMethodMap.addNormalAttributeName("processingDateTo");
		finderMethodMap.addNormalAttributeName("processingDate");
	}

	public static Attribute[] allPersistentAttributes()
	{
		return finder.getPersistentAttributes();
	}

	public static List<RelatedFinder> allRelatedFinders()
	{
		return finder.getRelationshipFinders();
	}

	public static List<RelatedFinder> allDependentRelatedFinders()
	{
		return finder.getDependentRelationshipFinders();
	}

	public static ConstantStringSet zGetConstantStringSet(int index)
	{
		return constantStringSets[index];
	}

	public static ConstantIntSet zGetConstantIntSet(int index)
	{
		return constantIntSets[index];
	}

	public static ConstantShortSet zGetConstantShortSet(int index)
	{
		return constantShortSets[index];
	}

	public static SourceAttributeType getSourceAttributeType()
	{
		return null;
	}

	public static Task findOne(com.gs.fw.finder.Operation operation)
	{
		return findOne(operation, false);
	}

	public static Task findOneBypassCache(com.gs.fw.finder.Operation operation)
	{
		return findOne(operation, true);
	}

	public static TaskList findMany(com.gs.fw.finder.Operation operation)
	{
		return (TaskList) finder.findMany(operation);
	}

	public static TaskList findManyBypassCache(com.gs.fw.finder.Operation operation)
	{
		return (TaskList) finder.findManyBypassCache(operation);
	}

	private static Task findOne(com.gs.fw.finder.Operation operation, boolean bypassCache)
	{
		List found = getMithraObjectPortal().find((Operation) operation, bypassCache);
		return (Task) FinderUtils.findOne(found);
	}

	public static Task findByPrimaryKey(int taskId, Timestamp processingDate)
	{
		return finder.findByPrimaryKey(taskId, processingDate);
	}

	private static final RelationshipHashStrategy forPrimaryKey = new PrimaryKeyRhs();
	private static final class PrimaryKeyRhs implements RelationshipHashStrategy
	{
		public boolean equalsForRelationship(Object _srcObject, Object _srcData, Object _targetData, Timestamp _asOfDate0, Timestamp _asOfDate1)
		{
			I3O3L3 _bean = (I3O3L3) _srcData;
			TaskData _castedTargetData = (TaskData) _targetData;
			if (_bean.getI1AsInteger() == _castedTargetData.getTaskId())
			{
				return TaskFinder.processingDate().dataMatches(_castedTargetData, _asOfDate0);
			}

			return false;
		}

		public int computeHashCodeFromRelated(Object _srcObject, Object _srcData)
		{
			I3O3L3 _bean = (I3O3L3) _srcData;
			return HashUtil.hash(_bean.getI1AsInteger());
		}

		public int computeOffHeapHashCodeFromRelated(Object _srcObject, Object _srcData)
		{
			I3O3L3 _bean = (I3O3L3) _srcData;
			return HashUtil.hash(_bean.getI1AsInteger());
		}
	}

	public static Task zFindOneForRelationship(Operation operation)
	{
		List found = getMithraObjectPortal().findAsCachedQuery(operation, null, false, true, 0).getResult();
		return (Task) FinderUtils.findOne(found);
	}

	public static MithraObjectPortal getMithraObjectPortal()
	{
		return objectPortal.getInitializedPortal();
	}

	public static void clearQueryCache()
	{
		objectPortal.clearQueryCache();
	}

	public static void reloadCache()
	{
		objectPortal.reloadCache();
	}

	public static class TaskRelatedFinder<ParentOwnerType, ReturnType, ReturnListType extends List, OwnerType> extends AbstractRelatedFinder<Task, ParentOwnerType, ReturnType, ReturnListType, OwnerType>
	{
		private List<RelatedFinder> relationshipFinders;
		private List<RelatedFinder> dependentRelationshipFinders;
		private IntegerAttribute<ParentOwnerType> taskId;
		private StringAttribute<ParentOwnerType> name;
		private StringAttribute<ParentOwnerType> status;
		private TimestampAttribute<ParentOwnerType> processingDateFrom;
		private TimestampAttribute<ParentOwnerType> processingDateTo;
		private AsOfAttribute<ParentOwnerType> processingDate;
		private transient AsOfAttribute[] asOfAttributes;
		public synchronized AsOfAttribute[] getAsOfAttributes()
		{
			if (asOfAttributes == null)
			{
				asOfAttributes = new AsOfAttribute[1];
				asOfAttributes[0] = this.processingDate();
			}

			return this.asOfAttributes;
		}

		public TaskRelatedFinder()
		{
			super();
		}

		public TaskRelatedFinder(Mapper mapper)
		{
			super(mapper);
		}

		public String getFinderClassName()
		{
			return "kata.domain.TaskFinder";
		}

		public RelatedFinder getRelationshipFinderByName(String relationshipName)
		{
			return TaskFinder.finderMethodMap.getRelationshipFinderByName(relationshipName, this);
		}

		public Attribute getAttributeByName(String attributeName)
		{
			return TaskFinder.finderMethodMap.getAttributeByName(attributeName, this);
		}

		public com.gs.fw.common.mithra.extractor.Function getAttributeOrRelationshipSelector(String attributeName)
		{
			return TaskFinder.finderMethodMap.getAttributeOrRelationshipSelectorFunction(attributeName, this);
		}

		public Attribute[] getPersistentAttributes()
		{
			Attribute[] attributes = new Attribute[5];
			attributes[0] = this.taskId();
			attributes[1] = this.name();
			attributes[2] = this.status();
			attributes[3] = this.processingDateFrom();
			attributes[4] = this.processingDateTo();
			return attributes;
		}

		public List<RelatedFinder> getRelationshipFinders()
		{
			if (relationshipFinders == null)
			{
				List<RelatedFinder> relatedFinders = new ArrayList<RelatedFinder>(0);
				relationshipFinders = Collections.unmodifiableList(relatedFinders);
			}

			return relationshipFinders;
		}

		public List<RelatedFinder> getDependentRelationshipFinders()
		{
			if (dependentRelationshipFinders == null)
			{
				List<RelatedFinder> dependentRelatedFinders = new ArrayList<RelatedFinder>(0);
				dependentRelationshipFinders = Collections.unmodifiableList(dependentRelatedFinders);
			}

			return dependentRelationshipFinders;
		}

		public Task findOne(com.gs.fw.finder.Operation operation)
		{
			return TaskFinder.findOne(operation, false);
		}

		public Task findOneBypassCache(com.gs.fw.finder.Operation operation)
		{
			return TaskFinder.findOne(operation, true);
		}

		public MithraList<? extends Task> findMany(com.gs.fw.finder.Operation operation)
		{
			return new TaskList((Operation) operation);
		}

		public MithraList<? extends Task> findManyBypassCache(com.gs.fw.finder.Operation operation)
		{
			TaskList result = (TaskList) this.findMany(operation);
			result.setBypassCache(true);
			return result;
		}

		public MithraList<? extends Task> constructEmptyList()
		{
			return new TaskList();
		}

		public int getSerialVersionId()
		{
			return 1451591893;
		}

		public boolean isPure()
		{
			return false;
		}

		public boolean isTemporary()
		{
			return false;
		}

		public int getHierarchyDepth()
		{
			return 0;
		}

		public IntegerAttribute<ParentOwnerType> taskId()
		{
			IntegerAttribute<ParentOwnerType> result = this.taskId;
			if (result == null)
			{
				result = mapper == null ? SingleColumnIntegerAttribute.generate("TASK_ID","","taskId",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,false,false,this,null,true,false,false,-1,-1,-1,false, false) :
					new MappedIntegerAttribute(TaskFinder.taskId(), this.mapper, this.zGetValueSelector());
				this.taskId = result;
			}

			return result;
		}

		public StringAttribute<ParentOwnerType> name()
		{
			StringAttribute<ParentOwnerType> result = this.name;
			if (result == null)
			{
				result = mapper == null ? SingleColumnStringAttribute.generate("NAME","","name",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,false,false,this,null,true,false,-1,-1,-1,64,true, false) :
					new MappedStringAttribute(TaskFinder.name(), this.mapper, this.zGetValueSelector());
				this.name = result;
			}

			return result;
		}

		public StringAttribute<ParentOwnerType> status()
		{
			StringAttribute<ParentOwnerType> result = this.status;
			if (result == null)
			{
				result = mapper == null ? SingleColumnStringAttribute.generate("STATUS","","status",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,false,false,this,null,true,false,-1,-1,-1,32,true, false) :
					new MappedStringAttribute(TaskFinder.status(), this.mapper, this.zGetValueSelector());
				this.status = result;
			}

			return result;
		}

		public TimestampAttribute<ParentOwnerType> processingDateFrom()
		{
			TimestampAttribute<ParentOwnerType> result = this.processingDateFrom;
			if (result == null)
			{
				result = mapper == null ? SingleColumnTimestampAttribute.generate("IN_Z","","processingDateFrom",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,false,false,this,null,true,false,-1,-1,-1,TimestampAttribute.CONVERT_NONE,false,false,TaskFinder.processingDateInfinity, (byte) 0, false) :
					new MappedTimestampAttribute(TaskFinder.processingDateFrom(), this.mapper, this.zGetValueSelector());
				this.processingDateFrom = result;
			}

			return result;
		}

		public TimestampAttribute<ParentOwnerType> processingDateTo()
		{
			TimestampAttribute<ParentOwnerType> result = this.processingDateTo;
			if (result == null)
			{
				result = mapper == null ? SingleColumnTimestampAttribute.generate("OUT_Z","","processingDateTo",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,false,false,this,null,true,false,-1,-1,-1,TimestampAttribute.CONVERT_NONE,false,true,TaskFinder.processingDateInfinity, (byte) 0, false) :
					new MappedTimestampAttribute(TaskFinder.processingDateTo(), this.mapper, this.zGetValueSelector());
				this.processingDateTo = result;
			}

			return result;
		}

		public AsOfAttribute<ParentOwnerType> processingDate()
		{
			AsOfAttribute<ParentOwnerType> result = this.processingDate;
			if (result == null)
			{
				result = mapper == null ? AsOfAttribute.generate("processingDate",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,false,false,this,null,true,false,this.processingDateFrom(),this.processingDateTo(),TaskFinder.processingDateInfinity,false,false,TaskFinder.processingDateDefault,true,false) :
					new MappedAsOfAttribute(TaskFinder.processingDate(), this.mapper, this.zGetValueSelector());
				this.processingDate = result;
			}

			return result;
		}

		public Attribute getSourceAttribute()
		{
			return null;
		}

		private Mapper combineWithMapperIfExists(Mapper newMapper)
		{
			if (this.mapper != null)
			{
				return new LinkedMapper(this.mapper, newMapper);
			}

			return newMapper;
		}

		public Attribute[] getPrimaryKeyAttributes()
		{
			return TaskFinder.getPrimaryKeyAttributes();
		}

		public VersionAttribute getVersionAttribute()
		{
			return null;
		}

		public MithraObjectPortal getMithraObjectPortal()
		{
			return TaskFinder.getMithraObjectPortal();
		}
	}

	public static class TaskCollectionFinder<ParentOwnerType, ReturnType extends List, OwnerType> extends TaskRelatedFinder<ParentOwnerType, ReturnType, TaskList, OwnerType>
	{
		public TaskCollectionFinder(Mapper mapper)
		{
			super(mapper);
		}
	}

	public static abstract class TaskCollectionFinderForRelatedClasses<ParentOwnerType, ReturnType extends List, OwnerType>
	extends TaskCollectionFinder<ParentOwnerType, ReturnType, OwnerType>
	implements DeepRelationshipAttribute<ParentOwnerType, ReturnType>
	{
		public TaskCollectionFinderForRelatedClasses(Mapper mapper)
		{
			super(mapper);
		}

		protected NormalAndListValueSelector zGetValueSelector()
		{
			return this;
		}
	}

	public static class TaskSingleFinder<ParentOwnerType, ReturnType, OwnerType> extends TaskRelatedFinder<ParentOwnerType, ReturnType, TaskList, OwnerType>
	implements ToOneFinder
	{
		public TaskSingleFinder(Mapper mapper)
		{
			super(mapper);
		}

		public TaskSingleFinder()
		{
			super(null);
		}

		public Operation eq(Task other)
		{
			return this.taskId().eq(other.getTaskId())
			;
		}
		// this implementation uses private API. Do NOT copy to application code. Application code must use normal operations for lookups.
		public Task findByPrimaryKey(int taskId, Timestamp processingDate)
		{
			Task _result = null;
			Operation _op = null;
			Object _related = null;
			{
				I3O3L3 _bean = I3O3L3.POOL.getOrConstruct();
				_bean.setI1AsInteger(taskId);
				MithraObjectPortal _portal = this.getMithraObjectPortal();
				_related = _portal.getAsOneFromCacheForFind(_bean, _bean, forPrimaryKey, processingDate, null);
				_bean.release();
			}

			if (!(_related instanceof NulledRelation)) _result = (Task) _related;
			if (_related == null)
			{
				_op = this.taskId().eq(taskId).and(this.processingDate().eq(processingDate));
			}

			if (_op != null)
			{
				_result = this.findOne(_op);
			}

			return _result;
		}
	}

	public static abstract class TaskSingleFinderForRelatedClasses<ParentOwnerType, ReturnType, OwnerType> extends TaskSingleFinder<ParentOwnerType, ReturnType, OwnerType> implements DeepRelationshipAttribute<ParentOwnerType, ReturnType>
	{
		public TaskSingleFinderForRelatedClasses(Mapper mapper)
		{
			super(mapper);
		}

		protected NormalAndListValueSelector zGetValueSelector()
		{
			return this;
		}
	}

	/** maps to TASK.TASK_ID **/
	public static IntegerAttribute<Task> taskId()
	{
		return finder.taskId();
	}

	/** maps to TASK.NAME **/
	public static StringAttribute<Task> name()
	{
		return finder.name();
	}

	/** maps to TASK.STATUS **/
	public static StringAttribute<Task> status()
	{
		return finder.status();
	}

	/** maps to TASK.IN_Z **/
	public static TimestampAttribute<Task> processingDateFrom()
	{
		return finder.processingDateFrom();
	}

	/** maps to TASK.OUT_Z **/
	public static TimestampAttribute<Task> processingDateTo()
	{
		return finder.processingDateTo();
	}

	public static AsOfAttribute<Task> processingDate()
	{
		return finder.processingDate();
	}

	public static Operation eq(Task other)
	{
		return finder.eq(other);
	}

	public static Operation all()
	{
		return new All(taskId());
	}

	public static TaskSingleFinder<Task, Object, Task> getFinderInstance()
	{
		return finder;
	}

	public static Attribute[] getPrimaryKeyAttributes()
	{
		return new Attribute[] 
		{
			taskId()
		}

		;
	}

	public static Attribute[] getImmutableAttributes()
	{
		return new Attribute[] 
		{
			taskId()
			, taskId()
		}

		;
	}

	public static AsOfAttribute[] getAsOfAttributes()
	{
		return new AsOfAttribute[] 
		{
			processingDate()
		}

		;
	}

	protected static void initializeIndicies(Cache cache)
	{
	}

	protected static void initializePortal(MithraObjectDeserializer objectFactory, Cache cache,
		MithraConfigurationManager.Config config)
	{
		initializeIndicies(cache);
		isFullCache = cache.isFullCache();
		isOffHeap = cache.isOffHeap();
		MithraObjectPortal portal;
		if (config.isParticipatingInTx())
		{
			portal = new MithraTransactionalPortal(objectFactory, cache, getFinderInstance(),
				config.getRelationshipCacheSize(), config.getMinQueriesToKeep(), null,
				null, null, 0,
				(MithraObjectPersister) objectFactory);
		}
		else
		{
			portal = new MithraReadOnlyPortal(objectFactory, cache, getFinderInstance(),
				config.getRelationshipCacheSize(), config.getMinQueriesToKeep(), null,
				null, null, 0,
				(MithraObjectPersister) objectFactory);
		}

		portal.setIndependent(true);
		config.initializePortal(portal);
		objectPortal.destroy();
		objectPortal = portal;
	}

	protected static void initializeClientPortal(MithraObjectDeserializer objectFactory, Cache cache,
		MithraConfigurationManager.Config config)
	{
		initializeIndicies(cache);
		isFullCache = cache.isFullCache();
		isOffHeap = cache.isOffHeap();
		MithraObjectPortal portal;
		if (config.isParticipatingInTx())
		{
			portal = new MithraTransactionalPortal(objectFactory, cache, getFinderInstance(),
				config.getRelationshipCacheSize(), config.getMinQueriesToKeep(),
				null, null,
				null, 0,
				new RemoteMithraObjectPersister(config.getRemoteMithraService(), getFinderInstance(), true));
		}
		else
		{
			portal = new MithraReadOnlyPortal(objectFactory, cache, getFinderInstance(),
				config.getRelationshipCacheSize(), config.getMinQueriesToKeep(),
				null, null,
				null, 0,
				new RemoteMithraObjectPersister(config.getRemoteMithraService(), getFinderInstance(), true));
		}

		portal.setIndependent(true);
		config.initializePortal(portal);
		objectPortal.destroy();
		objectPortal = portal;
	}

	public static boolean isFullCache()
	{
		return isFullCache;
	}

	public static boolean isOffHeap()
	{
		return isOffHeap;
	}

	public static Attribute getAttributeByName(String attributeName)
	{
		return finder.getAttributeByName(attributeName);
	}

	public static com.gs.fw.common.mithra.extractor.Function getAttributeOrRelationshipSelector(String attributeName)
	{
		return finder.getAttributeOrRelationshipSelector(attributeName);
	}

	public static RelatedFinder getRelatedFinderByName(String relationshipName)
	{
		return finder.getRelationshipFinderByName(relationshipName);
	}

	public static DoubleAttribute[] zGetDoubleAttributes()
	{
		DoubleAttribute[] result = new DoubleAttribute[0];
		return result;
	}

	public static BigDecimalAttribute[] zGetBigDecimalAttributes()
	{
		BigDecimalAttribute[] result = new BigDecimalAttribute[0];
		return result;
	}

	public static void zResetPortal()
	{
		objectPortal.destroy();
		objectPortal = new UninitializedPortal("kata.domain.Task");
		isFullCache = false;
		isOffHeap = false;
	}

	public static void setTransactionModeFullTransactionParticipation(MithraTransaction tx)
	{
		tx.setTxParticipationMode(objectPortal, FullTransactionalParticipationMode.getInstance());
	}

	public static void setTransactionModeReadCacheWithOptimisticLocking(MithraTransaction tx)
	{
		tx.setTxParticipationMode(objectPortal, ReadCacheWithOptimisticLockingTxParticipationMode.getInstance());
	}

	public static void registerForNotification(MithraApplicationClassLevelNotificationListener listener)
	{
		getMithraObjectPortal().registerForApplicationClassLevelNotification(listener);
	}
}
