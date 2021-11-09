import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { OwnerPreferences } from '../model/owner-preference';
import { Owner } from '../model/owner';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OwnerPreferenceService {
  url="http://localhost:8080/ownerpreferences";
  
  
  constructor(private _http:HttpClient) { }
  // public restPreference(preference:OwnerPreferences):Observable<any>{
  //   return this._http.post<any>(this.url, preference);
  // }

  public restPreference(preference:OwnerPreferences):Observable<any>{
    return this._http.post<any>(this.url,preference);

}

}
