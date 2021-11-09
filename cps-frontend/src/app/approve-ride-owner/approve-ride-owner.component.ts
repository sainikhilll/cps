import { Component, OnInit } from '@angular/core';
import { Owner } from '../model/owner';
import { OwnerService } from '../service/owner.service';

@Component({
  selector: 'app-approve-ride-owner',
  templateUrl: './approve-ride-owner.component.html',
  styleUrls: ['./approve-ride-owner.component.css']
})
export class ApproveRideOwnerComponent implements OnInit {
  owners:Owner[]|undefined;
  owner= {
    "id": 3,
   "name": "",
   "address": "",
   "mobile":0,
   "licenceNumber": "",
   "licenceUrl": "",
   "aadharNumber":"",
   "aadharUrl": "",
   "status": "Approved",
   "user": {
     "id": 0,
       "email": "",
       "password": "",
       "role": ""
   },
   "ownerPreference": {
     "id": 1,
       "music": "",
       "smoking": "",
       "petsAllowed": ""
   }
}
  constructor(private _service:OwnerService) { }

  ngOnInit(): void {
    this._service.restOwner().subscribe(
      data=> {
        this.owners=data;
        console.log(this.owners);
      }
    );
  }
 
  status(id : number){
this._service.updateOwner(id).subscribe(
  data=> {
    this.owners=data;
    this.ngOnInit();

  }
);
  }
  reject(id : number){
    this._service.rejectOwner(id).subscribe(
      data=> {
        this.owners=data;
        this.ngOnInit();

      }
    );
    
  }
}
