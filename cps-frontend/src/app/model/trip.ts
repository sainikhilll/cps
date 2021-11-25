import { Owner } from "./owner";

export interface Trip {​​​​​​​
    id: number;
    origin: string,
    destination: string,
    departureTime: string,
    price: number,
    date: string,
	owner: Owner,
    numberOfPassengers: number,    
    numberOfSeatsAvailable: number,
    carType: string,
    status:string    
}​​​​​​​
