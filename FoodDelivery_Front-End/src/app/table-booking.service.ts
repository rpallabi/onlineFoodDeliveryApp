import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { TableBooking } from './table-booking';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TableBookingService {

  constructor(private httpClient: HttpClient) { }

  private TableBookingURL = "http://localhost:8080/createBooking";
   
  
  AddBooking(tableBooking: TableBooking): Observable<Object>{
    return this.httpClient.post(`${this.TableBookingURL}`,tableBooking);
  }
}
