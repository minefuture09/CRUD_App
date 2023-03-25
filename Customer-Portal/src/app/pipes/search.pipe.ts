import { Pipe, PipeTransform } from '@angular/core';
import { Customer } from '../model/customer';

@Pipe({
  name: 'search'
})
export class SearchPipe implements PipeTransform {

  transform(Customer: Customer[], searchValue:String ): any[] {
    if(!Customer || !searchValue){
      return Customer;
    }
    else{return Customer.filter(customer=>{

      return customer.name.toLocaleLowerCase().includes(searchValue.toLocaleLowerCase())
      
    });
  }
  }

}
