cd ..
#Uncomment the line below if you don't have Maven installed
#docker run -it --rm --name webapp -v "%cd%":/src -w /src maven:3.3-jdk-8 mvn clean install
mvn package
Copy-Item './target/demo-0.0.1-SNAPSHOT.jar' './docker/demo-0.0.1-SNAPSHOT.jar'
cd docker
docker build -t azoriussergh/daw .