import { DatePipe } from "@angular/common";

export class TableBooking {
     bookingId!: number;
     numberOfSeats!: number;
    remainingSeats!: number;
    bookingDate!: DatePipe;
    paidAmount!: number;
}
