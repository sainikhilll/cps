import { OwnerPreferences } from "./owner-preference";
import { User } from "./user";

export interface Owner{
    name:string,
    address:string,
    mobile:string,
    licenceNumber:string,
    licenceUrl:string,
    aadharNumber:string,
    aadharUrl:string,
    user:User,
    ownerPreference:OwnerPreferences,
    status:string
}