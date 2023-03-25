import { Pipe, PipeTransform } from '@angular/core';
import { Customer } from '../model/customer';

@Pipe({
  name: 'namePipe'
})
export class NamePipePipe implements PipeTransform {

  customer!:Customer;
  transform(customer:Customer):string{
    
    return customer.gender=="Male"?"Mr."+customer.name:"Ms."+customer.name;
    
  }
}
