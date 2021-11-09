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
  owner : Owner = {
    "id" : 1,
    "name": "",
    "address": "",
    "mobile": "",
    "licenceNumber": "",
    "licenceUrl": "",
    "aadharNumber": "",
    "aadharUrl": "",
    "status": "pending",
    "user": {
      "id": 1,
      "email": "",
      "password": "",
      "role": "owner"
    },
     
  }  

ownersignup = new FormGroup(
{
    name: new FormControl('', [Validators.required]),
    address: new FormControl('',[Validators.required]),
    mobile: new FormControl('',[Validators.required,Validators.pattern("[1-9]{1}[0-9]{9}")]),
    licenceNumber: new FormControl('',[Validators.required]),
    licenceUrl: new FormControl('',[Validators.required]),
    aadharNumber: new FormControl('',[Validators.required]),
    aadharUrl: new FormControl('',[Validators.required])
})
    get name() {return this.ownersignup.get('name')}
    get address() {return this.ownersignup.get('address')}
    get mobile() {return this.ownersignup.get('mobile')}
    get licenceNumber() {return this.ownersignup.get('licenceNumber')}
    get licenceUrl() {return this.ownersignup.get('licenceUrl')}
    get aadharNumber() {return this.ownersignup.get('aadharNumber')}
    get aadharUrl() {return this.ownersignup.get('aadharUrl')}

    success : boolean = false;
    constructor( private ownerService:OwnerService,private router : Router) { }

    ngOnInit(): void {
    }
  
    postRegistration(){
    this.ownerService.signup(this.owner).subscribe(
      data=>{
        this.owner = data;
        console.log(this.owner);
      } 
    );
  }
}
  // signup():void {
   
  //   let observable : Observable<any> = this.ownerService.signup(this.owner);
  //   observable.subscribe(
  //     response => {
  //        this.success = true;
  //        this.owner.name="";
  //        this.owner.address="";
  //        this.owner.mobile=0;
  //        this.owner.licenseNumber=0;
  //        this.owner.licenseUrl="",
  //        this.owner.aadharNumber=0;
  //        this.owner.aadharUrl="";
  //        this.router.navigateByUrl('user');
  //     },
  //     error => {
  //       // this.error = error;
  //     }
       
  //   );
  // }


// function ngOnInit() {
//   throw new Error('Function not implemented.');
// }

