#! /bin/sh
#
# Given a XML file and an XSLT stylesheet, launch the generation of a PDF file
#
# Examples :
#   launch_fop.sh scrr.xml schoolCanteenRegistrationRequest.xsl
#   launch_fop.sh vocr.xml voCardRequest.xsl
#
##############################################################################

XALAN_SCRIPT=~/java/fop-0.20.5/xalan.sh
#FOP_PATH=~/java/fop/trunk/trunk/fop
XML_FILE_PATH=~/cvq.svn/trunk/Model/test
XSL_FILE_PATH=~/cvq.svn/trunk/Model/conf/referential/default

# To test XSL transformations
$XALAN_SCRIPT -IN $XML_FILE_PATH/$1 -XSL $XSL_FILE_PATH/$2 -OUT output.xalan.fo

