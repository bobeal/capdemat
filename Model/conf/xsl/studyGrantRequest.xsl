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
	      <xsl:with-param name="RequestName">Demande de bourse Mobil'Etudes</xsl:with-param>
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
            <xsl:call-template name="cvq:DisplayDate">
            <xsl:with-param name="DateToDisplay">
              <xsl:value-of select="./sgr:SubjectBirthDate"/>
            </xsl:with-param>
          </xsl:call-template>
          </fo:block>
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
  Première demande
          </fo:block>
        </fo:table-cell>
        <fo:table-cell>
          <fo:block xsl:use-attribute-sets="request.field.yesno.label">OUI</fo:block>
       </fo:table-cell>
       <fo:table-cell>
         <fo:block xsl:use-attribute-sets="request.field.yesno.value">
           <xsl:if test="./sgr:SubjectFirstRequest = &quot;true&quot;">X</xsl:if>
           <xsl:if test="./sgr:SubjectFirstRequest = &quot;false&quot;">&#160;</xsl:if>
         </fo:block>
       </fo:table-cell>
       <fo:table-cell>
         <fo:block xsl:use-attribute-sets="request.field.yesno.label">NON</fo:block>
       </fo:table-cell>
       <fo:table-cell>
         <fo:block xsl:use-attribute-sets="request.field.yesno.value">
           <xsl:if test="./sgr:SubjectFirstRequest = &quot;false&quot;">X</xsl:if>
           <xsl:if test="./sgr:SubjectFirstRequest = &quot;true&quot;">&#160;</xsl:if>
         </fo:block>
       </fo:table-cell>
       <fo:table-cell>
         <fo:block>&#160;</fo:block>
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

    
          
                                                  <fo:block xsl:use-attribute-sets="request.field.inline.label">Commune* :</fo:block>
      	    <xsl:call-template name="LocalReferentialDataType">
	      <xsl:with-param name="ReferentialData" select="document(string(concat($localAuthorityName,'/local_referential/local_referential_sgr.xml')))//ref:data[@name = 'TaxHouseholdCity']/ref:entries"/>
	      <xsl:with-param name="RequestData" select="//sgr:TaxHouseholdCity"/>
	    </xsl:call-template>

    
          
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

    <xsl:for-each select="//sgr:CurrentSchool">
                                                                                                <fo:block xsl:use-attribute-sets="request.field.inline.label">Nom de l'établissement :</fo:block>
                    <xsl:call-template name="LocalReferentialDataType">
            <xsl:with-param name="ReferentialData" select="document(string(concat($localAuthorityName,'/local_referential/local_referential_sgr.xml')))//ref:data[@name = 'CurrentSchoolName']/ref:entries"/>
            <xsl:with-param name="RequestData" select="//sgr:CurrentSchoolName"/>
          </xsl:call-template>
                                                            <fo:table xsl:use-attribute-sets="request.field.inline.table">
  <fo:table-column column-width="proportional-column-width(100)" />
  <fo:table-column column-width="proportional-column-width(200)" />
  <fo:table-column column-width="proportional-column-width(100)" />
  
  <fo:table-body>
    <fo:table-row>
      <fo:table-cell>
       <fo:block xsl:use-attribute-sets="request.field.inline.label">
	Précisez le nom
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
              <xsl:variable name="mod_column" select="'3'"/>
              <xsl:variable name="enum_tokens">
                <xsl:call-template name="split-string">
                        <xsl:with-param name="string" select="./sgr:Alevels/text()"/>
                      </xsl:call-template>
              </xsl:variable>
                    <fo:table-column column-width="100pt" />
      
              <xsl:for-each select="locservice:getEnumsDataNode($localizationService,'http://www.cg95.fr/cvq/schema/sgr','ALevelsType','fr')//ref:data[@name = 'ALevelsType']/ref:entry">
                <xsl:if test="not(position() &gt; ($mod_column + 1))">
                  <fo:table-column column-width="30pt" />
                  <fo:table-column column-width="proportional-column-width(1) - 30pt"/>
                </xsl:if>
              </xsl:for-each>

              <fo:table-body>
                      <xsl:text disable-output-escaping="yes">&lt;fo:table-row&gt;</xsl:text>
                <fo:table-cell>
	          <fo:block xsl:use-attribute-sets="request.field.inline.label">
		    Type de baccalauréat
		  </fo:block>
	        </fo:table-cell>
      
                <xsl:for-each select="locservice:getEnumsDataNode($localizationService,'http://www.cg95.fr/cvq/schema/sgr','ALevelsType','fr')//ref:data[@name = 'ALevelsType']/ref:entry">

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
              <xsl:variable name="mod_column" select="'3'"/>
              <xsl:variable name="enum_tokens">
                <xsl:call-template name="split-string">
                        <xsl:with-param name="string" select="./sgr:CurrentStudiesDiploma/text()"/>
                      </xsl:call-template>
              </xsl:variable>
                    <fo:table-column column-width="100pt" />
      
              <xsl:for-each select="locservice:getEnumsDataNode($localizationService,'http://www.cg95.fr/cvq/schema/sgr','CurrentStudiesType','fr')//ref:data[@name = 'CurrentStudiesType']/ref:entry">
                <xsl:if test="not(position() &gt; ($mod_column + 1))">
                  <fo:table-column column-width="30pt" />
                  <fo:table-column column-width="proportional-column-width(1) - 30pt"/>
                </xsl:if>
              </xsl:for-each>

              <fo:table-body>
                      <xsl:text disable-output-escaping="yes">&lt;fo:table-row&gt;</xsl:text>
                <fo:table-cell>
	          <fo:block xsl:use-attribute-sets="request.field.inline.label">
		    Diplôme préparé
		  </fo:block>
	        </fo:table-cell>
      
                <xsl:for-each select="locservice:getEnumsDataNode($localizationService,'http://www.cg95.fr/cvq/schema/sgr','CurrentStudiesType','fr')//ref:data[@name = 'CurrentStudiesType']/ref:entry">

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
                    <xsl:if test="$withTotal = 'true'  or not(position() = last())">
        <fo:block>
          <fo:leader leader-pattern="dots" leader-length.optimum="100%"/>
          <fo:leader leader-pattern="space" />
        </fo:block>
      </xsl:if>
    </xsl:for-each>
    
          
                                        
                  <fo:table xsl:use-attribute-sets="request.field.inline.table">
              <xsl:variable name="mod_column" select="'3'"/>
              <xsl:variable name="enum_tokens">
                <xsl:call-template name="split-string">
                        <xsl:with-param name="string" select="//sgr:CurrentStudiesLevel/text()"/>
                      </xsl:call-template>
              </xsl:variable>
                    <fo:table-column column-width="100pt" />
      
              <xsl:for-each select="locservice:getEnumsDataNode($localizationService,'http://www.cg95.fr/cvq/schema/sgr','CurrentStudiesLevelType','fr')//ref:data[@name = 'CurrentStudiesLevelType']/ref:entry">
                <xsl:if test="not(position() &gt; ($mod_column + 1))">
                  <fo:table-column column-width="30pt" />
                  <fo:table-column column-width="proportional-column-width(1) - 30pt"/>
                </xsl:if>
              </xsl:for-each>

              <fo:table-body>
                      <xsl:text disable-output-escaping="yes">&lt;fo:table-row&gt;</xsl:text>
                <fo:table-cell>
	          <fo:block xsl:use-attribute-sets="request.field.inline.label">
		    Niveau
		  </fo:block>
	        </fo:table-cell>
      
                <xsl:for-each select="locservice:getEnumsDataNode($localizationService,'http://www.cg95.fr/cvq/schema/sgr','CurrentStudiesLevelType','fr')//ref:data[@name = 'CurrentStudiesLevelType']/ref:entry">

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
		      Études en alternance
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.yesno.label">OUI</fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.yesno.value">
		      <xsl:if test="//sgr:SandwichCourses = &quot;true&quot;">X</xsl:if>
		      <xsl:if test="//sgr:SandwichCourses = &quot;false&quot;">&#160;</xsl:if>
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.yesno.label">NON</fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.yesno.value">
		      <xsl:if test="//sgr:SandwichCourses = &quot;false&quot;">X</xsl:if>
		      <xsl:if test="//sgr:SandwichCourses = &quot;true&quot;">&#160;</xsl:if>
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
		      Stage à l'étranger
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.yesno.label">OUI</fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.yesno.value">
		      <xsl:if test="//sgr:AbroadInternship = &quot;true&quot;">X</xsl:if>
		      <xsl:if test="//sgr:AbroadInternship = &quot;false&quot;">&#160;</xsl:if>
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.yesno.label">NON</fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.yesno.value">
		      <xsl:if test="//sgr:AbroadInternship = &quot;false&quot;">X</xsl:if>
		      <xsl:if test="//sgr:AbroadInternship = &quot;true&quot;">&#160;</xsl:if>
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
                	              <xsl:call-template name="cvq:DisplayDate">
		        <xsl:with-param name="DateToDisplay">
		          <xsl:value-of select="//sgr:AbroadInternshipStartDate"/>
		        </xsl:with-param>
	              </xsl:call-template>
			    </fo:block>
		  </fo:table-cell>
      	                    		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.inline.label">
		      Date de fin
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
                	              <xsl:call-template name="cvq:DisplayDate">
		        <xsl:with-param name="DateToDisplay">
		          <xsl:value-of select="//sgr:AbroadInternshipEndDate"/>
		        </xsl:with-param>
	              </xsl:call-template>
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
              <xsl:variable name="mod_column" select="'2'"/>
              <xsl:variable name="enum_tokens">
                <xsl:call-template name="split-string">
                        <xsl:with-param name="string" select="//sgr:Distance/text()"/>
                      </xsl:call-template>
              </xsl:variable>
                    <fo:table-column column-width="100pt" />
      
              <xsl:for-each select="locservice:getEnumsDataNode($localizationService,'http://www.cg95.fr/cvq/schema/sgr','DistanceType','fr')//ref:data[@name = 'DistanceType']/ref:entry">
                <xsl:if test="not(position() &gt; ($mod_column + 1))">
                  <fo:table-column column-width="30pt" />
                  <fo:table-column column-width="proportional-column-width(1) - 30pt"/>
                </xsl:if>
              </xsl:for-each>

              <fo:table-body>
                      <xsl:text disable-output-escaping="yes">&lt;fo:table-row&gt;</xsl:text>
                <fo:table-cell>
	          <fo:block xsl:use-attribute-sets="request.field.inline.label">
		    Lieu d'études ou de stage situé à*
		  </fo:block>
	        </fo:table-cell>
      
                <xsl:for-each select="locservice:getEnumsDataNode($localizationService,'http://www.cg95.fr/cvq/schema/sgr','DistanceType','fr')//ref:data[@name = 'DistanceType']/ref:entry">

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

    
      
              <fo:block>
              <fo:leader leader-pattern="space" />
            </fo:block>
  
                  <fo:block xsl:use-attribute-sets="request.section.header">Références bancaires de l'étudiant</fo:block>
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
		      Etes-vous titulaire du compte ?*
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.yesno.label">OUI</fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.yesno.value">
		      <xsl:if test="//sgr:IsSubjectAccountHolder = &quot;true&quot;">X</xsl:if>
		      <xsl:if test="//sgr:IsSubjectAccountHolder = &quot;false&quot;">&#160;</xsl:if>
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.yesno.label">NON</fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.yesno.value">
		      <xsl:if test="//sgr:IsSubjectAccountHolder = &quot;false&quot;">X</xsl:if>
		      <xsl:if test="//sgr:IsSubjectAccountHolder = &quot;true&quot;">&#160;</xsl:if>
		    </fo:block>
		  </fo:table-cell>
      		  <fo:table-cell>
		    <fo:block>&#160;</fo:block>
		  </fo:table-cell>
      		</fo:table-row>
	      </fo:table-body>
	    </fo:table>

    
          
                                        
                  <fo:table xsl:use-attribute-sets="request.field.inline.table">
              <xsl:variable name="mod_column" select="'2'"/>
              <xsl:variable name="enum_tokens">
                <xsl:call-template name="split-string">
                        <xsl:with-param name="string" select="//sgr:AccountHolderTitle/text()"/>
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
		    Civilité du titulaire du compte
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
		      Nom du titulaire du compte
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
                                      <xsl:choose>
                        <xsl:when test="//sgr:AccountHolderLastName and //sgr:AccountHolderLastName != ''">
                                    <xsl:value-of select="//sgr:AccountHolderLastName" />
                                  </xsl:when>
                        <xsl:otherwise>
                          <xsl:text>&#160;</xsl:text>
                        </xsl:otherwise>
                      </xsl:choose>
        		    </fo:block>
		  </fo:table-cell>
      	                    		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.inline.label">
		      Prénom du titulaire du compte
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
                                      <xsl:choose>
                        <xsl:when test="//sgr:AccountHolderFirstName and //sgr:AccountHolderFirstName != ''">
                                    <xsl:value-of select="//sgr:AccountHolderFirstName" />
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
		      Date de naissance du titulaire du compte
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
                	              <xsl:call-template name="cvq:DisplayDate">
		        <xsl:with-param name="DateToDisplay">
		          <xsl:value-of select="//sgr:AccountHolderBirthDate"/>
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
                                                                                                                                                                                                                                                                                                                                                                                                                    <xsl:template match="//cvq:MeansOfContact">
          <xsl:call-template name="MeansOfContactType">
      <xsl:with-param name="localizationService" select="$localizationService"></xsl:with-param>
    </xsl:call-template>
  </xsl:template>
      </xsl:stylesheet>
