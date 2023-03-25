import { Pipe, PipeTransform } from '@angular/core';
import { Customer } from '../model/customer';

@Pipe({
  name: 'dobPipe'
})
export class DobPipePipe implements PipeTransform {

  customer!:Customer;
  date!:number;
  month!:number;
  year!:number;
  transform(customer: Customer, ...args: unknown[]): string {

    this.date = customer.dob.getDate();
    this.month = customer.dob.getMonth();
    this.year = customer.dob.getFullYear();
    return this.date+"-"+this.month+"-"+this.year;
  }

}
