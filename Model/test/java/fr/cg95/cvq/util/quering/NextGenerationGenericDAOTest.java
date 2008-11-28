package fr.cg95.cvq.util.quering;

import java.text.ParseException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import junit.framework.Assert;

import org.springframework.context.ConfigurableApplicationContext;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.RequestAction;
import fr.cg95.cvq.dao.external.IExternalServiceTraceDAO;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.testtool.ServiceTestCase;
import fr.cg95.cvq.util.DateUtils;
import fr.cg95.cvq.util.quering.criterias.CompositeCriteria;
import fr.cg95.cvq.util.quering.criterias.CrossJoinCriteria;
import fr.cg95.cvq.util.quering.criterias.ISearchCriteria;
import fr.cg95.cvq.util.quering.criterias.InCriteria;
import fr.cg95.cvq.util.quering.criterias.SimpleCriteria;
import fr.cg95.cvq.util.quering.sort.SortCriteria;
import fr.cg95.cvq.util.quering.sort.SortDirection;

public class NextGenerationGenericDAOTest extends ServiceTestCase{
    protected ConfigurableApplicationContext context = null;
    protected IExternalServiceTraceDAO externalServiceTraceDAO = null;
    
    protected void initTestEnvironment(int testObjectCount) throws Exception {
        this.context = getContext(getConfigLocations());
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.ADMIN_CONTEXT);
                
        for(int i=0;i < testObjectCount; i++)
            this.gimmeAnHomeFolder();
        
        this.continueWithNewTransaction();
        
