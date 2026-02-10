import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Home } from './home/home';
import { Tanu } from './tanu/tanu';
import { Rohit } from './rohit/rohit';
import { Register } from './register/register';
import { form } from '@angular/forms/signals';
import { Form } from './form/form';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet,Home,Tanu,Rohit,Register,Form],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('thirdproject');
}
