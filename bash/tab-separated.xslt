<?xml version="1.0" encoding="UTF-8"?>
<!--
     Format the output of vat-details as tab-separated values.
     This can be used for pasting into a spreadsheet.
-->

<xsl:stylesheet version="1.0"
  xmlns:m="http://gr/gsis/rgwspublic/RgWsPublic.wsdl"
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:output method="text" omit-xml-declaration="yes" />

  <xsl:template match="m:rgWsPublicAfmMethodResponse">
    <xsl:apply-templates mode="name"/>
    <xsl:apply-templates mode="profession"/>
    <xsl:apply-templates mode="rest"/>
  </xsl:template>

  <!-- Name -->
  <xsl:template match="RgWsPublicBasicRt_out" mode="profession" />
  <xsl:template match="RgWsPublicBasicRt_out" mode="name">
    <xsl:value-of select="m:onomasia"/>
    <!-- tab -->
    <xsl:text>&#x9;</xsl:text>
  </xsl:template>

  <xsl:template match="m:RgWsPublicFirmActRtUser" mode="name" />
  <xsl:template match="m:RgWsPublicFirmActRtUser" mode="rest" />
  <xsl:template match="m:RgWsPublicFirmActRtUser" mode="profession">
    <xsl:if test="m:firmActKind[text()='1']">
      <xsl:value-of select="m:firmActDescr"/>
    </xsl:if>
  </xsl:template>

  <!-- More details -->
  <xsl:template match="RgWsPublicBasicRt_out" mode="rest" >
    <xsl:text>&#x9;</xsl:text>
    <xsl:text>&#x9;</xsl:text>
    <xsl:value-of select="m:afm"/>

    <xsl:text>&#x9;</xsl:text>
    <xsl:value-of select="m:doyDescr"/>

    <xsl:text>&#x9;</xsl:text>
    <xsl:value-of select="m:postalAddress"/>
    <xsl:text> </xsl:text>
    <xsl:value-of select="m:postalAddressNo"/>

    <xsl:text>&#x9;</xsl:text>
    <xsl:text>&#x9;</xsl:text>
    <xsl:value-of select="m:postalZipCode"/>
    <xsl:text> </xsl:text>
    <xsl:value-of select="m:postalAreaDescription"/>
    <xsl:text>&#xa;</xsl:text>

  </xsl:template>

  <!-- Ignore -->
  <xsl:template match="pCallSeqId_out" mode="name" />
  <xsl:template match="pCallSeqId_out" mode="profession" />
  <xsl:template match="pCallSeqId_out" mode="rest" />

</xsl:stylesheet>
