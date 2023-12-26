import { Component, ElementRef, ViewChild ,OnInit} from '@angular/core';
import { Food } from '../food';
import { FoodService } from '../food.service';

import { ActivatedRoute, Router } from '@angular/router';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  
  userId!: string | null;
  foods: Food[] = [];
  isLoggedIn:string='';
  @ViewChild('widgetsContent', { read: ElementRef })
  public widgetsContent!: ElementRef<any>;
  @ViewChild('foodContent', { read: ElementRef })
  public foodContent!: ElementRef<any>;
  isLogin!: boolean;
  
  
  //route: any;
  /*
  public scrollRight(): void {
    this.widgetsContent.nativeElement.scrollTo({ left: (this.widgetsContent.nativeElement.scrollLeft + 400), behavior: 'smooth' });
  }
  public scrollLeft(): void {
    this.widgetsContent.nativeElement.scrollTo({ left: (this.widgetsContent.nativeElement.scrollLeft - 400), behavior: 'smooth' });
  }
  public scrollRightFood(): void {
    this.foodContent.nativeElement.scrollTo({ left: (this.foodContent.nativeElement.scrollLeft + 700), behavior: 'smooth' });
  }

  public scrollLeftFood(): void {
    this.foodContent.nativeElement.scrollTo({ left: (this.foodContent.nativeElement.scrollLeft - 700), behavior: 'smooth' });
  }
*/
  constructor(private foodService : FoodService,private router: Router, private route: ActivatedRoute){
   // this.route.paramMap.subscribe(params => {
     // this.userId = params.get('userId');
      //console.log('UserId in home:', this.userId);
  //});
  this.userId=localStorage.getItem('userId');
  }
  ngOnInit(): void {
    //this.getFoods(); 
    //if(this.userId) this.isLoggedIn='Logout';
    //else this.isLoggedIn='Login'
    if (localStorage.getItem('userId')) this.isLogin = true;
    else this.isLogin = false;
  }
 // getFoods() {
   // this.foodService.getFoodList().subscribe(data =>{
     // this.foods=data;
      
    //});
  //}
  /*
  loginLogout(){
    console.log(this.userId);
    
    if(this.userId){
      alert("Logging out")
      this.isLoggedIn="Login";
      localStorage.removeItem('userId');
      this.router.navigate(['/']);
    }
    else {
      this.router.navigate(['/userlogin']);
    }
  }*/

  loginLogout() {
    console.log(this.userId);

    if (localStorage.getItem('userId')) {
      alert("Logging out")
      localStorage.removeItem('userId');
      localStorage.clear();
      this.router.navigate(['/']);
      window.location.reload();
    }
    else {
      this.router.navigate(['/userlogin']);
      
    }
  }
}
