import { Passenger } from "./passenger";
import { Trip } from "./trip";

export interface TripBooking{
    id:number,
    seatsBooked:number,
    trip:Trip,
    passenger:Passenger,
    status:string,
    ownerRatingPassenger:number,
    passengerRatingOwner:number,
    passengerReviewOwner:string

}