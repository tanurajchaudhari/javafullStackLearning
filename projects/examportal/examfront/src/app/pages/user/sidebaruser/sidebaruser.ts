import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { MatCardModule } from '@angular/material/card';
import { Material_Imports } from '../../../importMaterial';
import { Category } from '../../../service/category';
import { MatSnackBar } from '@angular/material/snack-bar';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-sidebaruser',
  imports: [
    CommonModule,
    Material_Imports,
  ],
  templateUrl: './sidebaruser.html',
  styleUrl: './sidebaruser.css',
})
export class Sidebaruser implements OnInit{

  categories:any[]=[]

  constructor(private _cat:Category,private _snack:MatSnackBar,private cdr:ChangeDetectorRef){}

  ngOnInit(): void {
     this._cat.categories().subscribe(
      (data:any)=>{
        this.categories=data
        // this.cdr.detectChanges()
        console.log(data)
      },
      (error)=>{
          this._snack.open('error in fetching categories','',{
            duration:3000
          })
      }
     )
  }

}
