#! /bin/sh

config=$1
local_authority=$2

if [ "$config" == "deployment" ]
then
  # deployment configuration
  echo "Deployment configuration ..."
  libDirCommon="$CVQ95_HOME/utils/lib"
  CLASSPATH=$CVQ95_HOME/conf:$CVQ95_HOME/conf/spring
  CLASSPATH="$CLASSPATH:$CVQ95_HOME/conf/referential/$local_authority"
else
  # development configuration
  echo "Test configuration ..."
  libDirCommon="$CVQ95_HOME/Libraries"
  libDir="$CVQ95_HOME/Model/lib"
  archivesDir="$CVQ95_HOME/Model/build/archives"
  CLASSPATH="$CVQ95_HOME/Model/build/test/"
  for lib in $(find $archivesDir -name *.jar); do
    CLASSPATH="${CLASSPATH}:$lib"
  done
  for lib in $(find $libDir -name *.jar); do
    CLASSPATH="${CLASSPATH}:$lib"
  done
 # CLASSPATH="$CLASSPATH:$CVQ95_HOME/Model/build/admin/conf/referential/$local_authority:$CVQ95_HOME/Model/build/admin/conf/spring"
  CLASSPATH="$CLASSPATH:$CVQ95_HOME/Model/conf/spring"
fi

for lib in $(find $libDirCommon -name *.jar); do
    CLASSPATH="${CLASSPATH}:$lib"
done

#echo $CLASSPATH
export CLASSPATH
