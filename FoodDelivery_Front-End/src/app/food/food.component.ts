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
  /*   
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
      

*/



showModal: boolean = false;
  submitted = false;
  newFood: Food = new Food();

  file!: File;
  //adminId!: number;
  isLoggedIn:string='';
  isLogin!: boolean;
  id: any;
  ID!: number;


  constructor(private foodService : FoodService,private router: Router, private route: ActivatedRoute) {
   // this.admin=localStorage.getItem('admin');
   }

  ngOnInit(): void {
    this.show();
    //this.route.paramMap.subscribe(params => {
      //this.admin = params.get('adminId');
      //console.log('AdminID in FoodComponent:', this.admin);
    //});

    //if (localStorage.getItem('admin')) this.isLogin = true;
    //else this.isLogin = false;

    console.log("Inside Food Upload");
    
    this.id = localStorage.getItem('adminId');
    this.ID=parseInt(this.id, 10);

    
    if (this.ID) {
      console.log('Admin Id is:',this.ID);
      
      console.log('AdminID of  Person:', typeof this.ID);
  
    } else {
      
      console.log('AdminID not found in the session');
    }
  }
  show() {
    this.showModal = true; // Show-Hide Modal Check
  }
  hide() {
    this.showModal = false;
    this.router.navigate(['/']);
    console.log("Window hidden");

  }
  onChangeFileField(event: any) {

    this.file = event.target.files[0]
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

   /*
  loginLogout() {
    console.log(this.admin);

    if (localStorage.getItem('admin')) {
      alert("Logging out")
      localStorage.removeItem('admin');
      localStorage.clear();
      this.router.navigate(['/']);
      window.location.reload();
    }
    else {
      this.router.navigate(['/adminlogin']);
      
    }
  }
*/
}  
