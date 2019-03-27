class Student{
	
	//This is a property of the Student class	
	public static String A = "TAG";
	//This is a property of the Objects of the Student class	
	public String name;
	public String address;
	public String age;

	Student(name, address, age){
		this.name = name;
		this.address = address;
		this.age = age;
	}

	public static void main(String... args){
		System.out.println("Hello");
		System.out.println(name);
	}

	public String sayHello(){
		returns "Hello World"
	}

}