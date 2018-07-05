database MyDB;

class Users {
	int age;
	String name;
	Animals[] animals;
	
	query User getMaxAgeUser() : User.max(User.age);
	query int getMinAgeUserId() : User.min(User.age).id;
}

class Animals {
	int age;
	String name;
	String type;
	User user;
	
	query Animal getByUser(User user) : Animal.find(Animal.user == user);
	query int getMediumAge() {
		return Animal.sum(Animal.age) / Animal.count();
	} 
}

class Purchase {
	float amount;
	User user;
	String product;

	query float getUserPurchasesAmount(User user) {
		float sum = 0;
		Purchase[] ps = Purchase.findAll(Purchase.user == user);
		for (Purchase p : ps)
			if (p.amount > 0)
			    sum += p.amount;
		return sum;
	}
}


