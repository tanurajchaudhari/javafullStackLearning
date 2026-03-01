import { useState } from "react";
import{useForm} from "react-hook-form";
 export default function Signupform() {
// const {register,handleSubmit,formState:{errors}}=useForm();


//  function onSubmit(data){
//       event.preventDefault();
//       alert(`Submitted with Emal : ${data.email} email and password : ${data.password} password`);
//  }

    return(
        // <div>
        //     <h1>Sign Up</h1>
        //     <form onSubmit={handleSubmit(onSubmit)}>
        //         <div>
        //             <label>
        //                 Email 
        //                 <input
        //                  type="email" placeholder="you@gmail.com" 
        //                  {...register("email",{required:"Email is required"})}
        //                  />
        //             </label>
        //             {errors.email && <p style={{color:"crimson"}}>{errors.email.message}</p>}
        //         </div>
        //         <div>
        //             <label>
        //                 Password
        //                 <input type="password" placeholder="********" 
        //                 {...register("password",{required:"Password is required",
        //                     minLength:{
        //                         value:4,
        //                         message:"Password must be at least 4 chars"
        //                     },
        //                     maxLength:{
        //                         value:12,
        //                         message:"Password must be at most 12 chars"
        //                     },
        //                 })}
        //                 />
        //             </label>
        //             {errors.password && <p style={{color:"crimson"}} >{errors.password.message}</p>}
        //         </div>
        //         <button type="submit">Create Account</button>
        //     </form>
        // </div>

        <div></div>
    )
}