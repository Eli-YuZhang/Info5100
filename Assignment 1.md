<center>

INFO 5100 Assignment 1
====
</center>

<p align="right">Yu (Eli) Zhang</p>

---

*1.Design a course management system*
---

**-Course Management System**

- Data: name, currentDate
- Behaviors: display, alert, sendMessage

**-Student**

- Data: name, universityId
- Behaviors: submitAssignment, login, logout

**-Professor**

- Data: name, universityId
- Behaviors: giveAssignment, gradeAssignment, deleteAssignment, login, logout

**-Teaching Assistant**

- Data: name, universityId
- Behaviors: gradeAssignment, login, logout

**-Course**

- Data: name, professor, studentList, assignmentList 
- Behaviors: 

**-Assignment**

- Data: name, courseName, score, dueDate, status
- Behaviors:


>**Sequence of invoking behaviors on objects: Assignment process**

	CourseManagementSystem cms;
	Student eli;
	Course info5100;
	Professor siva;
	TeachingAssistant yaqi

	siva.login(cms, universityId);
	Assignment.name = assignment1;
	Assignment.dueDate = sep18;
	siva.giveAssignment(info5100, assignment1, sep18);
	assignmentList.add(assignment1);
	cms.sendMessage(studentList, "New Assignment")
	siva.logout(cms);
	
	if assignment1.dueDate is later than cms.currentDate
		assignment1.status = open;
	else
		assignment1.status = close;
	
	eli.login(cms, universityId);
	cms.display(info5100.assignmentList);
	eli.submitAssignment(info5100, assignment1);
	if assignment1.status = open
		cms.alert("Submit Successful"); 
	else
		cms.alert("You Are Screwed");
 		cms.sendMessage(siva, yaqi, "eli assignment overdue");
	eli.logout(cms);
	
	yaqi.login(cms, universityId);
	yaqi.gradeAssignment(info5100);
	cms.sendMessage(studentList, "Assignment Graded")
	yaqi.logout(cms);

---

*2.Design a pet adoption platform*
---

**-Adoption Platform**

- Data: name
- Behaviors: generatePetId, getInfo, findVet,sendMessage, sendVetBill

**-Owner**

- Data: name, location, email, cellPhone
- Behaviors: register, postPet, searchForRequest, give, login, logout


**-Adopter**

- Data: name, location, email, cellPhone, personalProfile
- Behaviors: register, postRequest, searchForPost, adopt, login, logout

**-Pet**

- Data: ownerName, species, gender, age, healthCondition, location, petId
- Behaviors:


**-Vet**

- Data: name, location, qualification
- Behaviors: examinePet, submitReport

>**Sequence of invoking behaviors on objects:**

**Scenario 1: Owner looking for adopter**

	AdoptionPlatform ap;
	Owner owen = Owner.register(owen, location, email, cellPhone);
	Owen.postPet(owen, species, gender, age, healthCondition, location);
	ap.generatePetId(owen, species, gender, age, healthCondition, location);

	/*eli has already done : 
	Adopter.register(eli, location, email, cellPhone, personalProfile);
	eli.postRequest(species, gender, age, healthCondition, location);*/

	owen.login(ap);
	Adopter eli = owen.searchForRequest(species, gender, age, healthCondition, location);
	ap.getInfo(eli.personalProfile);

	if owen is satisfied with eli's profile
		owen.give(petId);
		ap.sendMessage(eli,"A Owner wants to give you his/her pet!")

			if eli.adopt(petId)
				ap.sendMessage(owen,"Agree to adopt! Adopter's contact infomation are (ap.getInfo (eli.location, eli.email, eli.cellPhone))");
				Vet victor = ap.findVet(min.abs(vet.location-owen.location));
				if victor.qualification == valid
					victor.examinePet(petId);
					victor.submitReport(petId);
					ap.sendMessage(eli,"Your new pet's health report is ready!")
					ap.sendVetBill(eli);
				else
					find the second(third, fourth...) closest untill a qualified vet is found;
			else
			ap.sendMessage(owen, "Adopter refused your pet");

	else if owen is not satisfied with eli and want to keep searching
		alter search criteria;
	else
		owen.logout(ap);

**Scenario 2: Adopter looking for pet**

	AdoptionPlatform ap;
	Adopter eli = Adopter.register(eli, location, email, cellPhone, personalProfile);

	//owen has already done : Owner.postPet(owen, species, gender, age, healthCondition, location);
	//ap has already done : ap.generatePetId(owen,species, gender, age, healthCondition, location);

	eli.login(ap);
	Owner owen = eli.searchForPost(ownerName, species, gender, age, healthCondition, location, petId);

	if eli is satisfied with owen's pet
		eli.adopt(petId);
		ap.sendMessage(owen,"An adopter is found!", eli.personalProfile)

			if owen is satisfied with eli's profile
				owen.give(petId);
				ap.sendMessage(eli,"Owner agrees to give you his/her pet! Owner's contact infomation are (ap.getInfo (owen.location, owen.email, owen.cellPhone))");
				Vet victor = ap.findVet(min.abs(vet.location-owen.location));
				if victor.qualification == valid
					victor.examinePet(petId);
					victor.submitReport(petId);
					ap.sendMessage(eli,"Your new pet's health report is ready!")
					ap.sendVetBill(eli);
				else
					find the second(third, fourth...) closest untill a qualified vet is found;
			else
			ap.sendMessage(eli, "Owner refuses to give you his/her pet");

	else if eli is not satisfied with owen's pet and want to keep searching
		alter search criteria;
	else
		eli.logout(ap);

---

*3.Design an app to book airline ticket*
---

