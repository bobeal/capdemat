<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:fo="http://www.w3.org/1999/XSL/Format"
	xmlns:cert="http://www.cg95.fr/cvq/certificate"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
	<xsl:template match="/">
		<fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
			<fo:layout-master-set>
				<fo:simple-page-master page-width="21.0cm"
					page-height="29.7cm" master-name="Section1-rest"
					margin-top="0.0cm" margin-bottom="2.0cm"
					margin-left="2.0cm"
					margin-right="1.5cm">
					<fo:region-before extent="0cm" />
					<fo:region-after extent="0cm" />
					<fo:region-body margin-top="2cm"
						margin-bottom="2cm" />
				</fo:simple-page-master>
				<fo:page-sequence-master master-name="Section1-ps">
					<fo:repeatable-page-master-reference
						master-reference="Section1-rest" />
				</fo:page-sequence-master>
			</fo:layout-master-set>
			<fo:page-sequence master-reference="Section1-ps">
				<fo:static-content flow-name="xsl-region-before" />
				<fo:static-content flow-name="xsl-region-after" />
				<fo:flow flow-name="xsl-region-body">
					<fo:block-container position="absolute" top="0cm" left="0cm" height="3.0cm" width="5.5cm">
						<fo:block 
							font-size="11.0pt" font-family="serif" color="black"
							font-weight="bold" text-align="left">
							MAIRIE DE VETHEUIL
						</fo:block>
						<fo:block 
							font-size="11.0pt" font-family="serif" color="black"
							font-weight="bold" text-align="left">
							BP 1
						</fo:block>
						<fo:block 
							font-size="11.0pt" font-family="serif" color="black"
							font-weight="bold" text-align="left">
							95510 VETHEUIL
						</fo:block>
						<fo:block 
							font-size="11.0pt" font-family="serif" color="black"
							font-style="italic" text-align="left">
							Tél. 01 34 78 13 18
						</fo:block>
						<fo:block 
							font-size="11.0pt" font-family="serif" color="black"
							font-style="italic" text-align="left">
							Fax  01 34 78 14 68
						</fo:block>
					</fo:block-container>

					<fo:block-container position="absolute" top="3.5cm" left="10.0cm" height="1.0cm" width="6cm">
						<fo:block font-size="11.0pt" font-family="serif">
							Vétheuil, le
							<xsl:for-each select="//cert:date">
								<xsl:apply-templates />
							</xsl:for-each>
						</fo:block>
					</fo:block-container>

					<fo:block-container position="absolute" top="4.5cm" left="10.0cm" height="2.0cm" width="6cm">
						<fo:block font-size="11.0pt" font-family="serif">
							<xsl:for-each select="//cert:civilite">
								<xsl:apply-templates />
							</xsl:for-each>
							&#160;
							<xsl:for-each select="//cert:nom">
								<xsl:apply-templates />
							</xsl:for-each>
						</fo:block>
						<xsl:for-each select="//cert:adresse">
							<fo:block font-size="11.0pt" font-family="serif">
								<xsl:apply-templates />
							</fo:block>
						</xsl:for-each>
						<fo:block font-size="11.0pt" font-family="serif">
							<xsl:for-each select="//cert:codepostal">
								<xsl:apply-templates />
							</xsl:for-each>
							&#160;
							<xsl:for-each select="//cert:ville">
								<xsl:apply-templates />
							</xsl:for-each>
						</fo:block>
					</fo:block-container>

					<fo:block-container position="absolute" top="6.5cm" left="0cm" height="2.5cm" width="14.0cm">
						<fo:block font-size="11.0pt" font-family="serif">
							<fo:inline font-weight="bold">N/Réf</fo:inline>
							. :
							<xsl:for-each select="//cert:service">
								<xsl:apply-templates />
							</xsl:for-each>
						</fo:block>
						<fo:block font-size="11.0pt" font-family="serif">
							<fo:inline font-weight="bold">V/Réf</fo:inline>
							. : demande n°
							<xsl:for-each select="//cert:numero_demande">
								<xsl:apply-templates />
							</xsl:for-each>
						</fo:block>
						<fo:block font-size="11.0pt" font-family="serif">
							<fo:inline font-weight="bold">Objet : </fo:inline>
							<xsl:for-each select="//cert:type_demande">
								<xsl:apply-templates />
							</xsl:for-each>
						</fo:block>
						<fo:block font-size="11.0pt" font-family="serif">
							<fo:inline font-weight="bold">Envoi </fo:inline>
							:
							<xsl:for-each select="//cert:envoi">
								<xsl:apply-templates />
							</xsl:for-each>
						</fo:block>
					</fo:block-container>

					<fo:block-container position="absolute" top="10cm" left="1cm" height="15.0cm" width="16cm">
						<fo:block space-after.optimum="12.0pt"
							text-align="justify" font-size="12.0pt"	font-family="serif">
							<xsl:for-each select="//cert:civilite">
								<xsl:apply-templates />
							</xsl:for-each>,
						</fo:block>
						<fo:block space-after.optimum="12.0pt" text-align="justify" font-size="12.0pt" font-family="serif">
							Je fais suite à votre demande de 
							<xsl:for-each select="//cert:type_demande">
								<xsl:apply-templates />
							</xsl:for-each>
							du
							<xsl:for-each select="//cert:date_demande">
								<xsl:apply-templates />
							</xsl:for-each>
							pour vous informer qu'elle a été validée.
						</fo:block>
						<fo:block space-after.optimum="12.0pt" text-align="justify" font-size="12.0pt" font-family="serif">
							Pour retirer l'attestation, j'invite la personne concernée à venir en mairie avec une pièce d'identité, dans un délai de cinq jours ouvrés.	
						</fo:block>
						<fo:block text-align="justify" font-size="12.0pt" font-family="serif">
							Je vous prie d’agréer, 
							<xsl:for-each select="//cert:civilite">
								<xsl:apply-templates />
							</xsl:for-each>, l'expression de ma considération distinguée.
						</fo:block>
						<fo:block start-indent="9cm" font-size="12.0pt" space-before.optimum="2.5cm" font-family="serif">
						Dominique Herpin-Poulenat
						</fo:block>
						<fo:block start-indent="9cm" font-size="12.0pt" font-family="serif">
						Maire de Vétheuil
						</fo:block>
					</fo:block-container>
					<fo:block-container position="absolute" top="24.2cm" left="0cm" height="2.5cm" width="2.6cm">
						<fo:block>
							<fo:external-graphic height="2.43cm" width="2.57cm" src="file:eglise.gif" />
						</fo:block>
					</fo:block-container>
					<fo:block-container position="absolute" top="25.7cm" left="1cm" height="1cm" width="100%">
						<fo:block  text-align="center"
							font-size="11.0pt" font-family="serif">
							Courriel : mairiedevetheuil@orange.fr  
						</fo:block>
						<fo:block  text-align="center"
							font-size="11.0pt" font-family="serif" color="black">
							www.mairie-vetheuil.fr
						</fo:block>
					</fo:block-container>
					<fo:block-container position="absolute" top="24cm" left="15.5cm" height="2.7cm" width="1.5cm">
						<fo:block>
							<fo:external-graphic height="2.67cm"	width="1.43cm" src="file:pnr.gif" />
						</fo:block>
					</fo:block-container>

				</fo:flow>
			</fo:page-sequence>
		</fo:root>
	</xsl:template>
</xsl:stylesheet>
