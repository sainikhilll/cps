import { OwnerPreferences } from "./owner-preference";
import { User } from "./user";

export interface Owner{
    id: number,
    name:string,
    address:string,
    mobile:number,
    licenseNumber:number,
    licenseUrl:string,
    aadharNumber:number,
    aadharUrl:string,
    user:User,
    ownerPreference:OwnerPreferences,
    status:string
}