import { Pipe, PipeTransform } from '@angular/core';
import { Customer } from '../model/customer';

@Pipe({
  name: 'agePipe'
})
export class AgePipePipe implements PipeTransform {

  customer!:Customer;
  current_year:number=(new Date()).getFullYear();
  customer_birth_year!:number;
  transform(customer:Customer , ...args: unknown[]): number {
    this.customer_birth_year = customer.dob.getFullYear();



    return this.current_year- this.customer_birth_year;

  }

}
