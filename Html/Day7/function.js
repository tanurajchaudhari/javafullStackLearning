function Add(){
console.log("Hellow thei function in js")
}
function Add1(){
    var a=10, b=20;
    console.log(a+b)
}
function add(a,b){

    console.log(a+b);
}
Add()
add(100,200)
add(1)
add(1000,2000,3000)
add("Ram","Shyam")
//  function getstudent(){
//     return {name:"Rohan",age:20};
//  }
// console.log( getstudent())

 function getstudent(){
   var objects=[
     {name:"Rohan",age:20,adress:{city:"Pune",pincode:412110}},
     {name:"Karan",age:22},
     {name:"suresh",age:21}
   ]
   return objects[0].adress.city;
 }
 console.log(getstudent())
