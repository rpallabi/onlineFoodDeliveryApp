import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { GetAllUserComponent } from './get-all-user/get-all-user.component';
import { AppComponent } from './app.component';
import { CreateUsersComponent } from './create-users/create-users.component';
import { combineLatest } from 'rxjs';
import { LoginComponent } from './login/login.component';
import { OrdersComponent } from './orders/orders.component';
import { AuthGuardService } from './auth-guard.service';
import { AdminloginComponent } from './adminlogin/adminlogin.component';
import { GuardServiceService } from './guard-service.service';
import { FoodComponent } from './food/food.component';
import { TableBookingComponent } from './table-booking/table-booking.component';

const routes: Routes = [
  {path:'users', component:GetAllUserComponent,canActivate:[GuardServiceService]},
  {path:'create-users', component:CreateUsersComponent},
  {path:'login',component:LoginComponent},
  {path:'orders',component:OrdersComponent},
  {path:'adminlogin',component:AdminloginComponent},
  {path:'uploadfoods/:adminId',component:FoodComponent},
  {path:'TableBooking',component:TableBookingComponent,canActivate:[AuthGuardService]}
 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
