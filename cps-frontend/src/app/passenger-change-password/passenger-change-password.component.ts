import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { FormControl, FormGroup, Validators } from '@angular/forms';


import { User } from '../model/user';
import { UserService } from '../service/user.service';
@Component({
  selector: 'app-passenger-change-password',
  templateUrl: './passenger-change-password.component.html',
  styleUrls: ['./passenger-change-password.component.css']
})
export class PassengerChangePasswordComponent implements OnInit {
  error_messages = {
    

    'np1': [
      { type: 'required', message: 'New password is required.' },
      { type: 'minlength', message: 'password length.' },
      { type: 'maxlength', message: 'password length.' }
    ],
    'np2': [
      { type: 'required', message: 'Confirm Password is required.' },
      { type: 'minlength', message: 'password length.' },
      { type: 'maxlength', message: 'password length.' }
    ],
  }

  



  user : User = {
    id : 0,
    email : "",
    password : "",
    role:""
    
  }
  success: boolean = false;
  error !: HttpErrorResponse;
  fail : boolean = false;




  np:string="";
  constructor(private userService:UserService) { }


  updatepassword = new FormGroup(
    {
      password: new FormControl('', [Validators.required ]),
      np1: new FormControl('', [Validators.required, Validators.minLength(6),
        Validators.maxLength(30)]),
      np2: new FormControl('', [Validators.required,Validators.minLength(6),
        Validators.maxLength(30)]),


    }


    )
   
get password(){return this.updatepassword.get('password')}
get np1(){return this.updatepassword.get('np1')}
get np2(){return this.updatepassword.get('np2')}





  ngOnInit(): void {
  }
  
  onSubmit():void{
    let observable : Observable<any> = this.userService.onSubmit(this.user,this.np);

    observable.subscribe( 
      response => {
        console.log("in update response");
        this.success = true;
        this.updatepassword.reset();
       },
       error => {
        this.fail = true;
        this.updatepassword.reset();

        console.log(error);

      }

    ) 
  }
   
  
  }


  
  


  

