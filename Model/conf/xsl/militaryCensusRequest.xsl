<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" 
  xmlns:mcr="http://www.cg95.fr/cvq/schema/mcr" 
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
	      <xsl:with-param name="RequestName">Demande de recensement militaire</xsl:with-param>
	      <xsl:with-param name="FriendlyLocalAuthorityName"><xsl:value-of select="$friendlyLocalAuthorityName"/></xsl:with-param>
	    </xsl:call-template>

                <fo:block xsl:use-attribute-sets="request.section.header">Enfant</fo:block>
	    <fo:block>
	      <fo:leader leader-pattern="space" />
	    </fo:block>
        
                    	    <xsl:apply-templates select="//cvq:Subject"/>
      
    
          
                                            
                  <fo:table xsl:use-attribute-sets="request.field.inline.table">
              <xsl:variable name="mod_column" select="'6'"/>
              <xsl:variable name="enum_tokens">
                <xsl:call-template name="split-string">
                        <xsl:with-param name="string" select="//mcr:ChildTitle/text()"/>
                      </xsl:call-template>
              </xsl:variable>
                    <fo:table-column column-width="100pt" />
      
              <xsl:for-each select="locservice:getEnumsDataNode($localizationService,'http://www.cg95.fr/cvq/schema/common','TitleType','fr')//ref:data[@name = 'TitleType']/ref:entry">
                <xsl:if test="not(position() &gt; ($mod_column + 1))">
                  <fo:table-column column-width="30pt" />
                  <fo:table-column column-width="proportional-column-width(1) - 30pt"/>
                </xsl:if>
              </xsl:for-each>

              <fo:table-body>
                      <xsl:text disable-output-escaping="yes">&lt;fo:table-row&gt;</xsl:text>
                <fo:table-cell>
	          <fo:block xsl:use-attribute-sets="request.field.inline.label">
		    Civilité*
		  </fo:block>
	        </fo:table-cell>
      
                <xsl:for-each select="locservice:getEnumsDataNode($localizationService,'http://www.cg95.fr/cvq/schema/common','TitleType','fr')//ref:data[@name = 'TitleType']/ref:entry">

	                	          	          <xsl:if test="(position() != 1) and ((position() mod $mod_column) = 1)">
	            <xsl:text disable-output-escaping="yes">&lt;fo:table-row&gt;</xsl:text>
	                  	              <xsl:text disable-output-escaping="yes">&lt;fo:table-cell&gt;&lt;fo:block&gt;&#160;&lt;/fo:block&gt;&lt;/fo:table-cell&gt;</xsl:text>
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

    
          
                                    <fo:table xsl:use-attribute-sets="request.field.inline.table">
                        <fo:table-column column-width="proportional-column-width(100)" />
          <fo:table-column column-width="proportional-column-width(100)" />
                                <fo:table-column column-width="proportional-column-width(100)" />
          <fo:table-column column-width="proportional-column-width(100)" />
                    	      <fo:table-body>
		<fo:table-row>
      	                        		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.inline.label">
		      Pays de naissance*
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
                                      <xsl:choose>
                        <xsl:when test="//mcr:ChildBirthCountry and //mcr:ChildBirthCountry != ''">
          			  <xsl:variable name="current_value" select="//mcr:ChildBirthCountry"/>
                          <xsl:for-each select="locservice:getEnumsDataNode($localizationService,'http://www.cg95.fr/cvq/schema/common','CountryType','fr')//ref:data[@name = 'CountryType']/ref:entry">
			    <xsl:if test="@key = $current_value">
			      <xsl:value-of select="./ref:label[@lang = 'fr']"/>
			    </xsl:if>
			  </xsl:for-each>
                                  </xsl:when>
                        <xsl:otherwise>
                          <xsl:text>&#160;</xsl:text>
                        </xsl:otherwise>
                      </xsl:choose>
        		    </fo:block>
		  </fo:table-cell>
      	                    		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.inline.label">
		      Pays de résidence
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
                                      <xsl:choose>
                        <xsl:when test="//mcr:ChildResidenceCountry and //mcr:ChildResidenceCountry != ''">
          			  <xsl:variable name="current_value" select="//mcr:ChildResidenceCountry"/>
                          <xsl:for-each select="locservice:getEnumsDataNode($localizationService,'http://www.cg95.fr/cvq/schema/common','CountryType','fr')//ref:data[@name = 'CountryType']/ref:entry">
			    <xsl:if test="@key = $current_value">
			      <xsl:value-of select="./ref:label[@lang = 'fr']"/>
			    </xsl:if>
			  </xsl:for-each>
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
          <fo:table-column column-width="proportional-column-width(100)" />
                                <fo:table-column column-width="proportional-column-width(100)" />
          <fo:table-column column-width="proportional-column-width(100)" />
                    	      <fo:table-body>
		<fo:table-row>
      	                        		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.inline.label">
		      Téléphone*
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
                                      <xsl:choose>
                        <xsl:when test="//mcr:ChildPhone and //mcr:ChildPhone != ''">
                                    <xsl:value-of select="//mcr:ChildPhone" />
                                  </xsl:when>
                        <xsl:otherwise>
                          <xsl:text>&#160;</xsl:text>
                        </xsl:otherwise>
                      </xsl:choose>
        		    </fo:block>
		  </fo:table-cell>
      	                    		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.inline.label">
		      Courriel
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
                                      <xsl:choose>
                        <xsl:when test="//mcr:ChildMail and //mcr:ChildMail != ''">
                                    <xsl:value-of select="//mcr:ChildMail" />
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
  
                  <fo:block xsl:use-attribute-sets="request.section.header">Nationalité</fo:block>
	    <fo:block>
	      <fo:leader leader-pattern="space" />
	    </fo:block>
        
                                    <fo:table xsl:use-attribute-sets="request.field.inline.table">
                        <fo:table-column column-width="proportional-column-width(100)" />
          <fo:table-column column-width="proportional-column-width(100)" />
                                <fo:table-column column-width="proportional-column-width(100)" />
          <fo:table-column column-width="proportional-column-width(100)" />
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
                        <xsl:when test="//mcr:ChildCountry and //mcr:ChildCountry != ''">
          			  <xsl:variable name="current_value" select="//mcr:ChildCountry"/>
                          <xsl:for-each select="locservice:getEnumsDataNode($localizationService,'http://www.cg95.fr/cvq/schema/common','FullNationalityType','fr')//ref:data[@name = 'FullNationalityType']/ref:entry">
			    <xsl:if test="@key = $current_value">
			      <xsl:value-of select="./ref:label[@lang = 'fr']"/>
			    </xsl:if>
			  </xsl:for-each>
                                  </xsl:when>
                        <xsl:otherwise>
                          <xsl:text>&#160;</xsl:text>
                        </xsl:otherwise>
                      </xsl:choose>
        		    </fo:block>
		  </fo:table-cell>
      	                    		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.inline.label">
		      Deuxième nationalité
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
                                      <xsl:choose>
                        <xsl:when test="//mcr:ChildOtherCountry and //mcr:ChildOtherCountry != ''">
          			  <xsl:variable name="current_value" select="//mcr:ChildOtherCountry"/>
                          <xsl:for-each select="locservice:getEnumsDataNode($localizationService,'http://www.cg95.fr/cvq/schema/common','FullNationalityType','fr')//ref:data[@name = 'FullNationalityType']/ref:entry">
			    <xsl:if test="@key = $current_value">
			      <xsl:value-of select="./ref:label[@lang = 'fr']"/>
			    </xsl:if>
			  </xsl:for-each>
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
          <fo:table-column column-width="proportional-column-width(100)" />
                    	      <fo:table-column column-width="proportional-column-width(200)" />
      	      <fo:table-body>
		<fo:table-row>
      	                    		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.inline.label">
		      Convention internationale
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
                                      <xsl:choose>
                        <xsl:when test="//mcr:ChildConvention and //mcr:ChildConvention != ''">
                                    <xsl:value-of select="//mcr:ChildConvention" />
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
  
                  <fo:block xsl:use-attribute-sets="request.section.header">Filiation</fo:block>
	    <fo:block>
	      <fo:leader leader-pattern="space" />
	    </fo:block>
        
                                    <fo:table xsl:use-attribute-sets="request.field.inline.table">
                        <fo:table-column column-width="proportional-column-width(100)" />
          <fo:table-column column-width="proportional-column-width(100)" />
                                <fo:table-column column-width="proportional-column-width(100)" />
          <fo:table-column column-width="proportional-column-width(100)" />
                    	      <fo:table-body>
		<fo:table-row>
      	                    		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.inline.label">
		      Nom du père
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
                                      <xsl:choose>
                        <xsl:when test="//mcr:FatherLastName and //mcr:FatherLastName != ''">
                                    <xsl:value-of select="//mcr:FatherLastName" />
                                  </xsl:when>
                        <xsl:otherwise>
                          <xsl:text>&#160;</xsl:text>
                        </xsl:otherwise>
                      </xsl:choose>
        		    </fo:block>
		  </fo:table-cell>
      	                    		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.inline.label">
		      Prénom du père
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
                                      <xsl:choose>
                        <xsl:when test="//mcr:FatherFirstName and //mcr:FatherFirstName != ''">
                                    <xsl:value-of select="//mcr:FatherFirstName" />
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
          <fo:table-column column-width="proportional-column-width(100)" />
                                <fo:table-column column-width="proportional-column-width(100)" />
          <fo:table-column column-width="proportional-column-width(100)" />
                    	      <fo:table-body>
		<fo:table-row>
      	                    		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.inline.label">
		      Date de naissance du père
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
                	              <xsl:call-template name="cvq:DisplayDate">
		        <xsl:with-param name="DateToDisplay">
		          <xsl:value-of select="//mcr:FatherBirthDate"/>
		        </xsl:with-param>
	              </xsl:call-template>
			    </fo:block>
		  </fo:table-cell>
      	                    		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.inline.label">
		      Ville de naissance du père
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
                                      <xsl:choose>
                        <xsl:when test="//mcr:FatherBirthCity and //mcr:FatherBirthCity != ''">
                                    <xsl:value-of select="//mcr:FatherBirthCity" />
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
          <fo:table-column column-width="proportional-column-width(100)" />
                                <fo:table-column column-width="proportional-column-width(100)" />
          <fo:table-column column-width="proportional-column-width(100)" />
                    	      <fo:table-body>
		<fo:table-row>
      	                    		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.inline.label">
		      Département de naissance du père
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
                                      <xsl:choose>
                        <xsl:when test="//mcr:FatherBirthDepartment and //mcr:FatherBirthDepartment != ''">
          			  <xsl:variable name="current_value" select="//mcr:FatherBirthDepartment"/>
                          <xsl:for-each select="locservice:getEnumsDataNode($localizationService,'http://www.cg95.fr/cvq/schema/common','InseeDepartementCodeType','fr')//ref:data[@name = 'InseeDepartementCodeType']/ref:entry">
			    <xsl:if test="@key = $current_value">
			      <xsl:value-of select="./ref:label[@lang = 'fr']"/>
			    </xsl:if>
			  </xsl:for-each>
                                  </xsl:when>
                        <xsl:otherwise>
                          <xsl:text>&#160;</xsl:text>
                        </xsl:otherwise>
                      </xsl:choose>
        		    </fo:block>
		  </fo:table-cell>
      	                    		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.inline.label">
		      Pays de naissance du père
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
                                      <xsl:choose>
                        <xsl:when test="//mcr:FatherBirthCountry and //mcr:FatherBirthCountry != ''">
          			  <xsl:variable name="current_value" select="//mcr:FatherBirthCountry"/>
                          <xsl:for-each select="locservice:getEnumsDataNode($localizationService,'http://www.cg95.fr/cvq/schema/common','CountryType','fr')//ref:data[@name = 'CountryType']/ref:entry">
			    <xsl:if test="@key = $current_value">
			      <xsl:value-of select="./ref:label[@lang = 'fr']"/>
			    </xsl:if>
			  </xsl:for-each>
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
          <fo:table-column column-width="proportional-column-width(100)" />
                    	      <fo:table-column column-width="proportional-column-width(200)" />
      	      <fo:table-body>
		<fo:table-row>
      	                    		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.inline.label">
		      Nationalité du père
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
                                      <xsl:choose>
                        <xsl:when test="//mcr:FatherNationality and //mcr:FatherNationality != ''">
          			  <xsl:variable name="current_value" select="//mcr:FatherNationality"/>
                          <xsl:for-each select="locservice:getEnumsDataNode($localizationService,'http://www.cg95.fr/cvq/schema/common','FullNationalityType','fr')//ref:data[@name = 'FullNationalityType']/ref:entry">
			    <xsl:if test="@key = $current_value">
			      <xsl:value-of select="./ref:label[@lang = 'fr']"/>
			    </xsl:if>
			  </xsl:for-each>
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
                                <fo:table-column column-width="proportional-column-width(100)" />
          <fo:table-column column-width="proportional-column-width(100)" />
                    	      <fo:table-body>
		<fo:table-row>
      	                        		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.inline.label">
		      Nom de jeune fille de la mère*
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
                                      <xsl:choose>
                        <xsl:when test="//mcr:MotherLastName and //mcr:MotherLastName != ''">
                                    <xsl:value-of select="//mcr:MotherLastName" />
                                  </xsl:when>
                        <xsl:otherwise>
                          <xsl:text>&#160;</xsl:text>
                        </xsl:otherwise>
                      </xsl:choose>
        		    </fo:block>
		  </fo:table-cell>
      	                        		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.inline.label">
		      Prénom de la mère*
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
                                      <xsl:choose>
                        <xsl:when test="//mcr:MotherFirstName and //mcr:MotherFirstName != ''">
                                    <xsl:value-of select="//mcr:MotherFirstName" />
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
          <fo:table-column column-width="proportional-column-width(100)" />
                                <fo:table-column column-width="proportional-column-width(100)" />
          <fo:table-column column-width="proportional-column-width(100)" />
                    	      <fo:table-body>
		<fo:table-row>
      	                        		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.inline.label">
		      Date de naissance de la mère*
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
                	              <xsl:call-template name="cvq:DisplayDate">
		        <xsl:with-param name="DateToDisplay">
		          <xsl:value-of select="//mcr:MotherBirthDate"/>
		        </xsl:with-param>
	              </xsl:call-template>
			    </fo:block>
		  </fo:table-cell>
      	                        		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.inline.label">
		      Ville de naissance de la mère*
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
                                      <xsl:choose>
                        <xsl:when test="//mcr:MotherBirthCity and //mcr:MotherBirthCity != ''">
                                    <xsl:value-of select="//mcr:MotherBirthCity" />
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
          <fo:table-column column-width="proportional-column-width(100)" />
                                <fo:table-column column-width="proportional-column-width(100)" />
          <fo:table-column column-width="proportional-column-width(100)" />
                    	      <fo:table-body>
		<fo:table-row>
      	                    		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.inline.label">
		      Département de naissance de la mère
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
                                      <xsl:choose>
                        <xsl:when test="//mcr:MotherBirthDepartment and //mcr:MotherBirthDepartment != ''">
          			  <xsl:variable name="current_value" select="//mcr:MotherBirthDepartment"/>
                          <xsl:for-each select="locservice:getEnumsDataNode($localizationService,'http://www.cg95.fr/cvq/schema/common','InseeDepartementCodeType','fr')//ref:data[@name = 'InseeDepartementCodeType']/ref:entry">
			    <xsl:if test="@key = $current_value">
			      <xsl:value-of select="./ref:label[@lang = 'fr']"/>
			    </xsl:if>
			  </xsl:for-each>
                                  </xsl:when>
                        <xsl:otherwise>
                          <xsl:text>&#160;</xsl:text>
                        </xsl:otherwise>
                      </xsl:choose>
        		    </fo:block>
		  </fo:table-cell>
      	                    		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.inline.label">
		      Pays de naissance de la mère
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
                                      <xsl:choose>
                        <xsl:when test="//mcr:MotherBirthCountry and //mcr:MotherBirthCountry != ''">
          			  <xsl:variable name="current_value" select="//mcr:MotherBirthCountry"/>
                          <xsl:for-each select="locservice:getEnumsDataNode($localizationService,'http://www.cg95.fr/cvq/schema/common','CountryType','fr')//ref:data[@name = 'CountryType']/ref:entry">
			    <xsl:if test="@key = $current_value">
			      <xsl:value-of select="./ref:label[@lang = 'fr']"/>
			    </xsl:if>
			  </xsl:for-each>
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
          <fo:table-column column-width="proportional-column-width(100)" />
                    	      <fo:table-column column-width="proportional-column-width(200)" />
      	      <fo:table-body>
		<fo:table-row>
      	                        		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.inline.label">
		      Nationalité de la mère*
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
                                      <xsl:choose>
                        <xsl:when test="//mcr:MotherNationality and //mcr:MotherNationality != ''">
          			  <xsl:variable name="current_value" select="//mcr:MotherNationality"/>
                          <xsl:for-each select="locservice:getEnumsDataNode($localizationService,'http://www.cg95.fr/cvq/schema/common','FullNationalityType','fr')//ref:data[@name = 'FullNationalityType']/ref:entry">
			    <xsl:if test="@key = $current_value">
			      <xsl:value-of select="./ref:label[@lang = 'fr']"/>
			    </xsl:if>
			  </xsl:for-each>
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
  
                  <fo:block xsl:use-attribute-sets="request.section.header">Situation Familiale</fo:block>
	    <fo:block>
	      <fo:leader leader-pattern="space" />
	    </fo:block>
        
                                    <fo:table xsl:use-attribute-sets="request.field.inline.table">
                        <fo:table-column column-width="proportional-column-width(200 * 1) - 30pt" />
          <fo:table-column column-width="30pt" />
                                <fo:table-column column-width="proportional-column-width(200 * 1) - 30pt" />
          <fo:table-column column-width="30pt" />
                    	      <fo:table-body>
		<fo:table-row>
      	                        		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.inline.label">
		      Nombre de frères et soeurs vivants*
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.char_value">
                                      <xsl:choose>
                        <xsl:when test="//mcr:AliveChildren and //mcr:AliveChildren != ''">
                                    <xsl:value-of select="//mcr:AliveChildren" />
                                  </xsl:when>
                        <xsl:otherwise>
                          <xsl:text>&#160;</xsl:text>
                        </xsl:otherwise>
                      </xsl:choose>
        		    </fo:block>
		  </fo:table-cell>
      	                        		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.inline.label">
		      Nombre d'enfants à charge*
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.char_value">
                                      <xsl:choose>
                        <xsl:when test="//mcr:ChildrenInCharge and //mcr:ChildrenInCharge != ''">
                                    <xsl:value-of select="//mcr:ChildrenInCharge" />
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
              <xsl:variable name="mod_column" select="'6'"/>
              <xsl:variable name="enum_tokens">
                <xsl:call-template name="split-string">
                        <xsl:with-param name="string" select="//mcr:ChildStatus/text()"/>
                      </xsl:call-template>
              </xsl:variable>
                    <fo:table-column column-width="100pt" />
      
              <xsl:for-each select="locservice:getEnumsDataNode($localizationService,'http://www.cg95.fr/cvq/schema/common','FamilyStatusType','fr')//ref:data[@name = 'FamilyStatusType']/ref:entry">
                <xsl:if test="not(position() &gt; ($mod_column + 1))">
                  <fo:table-column column-width="30pt" />
                  <fo:table-column column-width="proportional-column-width(1) - 30pt"/>
                </xsl:if>
              </xsl:for-each>

              <fo:table-body>
                      <xsl:text disable-output-escaping="yes">&lt;fo:table-row&gt;</xsl:text>
                <fo:table-cell>
	          <fo:block xsl:use-attribute-sets="request.field.inline.label">
		    Situation familiale*
		  </fo:block>
	        </fo:table-cell>
      
                <xsl:for-each select="locservice:getEnumsDataNode($localizationService,'http://www.cg95.fr/cvq/schema/common','FamilyStatusType','fr')//ref:data[@name = 'FamilyStatusType']/ref:entry">

	                	          	          <xsl:if test="(position() != 1) and ((position() mod $mod_column) = 1)">
	            <xsl:text disable-output-escaping="yes">&lt;fo:table-row&gt;</xsl:text>
	                  	              <xsl:text disable-output-escaping="yes">&lt;fo:table-cell&gt;&lt;fo:block&gt;&#160;&lt;/fo:block&gt;&lt;/fo:table-cell&gt;</xsl:text>
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

    
          
                              <fo:table xsl:use-attribute-sets="request.field.inline.table">
                        <fo:table-column column-width="proportional-column-width(100)" />
          <fo:table-column column-width="proportional-column-width(100)" />
                    	      <fo:table-column column-width="proportional-column-width(200)" />
      	      <fo:table-body>
		<fo:table-row>
      	                    		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.inline.label">
		      Autre situation
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
                                      <xsl:choose>
                        <xsl:when test="//mcr:OtherSituation and //mcr:OtherSituation != ''">
                                    <xsl:value-of select="//mcr:OtherSituation" />
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
		      Pupille de l'état*
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.yesno.label">OUI</fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.yesno.value">
		      <xsl:if test="//mcr:StatePupil = &quot;true&quot;">X</xsl:if>
		      <xsl:if test="//mcr:StatePupil = &quot;false&quot;">&#160;</xsl:if>
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.yesno.label">NON</fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.yesno.value">
		      <xsl:if test="//mcr:StatePupil = &quot;false&quot;">X</xsl:if>
		      <xsl:if test="//mcr:StatePupil = &quot;true&quot;">&#160;</xsl:if>
		    </fo:block>
		  </fo:table-cell>
      		  <fo:table-cell>
		    <fo:block>&#160;</fo:block>
		  </fo:table-cell>
      		</fo:table-row>
	      </fo:table-body>
	    </fo:table>

    
          
                                
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
		      Pupille du préfet*
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.yesno.label">OUI</fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.yesno.value">
		      <xsl:if test="//mcr:PrefectPupil = &quot;true&quot;">X</xsl:if>
		      <xsl:if test="//mcr:PrefectPupil = &quot;false&quot;">&#160;</xsl:if>
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.yesno.label">NON</fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.yesno.value">
		      <xsl:if test="//mcr:PrefectPupil = &quot;false&quot;">X</xsl:if>
		      <xsl:if test="//mcr:PrefectPupil = &quot;true&quot;">&#160;</xsl:if>
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
		      Pupille du préfet du département
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
                                      <xsl:choose>
                        <xsl:when test="//mcr:PrefectPupilDepartment and //mcr:PrefectPupilDepartment != ''">
          			  <xsl:variable name="current_value" select="//mcr:PrefectPupilDepartment"/>
                          <xsl:for-each select="locservice:getEnumsDataNode($localizationService,'http://www.cg95.fr/cvq/schema/common','InseeDepartementCodeType','fr')//ref:data[@name = 'InseeDepartementCodeType']/ref:entry">
			    <xsl:if test="@key = $current_value">
			      <xsl:value-of select="./ref:label[@lang = 'fr']"/>
			    </xsl:if>
			  </xsl:for-each>
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

    
      
              <fo:block break-after="page"/>
  
                  <fo:block xsl:use-attribute-sets="request.section.header">Situation Professionnelle</fo:block>
	    <fo:block>
	      <fo:leader leader-pattern="space" />
	    </fo:block>
        
                                    <fo:table xsl:use-attribute-sets="request.field.inline.table">
                        <fo:table-column column-width="proportional-column-width(100)" />
          <fo:table-column column-width="proportional-column-width(100)" />
                                <fo:table-column column-width="proportional-column-width(100)" />
          <fo:table-column column-width="proportional-column-width(100)" />
                    	      <fo:table-body>
		<fo:table-row>
      	                        		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.inline.label">
		      Situation scolaire ou professionnelle*
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
                                      <xsl:choose>
                        <xsl:when test="//mcr:ChildSituation and //mcr:ChildSituation != ''">
          			  <xsl:variable name="current_value" select="//mcr:ChildSituation"/>
                          <xsl:for-each select="locservice:getEnumsDataNode($localizationService,'http://www.cg95.fr/cvq/schema/mcr','ChildSituationType','fr')//ref:data[@name = 'ChildSituationType']/ref:entry">
			    <xsl:if test="@key = $current_value">
			      <xsl:value-of select="./ref:label[@lang = 'fr']"/>
			    </xsl:if>
			  </xsl:for-each>
                                  </xsl:when>
                        <xsl:otherwise>
                          <xsl:text>&#160;</xsl:text>
                        </xsl:otherwise>
                      </xsl:choose>
        		    </fo:block>
		  </fo:table-cell>
      	                        		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.inline.label">
		      Diplôme*
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
                                      <xsl:choose>
                        <xsl:when test="//mcr:ChildDiploma and //mcr:ChildDiploma != ''">
          			  <xsl:variable name="current_value" select="//mcr:ChildDiploma"/>
                          <xsl:for-each select="locservice:getEnumsDataNode($localizationService,'http://www.cg95.fr/cvq/schema/mcr','ChildDiplomaType','fr')//ref:data[@name = 'ChildDiplomaType']/ref:entry">
			    <xsl:if test="@key = $current_value">
			      <xsl:value-of select="./ref:label[@lang = 'fr']"/>
			    </xsl:if>
			  </xsl:for-each>
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
          <fo:table-column column-width="proportional-column-width(100)" />
                                <fo:table-column column-width="proportional-column-width(100)" />
          <fo:table-column column-width="proportional-column-width(100)" />
                    	      <fo:table-body>
		<fo:table-row>
      	                    		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.inline.label">
		      Spécialité
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
                                      <xsl:choose>
                        <xsl:when test="//mcr:ChildSpeciality and //mcr:ChildSpeciality != ''">
                                    <xsl:value-of select="//mcr:ChildSpeciality" />
                                  </xsl:when>
                        <xsl:otherwise>
                          <xsl:text>&#160;</xsl:text>
                        </xsl:otherwise>
                      </xsl:choose>
        		    </fo:block>
		  </fo:table-cell>
      	                    		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.inline.label">
		      Profession
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
                                      <xsl:choose>
                        <xsl:when test="//mcr:ChildProfession and //mcr:ChildProfession != ''">
                                    <xsl:value-of select="//mcr:ChildProfession" />
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
  
                  <fo:block xsl:use-attribute-sets="request.section.header">Exemption</fo:block>
	    <fo:block>
	      <fo:leader leader-pattern="space" />
	    </fo:block>
        
                                
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
		      Exemption JAPD*
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.yesno.label">OUI</fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.yesno.value">
		      <xsl:if test="//mcr:JapdExemption = &quot;true&quot;">X</xsl:if>
		      <xsl:if test="//mcr:JapdExemption = &quot;false&quot;">&#160;</xsl:if>
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.yesno.label">NON</fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.yesno.value">
		      <xsl:if test="//mcr:JapdExemption = &quot;false&quot;">X</xsl:if>
		      <xsl:if test="//mcr:JapdExemption = &quot;true&quot;">&#160;</xsl:if>
		    </fo:block>
		  </fo:table-cell>
      		  <fo:table-cell>
		    <fo:block>&#160;</fo:block>
		  </fo:table-cell>
      		</fo:table-row>
	      </fo:table-body>
	    </fo:table>

    
          
                            
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
		      Grand Infirme
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.yesno.label">OUI</fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.yesno.value">
		      <xsl:if test="//mcr:HighlyInfirm = &quot;true&quot;">X</xsl:if>
		      <xsl:if test="//mcr:HighlyInfirm = &quot;false&quot;">&#160;</xsl:if>
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.yesno.label">NON</fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.yesno.value">
		      <xsl:if test="//mcr:HighlyInfirm = &quot;false&quot;">X</xsl:if>
		      <xsl:if test="//mcr:HighlyInfirm = &quot;true&quot;">&#160;</xsl:if>
		    </fo:block>
		  </fo:table-cell>
      		  <fo:table-cell>
		    <fo:block>&#160;</fo:block>
		  </fo:table-cell>
      		</fo:table-row>
	      </fo:table-body>
	    </fo:table>

    
          
                            
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
		      Affection ou maladie
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.yesno.label">OUI</fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.yesno.value">
		      <xsl:if test="//mcr:AffectionOrDisease = &quot;true&quot;">X</xsl:if>
		      <xsl:if test="//mcr:AffectionOrDisease = &quot;false&quot;">&#160;</xsl:if>
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.yesno.label">NON</fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.yesno.value">
		      <xsl:if test="//mcr:AffectionOrDisease = &quot;false&quot;">X</xsl:if>
		      <xsl:if test="//mcr:AffectionOrDisease = &quot;true&quot;">&#160;</xsl:if>
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
            <xsl:value-of select="mcr:MilitaryCensusRequest/cvq:Id"/>
          </xsl:with-param>
	      <xsl:with-param name="CreationDate">
            <xsl:value-of select="mcr:MilitaryCensusRequest/cvq:CreationDate"/>
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
                                                                                                                                                                              <xsl:template match="//cvq:MeansOfContact">
          <xsl:call-template name="MeansOfContactType">
      <xsl:with-param name="localizationService" select="$localizationService"></xsl:with-param>
    </xsl:call-template>
  </xsl:template>
      </xsl:stylesheet>