**-App**

- Data: name
- Behaviors: sendMessage, sendBill, matchCompany, generateOrderId, refund

**-Passenger**

- Data: name, departureLocation, destination, contactInfo, loginCredentials, paymentMethod, numOfBaggage, milage
- Behaviors: register, login, logout, searchFlight, bookFlight, cancelFlight

**-Flight**

- Data: departureTime, arrivalTime, departureAirport, arrivalAirport, price, airlaneCompany
- Behaviors: 

**-Baggage**

- Data: owner, departureAirport, arrivalAirport, weight
- Behaviors:

**-Airlane Company**

- Data: baggageRule, refundPolicy
- Behaviors: acceptRequest, refuseRequest, extraCharge

>**Sequence of invoking behaviors on objects: Book a flight**
	
	App app;
	Passenger eli = Passenger.register(eli, loginCredentials, email, contactInfo, paymentMethod);
	Baggage = elibag;
	eli.login(app, loginCredentials);

	Flight info5100 = eli.searchFlight(departureTime, arrivalTime, departureAirport, arrivalAirport, price,airlaneCompany);
	AirlaneCompany neu = app.matchCompany(info5100);
	eli.bookFlight(info5100, numOfBaggage, paymentMethod);
	abc = app.generateOrderId(eli, info5100, departureTime, arrivalTime)
	
	if eli.numOfBaggage && elibag.weight meet neu.baggageRule
		app.sendBill(eli, abc)
	else
		app.sendBill(eli, abc + neu.extraCharge())
	
	if eli change his mind
		eli.cancelFlight(abc);
		if neu.refundPolicy is not met
			neu.refuseRequest(abc);
			app.sendMessage(eli, "Refund failed, airlane company denied your request according to company policy")
		else
			neu.acceptRequest(abc);
			app.refund(eli.paymentMethod);	
	else
		enjoy the trip;
---

*4.Design a course registration platform*
---

**-Course Registration Platform**

- Data: name
- Behaviors: checkCredit, sendMessage, sendBill, checkQualification

**-Course**

- Data: name, courseNumber, credit, instructor, preRequisit, major
- Behaviors: 

**-Student**

- Data: name, minCreditRequirement, loginCredentials, courseTaken, major
- Behaviors: login, logout, search, register, drop, contact

**-Advisor**

- Data: name, email
- Behaviors: overwrite


>**Sequence of invoking behaviors on objects:**
	
	CourseRegistrationPlatform crp;
	Student eli;
	Advisor adele

	eli.login(crp, loginCredentials)
	Course info5100 = eli.search(name, courseNumber, instructor);
	eli.register(info5100);	
	crp.checkQualification(eli.major, info5100.major, eli. courseTaken, info5100.preRequisit)

	if eli is qualified
		crp.checkCredit(info5100.credit, eli.minCreditRequirement);
		if minCreditRequirement is not met && eli.logout(crp)
			crp.sendMessage(eli, "Minimum credit requirement is not met, contact your advisor:(adele.email) to overwrite");
			eli.contact(adele);
			adele.overwrite(eli.minCreditRequirement);
			crp.sendMessage(eli, "Register successful! Your bill is ready");
			crp.sendBill(eli);
		else
			do nothing;
	else
		crp.sendMessage(eli, "You are not qualified for this course, contact your advisor:(adele.email) for more information");

---

*5.Order food in a food delivery app*
---

**-Food Delivery App**

- Data: name, food
- Behaviors: sendMessage, findCourier, acceptRefund, denyRefund, refund, generateOrderId

**-User**

- Data: name, location, phone, paymentMethod
- Behaviors: search, addToCart, checkOut, checkStatus, requestRefund

**-Restaurant**

- Data: name, location, phone
- Behaviors: finishCooking, contact

**-Courier**

- Data: name, currentLocation, phone
- Behaviors: checkIn, contact

**-Food**

- Data: name, taste, price, nationality
- Behaviors: 


>**Sequence of invoking behaviors on objects:**

	User eli;
	FoodDeliveryApp fda;
	Restaurant kfc;

	Food friedchicken = eli.search(food.name, food.taste, food.price, food.nationality);
	eli.addToCart(friedchicken);
	eli.checkOut();
	abc = fda.generateOrderId();

	Courier cris = fda.findCourier(min.abs(cris.location-kfc.location));
	fda.sendMessage(cris, "Pick up food at (kfc.location) and deliever to (eli.location)");
	fda.sendMessage(kfc,"eli (eli.phone) has ordered, a courier (cris.phone) is found");

	eli.checkStatus(abc);
	if kfc.finishCooking == false
		fda.sendMessage(eli, "Restaurant is cooking");
	else if kfc.finishCooking == true && cris.checkIn(kfc) == false
		fda.sendMessage(eli, "Courier is on his/her way to restaurant");
	else if kfc.finishCooking == true && cris.checkIn(kfc.location) == true && cris.checkIn(eli.location) == false
		fda.sendMessage(eli, "Courier is on his/her way to you with your food");
	else if kfc.finishCooking == true && cris.checkIn(kfc.location) == true && cris.checkIn(eli.location) == true
		fda.sendMessage(eli, "Just a sec!");
	else
		fda.sendMessage(eli, "Something wrong in the process, contact restaurant(kfc.phone) or courier (cris.phone)");

	if eli change his mind
		eli.requestRefund(abc);
		if kfc.finishCooking == true
			fda.denyRefund(abc);
			fda.sendMessage(eli, "Refund failed, Food is ready")
		else
			fda.acceptRefund(abc);
			fda.refund(eli.paymentMethod);	
	else
		enjoy food;
	
---
