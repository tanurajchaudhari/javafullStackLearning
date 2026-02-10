import { Routes } from '@angular/router';
import { Empdetails } from './empdetails/empdetails';
import { Home } from './home/home';
import { Register } from './register/register';
import { Login } from './login/login';
import { EditPage } from './edit-page/edit-page';

export const routes: Routes = [

    { path: '', redirectTo: 'home', pathMatch: 'full' },
    {
        path: 'home', component: Home
    },
    { path: 'register', component: Register },

    { path: 'employees', component: Empdetails },

    { path: 'login', component: Login },

    {path:'edit-page/:id', component:EditPage},
    
    { path: '**', component: Home }

];
