import { Component, OnInit } from '@angular/core';
import {CustomerService} from "../../service/customer.service";
import {Customer} from "../../dto/Customer";
import {ToastrService} from "ngx-toastr";
import {GlobalErrorHandler} from "../../exception/GlobalErrorHandler";




@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.scss']
})
export class CustomerComponent implements OnInit {

  // this variable for hold customer data from customer form (two way baingding)
  customer: Customer = new Customer();
  customerList: Array<any>=new Array<any>();

  constructor(private customerService:CustomerService,private message: GlobalErrorHandler) {

  }

  ngOnInit(): void {
    this.getAllCustomer();
  }

  addCustomer() {
    this.customerService.addCustomer(this.customer).subscribe({
      next(position) {
        console.log('Current Position: ', position);
      },
      error(msg) {
        console.log('Error Getting Location: ', msg);
      }
    });

  }
  getAllCustomer() {
    this.customerService.getAllCustomer().subscribe(obj=> {
      this.customerList = obj;
      this.message.systemMessages("load data","load","success",7000);
    });
  }
  editCustomer(obj: Customer) {
    this.customer=obj;
  }

  deleteCustomer(customerId: string) {
    this.customerService.deleteCustomer(customerId);
  }
}
