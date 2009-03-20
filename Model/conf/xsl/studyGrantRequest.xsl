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
	      <xsl:with-param name="RequestName">Dossier de demande de bourse</xsl:with-param>
	      <xsl:with-param name="FriendlyLocalAuthorityName"><xsl:value-of select="$friendlyLocalAuthorityName"/></xsl:with-param>
	    </xsl:call-template>

                <fo:block xsl:use-attribute-sets="request.section.header">Sujet</fo:block>
	    <fo:block>
	      <fo:leader leader-pattern="space" />
	    </fo:block>
        
                    	    <xsl:apply-templates select="//cvq:Subject"/>
      
    
          
                  <xsl:variable name="withTotal" select="'false'" />

    <xsl:for-each select="//sgr:SubjetInformations">
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
	Lieu de naissance
       </fo:block>
      </fo:table-cell>
      <fo:table-cell>
        <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
            <xsl:choose>
            <xsl:when test="./sgr:SubjectBirthPlace and ./sgr:SubjectBirthPlace != ''">
                  <xsl:value-of select="./sgr:SubjectBirthPlace" />
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
  Réside au foyer familial
          </fo:block>
        </fo:table-cell>
        <fo:table-cell>
          <fo:block xsl:use-attribute-sets="request.field.yesno.label">OUI</fo:block>
       </fo:table-cell>
       <fo:table-cell>
         <fo:block xsl:use-attribute-sets="request.field.yesno.value">
           <xsl:if test="./sgr:HasParentsAddress = &quot;true&quot;">X</xsl:if>
           <xsl:if test="./sgr:HasParentsAddress = &quot;false&quot;">&#160;</xsl:if>
         </fo:block>
       </fo:table-cell>
       <fo:table-cell>
         <fo:block xsl:use-attribute-sets="request.field.yesno.label">NON</fo:block>
       </fo:table-cell>
       <fo:table-cell>
         <fo:block xsl:use-attribute-sets="request.field.yesno.value">
           <xsl:if test="./sgr:HasParentsAddress = &quot;false&quot;">X</xsl:if>
           <xsl:if test="./sgr:HasParentsAddress = &quot;true&quot;">&#160;</xsl:if>
         </fo:block>
       </fo:table-cell>
       <fo:table-cell>
         <fo:block>&#160;</fo:block>
       </fo:table-cell>
     </fo:table-row>
   </fo:table-body>
