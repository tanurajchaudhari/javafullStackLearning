var userDetails=[]

// var userData=[1,"Tanurajandhisproblems",{city:"Pune"},true,45.46,"male"]

//  console.log(typeof userData)
// console.log(userData);

 // addthe data last position
//  userData.push("Aadi")// insert
//  userData.push("Lakshman",23)
//  console.log(userData);

// add data first
// userData.unshift(99)
// userData.unshift({gender:"Male"},[1,2,3])
// console.log(userData)

// remove last element
// userData.pop()
// console.log(userData)

// splice

//var numbers=[1000,2000,3000, 8000]
//numbers.splice(2,0,4000,5000,6000)
//numbers.splice(2,2,101,102)
//numbers.splice(2,0)
//numbers.splice(2,2)
// numbers.splice(0,2)

// console.log(numbers)

//   var userData=[1,"Tanurajandhisproblems",{city:"Pune"},true,45.46,"male"]

// var newarr=userData.slice(2,5)
// console.log(newarr)

//  var x=userData.indexOf(true)
// var x=userData.indexOf("male")
//  console.log(x)

var userData=[1,"Tanurajandhisproblems",{city:"Pune"},true,"Tanurajandhisproblems",45.46,"male"]
//var x= userData.lastIndexOf("Tanurajandhisproblems")

// var isElementPresent = userData.includes("male")
// var isElementPresent = userData.includes("20282")
// console.log(isElementPresent)

// console.log(userData[4])
// console.log(userData[40])

// var length = userData.length;
// console.log(length)

//  for(var i=0;i<userData.length;i++){
//     console.log("indes is "+i+"   having a element  is :- "+userData[i])
//  }


//----------- forEach loop
// userData.forEach(function(element,index){
//     console.log(index, element)
// });


//----------map
// var numbers=[1000,2000,3000, 8000]

// var newnum=numbers.map(function(e,i){
//     return e*2;
// })
// console.log(newnum)

// var name=["Tanuraj","Atharv","Abhay","Mayur"]

// var newnames=name.map(function(e,i){
//     return e.toUpperCase()+" : "+e.length
// })
// console.log(newnames)

//---------------------filter

// var numbers=[23,321,43,23,344,22,24,"Tanuraj","gaurav","ganesh"]
// var newnum=numbers.filter(function(e,i){
//     return e.startsWith("g")
// })
//  console.log(newnum)

// var details=[
//     {
//         brand:"Xiomi",
//         model:"Mi 11",
//         color: "black",
//         price:8948

//     },
//         {
//         brand:"RedMe",
//         model:"RM 1",
//         color: "green",
//         price:83742

//     },
//         {
//         brand:"Apple",
//         model:"promax",
//         color: "orange",
//         price:120000

//     },
//         {
//         brand:"Samsung",
//         model:"J1",
//         color: "pink",
//         price:23231

//     },
//         {
//         brand:"Motorolla",
//         model:"G65",
//         color: "violet",
//         price:15000

//     },
// ]
// console.log(details)

// var newdata=details.filter(function(item){
//     return item.brand=="Apple";
// })
// console.log(newdata)


var obj={
    name:"Raj",
    age:22,
    address:"Pune",
    id:111
}

var  num=[12,13,14,12,13,11,12]

// for (var x in obj){
//     console.log(x);
// }
// for (var x in obj){
//     console.log(x," : ",obj[x]);
// }

// on array of an d in working but in  object  ony in working
for(var x of num) {
    console.log(x)
}
for (var x in num){
        console.log(x," : ",num[x]);
}
