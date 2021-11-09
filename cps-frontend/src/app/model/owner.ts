import { OwnerPreferences } from "./owner-preference";
import { User } from "./user";

export interface Owner{
    name:string,
    address:string,
    mobile:number,
    licenseNumber:string,
    licenseUrl:string,
    aadharNumber:string,
    aadharUrl:string,
    user:User,
    ownerPreference:OwnerPreferences,
    status:string
}