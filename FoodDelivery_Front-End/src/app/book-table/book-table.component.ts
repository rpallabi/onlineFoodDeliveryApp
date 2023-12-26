import { Component,OnInit } from '@angular/core';
import { TableBooking } from '../table-booking';
import { TableBookingService } from '../table-booking.service';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from '../user';
import { UserService } from '../user.service';

@Component({
  selector: 'app-book-table',
  templateUrl: './book-table.component.html',
  styleUrls: ['./book-table.component.css']
})
export class BookTableComponent implements OnInit{
  tableBooking : TableBooking = new TableBooking();
  
  userIdString!: string | null;
  paidAmount: number | undefined;
  userId!: number;
  

  id : any;
  ID!: number;
  
  // Assuming you have a User object representing the logged-in user
  currentUser!: User;

  constructor(private userService : UserService,private tableBookingService : TableBookingService, private router:Router,private route: ActivatedRoute){

  }

 

  ngOnInit():void {
    console.log("Inside Booking");
    
    this.id = localStorage.getItem('userId');
    this.ID=parseInt(this.id, 10);

    
    if (this.ID) {
      console.log('UserID of booking Person:', typeof this.ID);
  
    } else {
      
      console.log('UserID not found in the session');
    }
  }

  
  errorMsg=""
  values: any=0;
  totalSeats = 60;
  onKeyUp(event: any) {
    this.values = event.target.value;
    this.errorMsg=""
  };
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
console.log(this.tableBooking);

      this.tableBooking.user.id = this.ID;

        //this.tableBooking.user = this.user;
      console.log(this.tableBooking);
     this.createBooking();
    }
    
  }


  createBooking(): void {
    this.tableBookingService.AddBooking(this.tableBooking).subscribe(
      (data) => {
       
        console.log('Book Table:', data);
        //alert("Success")
        this.router.navigate(['/Payment']);
      },
      (error) => {
      
        console.error('Error:', error);
        alert("error")
      }
    );

  }


}