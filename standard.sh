#!/bin/bash

mvn clean package -q
java -jar target/ox-?.?.jar