import { Component, OnInit } from '@angular/core';
import { Trip } from '../model/trip';
import { AdminCancelRidesService } from '../service/admin-cancel-rides.service';
import { AdminViewRidesService } from '../service/admin-view-rides.service';

@Component({
  selector: 'app-admin-view-rides',
  templateUrl: './admin-view-rides.component.html',
  styleUrls: ['./admin-view-rides.component.css']
})
export class AdminViewRidesComponent implements OnInit {
  trips :any ={
    "id": 0,
    "origin": "",
    "destination": "",
    "departureTime": "",
    "price":0,
    "date": "",
    "numberOfPassengers": 0,
    "numberOfSeatsAvailable": 0,
    "carType": "",
    "owner": {
        "id": 0,
        "name": "",
        "address": "",
        "mobile": "",
        "licenceNumber": "",
        "licenceUrl": "",
        "aadharNumber": "",
        "aadharUrl": "",
        "status": "",
        "user": {
            "id": 0,
            "email": "",
            "password": "",
            "role": "",
            "blacklisted": ""
        },
        "ownerPreference": {
            "id": 0,
            "music": "",
            "smoking": "",
            "petsAllowed": ""
        }
    },
    "status": ""
}

currentDate = new Date();



  constructor(private _service:AdminViewRidesService) { }

  ngOnInit(): void {
    this._service.restTrips().subscribe(
      data => {
        this.trips=data;
      }
    );
  }


  changeStatus(id: number){
    this._service.restStatus(id).subscribe(
      data=>{
        console.log(id);
        console.log("cancelled");
        this.ngOnInit();
      }
    )
  }

}
