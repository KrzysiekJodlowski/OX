#!/bin/bash

mvn clean package -q -Dmaven.test.skip=true | grep -v info > stale_outputs_checked
python3 automata/run_auto.py