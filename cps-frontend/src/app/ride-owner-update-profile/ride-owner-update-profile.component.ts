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
  register: Owner = {
    id: 1,
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
      name: new FormControl('', [Validators.required, Validators.pattern("[A-Za-z ]{1,32}")]),
      address: new FormControl('', [Validators.required, Validators.pattern("")]),
      mobile: new FormControl('', [Validators.required, Validators.pattern(""), Validators.maxLength(10)]),
      licenceNumber: new FormControl('', [Validators.required, Validators.pattern("")]),
      licenceUrl: new FormControl('', [Validators.required, Validators.pattern("")]),
      aadharNumber: new FormControl('', [Validators.required, Validators.pattern("")]),
      aadharUrl: new FormControl('', [Validators.required, Validators.pattern("")])
    }
  )
  get name() { return this.updateProfile.get('name') }
  get address() { return this.updateProfile.get('address') }
  get mobile() { return this.updateProfile.get('mobile') }
  get licenceNumber() { return this.updateProfile.get('licenceNumber') }
  get licenceUrl() { return this.updateProfile.get('licenceUrl') }
  get aadharNumber() { return this.updateProfile.get('aadharNumber') }
  get aadharUrl() { return this.updateProfile.get('aadharUrl') }
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
      },
      (err) => {
        console.log(err);
      }
    );
  }
}
