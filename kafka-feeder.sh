#!/bin/bash

kafkacat -b localhost:9092 -t vehicle -P < kafka/vehicle.txt
kafkacat -b localhost:9092 -t vehicle-price -P < kafka/vehicle-price.txt
kafkacat -b localhost:9092 -t vehicle-photo -P < kafka/vehicle-url.txt