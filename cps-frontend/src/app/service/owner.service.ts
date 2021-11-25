
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { REST_URL } from './common';
import { LoginAuthService } from './login-auth.service.ts.service';
import { getLocaleWeekEndRange } from '@angular/common';
import { Observable, observable } from 'rxjs';
import { Owner } from '../model/owner';



@Injectable({
  providedIn: 'root'
})
export class OwnerService {
  url = REST_URL + "approvals";
  constructor(private _http: HttpClient, private loginAuthService: LoginAuthService) { }

  public restOwner(): Observable<any> {
    return this._http.get<any>(this.url);
  }

  public updateOwner(id: number): Observable<any> {
    return this._http.get<any>(REST_URL + "updates/" + id);
  }

  public rejectOwner(id: number): Observable<any> {
    return this._http.get<any>(REST_URL + "rejects/" + id);
  }

  public registerOwner(ownerData: Owner): Observable<any> {
    return this._http.put<any>(REST_URL + "owners", ownerData);
  }

  public getOwnerDetails(): Observable<any> {
    return this._http.get<any>(REST_URL + 'owners/user/' + this.loginAuthService.user.id);
  }

  public signup(owner: Owner): Observable<any> {
    const url = REST_URL + "owners";
    return this._http.post<any>(url, owner);
  }

  getOwners(): Observable<any> {
    return this._http.get(REST_URL + "owners");

  }

  public blackList(id: number): Observable<any> {
    return this._http.get<any>(REST_URL + "blackList/"+ id);
  }

  public undoBlackList(id:number): Observable<any>{
    return this._http.get<any>(REST_URL + "undoBlackList/"+ id);
  }
}