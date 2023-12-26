import { Component,OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router'
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
  userId!: string | null;
  

constructor(private userService : UserService, private router:Router,private route: ActivatedRoute){
}
ngOnInit(): void {
    
}
/*
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
*/

login(): void {
  this.userService.login(this.email, this.password)
    .subscribe((result: { userId: string | null, loggedIn: boolean }) => {
      if (result.loggedIn) {

        this.userId = result.userId; 
        console.log('UserID:', this.userId);
        alert("Success");
        this.router.navigate(['/TableBooking',this.userId]);

      } else {
        this.loginError = 'Invalid username or password';
        alert("Invalid credentials. Please try again.");
        console.log('Invalid credentials. Please try again.');
        
      }
    });
}

}
