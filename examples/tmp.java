database MyDB;

class User {
	int age;
	String name;
	Animal[] animals;
	
	User getMaxAgeUser() : User.max(User.age);
	int getMinAgeUserId() : User.min(User.age).id;
}

class Animal {
	int age;
	String name;
	String type;
	User user;
	
	Animal getByUser(User user) : Animal.find(Animal.user == user);
	int getMediumAge() {
		return Animal.sum(Animal.age) / Animal.count();
	} 
}

class Purchase {
	float amount;
	User user;
	String product;

	float getUserPurchasesAmount(User user) {
		float sum = 0;
		Purchase[] ps = Purchase.findAll(Purchase.user == user);
		for (Purchase p : ps)
			if (p.amount > 0)
			    sum += p.amount;
		return sum;
	}
}


