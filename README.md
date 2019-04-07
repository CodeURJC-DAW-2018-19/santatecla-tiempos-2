# santatecla-tiempos-2

## Phase 0

### Name: Time Manager

**Team members:**

| Name | Mail | Github Username |
| ---- | ---- | --------------- |
| María Flores García | m.flores.2016@alumnos.urjc.es | mariafg11 |
| Karol Lisowski | k.lisowski@alumnos.urjc.es | KarolLisowski |
| Marcos Sánchez Hernández | m.sanchezh.2016@alumnos.urjc.es | zikram013 |
| Lucía Colás Vico | l.colas.2016@alumnos.urjc.es | lucia2cv |
| Sergio Lira Díaz | s.lira.2016@alumnos.urjc.es | AzoriusSergh4 |


---

### Trello link:
https://trello.com/b/52Tfgzru/daw

---

### Docs Google:
https://docs.google.com/document/d/1Xx1CJYwagN6zfFhv3WBdONDRmzzXSm6Uv-9EQpe4I_4/edit

---

## Phase 1

#### In fase 1 we've built the base structure for our web page, divided into 4 sections: Categories, events, time and intervals, plus a login button. Every section has been edited as indicated in requirements using HTML, CSS, Bootstrap and Dashboard. 

##### Default Page
![Screenshot](https://github.com/CodeURJC-DAW-2018-19/santatecla-tiempos-2/blob/master/Screenshots/CapturaCategorias.jpg)

##### Events Section
![Screenshot](https://github.com/CodeURJC-DAW-2018-19/santatecla-tiempos-2/blob/master/Screenshots/capturaEvento.jpg)

##### Time Section
![Screenshot](https://github.com/CodeURJC-DAW-2018-19/santatecla-tiempos-2/blob/master/Screenshots/CapturaIntervalo.jpg)

##### Interval Section
![Screenshot](https://github.com/CodeURJC-DAW-2018-19/santatecla-tiempos-2/blob/master/Screenshots/CapturaIntervalo1.jpg)

##### Log In Section
![Screenshot](https://github.com/CodeURJC-DAW-2018-19/santatecla-tiempos-2/blob/master/Screenshots/CapturaLogIn.jpg)

##### Navegation Diagram
![Screenshot](https://github.com/CodeURJC-DAW-2018-19/santatecla-tiempos-2/blob/master/Screenshots/Diagrama.PNG.png)

## Phase 2

#### In phase 2, the one created in phase 1 for the implementation of Mustache has been used as the base model so that the page goes from being static to dynamic. To achieve this, we have also used Spring and Maven frameworks based on Java, as well as the use of a database in sql language for the storage, creation and deletion of data.

##### Entity relationship diagram
![Screenshot](https://github.com/CodeURJC-DAW-2018-19/santatecla-tiempos-2/blob/master/Screenshots/EntidadRelacion.PNG)

##### Navigation Diagram
![Screenshot](https://github.com/CodeURJC-DAW-2018-19/santatecla-tiempos-2/blob/master/Screenshots/NavDiagram.png)

#### When you create any entity or modify any entity,we go back to the initial page of that entity


##### Diagram
![Screenshot](https://github.com/CodeURJC-DAW-2018-19/santatecla-tiempos-2/blob/master/Screenshots/diagrama.PNG)

##### Login
![Screenshot](https://github.com/CodeURJC-DAW-2018-19/santatecla-tiempos-2/blob/master/Screenshots/login.PNG)

##### Login Error
![Screenshot](https://github.com/CodeURJC-DAW-2018-19/santatecla-tiempos-2/blob/master/Screenshots/loginerror.PNG)

##### Error Screen
![Screenshot](https://github.com/CodeURJC-DAW-2018-19/santatecla-tiempos-2/blob/master/Screenshots/error.PNG)

##### Categories
![Screenshot](https://github.com/CodeURJC-DAW-2018-19/santatecla-tiempos-2/blob/master/Screenshots/Categorias.PNG)
![Screenshot](https://github.com/CodeURJC-DAW-2018-19/santatecla-tiempos-2/blob/master/Screenshots/AddCategory.PNG)

##### Events
![Screenshot](https://github.com/CodeURJC-DAW-2018-19/santatecla-tiempos-2/blob/master/Screenshots/Events.PNG)
![Screenshot](https://github.com/CodeURJC-DAW-2018-19/santatecla-tiempos-2/blob/master/Screenshots/searchEvent.PNG)

##### Time
![Screenshot](https://github.com/CodeURJC-DAW-2018-19/santatecla-tiempos-2/blob/master/Screenshots/Times.PNG)
![Screenshot](https://github.com/CodeURJC-DAW-2018-19/santatecla-tiempos-2/blob/master/Screenshots/EventsPerTime.PNG)
![Screenshot](https://github.com/CodeURJC-DAW-2018-19/santatecla-tiempos-2/blob/master/Screenshots/wrongTime.PNG)
![Screenshot](https://github.com/CodeURJC-DAW-2018-19/santatecla-tiempos-2/blob/master/Screenshots/addTime.PNG)
![Screenshot](https://github.com/CodeURJC-DAW-2018-19/santatecla-tiempos-2/blob/master/Screenshots/concreteTime.PNG)


##### Configuration of the development environment

Eclipse as Intellij so we will explain how to configure them for both of them. The environment configuration for Eclipse can be done in two ways:
- If you have downloaded the Eclipse STS, it already comes with the framework of Spring boot therefore we just have to create a project   in the what we say the dependencies that we want as the base of data or the devTools.
- If you have a normal Eclipse it would be enough to go to the section of market that has Eclipse and look for the FrameWork of Spring Boot, the will be installed automatically once selected and the form to create a project is in the same way as the previous one with the only difference that you will have to choose the type of project manually.

In Intellij Idea you can only program with this framework in the business version. The installation of Spring Boot is made from the beginning of the application. Once this is done, it will be enough to do a project from scratch with all the necessary dependencies.

##### How to develop the application?

To develop the application, once the project is created, we must
divide it into entities (attributes, services and repositories), security,
users and controllers. Once this is done, in certain parts
As security can be, it will ask us to import dependencies from
Maven to the pom.xml file, automatically generated from the
principle of the project, so it is important to enable the
enabled import dependencies option that appears when you add a
that is not.

For the project to connect to the database it is important that
open the application.properties file and put the credentials
of the database.
Once everything is executed and running smoothly,
we add the templates and the assets and open the page in the
browser.

## Phase 3

### Installation and configuration of Docker

To install Docker for Windows, you have to go to [this link](https://docs.docker.com/docker-for-windows/install/) to download it and follow the steps. Once you have installed it, go to your shell and type "docker --version" and "docker-compose --version" to check taht you have all installed correctly. Finally, go to the Docker icon in your taskbar, right-click on it and go to "Settings". Once you are in, go to "Daemon" section and ensure that the "Experimental features" is unchecked. 

### Execution instructions for our application

In Windows Powershell, supposing that you are on our repository ("Github\santatecla-tiempos-2"), go to the docker folder ("cd docker") and execute the "create_image-ps1" script. It will update our app jar and will copy it in the docker image. Then the only thing you have to do is execute the "docker-compose up" command, and both containers will set up and start.

### Diagram

The template diagrams have not been modified in this phase of the practice.

### UML diagram updated
![Screenshot](https://github.com/CodeURJC-DAW-2018-19/santatecla-tiempos-2/blob/master/Screenshots/Phase%203/newDiagram.PNG)

### Create 
![Screenshot](https://github.com/CodeURJC-DAW-2018-19/santatecla-tiempos-2/blob/master/Screenshots/Phase%203/CreateEvent.png)

### Show one
![Screenshot](https://github.com/CodeURJC-DAW-2018-19/santatecla-tiempos-2/blob/master/Screenshots/Phase%203/GetEvent.png)

### Show all
![Screenshot](https://github.com/CodeURJC-DAW-2018-19/santatecla-tiempos-2/blob/master/Screenshots/Phase%203/PostmanGETCategories.png)

### Update
![Screenshot](https://github.com/CodeURJC-DAW-2018-19/santatecla-tiempos-2/blob/master/Screenshots/Phase%203/Update.PNG)

### Delete
![Screenshot](https://github.com/CodeURJC-DAW-2018-19/santatecla-tiempos-2/blob/master/Screenshots/Phase%203/newdelete.PNG)

### Login error 401
![Screenshot](https://github.com/CodeURJC-DAW-2018-19/santatecla-tiempos-2/blob/master/Screenshots/Phase%203/login.PNG)

### Resource not found
![Screenshot](https://github.com/CodeURJC-DAW-2018-19/santatecla-tiempos-2/blob/master/Screenshots/Phase%203/404.PNG)
### REST API documentation
Document [Api documentation](API.md) with information about the REST API.

## Phsae 4

### Installation and configuration for SPA with Angular

First of all we have to install node.js, you have to go to [this link](https://nodejs.org/es/download/) to download it. 
One you have installed it, go to a terminal and execute the following commands: 
 1. Install the Angular CLI globally with the command:
 npm install -g angular-cli
 2. Go to the workspace folder my-app for example, with:
 cd my-app
 3. To download the modules use the command:
 npm install
 4. End using command:
 npm start
 
### Component Diagram
![Screenshot](https://github.com/CodeURJC-DAW-2018-19/santatecla-tiempos-2/blob/master/Screenshots/Phase%204/ComponentDiagram.png)
### Templates
##### Login
![Screenshot](https://github.com/CodeURJC-DAW-2018-19/santatecla-tiempos-2/blob/master/Screenshots/Phase%204/LogIn.png)
##### Login Error
![Screenshot](https://github.com/CodeURJC-DAW-2018-19/santatecla-tiempos-2/blob/master/Screenshots/Phase%204/LogInError.png)
##### Not Allow
![Screenshot](https://github.com/CodeURJC-DAW-2018-19/santatecla-tiempos-2/blob/master/Screenshots/Phase%204/NoPermisos.png)
##### Categories
![Screenshot](https://github.com/CodeURJC-DAW-2018-19/santatecla-tiempos-2/blob/master/Screenshots/Phase%204/Categories.png)
##### Add Category
![Screenshot](https://github.com/CodeURJC-DAW-2018-19/santatecla-tiempos-2/blob/master/Screenshots/Phase%204/CategoriesAdd.png)
##### Events
![Screenshot](https://github.com/CodeURJC-DAW-2018-19/santatecla-tiempos-2/blob/master/Screenshots/Phase%204/Events.png)
##### Search Event
![Screenshot](https://github.com/CodeURJC-DAW-2018-19/santatecla-tiempos-2/blob/master/Screenshots/Phase%204/EventsBusqueda.png)
##### Times
![Screenshot](https://github.com/CodeURJC-DAW-2018-19/santatecla-tiempos-2/blob/master/Screenshots/Phase%204/Times.png)
##### Interval
![Screenshot](https://github.com/CodeURJC-DAW-2018-19/santatecla-tiempos-2/blob/master/Screenshots/Phase%204/TimesConcreto.png)
##### Add Interval
![Screenshot](https://github.com/CodeURJC-DAW-2018-19/santatecla-tiempos-2/blob/master/Screenshots/Phase%204/TimesAdd.png)

