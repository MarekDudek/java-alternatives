#!/bin/bash

set -euo pipefail
{
  IFS=$'\n\t'
} &>/dev/null

java -jar ./target/java-alternatives-*.jar "$@"
