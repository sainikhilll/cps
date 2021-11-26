
import { Passenger } from "./passenger";
import { Trip } from "./trip";

export interface OwnerRating{
    id:number;
    rating:number;
    review:string;
    passenger:Passenger;
    trip:Trip
}