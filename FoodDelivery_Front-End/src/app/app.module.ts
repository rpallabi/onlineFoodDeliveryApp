import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule } from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { GetAllUserComponent } from './get-all-user/get-all-user.component';
import { CreateUsersComponent } from './create-users/create-users.component';
import { FormsModule } from '@angular/forms';
import { LoginComponent } from './login/login.component';
import { OrdersComponent } from './orders/orders.component';
import { AdminloginComponent } from './adminlogin/adminlogin.component';
import { FoodComponent } from './food/food.component';
import { TableBookingComponent } from './table-booking/table-booking.component';
import { PaymentComponent } from './payment/payment.component';
import { HomeComponent } from './home/home.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { AboutComponent } from './about/about.component';
import { ContactComponent } from './contact/contact.component';
import { FooterComponent } from './footer/footer.component';
import { MenuComponent } from './menu/menu.component';
import { CartComponent } from './cart/cart.component';
import { OrdersDetailsComponent } from './orders-details/orders-details.component';
import { RegisterComponent } from './register/register.component';
import { UserloginComponent } from './userlogin/userlogin.component';
import { BookTableComponent } from './book-table/book-table.component';

@NgModule({
  declarations: [
    AppComponent,
    GetAllUserComponent,
    CreateUsersComponent,
    LoginComponent,
    OrdersComponent,
    AdminloginComponent,
    FoodComponent,
    TableBookingComponent,
    PaymentComponent,
    HomeComponent,
    NavBarComponent,
    AboutComponent,
    ContactComponent,
    FooterComponent,
    MenuComponent,
    CartComponent,
    OrdersDetailsComponent,
    RegisterComponent,
    UserloginComponent,
    BookTableComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    FormsModule
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
