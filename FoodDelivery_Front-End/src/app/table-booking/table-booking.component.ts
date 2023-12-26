import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router'
import { TableBooking } from '../table-booking';
import { TableBookingService } from '../table-booking.service';
import { User } from '../user';
@Component({
  selector: 'app-table-booking',
  templateUrl: './table-booking.component.html',
  styleUrls: ['./table-booking.component.css']
})
export class TableBookingComponent implements OnInit{

  tableBooking : TableBooking = new TableBooking();
  
  userIdString!: string | null;
  paidAmount: number | undefined;
  userId!: number;
  user!: number;
  //user: User = new User;
  //numberOfSeats: any;
  //remainingSeats:any;
  
 
  constructor(private tableBookingService : TableBookingService, private router:Router,private route: ActivatedRoute){

  }
  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      /*
      this.userIdString = params.get('userId');
     console.log("This is Table Booking page");
      
      console.log('AdminID in FoodComponent:', this.userIdString);
     console.log('userIdString type:', typeof this.userIdString);

   */
     this.userIdString = params.get('userId');
    
     // Convert userIdString to an integer
     this.userId = parseInt(this.userIdString || '0');
 
     console.log("This is Table Booking page");
     console.log('User ID in Table Booking Component:', this.userId);
     console.log('userId type:', typeof this.userId);
    
  }); 
  }
  
  


  errorMsg=""
  values: any=0;
  totalSeats = 60;
  onKeyUp(event: any) {
    this.values = event.target.value;
    this.errorMsg=""
  };
  /*
  bookTable(): void {
    console.log("Table booking Submitted");
    if(this.values>this.totalSeats){
      this.errorMsg="Sorry not enough seat available !!"
    }
    else if(this.values<=0){
      this.errorMsg="Minimum seat shoul be 1 !!"
    }
    else {
      this.totalSeats=this.totalSeats-this.values;
      //this.values=0;
      this.values=this.values;
      this.paidAmount=this.values*100;
      //console.log(this.tableBooking);
      
      this.tableBooking.numberOfSeats = this.values;
      this.tableBooking.remainingSeats = this.totalSeats;
      this.tableBooking.paidAmount = this.paidAmount;

      this.tableBooking.user = this.userId;
      //this.tableBooking.user = this.user;
      console.log(this.tableBooking);
     this.createBooking();
    }
    
  }


  createBooking(): void {
    this.tableBookingService.AddBooking(this.tableBooking).subscribe(
      (data) => {
       
        console.log('Saved Food:', data);
        //alert("Success")
        this.router.navigate(['/Payment']);
      },
      (error) => {
      
        console.error('Error saving food:', error);
        alert("error")
      }
    );
    
}

*/

}