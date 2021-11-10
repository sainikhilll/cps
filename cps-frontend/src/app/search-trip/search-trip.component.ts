import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Trip } from '../model/trip';
import { TripService } from '../service/trip.service';
import { Owner } from '../model/owner';
@Component({
  selector: 'app-search-trip',
  templateUrl: './search-trip.component.html',
  styleUrls: ['./search-trip.component.css']
})
export class SearchTripComponent implements OnInit {

  flash = false;

  trips!: Trip[];

  trip = {
    "id": 1,
    "origin": "",
    "destination": "",
    "departureTime": "",
    "price": 0,
    "date": "",
    "numberOfPassengers": 0,
    "numberOfSeatsAvailable": 0,
    "carType": "",
    "owner": {
      "id": 2,
      "name": "",
      "address": "",
      "mobile":"",
      "licenceNumber": "",
      "licenceUrl": "",
      "aadharNumber": "",
      "aadharUrl": "",
      "status": "",
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

  }

  city: string[] = [];
  temp_org: string[] = [];
  temp_des:string[]=[];




  constructor(private _service: TripService) {

  }

  ngOnInit(): void {
    this._service.getApi().subscribe(
      data => {
        this.city = data.data;
        console.log(this.city);
      });

  }

  sendOrigin(): void {
    console.log("hello");
    if (this.trip.origin.length >= 3) {
      this.temp_org = [];
      for (let x of this.city) {
        if (x.toLowerCase().indexOf(this.trip.origin.toLowerCase()) != -1) {
          this.temp_org.push(x);
        }
      }
      console.log(this.temp_org);
    }

  }


  sendDestination(): void {
    console.log("hello");
    if (this.trip.destination.length >= 3) {
      this.temp_des = [];
      for (let x of this.city) {
        if (x.toLowerCase().indexOf(this.trip.destination.toLowerCase()) != -1) {
          this.temp_des.push(x);
        }
      }
      console.log(this.temp_des);
    }

  }
  clickOrigin(tem:string){
    this.trip.origin=tem;
    this.temp_org=[];

  }

  clickdestination(tem:string){
    this.trip.destination=tem;
    this.temp_des=[];

  }









  searchTrips() {
    this._service.trips(this.trip).subscribe(
      (data) => {
        this.trips = data;
        this.flash = true;
        console.log(this.trips);

      });
  }

  seats() {
    this.trips.sort((a, b) => a.numberOfSeatsAvailable - b.numberOfSeatsAvailable);

    console.log(this.trips);

  }

  pricelow() {
    this.trips.sort((a, b) => a.price - b.price);

    console.log(this.trips);

  }
  priceHigh() {
    this.trips.sort((a, b) => b.price - a.price);

    console.log(this.trips);

  }

  depature() {
    this.trips.sort((a, b) => a.departureTime.localeCompare(b.departureTime));

    console.log(this.trips);
  }


}

