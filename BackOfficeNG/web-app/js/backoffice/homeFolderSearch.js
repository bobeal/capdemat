
/**
 * @description This file contains homefolder search client-module
 * @namespace zenexity.capdemat.bong.homeFolder
 * 
 * @author vba@zenexity.fr
 */

zenexity.capdemat.tools.namespace('zenexity.capdemat.bong.homeFolder');

(function(){

  var zct = zenexity.capdemat.tools;
  var zcbh = zenexity.capdemat.bong.homeFolder;
  
  var yl = YAHOO.lang;
  var yu = YAHOO.util;
  var yud = yu.Dom;
  var yue = yu.Event;
  var yus = yu.Selector;
  var ylj = yl.JSON;
  
  
  zcbh.Search = function() {
    var initControls = function() {
      zcbh.Search.paginator = new YAHOO.widget.Paginator({
        containers: ['pagination-top','pagination-bottom'],
        rowsPerPage : parseInt(yud.get('currentMax').value),
        totalRecords: parseInt(yud.get('currentCount').value),
        recordOffset: parseInt(yud.get('currentOffset').value),
        template : "{FirstPageLink} {PreviousPageLink} <span>{CurrentPageReport}</span> {NextPageLink} {LastPageLink}",
        previousPageLinkLabel : '&lt;',
        firstPageLinkLabel : '&lt;&lt;',
        nextPageLinkLabel : '&gt;',
        lastPageLinkLabel : '&gt;&gt;',
        pageReportTemplate : 'R&eacute;sultats {startRecord} &agrave; {endRecord} sur {totalRecords}'
      });
      
      zcbh.Search.paginator.subscribe('changeRequest', function(state){
        yud.get('currentOffset').value = state.recordOffset;
        zcbh.Search.doSearch();
      });
      
      zcbh.Search.paginator.render();
      
      yue.on('searchForm','submit',zcbh.Search.doSearch);
    };

    return {
      /**
       * @description Page state descriptor
       */
      pageState : undefined,
      /**
       * @description Search results paginator
       */
      paginator : undefined,
      /**
      * @description Initialize current module
      */
      init : function() {
        zcbh.Search.pageState = ylj.parse(yud.get('pageState').value);
        yue.on(yus.query('.sort'),'change',zcbh.Search.doSearch);
        yue.on(yus.query('.filter'),'change',zcbh.Search.doSearch);
        initControls();
      },
      /**
       * @description Retrives and save page state to input element
       */
      saveState : function() {
        zct.each(yus.query('.persistent'),function(){zcbh.Search.processValue(this);});
        yud.get("pageState").value = ylj.stringify(zcbh.Search.pageState);
      },
      /**
       * @description Applays user defined/default method for element processing
       * @param el {HTMLElement} element to process
       */
      processValue : function(el) {
        var method = ['process',zct.capitalize(el.type.toLowerCase().replace('-','')||'none')].join('');
        if(!zct.tryToCall(zcbh.Search[method],zcbh.Search,el)) 
          zcbh.Search.pageState[el.name] = zct.val(el);
      },
      /**
       * @see zenexity.capdemat.bong.homeFolder.Search.processValue
       */
      processRadio: function(el) {
        if(el.checked) zcbh.Search.pageState[el.name] = zct.val(el);
        return true;
      },
      /**
       * @see zenexity.capdemat.bong.homeFolder.Search.processValue
       */
      processCheckbox: function(el) {
        if(el.checked) zcbh.Search.pageState[el.name] = zct.val(el);
        else delete zcbh.Search.pageState[el.name];
        return true;
      },
      /**
       * @description Produce home folder search
       */
      doSearch : function(e) {
        zcbh.Search.saveState();
        if(!e || yue.getTarget(e).nodeName != 'form') yud.get('searchForm').submit();
      }
    }
  }();
  
  yue.onDOMReady(zcbh.Search.init);
  
}());
