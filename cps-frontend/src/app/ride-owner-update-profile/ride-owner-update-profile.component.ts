import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Owner } from '../model/owner';
import { OwnerService } from '../service/owner.service';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-ride-owner-update-profile',
  templateUrl: './ride-owner-update-profile.component.html',
  styleUrls: ['./ride-owner-update-profile.component.css']
})
export class RideOwnerUpdateProfileComponent implements OnInit {
  alert: boolean = false
  register: Owner = {
    id: 0,
    name: "",
    address: "",
    mobile: "",
    licenceNumber: "",
    licenceUrl: "",
    aadharNumber: "",
    aadharUrl: "",
    user: {
      id: 0,
      email: "",
      password: "",
      role: ""
    },
    ownerPreference: {
      id: 0,
      music: "",
      smoking: "",
      petsAllowed: ""
    },
    status: ''
  }
  updateProfile = new FormGroup(
    {
      name: new FormControl('', [Validators.required, Validators.pattern("[A-Za-z ]{1,45}"),Validators.maxLength(45)]),
      address: new FormControl('', [Validators.required, Validators.maxLength(1000)]),
      mobile: new FormControl('', [Validators.required, Validators.minLength(10),Validators.maxLength(10)]),
      email: new FormControl('', [Validators.required, Validators.pattern("")]),
      licenceNumber: new FormControl('', [Validators.required, Validators.maxLength(30)]),
      aadharNumber: new FormControl('', [Validators.required, Validators.minLength(12),Validators.maxLength(12)])
    }
  )
  get form()
{
  return  this.updateProfile.controls;
}
  constructor(private ownerService: OwnerService) { }

  ngOnInit(): void {
    this.ownerService.getOwnerDetails().subscribe(
      data => {
        this.register = data;
      }
    )
  }

  updateOwner(): void {
    this.ownerService.registerOwner(this.register).subscribe(
      (resp) => {
        console.log(resp);
        this.alert = true
      },
      (err) => {
        console.log(err);
      }
    );
  }
}
