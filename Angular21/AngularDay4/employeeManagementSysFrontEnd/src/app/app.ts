import { Component, signal } from '@angular/core';
import { RouterLink, RouterOutlet } from '@angular/router';
import { Register } from './register/register';
import { Empdetails } from './empdetails/empdetails';
import { Home } from './home/home';
import { Login } from './login/login';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet,RouterLink],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('employeeManagementSysFrontEnd');
}
