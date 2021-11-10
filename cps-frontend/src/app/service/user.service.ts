import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient} from '@angular/common/http';

import { User } from '../model/user';
import { REST_URL } from './common';

@Injectable({
  providedIn: 'root'
})



export class UserService {
  PasswordUrl : string = REST_URL+"authenticate/";
  constructor(private httpClient:HttpClient) { }


  onSubmit(user : User,np:string) : Observable<any> { 
    const headers = {'content-type':'application/json'};
    return this.httpClient.put<any>(
      this.PasswordUrl+np,user,{'headers':headers}
    );
    

  }
  user: User = {  
    id: 0,
    email: '',
    password: '',
    role: ''
  }


}
