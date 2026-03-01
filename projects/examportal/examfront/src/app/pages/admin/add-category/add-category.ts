import { Component } from '@angular/core';
import { Material_Imports } from '../../../importMaterial';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Category } from '../../../service/category';
import { MatSnackBar } from '@angular/material/snack-bar';
import Swal from 'sweetalert2';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-category',
  imports: [
    CommonModule,
    FormsModule,
    Material_Imports
  ],
  templateUrl: './add-category.html',
  styleUrl: './add-category.css',
})
export class AddCategory {
  category={
    title:'',
    description:''
  }
  constructor(private _category:Category,private _snack:MatSnackBar,private _router:Router){}

  formSubmit(){
    if(this.category.title.trim() ==''||this.category.description.trim()==null){
             this._snack.open('Title is required','',{
              duration:3000
             })
    }
    //all done
    this._category.addCategory(this.category).subscribe(
      (data:any)=>{
        this.category.title=''
        this.category.description=''
        Swal.fire('Success','Category added successfully','success').then((e)=>{
         this._router.navigate(['/admin/categories'])
        })

      },
      (error)=>{
        console.log(error);
        Swal.fire('Error !!','Server error !!','error');
      }
    )
  }

}
