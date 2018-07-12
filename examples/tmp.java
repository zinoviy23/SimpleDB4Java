database MyDB;

class User {
	int age;
	String name;
	Animal[] animals;
	
	User getMaxAgeUser() -> User.max(age, -id);
	int getMinAgeUserId() -> User.min(age).id;

	int lol(int i) -> 3 + 5;
	int tmp() -> lol(2) == 3;
	Animal[] ssss() -> animals[3];
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
		Purchase[] ps = Purchase.findAll(user == user);
		for (Purchase p : ps)
			if (p.amount > 0)
			    sum += p.amount;
		return sum;
		int[] arr = {1, 1.0};
		int i = arr[1];
	}

	float kek(int a, int b, int c) -> (-1);
}


