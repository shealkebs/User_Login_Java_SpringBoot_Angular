import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { ResetComponent } from './reset/reset.component';
import { AuthGuard } from './Shared/auth.guard';


const routes: Routes = [
  {path:'login' , component: LoginComponent},
  {path: 'home' , component: HomeComponent,
canActivate: [AuthGuard]},
  {path: 'reset', component: ResetComponent},
  {
    path:'',redirectTo:'/login',
    pathMatch: 'full'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
