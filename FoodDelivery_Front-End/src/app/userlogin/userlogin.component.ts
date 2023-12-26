import { Component,OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';
import { User } from '../user';
import { UserService } from '../user.service';
@Component({
  selector: 'app-userlogin',
  templateUrl: './userlogin.component.html',
  styleUrls: ['./userlogin.component.css']
})
export class UserloginComponent implements OnInit{
  user : User = new User();
  email: string = '';
  password: string = '';
  loginError: string = '';
  userId!: string | null;

  showModal: boolean = false;
  registerForm!: FormGroup;
  submitted = false;
  constructor(private userService : UserService,private formBuilder: FormBuilder,private activatedRoute: ActivatedRoute,private router: Router) {  }
  show() {
    this.showModal = true; // Show-Hide Modal Check

  }
  //Bootstrap Modal Close event
  hide() {
    this.showModal = false;
    this.router.navigate(['/']);
    console.log("Window hidden");
    
  }
  ngOnInit() {
    this.show();
    this.registerForm = this.formBuilder.group({
      email: '',
      password: ''
    });
  }
  // convenience getter for easy access to form fields
  get f() { return this.registerForm.controls; }

  login() {
    
      this.userService.login(this.email, this.password)
    .subscribe((result: { userId: string | null, loggedIn: boolean }) => {
      if (result.loggedIn) {

        this.userId = result.userId; 
        console.log('UserID:', this.userId);

        if (this.userId !== null) {
        localStorage.setItem('userId', this.userId);
        }
        alert("Success");
        this.showModal = false;
        
        //this.router.navigate(['/home',this.userId]);
        //localStorage.removeItem('userId');
      this.router.navigate(['/']).then(() => {
        window.location.reload();
      });

      } else {
        this.loginError = 'Invalid username or password';
        alert("Invalid credentials. Please try again.");
        console.log('Invalid credentials. Please try again.');
        
      }
    });
      
    }
/*
    logout() {
      this.userService.logout();
      localStorage.removeItem('userId');
      this.router.navigate(['/']).then(() => {
        window.location.reload();
      });
    }
  */
}
