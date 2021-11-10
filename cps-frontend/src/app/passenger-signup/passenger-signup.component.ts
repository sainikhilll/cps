import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Passenger } from '../model/passenger';
import { PassengerService } from '../service/passenger.service';

@Component({
  selector: 'app-passenger-signup',
  templateUrl: './passenger-signup.component.html',
  styleUrls: ['./passenger-signup.component.css']
})
export class PassengerSignupComponent implements OnInit {
 
 

 passenger :Passenger={
  id: 0,
  name: "",
  mobileNumber: "",
  dateOfBirth: "" ,
  user:{id: 0,
    email: "",
    password:"",
    role:""	

  }
}
passengersignup = new FormGroup(
  {
    name: new FormControl('',[ Validators.required,Validators.pattern("[A-Za-z ]{1,32}")]),
    email: new FormControl('', [Validators.required, Validators.pattern("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{1,63}$")]),
    password: new FormControl('', [Validators.required]),
    mobileNumber: new FormControl('', [Validators.required, Validators.pattern("[1-9]{1}[0-9]{9}"), Validators.maxLength(10)]),
    dateOfBirth : new FormControl('',[Validators.required])
 
  }
)

  
  get name(){return this.passengersignup.get('name')}
  get email(){return this.passengersignup.get('email')}
  get password(){return this.passengersignup.get('password')}
  get mobileNumber(){return this.passengersignup.get('mobileNumber')}
  get dateOfBirth(){return this.passengersignup.get('dateOfBirth')}


  constructor(private passengerService: PassengerService, private _router:Router) {}

  ngOnInit(): void {

  }
  signup():void {
   
    let observable : Observable<any> = this.passengerService.signup(this.passenger);
    observable.subscribe(data => {console.log(data);
      this._router.navigate(['login']);
    })
    
}
     
     
        
  }

