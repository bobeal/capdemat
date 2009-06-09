<ajoutPiecesJointes>
  <codeTiers>${psCodeTiers}</codeTiers>
  <codeDemande>${psCodeDemande}</codeDemande>
  <codeTiers>${psCodeTiers}</codeTiers>
  <piecesjointes>
    <moDocument>
      <msDescri xmlns:oxf="http://www.orbeon.com/oxf/processors" xmlns:delegation="http://orbeon.org/oxf/xml/delegation" xmlns:p="http://www.orbeon.com/oxf/pipeline" xmlns:saxon="http://saxon.sf.net/" xmlns:xu="http://www.xmldb.org/xupdate"/>
      <msLib xmlns:oxf="http://www.orbeon.com/oxf/processors" xmlns:delegation="http://orbeon.org/oxf/xml/delegation" xmlns:p="http://www.orbeon.com/oxf/pipeline" xmlns:saxon="http://saxon.sf.net/" xmlns:xu="http://www.xmldb.org/xupdate"/>
      <miNombre xmlns:oxf="http://www.orbeon.com/oxf/processors" xmlns:delegation="http://orbeon.org/oxf/xml/delegation" xmlns:p="http://www.orbeon.com/oxf/pipeline" xmlns:saxon="http://saxon.sf.net/" xmlns:xu="http://www.xmldb.org/xupdate"/>
      <moImage xmlns:oxf="http://www.orbeon.com/oxf/processors" xmlns:delegation="http://orbeon.org/oxf/xml/delegation" xmlns:p="http://www.orbeon.com/oxf/pipeline" xmlns:saxon="http://saxon.sf.net/" xmlns:xu="http://www.xmldb.org/xupdate">
        <msReferenceExt>${filename}</msReferenceExt>
        <!-- ne pas le renseigner, est fait à partir de la sourceImage -->
        <mtbFluxBinaire/>
        <msSourceImage>/tmp/${filename}</msSourceImage>
        <!-- ne pas renseigner msCle, est fait à partir de la sourceImage -->
      </moImage>
      <moFormat xmlns:oxf="http://www.orbeon.com/oxf/processors" xmlns:delegation="http://orbeon.org/oxf/xml/delegation" xmlns:p="http://www.orbeon.com/oxf/pipeline" xmlns:saxon="http://saxon.sf.net/" xmlns:xu="http://www.xmldb.org/xupdate">
        <msTypeMime>text/plain</msTypeMime>
      </moFormat>
      <msPieceReqDescri>${description}</msPieceReqDescri>
      <msPieceReqLib>${description}</msPieceReqLib>
      <miPieceReqNbex>1</miPieceReqNbex>
    </moDocument>
  </piecesjointes>
</ajoutPiecesJointes>