FROM java:7-jdk

RUN mkdir /app
WORKDIR /app
COPY . .
RUN chmod +x compil.sh
RUN ./compil.sh
CMD ["java", "src.Main"]

# docker build -t avaj .
# docker run avaj
