import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule} from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RideOwnerSignupComponent } from './ride-owner-signup/ride-owner-signup.component';
import { LoginComponent } from './login/login.component';
import { RideOwnerPreferencesComponent } from './ride-owner-preferences/ride-owner-preferences.component';
import { RideOwnerUpdateProfileComponent } from './ride-owner-update-profile/ride-owner-update-profile.component';
import { PublishTripComponent } from './publish-trip/publish-trip.component';
import { PassengerSignupComponent } from './passenger-signup/passenger-signup.component';
import { PassengerChangePasswordComponent } from './passenger-change-password/passenger-change-password.component';
import { SearchTripComponent } from './search-trip/search-trip.component';
import { BookRideComponent } from './book-ride/book-ride.component';
import { ApproveRideOwnerComponent } from './approve-ride-owner/approve-ride-owner.component';
import { ViewRideOwnersComponent } from './view-ride-owners/view-ride-owners.component';
import { ViewPassengersComponent } from './view-passengers/view-passengers.component';
import { NavigationComponent } from './navigation/navigation.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    AppComponent,
    RideOwnerSignupComponent,
    LoginComponent,
    RideOwnerPreferencesComponent,
    RideOwnerUpdateProfileComponent,
    PublishTripComponent,
    PassengerSignupComponent,
    PassengerChangePasswordComponent,
    SearchTripComponent,
    BookRideComponent,
    ApproveRideOwnerComponent,
    ViewRideOwnersComponent,
    ViewPassengersComponent,
    NavigationComponent,
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
