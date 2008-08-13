<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" 
  xmlns:prr="http://www.cg95.fr/cvq/schema/prr" 
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xmlns:fo="http://www.w3.org/1999/XSL/Format" 
  xmlns:cvq="http://www.cg95.fr/cvq/schema/common"
  xmlns:ref="http://www.cg95.fr/cvq/schema/referential" 
  xmlns:exslt="http://exslt.org/common"
  xmlns:locservice="java:fr.cg95.cvq.util.localization.impl.LocalizationService">

  <xsl:include href="styleAttributes.xsl"/>
  <xsl:include href="commonReferentialTemplates.xsl"/>
  <xsl:include href="commonRequestTemplates.xsl"/>
  <xsl:include href="split-string.xslt"/>

  <xsl:param name="logoSource" select="''"/>
  <xsl:param name="localAuthorityName" select="''"/>
  <xsl:param name="friendlyLocalAuthorityName" select="''"/>
  <xsl:param name="localizationService" select="''"/>
  
  <xsl:template match="/">

    <fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">

      <fo:layout-master-set>
        <fo:simple-page-master master-name="default-page" 
	  page-height="297mm" page-width="210mm" 
	  margin-left="0.6in" margin-right="0.6in"
	  margin-top="0.1in" margin-bottom="0.1in">
          <fo:region-body/>
        </fo:simple-page-master>
      </fo:layout-master-set>

      <fo:page-sequence master-reference="default-page" initial-page-number="1">

	<fo:flow flow-name="xsl-region-body">

	  <fo:block>
	    <xsl:call-template name="requestHeader">
	      <xsl:with-param name="RequestName">Demande de réservation de places</xsl:with-param>
	      <xsl:with-param name="FriendlyLocalAuthorityName"><xsl:value-of select="$friendlyLocalAuthorityName"/></xsl:with-param>
	    </xsl:call-template>

                <fo:block xsl:use-attribute-sets="request.section.header">Demandeur*</fo:block>
	    <fo:block>
	      <fo:leader leader-pattern="space" />
	    </fo:block>
        
                    	    <xsl:apply-templates select="//cvq:Requester"/>
      
    
          
                                
      	    <fo:table xsl:use-attribute-sets="request.field.inline.table">
	      <fo:table-column column-width="proportional-column-width(2 * 1)" />
	      <fo:table-column column-width="proportional-column-width(1) - 30pt" />
	      <fo:table-column column-width="30pt" />
	      <fo:table-column column-width="proportional-column-width(1) - 30pt" />
	      <fo:table-column column-width="30pt" />
      	      <fo:table-column column-width="proportional-column-width(4)" />
      	      <fo:table-body>
		<fo:table-row>
		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.inline.label">
		      Etes-vous abonné ?*
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.yesno.label">OUI</fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.yesno.value">
		      <xsl:if test="//prr:IsSubscriber = &quot;true&quot;">X</xsl:if>
		      <xsl:if test="//prr:IsSubscriber = &quot;false&quot;">&#160;</xsl:if>
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.yesno.label">NON</fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.yesno.value">
		      <xsl:if test="//prr:IsSubscriber = &quot;false&quot;">X</xsl:if>
		      <xsl:if test="//prr:IsSubscriber = &quot;true&quot;">&#160;</xsl:if>
		    </fo:block>
		  </fo:table-cell>
      		  <fo:table-cell>
		    <fo:block>&#160;</fo:block>
		  </fo:table-cell>
      		</fo:table-row>
	      </fo:table-body>
	    </fo:table>

    
          
                              <fo:table xsl:use-attribute-sets="request.field.inline.table">
                        <fo:table-column column-width="proportional-column-width(100)" />
          <fo:table-column column-width="proportional-column-width(100)" />
                    	      <fo:table-column column-width="proportional-column-width(200)" />
      	      <fo:table-body>
		<fo:table-row>
      	                    		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.inline.label">
		      Numéro d'abonné
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
                                      <xsl:choose>
                        <xsl:when test="//prr:SubscriberNumber and //prr:SubscriberNumber != ''">
                                    <xsl:value-of select="//prr:SubscriberNumber" />
                                  </xsl:when>
                        <xsl:otherwise>
                          <xsl:text>&#160;</xsl:text>
                        </xsl:otherwise>
                      </xsl:choose>
        		    </fo:block>
		  </fo:table-cell>
            		  <fo:table-cell>
		    <fo:block>&#160;</fo:block>
		  </fo:table-cell>
      		</fo:table-row>
	      </fo:table-body>
	    </fo:table>

    
      
              <fo:block>
              <fo:leader leader-pattern="space" />
            </fo:block>
  
                  <fo:block xsl:use-attribute-sets="request.section.header">Places*</fo:block>
	    <fo:block>
	      <fo:leader leader-pattern="space" />
	    </fo:block>
        
                              	    <xsl:call-template name="PlaceReservationDataType">
	      <xsl:with-param name="ReservationData" select="document(string(concat($localAuthorityName,'/local_referential/place_reservation_prr.xml')))//ref:data"/>
	      <xsl:with-param name="RequestData" select="//prr:PlaceReservation"/>
	    </xsl:call-template>

    
          
                              <fo:table xsl:use-attribute-sets="request.field.inline.table">
                        <fo:table-column column-width="proportional-column-width(100)" />
          <fo:table-column column-width="proportional-column-width(100)" />
                    	      <fo:table-body>
		<fo:table-row>
      	                    		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.inline.label">
		      Référence du paiement
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
                                      <xsl:choose>
                        <xsl:when test="//prr:PaymentReference and //prr:PaymentReference != ''">
                                    <xsl:value-of select="//prr:PaymentReference" />
                                  </xsl:when>
                        <xsl:otherwise>
                          <xsl:text>&#160;</xsl:text>
                        </xsl:otherwise>
                      </xsl:choose>
        		    </fo:block>
		  </fo:table-cell>
            		</fo:table-row>
	      </fo:table-body>
	    </fo:table>

    
      
              <fo:block>
              <fo:leader leader-pattern="space" />
            </fo:block>
  
                  <fo:block xsl:use-attribute-sets="request.section.header">Moyen de contact*</fo:block>
	    <fo:block>
	      <fo:leader leader-pattern="space" />
	    </fo:block>
        
                    	    <xsl:apply-templates select="//cvq:MeansOfContact"/>
      
    
      
              <fo:block>
              <fo:leader leader-pattern="space" />
            </fo:block>
  
  
	    <xsl:call-template name="requestFooter">
	      <xsl:with-param name="RequestId">
            <xsl:value-of select="prr:PlaceReservationRequest/cvq:Id"/>
          </xsl:with-param>
	      <xsl:with-param name="CreationDate">
            <xsl:value-of select="prr:PlaceReservationRequest/cvq:CreationDate"/>
          </xsl:with-param>
	    </xsl:call-template>

      </fo:block>
	</fo:flow>
      </fo:page-sequence>
    </fo:root>
  </xsl:template>

              <xsl:template match="//cvq:Requester">
          <xsl:call-template name="AdultType">
      <xsl:with-param name="localizationService" select="$localizationService"></xsl:with-param>
    </xsl:call-template>
  </xsl:template>
                                              <xsl:template match="//cvq:MeansOfContact">
          <xsl:call-template name="MeansOfContactType">
      <xsl:with-param name="localizationService" select="$localizationService"></xsl:with-param>
    </xsl:call-template>
  </xsl:template>
      </xsl:stylesheet>