        this.externalServiceTraceDAO = (IExternalServiceTraceDAO) context.getBean("externalServiceTraceDAO");
    }
    
    public void testSelectQueries() throws Exception {
        //init
        try {
            int count = 5;
            this.initTestEnvironment(count);
            
            // Simplest select test
            Set<Long> ids = this.extractRequestIds();
            Assert.assertEquals(ids.size(), count);
            Set<Request> requests = this.extractRequestWithIn(ids);
            Assert.assertEquals(requests.size(), count);
            Assert.assertEquals(this.getCount(), count);
            
            // Cross join tests
            Assert.assertEquals(this.extractRequestIdsViaActions().size(), count);
            
            // Composite criterias
            Assert.assertEquals(this.realizeComplexIdsExtract(ids).size(), count);
            Assert.assertEquals(this.realizeExtractionWithDescriptor(ids).size(), count);
            Assert.assertEquals(this.realizeComplexIdsExtract2(ids).size(), count-1);
            Assert.assertEquals(this.testDescriptorTop2(ids).size(), 2);
            Assert.assertEquals(this.testDescriptorTop1(ids).size(), 1);
            
        } catch (Exception e) {
            e.printStackTrace();
            fail("Unwaited exception trown : " + e.getMessage());
            //throw e;
        }
        
    }
    
    private Set<Long> testDescriptorTop1(Set<Long> ids) throws ParseException {
        CriteriasDescriptor descriptor = new CriteriasDescriptor();
        Set<ISearchCriteria> subCriterias1 = new HashSet<ISearchCriteria>();
        
        descriptor
            .addSearch(new CrossJoinCriteria("id",BaseOperator.EQUALS,
                CrossJoinCriteria.prepareOperand("request", RequestAction.class)))
            .addSearch(new SimpleCriteria(RequestAction.class,"date",BaseOperator.GTE,
                DateUtils.parseDate("13/07/2007")))
            .addSelect(new SelectField(Request.class,"id"))
            .addSort(new SortCriteria(Request.class,"id",SortDirection.ASC))
            .addSort(new SortCriteria("creationDate"))
            .setMax(1).setOffset(1);
        
        
        for(Long id : ids)
            subCriterias1.add(new SimpleCriteria("id",BaseOperator.EQUALS,id,LogicOperator.OR));
        
        descriptor.addSearch(new CompositeCriteria(subCriterias1,LogicOperator.OR));
        descriptor.setMax(2);
        return this.externalServiceTraceDAO.<Request,Long>get(descriptor, Request.class);
    }
    
    private Set<Long> testDescriptorTop2(Set<Long> ids) throws ParseException {
        CriteriasDescriptor descriptor = new CriteriasDescriptor();
        Set<ISearchCriteria> subCriterias1 = new HashSet<ISearchCriteria>();
        
        descriptor
            .addSearch(new CrossJoinCriteria("id",BaseOperator.EQUALS,
                CrossJoinCriteria.prepareOperand("request", RequestAction.class)))
            .addSearch(new SimpleCriteria(RequestAction.class,"date",BaseOperator.GTE,
                DateUtils.parseDate("13/07/2007")))
            .addSelect(new SelectField(Request.class,"id"))
            .addSort(new SortCriteria(Request.class,"id",SortDirection.ASC))
            .addSort(new SortCriteria("creationDate"))
            .setMax(2);
        
        
        for(Long id : ids)
            subCriterias1.add(new SimpleCriteria("id",BaseOperator.EQUALS,id,LogicOperator.OR));
        
        descriptor.addSearch(new CompositeCriteria(subCriterias1,LogicOperator.OR));
        descriptor.setMax(2);
        return this.externalServiceTraceDAO.<Request,Long>get(descriptor, Request.class);
    }
    
    private Set<Long> realizeExtractionWithDescriptor(Set<Long> ids) throws ParseException {
        CriteriasDescriptor descriptor = new CriteriasDescriptor();
        Set<ISearchCriteria> subCriterias1 = new HashSet<ISearchCriteria>();
        
        descriptor
            .addSearch(new CrossJoinCriteria("id",BaseOperator.EQUALS,
                CrossJoinCriteria.prepareOperand("request", RequestAction.class)))
            .addSearch(new SimpleCriteria(RequestAction.class,"date",BaseOperator.GTE,
                DateUtils.parseDate("13/07/2007")))
            .addSelect(new SelectField(Request.class,"id"))
            .addSort(new SortCriteria(Request.class,"id",SortDirection.ASC));
        
        
        for(Long id : ids)
            subCriterias1.add(new SimpleCriteria("id",BaseOperator.EQUALS,id,LogicOperator.OR));
        
        descriptor.addSearch(new CompositeCriteria(subCriterias1,LogicOperator.OR));
        return this.externalServiceTraceDAO.<Request,Long>get(descriptor, Request.class);
    }
    
    private Set<Long> realizeComplexIdsExtract(Set<Long> ids) throws ParseException {
        Set<ISelectArgument> arguments = new HashSet<ISelectArgument>();
        Set<ISearchCriteria> criterias = new HashSet<ISearchCriteria>();
        Set<ISearchCriteria> subCriterias1 = new HashSet<ISearchCriteria>();
        
        arguments.add(new SelectField(Request.class,"id"));
        criterias.add(new CrossJoinCriteria("id",BaseOperator.EQUALS,
                CrossJoinCriteria.prepareOperand("request", RequestAction.class)));
        criterias.add(new SimpleCriteria(RequestAction.class,"date",BaseOperator.GTE,
                DateUtils.parseDate("13/07/2007")));
        
        for(Long id : ids)
            subCriterias1.add(new SimpleCriteria("id",BaseOperator.EQUALS,id,LogicOperator.OR));
        
        criterias.add(new CompositeCriteria(subCriterias1,LogicOperator.OR));
        
        return this.externalServiceTraceDAO.<Request,Long>get(arguments, criterias, Request.class);
    }
    
    private Set<Long> realizeComplexIdsExtract2(Set<Long> ids) throws ParseException {
        ids.remove(ids.iterator().next());
        Set<ISelectArgument> arguments = new HashSet<ISelectArgument>();
        Set<ISearchCriteria> criterias = new HashSet<ISearchCriteria>();
        Set<ISearchCriteria> subCriterias1 = new HashSet<ISearchCriteria>();
        
        arguments.add(new SelectField(Request.class,"id"));
        criterias.add(new CrossJoinCriteria("id",BaseOperator.EQUALS,
                CrossJoinCriteria.prepareOperand("request", RequestAction.class)));
        criterias.add(new SimpleCriteria(RequestAction.class,"date",BaseOperator.GTE,
                DateUtils.parseDate("13/07/2007")));
        
        for(Long id : ids) {
            Long[] array = {id};
            subCriterias1.add(new InCriteria("id",BaseOperator.IN,
                    new HashSet<Long>(Arrays.asList(array)),LogicOperator.OR));
        }
        
        criterias.add(new CompositeCriteria(subCriterias1,LogicOperator.AND));
        
        return this.externalServiceTraceDAO.<Request,Long>get(arguments, criterias, Request.class);
    }
    
    private Set<Long> extractRequestIdsViaActions() throws ParseException {
        Set<ISelectArgument> arguments = new HashSet<ISelectArgument>();
        Set<ISearchCriteria> criterias = new HashSet<ISearchCriteria>();
        
        arguments.add(new SelectField(Request.class,"id"));
        criterias.add(new CrossJoinCriteria("id",BaseOperator.EQUALS,
                CrossJoinCriteria.prepareOperand("request", RequestAction.class)));
        criterias.add(new SimpleCriteria(RequestAction.class,"date",BaseOperator.GTE,
                DateUtils.parseDate("13/07/2007")));
        criterias.add(new SimpleCriteria(RequestAction.class,"date",BaseOperator.LTE,
                DateUtils.parseDate("13/07/2012")));
        
        return this.externalServiceTraceDAO.<Request,Long>get(arguments, criterias, Request.class);
    }
    
    private int getCount() {
        Set<ISelectArgument> arguments = new HashSet<ISelectArgument>();
        arguments.add(new SelectAggregator("COUNT(id)"));
        
        Set<Long> result = this.externalServiceTraceDAO.<Request,Long>get(arguments, null, Request.class);
        return Integer.parseInt(result.iterator().next().toString());
    }
    
    private Set<Long> extractRequestIds() {
        Set<ISelectArgument> arguments = new HashSet<ISelectArgument>();
        arguments.add(new SelectField("id"));
        Set<Long> result = this.externalServiceTraceDAO.<Request,Long>get(arguments, null, Request.class);
        return result;
    }
    
    private Set<Request> extractRequestWithIn(Set<Long> ids) {
        Set<ISearchCriteria> criterias = new HashSet<ISearchCriteria>();
        criterias.add(new InCriteria("id",BaseOperator.IN,ids));
        return this.externalServiceTraceDAO.<Request,Request> get(criterias, Request.class);
    }
}
