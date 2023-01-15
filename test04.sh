#!/usr/bin/env bash

mvn  package

java \
  -cp $(pwd) \
  -javaagent:$(pwd)/target/mantyAsm.jar \
  kr.co.manty.asm.exam04.TargetApplication
