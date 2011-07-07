#! /bin/sh

. ./check_env.sh

for lr in $(find $CAPDEMAT_HOME/Assets -name "local_referential_*.xml"); do
  sed -i "s|schema/referential|schema/oldreferential|g" $lr
done

. ./set_classpath.sh $1 blainville

java -cp $CLASSPATH fr.cg95.cvq.util.admin.LocalReferentialTransformer

# Hack to deal with multiple runs of the migration script on a given local ref file
for lr in $(find $CAPDEMAT_HOME/Assets -name "local_referential_*.xml"); do
  sed -i "s|schema/oldreferential|schema/referential|g" $lr
done
