import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
import { Owner } from '../model/owner';
import { OwnerService } from '../service/owner.service';
import { UserService } from '../service/user.service';
import { FormControl, FormGroup, Validators } from '@angular/forms';



@Component({
  selector: 'app-ride-owner-signup',
  templateUrl: './ride-owner-signup.component.html',
  styleUrls: ['./ride-owner-signup.component.css']
})
export class RideOwnerSignupComponent implements OnInit {
  owner: Owner = {
    id: 0,
    name: "",
    address: "",
    mobile: "",
    licenceNumber: "",
    licenceUrl: "",
    aadharNumber: "",
    aadharUrl: "",
    status: "Pending",
    user: {
      id: 0,
      email: "",
      password: "",
      role: "owner",
      blacklisted: "N"
    },
    ownerPreference: {
      id: 0,
      music: "N",
      smoking: "N",
      petsAllowed: "N"
    }
  }

  ownersignup = new FormGroup(
    {
      name: new FormControl('', [Validators.required,Validators.pattern("^[a-zA-Z\\s]*$")]),
      address: new FormControl('', [Validators.required]),
      mobile: new FormControl('', [Validators.required, Validators.pattern("[123456789][0-9]{9}")]),
      licenceNumber: new FormControl('', [Validators.required,Validators.maxLength(30)]),
      licenceUrl: new FormControl('', [Validators.required]),
      aadharNumber: new FormControl('', [Validators.required,Validators.pattern("[0123456789][0-9]{11}")]),
      aadharUrl: new FormControl('', [Validators.required]),
      email: new FormControl('',[Validators.required,Validators.email]),
      password: new FormControl('',[Validators.required,Validators.pattern("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$")])
    })
get f()
{
  return  this.ownersignup.controls;
}

alert:boolean=false
  constructor(private ownerService: OwnerService, private router: Router) { }

  ngOnInit(): void {
  }

  postRegistration() {
    this.ownerService.signup(this.owner).subscribe(
      data => {
        this.owner = data;
        console.log(this.owner);
      }
    );

  }

  signup(): void {
    console.log(this.owner);
    let observable: Observable<any> = this.ownerService.signup(this.owner);
    console.log(observable);
    observable.subscribe(
      response => {
        this.alert=true
        this.ownersignup.reset({})
      })
  }
}



