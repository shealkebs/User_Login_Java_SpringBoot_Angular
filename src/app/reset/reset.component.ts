import { Component, OnInit, Input } from '@angular/core';
import { UserLogin } from '../shared/UserLogin';
import { UserLoginServiceService } from '../Shared/user-login-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-reset',
  templateUrl: './reset.component.html',
  styleUrls: ['./reset.component.scss']
})
export class ResetComponent implements OnInit {
  @Input() username;
  status: any;
  error: boolean =false;
  userReset = new UserLogin();
  constructor(private userLoginService: UserLoginServiceService, private routes: Router) { }
  ResetUserPassword(userReset: UserLogin) {
    this.userLoginService.ResetUser(this.userReset).subscribe((res) => {
      this.status = res;
      if (this.status) {
        console.log(this.status);
        this.routes.navigate(['/login']);
      }
    },
    (err) => {
      this.error = err; 
      if(this.error)
      this.error=true;
    })
  }
  ngOnInit() {
  }

}
