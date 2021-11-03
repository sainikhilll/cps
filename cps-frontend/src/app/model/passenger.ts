import { User } from "./user";

export interface Passenger{
    id: number,
    name: string,
    mobileNumber: string,
    dateOfBirth: Date,
    user:User
}
    