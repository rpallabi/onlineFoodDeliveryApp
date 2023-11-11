import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Food } from './food';
import { Observable, catchError, throwError } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class FoodService {
  /*
  [x: string]: any;
  


  private saveFoodURL = "http://localhost:8080/saveFood";
  
  private FoodListURL = "http://localhost:8080/getAllFoods";
  constructor(private httpClient: HttpClient) { }

  saveFood(food: Food, image: File): Observable<Food>{
    console.log('Trying to save food:', food);
    const formData: FormData = new FormData();
    formData.append('food', JSON.stringify(food));
    formData.append('image', image);
    return this.httpClient.post<Food>(`${this.saveFoodURL}`,formData)
    .pipe(
      catchError(error => {
        console.error('Error saving food:', error);
        return throwError(error);
      })
    );
  }

  getFoodList():Observable<Food[]> {
    return this.httpClient.get<Food[]>(`${this.FoodListURL}`)
    .pipe(
      catchError(this.handleError)
    );
  }

  private handleError(error: any) {
    console.error('An error occurred', error);
    return throwError(error);
  }
  
*/
private saveFoodURL = "http://localhost:8080/saveFood";
  
  
 constructor(private httpClient: HttpClient){}
 /*
 SaveFood(newFood:Food,file:any){
  console.log("API Call Service :"+ newFood);
  let formData=new FormData();
  formData.append('image',file)
  //formData.append('food',new Blob([JSON.stringify(newFood)], { type: 'application/json' }))
return this.httpClient.post(`${this.saveFoodURL}`,formData);
 }
 */
 
 saveFood(food: Food, image: File): Observable<Food> {
  const formData: FormData = new FormData();
  formData.append('foodname', food.foodname);
  formData.append('type', food.type);
  formData.append('description', food.description);
  formData.append('price', food.price.toString());
  formData.append('quantity', food.quantity.toString());
  formData.append('image', image);
   return this.httpClient.post<Food>(`${this.saveFoodURL}`, formData);
}
}


