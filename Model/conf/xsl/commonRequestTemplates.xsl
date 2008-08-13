<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" 
  xmlns:com="http://www.cg95.fr/cvq/schema/common"
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
  xmlns:fo="http://www.w3.org/1999/XSL/Format">

  <xsl:template name="requestHeader">
    <xsl:param name="RequestName"/>
    <xsl:param name="FriendlyLocalAuthorityName"/>
    
    <fo:table xsl:use-attribute-sets="request.header.table">
      <fo:table-column />
      <fo:table-column />
      <fo:table-column />
      <fo:table-body>
	<fo:table-row>
	  <fo:table-cell xsl:use-attribute-sets="request.header.table.cell">
	    <fo:block>
	      <xsl:if test="$logoSource">
            <fo:external-graphic space-before.optimum="4pt" space-after.optimum="4pt">
		      <xsl:attribute name="src">
		        <xsl:value-of select="$logoSource"/>
		      </xsl:attribute>
		    </fo:external-graphic>
	      </xsl:if>
	    </fo:block>
	  </fo:table-cell>

	  <fo:table-cell xsl:use-attribute-sets="request.header.table.cell">
	    <fo:block xsl:use-attribute-sets="request.header.table.cell.localAuth">
	      <xsl:call-template name="com:LocalAuthority">
            <xsl:with-param name="Name"><xsl:value-of select="$FriendlyLocalAuthorityName"/></xsl:with-param>
	      </xsl:call-template>
	    </fo:block>
	  </fo:table-cell>

	  <fo:table-cell xsl:use-attribute-sets="request.header.table.cell">
	    <fo:block xsl:use-attribute-sets="request.header.table.cell.requestName">
	      <xsl:value-of select="$RequestName"/>
	    </fo:block>
	  </fo:table-cell>
	
	</fo:table-row>
      </fo:table-body>
    </fo:table>
    
    <fo:block xsl:use-attribute-sets="request.header.notice">
      Les informations suivies d&apos;une * sont obligatoires
    </fo:block>

    <fo:block>
      <fo:leader leader-pattern="space" />
    </fo:block>

  </xsl:template>

  <xsl:template name="requestFooter">
    <xsl:param name="RequestId"/>
    <xsl:param name="CreationDate"/>

    <fo:block xsl:use-attribute-sets="request.section.header">CADRE RESERVE A L&apos;ADMINISTRATION</fo:block>

    <fo:block>
      <fo:leader leader-pattern="space" />
    </fo:block>

    <fo:block xsl:use-attribute-sets="request.footer">
      <fo:inline xsl:use-attribute-sets="request.footer.label">
	Code de l&apos;agent :
	&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;
	Date :
      </fo:inline>
      <fo:inline xsl:use-attribute-sets="request.footer.value">
	<xsl:call-template name="com:DisplayDate">
	  <xsl:with-param name="DateToDisplay">
	    <xsl:value-of select="$CreationDate"/>
	  </xsl:with-param>
	</xsl:call-template>
      </fo:inline>
      <fo:inline xsl:use-attribute-sets="request.footer.label">
	&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;
	N&#186; de suivi de la demande :&#160;
      </fo:inline>
      <fo:inline xsl:use-attribute-sets="request.footer.value">
	<xsl:value-of select="$RequestId"/>
      </fo:inline>
      <fo:block>
	<fo:leader leader-pattern="space" />
      </fo:block>
      <fo:inline xsl:use-attribute-sets="request.footer.label">
	Observations :&#160;
      </fo:inline>
      <fo:inline xsl:use-attribute-sets="request.footer.value">
	<xsl:apply-templates select="//com:Observations"/>
      </fo:inline>
      <fo:block>
	<fo:leader leader-pattern="space" />
      </fo:block>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160; 
    </fo:block>

  </xsl:template>

</xsl:stylesheet>
