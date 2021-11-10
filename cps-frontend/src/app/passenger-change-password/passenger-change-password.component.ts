import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Observable } from 'rxjs';


import { User } from '../model/user';
import { UserService } from '../service/user.service';
@Component({
  selector: 'app-passenger-change-password',
  templateUrl: './passenger-change-password.component.html',
  styleUrls: ['./passenger-change-password.component.css']
})
export class PassengerChangePasswordComponent implements OnInit {
  regArry:any={}
  reactiveform!:FormGroup;
  registerArray:any={}
  passwordPtn=""



  user : User = {
    id : 0,
    email : "",
    password : "",
    role:""
  }
  success: boolean = false;

  np:string="";


  constructor(private userService:UserService) { }

  ngOnInit(): void {
  }
  
  onSubmit():void{
    let observable : Observable<any> = this.userService.onSubmit(this.user,this.np);
    alert("sucessfully updated password")

    observable.subscribe( 
      response => {
        console.log("in update response");
        this.success = true;

      }
    ) 
  }
   pwdSubmit(){
  }
  
  }


  
  


  


