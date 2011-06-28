
package fr.cg95.cvq.business.request.school;

import java.io.Serializable;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import net.sf.oval.constraint.AssertValid;
import org.apache.xmlbeans.XmlOptions;
import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.business.request.*;
import fr.cg95.cvq.business.request.annotation.*;
import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.school.*;
import fr.cg95.cvq.service.request.condition.IConditionChecker;

/**
 * Generated class file, do not edit !
 */
public class ChildCareCenterRegistrationRequest extends Request implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions = ChildCareCenterRegistrationRequestData.conditions;

    @AssertValid(message = "")
    private ChildCareCenterRegistrationRequestData childCareCenterRegistrationRequestData;

    public ChildCareCenterRegistrationRequest(RequestData requestData, ChildCareCenterRegistrationRequestData childCareCenterRegistrationRequestData) {
        super(requestData);
        this.childCareCenterRegistrationRequestData = childCareCenterRegistrationRequestData;
    }

    public ChildCareCenterRegistrationRequest() {
        super();
        this.childCareCenterRegistrationRequestData = new ChildCareCenterRegistrationRequestData();
    }

    /**
     * Reserved for RequestDAO !
     */
    @Override
    public ChildCareCenterRegistrationRequestData getSpecificData() {
        return childCareCenterRegistrationRequestData;
    }

    /**
     * Reserved for RequestDAO !
     */
    public void setSpecificData(ChildCareCenterRegistrationRequestData childCareCenterRegistrationRequestData) {
        this.childCareCenterRegistrationRequestData = childCareCenterRegistrationRequestData;
    }

    @Override
    public final String modelToXmlString() {
        ChildCareCenterRegistrationRequestDocument object = this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    @Override
    public final ChildCareCenterRegistrationRequestDocument modelToXml() {
        
        Calendar calendar = Calendar.getInstance();
        Date date = null;
        ChildCareCenterRegistrationRequestDocument childCareCenterRegistrationRequestDoc = ChildCareCenterRegistrationRequestDocument.Factory.newInstance();
        ChildCareCenterRegistrationRequestDocument.ChildCareCenterRegistrationRequest childCareCenterRegistrationRequest = childCareCenterRegistrationRequestDoc.addNewChildCareCenterRegistrationRequest();
        super.fillCommonXmlInfo(childCareCenterRegistrationRequest);
        int i = 0;
          ChildThursdayType childThursdayTypeThursdayRegistrationParam = childCareCenterRegistrationRequest.addNewThursdayRegistrationParam();
        childThursdayTypeThursdayRegistrationParam.setThursdaySecondPeriodBegining(getThursdaySecondPeriodBegining());
        ChildFridayType childFridayTypeFridayRegistrationParam = childCareCenterRegistrationRequest.addNewFridayRegistrationParam();
        childFridayTypeFridayRegistrationParam.setFridayFirstPeriodEnding(getFridayFirstPeriodEnding());
      
        i = 0;
        if (getWelcomingChoice() != null) {
            fr.cg95.cvq.xml.common.LocalReferentialDataType[] welcomingChoiceTypeTab = new fr.cg95.cvq.xml.common.LocalReferentialDataType[getWelcomingChoice().size()];
            for (LocalReferentialData object : getWelcomingChoice()) {
              welcomingChoiceTypeTab[i++] = LocalReferentialData.modelToXml(object);
            }
            childCareCenterRegistrationRequest.setWelcomingChoiceArray(welcomingChoiceTypeTab);
        }
        ChildWednesdayType childWednesdayTypeWednesdayRegistrationParam = childCareCenterRegistrationRequest.addNewWednesdayRegistrationParam();
        childWednesdayTypeWednesdayRegistrationParam.setWednesdayFirstPeriodBegining(getWednesdayFirstPeriodBegining());
      
        childFridayTypeFridayRegistrationParam.setFridayFirstPeriodBegining(getFridayFirstPeriodBegining());
        ChildMonDayType childMonDayTypeMondayRegistrationParam = childCareCenterRegistrationRequest.addNewMondayRegistrationParam();
        childMonDayTypeMondayRegistrationParam.setMondayFirstPeriodBegining(getMondayFirstPeriodBegining());
        ChildTuesdayType childTuesdayTypeTuesdayRegistrationParam = childCareCenterRegistrationRequest.addNewTuesdayRegistrationParam();
        childTuesdayTypeTuesdayRegistrationParam.setTuesdaySecondPeriodBegining(getTuesdaySecondPeriodBegining());
      
        childTuesdayTypeTuesdayRegistrationParam.setTuesdaySecondPeriodEnding(getTuesdaySecondPeriodEnding());
      
        childThursdayTypeThursdayRegistrationParam.setThursdayFirstPeriodEnding(getThursdayFirstPeriodEnding());
      
        childThursdayTypeThursdayRegistrationParam.setThursdaySecondPeriodEnding(getThursdaySecondPeriodEnding());
      
        childTuesdayTypeTuesdayRegistrationParam.setTuesdayFirstPeriodEnding(getTuesdayFirstPeriodEnding());
      
        if (getTuesdayPeriod() != null)
            childTuesdayTypeTuesdayRegistrationParam.setTuesdayPeriod(fr.cg95.cvq.xml.request.school.DayPeriodType.Enum.forString(getTuesdayPeriod().toString()));
      
        date = getSubjectChoiceBirthDate();
        if (date != null) {
            calendar.setTime(date);
            childCareCenterRegistrationRequest.setSubjectChoiceBirthDate(calendar);
        }
      
        childTuesdayTypeTuesdayRegistrationParam.setTuesdayFirstPeriodBegining(getTuesdayFirstPeriodBegining());
      
        childWednesdayTypeWednesdayRegistrationParam.setWednesdayFirstPeriodEnding(getWednesdayFirstPeriodEnding());
      
        childWednesdayTypeWednesdayRegistrationParam.setWednesdaySecondPeriodEnding(getWednesdaySecondPeriodEnding());
      
        if (getFridayPeriod() != null)
            childFridayTypeFridayRegistrationParam.setFridayPeriod(fr.cg95.cvq.xml.request.school.DayPeriodType.Enum.forString(getFridayPeriod().toString()));
      
        if (getWednesdayPeriod() != null)
            childWednesdayTypeWednesdayRegistrationParam.setWednesdayPeriod(fr.cg95.cvq.xml.request.school.DayPeriodType.Enum.forString(getWednesdayPeriod().toString()));
      
        childMonDayTypeMondayRegistrationParam.setMondaySecondPeriodEnding(getMondaySecondPeriodEnding());
      
        childMonDayTypeMondayRegistrationParam.setMondayFirstPeriodEnding(getMondayFirstPeriodEnding());
      
        childFridayTypeFridayRegistrationParam.setFridaySecondPeriodBegining(getFridaySecondPeriodBegining());
      
        childFridayTypeFridayRegistrationParam.setFridaySecondPeriodEnding(getFridaySecondPeriodEnding());
      
        childMonDayTypeMondayRegistrationParam.setMondaySecondPeriodBegining(getMondaySecondPeriodBegining());
      
        if (getMondayPeriod() != null)
            childMonDayTypeMondayRegistrationParam.setMondayPeriod(fr.cg95.cvq.xml.request.school.DayPeriodType.Enum.forString(getMondayPeriod().toString()));
      
        date = getRegistrationDate();
        if (date != null) {
            calendar.setTime(date);
            childCareCenterRegistrationRequest.setRegistrationDate(calendar);
        }
      
        childWednesdayTypeWednesdayRegistrationParam.setWednesdaySecondPeriodBegining(getWednesdaySecondPeriodBegining());
      
        if (getSubjectChoiceGender() != null)
            childCareCenterRegistrationRequest.setSubjectChoiceGender(fr.cg95.cvq.xml.common.SexType.Enum.forString(getSubjectChoiceGender().toString()));
      
        childThursdayTypeThursdayRegistrationParam.setThursdayFirstPeriodBegining(getThursdayFirstPeriodBegining());
      
        if (getThursdayPeriod() != null)
            childThursdayTypeThursdayRegistrationParam.setThursdayPeriod(fr.cg95.cvq.xml.request.school.DayPeriodType.Enum.forString(getThursdayPeriod().toString()));
      
        return childCareCenterRegistrationRequestDoc;
    }

    @Override
    public final ChildCareCenterRegistrationRequestDocument.ChildCareCenterRegistrationRequest modelToXmlRequest() {
        return modelToXml().getChildCareCenterRegistrationRequest();
    }

    public static ChildCareCenterRegistrationRequest xmlToModel(ChildCareCenterRegistrationRequestDocument childCareCenterRegistrationRequestDoc) {
        ChildCareCenterRegistrationRequestDocument.ChildCareCenterRegistrationRequest childCareCenterRegistrationRequestXml = childCareCenterRegistrationRequestDoc.getChildCareCenterRegistrationRequest();
        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        ChildCareCenterRegistrationRequest childCareCenterRegistrationRequest = new ChildCareCenterRegistrationRequest();
        childCareCenterRegistrationRequest.fillCommonModelInfo(childCareCenterRegistrationRequest, childCareCenterRegistrationRequestXml);
        
        childCareCenterRegistrationRequest.setThursdaySecondPeriodBegining(childCareCenterRegistrationRequestXml.getThursdayRegistrationParam().getThursdaySecondPeriodBegining());
      
        childCareCenterRegistrationRequest.setFridayFirstPeriodEnding(childCareCenterRegistrationRequestXml.getFridayRegistrationParam().getFridayFirstPeriodEnding());
      
        List<fr.cg95.cvq.business.request.LocalReferentialData> welcomingChoiceList = new ArrayList<fr.cg95.cvq.business.request.LocalReferentialData>(childCareCenterRegistrationRequestXml.sizeOfWelcomingChoiceArray());
        for (LocalReferentialDataType object : childCareCenterRegistrationRequestXml.getWelcomingChoiceArray()) {
            welcomingChoiceList.add(fr.cg95.cvq.business.request.LocalReferentialData.xmlToModel(object));
        }
        childCareCenterRegistrationRequest.setWelcomingChoice(welcomingChoiceList);
      
        childCareCenterRegistrationRequest.setWednesdayFirstPeriodBegining(childCareCenterRegistrationRequestXml.getWednesdayRegistrationParam().getWednesdayFirstPeriodBegining());
      
        childCareCenterRegistrationRequest.setFridayFirstPeriodBegining(childCareCenterRegistrationRequestXml.getFridayRegistrationParam().getFridayFirstPeriodBegining());
      
        childCareCenterRegistrationRequest.setMondayFirstPeriodBegining(childCareCenterRegistrationRequestXml.getMondayRegistrationParam().getMondayFirstPeriodBegining());
      
        childCareCenterRegistrationRequest.setTuesdaySecondPeriodBegining(childCareCenterRegistrationRequestXml.getTuesdayRegistrationParam().getTuesdaySecondPeriodBegining());
      
        childCareCenterRegistrationRequest.setTuesdaySecondPeriodEnding(childCareCenterRegistrationRequestXml.getTuesdayRegistrationParam().getTuesdaySecondPeriodEnding());
      
        childCareCenterRegistrationRequest.setThursdayFirstPeriodEnding(childCareCenterRegistrationRequestXml.getThursdayRegistrationParam().getThursdayFirstPeriodEnding());
      
        childCareCenterRegistrationRequest.setThursdaySecondPeriodEnding(childCareCenterRegistrationRequestXml.getThursdayRegistrationParam().getThursdaySecondPeriodEnding());
      
        childCareCenterRegistrationRequest.setTuesdayFirstPeriodEnding(childCareCenterRegistrationRequestXml.getTuesdayRegistrationParam().getTuesdayFirstPeriodEnding());
      
        if (childCareCenterRegistrationRequestXml.getTuesdayRegistrationParam().getTuesdayPeriod() != null)
            childCareCenterRegistrationRequest.setTuesdayPeriod(fr.cg95.cvq.business.request.school.DayPeriodType.forString(childCareCenterRegistrationRequestXml.getTuesdayRegistrationParam().getTuesdayPeriod().toString()));
        else
            childCareCenterRegistrationRequest.setTuesdayPeriod(fr.cg95.cvq.business.request.school.DayPeriodType.getDefaultDayPeriodType());
      
        calendar = childCareCenterRegistrationRequestXml.getSubjectChoiceBirthDate();
        if (calendar != null) {
            childCareCenterRegistrationRequest.setSubjectChoiceBirthDate(calendar.getTime());
        }
      
        childCareCenterRegistrationRequest.setTuesdayFirstPeriodBegining(childCareCenterRegistrationRequestXml.getTuesdayRegistrationParam().getTuesdayFirstPeriodBegining());
      
        childCareCenterRegistrationRequest.setWednesdayFirstPeriodEnding(childCareCenterRegistrationRequestXml.getWednesdayRegistrationParam().getWednesdayFirstPeriodEnding());
      
        childCareCenterRegistrationRequest.setWednesdaySecondPeriodEnding(childCareCenterRegistrationRequestXml.getWednesdayRegistrationParam().getWednesdaySecondPeriodEnding());
      
        if (childCareCenterRegistrationRequestXml.getFridayRegistrationParam().getFridayPeriod() != null)
            childCareCenterRegistrationRequest.setFridayPeriod(fr.cg95.cvq.business.request.school.DayPeriodType.forString(childCareCenterRegistrationRequestXml.getFridayRegistrationParam().getFridayPeriod().toString()));
        else
            childCareCenterRegistrationRequest.setFridayPeriod(fr.cg95.cvq.business.request.school.DayPeriodType.getDefaultDayPeriodType());
      
        if (childCareCenterRegistrationRequestXml.getWednesdayRegistrationParam().getWednesdayPeriod() != null)
            childCareCenterRegistrationRequest.setWednesdayPeriod(fr.cg95.cvq.business.request.school.DayPeriodType.forString(childCareCenterRegistrationRequestXml.getWednesdayRegistrationParam().getWednesdayPeriod().toString()));
        else
            childCareCenterRegistrationRequest.setWednesdayPeriod(fr.cg95.cvq.business.request.school.DayPeriodType.getDefaultDayPeriodType());
      
        childCareCenterRegistrationRequest.setMondaySecondPeriodEnding(childCareCenterRegistrationRequestXml.getMondayRegistrationParam().getMondaySecondPeriodEnding());
      
        childCareCenterRegistrationRequest.setMondayFirstPeriodEnding(childCareCenterRegistrationRequestXml.getMondayRegistrationParam().getMondayFirstPeriodEnding());
      
        childCareCenterRegistrationRequest.setFridaySecondPeriodBegining(childCareCenterRegistrationRequestXml.getFridayRegistrationParam().getFridaySecondPeriodBegining());
      
        childCareCenterRegistrationRequest.setFridaySecondPeriodEnding(childCareCenterRegistrationRequestXml.getFridayRegistrationParam().getFridaySecondPeriodEnding());
      
        childCareCenterRegistrationRequest.setMondaySecondPeriodBegining(childCareCenterRegistrationRequestXml.getMondayRegistrationParam().getMondaySecondPeriodBegining());
      
        if (childCareCenterRegistrationRequestXml.getMondayRegistrationParam().getMondayPeriod() != null)
            childCareCenterRegistrationRequest.setMondayPeriod(fr.cg95.cvq.business.request.school.DayPeriodType.forString(childCareCenterRegistrationRequestXml.getMondayRegistrationParam().getMondayPeriod().toString()));
        else
            childCareCenterRegistrationRequest.setMondayPeriod(fr.cg95.cvq.business.request.school.DayPeriodType.getDefaultDayPeriodType());
      
        calendar = childCareCenterRegistrationRequestXml.getRegistrationDate();
        if (calendar != null) {
            childCareCenterRegistrationRequest.setRegistrationDate(calendar.getTime());
        }
      
        childCareCenterRegistrationRequest.setWednesdaySecondPeriodBegining(childCareCenterRegistrationRequestXml.getWednesdayRegistrationParam().getWednesdaySecondPeriodBegining());
      
        if (childCareCenterRegistrationRequestXml.getSubjectChoiceGender() != null)
            childCareCenterRegistrationRequest.setSubjectChoiceGender(fr.cg95.cvq.business.users.SexType.forString(childCareCenterRegistrationRequestXml.getSubjectChoiceGender().toString()));
        else
            childCareCenterRegistrationRequest.setSubjectChoiceGender(fr.cg95.cvq.business.users.SexType.getDefaultSexType());
      
        childCareCenterRegistrationRequest.setThursdayFirstPeriodBegining(childCareCenterRegistrationRequestXml.getThursdayRegistrationParam().getThursdayFirstPeriodBegining());
      
        if (childCareCenterRegistrationRequestXml.getThursdayRegistrationParam().getThursdayPeriod() != null)
            childCareCenterRegistrationRequest.setThursdayPeriod(fr.cg95.cvq.business.request.school.DayPeriodType.forString(childCareCenterRegistrationRequestXml.getThursdayRegistrationParam().getThursdayPeriod().toString()));
        else
            childCareCenterRegistrationRequest.setThursdayPeriod(fr.cg95.cvq.business.request.school.DayPeriodType.getDefaultDayPeriodType());
      
        return childCareCenterRegistrationRequest;
    }

  
    public final void setThursdaySecondPeriodBegining(final String thursdaySecondPeriodBegining) {
        childCareCenterRegistrationRequestData.setThursdaySecondPeriodBegining(thursdaySecondPeriodBegining);
    }

    
    public final String getThursdaySecondPeriodBegining() {
        return childCareCenterRegistrationRequestData.getThursdaySecondPeriodBegining();
    }
  
    public final void setFridayFirstPeriodEnding(final String fridayFirstPeriodEnding) {
        childCareCenterRegistrationRequestData.setFridayFirstPeriodEnding(fridayFirstPeriodEnding);
    }

    
    public final String getFridayFirstPeriodEnding() {
        return childCareCenterRegistrationRequestData.getFridayFirstPeriodEnding();
    }
  
    public final void setWelcomingChoice(final List<fr.cg95.cvq.business.request.LocalReferentialData> welcomingChoice) {
        childCareCenterRegistrationRequestData.setWelcomingChoice(welcomingChoice);
    }

    
    public final List<fr.cg95.cvq.business.request.LocalReferentialData> getWelcomingChoice() {
        return childCareCenterRegistrationRequestData.getWelcomingChoice();
    }
  
    public final void setWednesdayFirstPeriodBegining(final String wednesdayFirstPeriodBegining) {
        childCareCenterRegistrationRequestData.setWednesdayFirstPeriodBegining(wednesdayFirstPeriodBegining);
    }

    
    public final String getWednesdayFirstPeriodBegining() {
        return childCareCenterRegistrationRequestData.getWednesdayFirstPeriodBegining();
    }
  
    public final void setFridayFirstPeriodBegining(final String fridayFirstPeriodBegining) {
        childCareCenterRegistrationRequestData.setFridayFirstPeriodBegining(fridayFirstPeriodBegining);
    }

    
    public final String getFridayFirstPeriodBegining() {
        return childCareCenterRegistrationRequestData.getFridayFirstPeriodBegining();
    }
  
    public final void setMondayFirstPeriodBegining(final String mondayFirstPeriodBegining) {
        childCareCenterRegistrationRequestData.setMondayFirstPeriodBegining(mondayFirstPeriodBegining);
    }

    
    public final String getMondayFirstPeriodBegining() {
        return childCareCenterRegistrationRequestData.getMondayFirstPeriodBegining();
    }
  
    public final void setTuesdaySecondPeriodBegining(final String tuesdaySecondPeriodBegining) {
        childCareCenterRegistrationRequestData.setTuesdaySecondPeriodBegining(tuesdaySecondPeriodBegining);
    }

    
    public final String getTuesdaySecondPeriodBegining() {
        return childCareCenterRegistrationRequestData.getTuesdaySecondPeriodBegining();
    }
  
    public final void setTuesdaySecondPeriodEnding(final String tuesdaySecondPeriodEnding) {
        childCareCenterRegistrationRequestData.setTuesdaySecondPeriodEnding(tuesdaySecondPeriodEnding);
    }

    
    public final String getTuesdaySecondPeriodEnding() {
        return childCareCenterRegistrationRequestData.getTuesdaySecondPeriodEnding();
    }
  
    public final void setThursdayFirstPeriodEnding(final String thursdayFirstPeriodEnding) {
        childCareCenterRegistrationRequestData.setThursdayFirstPeriodEnding(thursdayFirstPeriodEnding);
    }

    
    public final String getThursdayFirstPeriodEnding() {
        return childCareCenterRegistrationRequestData.getThursdayFirstPeriodEnding();
    }
  
    public final void setThursdaySecondPeriodEnding(final String thursdaySecondPeriodEnding) {
        childCareCenterRegistrationRequestData.setThursdaySecondPeriodEnding(thursdaySecondPeriodEnding);
    }

    
    public final String getThursdaySecondPeriodEnding() {
        return childCareCenterRegistrationRequestData.getThursdaySecondPeriodEnding();
    }
  
    public final void setTuesdayFirstPeriodEnding(final String tuesdayFirstPeriodEnding) {
        childCareCenterRegistrationRequestData.setTuesdayFirstPeriodEnding(tuesdayFirstPeriodEnding);
    }

    
    public final String getTuesdayFirstPeriodEnding() {
        return childCareCenterRegistrationRequestData.getTuesdayFirstPeriodEnding();
    }
  
    public final void setTuesdayPeriod(final fr.cg95.cvq.business.request.school.DayPeriodType tuesdayPeriod) {
        childCareCenterRegistrationRequestData.setTuesdayPeriod(tuesdayPeriod);
    }

    
    public final fr.cg95.cvq.business.request.school.DayPeriodType getTuesdayPeriod() {
        return childCareCenterRegistrationRequestData.getTuesdayPeriod();
    }
  
    public final void setSubjectChoiceBirthDate(final java.util.Date subjectChoiceBirthDate) {
        childCareCenterRegistrationRequestData.setSubjectChoiceBirthDate(subjectChoiceBirthDate);
    }

    
    public final java.util.Date getSubjectChoiceBirthDate() {
        return childCareCenterRegistrationRequestData.getSubjectChoiceBirthDate();
    }
  
    public final void setTuesdayFirstPeriodBegining(final String tuesdayFirstPeriodBegining) {
        childCareCenterRegistrationRequestData.setTuesdayFirstPeriodBegining(tuesdayFirstPeriodBegining);
    }

    
    public final String getTuesdayFirstPeriodBegining() {
        return childCareCenterRegistrationRequestData.getTuesdayFirstPeriodBegining();
    }
  
    public final void setWednesdayFirstPeriodEnding(final String wednesdayFirstPeriodEnding) {
        childCareCenterRegistrationRequestData.setWednesdayFirstPeriodEnding(wednesdayFirstPeriodEnding);
    }

    
    public final String getWednesdayFirstPeriodEnding() {
        return childCareCenterRegistrationRequestData.getWednesdayFirstPeriodEnding();
    }
  
    public final void setWednesdaySecondPeriodEnding(final String wednesdaySecondPeriodEnding) {
        childCareCenterRegistrationRequestData.setWednesdaySecondPeriodEnding(wednesdaySecondPeriodEnding);
    }

    
    public final String getWednesdaySecondPeriodEnding() {
        return childCareCenterRegistrationRequestData.getWednesdaySecondPeriodEnding();
    }
  
    public final void setFridayPeriod(final fr.cg95.cvq.business.request.school.DayPeriodType fridayPeriod) {
        childCareCenterRegistrationRequestData.setFridayPeriod(fridayPeriod);
    }

    
    public final fr.cg95.cvq.business.request.school.DayPeriodType getFridayPeriod() {
        return childCareCenterRegistrationRequestData.getFridayPeriod();
    }
  
    public final void setWednesdayPeriod(final fr.cg95.cvq.business.request.school.DayPeriodType wednesdayPeriod) {
        childCareCenterRegistrationRequestData.setWednesdayPeriod(wednesdayPeriod);
    }

    
    public final fr.cg95.cvq.business.request.school.DayPeriodType getWednesdayPeriod() {
        return childCareCenterRegistrationRequestData.getWednesdayPeriod();
    }
  
    public final void setMondaySecondPeriodEnding(final String mondaySecondPeriodEnding) {
        childCareCenterRegistrationRequestData.setMondaySecondPeriodEnding(mondaySecondPeriodEnding);
    }

    
    public final String getMondaySecondPeriodEnding() {
        return childCareCenterRegistrationRequestData.getMondaySecondPeriodEnding();
    }
  
    public final void setMondayFirstPeriodEnding(final String mondayFirstPeriodEnding) {
        childCareCenterRegistrationRequestData.setMondayFirstPeriodEnding(mondayFirstPeriodEnding);
    }

    
    public final String getMondayFirstPeriodEnding() {
        return childCareCenterRegistrationRequestData.getMondayFirstPeriodEnding();
    }
  
    public final void setFridaySecondPeriodBegining(final String fridaySecondPeriodBegining) {
        childCareCenterRegistrationRequestData.setFridaySecondPeriodBegining(fridaySecondPeriodBegining);
    }

    
    public final String getFridaySecondPeriodBegining() {
        return childCareCenterRegistrationRequestData.getFridaySecondPeriodBegining();
    }
  
    public final void setFridaySecondPeriodEnding(final String fridaySecondPeriodEnding) {
        childCareCenterRegistrationRequestData.setFridaySecondPeriodEnding(fridaySecondPeriodEnding);
    }

    
    public final String getFridaySecondPeriodEnding() {
        return childCareCenterRegistrationRequestData.getFridaySecondPeriodEnding();
    }
  
    public final void setMondaySecondPeriodBegining(final String mondaySecondPeriodBegining) {
        childCareCenterRegistrationRequestData.setMondaySecondPeriodBegining(mondaySecondPeriodBegining);
    }

    
    public final String getMondaySecondPeriodBegining() {
        return childCareCenterRegistrationRequestData.getMondaySecondPeriodBegining();
    }
  
    public final void setMondayPeriod(final fr.cg95.cvq.business.request.school.DayPeriodType mondayPeriod) {
        childCareCenterRegistrationRequestData.setMondayPeriod(mondayPeriod);
    }

    
    public final fr.cg95.cvq.business.request.school.DayPeriodType getMondayPeriod() {
        return childCareCenterRegistrationRequestData.getMondayPeriod();
    }
  
    public final void setRegistrationDate(final java.util.Date registrationDate) {
        childCareCenterRegistrationRequestData.setRegistrationDate(registrationDate);
    }

    
    public final java.util.Date getRegistrationDate() {
        return childCareCenterRegistrationRequestData.getRegistrationDate();
    }
  
    public final void setWednesdaySecondPeriodBegining(final String wednesdaySecondPeriodBegining) {
        childCareCenterRegistrationRequestData.setWednesdaySecondPeriodBegining(wednesdaySecondPeriodBegining);
    }

    
    public final String getWednesdaySecondPeriodBegining() {
        return childCareCenterRegistrationRequestData.getWednesdaySecondPeriodBegining();
    }
  
    public final void setSubjectChoiceGender(final fr.cg95.cvq.business.users.SexType subjectChoiceGender) {
        childCareCenterRegistrationRequestData.setSubjectChoiceGender(subjectChoiceGender);
    }

    
    public final fr.cg95.cvq.business.users.SexType getSubjectChoiceGender() {
        return childCareCenterRegistrationRequestData.getSubjectChoiceGender();
    }
  
    public final void setThursdayFirstPeriodBegining(final String thursdayFirstPeriodBegining) {
        childCareCenterRegistrationRequestData.setThursdayFirstPeriodBegining(thursdayFirstPeriodBegining);
    }

    
    public final String getThursdayFirstPeriodBegining() {
        return childCareCenterRegistrationRequestData.getThursdayFirstPeriodBegining();
    }
  
    public final void setThursdayPeriod(final fr.cg95.cvq.business.request.school.DayPeriodType thursdayPeriod) {
        childCareCenterRegistrationRequestData.setThursdayPeriod(thursdayPeriod);
    }

    
    public final fr.cg95.cvq.business.request.school.DayPeriodType getThursdayPeriod() {
        return childCareCenterRegistrationRequestData.getThursdayPeriod();
    }
  
}
