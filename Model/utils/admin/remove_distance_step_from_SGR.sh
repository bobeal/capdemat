#! /bin/sh

. ./check_env.sh

. ./set_classpath.sh "$1" "$2"

java -Xms512m -Xmx2000m -cp $CLASSPATH fr.cg95.cvq.util.admin.StudyGrantDistanceStepRemover
