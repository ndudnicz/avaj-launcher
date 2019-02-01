FROM java:7-jdk

RUN mkdir /app
WORKDIR /app
# CMD ["./compil_and_run.sh"]

# docker build -t avaj .
# docker run --mount type=bind,source="$(pwd)",target=/app avaj
