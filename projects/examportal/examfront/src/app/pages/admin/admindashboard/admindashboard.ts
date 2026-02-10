import { Component } from '@angular/core';
import { Sidebar } from '../sidebar/sidebar';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-admindashboard',
  imports: [Sidebar,RouterOutlet],
  templateUrl: './admindashboard.html',
  styleUrl: './admindashboard.css',
})
export class Admindashboard {

}
