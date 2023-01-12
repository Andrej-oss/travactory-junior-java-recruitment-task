# TRAVACTORY JUNIOR JAVA DEV TASK
Hello and welcome to the Travactory junior java developer recrutation task. Your goal is to finish the implementation of an application which returns information about bookings made in the system. Please read the document below, to know how to start the application, how to develop it, and finally what needs to be done.

Your solution will be graded by people, not by some automatic mechanism. So it's more about you showing us what you know and how you think, than developing everything correctly. So even if you don't know how to achieve something, or something doesn't work, don't worry! Write at least something, which shows what you want to do, even if it doesn't work perfectly. Write comments, if you like. It's also ok, if you don't finish all the tasks, so don't worry about it. It's better to implement 50% of the tasks correctly than 100%, but wrong.  

## Application description
- the application is a spring-boot REST service
- it returns data in JSON format
- the build system used is gradle, but don't worry, you won't need to change anything with that
- it starts up an in-memory SQL database, but you'll also won't need to do any database administration
- the database structure is defined in the file `/src/main/resources/schema.sql`, the data is defined in the file `/src/main/resources/data.sql`; you shouldn't have to change the contents of these files, but it is permitted if it is necessary for your solution.

### App startup
The application can be started by issuing the following command in the command line:

on mac/linux:
```bash 
./gradlew clean bootRun
``` 
on windows:
```bash
.\gradlew clean bootRun
```

### App operations
The applications starts up a web server and responds to http calls. So to issue a command to the app you need to either execute a `curl` command or enter the browser. 
 
curl:
```bash
curl localhost:8080/api/bookings/1 -v
```

browser:

enter the address `http://localhost:8080/api/bookings/1`

## Your tasks
**Above all else the code in the application has to compile**. It's ok, if something doesn't work, but the code has to compile properly and the application needs to startup.

 1. Add the ability to save a new booking in the database.
 1. The database contains also data about customers. Add the ability to get customers from the database.
 1. Every booking has a customer connected with it, which is shown in the `Booking` class in the field `customerId`. Change this field to show the complete set of information about the customer. The customers are also stored in the database.
 1. Right now the app only returns information about a specific booking by id, it's price and duration, on the endpoint `/api/bookings/{id}`. Add the ability to retrieve all bookings stored in the database.
 1. For some cases, the API returns a different booking class than what is stored in the database. Please find the error and fix it.
 1. The price calculation algorithm doesn't have any unit tests. Write junit tests for this algorithm and fix any potential bugs.
 1. The flight duration is calculated wrong. For some cases it returns a correct value, but f.ex. for the flight 
 AMS -> JFK it returns 5h 5min but it should return 11h 5min. Please fix it.
 