#! /bin/sh
#
# Takes one argument
#  -> the password to SHA-encode
#
# Example :
#    ./invoke_password_generator.sh pwd

. check_env.sh

. set_classpath.sh $1

java -cp $CLASSPATH fr.cg95.cvq.util.LdapPasswordGenerator $1





