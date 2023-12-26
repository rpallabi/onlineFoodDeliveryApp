import { Component,OnInit } from '@angular/core';
import { FoodService } from '../food.service';
import { Food } from '../food';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {
  menu: Food[] = [];

  constructor(private foodService : FoodService){}
  ngOnInit(): void {
    this.getFoods(); 
  }
  getFoods() {
    this.foodService.getFoodList().subscribe(data =>{
      this.menu=data;
      console.log(this.menu);
      
    });
  }
  /*
  menu:any=[
    { "fid": 503, "foodname": "Chicken Leg Piece", "type": "starter", "description": "Juicy chicken lollipop", "price": 150, "quantity": 20, "foodImage": "lollipop.jpg" },
    { "fid": 504, "foodname": "Momo", "type": "veg", "description": "Veg Momo", "price": 35, "quantity": 20, "foodImage": "momo.jpg" },
    { "fid": 505, "foodname": "Momo", "type": "NonVeg", "description": "Chicken Momo", "price": 50, "quantity": 20, "foodImage": "chickenmomo.jpg" },
    { "fid": 506, "foodname": "Burger", "type": "pnb", "description": "Double decker burger", "price": 45, "quantity": 20, "foodImage": "burger.png" },
    { "fid": 506, "foodname": "Salad", "type": "salad", "description": "Green Salad", "price": 45, "quantity": 20, "foodImage": "salad.jpg" },
    { "fid": 506, "foodname": "Mojito", "type": "drinks", "description": "Lemon Mojito", "price": 45, "quantity": 20, "foodImage": "mojito.jpg" }];
  */
    currentMenu: any = this.menu;
  
  fetchMenu(foodType: string) {
    if (foodType === 'all') {
      this.currentMenu = this.menu;
    }
    else if (foodType === 'starter') {

      this.currentMenu = this.menu.filter((food:any) => food.type.toLowerCase()==="starter");
      

    }
    else if (foodType === 'veg') {
      this.currentMenu = this.menu.filter((food:any) => food.type.toLowerCase()==="veg");
    }
    else if (foodType === 'nonVeg') {
      this.currentMenu = this.menu.filter((food:any) => food.type.toLowerCase()==="nonveg");
    }
    else if (foodType === 'pnb') {
      this.currentMenu = this.menu.filter((food:any) => food.type.toLowerCase()==="pnb");
    }
    else if (foodType === 'salad') {
      this.currentMenu = this.menu.filter((food:any) => food.type.toLowerCase()==="salad");
    }
    else {
      this.currentMenu = this.menu.filter((food:any) => food.type.toLowerCase()==="drinks");
    }
  }
}