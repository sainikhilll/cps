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
  alert: boolean = false
  passenger: Passenger = {
    id: 0,
    name: "",
    mobileNumber: "",
    dateOfBirth: "",
    user: {
      id: 0,
      email: "",
      password: "",
      role: "passenger",
      blacklisted: "N"
    }
  }

  addRestto: any;

  constructor(private passengerService: PassengerService, private _router: Router) { }

  ngOnInit(): void {

  }
  signup(): void {

    let observable: Observable<any> = this.passengerService.signup(this.passenger);
    observable.subscribe(data => {
      console.log(data);
      /*  this._router.navigate(['login']); */
      this.alert = true
    })

  }



}

