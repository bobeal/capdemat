<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" 
  xmlns:bdr="http://www.cg95.fr/cvq/schema/bdr" 
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
	      <xsl:with-param name="RequestName">Demande extrait d'acte naissance</xsl:with-param>
	      <xsl:with-param name="FriendlyLocalAuthorityName"><xsl:value-of select="$friendlyLocalAuthorityName"/></xsl:with-param>
	    </xsl:call-template>

                <fo:block xsl:use-attribute-sets="request.section.header">Renseignements concernant l'acte de naissance</fo:block>
	    <fo:block>
	      <fo:leader leader-pattern="space" />
	    </fo:block>
        
                                            
                  <fo:table xsl:use-attribute-sets="request.field.inline.table">
              <xsl:variable name="mod_column" select="'2'"/>
              <xsl:variable name="enum_tokens">
                <xsl:call-template name="split-string">
                        <xsl:with-param name="string" select="//bdr:Format/text()"/>
                      </xsl:call-template>
              </xsl:variable>
                    <fo:table-column column-width="100pt" />
      
              <xsl:for-each select="locservice:getEnumsDataNode($localizationService,'http://www.cg95.fr/cvq/schema/bdr','BirthCertificateFormatType','fr')//ref:data[@name = 'BirthCertificateFormatType']/ref:entry">
                <xsl:if test="not(position() &gt; ($mod_column + 1))">
                  <fo:table-column column-width="30pt" />
                  <fo:table-column column-width="proportional-column-width(1) - 30pt"/>
                </xsl:if>
              </xsl:for-each>

              <fo:table-body>
                      <xsl:text disable-output-escaping="yes">&lt;fo:table-row&gt;</xsl:text>
                <fo:table-cell>
	          <fo:block xsl:use-attribute-sets="request.field.inline.label">
		    Type de l'acte*
		  </fo:block>
	        </fo:table-cell>
      
                <xsl:for-each select="locservice:getEnumsDataNode($localizationService,'http://www.cg95.fr/cvq/schema/bdr','BirthCertificateFormatType','fr')//ref:data[@name = 'BirthCertificateFormatType']/ref:entry">

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
                        <fo:table-column column-width="proportional-column-width(200 * 1) - 30pt" />
          <fo:table-column column-width="30pt" />
                                <fo:table-column column-width="proportional-column-width(200)" />
          <fo:table-column column-width="proportional-column-width(200)" />
                    	      <fo:table-body>
		<fo:table-row>
      	                        		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.inline.label">
		      Nombre d'actes souhaité*
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.char_value">
                                      <xsl:choose>
                        <xsl:when test="//bdr:Copies and //bdr:Copies != ''">
                                    <xsl:value-of select="//bdr:Copies" />
                                  </xsl:when>
                        <xsl:otherwise>
                          <xsl:text>&#160;</xsl:text>
                        </xsl:otherwise>
                      </xsl:choose>
        		    </fo:block>
		  </fo:table-cell>
      	                    		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.inline.label">
		      Précisez le ou les usage(s) de ce ou ces document(s)
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
                                      <xsl:choose>
                        <xsl:when test="//bdr:Usage and //bdr:Usage != ''">
                                    <xsl:value-of select="//bdr:Usage" />
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
  
                  <fo:block xsl:use-attribute-sets="request.section.header">Renseignements concernant le demandeur</fo:block>
	    <fo:block>
	      <fo:leader leader-pattern="space" />
	    </fo:block>
        
                    	    <xsl:apply-templates select="//cvq:Requester"/>
      
    
      
              <fo:block>
              <fo:leader leader-pattern="space" />
            </fo:block>
  
                  <fo:block xsl:use-attribute-sets="request.section.header">Qualité du demandeur (lien de parenté avec la personne dont vous demandez l'acte)</fo:block>
	    <fo:block>
	      <fo:leader leader-pattern="space" />
	    </fo:block>
        
                                    
                  <fo:table xsl:use-attribute-sets="request.field.inline.table">
              <xsl:variable name="mod_column" select="'2'"/>
              <xsl:variable name="enum_tokens">
                <xsl:call-template name="split-string">
                        <xsl:with-param name="string" select="//bdr:RequesterQuality/text()"/>
                      </xsl:call-template>
              </xsl:variable>
      
              <xsl:for-each select="locservice:getEnumsDataNode($localizationService,'http://www.cg95.fr/cvq/schema/bdr','BirthRequesterQualityType','fr')//ref:data[@name = 'BirthRequesterQualityType']/ref:entry">
                <xsl:if test="not(position() &gt; ($mod_column + 1))">
                  <fo:table-column column-width="30pt" />
                  <fo:table-column column-width="proportional-column-width(1) - 30pt"/>
                </xsl:if>
              </xsl:for-each>

              <fo:table-body>
      
                <xsl:for-each select="locservice:getEnumsDataNode($localizationService,'http://www.cg95.fr/cvq/schema/bdr','BirthRequesterQualityType','fr')//ref:data[@name = 'BirthRequesterQualityType']/ref:entry">

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

    
          
                              <fo:table xsl:use-attribute-sets="request.field.inline.table">
                        <fo:table-column column-width="proportional-column-width(50)" />
          <fo:table-column column-width="proportional-column-width(150)" />
                    	      <fo:table-body>
		<fo:table-row>
      	                    		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.inline.label">
		      Précisez (votre lien si autre, votre qualité (art. 197-5 de l'IGREC) si avocat ou notaire)
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
                                      <xsl:choose>
                        <xsl:when test="//bdr:RequesterQualityPrecision and //bdr:RequesterQualityPrecision != ''">
                                    <xsl:value-of select="//bdr:RequesterQualityPrecision" />
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

    
      
              <fo:block break-after="page"/>
  
                  <fo:block xsl:use-attribute-sets="request.section.header">Etat civil de la personne dont vous demandez l'acte de naissance</fo:block>
	    <fo:block>
	      <fo:leader leader-pattern="space" />
	    </fo:block>
        
                              <fo:table xsl:use-attribute-sets="request.field.inline.table">
                        <fo:table-column column-width="proportional-column-width(100)" />
          <fo:table-column column-width="proportional-column-width(300)" />
                    	      <fo:table-body>
		<fo:table-row>
      	                        		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.inline.label">
		      Nom*
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
                                      <xsl:choose>
                        <xsl:when test="//bdr:BirthLastName and //bdr:BirthLastName != ''">
                                    <xsl:value-of select="//bdr:BirthLastName" />
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
          <fo:table-column column-width="proportional-column-width(300)" />
                    	      <fo:table-body>
		<fo:table-row>
      	                        		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.inline.label">
		      Prénom(s)*
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
                                      <xsl:choose>
                        <xsl:when test="//bdr:BirthFirstNames and //bdr:BirthFirstNames != ''">
                                    <xsl:value-of select="//bdr:BirthFirstNames" />
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
		      Date de naissance*
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
                	              <xsl:call-template name="cvq:DisplayDate">
		        <xsl:with-param name="DateToDisplay">
		          <xsl:value-of select="//bdr:BirthDate"/>
		        </xsl:with-param>
	              </xsl:call-template>
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
		      Ville de naissance*
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
                                      <xsl:choose>
                        <xsl:when test="//bdr:BirthCity and //bdr:BirthCity != ''">
                                    <xsl:value-of select="//bdr:BirthCity" />
                                  </xsl:when>
                        <xsl:otherwise>
                          <xsl:text>&#160;</xsl:text>
                        </xsl:otherwise>
                      </xsl:choose>
        		    </fo:block>
		  </fo:table-cell>
      	                        		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.inline.label">
		      Département de naissance*
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
                                      <xsl:choose>
                        <xsl:when test="//bdr:BirthPostalCode and //bdr:BirthPostalCode != ''">
                                    <xsl:value-of select="//bdr:BirthPostalCode" />
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
  
                <xsl:if test="//bdr:Format/text() = 'ExtractWithRelationship' or //bdr:Format/text() = 'FullCopy'">
                <fo:block xsl:use-attribute-sets="request.section.header">Informations de filiation de la personne dont vous demandez l'acte</fo:block>
	    <fo:block>
	      <fo:leader leader-pattern="space" />
	    </fo:block>
        
                                            
                  <fo:table xsl:use-attribute-sets="request.field.inline.table">
              <xsl:variable name="mod_column" select="'2'"/>
              <xsl:variable name="enum_tokens">
                <xsl:call-template name="split-string">
                        <xsl:with-param name="string" select="//bdr:Relationship/text()"/>
                      </xsl:call-template>
              </xsl:variable>
                    <fo:table-column column-width="100pt" />
      
              <xsl:for-each select="locservice:getEnumsDataNode($localizationService,'http://www.cg95.fr/cvq/schema/bdr','BirthRelationshipType','fr')//ref:data[@name = 'BirthRelationshipType']/ref:entry">
                <xsl:if test="not(position() &gt; ($mod_column + 1))">
                  <fo:table-column column-width="30pt" />
                  <fo:table-column column-width="proportional-column-width(1) - 30pt"/>
                </xsl:if>
              </xsl:for-each>

              <fo:table-body>
                      <xsl:text disable-output-escaping="yes">&lt;fo:table-row&gt;</xsl:text>
                <fo:table-cell>
	          <fo:block xsl:use-attribute-sets="request.field.inline.label">
		    Filiation de*
		  </fo:block>
	        </fo:table-cell>
      
                <xsl:for-each select="locservice:getEnumsDataNode($localizationService,'http://www.cg95.fr/cvq/schema/bdr','BirthRelationshipType','fr')//ref:data[@name = 'BirthRelationshipType']/ref:entry">

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
                        <fo:table-column column-width="proportional-column-width(50)" />
          <fo:table-column column-width="proportional-column-width(150)" />
                    	      <fo:table-body>
		<fo:table-row>
      	                        		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.inline.label">
		      Nom du père*
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
                                      <xsl:choose>
                        <xsl:when test="//bdr:FatherLastName and //bdr:FatherLastName != ''">
                                    <xsl:value-of select="//bdr:FatherLastName" />
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
                        <fo:table-column column-width="proportional-column-width(50)" />
          <fo:table-column column-width="proportional-column-width(150)" />
                    	      <fo:table-body>
		<fo:table-row>
      	                        		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.inline.label">
		      Prénom(s) du père*
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
                                      <xsl:choose>
                        <xsl:when test="//bdr:FatherFirstNames and //bdr:FatherFirstNames != ''">
                                    <xsl:value-of select="//bdr:FatherFirstNames" />
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
                        <fo:table-column column-width="proportional-column-width(50)" />
          <fo:table-column column-width="proportional-column-width(150)" />
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
                        <xsl:when test="//bdr:MotherMaidenName and //bdr:MotherMaidenName != ''">
                                    <xsl:value-of select="//bdr:MotherMaidenName" />
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
                        <fo:table-column column-width="proportional-column-width(50)" />
          <fo:table-column column-width="proportional-column-width(150)" />
                    	      <fo:table-body>
		<fo:table-row>
      	                        		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.inline.label">
		      Prénom(s) de la mère*
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
                                      <xsl:choose>
                        <xsl:when test="//bdr:MotherFirstNames and //bdr:MotherFirstNames != ''">
                                    <xsl:value-of select="//bdr:MotherFirstNames" />
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
  
              </xsl:if>
  
	    <xsl:call-template name="requestFooter">
	      <xsl:with-param name="RequestId">
            <xsl:value-of select="bdr:BirthDetailsRequest/cvq:Id"/>
          </xsl:with-param>
	      <xsl:with-param name="CreationDate">
            <xsl:value-of select="bdr:BirthDetailsRequest/cvq:CreationDate"/>
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
                                                                              </xsl:stylesheet>
