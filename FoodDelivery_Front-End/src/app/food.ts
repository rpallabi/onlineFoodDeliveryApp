import { User } from "./user";

export class Food {


    fid!: number;
  foodname!: string;
  type!: string;
  description!: string;
  price!: number;
  quantity!: number;
  FoodImage!: string;
  adminId!: number ;
  admin: User=new User();
  //orderItems!: any[];


}
