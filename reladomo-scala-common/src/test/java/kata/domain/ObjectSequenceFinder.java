package kata.domain;

import com.gs.fw.common.mithra.MithraList;
import com.gs.fw.common.mithra.MithraObjectDeserializer;
import com.gs.fw.common.mithra.MithraObjectPortal;
import com.gs.fw.common.mithra.MithraTransaction;
import com.gs.fw.common.mithra.attribute.*;
import com.gs.fw.common.mithra.behavior.txparticipation.FullTransactionalParticipationMode;
import com.gs.fw.common.mithra.behavior.txparticipation.ReadCacheUpdateCausesRefreshAndLockTxParticipationMode;
import com.gs.fw.common.mithra.cache.Cache;
import com.gs.fw.common.mithra.cache.bean.I3O3L3;
import com.gs.fw.common.mithra.extractor.NormalAndListValueSelector;
import com.gs.fw.common.mithra.extractor.RelationshipHashStrategy;
import com.gs.fw.common.mithra.finder.*;
import com.gs.fw.common.mithra.list.NulledRelation;
import com.gs.fw.common.mithra.notification.listener.MithraApplicationClassLevelNotificationListener;
import com.gs.fw.common.mithra.portal.MithraReadOnlyPortal;
import com.gs.fw.common.mithra.portal.MithraTransactionalPortal;
import com.gs.fw.common.mithra.portal.UninitializedPortal;
import com.gs.fw.common.mithra.remote.RemoteMithraObjectPersister;
import com.gs.fw.common.mithra.transaction.MithraObjectPersister;
import com.gs.fw.common.mithra.util.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
* This file was automatically generated using Mithra 16.5.1. Please do not modify it.
* Add custom logic to its subclass instead.
*/
public class ObjectSequenceFinder
{
	private static final String IMPL_CLASS_NAME_WITH_SLASHES = "kata/domain/ObjectSequence";
	private static final String BUSINESS_CLASS_NAME_WITH_DOTS = "kata.domain.ObjectSequence";
	private static final FinderMethodMap finderMethodMap;
	private static boolean isFullCache;
	private static boolean isOffHeap;
	private static volatile MithraObjectPortal objectPortal = new UninitializedPortal("kata.domain.ObjectSequence");
	private static final ObjectSequenceSingleFinder<ObjectSequence, Object, ObjectSequence> finder = new ObjectSequenceSingleFinder<ObjectSequence, Object, ObjectSequence>();
	private static ConstantStringSet[] constantStringSets = new ConstantStringSet[0];
	private static ConstantIntSet[] constantIntSets = new ConstantIntSet[0];
	private static ConstantShortSet[] constantShortSets = new ConstantShortSet[0];
	static
	{
		finderMethodMap = new FinderMethodMap(ObjectSequenceFinder.ObjectSequenceRelatedFinder.class);
		finderMethodMap.addNormalAttributeName("simulatedSequenceName");
		finderMethodMap.addNormalAttributeName("nextValue");
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

	public static ObjectSequence findOne(com.gs.fw.finder.Operation operation)
	{
		return findOne(operation, false);
	}

	public static ObjectSequence findOneBypassCache(com.gs.fw.finder.Operation operation)
	{
		return findOne(operation, true);
	}

	public static ObjectSequenceList findMany(com.gs.fw.finder.Operation operation)
	{
		return (ObjectSequenceList) finder.findMany(operation);
	}

	public static ObjectSequenceList findManyBypassCache(com.gs.fw.finder.Operation operation)
	{
		return (ObjectSequenceList) finder.findManyBypassCache(operation);
	}

	private static ObjectSequence findOne(com.gs.fw.finder.Operation operation, boolean bypassCache)
	{
		List found = getMithraObjectPortal().find((Operation) operation, bypassCache);
		return (ObjectSequence) FinderUtils.findOne(found);
	}

	public static ObjectSequence findByPrimaryKey(String simulatedSequenceName)
	{
		return finder.findByPrimaryKey(simulatedSequenceName);
	}

	private static final RelationshipHashStrategy forPrimaryKey = new PrimaryKeyRhs();
	private static final class PrimaryKeyRhs implements RelationshipHashStrategy
	{
		public boolean equalsForRelationship(Object _srcObject, Object _srcData, Object _targetData, Timestamp _asOfDate0, Timestamp _asOfDate1)
		{
			I3O3L3 _bean = (I3O3L3) _srcData;
			ObjectSequenceData _castedTargetData = (ObjectSequenceData) _targetData;
			if (_bean.getO1AsString().equals(_castedTargetData.getSimulatedSequenceName()))
			{
				return true;
			}

			return false;
		}

		public int computeHashCodeFromRelated(Object _srcObject, Object _srcData)
		{
			I3O3L3 _bean = (I3O3L3) _srcData;
			return HashUtil.hash(_bean.getO1AsString());
		}

		public int computeOffHeapHashCodeFromRelated(Object _srcObject, Object _srcData)
		{
			I3O3L3 _bean = (I3O3L3) _srcData;
			return HashUtil.offHeapHash(_bean.getO1AsString());
		}
	}

	public static ObjectSequence zFindOneForRelationship(Operation operation)
	{
		List found = getMithraObjectPortal().findAsCachedQuery(operation, null, false, true, 0).getResult();
		return (ObjectSequence) FinderUtils.findOne(found);
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

	public static class ObjectSequenceRelatedFinder<ParentOwnerType, ReturnType, ReturnListType extends List, OwnerType> extends AbstractRelatedFinder<ObjectSequence, ParentOwnerType, ReturnType, ReturnListType, OwnerType>
	{
		private List<RelatedFinder> relationshipFinders;
		private List<RelatedFinder> dependentRelationshipFinders;
		private StringAttribute<ParentOwnerType> simulatedSequenceName;
		private LongAttribute<ParentOwnerType> nextValue;
		public ObjectSequenceRelatedFinder()
		{
			super();
		}

		public ObjectSequenceRelatedFinder(Mapper mapper)
		{
			super(mapper);
		}

		public String getFinderClassName()
		{
			return "kata.domain.ObjectSequenceFinder";
		}

		public RelatedFinder getRelationshipFinderByName(String relationshipName)
		{
			return ObjectSequenceFinder.finderMethodMap.getRelationshipFinderByName(relationshipName, this);
		}

		public Attribute getAttributeByName(String attributeName)
		{
			return ObjectSequenceFinder.finderMethodMap.getAttributeByName(attributeName, this);
		}

		public com.gs.fw.common.mithra.extractor.Function getAttributeOrRelationshipSelector(String attributeName)
		{
			return ObjectSequenceFinder.finderMethodMap.getAttributeOrRelationshipSelectorFunction(attributeName, this);
		}

		public Attribute[] getPersistentAttributes()
		{
			Attribute[] attributes = new Attribute[2];
			attributes[0] = this.simulatedSequenceName();
			attributes[1] = this.nextValue();
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

		public ObjectSequence findOne(com.gs.fw.finder.Operation operation)
		{
			return ObjectSequenceFinder.findOne(operation, false);
		}

		public ObjectSequence findOneBypassCache(com.gs.fw.finder.Operation operation)
		{
			return ObjectSequenceFinder.findOne(operation, true);
		}

		public MithraList<? extends ObjectSequence> findMany(com.gs.fw.finder.Operation operation)
		{
			return new ObjectSequenceList((Operation) operation);
		}

		public MithraList<? extends ObjectSequence> findManyBypassCache(com.gs.fw.finder.Operation operation)
		{
			ObjectSequenceList result = (ObjectSequenceList) this.findMany(operation);
			result.setBypassCache(true);
			return result;
		}

		public MithraList<? extends ObjectSequence> constructEmptyList()
		{
			return new ObjectSequenceList();
		}

		public int getSerialVersionId()
		{
			return 1409632274;
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

		public StringAttribute<ParentOwnerType> simulatedSequenceName()
		{
			StringAttribute<ParentOwnerType> result = this.simulatedSequenceName;
			if (result == null)
			{
				result = mapper == null ? SingleColumnStringAttribute.generate("SEQUENCE_NAME","","simulatedSequenceName",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,false,false,this,null,true,false,-1,-1,-1,64,true, false) :
					new MappedStringAttribute(ObjectSequenceFinder.simulatedSequenceName(), this.mapper, this.zGetValueSelector());
				this.simulatedSequenceName = result;
			}

			return result;
		}

		public LongAttribute<ParentOwnerType> nextValue()
		{
			LongAttribute<ParentOwnerType> result = this.nextValue;
			if (result == null)
			{
				result = mapper == null ? SingleColumnLongAttribute.generate("NEXT_VALUE","","nextValue",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,true,false,this,null,true,false,false,-1,-1,-1,false, false) :
					new MappedLongAttribute(ObjectSequenceFinder.nextValue(), this.mapper, this.zGetValueSelector());
				this.nextValue = result;
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
			return ObjectSequenceFinder.getPrimaryKeyAttributes();
		}

		public VersionAttribute getVersionAttribute()
		{
			return null;
		}

		public MithraObjectPortal getMithraObjectPortal()
		{
			return ObjectSequenceFinder.getMithraObjectPortal();
		}
	}

	public static class ObjectSequenceCollectionFinder<ParentOwnerType, ReturnType extends List, OwnerType> extends ObjectSequenceRelatedFinder<ParentOwnerType, ReturnType, ObjectSequenceList, OwnerType>
	{
		public ObjectSequenceCollectionFinder(Mapper mapper)
		{
			super(mapper);
		}
	}

	public static abstract class ObjectSequenceCollectionFinderForRelatedClasses<ParentOwnerType, ReturnType extends List, OwnerType>
	extends ObjectSequenceCollectionFinder<ParentOwnerType, ReturnType, OwnerType>
	implements DeepRelationshipAttribute<ParentOwnerType, ReturnType>
	{
		public ObjectSequenceCollectionFinderForRelatedClasses(Mapper mapper)
		{
			super(mapper);
		}

		protected NormalAndListValueSelector zGetValueSelector()
		{
			return this;
		}
	}

	public static class ObjectSequenceSingleFinder<ParentOwnerType, ReturnType, OwnerType> extends ObjectSequenceRelatedFinder<ParentOwnerType, ReturnType, ObjectSequenceList, OwnerType>
	implements ToOneFinder
	{
		public ObjectSequenceSingleFinder(Mapper mapper)
		{
			super(mapper);
		}

		public ObjectSequenceSingleFinder()
		{
			super(null);
		}

		public Operation eq(ObjectSequence other)
		{
			return this.simulatedSequenceName().eq(other.getSimulatedSequenceName())
			;
		}
		// this implementation uses private API. Do NOT copy to application code. Application code must use normal operations for lookups.
		public ObjectSequence findByPrimaryKey(String simulatedSequenceName)
		{
			ObjectSequence _result = null;
			Operation _op = null;
			Object _related = null;
			if (simulatedSequenceName != null)
			{
				I3O3L3 _bean = I3O3L3.POOL.getOrConstruct();
				_bean.setO1(simulatedSequenceName);
				MithraObjectPortal _portal = this.getMithraObjectPortal();
				_related = _portal.getAsOneFromCacheForFind(_bean, _bean, forPrimaryKey, null, null);
				_bean.release();
			}

			if (!(_related instanceof NulledRelation)) _result = (ObjectSequence) _related;
			if (_related == null)
			{
				_op = this.simulatedSequenceName().eq(simulatedSequenceName);
			}

			if (_op != null)
			{
				_result = this.findOne(_op);
			}

			return _result;
		}
	}

	public static abstract class ObjectSequenceSingleFinderForRelatedClasses<ParentOwnerType, ReturnType, OwnerType> extends ObjectSequenceSingleFinder<ParentOwnerType, ReturnType, OwnerType> implements DeepRelationshipAttribute<ParentOwnerType, ReturnType>
	{
		public ObjectSequenceSingleFinderForRelatedClasses(Mapper mapper)
		{
			super(mapper);
		}

		protected NormalAndListValueSelector zGetValueSelector()
		{
			return this;
		}
	}

	/** maps to OBJECT_SEQUENCE.SEQUENCE_NAME **/
	public static StringAttribute<ObjectSequence> simulatedSequenceName()
	{
		return finder.simulatedSequenceName();
	}

	/** maps to OBJECT_SEQUENCE.NEXT_VALUE **/
	public static LongAttribute<ObjectSequence> nextValue()
	{
		return finder.nextValue();
	}

	public static Operation eq(ObjectSequence other)
	{
		return finder.eq(other);
	}

	public static Operation all()
	{
		return new All(simulatedSequenceName());
	}

	public static ObjectSequenceSingleFinder<ObjectSequence, Object, ObjectSequence> getFinderInstance()
	{
		return finder;
	}

	public static Attribute[] getPrimaryKeyAttributes()
	{
		return new Attribute[] 
		{
			simulatedSequenceName()
		}

		;
	}

	public static Attribute[] getImmutableAttributes()
	{
		return new Attribute[] 
		{
			simulatedSequenceName()
			, simulatedSequenceName()
		}

		;
	}

	public static AsOfAttribute[] getAsOfAttributes()
	{
		return null;
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
				new RemoteMithraObjectPersister(config.getRemoteMithraService(), getFinderInstance(), false));
		}
		else
		{
			portal = new MithraReadOnlyPortal(objectFactory, cache, getFinderInstance(),
				config.getRelationshipCacheSize(), config.getMinQueriesToKeep(),
				null, null,
				null, 0,
				new RemoteMithraObjectPersister(config.getRemoteMithraService(), getFinderInstance(), false));
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
		objectPortal = new UninitializedPortal("kata.domain.ObjectSequence");
		isFullCache = false;
		isOffHeap = false;
	}

	public static void setTransactionModeFullTransactionParticipation(MithraTransaction tx)
	{
		tx.setTxParticipationMode(objectPortal, FullTransactionalParticipationMode.getInstance());
	}

	public static void setTransactionModeReadCacheUpdateCausesRefreshAndLock(MithraTransaction tx)
	{
		tx.setTxParticipationMode(objectPortal, ReadCacheUpdateCausesRefreshAndLockTxParticipationMode.getInstance());
	}

	public static void registerForNotification(MithraApplicationClassLevelNotificationListener listener)
	{
		getMithraObjectPortal().registerForApplicationClassLevelNotification(listener);
	}
}
