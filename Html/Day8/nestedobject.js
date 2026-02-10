employee={
    id:1,
    name:"Tanuraj",
    salary:100000,
    address:{
        city:"Pune",
        state:"Maharastra",
        pin:412110
    },
    dep:{
             depId:101,
             depName:"IT"
    },
    contact:{
        mob:8600169179,
        email:"tanraj169179@gmail.com",
        parentContactNo:9767112633
    }
}
// console.log(employee);
// console.log(employee.address.pin)
// console.log(employee.contact.email)

employee.dep.depId=102;
employee.dep.depName="HR"

employee.dep.depId2=103;
employee.dep.depName2="dev"

employee.address.city="Banglore"

delete employee.address.pin;
// console.log(employee);

//make  neste on product ,user , student

///  for loop i js
for(i=0;i<5;i++) {

    for(j=0;j<5;j++){
        process.stdout.write(" * ");
    }
    console.log("\n");
}