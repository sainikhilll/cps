import { Owner } from "./owner";

export interface OwnerPreferences{
    id:number;
    music:string,
    smoking:string,
    petsAllowed:string,
    owner?:Owner
}