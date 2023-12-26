import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';
@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent {
  showModal: boolean = false;

  constructor(private formBuilder: FormBuilder,private activatedRoute: ActivatedRoute,private router: Router) {  }
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
  }
  removeProduct(){
    console.log("Product removed");
    
  }  
}
