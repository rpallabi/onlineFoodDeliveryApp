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
import { PaymentComponent } from './payment/payment.component';
import { HomeComponent } from './home/home.component';
import { CartComponent } from './cart/cart.component';
import { OrdersDetailsComponent } from './orders-details/orders-details.component';
import { UserloginComponent } from './userlogin/userlogin.component';
import { RegisterComponent } from './register/register.component';
import { BookTableComponent } from './book-table/book-table.component';

const routes: Routes = [
  //{path:'home/:userId',component:HomeComponent},
  {path:'users', component:GetAllUserComponent,canActivate:[GuardServiceService]},
  {path:'create-users', component:CreateUsersComponent},
  {path:'login',component:LoginComponent},
  {path:'userlogin',component:UserloginComponent},
  {path:'register',component:RegisterComponent},
  //{path:'orders',component:OrdersComponent},
  {path:'adminlogin',component:AdminloginComponent},
  {path:'uploadfoods/:adminId',component:FoodComponent},
  {path:'uploadfoods',component:FoodComponent},
  //{path:'TableBooking/:userId',component:TableBookingComponent,canActivate:[AuthGuardService]},
  //{path:'orders/:userId',component:OrdersComponent},
  {path:'Payment',component:PaymentComponent},
  {path:'orders',component:OrdersComponent},
  {path:'orders/ordersDetails',component:OrdersDetailsComponent},
  {path:'cart',component:CartComponent}
  
 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
