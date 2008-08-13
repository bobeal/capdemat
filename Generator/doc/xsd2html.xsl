<?xml version="1.0"?>
<xsl:transform xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
  version="1.0" xmlns:xs="http://www.w3.org/2001/XMLSchema"
  exclude-result-prefixes="xs">

  <xsl:output method="html"/>

  <xsl:template match="xs:attribute" mode="attributes">
    <tr valign="baseline">
      <th align="left" rowspan="2">
        <xsl:value-of select="@name"/>
      </th>
      <td>
        <xsl:choose>
          <xsl:when test="xs:simpleType">
            <xsl:apply-templates select="xs:simpleType"/>
          </xsl:when>
          <xsl:when test="@type">
            <xsl:call-template name="simpleType">
              <xsl:with-param name="type" select="@type"/>
            </xsl:call-template>
          </xsl:when>
        </xsl:choose>
      </td>
      <td>
        <xsl:choose>
          <xsl:when test="@use">
            <xsl:value-of select="@use"/>
          </xsl:when>
          <xsl:otherwise>
            <xsl:text>optional</xsl:text>
          </xsl:otherwise>
        </xsl:choose>
	<xsl:if test="@default">
	  <xsl:text>; default: </xsl:text>
	  <code>
	    <xsl:value-of select="@default"/>
	  </code>
	</xsl:if>
      </td>
    </tr>
    <tr valign="baseline">
      <td colspan="2">
        <xsl:apply-templates select="xs:annotation"/>
      </td>
    </tr>
  </xsl:template>

  <xsl:template match="xs:attribute"/>

  <xsl:template match="xs:choice/xs:choice | xs:sequence/xs:choice">
    <li>
      <xsl:call-template name="occurrence"/>
      <xsl:text> choice of:</xsl:text>
      <ul>
        <xsl:apply-templates/>
      </ul>
    </li>
  </xsl:template>

  <xsl:template match="xs:choice">
    <p>
      <xsl:call-template name="occurrence"/>
      <xsl:text> choice of:</xsl:text>
    </p>
    <ul>
      <xsl:apply-templates/>
    </ul>
  </xsl:template>

  <xsl:template match="xs:complexType">
  	<xsl:element name="h2">
  		<xsl:attribute name="id">cvq-type-<xsl:value-of select="@name"/></xsl:attribute>
  		Complex Type : <xsl:value-of select="@name"/>
  	</xsl:element>
    <xsl:choose>
      <xsl:when test="xs:all">
        <p>All</p>
      </xsl:when>
      <xsl:when test="xs:choice | xs:complexContent | xs:group |
                      xs:sequence | xs:simpleContent">
        <xsl:if test="@mixed='true'">
          <p>Mixed content, including:</p>
        </xsl:if>
        <xsl:apply-templates/>
      </xsl:when>
      <xsl:when test="@mixed='true'">
        <p>Character content</p>
      </xsl:when>
      <xsl:otherwise>
        <p>Empty</p>
      </xsl:otherwise>
    </xsl:choose>
  </xsl:template>

  <xsl:template match="xs:simpleType">
  	<xsl:element name="h2">
  		<xsl:attribute name="id">cvq-type-<xsl:value-of select="@name"/></xsl:attribute>
  		Simple Type : <xsl:value-of select="@name"/>
  	</xsl:element>
    <xsl:apply-templates/>
  </xsl:template>

  <xsl:template match="xs:schema/xs:annotation/xs:documentation">
    <xsl:choose>
      <xsl:when test="count(.. |
                      ../../xs:annotation[xs:documentation][1]) = 1">
        <h1>
          <xsl:apply-templates/>
        </h1>
        <xsl:call-template name="toc"/>
      </xsl:when>
      <xsl:otherwise>
        <p>
          <xsl:apply-templates/>
        </p>
      </xsl:otherwise>
    </xsl:choose>
  </xsl:template>

  <xsl:template match="xs:documentation">
  	<xsl:if test="not(starts-with(@source,'http://www.cg95.fr/cvq/schema/translation'))">
      <p>
  		<xsl:if test="@xml:lang = 'fr'">FranÃ§ais </xsl:if>
  		<xsl:if test="@xml:lang = 'en'">Anglais </xsl:if>
  		<xsl:if test="@source = 'http://www.cg95.fr/cvq/schema/shortdesc'">(description courte) : </xsl:if>
  		<xsl:if test="@source = 'http://www.cg95.fr/cvq/schema/longdesc'">(description longue) : </xsl:if>
      	<xsl:apply-templates/>
      </p>
    </xsl:if>
  </xsl:template>

  <xsl:template match="xs:element[@name]">
    <h2 id="element-type-{@name}">
      <xsl:text>Element Type: </xsl:text>
      <xsl:value-of select="@name"/>
    </h2>
    <xsl:if test="/xs:schema/@targetNamespace">
      <p>
        <xsl:text>Namespace: </xsl:text>
        <code>
          <xsl:value-of select="/xs:schema/@targetNamespace"/>
        </code>
      </p>
    </xsl:if>
    <xsl:apply-templates select="xs:annotation"/>
    <xsl:if test="descendant::xs:attribute">
      <table border="1">
        <caption>Attributes</caption>
        <xsl:apply-templates select="descendant::xs:attribute"
          mode="attributes"/>
      </table>
    </xsl:if>
    <h3>Content Model</h3>
    <xsl:choose>
      <xsl:when test="xs:complexType">
        <xsl:apply-templates select="xs:complexType"/>
      </xsl:when>
      <xsl:when test="xs:simpleType">
        <xsl:apply-templates select="xs:simpleType"/>
      </xsl:when>
      <xsl:when test="@type">
        <p>
          <xsl:call-template name="simpleType">
            <xsl:with-param name="type" select="@type"/>
          </xsl:call-template>
        </p>
      </xsl:when>
      <xsl:otherwise>
        <p>Empty</p>
      </xsl:otherwise>
    </xsl:choose>
  </xsl:template>

  <xsl:template
    match="xs:choice/xs:element[@ref] | xs:sequence/xs:element[@ref]">
    <li>
      <xsl:call-template name="occurrence"/>
      <xsl:text> </xsl:text>
      <a href="#element-type-{@ref}">
        <xsl:value-of select="@ref"/>
      </a>
    </li>
  </xsl:template>

  <xsl:template match="xs:enumeration">
    <li>
      <code>
        <xsl:value-of select="@value"/>
      </code>
    </li>
  </xsl:template>

  <xsl:template match="xs:group[@name]">
    <h2 id="group-{@name}">
      <xsl:text>Content Model Group: </xsl:text>
      <xsl:value-of select="@name"/>
    </h2>
    <xsl:apply-templates select="xs:annotation"/>
    <xsl:if test="descendant::xs:attribute">
      <table border="1">
        <caption>Attributes</caption>
        <xsl:apply-templates select="descendant::xs:attribute"
          mode="attributes"/>
      </table>
    </xsl:if>
    <h3>Content Particle</h3>
    <xsl:apply-templates select="xs:choice | xs:complexContent |
                                 xs:group | xs:sequence |
                                 xs:simpleContent"/>
  </xsl:template>

  <xsl:template
    match="xs:choice/xs:group[@ref] | xs:sequence/xs:group[@ref]"
    priority="2">
    <li>
      <xsl:call-template name="occurrence"/>
      <xsl:text> </xsl:text>
      <a href="#group-{@ref}">
        <xsl:value-of select="@ref"/>
      </a>
      <xsl:text> group</xsl:text>
    </li>
  </xsl:template>

  <xsl:template match="xs:group[@ref]" priority="1">
    <ul>
      <li>
        <xsl:call-template name="occurrence"/>
        <xsl:text> </xsl:text>
        <a href="#group-{@ref}">
          <xsl:value-of select="@ref"/>
        </a>
        <xsl:text> group</xsl:text>
      </li>
    </ul>
  </xsl:template>

  <xsl:template match="xs:restriction">
    <p>
      <xsl:call-template name="simpleType">
        <xsl:with-param name="type" select="@base"/>
      </xsl:call-template>
    </p>
    <xsl:if test="xs:enumeration">
      <p>
        <xsl:text>Enumeration:</xsl:text>
      </p>
      <ul>
        <xsl:apply-templates select="xs:enumeration"/>
      </ul>
    </xsl:if>
  </xsl:template>

  <xsl:template match="xs:schema">
    <html>
      <head>
        <title>
          <xsl:value-of
            select="xs:annotation[xs:documentation][1]/
                    xs:documentation"/>
        </title>
        <style>
          body { background: white;
                 color: black; }
          h2   { border-top: black solid 1px;
                 margin-top: 2em;
                 padding-top: 1em; }
        </style>
      </head>
      <body>
        <xsl:apply-templates/>
      </body>
    </html>
  </xsl:template>

  <xsl:template
    match="xs:choice/xs:sequence | xs:sequence/xs:sequence">
    <li>
      <xsl:call-template name="occurrence"/>
      <xsl:text> sequences of:</xsl:text>
      <ol>
        <xsl:apply-templates/>
      </ol>
    </li>
  </xsl:template>

  <xsl:template match="xs:sequence">
    <p>
      <xsl:call-template name="occurrence"/>
      <xsl:text> sequences of:</xsl:text>
    </p>
    <ol>
      <xsl:apply-templates/>
    </ol>
  </xsl:template>

  <xsl:template name="occurrence">
    <xsl:variable name="minOccurs">
      <xsl:choose>
        <xsl:when test="@minOccurs">
          <xsl:value-of select="@minOccurs"/>
        </xsl:when>
        <xsl:otherwise>
          <xsl:value-of select="1"/>
        </xsl:otherwise>
      </xsl:choose>
    </xsl:variable>
    <xsl:variable name="maxOccurs">
      <xsl:choose>
        <xsl:when test="@maxOccurs">
          <xsl:value-of select="@maxOccurs"/>
        </xsl:when>
        <xsl:otherwise>
          <xsl:value-of select="1"/>
        </xsl:otherwise>
      </xsl:choose>
    </xsl:variable>
    <xsl:choose>
      <xsl:when test="$minOccurs = $maxOccurs">
        <xsl:text>Exactly </xsl:text>
        <xsl:value-of select="$minOccurs"/>
      </xsl:when>
      <xsl:when test="$minOccurs = 0 and $maxOccurs = 'unbounded'">
        <xsl:text>Optional repeatable</xsl:text>
      </xsl:when>
      <xsl:when test="$maxOccurs = 'unbounded'">
        <xsl:value-of select="$minOccurs"/>
        <xsl:text> or more</xsl:text>
      </xsl:when>
      <xsl:when test="$minOccurs = 0 and $maxOccurs = 1">
        <xsl:text>An optional</xsl:text>
      </xsl:when>
      <xsl:when test="$minOccurs = 0">
        <xsl:text>Up to </xsl:text>
        <xsl:value-of select="$maxOccurs"/>
      </xsl:when>
      <xsl:otherwise>
        <xsl:text>Between </xsl:text>
        <xsl:value-of select="$minOccurs"/>
        <xsl:text> and </xsl:text>
        <xsl:value-of select="$maxOccurs"/>
      </xsl:otherwise>
    </xsl:choose>
  </xsl:template>

  <xsl:template name="simpleType">
    <xsl:param name="type"/>
    <xsl:choose>
      <xsl:when test="starts-with($type, 'xs:')">
        <xsl:text>Built-in type : </xsl:text>
        <xsl:value-of select="substring-after($type, ':')"/>
      </xsl:when>
      <xsl:when test="starts-with($type, 'cvq:')">
        <xsl:text>CVQ type : </xsl:text>
        <xsl:element name="a">
        	<xsl:attribute name="href">#cvq-type-<xsl:value-of select="substring-after($type, ':')"/></xsl:attribute>
			<xsl:value-of select="substring-after($type, ':')"/>
        </xsl:element>
      </xsl:when>
      <xsl:otherwise>
        <xsl:text>Simple type </xsl:text>
        <a href="#simple-type-{$type}">
          <xsl:value-of select="$type"/>
        </a>
      </xsl:otherwise>
    </xsl:choose>
  </xsl:template>

  <xsl:template name="toc">
    <h2>Table of Contents</h2>
    <xsl:if test="/xs:schema/xs:element">
      <h3>Elements</h3>
      <ul>
        <xsl:for-each select="/xs:schema/xs:element">
          <xsl:sort select="@name"/>
          <li>
            <a href="#element-type-{@name}">
              <xsl:value-of select="@name"/>
            </a>
          </li>
        </xsl:for-each>
      </ul>
    </xsl:if>
    <xsl:if test="/xs:schema/xs:group">
      <h3>Content Model Groups</h3>
      <ul>
        <xsl:for-each select="/xs:schema/xs:group">
          <xsl:sort select="@name"/>
          <li>
            <a href="#group-{@name}">
              <xsl:value-of select="@name"/>
            </a>
          </li>
        </xsl:for-each>
      </ul>
    </xsl:if>
  </xsl:template>

</xsl:transform>
