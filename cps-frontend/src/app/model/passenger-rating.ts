import { Passenger } from "./passenger";
import { Trip } from "./trip";

export interface PassengerRating{
    id:number;
    rating:number;
    trip:Trip;
    passenger:Passenger;
}