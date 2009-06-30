<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" 
  xmlns:sgr="http://www.cg95.fr/cvq/schema/sgr" 
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
	      <xsl:with-param name="RequestName">Demande de Mobil'Etudes</xsl:with-param>
	      <xsl:with-param name="FriendlyLocalAuthorityName"><xsl:value-of select="$friendlyLocalAuthorityName"/></xsl:with-param>
	    </xsl:call-template>

                <fo:block xsl:use-attribute-sets="request.section.header">État civil de l'étudiant</fo:block>
	    <fo:block>
	      <fo:leader leader-pattern="space" />
	    </fo:block>
        
                    	    <xsl:apply-templates select="//cvq:Subject"/>
      
    
          
                  <xsl:variable name="withTotal" select="'false'" />

    <xsl:for-each select="//sgr:SubjectInformations">
                                                        <xsl:apply-templates select="./sgr:SubjectAddress"/>
                                                              <fo:table xsl:use-attribute-sets="request.field.inline.table">
  <fo:table-column column-width="proportional-column-width(100)" />
  <fo:table-column column-width="proportional-column-width(200)" />
  <fo:table-column column-width="proportional-column-width(100)" />
  
  <fo:table-body>
    <fo:table-row>
      <fo:table-cell>
       <fo:block xsl:use-attribute-sets="request.field.inline.label">
	Téléphone fixe
       </fo:block>
      </fo:table-cell>
      <fo:table-cell>
        <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
            <xsl:choose>
            <xsl:when test="./sgr:SubjectPhone and ./sgr:SubjectPhone != ''">
                  <xsl:value-of select="./sgr:SubjectPhone" />
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
	Téléphone mobile
       </fo:block>
      </fo:table-cell>
      <fo:table-cell>
        <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
            <xsl:choose>
            <xsl:when test="./sgr:SubjectMobilePhone and ./sgr:SubjectMobilePhone != ''">
                  <xsl:value-of select="./sgr:SubjectMobilePhone" />
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
	Courriel
       </fo:block>
      </fo:table-cell>
      <fo:table-cell>
        <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
            <xsl:choose>
            <xsl:when test="./sgr:SubjectEmail and ./sgr:SubjectEmail != ''">
                  <xsl:value-of select="./sgr:SubjectEmail" />
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
	Date de naissance
       </fo:block>
      </fo:table-cell>
      <fo:table-cell>
        <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
            <xsl:choose>
            <xsl:when test="./sgr:SubjectBirthDate and ./sgr:SubjectBirthDate != ''">
                  <xsl:value-of select="./sgr:SubjectBirthDate" />
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
	Première demande
       </fo:block>
      </fo:table-cell>
      <fo:table-cell>
        <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
            <xsl:choose>
            <xsl:when test="./sgr:SubjectFirstRequest and ./sgr:SubjectFirstRequest != ''">
                  <xsl:value-of select="./sgr:SubjectFirstRequest" />
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
    
      
              <fo:block>
              <fo:leader leader-pattern="space" />
            </fo:block>
  
                  <fo:block xsl:use-attribute-sets="request.section.header">Foyer fiscal de référence</fo:block>
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
		      Nom*
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
                                      <xsl:choose>
                        <xsl:when test="//sgr:TaxHouseholdLastName and //sgr:TaxHouseholdLastName != ''">
                                    <xsl:value-of select="//sgr:TaxHouseholdLastName" />
                                  </xsl:when>
                        <xsl:otherwise>
                          <xsl:text>&#160;</xsl:text>
                        </xsl:otherwise>
                      </xsl:choose>
        		    </fo:block>
		  </fo:table-cell>
      	                        		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.inline.label">
		      Prénom*
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
                                      <xsl:choose>
                        <xsl:when test="//sgr:TaxHouseholdFirstName and //sgr:TaxHouseholdFirstName != ''">
                                    <xsl:value-of select="//sgr:TaxHouseholdFirstName" />
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
		      Précisez la commune
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
                                      <xsl:choose>
                        <xsl:when test="//sgr:TaxHouseholdCityPrecision and //sgr:TaxHouseholdCityPrecision != ''">
                                    <xsl:value-of select="//sgr:TaxHouseholdCityPrecision" />
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
		      Revenu brut global pour l'année 2007 et inférieur à 32 000 euros*
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
                                      <xsl:choose>
                        <xsl:when test="//sgr:TaxHouseholdIncome and //sgr:TaxHouseholdIncome != ''">
                                    <xsl:value-of select="//sgr:TaxHouseholdIncome" />
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
  
                  <fo:block xsl:use-attribute-sets="request.section.header">Autres aides obtenues</fo:block>
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
		      CROUS*
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.yesno.label">OUI</fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.yesno.value">
		      <xsl:if test="//sgr:HasCROUSHelp = &quot;true&quot;">X</xsl:if>
		      <xsl:if test="//sgr:HasCROUSHelp = &quot;false&quot;">&#160;</xsl:if>
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.yesno.label">NON</fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.yesno.value">
		      <xsl:if test="//sgr:HasCROUSHelp = &quot;false&quot;">X</xsl:if>
		      <xsl:if test="//sgr:HasCROUSHelp = &quot;true&quot;">&#160;</xsl:if>
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
		      Conseil Régional*
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.yesno.label">OUI</fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.yesno.value">
		      <xsl:if test="//sgr:HasRegionalCouncilHelp = &quot;true&quot;">X</xsl:if>
		      <xsl:if test="//sgr:HasRegionalCouncilHelp = &quot;false&quot;">&#160;</xsl:if>
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.yesno.label">NON</fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.yesno.value">
		      <xsl:if test="//sgr:HasRegionalCouncilHelp = &quot;false&quot;">X</xsl:if>
		      <xsl:if test="//sgr:HasRegionalCouncilHelp = &quot;true&quot;">&#160;</xsl:if>
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
		      Europe*
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.yesno.label">OUI</fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.yesno.value">
		      <xsl:if test="//sgr:HasEuropeHelp = &quot;true&quot;">X</xsl:if>
		      <xsl:if test="//sgr:HasEuropeHelp = &quot;false&quot;">&#160;</xsl:if>
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.yesno.label">NON</fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.yesno.value">
		      <xsl:if test="//sgr:HasEuropeHelp = &quot;false&quot;">X</xsl:if>
		      <xsl:if test="//sgr:HasEuropeHelp = &quot;true&quot;">&#160;</xsl:if>
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
		      Autres (Établissement ...)*
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.yesno.label">OUI</fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.yesno.value">
		      <xsl:if test="//sgr:HasOtherHelp = &quot;true&quot;">X</xsl:if>
		      <xsl:if test="//sgr:HasOtherHelp = &quot;false&quot;">&#160;</xsl:if>
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.yesno.label">NON</fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.yesno.value">
		      <xsl:if test="//sgr:HasOtherHelp = &quot;false&quot;">X</xsl:if>
		      <xsl:if test="//sgr:HasOtherHelp = &quot;true&quot;">&#160;</xsl:if>
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
  
                  <fo:block xsl:use-attribute-sets="request.section.header">Établissement scolaire d'inscription</fo:block>
	    <fo:block>
	      <fo:leader leader-pattern="space" />
	    </fo:block>
        
                  <xsl:variable name="withTotal" select="'false'" />

    <xsl:for-each select="//sgr:ALevelsInformations">
                                                    <fo:table xsl:use-attribute-sets="request.field.inline.table">
  <fo:table-column column-width="proportional-column-width(100)" />
  <fo:table-column column-width="proportional-column-width(200)" />
  <fo:table-column column-width="proportional-column-width(100)" />
  
  <fo:table-body>
    <fo:table-row>
      <fo:table-cell>
       <fo:block xsl:use-attribute-sets="request.field.inline.label">
	Année d'obtention du baccalauréat
       </fo:block>
      </fo:table-cell>
      <fo:table-cell>
        <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
            <xsl:choose>
            <xsl:when test="./sgr:AlevelsDate and ./sgr:AlevelsDate != ''">
                  <xsl:value-of select="./sgr:AlevelsDate" />
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
	Type de baccalauréat
       </fo:block>
      </fo:table-cell>
      <fo:table-cell>
        <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
            <xsl:choose>
            <xsl:when test="./sgr:Alevels and ./sgr:Alevels != ''">
                  <xsl:value-of select="./sgr:Alevels" />
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
    
          
                                                  <fo:block xsl:use-attribute-sets="request.field.inline.label">Nom de l'établissement* :</fo:block>
      	    <xsl:call-template name="LocalReferentialDataType">
	      <xsl:with-param name="ReferentialData" select="document(string(concat($localAuthorityName,'/local_referential/local_referential_sgr.xml')))//ref:data[@name = 'CurrentSchoolName']/ref:entries"/>
	      <xsl:with-param name="RequestData" select="//sgr:CurrentSchoolName"/>
	    </xsl:call-template>

    
          
                  <xsl:variable name="withTotal" select="'false'" />

    <xsl:for-each select="//sgr:CurrentSchool">
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
            <xsl:when test="./sgr:CurrentSchoolNamePrecision and ./sgr:CurrentSchoolNamePrecision != ''">
                  <xsl:value-of select="./sgr:CurrentSchoolNamePrecision" />
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
	Code postal
       </fo:block>
      </fo:table-cell>
      <fo:table-cell>
        <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
            <xsl:choose>
            <xsl:when test="./sgr:CurrentSchoolPostalCode and ./sgr:CurrentSchoolPostalCode != ''">
                  <xsl:value-of select="./sgr:CurrentSchoolPostalCode" />
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
	Ville
       </fo:block>
      </fo:table-cell>
      <fo:table-cell>
        <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
            <xsl:choose>
            <xsl:when test="./sgr:CurrentSchoolCity and ./sgr:CurrentSchoolCity != ''">
                  <xsl:value-of select="./sgr:CurrentSchoolCity" />
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
	Pays
       </fo:block>
      </fo:table-cell>
      <fo:table-cell>
        <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
            <xsl:choose>
            <xsl:when test="./sgr:CurrentSchoolCountry and ./sgr:CurrentSchoolCountry != ''">
                  <xsl:value-of select="./sgr:CurrentSchoolCountry" />
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
    
          
                  <xsl:variable name="withTotal" select="'false'" />

    <xsl:for-each select="//sgr:CurrentStudiesInformations">
                                                    <fo:table xsl:use-attribute-sets="request.field.inline.table">
  <fo:table-column column-width="proportional-column-width(100)" />
  <fo:table-column column-width="proportional-column-width(200)" />
  <fo:table-column column-width="proportional-column-width(100)" />
  
  <fo:table-body>
    <fo:table-row>
      <fo:table-cell>
       <fo:block xsl:use-attribute-sets="request.field.inline.label">
	Diplôme préparé
       </fo:block>
      </fo:table-cell>
      <fo:table-cell>
        <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
            <xsl:choose>
            <xsl:when test="./sgr:CurrentStudies and ./sgr:CurrentStudies != ''">
                  <xsl:value-of select="./sgr:CurrentStudies" />
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
                    	      <fo:table-column column-width="proportional-column-width(200)" />
      	      <fo:table-body>
		<fo:table-row>
      	                    		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.inline.label">
		      Niveau
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
                                      <xsl:choose>
                        <xsl:when test="//sgr:CurrentStudiesLevel and //sgr:CurrentStudiesLevel != ''">
                                    <xsl:value-of select="//sgr:CurrentStudiesLevel" />
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
		      Études en alternance
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
                                      <xsl:choose>
                        <xsl:when test="//sgr:SandwichCourses and //sgr:SandwichCourses != ''">
                                    <xsl:value-of select="//sgr:SandwichCourses" />
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
		      Stage à l'étranger
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
                                      <xsl:choose>
                        <xsl:when test="//sgr:AbroadInternship and //sgr:AbroadInternship != ''">
                                    <xsl:value-of select="//sgr:AbroadInternship" />
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
  
                <xsl:if test="//sgr:CurrentStudies/text() = 'otherStudies'">
                <fo:block xsl:use-attribute-sets="request.section.header">Précisions sur le diplôme préparé</fo:block>
	    <fo:block>
	      <fo:leader leader-pattern="space" />
	    </fo:block>
        
                              <fo:table xsl:use-attribute-sets="request.field.inline.table">
                        <fo:table-column column-width="proportional-column-width(100)" />
          <fo:table-column column-width="proportional-column-width(100)" />
                    	      <fo:table-column column-width="proportional-column-width(200)" />
      	      <fo:table-body>
		<fo:table-row>
      	                    		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.inline.label">
		      Précisez
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
                                      <xsl:choose>
                        <xsl:when test="//sgr:OtherStudiesLabel and //sgr:OtherStudiesLabel != ''">
                                    <xsl:value-of select="//sgr:OtherStudiesLabel" />
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
  
              </xsl:if>
                <xsl:if test="//sgr:AbroadInternship">
                <fo:block xsl:use-attribute-sets="request.section.header">Renseignements sur le stage à l'étranger</fo:block>
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
		      Date de début
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
                                      <xsl:choose>
                        <xsl:when test="//sgr:AbroadInternshipStartDate and //sgr:AbroadInternshipStartDate != ''">
                                    <xsl:value-of select="//sgr:AbroadInternshipStartDate" />
                                  </xsl:when>
                        <xsl:otherwise>
                          <xsl:text>&#160;</xsl:text>
                        </xsl:otherwise>
                      </xsl:choose>
        		    </fo:block>
		  </fo:table-cell>
      	                    		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.inline.label">
		      Date de fin
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
                                      <xsl:choose>
                        <xsl:when test="//sgr:AbroadInternshipEndDate and //sgr:AbroadInternshipEndDate != ''">
                                    <xsl:value-of select="//sgr:AbroadInternshipEndDate" />
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
		      Nom de l'établissement d'accueil
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
                                      <xsl:choose>
                        <xsl:when test="//sgr:AbroadInternshipSchoolName and //sgr:AbroadInternshipSchoolName != ''">
                                    <xsl:value-of select="//sgr:AbroadInternshipSchoolName" />
                                  </xsl:when>
                        <xsl:otherwise>
                          <xsl:text>&#160;</xsl:text>
                        </xsl:otherwise>
                      </xsl:choose>
        		    </fo:block>
		  </fo:table-cell>
      	                    		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.inline.label">
		      Pays
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
                                      <xsl:choose>
                        <xsl:when test="//sgr:AbroadInternshipSchoolCountry and //sgr:AbroadInternshipSchoolCountry != ''">
                                    <xsl:value-of select="//sgr:AbroadInternshipSchoolCountry" />
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
                  <fo:block xsl:use-attribute-sets="request.section.header">Éléments de calcul de la bourse</fo:block>
	    <fo:block>
	      <fo:leader leader-pattern="space" />
	    </fo:block>
        
                              <fo:table xsl:use-attribute-sets="request.field.inline.table">
                        <fo:table-column column-width="proportional-column-width(100)" />
          <fo:table-column column-width="proportional-column-width(100)" />
                    	      <fo:table-column column-width="proportional-column-width(200)" />
      	      <fo:table-body>
		<fo:table-row>
      	                        		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.inline.label">
		      Lieu d'études ou de stage situé à*
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
                                      <xsl:choose>
                        <xsl:when test="//sgr:Distance and //sgr:Distance != ''">
                                    <xsl:value-of select="//sgr:Distance" />
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
  
                  <fo:block xsl:use-attribute-sets="request.section.header">Références bancaires de l'étudiant</fo:block>
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
		      Code banque*
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
                                      <xsl:choose>
                        <xsl:when test="//sgr:BankCode and //sgr:BankCode != ''">
                                    <xsl:value-of select="//sgr:BankCode" />
                                  </xsl:when>
                        <xsl:otherwise>
                          <xsl:text>&#160;</xsl:text>
                        </xsl:otherwise>
                      </xsl:choose>
        		    </fo:block>
		  </fo:table-cell>
      	                        		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.inline.label">
		      Code guichet*
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
                                      <xsl:choose>
                        <xsl:when test="//sgr:CounterCode and //sgr:CounterCode != ''">
                                    <xsl:value-of select="//sgr:CounterCode" />
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
		      Numéro de compte*
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
                                      <xsl:choose>
                        <xsl:when test="//sgr:AccountNumber and //sgr:AccountNumber != ''">
                                    <xsl:value-of select="//sgr:AccountNumber" />
                                  </xsl:when>
                        <xsl:otherwise>
                          <xsl:text>&#160;</xsl:text>
                        </xsl:otherwise>
                      </xsl:choose>
        		    </fo:block>
		  </fo:table-cell>
      	                        		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.inline.label">
		      Clé RIB*
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
                                      <xsl:choose>
                        <xsl:when test="//sgr:AccountKey and //sgr:AccountKey != ''">
                                    <xsl:value-of select="//sgr:AccountKey" />
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
  
  
	    <xsl:call-template name="requestFooter">
	      <xsl:with-param name="RequestId">
            <xsl:value-of select="sgr:StudyGrantRequest/cvq:Id"/>
          </xsl:with-param>
	      <xsl:with-param name="CreationDate">
            <xsl:value-of select="sgr:StudyGrantRequest/cvq:CreationDate"/>
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
                                                  <xsl:template match="//sgr:SubjectInformations/sgr:SubjectAddress">
              <xsl:call-template name="AddressType">
      <xsl:with-param name="localizationService" select="$localizationService"></xsl:with-param>
    </xsl:call-template>
  </xsl:template>
                                                                                                                                                                                                                                                                                                                                                                </xsl:stylesheet>
