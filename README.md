<h1>Contact Tracer</h1>

<h3>A QR-based Corona tracker Android application</h3>
<br>  
![alt text](https://github.com/mparedes3/qr-corona-tracker/blob/master/logo.jpg)
<h3>Developed and Tested by: Marco Paredes, Philip Emmanuele, Delilah Jacobsen, Rajvir Logani, and Ravi Johnson</h3>
<br>

<h3>Introduction</h3>

  Our ideas for this project stemmed from the desire to help others feel some semblance of control during this time. With the feeling of an invisible threat looming every time people leave the house, we wanted to allow for a way to trace the virus between communities and anonymously alert others of potential contact. The entire world is reeling and struggling to adjust to a new virus that could potentially stick around, a lengthy quarantine, and the subsequent anxieties and heightened emotions. Our hope has been to make an app that will give users reassurance and a sense of stability as we all navigate through new policies and this tragic threat.

<h3>Purpose and Motivation</h3>

  With the high contagion risk of coronavirus, many are scared for their health and the health of their loved ones. Even if everyone were to obey social distancing as much as possible, sometimes going out can be unavoidable. Whether going to a park alone or to buy groceries, the unknown concern and risk associated with leaving one’s home can be overwhelming. Contact Tracer allows users to have more assurance and knowledge regarding whether or not there has been community spread of coronavirus to them. 


  One of the most common questions recently when speaking to health care workers is “have you had recent contact with a person with diagnosed coronavirus?” This can oftentimes be a difficult question to answer because of the possibility that one unknowingly came into contact with a person that has COVID-19 or that a family member was diagnosed and did not come forward about their results. By scanning a QR code at stores and other public locations, Contact Tracer will allow for users' locations to be saved and, in the event that they are diagnosed with COVID-19, they can alert Contact Tracer. Contact Tracer will then alert all users that they have come into contact with an anonymous individual that was diagnosed with COVID-19. A benefit to this is that it will also encourage users to stay inside if they have had contact with anyone that ended up being diagnosed with coronavirus, thus preventing further spread.

<h3>Step-By-Step Instructions</h3>

1. Open the app

2. Go to a store or other public location and scan the designated QR code for every public location that you go to 

3. If you are diagnosed with coronavirus, push the button that claims that to notify everyone that has either possibly been in direct contact with you or has been in indirect contact with you via crossing paths in certain locations over a two week time period. This data is stored in order to track community spread because those individuals may have been in contact with anything you touched while you were in a public location

4. The app is also useful if you are not diagnosed with COVID-19. It will alert you if  someone you were in contact with ended up being diagnosed with coronavirus. This is why it is important to turn on notifications. 

<h3>Team Member Roles and Contributions</h3>

- Philip Emmanuele: This was my first time working with both Android App Studio and the coding language of Java. Therefore, I took more time to do tasks that weren’t very complicated. During this project, I mostly worked on coming up with ideas as well as various front end tasks. For example, I implemented the code that made the “twitter” page of our app possible and accessible. In addition, I also implemented the navigation bar at the bottom of the screen. 

- Delilah Jacobsen: My primary contributions were writing the non-coding related portions of our app and the design of our logo. In regards to the writing I did, the majority of the work revolved around researching COVID-19 to produce a section within our app about the effects of COVID-19 and relevant questions that any users may have. To produce our finalized logo, I drew a total of 4 different designs to give our team options to decide on. From there, I edited and finalized the logo based on our predetermined color scheme.

- Marco Paredes: My roles in the project included building the front-end and making both the menu and loading screen. I also assigned roles to every team member, first making sure they learn the material before implementing it. Leading an engineering team for the first time was nerve racking. I didn’t know what I was doing in the beginning and how to organize meetings or lead discussions, but it all turned out well at the end.

- Rajvir Logani: Back-end

- Ravi Johnson: QR code

<h3>Difficulties and Challenges</h3>

  Some of us didn’t (or still don’t) know how to code in Java so that was a major challenge we faced. We were able to overcome this through individuals teaching themselves how to code through research, such as looking up Java-teaching programs, and by messing with the code to see how it worked and what different tweaks resulted in. Since many functions were initially unknown and foreign, we had to look up many of them and try to manipulate them to work in the way that we wanted. The hardest part was the Java-specific syntax, but by playing with it and taking Android Studio’s suggestions, we were able to produce code that did not contain any errors. 
  
  
  We wanted to use a more passive data collection method such as the app accessing the users’ location. However, due to the limited resources of time and experience, we figured that this way wouldn’t be feasible. Instead, we opted to use a more inconvenient, but easier to code method of data collection by using QR codes.
  
  
  This was also the first time that almost everyone in the group was working with a large amount of data that had to be stored in the cloud. Therefore, it was a big challenge to learn JSON, learn how to store things in the cloud, and then implement that knowledge to fit our needs. 	
  
  
  Another challenge that we faced was how we wanted to implement the backend of the software. We ran through three or four ideas on how to implement it using firebase but most of them were either too complicated or we realised that they would fail after delving into them. This is the model for the final back-end program we decided on using because of our ideas it was the most efficient and effective:
  
 
<h3>Back-End</h3>

- Class: Location
  - Private field: users - a HashMap that holds the userID of the user who scanned the QR code as a key and the time of which the QR code was scanned as the value
  - Private field: QRcode - the tostring of the QR code for the specific location
    - Method: recordUsers
      - This method takes the users HashMap and puts its data into a text file which is saved to firebase
    - Method: readUsers
      - This method reads in the data from the use rstxt file in firebase and sets them as the parameter for the object (used in constructor)
      
- Class: User
  - Private field: locations - a HashMap that holds the qr code of a location as a key and the time of which the QR code was scanned as the value
  - Private static field: twoWeeks - a long that holds the number of milliseconds equivalent to two weeks (when risk of virus spreading in one area from a single individual is less)
  - Private field userID - hold the user’s identification (in the form of a long) so that the app can recognize which user is logged in
  - Private static field: availableLocations - a Hashmap that holds the qr code tostring of a location as the key and the location object reference (from location class) as the value 
    - Method: addLocation
      - This is the method that manages the data storage when a user scans the QR code. What this method does is it adds the qr tostring (as the key) and the time in which the QR code was scanned (using java’s Date class) to the private field hashmap “locations” if the QR code matches on of the keys in availableLocations
      - Then, using the availableLocations HashMap, this method uses the key (the qr tostring) just entered into the locations hashmap to retrieve the location object reference in availableLocations, it then adds the user’s userID number and time of entry into the location objects “users’ private field/HashMap which is then saved to firebase using the recordLocations method
      - After this it iterates through every item in the locations hashmap and removes every location entry that has been on the list for longer than two weeks 
    - Method: recordLocations 
      - This method takes the locations HashMap and puts its data into a text file which is saved to firebase
    - Method: readLocations
      - This method reads in the data from the locations txt file in firebase and sets them as the parameter for the object (used in constructor)
    - Method: coronaAlert
      - This method goes through every storthe the user has been to in the past two weeks, and using available locations goes through every locations users Hashmap and alerts all users that have been in those locations in the past two weeks that they have possibly been in contact with someone who has Coronavirus and that they should take precautions
      
The back end of this application handles all of the data storage and functionality of the QR scanner and alert button portions of the application. Basically once a User is identified using a User ID, they can do two functions, scan a QR code signifying entrance into a store location, or press the alert button to send out an anonymous tip that they have coronavirus. When starting up the app, all user and location objects are recreated given documentation in firebase. Once they are all recreated, a hashmap of all store location qr codes and references to those location objects is created which is recorded as a static variable for all user objects to have access to. A user can scan a QR code and the addLocation method will be called as described above. A user can also push the button to give an anonymous tip alerting all of the people who could have possibly been in contact with that person or the virus spread by that person by calling the method corona alert. There are also methods to record the current standings of all locations and users  to firebase and methods to read that information back in during the recreation of those objects in their constructor. 


<h3>Market Evaluation</h3>

Our product would be free on the app store and would be advertised by businesses that would hang QR codes in the storefront or immediately inside their business with our logo on it and a quick explanation of how the app works. Users would then download the app and use it at every business and/or public that has a designated QR code. When the user population reaches a critical mass, the app will be effective. This efficacy comes from users taking the recommended precautions in places where an individual that was diagnosed as COVID-19 positive had been and from users that had been in possible (direct or indirect) contact with the COVID-19 positive individual quarantining.

<h3>Suggested Improvements</h3>

Improvements we would want to make to the software are to make our program overall more efficient and effective. In the future given more time to learn how to program with different google API’s we would like to use applications like google maps to help with tracking but given our knowledge base we were only really able to do this more simplistic system. We’d probably also clean the app up a bit so it looks a little smoother and cleaner and add more attachments/widgets.

<h3>Conclusion</h3>

Overall, every person in our group has learned more about coding, specifically Java, and about what it takes to make an app. We have also learned a lot about the global situation and steps we can take on an individual level to prevent the spread of coronavirus. We have seen the development of an API from Apple and Android devices based on a similar concept. Their statement of their intent for “public health agencies [to] incorporate the API into their own apps” was encouraging to many but also fairly concerning. This leaves it open to the health care providers to include a service within their apps that offers coronavirus tracking and prompted the question of “what if health care providers do not develop an app to track coronavirus?” that urgently needs to be addressed. Through our app, we wanted to ensure that there was a coronavirus tracking app available in case health care providers chose not to develop one, and also to provide individuals that don’t have health insurance with the opportunity to also take part in the community effort to track and control the spread of coronavirus.

<h3>References</h3>

https://www.cdc.gov/coronavirus/2019-ncov/symptoms-testing/symptoms.html

https://www.cdc.gov/coronavirus/2019-ncov/prevent-getting-sick/cleaning-disinfection.html

https://www.epa.gov/pesticide-registration/list-n-disinfectants-use-against-sars-cov-2-covid-19

https://www.umms.org/coronavirus/what-to-know/treat-covid-at-home 

https://www.blog.google/inside-google/company-announcements/apple-google-exposure-notification-api-launches/
