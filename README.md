# kafka streams playground

## Context

Given 3 different topics:

- vehicle topic: containing vehicle information

```
{"id": "fd19abb0-10c9-4341-8c29-27cc738e2a97", "licensePlate": "1111-XXX", "createdAt": "2021-12-21T00:00:00Z", "odometer": 12345}
```

- vehicle-price: containing price for a vehicle

```
{"id": "fd19abb0-10c9-4341-8c29-27cc738e2a97", "price": "25400", "createdAt": "2021-12-21T00:00:00Z"}
```

- vehicle-photo: containing the url of the vehicle

```
{"id": "fd19abb0-10c9-4341-8c29-27cc738e2a97", "photoUrl": "some-image.jpg", "order": "1"}
```

The goal is to have a Kafka Stream topology that allows generating only valid FullVehicle objects according to the following invariants:
- A vehicle always have a price
- A vehicle have at least 2 photos

## How to run the application
1. Start Kafka and Zookeeper via docker compose: `docker-compose up -d`
2. Run the application `./gradlew run`
3. See the output
4. Use Ctrl + C to abort application execution
5. Stop docker containers by executing `docker-compose down`

## How to feed kafka topics

You can run `kafka-feeder.sh` to create some sample messages into the topics
