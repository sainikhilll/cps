import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Owner } from '../model/owner';
import { OwnerPreferences } from '../model/owner-preference';
import { OwnerPreferenceService } from '../service/owner-preference.service';

@Component({
  selector: 'app-ride-owner-preferences',
  templateUrl: './ride-owner-preferences.component.html',
  styleUrls: ['./ride-owner-preferences.component.css']
})
export class RideOwnerPreferencesComponent implements OnInit {
  ownerpreference!: OwnerPreferences;
  preferences={
    "id":7,
    "music":"",
    "smoking":"",
    "petsAllowed":""
  }
  constructor(private _service:OwnerPreferenceService) { }

  ngOnInit(): void {
  }
  setPreference(){
    this._service.restPreference(this.preferences).subscribe(
      data=>{
        this.preferences=data;
        console.log("saved");
      }
    );
  }
}
