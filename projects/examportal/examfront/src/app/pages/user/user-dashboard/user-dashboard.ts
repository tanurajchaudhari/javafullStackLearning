import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Sidebaruser } from '../sidebaruser/sidebaruser';


@Component({
  selector: 'app-user-dashboard',
  imports: [
    Sidebaruser,
    RouterOutlet
  ],
  templateUrl: './user-dashboard.html',
  styleUrl: './user-dashboard.css',
})
export class UserDashboard {

}
