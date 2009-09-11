import fr.cg95.cvq.business.request.DisplayGroup
import fr.cg95.cvq.service.request.IDisplayGroupService
import fr.cg95.cvq.service.request.IRequestTypeService

import grails.converters.JSON

class DisplayGroupController {
    
    IDisplayGroupService displayGroupService
    IRequestTypeService requestTypeService
    
    def translationService
    def defaultAction = "list"
    
    def beforeInterceptor = { session["currentMenu"] = "localAuthority" }
    
    def subMenuEntries = [
      'localAuthority.requests', 
      'localAuthority.aspect',
      'localAuthority.pdf', 
      'localAuthority.identity',
      'displayGroup.list'
    ]

    def list = {
        def displayGroups = displayGroupService.getAll()
        
        def requestTypesByDisplayGroup = [:]
        displayGroups.each { dg ->
            requestTypesByDisplayGroup[dg.id] = []
        	  dg.requestTypes?.each { rt ->
        	      requestTypesByDisplayGroup[dg.id].add(CapdematUtils.adaptRequestType(translationService, rt))
        	  }
        	  requestTypesByDisplayGroup[dg.id].sort {it.label.toLowerCase()}
        }

        return ['subMenuEntries':subMenuEntries,
                'displayGroups':displayGroups,
                'requestTypesByDisplayGroup':requestTypesByDisplayGroup
               ]
    }
    
    def edit = {           
        def displayGroup = displayGroupService.getById(Long.valueOf(params.id))
        def displayGroups = displayGroupService.getAll()
        def requestTypes = []
        displayGroup.requestTypes.each { 
            requestTypes.add(CapdematUtils.adaptRequestType(translationService,it))
        }
        requestTypes = requestTypes.sort{ it.label.toLowerCase() }
        
        return ['editMode':'edit', 
                'displayGroups':displayGroups,
                'displayGroup':displayGroup,
                'requestTypes':requestTypes,
                'orderRequestTypeBy':'label',
                'scope':'bounded'
               ]
    }
    
    
    def create = {
        render(view:'edit',model:[editMode:"create", displayGroups:displayGroupService.getAll()])
    }

    def save = {
        def displayGroup = null
        def create = true
        if (params.id != null && params.id != "") {
            displayGroup = displayGroupService.getById(Long.valueOf(params.id))
            bindData(displayGroup, params)
            displayGroupService.modify(displayGroup)
            create = false
        } else {
            displayGroup = new DisplayGroup()
            bindData(displayGroup, params)
            displayGroupService.create(displayGroup)
        }

        render ([ 'id': displayGroup.id, 'displayGroupLabel':displayGroup?.label,
                  'status':'success', 'message':message(code:'message.updateDone')] as JSON)
    }
    
    def delete = {
        displayGroupService.delete(Long.valueOf(params.id))
        render (['status':'success', 'message':message(code:'message.deleteDone')] as JSON)
    }
    
    /* requestType managment
     * --------------------------------------------------------------------- */

    def requestTypes = {
        def requestTypes = []
        
        if ((request.post && params.scope == null) || params.scope == 'all') {
            requestTypeService.getAllRequestTypes().each{
                requestTypes.add(CapdematUtils.adaptRequestType(translationService,it)) 
            }
        } else if (params.scope == 'bounded') {
            displayGroupService.getById(Long.valueOf(params.id)).requestTypes.each {
                requestTypes.add(CapdematUtils.adaptRequestType(translationService,it))
            }
        }
        
        def orderRequestTypeBy
        if (params.orderRequestTypeBy == null || params.orderRequestTypeBy == "label") {
            requestTypes = requestTypes.sort{ it.label.toLowerCase() }
            orderRequestTypeBy = "label"
        } else if (params.orderRequestTypeBy == "displayGroupName") {
            requestTypes = requestTypes.sort{ it.displayGroupName != null ? it.displayGroupName.toLowerCase() : "zzz" }
            orderRequestTypeBy = "displayGroupName"
        }
        
        render( template:"requestTypes",
                model:[ displayGroupId: new Long(params.id), requestTypes: requestTypes, 
                        orderRequestTypeBy: orderRequestTypeBy, scope:params.scope ])
    }
    

    def associateRequestType = {
        def displayGroup = 
            displayGroupService.addRequestType(Long.valueOf(params.displayGroupId),Long.valueOf(params.requestTypeId))
        render ([ displayGroupName:displayGroup.name,
                  status:'success', success_msg:message(code:"message.updateDone")] as JSON)
    }

    def unassociateRequestType = {
        def displayGroup = 
            displayGroupService.removeRequestType(Long.valueOf(params.displayGroupId),Long.valueOf(params.requestTypeId))
         render ([ displayGroupName:displayGroup.name,
            status:'success', success_msg:message(code:"message.updateDone")] as JSON)
    }

}
