<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" 
  xmlns:scrr="http://www.cg95.fr/cvq/schema/scrr" 
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
	      <xsl:with-param name="RequestName">Demande d'inscription au restaurant scolaire</xsl:with-param>
	      <xsl:with-param name="FriendlyLocalAuthorityName"><xsl:value-of select="$friendlyLocalAuthorityName"/></xsl:with-param>
	    </xsl:call-template>

                <fo:block xsl:use-attribute-sets="request.section.header">Enfant*</fo:block>
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
		      Nom de l'école
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
                                      <xsl:choose>
                        <xsl:when test="//scrr:School/cvq:Name and //scrr:School/cvq:Name != ''">
                                    <xsl:value-of select="//scrr:School/cvq:Name" />
                                  </xsl:when>
                        <xsl:otherwise>
                          <xsl:text>&#160;</xsl:text>
                        </xsl:otherwise>
                      </xsl:choose>
        		    </fo:block>
		  </fo:table-cell>
      	                        		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.inline.label">
		      Classe*
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
                                      <xsl:choose>
                        <xsl:when test="//scrr:Section and //scrr:Section != ''">
          			  <xsl:variable name="current_value" select="//scrr:Section"/>
                          <xsl:for-each select="locservice:getEnumsDataNode($localizationService,'http://www.cg95.fr/cvq/schema/common','SectionType','fr')//ref:data[@name = 'SectionType']/ref:entry">
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

    
          
                    	    <xsl:apply-templates select="//cvq:Subject"/>
      
    
          
                              <fo:table xsl:use-attribute-sets="request.field.inline.table">
                        <fo:table-column column-width="proportional-column-width(100)" />
          <fo:table-column column-width="proportional-column-width(100)" />
                    	      <fo:table-column column-width="proportional-column-width(200)" />
      	      <fo:table-body>
		<fo:table-row>
      	                        		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.inline.label">
		      Téléphone en cas d'urgence*
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
                                      <xsl:choose>
                        <xsl:when test="//scrr:UrgencyPhone and //scrr:UrgencyPhone != ''">
                                    <xsl:value-of select="//scrr:UrgencyPhone" />
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
  
                  <fo:block xsl:use-attribute-sets="request.section.header">Régime alimentaire*</fo:block>
	    <fo:block>
	      <fo:leader leader-pattern="space" />
	    </fo:block>
        
                              	    <xsl:call-template name="LocalReferentialDataType">
	      <xsl:with-param name="ReferentialData" select="document(string(concat($localAuthorityName,'/local_referential/local_referential_scrr.xml')))//ref:data[@name = 'FoodDiet']/ref:entries"/>
	      <xsl:with-param name="RequestData" select="//scrr:FoodDiet"/>
	    </xsl:call-template>

    
      
              <fo:block>
              <fo:leader leader-pattern="space" />
            </fo:block>
  
                  <fo:block xsl:use-attribute-sets="request.section.header">Présence de l'enfant*</fo:block>
	    <fo:block>
	      <fo:leader leader-pattern="space" />
	    </fo:block>
        
                              	    <xsl:call-template name="LocalReferentialDataType">
	      <xsl:with-param name="ReferentialData" select="document(string(concat($localAuthorityName,'/local_referential/local_referential_scrr.xml')))//ref:data[@name = 'CanteenAttendingDays']/ref:entries"/>
	      <xsl:with-param name="RequestData" select="//scrr:CanteenAttendingDays"/>
	    </xsl:call-template>

    
      
              <fo:block>
              <fo:leader leader-pattern="space" />
            </fo:block>
  
                  <fo:block xsl:use-attribute-sets="request.section.header">Allergie - Médecin traitant</fo:block>
	    <fo:block>
	      <fo:leader leader-pattern="space" />
	    </fo:block>
        
                                
      	    <fo:table xsl:use-attribute-sets="request.field.inline.table">
	      <fo:table-column column-width="proportional-column-width(2 * 2)" />
	      <fo:table-column column-width="proportional-column-width(2) - 30pt" />
	      <fo:table-column column-width="30pt" />
	      <fo:table-column column-width="proportional-column-width(2) - 30pt" />
	      <fo:table-column column-width="30pt" />
      	      <fo:table-body>
		<fo:table-row>
		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.inline.label">
		      Votre enfant présente-t-il une allergie alimentaire ?*
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.yesno.label">OUI</fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.yesno.value">
		      <xsl:if test="//scrr:FoodAllergy = &quot;true&quot;">X</xsl:if>
		      <xsl:if test="//scrr:FoodAllergy = &quot;false&quot;">&#160;</xsl:if>
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.yesno.label">NON</fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.yesno.value">
		      <xsl:if test="//scrr:FoodAllergy = &quot;false&quot;">X</xsl:if>
		      <xsl:if test="//scrr:FoodAllergy = &quot;true&quot;">&#160;</xsl:if>
		    </fo:block>
		  </fo:table-cell>
      		</fo:table-row>
	      </fo:table-body>
	    </fo:table>

    
    	    <fo:block xsl:use-attribute-sets="request.field.notice">
	      Si oui, un certificat médical est obligatoire et il est                 impératif de contacter le service Restaurants Scolaires.
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
		      Nom du médecin traitant
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
                                      <xsl:choose>
                        <xsl:when test="//scrr:DoctorName and //scrr:DoctorName != ''">
                                    <xsl:value-of select="//scrr:DoctorName" />
                                  </xsl:when>
                        <xsl:otherwise>
                          <xsl:text>&#160;</xsl:text>
                        </xsl:otherwise>
                      </xsl:choose>
        		    </fo:block>
		  </fo:table-cell>
      	                    		  <fo:table-cell>
		    <fo:block xsl:use-attribute-sets="request.field.inline.label">
		      Téléphone du médecin traitant
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
                                      <xsl:choose>
                        <xsl:when test="//scrr:DoctorPhone and //scrr:DoctorPhone != ''">
                                    <xsl:value-of select="//scrr:DoctorPhone" />
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
  
                  <fo:block xsl:use-attribute-sets="request.section.header">Responsables légaux</fo:block>
	    <fo:block>
	      <fo:leader leader-pattern="space" />
	    </fo:block>
        
                                        <xsl:for-each select="//cvq:Subject/cvq:LegalResponsible">
	      <xsl:apply-templates select="."/>
              <xsl:if test="not(position() = last())">
	        <fo:block>
	          <fo:leader leader-pattern="dots" leader-length.optimum="100%"/>
	        </fo:block>
	      </xsl:if>
            </xsl:for-each>
      
    
      
              <fo:block>
              <fo:leader leader-pattern="space" />
            </fo:block>
  
                  <fo:block xsl:use-attribute-sets="request.section.header">Moyen de contact</fo:block>
	    <fo:block>
	      <fo:leader leader-pattern="space" />
	    </fo:block>
        
                    	    <xsl:apply-templates select="//cvq:MeansOfContact"/>
      
    
      
              <fo:block>
              <fo:leader leader-pattern="space" />
            </fo:block>
  
                  <fo:block xsl:use-attribute-sets="request.section.header">Autorisation d'hospitalisation</fo:block>
	    <fo:block>
	      <fo:leader leader-pattern="space" />
	    </fo:block>
        
                                	    <fo:block xsl:use-attribute-sets="request.signature">
	      <xsl:if test="//scrr:HospitalizationPermission/text() = &quot;true&quot;">
      		<fo:inline>En inscrivant mon enfant (ci-dessus désigné) en Restaurant Scolaire, j'autorise les responsables à  prendre toutes les mesures pour le faire soigner, hospitaliser, opérer si nécessaire.</fo:inline>
		<fo:block>
		  <fo:leader leader-pattern="space" />
		</fo:block>
      		<fo:inline>JE CERTIFIE que tous les renseignements portés sur la présente fiche sont exacts, je m'engage à  signaler sans retard tous les changements qui interviendraient.</fo:inline>
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
	      <xsl:if test="//scrr:HospitalizationPermission/text() = &quot;false&quot;">
      		<fo:inline>Vous n'avez pas accepté l'autorisation d'hospitalisation</fo:inline>
		<fo:block>
		  <fo:leader leader-pattern="space" />
		</fo:block>
      	      </xsl:if>
	    </fo:block>

    
      
              <fo:block>
              <fo:leader leader-pattern="space" />
            </fo:block>
  
                  <fo:block xsl:use-attribute-sets="request.section.header">Règlement intérieur</fo:block>
	    <fo:block>
	      <fo:leader leader-pattern="space" />
	    </fo:block>
        
                                	    <fo:block xsl:use-attribute-sets="request.signature">
	      <xsl:if test="//scrr:RulesAndRegulationsAcceptance/text() = &quot;true&quot;">
      		<fo:inline>J'ai pris parfaite connaissance du règlement intérieur de la restauration scolaire qui accompagne cette fiche.</fo:inline>
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
	      <xsl:if test="//scrr:RulesAndRegulationsAcceptance/text() = &quot;false&quot;">
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
            <xsl:value-of select="scrr:SchoolCanteenRegistrationRequest/cvq:Id"/>
          </xsl:with-param>
	      <xsl:with-param name="CreationDate">
            <xsl:value-of select="scrr:SchoolCanteenRegistrationRequest/cvq:CreationDate"/>
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
                                                        <xsl:template match="cvq:LegalResponsible">
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
