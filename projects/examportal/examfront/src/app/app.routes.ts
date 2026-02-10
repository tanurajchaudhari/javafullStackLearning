import { Routes } from '@angular/router';
import { Signup } from './pages/signup/signup';
import { Home } from './pages/home/home';
import { Login } from './pages/login/login';
import { UserDashboard } from './pages/user/user-dashboard/user-dashboard';
import { Admindashboard } from './pages/admin/admindashboard/admindashboard';
import { adminGuard } from './service/admin-guard';
import { normalGuard } from './service/normal-guard';
import { Profile } from './pages/profile/profile';
import { Welcome } from './pages/admin/welcome/welcome';

export const routes: Routes = [
    {
        path: 'signup', component: Signup, pathMatch: 'full'
    },
    {
        path: 'home', component: Home, pathMatch: 'full'
    },
    {
        path: 'login', component: Login, pathMatch: 'full'
    },
    {
        path: 'user', component: UserDashboard, pathMatch: 'full',canActivate:[normalGuard]
    },
    {
        path: 'admin',
         component: Admindashboard,
        //   pathMatch: 'full',
           canActivate: [adminGuard],
           children:[
             {
                path:'',
                component:Welcome
            },
            {
                path:'profile',
                component:Profile
            }
           ]
    },
    {
        path: '', component: Home, pathMatch: 'full'
    },


];
