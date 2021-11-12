import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { OwnerPreferences } from '../model/owner-preference';
import { Owner } from '../model/owner';
import { Observable } from 'rxjs';
import { REST_URL } from './common';
import { LoginAuthService } from './login-auth.service.ts.service';


@Injectable({
  providedIn: 'root'
})
export class OwnerPreferenceService {
  
  url=REST_URL+"ownerpreferences";
  
  
  constructor(private _http:HttpClient, private loginAuthService: LoginAuthService) { }
  id:number=this.loginAuthService.user.id;
  
  public restPreference(preference:OwnerPreferences):Observable<any>{
    return this._http.put<any>(this.url,preference);

}
public getOwnerPreference():Observable<any>{
  return this._http.get<any>(REST_URL+"owners/preferences/"+this.loginAuthService.user.id);
}

}
