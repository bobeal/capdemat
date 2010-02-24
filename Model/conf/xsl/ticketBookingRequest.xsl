<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" 
  xmlns:tbr="http://www.cg95.fr/cvq/schema/tbr" 
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
	      <xsl:with-param name="RequestName">Billeterie</xsl:with-param>
	      <xsl:with-param name="FriendlyLocalAuthorityName"><xsl:value-of select="$friendlyLocalAuthorityName"/></xsl:with-param>
	    </xsl:call-template>

                <fo:block xsl:use-attribute-sets="request.section.header">Demandeur*</fo:block>
	    <fo:block>
	      <fo:leader leader-pattern="space" />
	    </fo:block>
        
                    	    <xsl:apply-templates select="//cvq:Requester"/>
      
    
          
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
                        <xsl:when test="//tbr:SubscriberNumber and //tbr:SubscriberNumber != ''">
                                    <xsl:value-of select="//tbr:SubscriberNumber" />
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
  
                  <fo:block xsl:use-attribute-sets="request.section.header">Spectacles*</fo:block>
	    <fo:block>
	      <fo:leader leader-pattern="space" />
	    </fo:block>
        
                  <xsl:variable name="withTotal" select="'false'" />

    <xsl:for-each select="//tbr:TbrTicket">
                                                    <fo:table xsl:use-attribute-sets="request.field.inline.table">
  <fo:table-column column-width="proportional-column-width(100)" />
  <fo:table-column column-width="proportional-column-width(200)" />
  <fo:table-column column-width="proportional-column-width(100)" />
  
  <fo:table-body>
    <fo:table-row>
      <fo:table-cell>
       <fo:block xsl:use-attribute-sets="request.field.inline.label">
	Nom
       </fo:block>
      </fo:table-cell>
      <fo:table-cell>
        <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
            <xsl:choose>
            <xsl:when test="./tbr:EventName and ./tbr:EventName != ''">
                  <xsl:value-of select="./tbr:EventName" />
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
                                                            <fo:table xsl:use-attribute-sets="request.field.inline.table">
  <fo:table-column column-width="proportional-column-width(100)" />
  <fo:table-column column-width="proportional-column-width(200)" />
  <fo:table-column column-width="proportional-column-width(100)" />
  
  <fo:table-body>
    <fo:table-row>
      <fo:table-cell>
       <fo:block xsl:use-attribute-sets="request.field.inline.label">
	Date
       </fo:block>
      </fo:table-cell>
      <fo:table-cell>
        <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
            <xsl:choose>
            <xsl:when test="./tbr:EventDate and ./tbr:EventDate != ''">
                  <xsl:value-of select="./tbr:EventDate" />
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
                                                            <fo:table xsl:use-attribute-sets="request.field.inline.table">
  <fo:table-column column-width="proportional-column-width(100)" />
  <fo:table-column column-width="proportional-column-width(200)" />
  <fo:table-column column-width="proportional-column-width(100)" />
  
  <fo:table-body>
    <fo:table-row>
      <fo:table-cell>
       <fo:block xsl:use-attribute-sets="request.field.inline.label">
	Lieu
       </fo:block>
      </fo:table-cell>
      <fo:table-cell>
        <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
            <xsl:choose>
            <xsl:when test="./tbr:EventPlace and ./tbr:EventPlace != ''">
                  <xsl:value-of select="./tbr:EventPlace" />
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
                    <xsl:if test="$withTotal = 'true'  or not(position() = last())">
        <fo:block>
          <fo:leader leader-pattern="dots" leader-length.optimum="100%"/>
          <fo:leader leader-pattern="space" />
        </fo:block>
      </xsl:if>
    </xsl:for-each>
    
          
                              <fo:table xsl:use-attribute-sets="request.field.inline.table">
                        <fo:table-column column-width="proportional-column-width(100)" />
          <fo:table-column column-width="proportional-column-width(100)" />
                    	      <fo:table-body>
		<fo:table-row>
      	                        		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.inline.label">
		      Total*
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
                                      <xsl:choose>
                        <xsl:when test="//tbr:TotalPrice and //tbr:TotalPrice != ''">
                                    <xsl:value-of select="//tbr:TotalPrice" />
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
  
                  <fo:block xsl:use-attribute-sets="request.section.header">Règlement intérieur</fo:block>
	    <fo:block>
	      <fo:leader leader-pattern="space" />
	    </fo:block>
        
                                	    <fo:block xsl:use-attribute-sets="request.signature">
	      <xsl:if test="//tbr:RulesAndRegulationsAcceptance/text() = &quot;true&quot;">
      		<fo:inline>J'ai pris parfaite connaissance du règlement intérieur qui accompagne cette fiche.</fo:inline>
		<fo:block>
		  <fo:leader leader-pattern="space" />
		</fo:block>
      		<fo:inline>A* ...................................................,&#160;&#160;le*&#160;&#160;...../...../.......&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;Signature du demandeur * 
		</fo:inline>
		<fo:block>
		  <fo:leader leader-pattern="space" />
		</fo:block>
		<fo:block>
		  <fo:leader leader-pattern="space" />
		</fo:block>
		<fo:block>
		  <fo:leader leader-pattern="space" />
		</fo:block>
	      </xsl:if>
	      <xsl:if test="//tbr:RulesAndRegulationsAcceptance/text() = &quot;false&quot;">
      		<fo:inline>Vous n'avez pas accepté le réglement intérieur</fo:inline>
		<fo:block>
		  <fo:leader leader-pattern="space" />
		</fo:block>
      	      </xsl:if>
	    </fo:block>

    
      
              <fo:block>
              <fo:leader leader-pattern="space" />
            </fo:block>
  
  
	    <xsl:call-template name="requestFooter">
	      <xsl:with-param name="RequestId">
            <xsl:value-of select="tbr:TicketBookingRequest/cvq:Id"/>
          </xsl:with-param>
	      <xsl:with-param name="CreationDate">
            <xsl:value-of select="tbr:TicketBookingRequest/cvq:CreationDate"/>
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
