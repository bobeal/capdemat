<rechercheTiers>
  <nom>${lastName.encodeAsXML()}</nom>
  <infoRIB>
    <type>RIB</type>
    <numero>${bankCode.encodeAsXML()} ${counterCode.encodeAsXML()} ${accountNumber.encodeAsXML()} ${accountKey.encodeAsXML()}</numero>
  </infoRIB>
</rechercheTiers>