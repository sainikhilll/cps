import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ApproveRideOwnerComponent } from './approve-ride-owner/approve-ride-owner.component';
import { BookRideComponent } from './book-ride/book-ride.component';
import { LoginComponent } from './login/login.component';
import { NavigationComponent } from './navigation/navigation.component';
import { PassengerChangePasswordComponent } from './passenger-change-password/passenger-change-password.component';
import { PassengerSignupComponent } from './passenger-signup/passenger-signup.component';
import { PublishTripComponent } from './publish-trip/publish-trip.component';
import { RideOwnerPreferencesComponent } from './ride-owner-preferences/ride-owner-preferences.component';
import { RideOwnerSignupComponent } from './ride-owner-signup/ride-owner-signup.component';
import { RideOwnerUpdateProfileComponent } from './ride-owner-update-profile/ride-owner-update-profile.component';
import { SearchTripComponent } from './search-trip/search-trip.component';
import { ViewPassengersComponent } from './view-passengers/view-passengers.component';
import { ViewRideOwnersComponent } from './view-ride-owners/view-ride-owners.component';

const routes: Routes = [
  {path:'ride-owner-signup', component:RideOwnerSignupComponent},
  {path:'login', component:LoginComponent},
  {path:'ride-owner-preferences', component: RideOwnerPreferencesComponent},
  {path:'ride-owner-update-profile', component: RideOwnerUpdateProfileComponent},
  {path:'publish-trip', component: PublishTripComponent},
  {path:'passenger-signup', component:PassengerSignupComponent},
  {path:'passenger-change-password', component:PassengerChangePasswordComponent},
  {path:'search-trip', component:SearchTripComponent},
  {path:'book-ride/:id', component: BookRideComponent},
  {path:'approve-ride-owner', component: ApproveRideOwnerComponent},
  {path:'view-ride-owners', component:ViewRideOwnersComponent},
  {path:'view-passengers', component: ViewPassengersComponent}
  //{path:'', redirectTo: "/login", pathMatch: 'full'}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
