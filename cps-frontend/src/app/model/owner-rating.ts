import { Owner } from "./owner";
import { Passenger } from "./passenger";

export interface OwnerRating{
    id:number;
    rating:string;
    review:string;
    passenger:Passenger;
    owner:Owner
}