</fo:table>
                                                                <xsl:apply-templates select="./sgr:SubjectAddress"/>
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
  
                  <fo:block xsl:use-attribute-sets="request.section.header">Foyer fiscal</fo:block>
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

    
          
                    	    <xsl:apply-templates select="//sgr:TaxHouseholdAddress"/>
      
    
          
                              <fo:table xsl:use-attribute-sets="request.field.inline.table">
                        <fo:table-column column-width="proportional-column-width(100)" />
          <fo:table-column column-width="proportional-column-width(100)" />
                    	      <fo:table-column column-width="proportional-column-width(200)" />
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
                        <xsl:when test="//sgr:TaxHouseholdPhone and //sgr:TaxHouseholdPhone != ''">
                                    <xsl:value-of select="//sgr:TaxHouseholdPhone" />
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
		      Revenu brut global indiqué sur l’avis d’imposition pour l'année précédente (à joindre au dossier)*
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
  
                  <fo:block xsl:use-attribute-sets="request.section.header">Autres aides</fo:block>
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
		      Autres (Conseil Régional, Établissement ...)*
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

    
          
                              <fo:table xsl:use-attribute-sets="request.field.inline.table">
                        <fo:table-column column-width="proportional-column-width(100)" />
          <fo:table-column column-width="proportional-column-width(100)" />
                    	      <fo:table-column column-width="proportional-column-width(200)" />
      	      <fo:table-body>
		<fo:table-row>
      	                    		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.inline.label">
		      À préciser
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
                                      <xsl:choose>
                        <xsl:when test="//sgr:OtherHelpInformations and //sgr:OtherHelpInformations != ''">
                                    <xsl:value-of select="//sgr:OtherHelpInformations" />
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
  
                  <fo:block xsl:use-attribute-sets="request.section.header">Études en cours</fo:block>
	    <fo:block>
	      <fo:leader leader-pattern="space" />
	    </fo:block>
        
                  <xsl:variable name="withTotal" select="'false'" />

    <xsl:for-each select="//sgr:ALevelsInformations">
                                                                    
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
  Actuellement en Terminale
          </fo:block>
        </fo:table-cell>
        <fo:table-cell>
          <fo:block xsl:use-attribute-sets="request.field.yesno.label">OUI</fo:block>
       </fo:table-cell>
       <fo:table-cell>
         <fo:block xsl:use-attribute-sets="request.field.yesno.value">
           <xsl:if test="./sgr:IsInLastYear = &quot;true&quot;">X</xsl:if>
           <xsl:if test="./sgr:IsInLastYear = &quot;false&quot;">&#160;</xsl:if>
         </fo:block>
       </fo:table-cell>
       <fo:table-cell>
         <fo:block xsl:use-attribute-sets="request.field.yesno.label">NON</fo:block>
       </fo:table-cell>
       <fo:table-cell>
         <fo:block xsl:use-attribute-sets="request.field.yesno.value">
           <xsl:if test="./sgr:IsInLastYear = &quot;false&quot;">X</xsl:if>
           <xsl:if test="./sgr:IsInLastYear = &quot;true&quot;">&#160;</xsl:if>
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
            <xsl:when test="./sgr:LastYearDate and ./sgr:LastYearDate != ''">
                  <xsl:value-of select="./sgr:LastYearDate" />
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
            <xsl:when test="./sgr:LastYearType and ./sgr:LastYearType != ''">
                  <xsl:value-of select="./sgr:LastYearType" />
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
	Études en cours
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
    
      
              <fo:block>
              <fo:leader leader-pattern="space" />
            </fo:block>
  
                <xsl:if test="//sgr:CurrentStudies/text() = 'sandwichCourses'">
                <fo:block xsl:use-attribute-sets="request.section.header">Précisions</fo:block>
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
		      Études en alternance
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
                                      <xsl:choose>
                        <xsl:when test="//sgr:SandwichCoursesLabel and //sgr:SandwichCoursesLabel != ''">
                                    <xsl:value-of select="//sgr:SandwichCoursesLabel" />
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
                <xsl:if test="//sgr:CurrentStudies/text() = 'abroadInternship'">
                <fo:block xsl:use-attribute-sets="request.section.header">Précisions</fo:block>
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
                <xsl:if test="//sgr:CurrentStudies/text() = 'otherStudies'">
                <fo:block xsl:use-attribute-sets="request.section.header">Précisions</fo:block>
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
                  <fo:block xsl:use-attribute-sets="request.section.header">Études futures</fo:block>
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
		      Nom de l'établissement*
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
                                      <xsl:choose>
                        <xsl:when test="//sgr:FutureSchoolName and //sgr:FutureSchoolName != ''">
                                    <xsl:value-of select="//sgr:FutureSchoolName" />
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

    
          
                    	    <xsl:apply-templates select="//sgr:FutureSchoolAddress"/>
      
    
          
                              <fo:table xsl:use-attribute-sets="request.field.inline.table">
                        <fo:table-column column-width="proportional-column-width(100)" />
          <fo:table-column column-width="proportional-column-width(100)" />
                    	      <fo:table-column column-width="proportional-column-width(200)" />
      	      <fo:table-body>
		<fo:table-row>
      	                        		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.inline.label">
		      Téléphone de l'établissement*
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
                                      <xsl:choose>
                        <xsl:when test="//sgr:FutureSchoolPhone and //sgr:FutureSchoolPhone != ''">
                                    <xsl:value-of select="//sgr:FutureSchoolPhone" />
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
		      Diplôme préparé*
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
                                      <xsl:choose>
                        <xsl:when test="//sgr:FutureDiplomaName and //sgr:FutureDiplomaName != ''">
                                    <xsl:value-of select="//sgr:FutureDiplomaName" />
                                  </xsl:when>
                        <xsl:otherwise>
                          <xsl:text>&#160;</xsl:text>
                        </xsl:otherwise>
                      </xsl:choose>
        		    </fo:block>
		  </fo:table-cell>
      	                        		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.inline.label">
		      Niveau (1ère, 2ème année)*
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
                                      <xsl:choose>
                        <xsl:when test="//sgr:FutureDiplomaLevel and //sgr:FutureDiplomaLevel != ''">
                                    <xsl:value-of select="//sgr:FutureDiplomaLevel" />
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
		      Stage à l'étranger*
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.yesno.label">OUI</fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.yesno.value">
		      <xsl:if test="//sgr:FutureSchoolIsAbroad = &quot;true&quot;">X</xsl:if>
		      <xsl:if test="//sgr:FutureSchoolIsAbroad = &quot;false&quot;">&#160;</xsl:if>
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.yesno.label">NON</fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.yesno.value">
		      <xsl:if test="//sgr:FutureSchoolIsAbroad = &quot;false&quot;">X</xsl:if>
		      <xsl:if test="//sgr:FutureSchoolIsAbroad = &quot;true&quot;">&#160;</xsl:if>
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
		      Adresse complète
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
                                      <xsl:choose>
                        <xsl:when test="//sgr:AbroadInternshipSchoolAddress and //sgr:AbroadInternshipSchoolAddress != ''">
                                    <xsl:value-of select="//sgr:AbroadInternshipSchoolAddress" />
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
		      Pays*
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
            		  <fo:table-cell>
		    <fo:block>&#160;</fo:block>
		  </fo:table-cell>
      		</fo:table-row>
	      </fo:table-body>
	    </fo:table>

    
      
              <fo:block>
              <fo:leader leader-pattern="space" />
            </fo:block>
  
                  <fo:block xsl:use-attribute-sets="request.section.header">Éléments de calcul</fo:block>
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
		      Lieu d'études situé à*
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
  
                  <fo:block xsl:use-attribute-sets="request.section.header">Coordonnées bancaires</fo:block>
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
		      Banque*
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
                                      <xsl:choose>
                        <xsl:when test="//sgr:BankName and //sgr:BankName != ''">
                                    <xsl:value-of select="//sgr:BankName" />
                                  </xsl:when>
                        <xsl:otherwise>
                          <xsl:text>&#160;</xsl:text>
                        </xsl:otherwise>
                      </xsl:choose>
        		    </fo:block>
		  </fo:table-cell>
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
		      Agence*
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
                                      <xsl:choose>
                        <xsl:when test="//sgr:BankAgency and //sgr:BankAgency != ''">
                                    <xsl:value-of select="//sgr:BankAgency" />
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
                                                                                                                                      <xsl:template match="//sgr:SubjetInformations/sgr:SubjectAddress">
              <xsl:call-template name="AddressType">
      <xsl:with-param name="localizationService" select="$localizationService"></xsl:with-param>
    </xsl:call-template>
  </xsl:template>
                                        <xsl:template match="//sgr:TaxHouseholdAddress">
          <xsl:call-template name="AddressType">
      <xsl:with-param name="localizationService" select="$localizationService"></xsl:with-param>
    </xsl:call-template>
  </xsl:template>
                                                                                                                                                                                  <xsl:template match="//sgr:FutureSchoolAddress">
          <xsl:call-template name="AddressType">
      <xsl:with-param name="localizationService" select="$localizationService"></xsl:with-param>
    </xsl:call-template>
  </xsl:template>
                                                                      </xsl:stylesheet>
