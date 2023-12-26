import { DatePipe } from "@angular/common";
import { User } from "./user";

export class TableBooking {
  bookingId!: number;
 numberOfSeats!: number;
  remainingSeats!: number;
  bookingDate!: Date;
  paidAmount!: number;
  user: User= new User();
  //user!: number;
  //user!: Object;

  
}
