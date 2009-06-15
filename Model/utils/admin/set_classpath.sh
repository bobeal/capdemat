#!/bin/sh

config=$1
local_authority=$2

if [ "$config" = "deployment" ]; then
  # deployment configuration
  echo "Deployment configuration ..."
  CommonLibPath="$CAPDEMAT_LIB_PATH"
  CLASSPATH=$CAPDEMAT_HOME/conf:$CAPDEMAT_HOME/conf/spring
  CLASSPATH="$CLASSPATH:$CAPDEMAT_HOME/conf/referential/$local_authority"
else
  # development configuration
  echo "Test configuration ..."
  CommonLibPath="$CAPDEMAT_HOME/Libraries"
  libDir="$CAPDEMAT_HOME/Model/lib"
  archivesDir="$CAPDEMAT_HOME/Model/build/archives"
  CLASSPATH="$CAPDEMAT_HOME/Model/build/test/"
  for lib in $(find $archivesDir -name *.jar); do
    CLASSPATH="${CLASSPATH}:$lib"
  done
  CLASSPATH="$CLASSPATH:$CAPDEMAT_HOME/Model/conf/spring"
    for lib in $(find $libD  -name *.jar); do
      CLASSPATH="${CLASSPATH}:$lib"
    done
fi

for dir in $(echo $CommonLibPath | sed 's/:/ /g'); do
  for lib in $(find $dir -name *.jar); do
    CLASSPATH="${CLASSPATH}:$lib"
  done
done

export CLASSPATH
