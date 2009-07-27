<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" 
  xmlns:vo="http://www.cg95.fr/cvq/schema/vo"
  xmlns:cvq="http://www.cg95.fr/cvq/schema/common" 
  xmlns:ref="http://www.cg95.fr/cvq/schema/referential" 
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
  xmlns:fo="http://www.w3.org/1999/XSL/Format" 
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
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
	      <xsl:with-param name="RequestName">Demande de création de compte</xsl:with-param>
          <xsl:with-param name="FriendlyLocalAuthorityName"><xsl:value-of select="$friendlyLocalAuthorityName"/></xsl:with-param>
	    </xsl:call-template>

	    <fo:block>
	      <fo:leader leader-pattern="space" />
	    </fo:block>

            <fo:block xsl:use-attribute-sets="request.section.header">Responsable Foyer</fo:block>

	    <xsl:apply-templates select="//cvq:Requester"/>

	    <fo:block>
	      <fo:leader leader-pattern="space"/>
	    </fo:block>

            <fo:block xsl:use-attribute-sets="request.section.header">Autres adultes</fo:block>

	    <xsl:variable name="requesterId" select="//cvq:Requester/cvq:Id"/>
	    <xsl:for-each select="//cvq:HomeFolder/cvq:Individuals">
	      <xsl:if test="contains(@xsi:type, 'AdultType') and not(cvq:Id = $requesterId)">
		<xsl:apply-templates select="."/>
		<xsl:if test="not(position() = last())">
		  <fo:block>
		    <fo:leader leader-pattern="dots" leader-length.optimum="100%"/>
		  </fo:block>
		  <fo:block>
		    <fo:leader leader-pattern="space"/>
		  </fo:block>
		</xsl:if>
	      </xsl:if>
	    </xsl:for-each>

	    <fo:block>
	      <fo:leader leader-pattern="space" />
	    </fo:block>

            <fo:block xsl:use-attribute-sets="request.section.header">Enfant(s)</fo:block>

	    <fo:table xsl:use-attribute-sets="request.field.inline.table">
	      <fo:table-column column-width="proportional-column-width(1)"/>
	      <fo:table-column column-width="proportional-column-width(1)"/>
	      <fo:table-column column-width="proportional-column-width(1)"/>
	      <fo:table-header>
		<fo:table-row>
		  <fo:table-cell xsl:use-attribute-sets="request.field.table.cell">
		    <fo:block xsl:use-attribute-sets="request.field.table.label">
		      Sexe (M ou F)
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell xsl:use-attribute-sets="request.field.table.cell">
		    <fo:block xsl:use-attribute-sets="request.field.table.label">
		      Nom et prénoms
		    </fo:block>
		  </fo:table-cell>
		  <fo:table-cell xsl:use-attribute-sets="request.field.table.cell">
		    <fo:block xsl:use-attribute-sets="request.field.table.label">
		      Date de naissance
		    </fo:block>
		  </fo:table-cell>
		</fo:table-row>
	      </fo:table-header>
	      <fo:table-body>
		<xsl:for-each select="//cvq:HomeFolder/cvq:Individuals">
		  <xsl:if test="contains(@xsi:type, 'ChildType')">
		    <fo:table-row>
		      <fo:table-cell xsl:use-attribute-sets="request.field.table.cell">
			<fo:block xsl:use-attribute-sets="request.field.table.value">
			  <xsl:if test="cvq:Sex = &quot;Male&quot;">M</xsl:if>
			  <xsl:if test="cvq:Sex = &quot;Female&quot;">F</xsl:if>
			</fo:block>
		      </fo:table-cell>
		      <fo:table-cell xsl:use-attribute-sets="request.field.table.cell">
			<fo:block xsl:use-attribute-sets="request.field.table.value">
			  <xsl:value-of select="cvq:LastName"/>
			  &#160;<xsl:value-of select="cvq:FirstName"/>
			  &#160;<xsl:value-of select="cvq:FirstName2"/>
			  &#160;<xsl:value-of select="cvq:FirstName3"/>
			</fo:block>
		      </fo:table-cell>
		      <fo:table-cell xsl:use-attribute-sets="request.field.table.cell">
			<fo:block xsl:use-attribute-sets="request.field.table.value">
			  <xsl:call-template name="cvq:DisplayDate">
			    <xsl:with-param name="DateToDisplay">
			      <xsl:value-of select="cvq:BirthDate"/>
			    </xsl:with-param>
			  </xsl:call-template>
			</fo:block>
		      </fo:table-cell>
		    </fo:table-row>
                  </xsl:if>
		</xsl:for-each>
	      </fo:table-body>
	    </fo:table>

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

            <fo:block xsl:use-attribute-sets="request.section.header">Déclaration sur l'honneur*</fo:block>

	    <fo:block>
	      <fo:leader leader-pattern="space" />
	    </fo:block>
    
       	    <fo:block xsl:use-attribute-sets="request.signature">
	      <fo:inline>Je soussigné(e)</fo:inline>
	      <fo:inline font-weight="bold">
		&#160;&#160;<xsl:value-of select="//cvq:Requester/cvq:LastName" />
		&#160;<xsl:value-of select="//cvq:Requester/cvq:FirstName" />&#160;
	      </fo:inline>
	      <fo:inline>&#160;certifie sur l&apos;honneur l&apos;exactitude des renseignements donnés et m'engage à en signaler immédiatement toute modification.</fo:inline>
	      <fo:block>
		<fo:leader leader-pattern="space" />
	      </fo:block>
	      <fo:inline>A*
		...................................................,&#160;&#160;
		le *&#160;&#160;../../....&#160;Signature du demandeur *
	      </fo:inline>
	      <fo:block>
		<fo:leader leader-pattern="space" />
	      </fo:block>
	    </fo:block>

	    <fo:block>
	      <fo:leader leader-pattern="space" />
	    </fo:block>

	    <xsl:call-template name="requestFooter">
	      <xsl:with-param name="RequestId">
                <xsl:value-of select="vo:VoCardRequest/cvq:Id"/>
              </xsl:with-param>
        <xsl:with-param name="CreationDate">
                <xsl:value-of select="vo:VoCardRequest/cvq:CreationDate"/>
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

  <xsl:template match="//cvq:Individuals">
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
