#!/bin/sh

SAXON9_JAR=saxon9he.jar

for i in $(find . -type f -name "*.xsd")
    do
        echo "converting $i"
	java -jar $SAXON9_JAR  -t -s:$i -xsl:xsd2wsdl.xslt -o:wsdl/$(basename $i .xsd).wsdl
    done


