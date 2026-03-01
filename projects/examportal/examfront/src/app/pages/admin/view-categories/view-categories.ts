import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { Material_Imports } from '../../../importMaterial';
import { CommonModule } from '@angular/common';
import { Category } from '../../../service/category';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-view-categories',
  imports: [
    CommonModule,
    Material_Imports
  ],
  templateUrl: './view-categories.html',
  styleUrl: './view-categories.css',
})
export class ViewCategories implements OnInit {
  categories:any[]=[]

  constructor(private _categorys:Category ,  private cdr: ChangeDetectorRef){

  }
  ngOnInit(): void {
    this._categorys.categories().subscribe((data:any)=>{
      this.categories=data;
      //this.cdr.detectChanges();
      console.log("in ngoninit")
      console.log(this.categories);
  
    },
    (error)=>{
      console.log(error);
      Swal.fire("Error  !!","error in loading data","error");
    }
  )
  }

}
