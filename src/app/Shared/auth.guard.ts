import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { UserLoginServiceService } from './user-login-service.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
  constructor(private userLoginService: UserLoginServiceService, private routes: Router) { }
  canActivate(): boolean {
    if (this.userLoginService.isLoggedIn()) {
      return true;
    } else {
      this.routes.navigate(['/login']);
      return false;
    }
  }

}


