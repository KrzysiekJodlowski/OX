#!/bin/bash

mvn clean package -q -Dmaven.test.skip=true | grep -v info > stale_outputs_checked
java -jar target/ox-?.?.jar