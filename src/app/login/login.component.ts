import { Component, OnInit } from '@angular/core';
import { UserLogin } from '../shared/UserLogin';

import { NgForm } from '@angular/forms'
import { format } from 'url';
import { UserLoginServiceService } from '../Shared/user-login-service.service';
import { Router } from '@angular/router';




@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  userLogin = new UserLogin();
  ResponseData: any;
  error: boolean = false;
  constructor(private userLoginService: UserLoginServiceService, private routes: Router) { }
  loginUser() {
    this.userLoginService.loginUser(this.userLogin).subscribe(
      (res) => {
        this.ResponseData = res;
        sessionStorage.setItem('user', this.ResponseData.userName);
        console.log(this.ResponseData);
        if (this.ResponseData) {
          this.routes.navigate(['/home']);
        }
      },
      (err) => {
        this.error = err;
        if (this.error)
          this.error = true;
      }
    )
  }

  ngOnInit() {
  }

}
