#!/bin/bash

# shellcheck disable=SC2034
BOARD_SIZE=${1:-"3"}
WIN_CONDITION=${2:-"3"}
STARTING_PLAYER=${3:-"O"}
LINE_TYPE=${4:-"ROW"}


mvn clean package -q -Dmaven.test.skip=true | grep -v info > stale_outputs_checked
python3 automata/generator.py $BOARD_SIZE $WIN_CONDITION $STARTING_PLAYER $LINE_TYPE
# > automata/templates/ > automata/run_auto.py