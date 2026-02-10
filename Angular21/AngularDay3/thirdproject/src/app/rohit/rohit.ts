import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-rohit',
  imports: [CommonModule,FormsModule],
  templateUrl: './rohit.html',
  styleUrl: './rohit.css',
})
export class Rohit {
  age=12
  name="Tanuraj"
  city="Pune"

}
