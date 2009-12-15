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
					margin-top="0.0cm" margin-bottom="0cm"
					margin-left="0cm"
					margin-right="0cm">
					<fo:region-before extent="0cm" />
					<fo:region-after extent="0cm" />
					<fo:region-body margin-top="0cm"
						margin-bottom="0cm" />
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
					<fo:block-container position="absolute" top="0.25cm" left="1.25cm" height="4cm" width="6.5cm">
						<fo:block >
							<fo:external-graphic height="3.86cm"
								width="6.03cm"
								src="file:xslheader.jpg" />
						</fo:block>
					</fo:block-container>

					<fo:block-container position="absolute" top="4.5cm" left="11.45cm" height="2.0cm" width="8cm">
						<fo:block font-size="11.0pt" font-family="serif">
							<xsl:for-each select="//cert:civilite">
								<xsl:apply-templates />
							</xsl:for-each>&#160;
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
							</xsl:for-each>&#160;
							<xsl:for-each select="//cert:ville">
								<xsl:apply-templates />
							</xsl:for-each>
						</fo:block>
					</fo:block-container>

					<fo:block-container position="absolute" top="7.6cm" left="11.45cm" height="1.0cm" width="8cm">
						<fo:block font-size="11.0pt" font-family="serif">
							Saint-Leu-la-Forêt, le
							<xsl:for-each select="//cert:date">
								<xsl:apply-templates />
							</xsl:for-each>
						</fo:block>
					</fo:block-container>

					<fo:block-container position="absolute" top="7.6cm" left="1.87cm" height="4.5cm" width="14.0cm">
						<fo:block font-size="11.0pt" font-weight="bold" font-family="serif">
							<fo:inline>Direction de l'éducation et de la jeunesse</fo:inline>
							</fo:block>
						<fo:block font-size="11.0pt" font-weight="bold" font-family="serif">
							<fo:inline>Pôle : </fo:inline>
							<xsl:for-each select="//cert:service">
								<xsl:apply-templates />
							</xsl:for-each>
						</fo:block>
						<fo:block font-size="11.0pt" font-family="serif" >
							<fo:inline font-weight="bold">Téléservice</fo:inline>
							 : 
							<xsl:for-each select="//cert:type_demande">
								<xsl:apply-templates />
							</xsl:for-each>
						</fo:block>
						<fo:block font-size="11.0pt" font-family="serif">
							Numéro de la demande : 
							<xsl:for-each select="//cert:numero_demande">
								<xsl:apply-templates />
							</xsl:for-each>
						</fo:block>
						<fo:block font-size="11.0pt" font-family="serif" font-weight="bold" >
							Dossier suivi par
							<xsl:for-each select="//cert:agent">
								<xsl:apply-templates />
							</xsl:for-each>
						</fo:block>
					</fo:block-container>

					<fo:block-container position="absolute" top="12cm" left="3.12cm" height="15.0cm" width="15.0cm">
						<fo:block space-after.optimum="12.0pt"
							text-align="justify" font-size="12.0pt"	font-family="serif">
							<xsl:for-each select="//cert:civilite">
								<xsl:apply-templates />
							</xsl:for-each>,
						</fo:block>
						<fo:block space-after.optimum="12.0pt" text-align="justify" font-size="12.0pt" font-family="serif">
							Je fais suite à votre demande d'<xsl:for-each select="//cert:type_demande">								<xsl:apply-templates />
							</xsl:for-each>
							de l'enfant, 
							<xsl:for-each select="//cert:enfant">
								<xsl:apply-templates />
							</xsl:for-each>,
							en date du
							<xsl:for-each select="//cert:date_demande">
								<xsl:apply-templates />
							</xsl:for-each>, 
							pour vous informer qu'elle a été validée.
						</fo:block>
						<fo:block space-after.optimum="12.0pt" text-align="justify" font-size="12.0pt" font-family="serif">
							Cette inscription est valable pour toute l'année scolaire.
						</fo:block>
						<fo:block space-after.optimum="12.0pt" text-align="justify" font-size="12.0pt" font-family="serif">
							Afin de prévoir le personnel d'encadrement nécessaire, toute annulation doit être signalée le plus rapidement possible en mairie en appelant au 01 30 40 22 00. A défaut, le repas commandé vous sera facturé sauf sur production d'un certificat médical.
						</fo:block>
						<fo:block text-align="justify" font-size="12.0pt" font-family="serif">
							Je vous prie d’agréer, 
							<xsl:for-each select="//cert:civilite">
								<xsl:apply-templates />
							</xsl:for-each>, l'expression de ma considération distinguée.
						</fo:block>
						<fo:block start-indent="7.5cm" font-size="12.0pt" space-before.optimum="2.5cm"	text-align="centre" font-family="serif">
						Pour le Maire
						</fo:block>
					</fo:block-container>

					<fo:block-container position="absolute" top="27.7cm" left="2.5cm" height="2.0cm" width="16cm">
						<fo:block>
							<fo:external-graphic height="1.15cm"
								width="15.99cm"
								src="file:xslpied.jpg" />
						</fo:block>
					</fo:block-container>

				</fo:flow>
			</fo:page-sequence>
		</fo:root>
	</xsl:template>
</xsl:stylesheet>