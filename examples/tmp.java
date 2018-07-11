database MyDB;

class User {
	int age;
	String name;
	Animal[] animals;
	
	User getMaxAgeUser() -> User.max(age, -id);
	int getMinAgeUserId() -> User.min(age).id;

	int lol(int i) -> i;
	int tmp() -> lol(2);
}

class Animal {
	int age;
	String name;
	String type;
	User user;
	
	Animal getByUser(User usr) -> Animal.find(user == 1);
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
		int[] arr = {1, 1.0};
	}

	float kek(int a, int b, int c) -> (-1);
}


