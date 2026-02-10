import { Routes } from '@angular/router';
import { Home } from './home/home';
import { About } from './about/about';
import { Contact } from './contact/contact';
import { Profile } from './profile/profile';

export const routes: Routes = [


    //localhost:4200/
    // {
    //     path:'',redirectTo:'home',pathMatch:'full'
    // },
    {
        path:'home',component:Home
    },
    {
        path:'about',component:About
    },
     {
        path:'contact',component:Contact
    },
     {
        path:'profile',component:Profile
    },
    //  {
    //     path:'**',component:Home
    // },


    
];
