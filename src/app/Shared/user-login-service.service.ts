import { Injectable } from '@angular/core';


import { NgForm } from '@angular/forms'
import { format } from 'url';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';
import { UserLogin } from './UserLogin';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

const httpheader = {
  headders: new HttpHeaders({ 'content -type': 'application/json' })
}
@Injectable({
  providedIn: 'root'
})
export class UserLoginServiceService {

  constructor(private http: HttpClient) { }

  loginUser(userLogin: UserLogin): Observable<UserLogin[]> {

    let subUrl = `${environment.baseUrl}`;
    if (userLogin.userName != undefined && userLogin.userPassword != undefined) {
      subUrl = `${subUrl}loginUser`;
    }
    return this.http.post<UserLogin[]>(subUrl, userLogin);
  }

  ResetUser(userReset: UserLogin): Observable<UserLogin[]> {
    let subUrl = `${environment.baseUrl}updateUser`;
    return this.http.put<UserLogin[]>(subUrl, userReset);
  }
  isLoggedIn() {
    return !!sessionStorage.getItem('user');
  }
  getToken() {
    sessionStorage.getItem('user');    
  }
}
