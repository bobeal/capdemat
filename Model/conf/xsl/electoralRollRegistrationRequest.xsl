<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" 
  xmlns:errr="http://www.cg95.fr/cvq/schema/errr" 
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
	      <xsl:with-param name="RequestName">Demande d'inscription sur les listes électorales</xsl:with-param>
	      <xsl:with-param name="FriendlyLocalAuthorityName"><xsl:value-of select="$friendlyLocalAuthorityName"/></xsl:with-param>
	    </xsl:call-template>

                <fo:block xsl:use-attribute-sets="request.section.header">Personne à inscrire*</fo:block>
	    <fo:block>
	      <fo:leader leader-pattern="space" />
	    </fo:block>
        
                    	    <xsl:apply-templates select="//cvq:Subject"/>
      
    
          
                              <fo:table xsl:use-attribute-sets="request.field.inline.table">
                        <fo:table-column column-width="proportional-column-width(100)" />
          <fo:table-column column-width="proportional-column-width(100)" />
                    	      <fo:table-column column-width="proportional-column-width(200)" />
      	      <fo:table-body>
		<fo:table-row>
      	                        		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.inline.label">
		      Nationalité*
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
                                      <xsl:choose>
                        <xsl:when test="//errr:SubjectNationality and //errr:SubjectNationality != ''">
                                    <xsl:value-of select="//errr:SubjectNationality" />
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

    
          
                              <fo:table xsl:use-attribute-sets="request.field.inline.table">
                        <fo:table-column column-width="proportional-column-width(100)" />
          <fo:table-column column-width="proportional-column-width(100)" />
                    	      <fo:table-column column-width="proportional-column-width(200)" />
      	      <fo:table-body>
		<fo:table-row>
      	                    		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.inline.label">
		      Ancienne commune
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
                                      <xsl:choose>
                        <xsl:when test="//errr:SubjectOldCity and //errr:SubjectOldCity != ''">
                                    <xsl:value-of select="//errr:SubjectOldCity" />
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
  
                  <fo:block xsl:use-attribute-sets="request.section.header">Raison de la demande*</fo:block>
	    <fo:block>
	      <fo:leader leader-pattern="space" />
	    </fo:block>
        
                                    
                  <fo:table xsl:use-attribute-sets="request.field.inline.table">
              <xsl:variable name="mod_column" select="'2'"/>
              <xsl:variable name="enum_tokens">
                <xsl:call-template name="split-string">
                        <xsl:with-param name="string" select="//errr:Motive/text()"/>
                      </xsl:call-template>
              </xsl:variable>
      
              <xsl:for-each select="locservice:getEnumsDataNode($localizationService,'http://www.cg95.fr/cvq/schema/errr','ElectoralMotiveType','fr')//ref:data[@name = 'ElectoralMotiveType']/ref:entry">
                <xsl:if test="not(position() &gt; ($mod_column + 1))">
                  <fo:table-column column-width="30pt" />
                  <fo:table-column column-width="proportional-column-width(1) - 30pt"/>
                </xsl:if>
              </xsl:for-each>

              <fo:table-body>
      
                <xsl:for-each select="locservice:getEnumsDataNode($localizationService,'http://www.cg95.fr/cvq/schema/errr','ElectoralMotiveType','fr')//ref:data[@name = 'ElectoralMotiveType']/ref:entry">

	                	          <xsl:if test="position() = 1">
	            <xsl:text disable-output-escaping="yes">&lt;fo:table-row&gt;</xsl:text>
	          </xsl:if>
      	          	          <xsl:if test="(position() != 1) and ((position() mod $mod_column) = 1)">
	            <xsl:text disable-output-escaping="yes">&lt;fo:table-row&gt;</xsl:text>
	                  	          </xsl:if>
	          <fo:table-cell>
	            <fo:block xsl:use-attribute-sets="request.field.checkbox.value">
		      <xsl:variable name="current_value" select="@key"/>
		      <xsl:for-each select="exslt:node-set($enum_tokens)/words/w">
			<xsl:choose>
			  <xsl:when test="text() = $current_value">X</xsl:when>
			  <xsl:otherwise>&#160;</xsl:otherwise>
			</xsl:choose>
                      </xsl:for-each>
	            </fo:block>
	          </fo:table-cell>
	          <fo:table-cell>
	            <fo:block xsl:use-attribute-sets="request.field.checkbox.label">
                      <xsl:value-of select="./ref:label[@lang='fr']"/>
      	            </fo:block>
	          </fo:table-cell>
	          <xsl:if test="((position() mod $mod_column) = 0) or (position() = last())">
	            <xsl:text disable-output-escaping="yes">&lt;/fo:table-row&gt;</xsl:text>
	            	            <xsl:if test="not(position() = last())">
	              <xsl:text disable-output-escaping="yes">&lt;fo:table-row&gt;&lt;fo:table-cell&gt;&lt;fo:block&gt;&#160;&lt;/fo:block&gt;&lt;/fo:table-cell&gt;&lt;/fo:table-row&gt;</xsl:text>
	            </xsl:if>
	          </xsl:if>
	        </xsl:for-each>
              </fo:table-body>
            </fo:table>

    
      
              <fo:block>
              <fo:leader leader-pattern="space" />
            </fo:block>
  
                <xsl:if test="//errr:Motive/text() = 'DirectCityContribution'">
                <fo:block xsl:use-attribute-sets="request.section.header">Adresse en dehors de la ville*</fo:block>
	    <fo:block>
	      <fo:leader leader-pattern="space" />
	    </fo:block>
        
                    	    <xsl:apply-templates select="//errr:SubjectAddressOutsideCity"/>
      
    
      
              <fo:block>
              <fo:leader leader-pattern="space" />
            </fo:block>
  
              </xsl:if>
                  <fo:block xsl:use-attribute-sets="request.section.header">Moyen de contact*</fo:block>
	    <fo:block>
	      <fo:leader leader-pattern="space" />
	    </fo:block>
        
                    	    <xsl:apply-templates select="//cvq:MeansOfContact"/>
      
    
      
              <fo:block>
              <fo:leader leader-pattern="space" />
            </fo:block>
  
                  <fo:block xsl:use-attribute-sets="request.section.header">Informations sur l'inscription (à remplir par l'administration)</fo:block>
	    <fo:block>
	      <fo:leader leader-pattern="space" />
	    </fo:block>
        
                                    <fo:table xsl:use-attribute-sets="request.field.inline.table">
                        <fo:table-column column-width="proportional-column-width(200 * 1) - 30pt" />
          <fo:table-column column-width="30pt" />
                                <fo:table-column column-width="proportional-column-width(100)" />
          <fo:table-column column-width="proportional-column-width(100)" />
                    	      <fo:table-body>
		<fo:table-row>
      	                    		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.inline.label">
		      Numéro d'ordre
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.char_value">
                                      <xsl:choose>
                        <xsl:when test="//errr:ElectoralNumber and //errr:ElectoralNumber != ''">
                                    <xsl:value-of select="//errr:ElectoralNumber" />
                                  </xsl:when>
                        <xsl:otherwise>
                          <xsl:text>&#160;</xsl:text>
                        </xsl:otherwise>
                      </xsl:choose>
        		    </fo:block>
		  </fo:table-cell>
      	                    		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.inline.label">
		      Nom du groupe scolaire
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
                                      <xsl:choose>
                        <xsl:when test="//errr:PollingSchoolName and //errr:PollingSchoolName != ''">
                                    <xsl:value-of select="//errr:PollingSchoolName" />
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
                        <fo:table-column column-width="proportional-column-width(200 * 1) - 30pt" />
          <fo:table-column column-width="30pt" />
                    	      <fo:table-column column-width="proportional-column-width(200)" />
      	      <fo:table-body>
		<fo:table-row>
      	                    		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.inline.label">
		      Numéro de bureau
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.char_value">
                                      <xsl:choose>
                        <xsl:when test="//errr:PollingStation and //errr:PollingStation != ''">
                                    <xsl:value-of select="//errr:PollingStation" />
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
  
  
	    <xsl:call-template name="requestFooter">
	      <xsl:with-param name="RequestId">
            <xsl:value-of select="errr:ElectoralRollRegistrationRequest/cvq:Id"/>
          </xsl:with-param>
	      <xsl:with-param name="CreationDate">
            <xsl:value-of select="errr:ElectoralRollRegistrationRequest/cvq:CreationDate"/>
          </xsl:with-param>
	    </xsl:call-template>

      </fo:block>
	</fo:flow>
      </fo:page-sequence>
    </fo:root>
  </xsl:template>

              <xsl:template match="//cvq:Subject">
          <xsl:call-template name="SubjectType">
      <xsl:with-param name="localizationService" select="$localizationService"></xsl:with-param>
    </xsl:call-template>
  </xsl:template>
                                        <xsl:template match="//errr:SubjectAddressOutsideCity">
          <xsl:call-template name="AddressType">
      <xsl:with-param name="localizationService" select="$localizationService"></xsl:with-param>
    </xsl:call-template>
  </xsl:template>
                    <xsl:template match="//cvq:MeansOfContact">
          <xsl:call-template name="MeansOfContactType">
      <xsl:with-param name="localizationService" select="$localizationService"></xsl:with-param>
    </xsl:call-template>
  </xsl:template>
                    </xsl:stylesheet>
