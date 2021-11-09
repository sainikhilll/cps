import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Trip } from '../model/trip';
import { TripService } from '../service/trip.service';

@Component({
  selector: 'app-publish-trip',
  templateUrl: './publish-trip.component.html',
  styleUrls: ['./publish-trip.component.css']
})
export class PublishTripComponent implements OnInit {
  trip: Trip = {
    id: 0,
    origin: "",
    destination: "",
    departureTime: "",
    price: 0,
    date: "",
    owner: {
      id: 3,
      name: "",
      address: "",
      mobile: 0,
      licenseNumber: 0,
      licenseUrl: "",
      aadharNumber: 0,
      aadharUrl: "",
      user:{
        id: 0,
        email: "",
        password: "",
        role: ""
      },
      ownerPreference:{
        id: 0,
        music: "",
        smoking: "",
        petsAllowed: ""
      },
      status: ""
    },
    numberOfPassengers: 0,
    numberOfSeatsAvailable: 0,
    carType: ""
  }
  success: boolean = false;
  constructor(private tripService: TripService) { }
  city: string[] = [];
  origin_temp: string[] = [];
  destination_temp: string[] = [];

  ngOnInit(): void {
    this.tripService.getApi().subscribe(
      data => {
        this.city = data.data;
        console.log(this.city);
      });
  }
  sendData(): void {
    console.log("hello");
    if(this.trip.origin.length >= 3){
      this.origin_temp =[];
      for(let x of this.city){
        if(x.toLowerCase().indexOf(this.trip.origin.toLowerCase()) != -1){
          this.origin_temp.push(x);
        }
      }
      console.log(this.origin_temp);
    }
  }

  getDestination(): void{
    if(this.trip.destination.length >= 3) {
      this.destination_temp = [];
      for(let x of this.city){
        if(x.toLowerCase().indexOf(this.trip.destination.toLowerCase()) != -1){
          this.destination_temp.push(x);
        }
      }
      console.log(this.destination_temp);
    }
  }
  clickOrigin(item: string){
    this.trip.origin = item;
    this.origin_temp = [];
  }
  clickDestination(item: string){
    this.trip.destination = item;
    this.destination_temp = [];
  }
  
  publish(): void{
    console.log(this.trip);
    let observable : Observable<any> = this.tripService.publish(this.trip);
    observable.subscribe(
      response => {
        this.success = true;
      },
    )
  };

}
