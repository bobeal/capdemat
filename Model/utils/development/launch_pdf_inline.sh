#! /bin/sh
#
#saxon ~/cvq.svn/trunk/Model/test/scrr.xml ~/cvq.svn/trunk/Model/conf/referential/default/schoolCanteenRegistrationRequest.xsl &> output.saxon.fo
#saxon ~/cvq.svn/trunk/Model/test/vocr.xml ~/cvq.svn/trunk/Model/conf/referential/default/voCardRequest.xsl &> output.saxon.fo
#saxon ~/cvq.svn/trunk/Model/test/parr.xml ~/cvq.svn/trunk/Model/conf/referential/default/perischoolActivityRegistrationRequest.xsl &> output.saxon.fo
#saxon ~/cvq.svn/trunk/Model/test/srr.xml ~/cvq.svn/trunk/Model/conf/referential/default/schoolRegistrationRequest.xsl &> output.saxon.fo
#saxon ~/cvq.svn/trunk/Model/test/pdr.xml ~/cvq.svn/trunk/Model/conf/referential/default/personalDetailsRequest.xsl &> output.saxon.fo
#saxon ~/cvq.svn/trunk/Model/test/errr.xml ~/cvq.svn/trunk/Model/conf/referential/default/electoralRollRegistrationRequest.xsl &> output.saxon.fo
#saxon ~/cvq.svn/trunk/Model/test/lrr.xml ~/cvq.svn/trunk/Model/conf/referential/default/libraryRegistrationRequest.xsl &> output.saxon.fo
saxon ~/cvq.svn/trunk/Model/test/msrr.xml ~/cvq.svn/trunk/Model/conf/referential/default/musicSchoolRegistrationRequest.xsl &> output.saxon.fo
~/java/fop-0.20.5/fop.sh output.saxon.fo output.pdf
evince output.pdf &

