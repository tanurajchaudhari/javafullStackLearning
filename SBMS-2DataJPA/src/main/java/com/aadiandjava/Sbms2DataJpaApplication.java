package com.aadiandjava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.aadiandjava.repository.BookRepository;
import com.aadiandjava.repository.EmployeeRepository;

@SpringBootApplication
public class Sbms2DataJpaApplication implements CommandLineRunner{

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Sbms2DataJpaApplication.class, args);
		BookRepository bean = context.getBean(BookRepository.class);
		System.out.println(bean.getClass().getName());
		
	}
    @Autowired
    BookRepository bookRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    
    // spring will create the implementation class and  object of thebookRepository Interface  
    //Proxy Classes are wiil create at runtime and that class object is inject in bookRepository
    //IOC will inject the BookRepositoy Implementation class object
    
	//Implementing run method of CommandLineArgument
	//Run method will call when spring boot application is started  
	@Override
	public void run(String... args) throws Exception {
		
		System.err.println("Run method called...");
		
		
//		Employee employee=new Employee();
//		employee.setName("John dao");
//		employee.setDep("It");
//		employee.setSalary(213323.23);
//		employee.setCity("pune");
//		employee.setGender("Male");
//		
//		Employee employee1=new Employee();
//		employee1.setName("John cens");
//		employee1.setDep("finance");
//		employee1.setSalary(23232.23);
//		employee1.setCity("mumbai");
//		employee1.setGender("Male");
//		
//		Employee employee2=new Employee();
//		employee2.setName("meghna");
//		employee2.setDep("hr");
//		employee2.setSalary(46234.54);
//		employee2.setCity("banglore");
//		employee2.setGender("female");
//		
//		Employee employee3=new Employee();
//		employee3.setName("shrusti ");
//		employee3.setDep("tech");
//		employee3.setSalary(243434.23);
//		employee3.setCity("pune");
//		employee3.setGender("female");
//		
//		Employee employee4=new Employee();
//		employee4.setName("sema");
//		employee4.setDep("frontend");
//		employee4.setSalary(347834.21);
//		employee4.setCity("pune");
//		employee4.setGender("female");
//		
//		Employee employee5=new Employee();
//		employee5.setName("rahul");
//		employee5.setDep("backend");
//		employee5.setSalary(9687967.263);
//		employee5.setCity("mumbai");
//		employee5.setGender("Male");
//		
//		Employee employee6=new Employee();
//		employee6.setName("rok johnson");
//		employee6.setDep("system  software");
//		employee6.setSalary(878737.23);
//		employee6.setCity("new york");
//		employee6.setGender("Male");
//		
//		Employee employee7=new Employee();
//		employee7.setName("mark");
//		employee7.setDep("ceo");
//		employee7.setSalary(348787387.23);
//		employee7.setCity("new york");
//		employee7.setGender("Male");
//		
//		employeeRepository.saveAll(Arrays.asList(employee,employee1,employee2,employee3,employee4,employee5,employee6,employee7));
//		
		
		
		//how to sort employees
		//Ascending & descending 
//		Sort sort = Sort.by("city").descending();
//		employeeRepository.findAll(sort).forEach(i->System.err.println(i));
//		
		
		//filter the employee
//		Employee emp= new Employee();
//		emp.setCity("mumbai");
//		emp.setGender("male");
//		Example<Employee> of = Example.of(emp);
//		employeeRepository.findAll(of).forEach(i->System.err.println(i));
//		
		//Pagination
		//to improve performance 
//		int pageNo=4;
//		PageRequest of = PageRequest.of(pageNo-1, 2);
//		Page<Employee> page = employeeRepository.findAll(of);
//		List<Employee> employees = page.getContent();
//		employees.forEach(i->System.err.println(i));
//		
		employeeRepository.findByName("rahul").forEach(i->System.err.println(i));
		
		employeeRepository.findByDep("It").forEach(i->System.err.println(i));


		employeeRepository.findByCity("mumbai").forEach(i->System.err.println(i));

		employeeRepository.findByGender("male").forEach(i->System.err.println(i));

		employeeRepository.findByNameOrDep("rahul","HR").forEach(i->System.err.println(i));
		
		employeeRepository.findByNameAndDep("rahul","Backend").forEach(i->System.err.println(i));

		employeeRepository.findBySalaryGreaterThan(50000).forEach(i->System.err.println(i));
         
		employeeRepository.findByNameStartingWith("s").forEach(i->System.err.println(i));
		
		employeeRepository.findByNameEndingWith("o").forEach(i->System.err.println(i));

		employeeRepository.findByNameContains("o").forEach(i->System.err.println(i));

		
		
		
		
//		Optional<Book> byId = bookRepository.findById(1);
//		if(byId.isPresent()) {
//			Book book=byId.get();
//			System.err.println(book);
//		}else {
//			System.err.println("Book Not Found... ");
//		}
		
		
//		bookRepository.findAllById(Arrays.asList(1,2,3)).forEach(System.out::println);
//		bookRepository.findAll().forEach(i->System.err.println(i));
		
//		boolean existsById = bookRepository.existsById(2);
//		System.err.println("Exists by id 2: "+existsById);
		
//		if(bookRepository.existsById(2)) {
//			bookRepository.deleteById(2);
//			System.err.println("Book deleted");
//		}else {
//			System.err.println("Book Not Found");
//		}
		
		//bookRepository.deleteAllById(Arrays.asList(4,5));
	//	bookRepository.deleteAll();
//		long count = bookRepository.count();
//		System.err.println("Total books : "+count);


		
//		Book book=new Book();
//		book.setBookName("python programming");
//		book.setBookAuthor("aadi and python");
//		book.setBookPrice(432.0);
//		book.setBookQuantity(56);
//		
//		
//		Book book1=new Book();
//		book1.setBookName("c++ programmin");
//		book1.setBookAuthor("aadi and c++");
//		book1.setBookPrice(586.0);
//		book1.setBookQuantity(75);
//		
//		
//		Book book2=new Book();
//		book2.setBookName("react js ");
//		book2.setBookAuthor("tanuraj chaudhari");
//		book2.setBookPrice(232.0);
//		book2.setBookQuantity(21);
//		
//	
//		Book book3=new Book();
//		book3.setBookName("node js");
//		book3.setBookAuthor("shashi sir");
//		book3.setBookPrice(343.0);
//		book3.setBookQuantity(43);
//		
//		
//		Book book4=new Book();
//		book4.setBookName("blackchain");
//		book4.setBookAuthor("harkirat sigh");
//		book4.setBookPrice(3764.0);
//		book4.setBookQuantity(74);
//		//save method called to save Book entity
//		bookRepository.saveAll(Arrays.asList(book,book1,book2,book3,book4));
//		
		
	}

}
