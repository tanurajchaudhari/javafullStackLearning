import { Component, signal } from '@angular/core';
import { RouterLink, RouterOutlet } from '@angular/router';
import{MatButtonModule}from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { Navbar } from './components/navbar/navbar';
import { Material_Imports } from './importMaterial';
import { MatToolbar, MatToolbarModule } from '@angular/material/toolbar';
// import {MatInputModule} from '@angular/material/input';
// import {MatFormFieldModule} from '@angular/material/form-field';

@Component({
  selector: 'app-root',
  // standalone: true,
  imports: [
    RouterOutlet,
    MatButtonModule,
    // MatInputModule,
    // MatFormFieldModule,
    // MatCardModule,
    Navbar,MatToolbarModule,
    

  ],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('examfront');
}
