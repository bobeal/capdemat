package fr.capwebct.modules.payment.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import fr.capwebct.modules.payment.business.ExternalDataType;
import fr.capwebct.modules.payment.exception.CpmBusinessException;
import fr.capwebct.modules.payment.service.IExternalApplicationService;
import fr.capwebct.modules.payment.service.IImportService;
import fr.capwebct.modules.payment.service.ImportResultBean;

public class ExternalImportController extends SimpleFormController {

    private static Log log = LogFactory.getLog(ExternalImportController.class);

    private IExternalApplicationService externalApplicationService;
    private IImportService importService;
    
    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, 
            Object command, BindException errors) 
        throws Exception {
        
        CsvDataCommand csvDataCommand = (CsvDataCommand) command;
        ModelAndView mav = new ModelAndView(getSuccessView());
        mav.addObject("externalDataTypes", ExternalDataType.values());
        mav.addObject("externalApplications", externalApplicationService.getAll());
                
        byte[] data = csvDataCommand.getData();
        if (data == null || data.length == 0) {
            log.warn("onSubmit() no accounts data provided");
            return mav;
        }
        
        ImportResultBean importResultBean = null;
        try {
            importResultBean = 
                importService.importExternalData("CSV", 
                        Long.valueOf(csvDataCommand.getExternalApplicationId()), 
                        csvDataCommand.getExternalApplicationBroker(), 
                        ExternalDataType.forKey(csvDataCommand.getDataType()), data,
                        csvDataCommand.getDetailsData());
        } catch (CpmBusinessException cbe) {
            importResultBean = new ImportResultBean();
            importResultBean.setSuccessful(false);
            importResultBean.setFailMessage("admin.import_export.error.data_import");
            mav.addObject("import_result", importResultBean);
            return mav;
        }
        
        importResultBean.setSuccessMessage("admin.import_export.success_message");
        mav.addObject("import_result", importResultBean);
        
        return mav;
    }
    
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder)
        throws ServletException {
        
        // to actually be able to convert Multipart instance to byte[]
        // we have to register a custom editor
        binder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
        // now Spring knows how to handle multipart object and convert them
    }

    @Override
    protected Map referenceData(HttpServletRequest request) throws Exception {
        
        Map<Object, Object> model = new HashMap<Object, Object>();
        model.put("externalDataTypes", ExternalDataType.values());
        model.put("externalApplications", externalApplicationService.getAll());
        
        request.getSession().setAttribute("currentMenu", "externalImport");

        return model;
    }
    
    public void setImportService(IImportService importService) {
        this.importService = importService;
    }

    public void setExternalApplicationService(IExternalApplicationService externalApplicationService) {
        this.externalApplicationService = externalApplicationService;
    }
}
