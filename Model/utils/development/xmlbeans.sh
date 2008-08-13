#! /bin/sh
#

XMLBEANS_HOME=/home/borihuela/java/xmlbeans/xmlbeans-2.1.0/bin

action=$1

if [ "$action" == "jar" ]
# create a jar out of an XSD schema (validating it in the process)
# $2 is jar name
# $3 is XSD file name
then
    $XMLBEANS_HOME/scomp -out $2 $3
elif [ "$action" == "xml" ]
# get an XML instance of an XML Schema
# $2 is XSD file name
# $3 is name of element we want an XML instance of
then
    $XMLBEANS_HOME/xsd2inst $2 -name $3
elif [ "$action" == "validate" ]
# validate an XML instance
# $2 is XSD file name
# $3 is XML file name
then
    $XMLBEANS_HOME/validate $2 $3
else
    echo "Usage :"
    echo "  Générer un jar : xmlbeans.sh jar <jar_filemane> <xsd_filename>"
    echo "  Générer une instance XML : xmlbeans.sh xml <xsd_filename> <element_name>"
    echo "  Valider une instance XML : xmlbeans.sh validate <xsd_filename> <xml_filename>"
fi
