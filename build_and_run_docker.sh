#! /bin/sh
docker build -t avaj .
docker run --mount type=bind,source="$(pwd)",target=/app avaj
