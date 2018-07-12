database MyDB;

class User {
	int age;
	String name;
	Animal[] animals;
	
	User getMaxAgeUser() -> User.max(age, -id);
	long getMinAgeUserId() -> User.min(age).id;
}

class Animal {
	int age;
	String name;
	String type;
	User user;
	
	Animal getByUser(User usr) -> Animal.find(user == usr);
}

class Purchase {
	float amount;
	User user;
	String product;

	float getUserPurchasesAmount(User usr) {
		float sum = 0;
		float[] arr = {1, 1.0};
		float i = arr[1];
		Purchase[] ps = Purchase.findAll(usr == user);
		for (Purchase p : ps)
			if (p.amount > 0)
			    sum += p.amount;
		return sum;
	}

	float kek(int a, int b, int c) -> (-1);
}


