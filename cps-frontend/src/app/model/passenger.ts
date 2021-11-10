import { User } from "./user";

export interface Passenger{
    id: number,
    name: string,
    mobileNumber: string,
    dateOfBirth: string,
    user:User
}
    