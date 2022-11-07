import { Injectable } from '@angular/core';
import {HttpClient, HttpErrorResponse} from "@angular/common/http";
import {Customer} from "../dto/Customer";
import {catchError, Observable, throwError} from "rxjs";
import {GlobalErrorHandler} from "../exception/GlobalErrorHandler";

@Injectable({
  providedIn: 'root'
})
export class CustomerService {



  constructor(private http:HttpClient,private errors: GlobalErrorHandler) {
  }

  errorHandler(error: { message: any; }) {
    return throwError(error.message);
  }

  addCustomer(customerDto:Customer):Observable<Customer>{
    return this.http.post<Customer>('http://localhost:8080/api/addCustomer',customerDto).pipe(catchError(this.errorHandler));
  }

  getAllCustomer():Observable<Array<Customer>> {
    return this.http.get<Array<Customer>>('http://localhost:8080/api/getAllCustomer').pipe(catchError(this.errorHandler));
  }

  deleteCustomer(customerId: string):Observable<any> {
    return this.http.get<any>('http://localhost:8080/api/deleteCustomer/'+customerId).pipe(catchError(this.errorHandler));
  }
}
