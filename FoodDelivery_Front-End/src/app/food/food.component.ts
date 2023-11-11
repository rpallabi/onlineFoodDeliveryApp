import { Component,OnInit} from '@angular/core';
import { Food } from '../food';
import { FoodService } from '../food.service';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from '../user';




@Component({
  selector: 'app-food',
  templateUrl: './food.component.html',
  styleUrls: ['./food.component.css']
 
})
export class FoodComponent implements OnInit{
     
 newFood: Food=new Food();
 
  file!: File;
  admin!: string | null;
  

  
      constructor(private foodService : FoodService, private router:Router,private route: ActivatedRoute){}
      
      ngOnInit():void {
        this.route.paramMap.subscribe(params => {
            this.admin = params.get('adminId');
            console.log('AdminID in FoodComponent:', this.admin);
        }); 
    }

      onChangeFileField(event: any){
       
        
        this.file=event.target.files[0]
        this.newFood.FoodImage=this.file.name;
        console.log(this.file);
      }
      
      addFood(): void {
        this.foodService.saveFood(this.newFood, this.file).subscribe(
          (savedFood: Food) => {
           
            console.log('Saved Food:', savedFood);
            alert("Success")
            this.router.navigate(['/adminlogin']);
          },
          (error) => {
          
            console.error('Error saving food:', error);
            alert("error")
          }
        );
      }
      


     
}  

