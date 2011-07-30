#! /bin/sh

. ./check_env.sh

CAPDEMAT_ASSETS=$2

for lr in $(find $CAPDEMAT_ASSETS -name "local_referential_*.xml"); do
  sed -i "s|schema/referential|schema/oldreferential|g" $lr
done

. ./set_classpath.sh $1 blainville

CLASSPATH="$CLASSPATH:./CapDemat-OldLocalReferentialSchemas-4.3.jar"

java -cp $CLASSPATH fr.cg95.cvq.util.admin.LocalReferentialTransformer

# Hack to deal with multiple runs of the migration script on a given local ref file
for lr in $(find $CAPDEMAT_ASSETS -name "local_referential_*.xml"); do
  sed -i "s|schema/oldreferential|schema/referential|g" $lr
done
