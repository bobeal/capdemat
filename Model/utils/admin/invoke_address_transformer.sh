#! /bin/sh

# Takes at least tow arguments
#  -> the configuration (test or deployment)
#  -> the action name
#
# Example
#    ./invoke_address_transformer.sh deployment

. check_env.sh

. set_classpath.sh $1 valdoise

#java -Dhttp.proxyHost=172.16.249.4 -Dhttp.proxyPort=8080 -cp $CLASSPATH  fr.cg95.cvq.util.admin.AddressTransformer $1 $2
java -cp $CLASSPATH  fr.cg95.cvq.util.admin.AddressTransformer $1



