import { OwnerPreferences } from "./owner-preference";
import { User } from "./user";

export interface Owner {
    id: number,
    name: string,
    address: string,
    mobile: string,
    licenceNumber: string,
    licenceUrl: string,
    aadharNumber: string,
    aadharUrl: string,
    user: User,
    ownerPreference: OwnerPreferences,
    status: string
}