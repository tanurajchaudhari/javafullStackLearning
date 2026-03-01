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
import { ViewCategories } from './pages/admin/view-categories/view-categories';
import { AddCategory } from './pages/admin/add-category/add-category';
import { ViewQuizzes } from './pages/admin/view-quizzes/view-quizzes';
import { AddQuiz } from './pages/admin/add-quiz/add-quiz';
import { UpdateQuiz } from './pages/admin/update-quiz/update-quiz';
import { ViewQuizQuestions } from './pages/admin/view-quiz-questions/view-quiz-questions';
import { AddQuestions } from './pages/admin/add-questions/add-questions';
import { UpdateQuestion } from './pages/admin/update-question/update-question';
import { LoadQuiz } from './pages/user/load-quiz/load-quiz';
import { Instructions } from './pages/user/instructions/instructions';
import { Start } from './pages/user/start/start';

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
        path: 'user', 
        component: UserDashboard,
         
         canActivate:[normalGuard],
         children:[
            {
                path:':catId',
                component:LoadQuiz
            },
            {
                path:'instructions/:qid',
                component:Instructions
            }
           
         ],
    },
     {
                path:'start/:qid',
                component:Start,
                canActivate:[normalGuard],
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
            },
            {
                path:'categories',
                component:ViewCategories
            },
            {
                path:'add-category',
                component:AddCategory
            },
            {
                path:'quizzes',
                component:ViewQuizzes
            },
            {
                path:'add-quiz',
                component:AddQuiz
            },
            {
                path:'update-quiz/:qid',
                component:UpdateQuiz
            },
            {
                path:'view-questions/:qid/:title',
                component:ViewQuizQuestions
            },
            {
                path:'add-questions/:qid/:qtitle',
                component:AddQuestions
            },
            {
                path:'update-question/:questId',
                component:UpdateQuestion
            }
           ]
    },
    {
        path: '', component: Home, pathMatch: 'full'
    },


];
