#! /bin/sh

. ./check_env.sh

. ./set_classpath.sh "$1" "$2"

if [ -n "$CAPDEMAT_I18N_PATH" ]; then
  CLASSPATH="$CLASSPATH:$CAPDEMAT_I18N_PATH"
else
  echo "Environment variable CAPDEMAT_I18N_PATH must be set !";
  exit;
fi

java -Xms512m -Xmx2000m -cp $CLASSPATH fr.cg95.cvq.util.admin.UserReferentialMigration
