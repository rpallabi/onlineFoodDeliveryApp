import { Component,OnInit } from '@angular/core';
import {Router} from '@angular/router'
import { User } from '../user';
import { UserService } from '../user.service';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{
  user : User = new User();
  email: string = '';
  password: string = '';
  loginError: string = '';
constructor(private userService : UserService, private router:Router){
}
ngOnInit(): void {
    
}
login(): void {
  this.userService.login(this.email, this.password).subscribe(
    (success) => {
      if (success) {
        
      
       this.router.navigate(['/TableBooking']);
      } else {
        
        this.loginError = 'Invalid username or password';
      }
    }
  );
}
}
  
  

