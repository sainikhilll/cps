import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

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
import { ReactiveFormsModule} from '@angular/forms';
import { FormsModule } from '@angular/forms';
import { OwnerNotificationComponent } from './owner-notification/owner-notification.component';
import { PassengerRatingComponent } from './passenger-rating/passenger-rating.component';
import { EditCancelTripOwnerComponent } from './edit-cancel-trip-owner/edit-cancel-trip-owner.component';
import { OwnerViewRatingsComponent } from './owner-view-ratings/owner-view-ratings.component';
import { PassengerNotificationsComponent } from './passenger-notifications/passenger-notifications.component';
import { PassengerCancelTripComponent } from './passenger-cancel-trip/passenger-cancel-trip.component';
import { PassengerReviewRateComponent } from './passenger-review-rate/passenger-review-rate.component';
import { AdminViewRidesComponent } from './admin-view-rides/admin-view-rides.component';
import { AdminCancelRideComponent } from './admin-cancel-ride/admin-cancel-ride.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';



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
    OwnerNotificationComponent,
    PassengerRatingComponent,
    EditCancelTripOwnerComponent,
    OwnerViewRatingsComponent,
    PassengerNotificationsComponent,
    PassengerCancelTripComponent,
    PassengerReviewRateComponent,
    AdminViewRidesComponent,
    AdminCancelRideComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    FormsModule,
    NgbModule
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
