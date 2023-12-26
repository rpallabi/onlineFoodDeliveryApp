import { Component,OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';

import { User } from '../user';
import { UserService } from '../user.service';
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit{
  user : User = new User();

  showModal: boolean = false;
  registerForm!: FormGroup;
  submitted = false;
  isChecked=false;
  userType='Register as an user';

  constructor(private formBuilder: FormBuilder,private userService : UserService,private activatedRoute: ActivatedRoute,private router: Router) {  }
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
    this.user.userType="User";
    this.registerForm = this.formBuilder.group({
      email: '',
      password: ''
   });
  }
  checkValue(event: any){
    console.log(event);
    this.isChecked=! this.isChecked;
    if(event=='A'){ this.userType="Register as an user";
    this.user.userType="User";
  }
    else {
    this.userType="Register as an admin";
    this.user.userType="Admin";
 }
}
  // convenience getter for easy access to form fields
  get f() { return this.registerForm.controls; }



  saveUser(){
    this.userService.createUser(this.user).subscribe(data=>{
      console.log(data);
      this.gotoUserDetails();
    })
  }
  
  gotoUserDetails(){
 // this.router.navigate(['/login'])
  }


  onSubmit() {
    
      console.log(this.user);
      this.saveUser();
      this.showModal=false;
      this.router.navigate(['/userlogin']);
    }

  

}
