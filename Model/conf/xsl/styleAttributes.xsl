<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" 
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

  <!-- style of the header table -->
  <xsl:attribute-set name="request.header.table">
    <xsl:attribute name="width">100%</xsl:attribute>
    <xsl:attribute name="space-before.optimum">1pt</xsl:attribute>
    <xsl:attribute name="space-after.optimum">2pt</xsl:attribute>
  </xsl:attribute-set>

  <!-- style for the cells of the header table -->
  <xsl:attribute-set name="request.header.table.cell">
    <xsl:attribute name="text-align">center</xsl:attribute>
    <xsl:attribute name="display-align">center</xsl:attribute>

    <xsl:attribute name="padding-start">3pt</xsl:attribute>
    <xsl:attribute name="padding-end">3pt</xsl:attribute>
    <xsl:attribute name="padding-before">3pt</xsl:attribute>
    <xsl:attribute name="padding-after">3pt</xsl:attribute>

    <xsl:attribute name="border-style">solid</xsl:attribute>
    <xsl:attribute name="border-width">1pt</xsl:attribute>
    <xsl:attribute name="border-color">black</xsl:attribute>
  </xsl:attribute-set>

  <!-- font style for the cell containing the local auth name -->
  <xsl:attribute-set name="request.header.table.cell.localAuth">
    <xsl:attribute name="font-size">14pt</xsl:attribute>
    <xsl:attribute name="font-style">italic</xsl:attribute>
    <xsl:attribute name="font-weight">bold</xsl:attribute>
  </xsl:attribute-set>

  <!-- font style for the cell containing the request name -->
  <xsl:attribute-set name="request.header.table.cell.requestName">
    <xsl:attribute name="font-size">16pt</xsl:attribute>
    <xsl:attribute name="font-weight">bold</xsl:attribute>
  </xsl:attribute-set>

  <!-- styles for the notice about required information -->
  <xsl:attribute-set name="request.header.notice">
    <xsl:attribute name="text-align">center</xsl:attribute>
    <xsl:attribute name="display-align">center</xsl:attribute>
    <xsl:attribute name="font-size">7pt</xsl:attribute>

    <xsl:attribute name="padding-top">3pt</xsl:attribute>
    <xsl:attribute name="padding-bottom">3pt</xsl:attribute>

    <xsl:attribute name="space-before.optimum">1pt</xsl:attribute>
    <xsl:attribute name="space-after.optimum">2pt</xsl:attribute>

    <xsl:attribute name="border-left">-1pt</xsl:attribute>
    <xsl:attribute name="border-right">-1pt</xsl:attribute>
    <xsl:attribute name="border-style">solid</xsl:attribute>
    <xsl:attribute name="border-width">1pt</xsl:attribute>
    <xsl:attribute name="border-color">black</xsl:attribute>
  </xsl:attribute-set>

  <!-- styles for the request specific information in header -->
  <!-- eg, request validity dates -->
  <xsl:attribute-set name="request.header.specific">
    <xsl:attribute name="font-size">10pt</xsl:attribute>
    <xsl:attribute name="font-weight">bold</xsl:attribute>
  </xsl:attribute-set>

  <!-- style for the footer area of a request -->
  <xsl:attribute-set name="request.footer">
    <xsl:attribute name="text-align">start</xsl:attribute>
    <xsl:attribute name="display-align">center</xsl:attribute>

    <xsl:attribute name="padding">3pt</xsl:attribute>
    <xsl:attribute name="margin-left">-3pt</xsl:attribute>

    <xsl:attribute name="border-style">solid</xsl:attribute>
    <xsl:attribute name="border-width">1pt</xsl:attribute>
    <xsl:attribute name="border-color">black</xsl:attribute>

    <xsl:attribute name="background-color">silver</xsl:attribute>
  </xsl:attribute-set>

  <!-- style for the labels in the footer area of a request -->
  <xsl:attribute-set name="request.footer.label">
    <xsl:attribute name="font-size">7pt</xsl:attribute>
  </xsl:attribute-set>

  <!-- style for the values in the footer area of a request -->
  <xsl:attribute-set name="request.footer.value">
    <xsl:attribute name="font-size">7pt</xsl:attribute>
    <xsl:attribute name="font-weight">bold</xsl:attribute>
  </xsl:attribute-set>

  <!-- style for the rules and regulation area of a request -->
  <xsl:attribute-set name="request.rules">
  </xsl:attribute-set>


  <!-- style for the sections headers -->
  <xsl:attribute-set name="request.section.header">
    <xsl:attribute name="text-align">start</xsl:attribute>
    <xsl:attribute name="display-align">center</xsl:attribute>

    <xsl:attribute name="background-color">silver</xsl:attribute>
    <xsl:attribute name="font-size">8pt</xsl:attribute>
    <xsl:attribute name="font-weight">bold</xsl:attribute>

    <xsl:attribute name="space-before.optimum">1pt</xsl:attribute>
    <xsl:attribute name="space-after.optimum">2pt</xsl:attribute>

    <xsl:attribute name="padding-top">3pt</xsl:attribute>
    <xsl:attribute name="padding-bottom">3pt</xsl:attribute>
    <xsl:attribute name="padding-left">3pt</xsl:attribute>
    <xsl:attribute name="margin-left">-3pt</xsl:attribute>

    <xsl:attribute name="border-style">solid</xsl:attribute>
    <xsl:attribute name="border-width">1pt</xsl:attribute>
    <xsl:attribute name="border-color">black</xsl:attribute>
    <xsl:attribute name="border-right">-1pt</xsl:attribute>
  </xsl:attribute-set>

  <!-- global style for hidden table used to display label/value entries -->
  <xsl:attribute-set name="request.field.inline.table">
    <xsl:attribute name="height">15pt</xsl:attribute>
    <xsl:attribute name="width">100%</xsl:attribute>
    <xsl:attribute name="table-layout">fixed</xsl:attribute>

    <xsl:attribute name="space-before.optimum">1pt</xsl:attribute>
    <xsl:attribute name="space-after.optimum">2pt</xsl:attribute>
  </xsl:attribute-set>

  <!-- style for fields labels displayed as question/answers -->
  <xsl:attribute-set name="request.field.inline.label">
    <xsl:attribute name="text-align">start</xsl:attribute>
    <xsl:attribute name="display-align">center</xsl:attribute>
    <xsl:attribute name="font-size">7pt</xsl:attribute>

    <xsl:attribute name="padding-left">5pt</xsl:attribute>
    <xsl:attribute name="padding-right">5pt</xsl:attribute>
    <xsl:attribute name="padding-top">3pt</xsl:attribute>
    <xsl:attribute name="padding-bottom">3pt</xsl:attribute>
    <xsl:attribute name="start-indent">5pt</xsl:attribute>
    <xsl:attribute name="end-indent">5pt</xsl:attribute>
  </xsl:attribute-set>

  <!-- style for fields values displayed as text string -->
  <xsl:attribute-set name="request.field.inline.string_value">
    <xsl:attribute name="text-align">start</xsl:attribute>
    <xsl:attribute name="display-align">center</xsl:attribute>
    <xsl:attribute name="font-size">9pt</xsl:attribute>
    <xsl:attribute name="font-weight">bold</xsl:attribute>

    <xsl:attribute name="padding-left">5pt</xsl:attribute>
    <xsl:attribute name="padding-right">5pt</xsl:attribute>
    <xsl:attribute name="padding-top">3pt</xsl:attribute>
    <xsl:attribute name="padding-bottom">3pt</xsl:attribute>
    <xsl:attribute name="start-indent">12pt</xsl:attribute>
    <xsl:attribute name="end-indent">12pt</xsl:attribute>

    <xsl:attribute name="border-style">solid</xsl:attribute>
    <xsl:attribute name="border-width">1pt</xsl:attribute>
    <xsl:attribute name="border-color">black</xsl:attribute>
  </xsl:attribute-set>

  <!-- style for fields values displayed in a checkbox -->
  <xsl:attribute-set name="request.field.inline.char_value">
    <xsl:attribute name="text-align">center</xsl:attribute>
    <xsl:attribute name="display-align">center</xsl:attribute>
    <xsl:attribute name="font-size">9pt</xsl:attribute>
    <xsl:attribute name="font-weight">bold</xsl:attribute>

    <xsl:attribute name="padding-left">5pt</xsl:attribute>
    <xsl:attribute name="padding-right">5pt</xsl:attribute>
    <xsl:attribute name="padding-top">3pt</xsl:attribute>
    <xsl:attribute name="padding-bottom">3pt</xsl:attribute>

    <xsl:attribute name="start-indent">12pt</xsl:attribute>
    <xsl:attribute name="end-indent">12pt</xsl:attribute>

    <xsl:attribute name="border-style">solid</xsl:attribute>
    <xsl:attribute name="border-width">1pt</xsl:attribute>
    <xsl:attribute name="border-color">black</xsl:attribute>
  </xsl:attribute-set>

  <!-- style for text displayed as notice/advertisement -->
  <xsl:attribute-set name="request.field.notice">
    <xsl:attribute name="text-align">start</xsl:attribute>
    <xsl:attribute name="display-align">center</xsl:attribute>
    <xsl:attribute name="font-size">8pt</xsl:attribute>
    <xsl:attribute name="font-style">italic</xsl:attribute>

    <xsl:attribute name="padding-left">5pt</xsl:attribute>
    <xsl:attribute name="padding-right">5pt</xsl:attribute>
    <xsl:attribute name="padding-top">3pt</xsl:attribute>
    <xsl:attribute name="padding-bottom">3pt</xsl:attribute>
    <xsl:attribute name="start-indent">5pt</xsl:attribute>
    <xsl:attribute name="end-indent">5pt</xsl:attribute>
  </xsl:attribute-set>

  <!-- style for fields labels displayed along with checkboxes -->
  <xsl:attribute-set name="request.field.checkbox.label">
    <xsl:attribute name="text-align">start</xsl:attribute>
    <xsl:attribute name="display-align">center</xsl:attribute>
    <xsl:attribute name="font-size">7pt</xsl:attribute>

    <xsl:attribute name="padding-left">5pt</xsl:attribute>
    <xsl:attribute name="padding-right">5pt</xsl:attribute>
    <xsl:attribute name="padding-top">3pt</xsl:attribute>
    <xsl:attribute name="padding-bottom">3pt</xsl:attribute>
    <!--
    <xsl:attribute name="start-indent">5pt</xsl:attribute>
    -->
    <xsl:attribute name="end-indent">5pt</xsl:attribute>
  </xsl:attribute-set>

  <!-- style for fields values displayed in a checkbox -->
  <xsl:attribute-set name="request.field.checkbox.value">
    <xsl:attribute name="text-align">center</xsl:attribute>
    <xsl:attribute name="display-align">center</xsl:attribute>
    <xsl:attribute name="font-size">9pt</xsl:attribute>
    <xsl:attribute name="font-weight">bold</xsl:attribute>

    <xsl:attribute name="padding-left">5pt</xsl:attribute>
    <xsl:attribute name="padding-right">5pt</xsl:attribute>
    <xsl:attribute name="padding-top">3pt</xsl:attribute>
    <xsl:attribute name="padding-bottom">3pt</xsl:attribute>

    <xsl:attribute name="start-indent">12pt</xsl:attribute>
    <xsl:attribute name="end-indent">12pt</xsl:attribute>

    <xsl:attribute name="border-style">solid</xsl:attribute>
    <xsl:attribute name="border-width">1pt</xsl:attribute>
    <xsl:attribute name="border-color">black</xsl:attribute>
  </xsl:attribute-set>

  <!-- style for tables -->
  <xsl:attribute-set name="request.field.table">
    <xsl:attribute name="width">100%</xsl:attribute>
    <xsl:attribute name="table-layout">fixed</xsl:attribute>

    <xsl:attribute name="space-before.optimum">1pt</xsl:attribute>
    <xsl:attribute name="space-after.optimum">2pt</xsl:attribute>
  </xsl:attribute-set>

  <!-- style for tables cells -->
  <xsl:attribute-set name="request.field.table.cell">
    <xsl:attribute name="border-style">solid</xsl:attribute>
    <xsl:attribute name="border-width">1pt</xsl:attribute>
    <xsl:attribute name="border-color">black</xsl:attribute>
  </xsl:attribute-set>

  <!-- style for fields labels displayed in tables -->
  <xsl:attribute-set name="request.field.table.label">
    <xsl:attribute name="text-align">center</xsl:attribute>
    <xsl:attribute name="display-align">center</xsl:attribute>
    <xsl:attribute name="font-size">7pt</xsl:attribute>

    <xsl:attribute name="padding">3pt</xsl:attribute>
  </xsl:attribute-set>

  <!-- style for fields values displayed as text string inside cell rows -->
  <xsl:attribute-set name="request.field.table.value">
    <xsl:attribute name="text-align">center</xsl:attribute>
    <xsl:attribute name="display-align">center</xsl:attribute>
    <xsl:attribute name="font-size">9pt</xsl:attribute>
    <xsl:attribute name="font-weight">bold</xsl:attribute>

    <xsl:attribute name="padding-top">2pt</xsl:attribute>
    <xsl:attribute name="padding-bottom">2pt</xsl:attribute>
  </xsl:attribute-set>

  <!-- style for fields labels displayed as question/answers -->
  <xsl:attribute-set name="request.field.yesno.label">
    <xsl:attribute name="text-align">end</xsl:attribute>
    <xsl:attribute name="display-align">center</xsl:attribute>
    <xsl:attribute name="font-size">7pt</xsl:attribute>

    <xsl:attribute name="padding-left">5pt</xsl:attribute>
    <xsl:attribute name="padding-right">5pt</xsl:attribute>
    <xsl:attribute name="padding-top">3pt</xsl:attribute>
    <xsl:attribute name="padding-bottom">3pt</xsl:attribute>
    <xsl:attribute name="start-indent">5pt</xsl:attribute>
    <xsl:attribute name="end-indent">5pt</xsl:attribute>
  </xsl:attribute-set>

  <!-- style for fields values displayed in a checkbox -->
  <xsl:attribute-set name="request.field.yesno.value">
    <xsl:attribute name="text-align">center</xsl:attribute>
    <xsl:attribute name="display-align">center</xsl:attribute>
    <xsl:attribute name="font-size">9pt</xsl:attribute>
    <xsl:attribute name="font-weight">bold</xsl:attribute>

    <xsl:attribute name="padding-left">5pt</xsl:attribute>
    <xsl:attribute name="padding-right">5pt</xsl:attribute>
    <xsl:attribute name="padding-top">3pt</xsl:attribute>
    <xsl:attribute name="padding-bottom">3pt</xsl:attribute>
    <xsl:attribute name="start-indent">12pt</xsl:attribute>
    <xsl:attribute name="end-indent">12pt</xsl:attribute>

    <xsl:attribute name="border-style">solid</xsl:attribute>
    <xsl:attribute name="border-width">1pt</xsl:attribute>
    <xsl:attribute name="border-color">black</xsl:attribute>
  </xsl:attribute-set>

  <!-- style for fields values displayed as referential data list -->
  <xsl:attribute-set name="request.field.list.block">
    <xsl:attribute name="start-indent">from-parent(start-indent) + 0.25in</xsl:attribute>
    <xsl:attribute name="provisional-distance-between-starts">10mm</xsl:attribute>
    <xsl:attribute name="provisional-label-separation">5mm</xsl:attribute>

    <xsl:attribute name="font-size">7pt</xsl:attribute>
  </xsl:attribute-set>

  <xsl:attribute-set name="request.field.list.label">
    <xsl:attribute name="space-before">2pt</xsl:attribute>
    <xsl:attribute name="space-after">2pt</xsl:attribute>

    <xsl:attribute name="border-style">solid</xsl:attribute>
    <xsl:attribute name="border-width">1pt</xsl:attribute>
    <xsl:attribute name="border-color">black</xsl:attribute>
  </xsl:attribute-set>

  <xsl:attribute-set name="request.field.list.label_not_selectable">
    <xsl:attribute name="space-before">2pt</xsl:attribute>
    <xsl:attribute name="space-after">2pt</xsl:attribute>

    <xsl:attribute name="border-style">solid</xsl:attribute>
    <xsl:attribute name="border-width">1pt</xsl:attribute>
    <xsl:attribute name="border-color">black</xsl:attribute>
    <xsl:attribute name="background-color">silver</xsl:attribute>
  </xsl:attribute-set>

  <xsl:attribute-set name="request.field.list.body.label">
    <xsl:attribute name="font-size">7pt</xsl:attribute>
  </xsl:attribute-set>

  <xsl:attribute-set name="request.field.list.body.value">
    <xsl:attribute name="font-size">9pt</xsl:attribute>
    <xsl:attribute name="font-weight">bold</xsl:attribute>
  </xsl:attribute-set>

  <!-- style for fields values displayed as place reservation data list -->
  <xsl:attribute-set name="request.field.places.block">
    <xsl:attribute name="provisional-distance-between-starts">3mm</xsl:attribute>
    <xsl:attribute name="provisional-label-separation">1mm</xsl:attribute>

    <xsl:attribute name="font-size">7pt</xsl:attribute>
    <xsl:attribute name="font-weight">bold</xsl:attribute>
  </xsl:attribute-set>

  <xsl:attribute-set name="request.field.places.block.item">
    <xsl:attribute name="space-after.optimum">4pt</xsl:attribute>
    <xsl:attribute name="space-after.minimum">4pt</xsl:attribute>
  </xsl:attribute-set>

  <xsl:attribute-set name="request.field.places.tickets.block">
    <xsl:attribute name="start-indent">from-parent(start-indent) + 0.25in</xsl:attribute>
    <xsl:attribute name="provisional-distance-between-starts">3mm</xsl:attribute>
    <xsl:attribute name="provisional-label-separation">1mm</xsl:attribute>

    <xsl:attribute name="font-weight">normal</xsl:attribute>
  </xsl:attribute-set>

  <xsl:attribute-set name="request.field.places.tickets.block.item">
  </xsl:attribute-set>

  <xsl:attribute-set name="request.field.places.subtotal">
    <xsl:attribute name="space-before.optimum">2pt</xsl:attribute>
    <xsl:attribute name="space-before.minimum">2pt</xsl:attribute>

    <xsl:attribute name="font-weight">bold</xsl:attribute>
  </xsl:attribute-set>
  
  <xsl:attribute-set name="request.field.places.total">
    <xsl:attribute name="font-size">9pt</xsl:attribute>
    <xsl:attribute name="font-weight">bold</xsl:attribute>

    <xsl:attribute name="space-before.optimum">6pt</xsl:attribute>
    <xsl:attribute name="space-before.minimum">2pt</xsl:attribute>
  </xsl:attribute-set>
  
  <xsl:attribute-set name="request.field.places.total.value">
    <xsl:attribute name="text-decoration">underline</xsl:attribute>
  </xsl:attribute-set>
  
  <!-- style for acceptance and permissions areas -->
  <xsl:attribute-set name="request.signature">
    <xsl:attribute name="text-align">start</xsl:attribute>
    <xsl:attribute name="font-size">7pt</xsl:attribute>

    <xsl:attribute name="padding-top">2pt</xsl:attribute>
    <xsl:attribute name="padding-bottom">2pt</xsl:attribute>
    <xsl:attribute name="padding-before">1pt</xsl:attribute>
    <xsl:attribute name="margin-left">-3pt</xsl:attribute>

    <xsl:attribute name="border-style">solid</xsl:attribute>
    <xsl:attribute name="border-width">1pt</xsl:attribute>
    <xsl:attribute name="border-color">black</xsl:attribute>
  </xsl:attribute-set>

</xsl:stylesheet>

