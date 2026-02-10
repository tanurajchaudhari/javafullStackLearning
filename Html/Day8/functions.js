// -------------------------------CALL BACK FUNCTIONS

// function print(x){
//     console.log(x);
//     x();
// }

//  function show(){
//     console.log("Normal function who has name ");
//  }
// print(
//     function(){
//         console.log("Callback function");
//     }
// )
// print(show)


//----------------------- FUNSTION EXPRESSION
// function add(){
//     console.log("return  the function");
//     return function(){
//         console.log("return from add");
//     }
// }
// x=add();
// x();

// thisis also  function expression when u are passing function to a variable

x=function(){
    console.log("hellow world");
}
x();