<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
  xmlns:fo="http://www.w3.org/1999/XSL/Format" 
  xmlns:com="http://www.cg95.fr/cvq/schema/common"
  xmlns:ref="http://www.cg95.fr/cvq/schema/referential"
  xmlns:pr="http://www.cg95.fr/cvq/schema/pr"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
  xmlns:exslt="http://exslt.org/common"
  xmlns:locservice="java:fr.cg95.cvq.util.localization.impl.LocalizationService">

  <xsl:template name="com:LocalAuthority">
    <xsl:param name="Name" />
    <fo:inline>
      <xsl:value-of select="$Name" />
    </fo:inline>
  </xsl:template>

  <!-- not used currently
    <xsl:template match="//*[local-name(.)='School']w">
    <fo:inline>
    <xsl:value-of select="com:Name"/>
    </fo:inline>
    </xsl:template>
  -->

  <xsl:template name="com:DisplayDate">
    <xsl:param name="DateToDisplay" />

    <xsl:choose>
      <xsl:when test="$DateToDisplay and $DateToDisplay != ''">
        <xsl:value-of select="format-number(substring($DateToDisplay, 9, 2), '00')" />
        <xsl:text>/</xsl:text>
        <xsl:value-of select="format-number(substring($DateToDisplay, 6, 2), '00')" />
        <xsl:text>/</xsl:text>
        <xsl:value-of select="format-number(substring($DateToDisplay, 1, 4), '0000')" />
      </xsl:when>
      <xsl:otherwise>
        <xsl:text>&#160;</xsl:text>
      </xsl:otherwise>
    </xsl:choose>
  </xsl:template>

  <xsl:template name="AddressType">
    <fo:table xsl:use-attribute-sets="request.field.inline.table">
      <fo:table-column column-width="proportional-column-width(1)" />
      <fo:table-column column-width="proportional-column-width(3)" />
      <fo:table-body>
        <fo:table-row>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.label">
              N° App ou Bal-Etg-Coul-Esc
            </fo:block>
          </fo:table-cell>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
              <xsl:if test="string(./com:AdditionalDeliveryInformation)">
                <xsl:value-of select="./com:AdditionalDeliveryInformation" />
              </xsl:if>
              <xsl:if test="not(string(./com:AdditionalDeliveryInformation))">&#160;</xsl:if>
            </fo:block>
          </fo:table-cell>
        </fo:table-row>
      </fo:table-body>
    </fo:table>
    <fo:table xsl:use-attribute-sets="request.field.inline.table">
      <fo:table-column column-width="proportional-column-width(1)" />
      <fo:table-column column-width="proportional-column-width(3)" />
      <fo:table-body>
        <fo:table-row>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.label">
              Ent-Bat-Imm-Res
            </fo:block>
          </fo:table-cell>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
              <xsl:if test="string(./com:AdditionalGeographicalInformation)">
                <xsl:value-of select="./com:AdditionalGeographicalInformation" />
              </xsl:if>
              <xsl:if test="not(string(./com:AdditionalGeographicalInformation))">&#160;</xsl:if>
            </fo:block>
          </fo:table-cell>
        </fo:table-row>
      </fo:table-body>
    </fo:table>
    <fo:table xsl:use-attribute-sets="request.field.inline.table">
      <fo:table-column column-width="proportional-column-width(1)" />
      <fo:table-column column-width="proportional-column-width(3)" />
      <fo:table-body>
        <fo:table-row>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.label">Numéro et libellé de voie *</fo:block>
          </fo:table-cell>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
              <xsl:if test="string(./com:StreetName)">
              	<xsl:if test="string(./com:StreetNumber)">
                  <xsl:value-of select="./com:StreetNumber" />
	          &#160;
		</xsl:if>
                <xsl:value-of select="./com:StreetName" />
              </xsl:if>
              <xsl:if test="not(string(./com:StreetName))">&#160;</xsl:if>
            </fo:block>
          </fo:table-cell>
        </fo:table-row>
      </fo:table-body>
    </fo:table>

    <fo:table xsl:use-attribute-sets="request.field.inline.table">
      <fo:table-column column-width="proportional-column-width(1)" />
      <fo:table-column column-width="proportional-column-width(3)" />
      <fo:table-body>
        <fo:table-row>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.label">
              Lieu dit / Service particulier
            </fo:block>
          </fo:table-cell>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
              <xsl:if test="string(./com:PlaceNameOrService)">
                <xsl:value-of select="./com:PlaceNameOrService" />
              </xsl:if>
              <xsl:if test="not(string(./com:PlaceNameOrService))">&#160;</xsl:if>
            </fo:block>
          </fo:table-cell>
        </fo:table-row>
      </fo:table-body>
    </fo:table>

    <fo:table xsl:use-attribute-sets="request.field.inline.table">
      <fo:table-column column-width="proportional-column-width(1)" />
      <fo:table-column column-width="proportional-column-width(1)" />
      <fo:table-column column-width="proportional-column-width(1)" />
      <fo:table-column column-width="proportional-column-width(1)" />
      <fo:table-body>
        <fo:table-row>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.label">Code Postal</fo:block>
          </fo:table-cell>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
              <xsl:value-of select="./com:PostalCode" />
            </fo:block>
          </fo:table-cell>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.label">Commune*</fo:block>
          </fo:table-cell>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
              <xsl:value-of select="./com:City" />
            </fo:block>
          </fo:table-cell>
        </fo:table-row>
      </fo:table-body>
    </fo:table>
    
  </xsl:template>

  <xsl:template name="SubjectType">
    <xsl:param name="localizationService"></xsl:param>

    <xsl:for-each select="./child::*">
      <xsl:if test="contains(local-name(), 'Adult')">
        <xsl:call-template name="AdultType">
          <xsl:with-param name="localizationService" select="$localizationService"></xsl:with-param>
        </xsl:call-template>
      </xsl:if>
      <xsl:if test="contains(local-name(), 'Child')">
        <xsl:call-template name="ChildType">
          <xsl:with-param name="localizationService" select="$localizationService"></xsl:with-param>
        </xsl:call-template>
      </xsl:if>
      <xsl:if test="contains(local-name(), 'Individual')">
        <xsl:call-template name="IndividualType">
          <xsl:with-param name="localizationService" select="$localizationService"></xsl:with-param>
        </xsl:call-template>
      </xsl:if>
    </xsl:for-each>

  </xsl:template>

  <xsl:template name="ChildType">

    <fo:table xsl:use-attribute-sets="request.field.inline.table">
      <fo:table-column column-width="proportional-column-width(1)" />
      <fo:table-column column-width="proportional-column-width(1)" />
      <fo:table-column column-width="proportional-column-width(1)" />
      <fo:table-column column-width="proportional-column-width(1)" />
      <fo:table-body>
        <fo:table-row>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.label">Nom*</fo:block>
          </fo:table-cell>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
              <xsl:value-of select="./com:LastName" />
            </fo:block>
          </fo:table-cell>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.label">Prénom*</fo:block>
          </fo:table-cell>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
              <xsl:value-of select="./com:FirstName" />
              &#160;
              <xsl:value-of select="./com:FirstName2" />
              &#160;
              <xsl:value-of select="./com:FirstName3" />
            </fo:block>
          </fo:table-cell>
        </fo:table-row>
      </fo:table-body>
    </fo:table>

    <fo:table xsl:use-attribute-sets="request.field.inline.table">
      <fo:table-column column-width="proportional-column-width(1)" />
      <fo:table-column column-width="proportional-column-width(1)" />
      <fo:table-column column-width="proportional-column-width(1)" />
      <fo:table-column column-width="30pt" />
      <fo:table-column column-width="proportional-column-width(1) - 30pt" />
      <fo:table-body>
        <fo:table-row>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.label">
              Date de naissance*
            </fo:block>
          </fo:table-cell>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
              <xsl:call-template name="com:DisplayDate">
                <xsl:with-param name="DateToDisplay">
                  <xsl:value-of select="com:BirthDate" />
                </xsl:with-param>
              </xsl:call-template>
            </fo:block>
          </fo:table-cell>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.label">Sexe* (M/F)</fo:block>
          </fo:table-cell>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.char_value">
              <xsl:choose>
                <xsl:when test="./com:Sex = &quot;Male&quot;">M</xsl:when>
                <xsl:when test="./com:Sex = &quot;Female&quot;">F</xsl:when>
                <xsl:otherwise>&#x00A0;</xsl:otherwise>
              </xsl:choose>
            </fo:block>
          </fo:table-cell>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.label">&#160;</fo:block>
          </fo:table-cell>
        </fo:table-row>
      </fo:table-body>
    </fo:table>

    <fo:table xsl:use-attribute-sets="request.field.inline.table">
      <fo:table-column column-width="proportional-column-width(1)" />
      <fo:table-column column-width="proportional-column-width(1)" />
      <fo:table-column column-width="proportional-column-width(1)" />
      <fo:table-column column-width="proportional-column-width(1)" />
      <fo:table-body>
        <fo:table-row>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.label">
              Ville de naissance*
            </fo:block>
          </fo:table-cell>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
              <xsl:if test="string(./com:BirthPlace/com:City)">
                <xsl:value-of select="./com:BirthPlace/com:City" />
              </xsl:if>
              <xsl:if test="not(string(./com:BirthPlace/com:City))">&#160;</xsl:if>
            </fo:block>
          </fo:table-cell>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.label">
              Code postal de naissance *
            </fo:block>
          </fo:table-cell>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
              <xsl:if test="string(./com:BirthPlace/com:PostalCode)">
                <xsl:value-of select="./com:BirthPlace/com:PostalCode" />
              </xsl:if>
              <xsl:if test="not(string(./com:BirthPlace/com:PostalCode))">&#160;</xsl:if>
            </fo:block>
          </fo:table-cell>
        </fo:table-row>
      </fo:table-body>
    </fo:table>

    <fo:table xsl:use-attribute-sets="request.field.inline.table">
      <fo:table-column column-width="proportional-column-width(1)" />
      <fo:table-column column-width="proportional-column-width(3)" />
      <fo:table-body>
        <fo:table-row>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.label">
              N° App ou Bal-Etg-Coul-Esc
            </fo:block>
          </fo:table-cell>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
              <xsl:if test="string(./com:Address/com:AdditionalDeliveryInformation)">
                <xsl:value-of select="./com:Address/com:AdditionalDeliveryInformation" />
              </xsl:if>
              <xsl:if test="not(string(./com:Address/com:AdditionalDeliveryInformation))">&#160;</xsl:if>
            </fo:block>
          </fo:table-cell>
        </fo:table-row>
      </fo:table-body>
    </fo:table>
    <fo:table xsl:use-attribute-sets="request.field.inline.table">
      <fo:table-column column-width="proportional-column-width(1)" />
      <fo:table-column column-width="proportional-column-width(3)" />
      <fo:table-body>
        <fo:table-row>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.label">
              Ent-Bat-Imm-Res
            </fo:block>
          </fo:table-cell>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
              <xsl:if test="string(./com:Address/com:AdditionalGeographicalInformation)">
                <xsl:value-of select="./com:Address/com:AdditionalGeographicalInformation" />
              </xsl:if>
              <xsl:if test="not(string(./com:Address/com:AdditionalGeographicalInformation))">&#160;</xsl:if>
            </fo:block>
          </fo:table-cell>
        </fo:table-row>
      </fo:table-body>
    </fo:table>
    <fo:table xsl:use-attribute-sets="request.field.inline.table">
      <fo:table-column column-width="proportional-column-width(1)" />
      <fo:table-column column-width="proportional-column-width(3)" />
      <fo:table-body>
        <fo:table-row>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.label">
              Adresse de l&apos;enfant*
            </fo:block>
          </fo:table-cell>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
              <xsl:if test="string(./com:Address/com:StreetName)">
              	<xsl:if test="string(./com:Address/com:StreetNumber)">
                  <xsl:value-of select="./com:Address/com:StreetNumber" />
	          &#160;
		</xsl:if>
                <xsl:value-of select="./com:Address/com:StreetName" />
              </xsl:if>
              <xsl:if test="not(string(./com:Address/com:StreetName))">&#160;</xsl:if>
            </fo:block>
          </fo:table-cell>
        </fo:table-row>
      </fo:table-body>
    </fo:table>

    <fo:table xsl:use-attribute-sets="request.field.inline.table">
      <fo:table-column column-width="proportional-column-width(1)" />
      <fo:table-column column-width="proportional-column-width(3)" />
      <fo:table-body>
        <fo:table-row>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.label">
              Lieu dit / Service particulier
            </fo:block>
          </fo:table-cell>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
              <xsl:if test="string(./com:PlaceNameOrService)">
                <xsl:value-of select="./com:PlaceNameOrService" />
              </xsl:if>
              <xsl:if test="not(string(./com:PlaceNameOrService))">&#160;</xsl:if>
            </fo:block>
          </fo:table-cell>
        </fo:table-row>
      </fo:table-body>
    </fo:table>

    <fo:table xsl:use-attribute-sets="request.field.inline.table">
      <fo:table-column column-width="proportional-column-width(1)" />
      <fo:table-column column-width="proportional-column-width(1)" />
      <fo:table-column column-width="proportional-column-width(1)" />
      <fo:table-column column-width="proportional-column-width(1)" />
      <fo:table-body>
        <fo:table-row>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.label">Code postal*</fo:block>
          </fo:table-cell>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
              <xsl:value-of select="./com:Address/com:PostalCode" />
            </fo:block>
          </fo:table-cell>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.label">Commune*</fo:block>
          </fo:table-cell>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
              <xsl:value-of select="./com:Address/com:City" />
            </fo:block>
          </fo:table-cell>
        </fo:table-row>
      </fo:table-body>
    </fo:table>
  </xsl:template>

  <xsl:template name="IndividualType">

    <fo:table xsl:use-attribute-sets="request.field.inline.table">
      <fo:table-column column-width="proportional-column-width(1)" />
      <fo:table-column column-width="proportional-column-width(1)" />
      <fo:table-column column-width="proportional-column-width(1)" />
      <fo:table-column column-width="proportional-column-width(1)" />
      <fo:table-body>
        <fo:table-row>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.label">Nom*</fo:block>
          </fo:table-cell>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
              <xsl:if test="string(./com:LastName)">
                <xsl:value-of select="./com:LastName" />
              </xsl:if>
              <xsl:if test="not(string(./com:LastName))">&#160;</xsl:if>
            </fo:block>
          </fo:table-cell>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.label">Prénom*</fo:block>
          </fo:table-cell>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
              <xsl:value-of select="./com:FirstName" />
              &#160;
              <xsl:value-of select="./com:FirstName2" />
              &#160;
              <xsl:value-of select="./com:FirstName3" />
            </fo:block>
          </fo:table-cell>
        </fo:table-row>
      </fo:table-body>
    </fo:table>

    <fo:table xsl:use-attribute-sets="request.field.inline.table">
      <fo:table-column column-width="proportional-column-width(1)" />
      <fo:table-column column-width="proportional-column-width(1)" />
      <fo:table-column column-width="proportional-column-width(1)" />
      <fo:table-column column-width="30pt" />
      <fo:table-column column-width="proportional-column-width(1) - 30pt" />
      <fo:table-body>
        <fo:table-row>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.label">
              Date de naissance*
            </fo:block>
          </fo:table-cell>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
              <xsl:call-template name="com:DisplayDate">
                <xsl:with-param name="DateToDisplay">
                  <xsl:value-of select="com:BirthDate" />
                </xsl:with-param>
              </xsl:call-template>
            </fo:block>
          </fo:table-cell>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.label">Sexe* (M/F)</fo:block>
          </fo:table-cell>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.char_value">
              <xsl:choose>
                <xsl:when test="./com:Sex = &quot;Male&quot;">M</xsl:when>
                <xsl:when test="./com:Sex = &quot;Female&quot;">F</xsl:when>
                <xsl:otherwise>&#x00A0;</xsl:otherwise>
              </xsl:choose>
            </fo:block>
          </fo:table-cell>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.label">&#160;</fo:block>
          </fo:table-cell>
        </fo:table-row>
      </fo:table-body>
    </fo:table>

    <fo:table xsl:use-attribute-sets="request.field.inline.table">
      <fo:table-column column-width="proportional-column-width(1)" />
      <fo:table-column column-width="proportional-column-width(3)" />
      <fo:table-body>
        <fo:table-row>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.label">
              N° App ou Bal-Etg-Coul-Esc
            </fo:block>
          </fo:table-cell>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
              <xsl:if test="string(./com:Address/com:AdditionalDeliveryInformation)">
                <xsl:value-of select="./com:Address/com:AdditionalDeliveryInformation" />
              </xsl:if>
              <xsl:if test="not(string(./com:Address/com:AdditionalDeliveryInformation))">&#160;</xsl:if>
            </fo:block>
          </fo:table-cell>
        </fo:table-row>
        <fo:table-row>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.label">
              Ent-Bat-Imm-Res
            </fo:block>
          </fo:table-cell>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
              <xsl:if test="string(./com:Address/com:AdditionalGeographicalInformation)">
                <xsl:value-of select="./com:Address/com:AdditionalGeographicalInformation" />
              </xsl:if>
              <xsl:if test="not(string(./com:Address/com:AdditionalGeographicalInformation))">&#160;</xsl:if>
            </fo:block>
          </fo:table-cell>
        </fo:table-row>
        <fo:table-row>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.label">
              Adresse de l&apos;individu*
            </fo:block>
          </fo:table-cell>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
              <xsl:if test="string(./com:Address/com:StreetName)">
              	<xsl:if test="string(./com:Address/com:StreetNumber)">
                  <xsl:value-of select="./com:Address/com:StreetNumber" />
	          &#160;
		</xsl:if>
                <xsl:value-of select="./com:Address/com:StreetName" />
              </xsl:if>
              <xsl:if test="not(string(./com:Address/com:StreetName))">&#160;</xsl:if>
            </fo:block>
          </fo:table-cell>
        </fo:table-row>
      </fo:table-body>
    </fo:table>

    <fo:table xsl:use-attribute-sets="request.field.inline.table">
      <fo:table-column column-width="proportional-column-width(1)" />
      <fo:table-column column-width="proportional-column-width(3)" />
      <fo:table-body>
        <fo:table-row>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.label">
              Lieu dit / Service particulier
            </fo:block>
          </fo:table-cell>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
              <xsl:if test="string(./com:PlaceNameOrService)">
                <xsl:value-of select="./com:PlaceNameOrService" />
              </xsl:if>
              <xsl:if test="not(string(./com:PlaceNameOrService))">&#160;</xsl:if>
            </fo:block>
          </fo:table-cell>
        </fo:table-row>
      </fo:table-body>
    </fo:table>

    <fo:table xsl:use-attribute-sets="request.field.inline.table">
      <fo:table-column column-width="proportional-column-width(1)" />
      <fo:table-column column-width="proportional-column-width(1)" />
      <fo:table-column column-width="proportional-column-width(1)" />
      <fo:table-column column-width="proportional-column-width(1)" />
      <fo:table-body>
        <fo:table-row>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.label">Code postal*</fo:block>
          </fo:table-cell>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
              <xsl:if test="string(./com:Address/com:PostalCode)">
                <xsl:value-of select="./com:Address/com:PostalCode" />
              </xsl:if>
              <xsl:if test="not(string(./com:Address/com:PostalCode))">&#160;</xsl:if>
            </fo:block>
          </fo:table-cell>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.label">Commune*</fo:block>
          </fo:table-cell>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
              <xsl:if test="string(./com:Address/com:City)">
                <xsl:value-of select="./com:Address/com:City" />
              </xsl:if>
              <xsl:if test="not(string(./com:Address/com:City))">&#160;</xsl:if>
            </fo:block>
          </fo:table-cell>
        </fo:table-row>
      </fo:table-body>
    </fo:table>
  </xsl:template>

  <xsl:template name="AdultType">
    <xsl:param name="localizationService"></xsl:param>
    
    <fo:table xsl:use-attribute-sets="request.field.inline.table">
      <xsl:variable name="mod_column" select="'6'" />
      <xsl:variable name="enum_tokens">
        <xsl:call-template name="split-string">
          <xsl:with-param name="string" select="./com:Title/text()" />
        </xsl:call-template>
      </xsl:variable>

      <xsl:for-each select="locservice:getEnumsDataNode($localizationService,'http://www.cg95.fr/cvq/schema/common','TitleType','fr')//ref:data[@name = 'TitleType']/ref:entry">
        <xsl:if test="not(position() &gt; ($mod_column + 1))">
          <fo:table-column column-width="30pt" />
          <fo:table-column column-width="proportional-column-width(1) - 30pt" />
        </xsl:if>
      </xsl:for-each>

      <fo:table-body>

        <xsl:for-each select="locservice:getEnumsDataNode($localizationService,'http://www.cg95.fr/cvq/schema/common','TitleType','fr')//ref:data[@name = 'TitleType']/ref:entry">
          <xsl:if test="position() = 1">
            <xsl:text disable-output-escaping="yes">&lt;fo:table-row&gt;</xsl:text>
          </xsl:if>

          <xsl:if test="(position() != 1) and ((position() mod $mod_column) = 1)">
            <xsl:text disable-output-escaping="yes">&lt;fo:table-row&gt;</xsl:text>
          </xsl:if>

          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.checkbox.value">
              <xsl:variable name="current_value" select="@key" />
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
              <xsl:value-of select="./ref:label[@lang='fr']" />
            </fo:block>
          </fo:table-cell>
          <xsl:if test="((position() mod $mod_column) = 0) or (position() = last())">
            <xsl:text disable-output-escaping="yes">&lt;/fo:table-row&gt;</xsl:text>
            <xsl:if test="not(position() = last())">
              <xsl:text disable-output-escaping="yes">
                &lt;fo:table-row&gt;&lt;fo:table-cell&gt;&lt;fo:block&gt;&#160;&lt;/fo:block&gt;&lt;/fo:table-cell&gt;&lt;/fo:table-row&gt;
              </xsl:text>
            </xsl:if>
          </xsl:if>
        </xsl:for-each>
      </fo:table-body>
    </fo:table>

    <fo:table xsl:use-attribute-sets="request.field.inline.table">
      <xsl:variable name="mod_column" select="'6'" />
      <xsl:variable name="enum_tokens">
        <xsl:call-template name="split-string">
          <xsl:with-param name="string" select="./com:FamilyStatus/text()" />
        </xsl:call-template>
      </xsl:variable>

      <xsl:for-each select="locservice:getEnumsDataNode($localizationService,'http://www.cg95.fr/cvq/schema/common','FamilyStatusType','fr')//ref:data[@name = 'FamilyStatusType']/ref:entry">
        <xsl:if test="not(position() &gt; ($mod_column + 1))">
          <fo:table-column column-width="30pt" />
          <fo:table-column column-width="proportional-column-width(1) - 30pt" />
        </xsl:if>
      </xsl:for-each>

      <fo:table-body>

        <xsl:for-each select="locservice:getEnumsDataNode($localizationService,'http://www.cg95.fr/cvq/schema/common','FamilyStatusType','fr')//ref:data[@name = 'FamilyStatusType']/ref:entry">
          <xsl:if test="position() = 1">
            <xsl:text disable-output-escaping="yes">&lt;fo:table-row&gt;</xsl:text>
          </xsl:if>

          <xsl:if test="(position() != 1) and ((position() mod $mod_column) = 1)">
            <xsl:text disable-output-escaping="yes">&lt;fo:table-row&gt;</xsl:text>
          </xsl:if>

          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.checkbox.value">
              <xsl:variable name="current_value" select="@key" />
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
              <xsl:value-of select="./ref:label[@lang='fr']" />
            </fo:block>
          </fo:table-cell>
          <xsl:if test="((position() mod $mod_column) = 0) or (position() = last())">
            <xsl:text disable-output-escaping="yes">&lt;/fo:table-row&gt;</xsl:text>
            <xsl:if test="not(position() = last())">
              <xsl:text disable-output-escaping="yes">
                &lt;fo:table-row&gt;&lt;fo:table-cell&gt;&lt;fo:block&gt;&#160;&lt;/fo:block&gt;&lt;/fo:table-cell&gt;&lt;/fo:table-row&gt;
              </xsl:text>
            </xsl:if>
          </xsl:if>
        </xsl:for-each>
      </fo:table-body>
    </fo:table>

    <fo:table xsl:use-attribute-sets="request.field.inline.table">
      <fo:table-column column-width="proportional-column-width(1)" />
      <fo:table-column column-width="proportional-column-width(3)" />
      <fo:table-body>
        <fo:table-row>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.label">Nom*</fo:block>
          </fo:table-cell>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
              <xsl:if test="string(./com:LastName)">
                <xsl:value-of select="./com:LastName" />
              </xsl:if>
              <xsl:if test="not(string(./com:LastName))">&#160;</xsl:if>
            </fo:block>
          </fo:table-cell>
        </fo:table-row>
      </fo:table-body>
    </fo:table>

    <fo:table xsl:use-attribute-sets="request.field.inline.table">
      <fo:table-column column-width="proportional-column-width(1)" />
      <fo:table-column column-width="proportional-column-width(3)" />
      <fo:table-body>
        <fo:table-row>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.label">
              Nom de jeune fille
            </fo:block>
          </fo:table-cell>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
              <xsl:if test="string(./com:MaidenName)">
                <xsl:value-of select="./com:MaidenName" />
              </xsl:if>
              <xsl:if test="not(string(./com:MaidenName))">&#160;</xsl:if>
            </fo:block>
          </fo:table-cell>
        </fo:table-row>
      </fo:table-body>
    </fo:table>

    <fo:table xsl:use-attribute-sets="request.field.inline.table">
      <fo:table-column column-width="proportional-column-width(1)" />
      <fo:table-column column-width="proportional-column-width(3)" />
      <fo:table-body>
        <fo:table-row>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.label">
              Nom d&apos;usage
            </fo:block>
          </fo:table-cell>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
              <xsl:if test="string(./com:NameOfUse)">
                <xsl:value-of select="./com:NameOfUse" />
              </xsl:if>
              <xsl:if test="not(string(./com:NameOfUse))">&#160;</xsl:if>
            </fo:block>
          </fo:table-cell>
        </fo:table-row>
      </fo:table-body>
    </fo:table>

    <fo:table xsl:use-attribute-sets="request.field.inline.table">
      <fo:table-column column-width="proportional-column-width(1)" />
      <fo:table-column column-width="proportional-column-width(3)" />
      <fo:table-body>
        <fo:table-row>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.label">Prénom(s)*</fo:block>
          </fo:table-cell>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
              <xsl:value-of select="./com:FirstName" />
              &#160;
              <xsl:value-of select="./com:FirstName2" />
              &#160;
              <xsl:value-of select="./com:FirstName3" />
            </fo:block>
          </fo:table-cell>
        </fo:table-row>
      </fo:table-body>
    </fo:table>

    <fo:table xsl:use-attribute-sets="request.field.inline.table">
      <fo:table-column column-width="proportional-column-width(1)" />
      <fo:table-column column-width="proportional-column-width(1)" />
      <fo:table-column column-width="proportional-column-width(2)" />
      <fo:table-body>
        <fo:table-row>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.label">
              Date de naissance*
            </fo:block>
          </fo:table-cell>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
              <xsl:call-template name="com:DisplayDate">
                <xsl:with-param name="DateToDisplay">
                  <xsl:value-of select="./com:BirthDate" />
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
      <fo:table-column column-width="proportional-column-width(1)" />
      <fo:table-column column-width="proportional-column-width(3)" />
      <fo:table-body>
        <fo:table-row>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.label">
              N° App ou Bal-Etg-Coul-Esc
            </fo:block>
          </fo:table-cell>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
              <xsl:if test="string(./com:Address/com:AdditionalDeliveryInformation)">
                <xsl:value-of select="./com:Address/com:AdditionalDeliveryInformation" />
              </xsl:if>
              <xsl:if test="not(string(./com:Address/com:AdditionalDeliveryInformation))">&#160;</xsl:if>
            </fo:block>
          </fo:table-cell>
        </fo:table-row>
      </fo:table-body>
    </fo:table>
    <fo:table xsl:use-attribute-sets="request.field.inline.table">
      <fo:table-column column-width="proportional-column-width(1)" />
      <fo:table-column column-width="proportional-column-width(3)" />
      <fo:table-body>
        <fo:table-row>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.label">
              Ent-Bat-Imm-Res
            </fo:block>
          </fo:table-cell>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
              <xsl:if test="string(./com:Address/com:AdditionalGeographicalInformation)">
                <xsl:value-of select="./com:Address/com:AdditionalGeographicalInformation" />
              </xsl:if>
              <xsl:if test="not(string(./com:Address/com:AdditionalGeographicalInformation))">&#160;</xsl:if>
            </fo:block>
          </fo:table-cell>
        </fo:table-row>
      </fo:table-body>
    </fo:table>
    <fo:table xsl:use-attribute-sets="request.field.inline.table">
      <fo:table-column column-width="proportional-column-width(1)" />
      <fo:table-column column-width="proportional-column-width(3)" />
      <fo:table-body>
        <fo:table-row>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.label">Numero et libéllé de voie*</fo:block>
          </fo:table-cell>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
              <xsl:if test="string(./com:Address/com:StreetName)">
              	<xsl:if test="string(./com:Address/com:StreetNumber)">
                  <xsl:value-of select="./com:Address/com:StreetNumber" />
	          &#160;
		</xsl:if>
                <xsl:value-of select="./com:Address/com:StreetName" />
              </xsl:if>
              <xsl:if test="not(string(./com:Address/com:StreetName))">&#160;</xsl:if>
            </fo:block>
          </fo:table-cell>
        </fo:table-row>
      </fo:table-body>
    </fo:table>

    <fo:table xsl:use-attribute-sets="request.field.inline.table">
      <fo:table-column column-width="proportional-column-width(1)" />
      <fo:table-column column-width="proportional-column-width(3)" />
      <fo:table-body>
        <fo:table-row>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.label">
              Lieu dit / Service particulier
            </fo:block>
          </fo:table-cell>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
              <xsl:if test="string(./com:PlaceNameOrService)">
                <xsl:value-of select="./com:PlaceNameOrService" />
              </xsl:if>
              <xsl:if test="not(string(./com:PlaceNameOrService))">&#160;</xsl:if>
            </fo:block>
          </fo:table-cell>
        </fo:table-row>
      </fo:table-body>
    </fo:table>

    <fo:table xsl:use-attribute-sets="request.field.inline.table">
      <fo:table-column column-width="proportional-column-width(1)" />
      <fo:table-column column-width="proportional-column-width(1)" />
      <fo:table-column column-width="proportional-column-width(1)" />
      <fo:table-column column-width="proportional-column-width(1)" />
      <fo:table-body>
        <fo:table-row>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.label">Code postal*</fo:block>
          </fo:table-cell>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
              <xsl:if test="string(./com:Address/com:PostalCode)">
                <xsl:value-of select="./com:Address/com:PostalCode" />
              </xsl:if>
              <xsl:if test="not(string(./com:Address/com:PostalCode))">&#160;</xsl:if>
            </fo:block>
          </fo:table-cell>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.label">Commune*</fo:block>
          </fo:table-cell>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
              <xsl:if test="string(./com:Address/com:City)">
                <xsl:value-of select="./com:Address/com:City" />
              </xsl:if>
              <xsl:if test="not(string(./com:Address/com:City))">&#160;</xsl:if>
            </fo:block>
          </fo:table-cell>
        </fo:table-row>
      </fo:table-body>
    </fo:table>

    <fo:table xsl:use-attribute-sets="request.field.inline.table">
      <fo:table-column column-width="proportional-column-width(1)" />
      <fo:table-column column-width="proportional-column-width(3)" />
      <fo:table-body>
        <fo:table-row>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.label">Courriel</fo:block>
          </fo:table-cell>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
              <xsl:if test="string(./com:Email)">
                <xsl:value-of select="./com:Email" />
              </xsl:if>
              <xsl:if test="not(string(./com:Email))">&#160;</xsl:if>
            </fo:block>
          </fo:table-cell>
        </fo:table-row>
      </fo:table-body>
    </fo:table>

    <fo:table xsl:use-attribute-sets="request.field.inline.table">
      <fo:table-column column-width="proportional-column-width(1)" />
      <fo:table-column column-width="proportional-column-width(1)" />
      <fo:table-column column-width="proportional-column-width(1)" />
      <fo:table-column column-width="proportional-column-width(1)" />
      <fo:table-body>
        <fo:table-row>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.label">Tél. domicile</fo:block>
          </fo:table-cell>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
              <xsl:if test="string(./com:HomePhone)">
                <xsl:value-of select="./com:HomePhone" />
              </xsl:if>
              <xsl:if test="not(string(./com:HomePhone))">&#160;</xsl:if>
            </fo:block>
          </fo:table-cell>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.label">Tél. portable</fo:block>
          </fo:table-cell>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
              <xsl:if test="string(./com:MobilePhone)">
                <xsl:value-of select="./com:MobilePhone" />
              </xsl:if>
              <xsl:if test="not(string(./com:MobilePhone))">&#160;</xsl:if>
            </fo:block>
          </fo:table-cell>
        </fo:table-row>
      </fo:table-body>
    </fo:table>

    <fo:table xsl:use-attribute-sets="request.field.inline.table">
      <fo:table-column column-width="proportional-column-width(1)" />
      <fo:table-column column-width="proportional-column-width(1)" />
      <fo:table-column column-width="proportional-column-width(2)" />
      <fo:table-body>
        <fo:table-row>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.label">
              Tél. Bureau
            </fo:block>
          </fo:table-cell>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
              <xsl:if test="string(./com:OfficePhone)">
                <xsl:value-of select="./com:OfficePhone" />
              </xsl:if>
              <xsl:if test="not(string(./com:OfficePhone))">&#160;</xsl:if>
            </fo:block>
          </fo:table-cell>
          <fo:table-cell>
            <fo:block>&#160;</fo:block>
          </fo:table-cell>
        </fo:table-row>
      </fo:table-body>
    </fo:table>

  </xsl:template>

  <xsl:template name="LegalResponsibleType">
    <xsl:param name="localizationService"></xsl:param>

    <fo:table xsl:use-attribute-sets="request.field.inline.table">
      <fo:table-column column-width="proportional-column-width(2)" />
      <fo:table-column column-width="30pt" />
      <fo:table-column column-width="proportional-column-width(1) - 30pt" />
      <fo:table-column column-width="30pt" />
      <fo:table-column column-width="proportional-column-width(1) - 30pt" />
      <fo:table-column column-width="30pt" />
      <fo:table-column column-width="proportional-column-width(1) - 30pt" />
      <fo:table-column column-width="30pt" />
      <fo:table-column column-width="proportional-column-width(1) - 30pt" />
      <fo:table-column column-width="30pt" />
      <fo:table-column column-width="proportional-column-width(1) - 30pt" />
      <fo:table-body>
        <fo:table-row>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.label">Civilité*</fo:block>
          </fo:table-cell>

          <xsl:variable name="title" select="./com:LegalResponsible/com:Title" />
          <xsl:for-each select="locservice:getEnumsDataNode($localizationService,'http://www.cg95.fr/cvq/schema/common','TitleType','fr')//ref:data[@name = 'TitleType']/ref:entry">
            <fo:table-cell>
              <fo:block xsl:use-attribute-sets="request.field.checkbox.value">
                <xsl:choose>
                  <xsl:when test="$title = @key">X</xsl:when>
                  <xsl:otherwise>&#160;</xsl:otherwise>
                </xsl:choose>
              </fo:block>
            </fo:table-cell>
            <fo:table-cell>
              <fo:block xsl:use-attribute-sets="request.field.checkbox.label">
                <xsl:value-of select="./ref:label[@lang='fr']" />
              </fo:block>
            </fo:table-cell>
          </xsl:for-each>

        </fo:table-row>
      </fo:table-body>
    </fo:table>

    <fo:table xsl:use-attribute-sets="request.field.inline.table">
      <fo:table-column column-width="100pt" />
      <fo:table-column column-width="30pt" />
      <fo:table-column column-width="proportional-column-width(1) - 30pt" />
      <fo:table-column column-width="30pt" />
      <fo:table-column column-width="proportional-column-width(1) - 30pt" />
      <fo:table-column column-width="30pt" />
      <fo:table-column column-width="proportional-column-width(1) - 30pt" />
      <fo:table-body>
        <fo:table-row>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.label">Qualité*</fo:block>
          </fo:table-cell>

          <xsl:variable name="role" select="./com:Role" />
          <xsl:for-each select="locservice:getEnumsDataNode($localizationService,'http://www.cg95.fr/cvq/schema/common','LegalResponsibleRoleType','fr')//ref:data[@name = 'LegalResponsibleRoleType']/ref:entry">
            <fo:table-cell>
              <fo:block xsl:use-attribute-sets="request.field.checkbox.value">
                <xsl:choose>
                  <xsl:when test="$role = @key">X</xsl:when>
                  <xsl:otherwise>&#160;</xsl:otherwise>
                </xsl:choose>
              </fo:block>
            </fo:table-cell>
            <fo:table-cell>
              <fo:block xsl:use-attribute-sets="request.field.inline.label">
                <xsl:value-of select="./ref:label[@lang='fr']" />
              </fo:block>
            </fo:table-cell>
          </xsl:for-each>
        </fo:table-row>
      </fo:table-body>
    </fo:table>

    <fo:table xsl:use-attribute-sets="request.field.inline.table">
      <fo:table-column column-width="100pt" />
      <fo:table-column column-width="30pt" />
      <fo:table-column column-width="proportional-column-width(1) - 30pt" />
      <fo:table-column column-width="30pt" />
      <fo:table-column column-width="proportional-column-width(1) - 30pt" />
      <fo:table-column column-width="30pt" />
      <fo:table-column column-width="proportional-column-width(1) - 30pt" />
      <fo:table-column column-width="30pt" />
      <fo:table-column column-width="proportional-column-width(1) - 30pt" />
      <fo:table-column column-width="30pt" />
      <fo:table-column column-width="proportional-column-width(1) - 30pt" />
      <fo:table-column column-width="30pt" />
      <fo:table-column column-width="proportional-column-width(1) - 30pt" />
      <fo:table-body>
        <fo:table-row>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.label">
              Situation familiale*
            </fo:block>
          </fo:table-cell>

          <xsl:variable name="familyStatus" select="./com:LegalResponsible/com:FamilyStatus" />
          <xsl:for-each select="locservice:getEnumsDataNode($localizationService,'http://www.cg95.fr/cvq/schema/common','FamilyStatusType','fr')//ref:data[@name = 'FamilyStatusType']/ref:entry">
            <fo:table-cell>
              <fo:block xsl:use-attribute-sets="request.field.checkbox.value">
                <xsl:choose>
                  <xsl:when test="$familyStatus = @key">X</xsl:when>
                  <xsl:otherwise>&#160;</xsl:otherwise>
                </xsl:choose>
              </fo:block>
            </fo:table-cell>
            <fo:table-cell>
              <fo:block xsl:use-attribute-sets="request.field.checkbox.label">
                <xsl:value-of select="./ref:label[@lang='fr']" />
              </fo:block>
            </fo:table-cell>
          </xsl:for-each>
        </fo:table-row>
      </fo:table-body>
    </fo:table>

    <fo:table xsl:use-attribute-sets="request.field.inline.table">
      <fo:table-column column-width="proportional-column-width(1)" />
      <fo:table-column column-width="proportional-column-width(3)" />
      <fo:table-body>
        <fo:table-row>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.label">Nom*</fo:block>
          </fo:table-cell>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
              <xsl:if test="string(./com:LegalResponsible/com:LastName)">
                <xsl:value-of select="./com:LegalResponsible/com:LastName" />
              </xsl:if>
              <xsl:if test="not(string(./com:LegalResponsible/com:LastName))">&#160;</xsl:if>
            </fo:block>
          </fo:table-cell>
        </fo:table-row>
      </fo:table-body>
    </fo:table>

    <fo:table xsl:use-attribute-sets="request.field.inline.table">
      <fo:table-column column-width="proportional-column-width(1)" />
      <fo:table-column column-width="proportional-column-width(3)" />
      <fo:table-body>
        <fo:table-row>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.label">
              Nom de jeune fille
            </fo:block>
          </fo:table-cell>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
              <xsl:if test="string(./com:LegalResponsible/com:MaidenName)">
                <xsl:value-of select="./com:LegalResponsible/com:MaidenName" />
              </xsl:if>
              <xsl:if test="not(string(./com:LegalResponsible/com:MaidenName))">&#160;</xsl:if>
            </fo:block>
          </fo:table-cell>
        </fo:table-row>
      </fo:table-body>
    </fo:table>

    <fo:table xsl:use-attribute-sets="request.field.inline.table">
      <fo:table-column column-width="proportional-column-width(1)" />
      <fo:table-column column-width="proportional-column-width(3)" />
      <fo:table-body>
        <fo:table-row>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.label">
              Nom d&apos;uage
            </fo:block>
          </fo:table-cell>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
              <xsl:if test="string(./com:LegalResponsible/com:NameOfUse)">
                <xsl:value-of select="./com:LegalResponsible/com:NameOfUse" />
              </xsl:if>
              <xsl:if test="not(string(./com:LegalResponsible/com:NameOfUse))">&#160;</xsl:if>
            </fo:block>
          </fo:table-cell>
        </fo:table-row>
      </fo:table-body>
    </fo:table>

    <fo:table xsl:use-attribute-sets="request.field.inline.table">
      <fo:table-column column-width="proportional-column-width(1)" />
      <fo:table-column column-width="proportional-column-width(3)" />
      <fo:table-body>
        <fo:table-row>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.label">Prénom(s)*</fo:block>
          </fo:table-cell>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
              <xsl:value-of select="./com:LegalResponsible/com:FirstName" />
              &#160;
              <xsl:value-of select="./com:LegalResponsible/com:FirstName2" />
              &#160;
              <xsl:value-of select="./com:LegalResponsible/com:FirstName3" />
              &#160;
            </fo:block>
          </fo:table-cell>
        </fo:table-row>
      </fo:table-body>
    </fo:table>

    <fo:table xsl:use-attribute-sets="request.field.inline.table">
      <fo:table-column column-width="proportional-column-width(1)" />
      <fo:table-column column-width="proportional-column-width(3)" />
      <fo:table-body>
        <fo:table-row>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.label">
              N° App ou Bal-Etg-Coul-Esc
            </fo:block>
          </fo:table-cell>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
              <xsl:if test="string(./com:LegalResponsible/com:Address/com:AdditionalDeliveryInformation)">
                <xsl:value-of select="./com:LegalResponsible/com:Address/com:AdditionalDeliveryInformation" />
              </xsl:if>
              <xsl:if test="not(string(./com:LegalResponsible/com:Address/com:AdditionalDeliveryInformation))">&#160;</xsl:if>
            </fo:block>
          </fo:table-cell>
        </fo:table-row>
      </fo:table-body>
    </fo:table>
    <fo:table xsl:use-attribute-sets="request.field.inline.table">
      <fo:table-column column-width="proportional-column-width(1)" />
      <fo:table-column column-width="proportional-column-width(3)" />
      <fo:table-body>
        <fo:table-row>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.label">
              Ent-Bat-Imm-Res
            </fo:block>
          </fo:table-cell>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
              <xsl:if test="string(./com:LegalResponsible/com:Address/com:AdditionalGeographicalInformation)">
                <xsl:value-of select="./com:LegalResponsible/com:Address/com:AdditionalGeographicalInformation" />
              </xsl:if>
              <xsl:if test="not(string(./com:LegalResponsible/com:Address/com:AdditionalGeographicalInformation))">&#160;</xsl:if>
            </fo:block>
          </fo:table-cell>
        </fo:table-row>
      </fo:table-body>
    </fo:table>
    <fo:table xsl:use-attribute-sets="request.field.inline.table">
      <fo:table-column column-width="proportional-column-width(1)" />
      <fo:table-column column-width="proportional-column-width(3)" />
      <fo:table-body>
        <fo:table-row>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.label">Numero et libéllé de voie*</fo:block>
          </fo:table-cell>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
              <xsl:if test="string(./com:LegalResponsible/com:Address/com:StreetName)">
              	<xsl:if test="string(./com:LegalResponsible/com:Address/com:StreetNumber)">
                  <xsl:value-of select="./com:LegalResponsible/com:Address/com:StreetNumber" />
	          &#160;
		</xsl:if>
                <xsl:value-of select="./com:LegalResponsible/com:Address/com:StreetName" />
              </xsl:if>
              <xsl:if test="not(string(./com:LegalResponsible/com:Address/com:StreetName))">&#160;</xsl:if>
	    </fo:block>
          </fo:table-cell>
        </fo:table-row>
      </fo:table-body>
    </fo:table>

    <fo:table xsl:use-attribute-sets="request.field.inline.table">
      <fo:table-column column-width="proportional-column-width(1)" />
      <fo:table-column column-width="proportional-column-width(3)" />
      <fo:table-body>
        <fo:table-row>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.label">
              Lieu dit / Service particulier
            </fo:block>
          </fo:table-cell>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
              <xsl:if test="string(./com:PlaceNameOrService)">
                <xsl:value-of select="./com:PlaceNameOrService" />
              </xsl:if>
              <xsl:if test="not(string(./com:PlaceNameOrService))">&#160;</xsl:if>
            </fo:block>
          </fo:table-cell>
        </fo:table-row>
      </fo:table-body>
    </fo:table>

    <fo:table xsl:use-attribute-sets="request.field.inline.table">
      <fo:table-column column-width="proportional-column-width(1)" />
      <fo:table-column column-width="proportional-column-width(1)" />
      <fo:table-column column-width="proportional-column-width(1)" />
      <fo:table-column column-width="proportional-column-width(1)" />
      <fo:table-body>
        <fo:table-row>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.label">Code postal*</fo:block>
          </fo:table-cell>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
              <xsl:if test="string(./com:LegalResponsible/com:Address/com:PostalCode)">
                <xsl:value-of select="./com:LegalResponsible/com:Address/com:PostalCode" />
              </xsl:if>
              <xsl:if test="not(string(./com:LegalResponsible/com:Address/com:PostalCode))">&#160;</xsl:if>
            </fo:block>
          </fo:table-cell>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.label">Commune*</fo:block>
          </fo:table-cell>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
              <xsl:if test="string(./com:LegalResponsible/com:Address/com:City)">
                <xsl:value-of select="./com:LegalResponsible/com:Address/com:City" />
              </xsl:if>
              <xsl:if test="not(string(./com:LegalResponsible/com:Address/com:City))">&#160;</xsl:if>
            </fo:block>
          </fo:table-cell>
        </fo:table-row>
      </fo:table-body>
    </fo:table>

    <fo:table xsl:use-attribute-sets="request.field.inline.table">
      <fo:table-column column-width="proportional-column-width(1)" />
      <fo:table-column column-width="proportional-column-width(1)" />
      <fo:table-column column-width="proportional-column-width(1)" />
      <fo:table-column column-width="proportional-column-width(1)" />
      <fo:table-body>
        <fo:table-row>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.label">Tél. domicile</fo:block>
          </fo:table-cell>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
              <xsl:if test="string(./com:LegalResponsible/com:HomePhone)">
                <xsl:value-of select="./com:LegalResponsible/com:HomePhone" />
              </xsl:if>
              <xsl:if test="not(string(./com:LegalResponsible/com:HomePhone))">&#160;</xsl:if>
            </fo:block>
          </fo:table-cell>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.label">Tél. portable</fo:block>
          </fo:table-cell>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
              <xsl:if test="string(./com:LegalResponsible/com:MobilePhone)">
                <xsl:value-of select="./com:LegalResponsible/com:MobilePhone" />
              </xsl:if>
              <xsl:if test="not(string(./com:LegalResponsible/com:MobilePhone))">&#160;</xsl:if>
            </fo:block>
          </fo:table-cell>
        </fo:table-row>
      </fo:table-body>
    </fo:table>

    <fo:table xsl:use-attribute-sets="request.field.inline.table">
      <fo:table-column column-width="proportional-column-width(1)" />
      <fo:table-column column-width="proportional-column-width(1)" />
      <fo:table-column column-width="proportional-column-width(1)" />
      <fo:table-column column-width="proportional-column-width(1)" />
      <fo:table-body>
        <fo:table-row>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.label">Courriel</fo:block>
          </fo:table-cell>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
              <xsl:if test="string(./com:LegalResponsible/com:Email)">
                <xsl:value-of select="./com:LegalResponsible/com:Email" />
              </xsl:if>
              <xsl:if test="not(string(./com:LegalResponsible/com:Email))">&#160;</xsl:if>
            </fo:block>
          </fo:table-cell>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.label">Tél. bureau</fo:block>
          </fo:table-cell>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
              <xsl:if test="string(./com:LegalResponsible/com:OfficePhone)">
                <xsl:value-of select="./com:LegalResponsible/com:OfficePhone" />
              </xsl:if>
              <xsl:if test="not(string(./com:LegalResponsible/com:OfficePhone))">&#160;</xsl:if>
            </fo:block>
          </fo:table-cell>
        </fo:table-row>
      </fo:table-body>
    </fo:table>

    <fo:table xsl:use-attribute-sets="request.field.inline.table">
      <fo:table-column column-width="proportional-column-width(1)" />
      <fo:table-column column-width="proportional-column-width(1)" />
      <fo:table-column column-width="proportional-column-width(2)" />
      <fo:table-body>
        <fo:table-row>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.label">
              N&#186; Caisse Allocation Familiale
            </fo:block>
          </fo:table-cell>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
              <xsl:if test="string(./com:LegalResponsible/com:Cfbn)">
                <xsl:value-of select="./com:LegalResponsible/com:Cfbn" />
              </xsl:if>
              <xsl:if test="not(string(./com:LegalResponsible/com:Cfbn))">&#160;</xsl:if>
            </fo:block>
          </fo:table-cell>
          <fo:table-cell>
            <fo:block>&#160;</fo:block>
          </fo:table-cell>
        </fo:table-row>
      </fo:table-body>
    </fo:table>

    <fo:table xsl:use-attribute-sets="request.field.inline.table">
      <fo:table-column column-width="proportional-column-width(1)" />
      <fo:table-column column-width="proportional-column-width(3)" />
      <fo:table-body>
        <fo:table-row>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.label">Profession</fo:block>
          </fo:table-cell>
          <fo:table-cell>
            <fo:block xsl:use-attribute-sets="request.field.inline.string_value">
              <xsl:if test="string(./com:LegalResponsible/com:Profession)">
                <xsl:value-of select="./com:LegalResponsible/com:Profession" />
              </xsl:if>
              <xsl:if test="not(string(./com:LegalResponsible/com:Profession))">&#160;</xsl:if>
            </fo:block>
          </fo:table-cell>
        </fo:table-row>
      </fo:table-body>
    </fo:table>

  </xsl:template>

  <xsl:template name="LocalReferentialDataType">
    <xsl:param name="ReferentialData" />
    <xsl:param name="RequestData" />

    <fo:list-block xsl:use-attribute-sets="request.field.list.block">
      <xsl:for-each select="$ReferentialData/ref:entry">
        <xsl:variable name="current_key" select="@key" />
        <fo:list-item>
          <fo:list-item-label end-indent="label-end()">
            <xsl:choose>
              <!-- entries with sub-entries can't be checked -->
              <xsl:when test="./ref:entries">
                <fo:block xsl:use-attribute-sets="request.field.list.label_not_selectable">&#160;</fo:block>
              </xsl:when>
              <xsl:otherwise>
                <fo:block xsl:use-attribute-sets="request.field.list.label">
                  <xsl:for-each select="exslt:node-set($RequestData)/com:Name">
                    <xsl:choose>
                      <xsl:when test="text() = $current_key">
                        <xsl:if test="../com:Priority">
                          &#160;
                          <xsl:value-of select="../com:Priority/text()" />
                        </xsl:if>
                        <xsl:if test="not(../com:Priority)">&#160;X</xsl:if>
                      </xsl:when>
                      <xsl:otherwise>&#160;</xsl:otherwise>
                    </xsl:choose>
                  </xsl:for-each>
                  <xsl:if test="not(exslt:node-set($RequestData))">&#160;</xsl:if>
                </fo:block>
              </xsl:otherwise>
            </xsl:choose>
          </fo:list-item-label>
          <fo:list-item-body start-indent="body-start()">
            <fo:block xsl:use-attribute-sets="request.field.list.body.label">
              <!-- display label -->
              <xsl:value-of select="./ref:label[@lang='fr']" />
              <!-- display additional message if there's one -->
              <xsl:if test="./ref:message[@lang='fr']">
                &#160;(
                <xsl:value-of select="./ref:message[@lang='fr']" />
                )
              </xsl:if>
              <!-- display user's additional information if there's some -->
              <xsl:variable name="add_info"
                select="exslt:node-set($RequestData)/com:Name[text() = $current_key]" />
              <xsl:if test="$add_info/../com:AdditionalInformationValue != ''">
                <fo:block>
                  <xsl:if test="$add_info/../com:AdditionalInformationLabel != ''">
                    <fo:inline xsl:use-attribute-sets="request.field.list.body.label">
                      <xsl:value-of select="$add_info/../com:AdditionalInformationLabel" />
                      :
                    </fo:inline>
                  </xsl:if>
                  <fo:inline xsl:use-attribute-sets="request.field.list.body.value">
                    <xsl:value-of select="$add_info/../com:AdditionalInformationValue" />
                  </fo:inline>
                </fo:block>
              </xsl:if>
              <!-- deal with sub-entries -->
              <xsl:if test="./ref:entries">
                <xsl:call-template name="LocalReferentialDataType">
                  <xsl:with-param name="ReferentialData" select="./ref:entries" />
                  <xsl:with-param name="RequestData"
                    select="exslt:node-set($RequestData)/com:Name[text() = $current_key]/../com:Children" />
                </xsl:call-template>
              </xsl:if>
            </fo:block>
          </fo:list-item-body>
        </fo:list-item>
      </xsl:for-each>
    </fo:list-block>

  </xsl:template>

  <xsl:template name="PlaceReservationDataType">
    <xsl:param name="ReservationData" />
    <xsl:param name="RequestData" />

    <fo:list-block xsl:use-attribute-sets="request.field.places.block">
      <xsl:for-each select="$RequestData">
        <xsl:variable name="current_key" select="./com:Name" />
        <fo:list-item xsl:use-attribute-sets="request.field.places.block.item">
          <fo:list-item-label end-indent="label-end()">
            <fo:block>
              <xsl:number format="1." />
            </fo:block>
          </fo:list-item-label>
          <fo:list-item-body start-indent="body-start()">
            <fo:block>
              <xsl:value-of select="exslt:node-set($ReservationData)/ref:entry[@key = $current_key]/ref:label[@lang = 'fr']" />
              <fo:list-block xsl:use-attribute-sets="request.field.places.tickets.block">
                <xsl:for-each select="./com:TicketTypeSelection">
                  <xsl:variable name="current_ticket" select="./com:Name" />
                  <fo:list-item xsl:use-attribute-sets="request.field.places.tickets.block.item">
                    <fo:list-item-label end-indent="label-end()">
                      <fo:block>
                        <fo:inline font-family="Symbol">&#x2022;</fo:inline>
                      </fo:block>
                    </fo:list-item-label>
                    <fo:list-item-body start-indent="body-start()">
                      <fo:block>
                        <xsl:value-of select="exslt:node-set($ReservationData)/ref:entry[@key = $current_key]/ref:ticketSelection[@key = $current_ticket]/ref:label[@lang = 'fr']" />
                        &#160;:&#160;
                        <xsl:value-of select="./com:Number" />
                        &#160;place(s)&#160;&#x00E0;&#160;
                        <xsl:value-of select="exslt:node-set($ReservationData)/ref:entry[@key = $current_key]/ref:ticketSelection[@key = $current_ticket]/ref:price" />
                        euros.
                      </fo:block>
                    </fo:list-item-body>
                  </fo:list-item>
                </xsl:for-each>
              </fo:list-block>
              <xsl:variable name="Tickets" select="./com:TicketTypeSelection" />
              <xsl:variable name="Prices" select="exslt:node-set($ReservationData)/ref:entry[@key = $current_key]" />
              <xsl:variable name="SubTotalValue">
                <xsl:call-template name="SubTotal">
                  <xsl:with-param name="Tickets" select="$Tickets"/>
                  <xsl:with-param name="Prices" select="$Prices"/>
                  <xsl:with-param name="RunningTotal" select="0"/>
                </xsl:call-template>
              </xsl:variable>
              <fo:block xsl:use-attribute-sets="request.field.places.subtotal">
              => Sous Total&#160;:&#160;<xsl:value-of select="format-number($SubTotalValue, '####0.0#')" />
              &#160;euros
              </fo:block>
            </fo:block>
          </fo:list-item-body>
        </fo:list-item>
      </xsl:for-each>
    </fo:list-block>
    <fo:block xsl:use-attribute-sets="request.field.places.total">
      Soit un total de :&#160;
      <fo:inline xsl:use-attribute-sets="request.field.places.total.value">
        <xsl:variable name="Prices" select="exslt:node-set($ReservationData)" />
        <xsl:variable name="TotalValue">
          <xsl:call-template name="Total">
            <xsl:with-param name="Places" select="$RequestData" />
            <xsl:with-param name="Prices" select="$Prices" />
            <xsl:with-param name="RunningTotal" select="0" />
          </xsl:call-template>
        </xsl:variable>
        <xsl:value-of select="format-number($TotalValue, '####0.0#')" />
        &#160;euros
      </fo:inline>
    </fo:block>
  </xsl:template>

  <xsl:template name="SubTotal">
    <xsl:param name="Tickets" />
    <xsl:param name="Prices" />
    <xsl:param name="RunningTotal" />
    <xsl:choose>
      <xsl:when test="not($Tickets)">
        <xsl:copy-of select="$RunningTotal" />
      </xsl:when>
      <xsl:otherwise>
        <xsl:variable name="CurrentTotal"
          select="$RunningTotal + ($Tickets[1]/com:Number * $Prices/ref:ticketSelection[@key = $Tickets[1]/com:Name]/ref:price)" />
        <xsl:call-template name="SubTotal">
          <xsl:with-param name="Tickets" select="$Tickets[position()>1]" />
          <xsl:with-param name="Prices" select="$Prices" />
          <xsl:with-param name="RunningTotal" select="$CurrentTotal" />
        </xsl:call-template>
      </xsl:otherwise>
    </xsl:choose>
  </xsl:template>

  <xsl:template name="Total">
    <xsl:param name="Places" />
    <xsl:param name="Prices" />
    <xsl:param name="RunningTotal" />
    <xsl:choose>
      <xsl:when test="not($Places)">
        <xsl:copy-of select="$RunningTotal" />
      </xsl:when>
      <xsl:otherwise>
        <xsl:variable name="SubTotalValue">
          <xsl:call-template name="SubTotal">
            <xsl:with-param name="Tickets" select="$Places[1]/com:TicketTypeSelection" />
            <xsl:with-param name="Prices" select="$Prices/ref:entry[@key = $Places[1]/com:Name]" />
            <xsl:with-param name="RunningTotal" select="0" />
          </xsl:call-template>
        </xsl:variable>
        <xsl:variable name="CurrentTotal" select="$RunningTotal + $SubTotalValue" />
        <xsl:call-template name="Total">
          <xsl:with-param name="Places" select="$Places[position()>1]" />
          <xsl:with-param name="Prices" select="$Prices" />
          <xsl:with-param name="RunningTotal" select="$CurrentTotal" />
        </xsl:call-template>
      </xsl:otherwise>
    </xsl:choose>
  </xsl:template>

  <xsl:template name="MeansOfContactType">
    <fo:table xsl:use-attribute-sets="request.field.inline.table"> 
      <xsl:variable name="mod_column" select="'6'" />
      <xsl:for-each select="locservice:getEnumsDataNode($localizationService,'http://www.cg95.fr/cvq/schema/common','MeansOfContactEnumType','fr')//ref:data[@name = 'MeansOfContactEnumType']/ref:entry">
        <xsl:if test="not(position() &gt; ($mod_column + 1))">
          <fo:table-column column-width="30pt" />
          <fo:table-column column-width="proportional-column-width(1) - 30pt" />
        </xsl:if>
      </xsl:for-each>
      <fo:table-body>
        <fo:table-row>
          <xsl:variable name="meansOfContactType" select="com:Type" />
          <xsl:for-each select="locservice:getEnumsDataNode($localizationService,'http://www.cg95.fr/cvq/schema/common','MeansOfContactEnumType','fr')//ref:data[@name = 'MeansOfContactEnumType']/ref:entry">
	    <fo:table-cell>
              <fo:block xsl:use-attribute-sets="request.field.checkbox.value">
                <xsl:choose>
                  <xsl:when test="$meansOfContactType = @key">X</xsl:when>
                  <xsl:otherwise>&#160;</xsl:otherwise>
                </xsl:choose>
              </fo:block>
            </fo:table-cell>
            <fo:table-cell>
              <fo:block xsl:use-attribute-sets="request.field.checkbox.label">
                <xsl:value-of select="./ref:label[@lang='fr']" />
              </fo:block>
            </fo:table-cell>
          </xsl:for-each>
        </fo:table-row>
      </fo:table-body>
    </fo:table>
  </xsl:template>

</xsl:stylesheet>
