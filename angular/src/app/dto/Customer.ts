import {IsEmpty, IsNumber, IsString, MaxLength} from "class-validator";

export class Customer{
    @IsNumber()
    customerId:number|undefined;
    @IsString()
    @IsEmpty()
    @MaxLength(10, {
      message: 'Title is too long. Maximal length is $constraint1 characters, but actual is $value',
    })
    firstName:string|undefined;
    @IsString()
    lastName:string|undefined;
    @IsString()
    address:string|undefined;
    @IsString()
    email:string|undefined;
    @IsNumber()
    mobile:number|undefined;
    @IsString()
    userName:string|undefined;
    @IsString()
    password:string|undefined;


}
