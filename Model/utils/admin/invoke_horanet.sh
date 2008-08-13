#! /bin/sh

# Takes at least three arguments
#  -> the configuration (test or deployment)
#  -> the local authority name to test
#  -> the action name
#
# Example
#    ./invoke_horanet.sh deployment valdoise <action_name> <param1> <param2> ...

. check_env.sh

. set_classpath.sh $1 $2

java -Dhttp.proxyHost=172.16.249.4 -Dhttp.proxyPort=8080 -cp $CLASSPATH fr.capwebct.capdemat.plugins.externalservices.horanet.service.HoranetCommandLineTester $1 $2 $3 $4 $5 $6 $7




