import { CanActivateFn, Router } from '@angular/router';
import { LoginService } from './login-service';
import { inject } from '@angular/core';

export const adminGuard: CanActivateFn = (route, state) => {
  const login=inject(LoginService);
  const router=inject(Router);

  if(login.isLoggedIn() && login.getUserRole()=='Admin'){
    console.log("user is loggedin and are admin")
       return true;

  }
  console.log("user is not logged in and  not login")
  router.navigate(['login']);
  return false;
};
