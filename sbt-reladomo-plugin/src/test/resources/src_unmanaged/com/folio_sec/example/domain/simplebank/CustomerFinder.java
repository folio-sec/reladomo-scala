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
* This file was automatically generated using Mithra 16.7.0. Please do not modify it.
* Add custom logic to its subclass instead.
*/
public class CustomerFinder
{
	private static final String IMPL_CLASS_NAME_WITH_SLASHES = "com/folio_sec/example/domain/simplebank/Customer";
	private static final String BUSINESS_CLASS_NAME_WITH_DOTS = "com.folio_sec.example.domain.simplebank.Customer";
	private static final FinderMethodMap finderMethodMap;
	private static boolean isFullCache;
	private static boolean isOffHeap;
	private static volatile MithraObjectPortal objectPortal = new UninitializedPortal("com.folio_sec.example.domain.simplebank.Customer");
	private static final CustomerSingleFinder<Customer, Object, Customer> finder = new CustomerSingleFinder<Customer, Object, Customer>();
	private static ConstantStringSet[] constantStringSets = new ConstantStringSet[0];
	private static ConstantIntSet[] constantIntSets = new ConstantIntSet[0];
	private static ConstantShortSet[] constantShortSets = new ConstantShortSet[0];
	static
	{
		finderMethodMap = new FinderMethodMap(CustomerFinder.CustomerRelatedFinder.class);
		finderMethodMap.addNormalAttributeName("customerId");
		finderMethodMap.addNormalAttributeName("firstName");
		finderMethodMap.addNormalAttributeName("lastName");
		finderMethodMap.addNormalAttributeName("country");
		finderMethodMap.addNormalAttributeName("zipCode");
		finderMethodMap.addRelationshipName("accounts");
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

	public static Mapper zGetConstantJoin(int index)
	{
		return getConstantJoinPool()[index];
	}

	private static Mapper[] constantJoinPool;
	private static Mapper[] getConstantJoinPool()
	{
		if (constantJoinPool == null)
		{
			Mapper[] result = new Mapper[2];
			result[0] = CustomerFinder.customerId().constructEqualityMapper(CustomerAccountFinder.customerId());
			result[1] = CustomerAccountFinder.customerId().constructEqualityMapper(CustomerFinder.customerId());
			constantJoinPool = result;
		}

		return constantJoinPool;
	}

	public static SourceAttributeType getSourceAttributeType()
	{
		return null;
	}

	public static Customer findOne(com.gs.fw.finder.Operation operation)
	{
		return findOne(operation, false);
	}

	public static Customer findOneBypassCache(com.gs.fw.finder.Operation operation)
	{
		return findOne(operation, true);
	}

	public static CustomerList findMany(com.gs.fw.finder.Operation operation)
	{
		return (CustomerList) finder.findMany(operation);
	}

	public static CustomerList findManyBypassCache(com.gs.fw.finder.Operation operation)
	{
		return (CustomerList) finder.findManyBypassCache(operation);
	}

	private static Customer findOne(com.gs.fw.finder.Operation operation, boolean bypassCache)
	{
		List found = getMithraObjectPortal().find((Operation) operation, bypassCache);
		return (Customer) FinderUtils.findOne(found);
	}

	public static Customer findByPrimaryKey(int customerId)
	{
		return finder.findByPrimaryKey(customerId);
	}

	private static final RelationshipHashStrategy forPrimaryKey = new PrimaryKeyRhs();
	private static final class PrimaryKeyRhs implements RelationshipHashStrategy
	{
		public boolean equalsForRelationship(Object _srcObject, Object _srcData, Object _targetData, Timestamp _asOfDate0, Timestamp _asOfDate1)
		{
			I3O3L3 _bean = (I3O3L3) _srcData;
			CustomerData _castedTargetData = (CustomerData) _targetData;
			if (_bean.getI1AsInteger() == _castedTargetData.getCustomerId())
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

	public static Customer zFindOneForRelationship(Operation operation)
	{
		List found = getMithraObjectPortal().findAsCachedQuery(operation, null, false, true, 0).getResult();
		return (Customer) FinderUtils.findOne(found);
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

	public static class CustomerRelatedFinder<ParentOwnerType, ReturnType, ReturnListType extends List, OwnerType> extends AbstractRelatedFinder<Customer, ParentOwnerType, ReturnType, ReturnListType, OwnerType>
	{
		private List<RelatedFinder> relationshipFinders;
		private List<RelatedFinder> dependentRelationshipFinders;
		private IntegerAttribute<ParentOwnerType> customerId;
		private StringAttribute<ParentOwnerType> firstName;
		private StringAttribute<ParentOwnerType> lastName;
		private StringAttribute<ParentOwnerType> country;
		private IntegerAttribute<ParentOwnerType> zipCode;
		private CustomerAccountsFinderSubclass<ParentOwnerType> accounts;
		public CustomerRelatedFinder()
		{
			super();
		}

		public CustomerRelatedFinder(Mapper mapper)
		{
			super(mapper);
		}

		public String getFinderClassName()
		{
			return "com.folio_sec.example.domain.simplebank.CustomerFinder";
		}

		public RelatedFinder getRelationshipFinderByName(String relationshipName)
		{
			return CustomerFinder.finderMethodMap.getRelationshipFinderByName(relationshipName, this);
		}

		public Attribute getAttributeByName(String attributeName)
		{
			return CustomerFinder.finderMethodMap.getAttributeByName(attributeName, this);
		}

		public com.gs.collections.api.block.function.Function getAttributeOrRelationshipSelector(String attributeName)
		{
			return CustomerFinder.finderMethodMap.getAttributeOrRelationshipSelectorFunction(attributeName, this);
		}

		public Attribute[] getPersistentAttributes()
		{
			Attribute[] attributes = new Attribute[5];
			attributes[0] = this.customerId();
			attributes[1] = this.firstName();
			attributes[2] = this.lastName();
			attributes[3] = this.country();
			attributes[4] = this.zipCode();
			return attributes;
		}

		public List<RelatedFinder> getRelationshipFinders()
		{
			if (relationshipFinders == null)
			{
				List<RelatedFinder> relatedFinders = new ArrayList<RelatedFinder>(1);
				relatedFinders.add(this.accounts());
				relationshipFinders = Collections.unmodifiableList(relatedFinders);
			}

			return relationshipFinders;
		}

		public List<RelatedFinder> getDependentRelationshipFinders()
		{
			if (dependentRelationshipFinders == null)
			{
				List<RelatedFinder> dependentRelatedFinders = new ArrayList<RelatedFinder>(1);
				dependentRelatedFinders.add(this.accounts());
				dependentRelationshipFinders = Collections.unmodifiableList(dependentRelatedFinders);
			}

			return dependentRelationshipFinders;
		}

		public Customer findOne(com.gs.fw.finder.Operation operation)
		{
			return CustomerFinder.findOne(operation, false);
		}

		public Customer findOneBypassCache(com.gs.fw.finder.Operation operation)
		{
			return CustomerFinder.findOne(operation, true);
		}

		public MithraList<? extends Customer> findMany(com.gs.fw.finder.Operation operation)
		{
			return new CustomerList((Operation) operation);
		}

		public MithraList<? extends Customer> findManyBypassCache(com.gs.fw.finder.Operation operation)
		{
			CustomerList result = (CustomerList) this.findMany(operation);
			result.setBypassCache(true);
			return result;
		}

		public MithraList<? extends Customer> constructEmptyList()
		{
			return new CustomerList();
		}

		public int getSerialVersionId()
		{
			return -1451762541;
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

		public IntegerAttribute<ParentOwnerType> customerId()
		{
			IntegerAttribute<ParentOwnerType> result = this.customerId;
			if (result == null)
			{
				result = mapper == null ? SingleColumnIntegerAttribute.generate("CUSTOMER_ID","","customerId",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,false,false,this,null,true,false,false,-1,-1,-1,false, false) :
					new MappedIntegerAttribute(CustomerFinder.customerId(), this.mapper, this.zGetValueSelector());
				this.customerId = result;
			}

			return result;
		}

		public StringAttribute<ParentOwnerType> firstName()
		{
			StringAttribute<ParentOwnerType> result = this.firstName;
			if (result == null)
			{
				result = mapper == null ? SingleColumnStringAttribute.generate("FIRST_NAME","","firstName",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,false,false,this,null,true,false,-1,-1,-1,64,true, false) :
					new MappedStringAttribute(CustomerFinder.firstName(), this.mapper, this.zGetValueSelector());
				this.firstName = result;
			}

			return result;
		}

		public StringAttribute<ParentOwnerType> lastName()
		{
			StringAttribute<ParentOwnerType> result = this.lastName;
			if (result == null)
			{
				result = mapper == null ? SingleColumnStringAttribute.generate("LAST_NAME","","lastName",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,false,false,this,null,true,false,-1,-1,-1,64,true, false) :
					new MappedStringAttribute(CustomerFinder.lastName(), this.mapper, this.zGetValueSelector());
				this.lastName = result;
			}

			return result;
		}

		public StringAttribute<ParentOwnerType> country()
		{
			StringAttribute<ParentOwnerType> result = this.country;
			if (result == null)
			{
				result = mapper == null ? SingleColumnStringAttribute.generate("COUNTRY","","country",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,true,false,this,null,true,false,-1,-1,-1,48,true, false) :
					new MappedStringAttribute(CustomerFinder.country(), this.mapper, this.zGetValueSelector());
				this.country = result;
			}

			return result;
		}

		public IntegerAttribute<ParentOwnerType> zipCode()
		{
			IntegerAttribute<ParentOwnerType> result = this.zipCode;
			if (result == null)
			{
				result = mapper == null ? SingleColumnIntegerAttribute.generate("ZIP_CODE","","zipCode",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,true,false,this,null,true,false,false,-1,-1,-1,false, false) :
					new MappedIntegerAttribute(CustomerFinder.zipCode(), this.mapper, this.zGetValueSelector());
				this.zipCode = result;
			}

			return result;
		}

		public CustomerAccountFinder.CustomerAccountCollectionFinderForRelatedClasses<ParentOwnerType, CustomerAccountList, Customer> accounts()
		{
			CustomerAccountsFinderSubclass<ParentOwnerType> result = this.accounts;
			if (result == null)
			{
				Mapper newMapper = combineWithMapperIfExists(CustomerFinder.zGetCustomerAccountsReverseMapper());
				newMapper.setToMany(true);
				result = new CustomerAccountsFinderSubclass<ParentOwnerType>(newMapper , this.zGetValueSelector() );
				this.accounts = result;
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
			return CustomerFinder.getPrimaryKeyAttributes();
		}

		public VersionAttribute getVersionAttribute()
		{
			return null;
		}

		public MithraObjectPortal getMithraObjectPortal()
		{
			return CustomerFinder.getMithraObjectPortal();
		}
	}

	public static class CustomerCollectionFinder<ParentOwnerType, ReturnType extends List, OwnerType> extends CustomerRelatedFinder<ParentOwnerType, ReturnType, CustomerList, OwnerType>
	{
		public CustomerCollectionFinder(Mapper mapper)
		{
			super(mapper);
		}
	}

	public static abstract class CustomerCollectionFinderForRelatedClasses<ParentOwnerType, ReturnType extends List, OwnerType>
	extends CustomerCollectionFinder<ParentOwnerType, ReturnType, OwnerType>
	implements DeepRelationshipAttribute<ParentOwnerType, ReturnType>
	{
		public CustomerCollectionFinderForRelatedClasses(Mapper mapper)
		{
			super(mapper);
		}

		protected NormalAndListValueSelector zGetValueSelector()
		{
			return this;
		}
	}

	public static class CustomerSingleFinder<ParentOwnerType, ReturnType, OwnerType> extends CustomerRelatedFinder<ParentOwnerType, ReturnType, CustomerList, OwnerType>
	implements ToOneFinder
	{
		public CustomerSingleFinder(Mapper mapper)
		{
			super(mapper);
		}

		public CustomerSingleFinder()
		{
			super(null);
		}

		public Operation eq(Customer other)
		{
			return this.customerId().eq(other.getCustomerId())
			;
		}
		// this implementation uses private API. Do NOT copy to application code. Application code must use normal operations for lookups.
		public Customer findByPrimaryKey(int customerId)
		{
			Customer _result = null;
			Operation _op = null;
			Object _related = null;
			{
				I3O3L3 _bean = I3O3L3.POOL.getOrConstruct();
				_bean.setI1AsInteger(customerId);
				MithraObjectPortal _portal = this.getMithraObjectPortal();
				_related = _portal.getAsOneFromCacheForFind(_bean, _bean, forPrimaryKey, null, null);
				_bean.release();
			}

			if (!(_related instanceof NulledRelation)) _result = (Customer) _related;
			if (_related == null)
			{
				_op = this.customerId().eq(customerId);
			}

			if (_op != null)
			{
				_result = this.findOne(_op);
			}

			return _result;
		}
	}

	public static abstract class CustomerSingleFinderForRelatedClasses<ParentOwnerType, ReturnType, OwnerType> extends CustomerSingleFinder<ParentOwnerType, ReturnType, OwnerType> implements DeepRelationshipAttribute<ParentOwnerType, ReturnType>
	{
		public CustomerSingleFinderForRelatedClasses(Mapper mapper)
		{
			super(mapper);
		}

		protected NormalAndListValueSelector zGetValueSelector()
		{
			return this;
		}
	}

	private static Mapper accountsReverseMapper = null;
	public static Mapper zGetCustomerAccountsReverseMapper()
	{
		if (accountsReverseMapper == null)
		{
			accountsReverseMapper = zConstructCustomerAccountsReverseMapper();
		}

		return accountsReverseMapper;
	}

	private static Mapper accountsMapper = null;
	public static Mapper zGetCustomerAccountsMapper()
	{
		if (accountsMapper == null)
		{
			accountsMapper = zConstructCustomerAccountsMapper();
		}

		return accountsMapper;
	}

	private static Mapper accountsPureReverseMapper = null;
	public static Mapper zGetCustomerAccountsPureReverseMapper()
	{
		if (accountsPureReverseMapper == null)
		{
			accountsPureReverseMapper = zConstructCustomerAccountsPureReverseMapper();
		}

		return accountsPureReverseMapper;
	}

	private static Mapper zConstructCustomerAccountsPureReverseMapper()
	{
		Mapper accountsMapper = CustomerFinder.zGetConstantJoin(0);
		accountsMapper.setName("accounts");
		return accountsMapper;
	}

	private static Mapper zConstructCustomerAccountsReverseMapper()
	{
		Mapper accountsMapper = CustomerFinder.zGetConstantJoin(0);
		accountsMapper.setName("accounts");
		return accountsMapper;
	}

	private static Mapper zConstructCustomerAccountsMapper()
	{
		Mapper accountsMapper = CustomerFinder.zGetConstantJoin(1);
		accountsMapper.setName("customer");
		return accountsMapper;
	}

	/** maps to CUSTOMER.CUSTOMER_ID **/
	public static IntegerAttribute<Customer> customerId()
	{
		return finder.customerId();
	}

	/** maps to CUSTOMER.FIRST_NAME **/
	public static StringAttribute<Customer> firstName()
	{
		return finder.firstName();
	}

	/** maps to CUSTOMER.LAST_NAME **/
	public static StringAttribute<Customer> lastName()
	{
		return finder.lastName();
	}

	/** maps to CUSTOMER.COUNTRY **/
	public static StringAttribute<Customer> country()
	{
		return finder.country();
	}

	/** maps to CUSTOMER.ZIP_CODE **/
	public static IntegerAttribute<Customer> zipCode()
	{
		return finder.zipCode();
	}

	public static CustomerAccountFinder.CustomerAccountCollectionFinderForRelatedClasses<Customer, CustomerAccountList, Customer> accounts()
	{
		return finder.accounts();
	}

	public static class CustomerAccountsFinderSubclass<ParentOwnerType> extends CustomerAccountFinder.CustomerAccountCollectionFinderForRelatedClasses<ParentOwnerType, CustomerAccountList, Customer>
	{
		public CustomerAccountsFinderSubclass(Mapper mapper, NormalAndListValueSelector parentSelector )
		{
			super(mapper);
			this._parentSelector = (AbstractRelatedFinder) parentSelector;
			this._orderBy = null;
			this._type = SIMPLE_TO_MANY;
			this._name = "accounts";
		}

		public DeepRelationshipAttribute copy()
		{
			return new CustomerAccountsFinderSubclass(zGetMapper(), (NormalAndListValueSelector) this._parentSelector
			);
		}

		public boolean isModifiedSinceDetachment(MithraTransactionalObject _obj)
		{
			return ((Customer) _obj).isAccountsModifiedSinceDetachment();
		}

		protected CustomerAccountList plainValueOf(Customer _obj)
		{
			return _obj.getAccounts();
		}

		protected CustomerAccountList plainListValueOf(Object _obj)
		{
			return ((CustomerList)_obj).getAccounts();
		}
	}

	public static Operation eq(Customer other)
	{
		return finder.eq(other);
	}

	public static Operation all()
	{
		return new All(customerId());
	}

	public static CustomerSingleFinder<Customer, Object, Customer> getFinderInstance()
	{
		return finder;
	}

	public static Attribute[] getPrimaryKeyAttributes()
	{
		return new Attribute[] 
		{
			customerId()
		}

		;
	}

	public static Attribute[] getImmutableAttributes()
	{
		return new Attribute[] 
		{
			customerId()
			, customerId()
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
		objectPortal = new UninitializedPortal("com.folio_sec.example.domain.simplebank.Customer");
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
