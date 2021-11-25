![image](https://img.shields.io/badge/Contributors-15-red?style=for-the-badge&logo=github)
![image](https://img.shields.io/badge/Branches-30-yellow?style=for-the-badge)
![image](https://img.shields.io/badge/Spring%20Boot-v2.5.6-success?style=for-the-badge&logo=spring)
![image](https://img.shields.io/badge/Angular-v8.3.8-red?style=for-the-badge&logo=angular)
![image](https://img.shields.io/badge/Maven-v3.8.1-informational?style=for-the-badge)



<h1> Car Pooling System</h1>
Car Pooling System is a system that connects drivers and passengers willing to travel together between the cities and share the journey. Ride Owner / Driver: Ride owner is a person who owns a car and wants to travel from one place to another and publishes his trip on the application in order to find the passengers to share the ride with Passenger: Passenger is a person who wants to travel or wants to join in the trip the driver has posted. Passenger can travel if he/she agrees to the condition the driver has specified (Price, time and behavior) Admin: Admin is a person who has complete control over other stake holders.

<h2>Getting Started</h2>
<ul>
<li> Start with this Github Repository</li>
<li>Git clone to directory of your choice $ git clone https://github.com/sainikhilll/cps.git</li>
<li> Open cps-frontend folder in VS Code</li>
<li>Run npm install in terminal.</li>
<li>Run ng serve to launch frontend.</li>
<li>Open SQL Script which is present in Database folder in MySQL workbench and run the script to create all the required tables</li>
<li>Import the cps-rest in STS and Change Database configurations in application.properties</li>
<li>Start the Application from CpsRestApplication.java file.</li>
<li>Access the application from Browser</li>
</ul>

<h2>Technologies Used</h2>
<h3>Frontend</h3>
<ul>
  <li>HTML</li>
  <li>CSS</li>
  <li>JS</li>
  <li>Angular</li>
  <li>Bootstrap</li>
</ul>

<h3>Backend</h3>
<ul>
<li>Java</li>
<li>Rest</li>
<li>Spring Framework</li>
<li>Spring Boot</li>
<li>Spring Data JPA</li>
<li>Maven</li>
</ul>

<h3>Database</h3>
<ul>
<li>MySQL</li>
</ul>

<h3>DevOps</h3>
<ul>
  <li>AWS</li>
  <li>Docker</li>
  <li>Jenkins</li>
  <li>Git</li>
</ul>

<h3>Testing</h3>
<ul>
  <li>Junit, Jasmine, Karma</li>
  <li>Postman</li>
</ul>

<h3>IDE</h3>
<ul>
<li>Spring Tool Suite IDE</li>
<li>Visual Studio Code</li>
</ul>

<h2>Features</h2>

<h3>RideOwner</h3>
<ul>
<li>As a Ride Owner, I want to register using name, address, mobile, mail, password and personal documents (like license and aadhar), so that I can share my ride</li>
<li>As a Ride Owner, I want to login, so that I can access the system</li>
<li>As a Ride Owner, I want to add preferences and personal behaviour (Aversion to Music, Smoking Allowed, Pets Allowed), so that passengers can select ride owner based on his preferences.</li>
<li>As a Ride Owner, I want to change my profile details after admin verification, so that I can keep my profile up to date</li>
<li>As a Ride Owner, I can publish my trip information like destination, origin, departure time, price, date and travelling preferences, so that the Passenger can find his suitable journey</li>
<li>As a Ride Owner, I want to receive notification and passenger details after booking confirmation so that I can get in touch with passenger.</li>
<li>As a Ride Owner, I want to edit or cancel the trip, so that I can handle if there is any change in my plan.</li>
<li>As a Ride Owner, I want to rate my passengers after completion of trip so that it will be added to passenger profile.</li>
<li>As a Ride Owner, I want to view my ratings and reviews, so that I can know where my ratings stand</li>
</ul> 
<h3>Passengers</h3>
<ul>
<li>As a Passenger, I can register in the system by giving my name , password, email, phone number, date of birth so that I can book ride</li>
<li>As a Passenger, I want to login, so that I can access the system</li>
<li>As a Passenger, I can change the password after successful registration, so that I can change my password whenever I want to.</li>
<li>As a passenger, I want to search based on destination, origin, departure time, date, price budget and car type so that it can filter out the options I have.</li>
<li>As a Passenger, I want to view the Ride Owner ratings, reviews and preferences before booking a ride, so that I can decide to take up the ride or not.</li>
<li>As a Passenger, I want to book a ride on the searched ride options, so that I can select my ride</li>
<li>As a Passenger, I can get the notification on the successful booking so that I can get the booking confirmation and details about the Ride Owner</li>
<li>As a Passenger, after I book a trip I can cancel my trip so that I can cancel when there is a change in my plan</li>
<li>As a Passenger, I want to review and rate the Ride Owner, so that I can convey my feedback about the ride</li>
</ul>    
<h3>Admin</h3>
<ul>
<li>As a Admin, I want to verify the driver's details and then approve or reject, so that the Ride Owner can publish his trip and make it available for passengers</li>
<li>As a Admin, I want to view all the Ride Owners, so that I can know about the Ride Owners in the system</li>
<li>As a Admin, I want to view all the Passengers, so that I can know about the Passengers in the system</li>
<li>As a Admin, I want to view all the Rides, so that I can view details about the current rides and completed rides</li>
<li>As a Admin, I can cancel a Ride, so that I can prevent any unforeseen circumstances</li>
<li>As an Admin, I want to blacklist a Ride Owner, so that I can prevent any unforseen circumstances</li>
<li>As an Admin, I want to blacklist a Passenger, so that I can prevent any unforseen circumstances</li>
<li>As a system, I want to create an admin credentials by default, so that the admin can initially manage the app.</li>
</ul>
