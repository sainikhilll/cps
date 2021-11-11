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
  // ownerpreference!: OwnerPreferences;
  ownerPreferencess:OwnerPreferences[]|undefined;
  preferences:OwnerPreferences={
    id:0,
    music:"N",
    smoking:"N",
    petsAllowed:"N"
  }
  musicPref:boolean=false;
  smokingPref:boolean=false;
  petsPref:boolean=false;
  constructor(private _service:OwnerPreferenceService) { }

  ngOnInit(): void {
    this._service.getOwnerPreference().subscribe(
      data=>{
        this.preferences = data;
      }
    );

  }
  setPreference(){
    this._service.restPreference(this.preferences).subscribe(
      data=>{
        //this.preferences=data;
        console.log("saved");
      }
    );
  }

  musicChanged(){
    console.log(this.preferences);
    if(this.preferences.music=="Y") {
      this.preferences.music="N";
      this.musicPref=false;
    }
    else{
      this.preferences.music="Y";
      this.musicPref=true;
    }
    this.setPreference();
    
  }

  smokingChanged(){
    console.log(this.preferences);
    if(this.preferences.smoking=="Y") {
      this.preferences.smoking="N";
      this.smokingPref=false;
    }
    else{
      this.preferences.smoking="Y";
      this.smokingPref=true;
    }
    this.setPreference();
  }

  petsAllowedChanged(){
    console.log(this.preferences);
    if(this.preferences.petsAllowed=="Y") {
      this.preferences.petsAllowed="N";
      this.petsPref=false;
    }
    else{
      this.preferences.petsAllowed="Y";
      this.petsPref=true;
    }
    this.setPreference();
  }

}
