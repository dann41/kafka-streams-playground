#!/bin/bash

kafkacat -b localhost:9092 -t vehicle -P -K_ < kafka/vehicle.txt
kafkacat -b localhost:9092 -t vehicle_price -P -K_ < kafka/vehicle-price.txt
kafkacat -b localhost:9092 -t vehicle_photo -P -K_ < kafka/vehicle-url.txt
