import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Owner } from '../model/owner';
import { Observable } from 'rxjs';
import { REST_URL } from './common';

@Injectable({
  providedIn: 'root'
})
export class OwnerService {
url= REST_URL+"approvals";
  constructor(private _http:HttpClient) { }
  public restOwner():Observable<any>{
    return this._http.get<any>(this.url);
    
  }
  public updateOwner(id:number):Observable<any>{
    return this._http.get<any>(REST_URL+"approvals/updates/"+id);
  }
  public rejectOwner(id:number):Observable<any>{
    return this._http.get<any>(REST_URL+"approvals/rejects/"+id);
  }
  public registerOwner(ownerData: Owner): Observable<any>{
    return this._http.put<any>(REST_URL+"owners", ownerData);
  }

  public getOwnerDetails(): Observable<any>{
    return this._http.get<any>(REST_URL+"owners/" +3);
  }
}
