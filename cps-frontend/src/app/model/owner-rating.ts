import { Owner } from "./owner";
import { Passenger } from "./passenger";

export interface OwnerRating{
    id:number;
    rating:number;
    review:string;
    passenger:Passenger;
    owner:Owner
}