import { Component,OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router'
import { User } from '../user';
import { UserService } from '../user.service';
//import { FormGroup } from '@angular/forms';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-adminlogin',
  templateUrl: './adminlogin.component.html',
  styleUrls: ['./adminlogin.component.css']
})
export class AdminloginComponent implements OnInit{
  
/*
  user : User = new User();
  email: string = '';
  password: string = '';
  AdminloginError: string = '';
  adminId!: string | null;
  
constructor(private userService : UserService, private router:Router,private route: ActivatedRoute){

}
ngOnInit(): void {
  
    }

adminlogin(): void {
  this.userService.adminlogin(this.email, this.password)
    .subscribe((result: { adminId: string | null, adminLoggedIn: boolean }) => {
      if (result.adminLoggedIn) {

        this.adminId = result.adminId; 
        console.log('AdminID:', this.adminId);
        this.router.navigate(['/uploadfoods',this.adminId]);

      } else {
        this.AdminloginError = 'Invalid username or password';
        console.log('Invalid credentials. Please try again.');
        
      }
    });
}

adminlogout(): void {
}
*/
showModalAdminLogin: boolean = false;
  submitted = false;
  registerForm!: FormGroup;

  user: User = new User();
  email: string = '';
  password: string = '';
  AdminloginError: string = '';
  adminId!: string | null;

  constructor(private userService: UserService, private router: Router, private route: ActivatedRoute) {

  }
  show() {
    this.showModalAdminLogin = true; // Show-Hide Modal Check
  }
  //Bootstrap Modal Close event
  hide() {
    this.showModalAdminLogin = false;
    this.router.navigate(['/']);
    console.log("Window hidden");

  }
  ngOnInit(): void {
    this.show();
  }
  adminlogin(): void {
    this.userService.adminlogin(this.email, this.password)
      .subscribe((result: { adminId: string | null, adminLoggedIn: boolean }) => {
        if (result.adminLoggedIn) {

          this.adminId = result.adminId;
          console.log('AdminID:', this.adminId);
         // this.router.navigate(['/uploadfoods', this.adminId]);
          //this.showModalAdminLogin = false;
          if (this.adminId !== null) {
            localStorage.setItem('adminId', this.adminId);
            
            }
            alert("Success");
            this.showModalAdminLogin = false;
            
            //this.router.navigate(['/home',this.userId]);
            //localStorage.removeItem('userId');
          this.router.navigate(['/uploadfoods']).then(() => {
            window.location.reload();
          });
    

        } else {
          this.AdminloginError = 'Invalid username or password';
          console.log('Invalid credentials. Please try again.');

        }
      });
  }

  adminlogout(): void {
  }
}
