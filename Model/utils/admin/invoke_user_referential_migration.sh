#! /bin/sh

. ./check_env.sh

. ./set_classpath.sh "$1" "$2"

CLASSPATH="$CLASSPATH:$CAPDEMAT_HOME/BackOfficeNG/grails-app/i18n"

java -Xms512m -Xmx512m -cp $CLASSPATH  fr.cg95.cvq.util.admin.UserReferentialMigration
