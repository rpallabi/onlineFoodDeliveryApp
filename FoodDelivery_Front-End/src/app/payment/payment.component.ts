import { Component } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent {
  showModal: boolean = false;

  constructor(private formBuilder: FormBuilder, private activatedRoute: ActivatedRoute, private router: Router) { }
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
}
