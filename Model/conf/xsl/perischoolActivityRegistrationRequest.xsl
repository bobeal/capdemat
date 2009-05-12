<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" 
  xmlns:parr="http://www.cg95.fr/cvq/schema/parr" 
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
	      <xsl:with-param name="RequestName">Demande d'inscription aux activités périscolaires</xsl:with-param>
	      <xsl:with-param name="FriendlyLocalAuthorityName"><xsl:value-of select="$friendlyLocalAuthorityName"/></xsl:with-param>
	    </xsl:call-template>

                <fo:block xsl:use-attribute-sets="request.section.header">Enfant*</fo:block>
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
		      Téléphone en cas d'urgence*
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
                                      <xsl:choose>
                        <xsl:when test="//parr:UrgencyPhone and //parr:UrgencyPhone != ''">
                                    <xsl:value-of select="//parr:UrgencyPhone" />
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
		      Ecole
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
                                      <xsl:choose>
                        <xsl:when test="//parr:School/cvq:Name and //parr:School/cvq:Name != ''">
                                    <xsl:value-of select="//parr:School/cvq:Name" />
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
		      Classe*
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell>
        		    <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
                                      <xsl:choose>
                        <xsl:when test="//parr:Section and //parr:Section != ''">
          			  <xsl:variable name="current_value" select="//parr:Section"/>
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
            		  <fo:table-cell>
		    <fo:block>&#160;</fo:block>
		  </fo:table-cell>
      		</fo:table-row>
	      </fo:table-body>
	    </fo:table>

    
      
              <fo:block>
              <fo:leader leader-pattern="space" />
            </fo:block>
  
                  <fo:block xsl:use-attribute-sets="request.section.header">Activités périscolaires*</fo:block>
	    <fo:block>
	      <fo:leader leader-pattern="space" />
	    </fo:block>
        
                              	    <xsl:call-template name="LocalReferentialDataType">
	      <xsl:with-param name="ReferentialData" select="document(string(concat($localAuthorityName,'/local_referential/local_referential_parr.xml')))//ref:data[@name = 'PerischoolActivity']/ref:entries"/>
	      <xsl:with-param name="RequestData" select="//parr:PerischoolActivity"/>
	    </xsl:call-template>

    
      
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
  
                  <fo:block xsl:use-attribute-sets="request.section.header">Personnes à contacter</fo:block>
	    <fo:block>
	      <fo:leader leader-pattern="space" />
	    </fo:block>
        
                  <xsl:variable name="withTotal" select="'false'" />

    <xsl:for-each select="//parr:ContactIndividuals">
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
            <xsl:when test="./parr:LastName and ./parr:LastName != ''">
                  <xsl:value-of select="./parr:LastName" />
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
	Prénom
       </fo:block>
      </fo:table-cell>
      <fo:table-cell>
        <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
            <xsl:choose>
            <xsl:when test="./parr:FirstName and ./parr:FirstName != ''">
                  <xsl:value-of select="./parr:FirstName" />
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
                                                                <xsl:apply-templates select="./parr:Address"/>
                                                              <fo:table xsl:use-attribute-sets="request.field.inline.table">
  <fo:table-column column-width="proportional-column-width(100)" />
  <fo:table-column column-width="proportional-column-width(200)" />
  <fo:table-column column-width="proportional-column-width(100)" />
  
  <fo:table-body>
    <fo:table-row>
      <fo:table-cell>
       <fo:block xsl:use-attribute-sets="request.field.inline.label">
	Téléphone domicile
       </fo:block>
      </fo:table-cell>
      <fo:table-cell>
        <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
            <xsl:choose>
            <xsl:when test="./parr:HomePhone and ./parr:HomePhone != ''">
                  <xsl:value-of select="./parr:HomePhone" />
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
	Téléphone bureau
       </fo:block>
      </fo:table-cell>
      <fo:table-cell>
        <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
            <xsl:choose>
            <xsl:when test="./parr:OfficePhone and ./parr:OfficePhone != ''">
                  <xsl:value-of select="./parr:OfficePhone" />
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
  
                  <fo:block xsl:use-attribute-sets="request.section.header">Personnes autorisées</fo:block>
	    <fo:block>
	      <fo:leader leader-pattern="space" />
	    </fo:block>
        
                  <xsl:variable name="withTotal" select="'false'" />

    <xsl:for-each select="//parr:AuthorizedIndividuals">
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
            <xsl:when test="./parr:LastName and ./parr:LastName != ''">
                  <xsl:value-of select="./parr:LastName" />
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
	Prénom
       </fo:block>
      </fo:table-cell>
      <fo:table-cell>
        <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
            <xsl:choose>
            <xsl:when test="./parr:FirstName and ./parr:FirstName != ''">
                  <xsl:value-of select="./parr:FirstName" />
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
                                                                <xsl:apply-templates select="./parr:Address"/>
                                                              <fo:table xsl:use-attribute-sets="request.field.inline.table">
  <fo:table-column column-width="proportional-column-width(100)" />
  <fo:table-column column-width="proportional-column-width(200)" />
  <fo:table-column column-width="proportional-column-width(100)" />
  
  <fo:table-body>
    <fo:table-row>
      <fo:table-cell>
       <fo:block xsl:use-attribute-sets="request.field.inline.label">
	Téléphone domicile
       </fo:block>
      </fo:table-cell>
      <fo:table-cell>
        <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
            <xsl:choose>
            <xsl:when test="./parr:HomePhone and ./parr:HomePhone != ''">
                  <xsl:value-of select="./parr:HomePhone" />
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
	Téléphone bureau
       </fo:block>
      </fo:table-cell>
      <fo:table-cell>
        <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
            <xsl:choose>
            <xsl:when test="./parr:OfficePhone and ./parr:OfficePhone != ''">
                  <xsl:value-of select="./parr:OfficePhone" />
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
  
                  <fo:block xsl:use-attribute-sets="request.section.header">Autorisation de participation aux sorties</fo:block>
	    <fo:block>
	      <fo:leader leader-pattern="space" />
	    </fo:block>
        
                                	    <fo:block xsl:use-attribute-sets="request.signature">
	      <xsl:if test="//parr:ClassTripPermission/text() = &quot;true&quot;">
      		<fo:inline>
                          J'autorise la participation de mon enfant
                          aux sorties organisées
                        </fo:inline>
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
	      <xsl:if test="//parr:ClassTripPermission/text() = &quot;false&quot;">
      		<fo:inline>
                          Vous n'avez pas autorisé votre enfant à
                          participer aux sorties organisées
                        </fo:inline>
		<fo:block>
		  <fo:leader leader-pattern="space" />
		</fo:block>
      	      </xsl:if>
	    </fo:block>

    
      
              <fo:block>
              <fo:leader leader-pattern="space" />
            </fo:block>
  
                  <fo:block xsl:use-attribute-sets="request.section.header">Autorisation d'hospitalisation</fo:block>
	    <fo:block>
	      <fo:leader leader-pattern="space" />
	    </fo:block>
        
                                	    <fo:block xsl:use-attribute-sets="request.signature">
	      <xsl:if test="//parr:HospitalizationPermission/text() = &quot;true&quot;">
      		<fo:inline>
                          En inscrivant mon enfant (ci-dessus désigné) aux activités
                          périscolaires, j'autorise les responsables à prendre toutes les
                          mesures pour le faire soigner, hospitaliser, opérer si
                          nécessaire.
                        </fo:inline>
		<fo:block>
		  <fo:leader leader-pattern="space" />
		</fo:block>
      		<fo:inline>
                          JE CERTIFIE que tous les renseignements portés sur la présente
                          fiche sont exacts, je m'engage à signaler sans retard tous les
                          changements qui interviendraient.
                        </fo:inline>
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
	      <xsl:if test="//parr:HospitalizationPermission/text() = &quot;false&quot;">
      		<fo:inline>
                          Vous n'avez pas accepté l'autorisation d'hospitalisation
                        </fo:inline>
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
	      <xsl:if test="//parr:RulesAndRegulationsAcceptance/text() = &quot;true&quot;">
      		<fo:inline>
                          J'ai pris parfaite connaissance du règlement intérieur de la
                          restauration scolaire qui accompagne cette fiche.
                        </fo:inline>
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
	      <xsl:if test="//parr:RulesAndRegulationsAcceptance/text() = &quot;false&quot;">
      		<fo:inline>
                          Vous n'avez pas accepté le règlement intérieur
                        </fo:inline>
		<fo:block>
		  <fo:leader leader-pattern="space" />
		</fo:block>
      	      </xsl:if>
	    </fo:block>

    
      
              <fo:block>
              <fo:leader leader-pattern="space" />
            </fo:block>
  
                  <fo:block xsl:use-attribute-sets="request.section.header">Autorisation d'exploitation de la photo de l'enfant</fo:block>
	    <fo:block>
	      <fo:leader leader-pattern="space" />
	    </fo:block>
        
                                	    <fo:block xsl:use-attribute-sets="request.signature">
	      <xsl:if test="//parr:ChildPhotoExploitationPermission/text() = &quot;true&quot;">
      		<fo:inline>
                          J'autorise l'exposition et la diffusion des photographies de mon enfant.
                        </fo:inline>
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
	      <xsl:if test="//parr:ChildPhotoExploitationPermission/text() = &quot;false&quot;">
      		<fo:inline>
                          Vous n'avez pas autorisé l'exposition et la diffusion des photographies de
                          votre enfant.
                        </fo:inline>
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
            <xsl:value-of select="parr:PerischoolActivityRegistrationRequest/cvq:Id"/>
          </xsl:with-param>
	      <xsl:with-param name="CreationDate">
            <xsl:value-of select="parr:PerischoolActivityRegistrationRequest/cvq:CreationDate"/>
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
                                                                                <xsl:template match="//parr:ContactIndividuals/parr:Address">
              <xsl:call-template name="AddressType">
      <xsl:with-param name="localizationService" select="$localizationService"></xsl:with-param>
    </xsl:call-template>
  </xsl:template>
                                                                                                                          <xsl:template match="//parr:AuthorizedIndividuals/parr:Address">
              <xsl:call-template name="AddressType">
      <xsl:with-param name="localizationService" select="$localizationService"></xsl:with-param>
    </xsl:call-template>
  </xsl:template>
                                                                                </xsl:stylesheet>
