import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
import { Owner } from '../model/owner';
import { OwnerService } from '../service/owner.service';
import { UserService } from '../service/user.service';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import Swal from 'sweetalert2';


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
      role: "owner"
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
      licenceNumber: new FormControl('', [Validators.required,Validators.pattern("^(([A-Z]{2}[0-9]{2})( )|([A-Z]{2}-[0-9]{2}))((19|20)[0-9][0-9])[0-9]{7}$")]),
      licenceUrl: new FormControl('', [Validators.required]),
      aadharNumber: new FormControl('', [Validators.required,Validators.pattern("^[2-9]{1}[0-9]{3}\\-[0-9]{4}\\-[0-9]{4}$")]),
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
        // this.alert=true
        Swal.fire({
          position: 'top-end',
          icon: 'success',
          title: 'Your data has been entered successfully Go to Login Page.',
          showConfirmButton: false,
          timer: 3500
        })
        this.ownersignup.reset({})
      })
  }
}




