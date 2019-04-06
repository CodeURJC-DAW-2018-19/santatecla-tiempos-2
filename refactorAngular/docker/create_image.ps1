cd ../ng
docker run -it --rm --name angularInstalation -v ${PWD}:/src -w /src node:8.15.1 /bin/bash -c "npm install -g @angular/cli; npm install; npm rebuild; ng build --baseHref=/new/" 
Remove-Item '../src/main/resources/static/new/*' 
Copy-Item './dist/my-app/*' '../src/main/resources/static/new/'
Write-Output 'Instalacion de angular completada'
cd ..
docker run -it --rm --name mavenInstalation -v ${PWD}:/src -w /src maven:3.6-jdk-8 mvn clean install
Copy-Item './target/web-ng-rest-db-security-0.1.0.jar' './docker/web-ng-rest-db-security-0.1.0.jar'
Write-Output 'Instalacion y empaquetado de maven completada'
cd docker
docker build -t azoriussergh/daw .
