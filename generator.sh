#!/bin/bash

# shellcheck disable=SC2034
STARTING_PLAYER=${1:-"O"}
BOARD_SIZE=${2:-"3"}
WIN_CONDITION=${3:-"3"}
LINE_TYPE=${4:-"ROW"}


mvn clean package -q -Dmaven.test.skip=true | grep -v info > stale_outputs_checked
python3 automata/generator.py $STARTING_PLAYER $BOARD_SIZE $WIN_CONDITION $LINE_TYPE
# > automata/templates/ > automata/run_auto.py