package com.folio_sec.example.domain.simplebank;
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
import com.gs.collections.impl.map.mutable.UnifiedMap;
import java.io.Serializable;
/**
* This file was automatically generated using Mithra 16.5.1. Please do not modify it.
* Add custom logic to its subclass instead.
*/
public class CustomerAccountFinder
{
	private static final String IMPL_CLASS_NAME_WITH_SLASHES = "com/folio_sec/example/domain/simplebank/CustomerAccount";
	private static final String BUSINESS_CLASS_NAME_WITH_DOTS = "com.folio_sec.example.domain.simplebank.CustomerAccount";
	private static final FinderMethodMap finderMethodMap;
	private static boolean isFullCache;
	private static boolean isOffHeap;
	private static volatile MithraObjectPortal objectPortal = new UninitializedPortal("com.folio_sec.example.domain.simplebank.CustomerAccount");
	private static final CustomerAccountSingleFinder<CustomerAccount, Object, CustomerAccount> finder = new CustomerAccountSingleFinder<CustomerAccount, Object, CustomerAccount>();
	private static ConstantStringSet[] constantStringSets = new ConstantStringSet[0];
	private static ConstantIntSet[] constantIntSets = new ConstantIntSet[0];
	private static ConstantShortSet[] constantShortSets = new ConstantShortSet[0];
	static
	{
		finderMethodMap = new FinderMethodMap(CustomerAccountFinder.CustomerAccountRelatedFinder.class);
		finderMethodMap.addNormalAttributeName("accountId");
		finderMethodMap.addNormalAttributeName("customerId");
		finderMethodMap.addNormalAttributeName("accountName");
		finderMethodMap.addNormalAttributeName("accountType");
		finderMethodMap.addNormalAttributeName("areaId");
		finderMethodMap.addNormalAttributeName("balance");
		finderMethodMap.addRelationshipName("customer");
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

	public static CustomerAccount findOne(com.gs.fw.finder.Operation operation)
	{
		return findOne(operation, false);
	}

	public static CustomerAccount findOneBypassCache(com.gs.fw.finder.Operation operation)
	{
		return findOne(operation, true);
	}

	public static CustomerAccountList findMany(com.gs.fw.finder.Operation operation)
	{
		return (CustomerAccountList) finder.findMany(operation);
	}

	public static CustomerAccountList findManyBypassCache(com.gs.fw.finder.Operation operation)
	{
		return (CustomerAccountList) finder.findManyBypassCache(operation);
	}

	private static CustomerAccount findOne(com.gs.fw.finder.Operation operation, boolean bypassCache)
	{
		List found = getMithraObjectPortal().find((Operation) operation, bypassCache);
		return (CustomerAccount) FinderUtils.findOne(found);
	}

	public static CustomerAccount findByPrimaryKey(int accountId)
	{
		return finder.findByPrimaryKey(accountId);
	}

	private static final RelationshipHashStrategy forPrimaryKey = new PrimaryKeyRhs();
	private static final class PrimaryKeyRhs implements RelationshipHashStrategy
	{
		public boolean equalsForRelationship(Object _srcObject, Object _srcData, Object _targetData, Timestamp _asOfDate0, Timestamp _asOfDate1)
		{
			I3O3L3 _bean = (I3O3L3) _srcData;
			CustomerAccountData _castedTargetData = (CustomerAccountData) _targetData;
			if (_bean.getI1AsInteger() == _castedTargetData.getAccountId())
			{
				return true;
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

	public static CustomerAccount zFindOneForRelationship(Operation operation)
	{
		List found = getMithraObjectPortal().findAsCachedQuery(operation, null, false, true, 0).getResult();
		return (CustomerAccount) FinderUtils.findOne(found);
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

	public static class CustomerAccountRelatedFinder<ParentOwnerType, ReturnType, ReturnListType extends List, OwnerType> extends AbstractRelatedFinder<CustomerAccount, ParentOwnerType, ReturnType, ReturnListType, OwnerType>
	{
		private List<RelatedFinder> relationshipFinders;
		private List<RelatedFinder> dependentRelationshipFinders;
		private IntegerAttribute<ParentOwnerType> accountId;
		private IntegerAttribute<ParentOwnerType> customerId;
		private StringAttribute<ParentOwnerType> accountName;
		private StringAttribute<ParentOwnerType> accountType;
		private IntegerAttribute<ParentOwnerType> areaId;
		private DoubleAttribute<ParentOwnerType> balance;
		private CustomerAccountCustomerFinderSubclass<ParentOwnerType> customer;
		public CustomerAccountRelatedFinder()
		{
			super();
		}

		public CustomerAccountRelatedFinder(Mapper mapper)
		{
			super(mapper);
		}

		public String getFinderClassName()
		{
			return "com.folio_sec.example.domain.simplebank.CustomerAccountFinder";
		}

		public RelatedFinder getRelationshipFinderByName(String relationshipName)
		{
			return CustomerAccountFinder.finderMethodMap.getRelationshipFinderByName(relationshipName, this);
		}

		public Attribute getAttributeByName(String attributeName)
		{
			return CustomerAccountFinder.finderMethodMap.getAttributeByName(attributeName, this);
		}

		public com.gs.collections.api.block.function.Function getAttributeOrRelationshipSelector(String attributeName)
		{
			return CustomerAccountFinder.finderMethodMap.getAttributeOrRelationshipSelectorFunction(attributeName, this);
		}

		public Attribute[] getPersistentAttributes()
		{
			Attribute[] attributes = new Attribute[6];
			attributes[0] = this.accountId();
			attributes[1] = this.customerId();
			attributes[2] = this.accountName();
			attributes[3] = this.accountType();
			attributes[4] = this.areaId();
			attributes[5] = this.balance();
			return attributes;
		}

		public List<RelatedFinder> getRelationshipFinders()
		{
			if (relationshipFinders == null)
			{
				List<RelatedFinder> relatedFinders = new ArrayList<RelatedFinder>(1);
				relatedFinders.add(this.customer());
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

		public CustomerAccount findOne(com.gs.fw.finder.Operation operation)
		{
			return CustomerAccountFinder.findOne(operation, false);
		}

		public CustomerAccount findOneBypassCache(com.gs.fw.finder.Operation operation)
		{
			return CustomerAccountFinder.findOne(operation, true);
		}

		public MithraList<? extends CustomerAccount> findMany(com.gs.fw.finder.Operation operation)
		{
			return new CustomerAccountList((Operation) operation);
		}

		public MithraList<? extends CustomerAccount> findManyBypassCache(com.gs.fw.finder.Operation operation)
		{
			CustomerAccountList result = (CustomerAccountList) this.findMany(operation);
			result.setBypassCache(true);
			return result;
		}

		public MithraList<? extends CustomerAccount> constructEmptyList()
		{
			return new CustomerAccountList();
		}

		public int getSerialVersionId()
		{
			return -18120473;
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

		public IntegerAttribute<ParentOwnerType> accountId()
		{
			IntegerAttribute<ParentOwnerType> result = this.accountId;
			if (result == null)
			{
				result = mapper == null ? SingleColumnIntegerAttribute.generate("ACCOUNT_ID","","accountId",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,false,false,this,null,true,false,false,-1,-1,-1,false, false) :
					new MappedIntegerAttribute(CustomerAccountFinder.accountId(), this.mapper, this.zGetValueSelector());
				this.accountId = result;
			}

			return result;
		}

		public IntegerAttribute<ParentOwnerType> customerId()
		{
			IntegerAttribute<ParentOwnerType> result = this.customerId;
			if (result == null)
			{
				result = mapper == null ? SingleColumnIntegerAttribute.generate("CUSTOMER_ID","","customerId",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,false,false,this,null,true,false,false,-1,-1,-1,false, false) :
					new MappedIntegerAttribute(CustomerAccountFinder.customerId(), this.mapper, this.zGetValueSelector());
				result.zSetOwningRelationship("customer");
				result.zSetOwningReverseRelationship("com.folio_sec.example.domain.simplebank", "Customer", "accounts");
				this.customerId = result;
			}

			return result;
		}

		public StringAttribute<ParentOwnerType> accountName()
		{
			StringAttribute<ParentOwnerType> result = this.accountName;
			if (result == null)
			{
				result = mapper == null ? SingleColumnStringAttribute.generate("ACCOUNT_NAME","","accountName",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,false,false,this,null,true,false,-1,-1,-1,48,true, false) :
					new MappedStringAttribute(CustomerAccountFinder.accountName(), this.mapper, this.zGetValueSelector());
				this.accountName = result;
			}

			return result;
		}

		public StringAttribute<ParentOwnerType> accountType()
		{
			StringAttribute<ParentOwnerType> result = this.accountType;
			if (result == null)
			{
				result = mapper == null ? SingleColumnStringAttribute.generate("ACCOUNT_TYPE","","accountType",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,false,false,this,null,true,false,-1,-1,-1,16,true, false) :
					new MappedStringAttribute(CustomerAccountFinder.accountType(), this.mapper, this.zGetValueSelector());
				this.accountType = result;
			}

			return result;
		}

		public IntegerAttribute<ParentOwnerType> areaId()
		{
			IntegerAttribute<ParentOwnerType> result = this.areaId;
			if (result == null)
			{
				result = mapper == null ? SingleColumnIntegerAttribute.generate("AREA_ID","","areaId",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,true,false,this,null,true,false,false,-1,-1,-1,false, false) :
					new MappedIntegerAttribute(CustomerAccountFinder.areaId(), this.mapper, this.zGetValueSelector());
				this.areaId = result;
			}

			return result;
		}

		public DoubleAttribute<ParentOwnerType> balance()
		{
			DoubleAttribute<ParentOwnerType> result = this.balance;
			if (result == null)
			{
				result = mapper == null ? SingleColumnDoubleAttribute.generate("BALANCE","","balance",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,true,false,this,null,true,false,-1,-1,-1, false) :
					new MappedDoubleAttribute(CustomerAccountFinder.balance(), this.mapper, this.zGetValueSelector());
				this.balance = result;
			}

			return result;
		}

		public CustomerFinder.CustomerSingleFinderForRelatedClasses<ParentOwnerType, Customer, CustomerAccount> customer()
		{
			CustomerAccountCustomerFinderSubclass<ParentOwnerType> result = this.customer;
			if (result == null)
			{
				Mapper newMapper = combineWithMapperIfExists(CustomerFinder.zGetCustomerAccountsMapper());
				newMapper.setToMany(false);
				result = new CustomerAccountCustomerFinderSubclass<ParentOwnerType>(newMapper , this.zGetValueSelector() );
				this.customer = result;
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
			return CustomerAccountFinder.getPrimaryKeyAttributes();
		}

		public VersionAttribute getVersionAttribute()
		{
			return null;
		}

		public MithraObjectPortal getMithraObjectPortal()
		{
			return CustomerAccountFinder.getMithraObjectPortal();
		}
	}

	public static class CustomerAccountCollectionFinder<ParentOwnerType, ReturnType extends List, OwnerType> extends CustomerAccountRelatedFinder<ParentOwnerType, ReturnType, CustomerAccountList, OwnerType>
	{
		public CustomerAccountCollectionFinder(Mapper mapper)
		{
			super(mapper);
		}
	}

	public static abstract class CustomerAccountCollectionFinderForRelatedClasses<ParentOwnerType, ReturnType extends List, OwnerType>
	extends CustomerAccountCollectionFinder<ParentOwnerType, ReturnType, OwnerType>
	implements DeepRelationshipAttribute<ParentOwnerType, ReturnType>
	{
		public CustomerAccountCollectionFinderForRelatedClasses(Mapper mapper)
		{
			super(mapper);
		}

		protected NormalAndListValueSelector zGetValueSelector()
		{
			return this;
		}
	}

	public static class CustomerAccountSingleFinder<ParentOwnerType, ReturnType, OwnerType> extends CustomerAccountRelatedFinder<ParentOwnerType, ReturnType, CustomerAccountList, OwnerType>
	implements ToOneFinder
	{
		public CustomerAccountSingleFinder(Mapper mapper)
		{
			super(mapper);
		}

		public CustomerAccountSingleFinder()
		{
			super(null);
		}

		public Operation eq(CustomerAccount other)
		{
			return this.accountId().eq(other.getAccountId())
			;
		}
		// this implementation uses private API. Do NOT copy to application code. Application code must use normal operations for lookups.
		public CustomerAccount findByPrimaryKey(int accountId)
		{
			CustomerAccount _result = null;
			Operation _op = null;
			Object _related = null;
			{
				I3O3L3 _bean = I3O3L3.POOL.getOrConstruct();
				_bean.setI1AsInteger(accountId);
				MithraObjectPortal _portal = this.getMithraObjectPortal();
				_related = _portal.getAsOneFromCacheForFind(_bean, _bean, forPrimaryKey, null, null);
				_bean.release();
			}

			if (!(_related instanceof NulledRelation)) _result = (CustomerAccount) _related;
			if (_related == null)
			{
				_op = this.accountId().eq(accountId);
			}

			if (_op != null)
			{
				_result = this.findOne(_op);
			}

			return _result;
		}
	}

	public static abstract class CustomerAccountSingleFinderForRelatedClasses<ParentOwnerType, ReturnType, OwnerType> extends CustomerAccountSingleFinder<ParentOwnerType, ReturnType, OwnerType> implements DeepRelationshipAttribute<ParentOwnerType, ReturnType>
	{
		public CustomerAccountSingleFinderForRelatedClasses(Mapper mapper)
		{
			super(mapper);
		}

		protected NormalAndListValueSelector zGetValueSelector()
		{
			return this;
		}
	}

	/** maps to CUSTOMER_ACCOUNT.ACCOUNT_ID **/
	public static IntegerAttribute<CustomerAccount> accountId()
	{
		return finder.accountId();
	}

	/** maps to CUSTOMER_ACCOUNT.CUSTOMER_ID **/
	public static IntegerAttribute<CustomerAccount> customerId()
	{
		return finder.customerId();
	}

	/** maps to CUSTOMER_ACCOUNT.ACCOUNT_NAME **/
	public static StringAttribute<CustomerAccount> accountName()
	{
		return finder.accountName();
	}

	/** maps to CUSTOMER_ACCOUNT.ACCOUNT_TYPE **/
	public static StringAttribute<CustomerAccount> accountType()
	{
		return finder.accountType();
	}

	/** maps to CUSTOMER_ACCOUNT.AREA_ID **/
	public static IntegerAttribute<CustomerAccount> areaId()
	{
		return finder.areaId();
	}

	/** maps to CUSTOMER_ACCOUNT.BALANCE **/
	public static DoubleAttribute<CustomerAccount> balance()
	{
		return finder.balance();
	}

	public static CustomerFinder.CustomerSingleFinderForRelatedClasses<CustomerAccount, Customer, CustomerAccount> customer()
	{
		return finder.customer();
	}

	public static class CustomerAccountCustomerFinderSubclass<ParentOwnerType> extends CustomerFinder.CustomerSingleFinderForRelatedClasses<ParentOwnerType, Customer, CustomerAccount>
	{
		public CustomerAccountCustomerFinderSubclass(Mapper mapper, NormalAndListValueSelector parentSelector )
		{
			super(mapper);
			this._parentSelector = (AbstractRelatedFinder) parentSelector;
			this._orderBy = null;
			this._type = SIMPLE_TO_ONE;
			this._name = "customer";
		}

		public DeepRelationshipAttribute copy()
		{
			return new CustomerAccountCustomerFinderSubclass(zGetMapper(), (NormalAndListValueSelector) this._parentSelector
			);
		}

		protected Customer plainValueOf(CustomerAccount _obj)
		{
			return _obj.getCustomer();
		}

		protected CustomerList plainListValueOf(Object _obj)
		{
			return ((CustomerAccountList)_obj).getCustomers();
		}
	}

	public static Operation eq(CustomerAccount other)
	{
		return finder.eq(other);
	}

	public static Operation all()
	{
		return new All(accountId());
	}

	public static CustomerAccountSingleFinder<CustomerAccount, Object, CustomerAccount> getFinderInstance()
	{
		return finder;
	}

	public static Attribute[] getPrimaryKeyAttributes()
	{
		return new Attribute[] 
		{
			accountId()
		}

		;
	}

	public static Attribute[] getImmutableAttributes()
	{
		return new Attribute[] 
		{
			accountId()
			, accountId()
		}

		;
	}

	public static AsOfAttribute[] getAsOfAttributes()
	{
		return null;
	}

	protected static void initializeIndicies(Cache cache)
	{
		cache.addIndex("0 Index", new Attribute[] 
		{
			customerId()
		}

		);
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

		portal.setParentFinders(new RelatedFinder[] 
		{
			CustomerFinder.getFinderInstance(),
		}

		);
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

		portal.setParentFinders(new RelatedFinder[] 
		{
			CustomerFinder.getFinderInstance(),
		}

		);
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

	public static com.gs.collections.api.block.function.Function getAttributeOrRelationshipSelector(String attributeName)
	{
		return finder.getAttributeOrRelationshipSelector(attributeName);
	}

	public static RelatedFinder getRelatedFinderByName(String relationshipName)
	{
		return finder.getRelationshipFinderByName(relationshipName);
	}

	public static DoubleAttribute[] zGetDoubleAttributes()
	{
		DoubleAttribute[] result = new DoubleAttribute[1];
		result[0] = balance();
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
		objectPortal = new UninitializedPortal("com.folio_sec.example.domain.simplebank.CustomerAccount");
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
