#! /bin/sh

. ./check_env.sh

. ./set_classpath.sh "$1" "$2"

java -cp $CLASSPATH fr.cg95.cvq.util.admin.FrenchRIBToIBAN "$3"
