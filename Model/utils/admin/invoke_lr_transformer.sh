#! /bin/sh

. ./check_env.sh

for lr in $(find $CAPDEMAT_HOME/Assets -name "local_referential_*.xml"); do
  sed -i "s|schema/referential|schema/oldreferential|g" $lr
done

. ./set_classpath.sh $1 blainville

java -cp $CLASSPATH fr.cg95.cvq.util.admin.LocalReferentialTransformer
