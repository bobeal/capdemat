#!/bin/sh

if [ -n "$CAPDEMAT_HOME" ]; then
    echo "CAPDEMAT_HOME is $CAPDEMAT_HOME";
else
    echo "Environment variable CAPDEMAT_HOME must be set !";
fi

if [ "$1" = "deployment" ]; then
  if [ -n "$CAPDEMAT_LIB_PATH" ]; then
      echo "CAPDEMAT_LIB_PATH is $CAPDEMAT_LIB_PATH";
  else
      echo "Environment variable CAPDEMAT_LIB_PATH must be set !";
  fi
fi

if [ -z "$CAPDEMAT_HOME" ]; then
  exit;
fi
if [ "$1" = "deployment" -a -z "$CAPDEMAT_LIB_PATH" ]; then
  exit;
fi
