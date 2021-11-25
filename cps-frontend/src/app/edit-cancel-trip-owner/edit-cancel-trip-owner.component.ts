import { Component, OnInit } from '@angular/core';
import { Trip } from '../model/trip';
import { EditCancelTripOwnerService } from '../service/edit-cancel-trip-owner.service';
import { NgForm } from '@angular/forms';
import { FormGroup} from '@angular/forms';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-edit-cancel-trip-owner',
  templateUrl: './edit-cancel-trip-owner.component.html',
  styleUrls: ['./edit-cancel-trip-owner.component.css']
})
export class EditCancelTripOwnerComponent implements OnInit {
  alert : boolean = false;
  trip : any= {
    "id": 0,
    "origin": "",           
    "destination": "",
    "departureTime": "",
    "price": 0.0,
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

  constructor(private _service : EditCancelTripOwnerService, private route : ActivatedRoute) { }



  ngOnInit(): void {
    this._service.getTripDetail(this.trip).subscribe(
      data => {
        this.trip = data;
        
        console.log(this.trip);

      }
    );
    let idd : any = this.route.snapshot.paramMap.get('id');
    this.trip.trip.id=idd;
    let resp = this._service.getTripDetail(idd);
    resp.subscribe((data) => this.trip = data);
    
  }

  changeTrip(){
    this._service.restTrip(this.trip).subscribe(
      (resp) => {
        console.log(resp);
        this.alert = true;
      }
    );
  }

}
